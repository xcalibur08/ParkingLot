package com.package.parkinglot

import java.util.*;


        public class ParkingLot {
            int MAX_SIZE=0;
            private class Car {
                String regNo;
                String color;
                public Car(String regNo, String color) {
                    this.color = color;
                    this.regNo = regNo;
                }
            }

            //The available slots in the parking lot
            ArrayList<integer> availableParkingSlotList;
            //Map of Slot and Car
            Map<String, Car> map1;
            //Map of Regno and Slot
            Map<String, String> map2;
            //Map of Color and list of Regno
            Map<String, ArrayList<String>> map3;


            //Creating a ParkingLot
            public createParkingLot(string lotCount){
                try{
                    this.MAX_SIZE = Integer.parseInt(lotCount);
                }catch (Exception e) {
                    System.out.println("Invalid Lot Count");
                    System.out.println();
                }
                this.availableParkingSlotList = new ArrayList<Integer>() {};
                for (int i = 1; i <= this.MAX_SIZE; i++) {
                    availableParkingSlotList.add(i);
                }
                this.map1 = new HashMap<String, Car>();
                this.map2 = new HashMap<String, String>();
                this.map3 = new HashMap<String, ArrayList<String>>();
                System.out.println("Created a parking lot with" + lotCount + "Slots");
                System.out.println();
            }

            //Cars who have parked and their Regno
            public void park(String regNo, String color){
                if (this.MAX_SIZE == 0) {
                    System.out.println("Parking lot has not been created");
                    System.out.println();
                }else if (this.map1 = this.MAX_SIZE) {
                    System.out.println("The parking lot is full");
                    System.out.println();
                }else {
                    //Sorting all the available slots in their ascending order of sequence
                    collections.sort(availableParkingSlotList);
                    String slot = availableParkingSlotList.get(0).toString();
                    Car car = new Car(regNo, color);
                    this.map1.put(slot, car);
                    this.map2.put(regNo, slot);
                    //Checking the cars of similar colors
                    if (this.map3.containsKey(color)) {
                        ArrayList<String> regNoList = this.map3.get(color);
                        this.map3.remove(color);
                        regNoList.add(regNo);
                        this.map3.put(color, regNoList);
                    }else {
                        ArrayList<String> regNoList = new ArrayList<String>();
                        regNoList.add(regNo);
                        this.map3.put(color, regNoList);
                    }
                    System.out.println("Allocated Slot Number: " + slot);
                    System.out.println();
                    availableParkingSlotList.remove(0);
                }
            }
            public void leave(String slotNo) {
                if (this.MAX_SIZE == 0) {
                    System.out.println("Parking lot not created");
                    System.out.println();
                    //Checking the used slots and removing them from the map
                } else if(this.map1.size() > 0) {
                    Car carToLeave = this.map1.get(slotNo);
                    if (carToLeave != null) {
                        this.map1.remove(slotNo);
                        this.map2.remove(carToLeave.regNo);
                        //Checking if a Car has left with respect to the RegNo and color and if not found remove
                        ArrayList<String> regNoList = this.map3.get(carToLeave.color);
                        if (regNoList.contains(carToLeave.regNo)) {
                            regNoList.remove(carToLeave.regNo)
                        }
                        //Now add the Lot Number back to the available list since car had left and show the current available slots in the lot
                        this.availableParkingSlotList.add(Integer.parseInt(slotNo));
                        System.out.println("The slot number: " + slotNo + "is empty");
                        System.out.println();
                    } else {
                        System.out.println("The slot number " + slotNo + "is already empty");
                        System.out.println();
                    }
                } else {
                    System.out.println("The Parking Lot is empty");
                    System.out.println();
                }
            }

            public void status() {
                if(this.MAX_SIZE == 0) {
                    System.out.println("The parking lot is not created");
                    System.out.println();
                } else if (this.map1.size() > 0) {
                    //Print the current status of the cars.
                    System.out.println("Slot NO.\tRegistration No.\tColor");
                    Car car;
                    for(int i=1; i <= this.MAX_SIZE; i++) {
                        String key = Integer.toString(i);
                        if(this.map1.containsKey(key)) {
                            car = this.map1.get(key);
                            System.out.println(i + "\t" + car.regNo + "\t" + car.color);
                        }
                    }
                    System.out.println();
                } else {
                    System.out.println("Parking lot is empty");
                    System.out.println();
                }
            }

            public void getSlotNumbersFromColors(String color) {
                if(this.MAX_SIZE == 0) {
                    Systme.out.println("The parking lot is not created");
                    System.out.println();
                } else if (this.map3.containsKey(color)) {
                    ArrayList<String> regNoList = this.map3.get(color);
                    ArrayList<Integer> slotList = new ArrayList<Integer>();
                    System.out.println();
                    for (int 1=0; i < regNoList.size(); i++) {
                        slotList.add(Integer.valueOf(this.map2.get(regNoList.get(i))));
                    }
                    collections.sort(slotList);
                    for(int j=0; j < slotList.size(); j++) {
                        if (!(j == slotList.size() - 1)) {
                            System.out.println(slotList.get(j) + ",");
                        } else {
                            System.out.println(slotList.get(j));
                        }
                    }
                    System.out.println();
                } else {
                    System.out.println("Not Found");
                    System.out.println();
                }
            }

            public void getSlotNumberFromRegNo(String regNo) {
                if(this.MAX_SIZE == 0) {
                    System.out.println("The parking lot is not created");
                    System.out.println();
                } else if (this.map2.containsKey(regNo)) {
                    System.out.println(this.map2.get(regNo));
                } else {
                    System.out.println("Not Found");
                    System.out.println();
                }
            }
        }