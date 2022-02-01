package com.tencent.qqpimsecure.wificore.api.recognize.monitor;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class Dog
  implements Parcelable
{
  public static final Parcelable.Creator<Dog> CREATOR = new Dog.1();
  public int fC = -1;
  public final ArrayList<DogFood> fD = new ArrayList();
  public long id = -1L;
  
  private Dog(Parcel paramParcel)
  {
    this.id = paramParcel.readLong();
    paramParcel.readList(this.fD, DogFood.class.getClassLoader());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "Dog{id=" + this.id + ", recognizeScene=" + this.fC + ", dogFoods=" + this.fD + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.id);
    paramParcel.writeList(this.fD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqpimsecure.wificore.api.recognize.monitor.Dog
 * JD-Core Version:    0.7.0.1
 */