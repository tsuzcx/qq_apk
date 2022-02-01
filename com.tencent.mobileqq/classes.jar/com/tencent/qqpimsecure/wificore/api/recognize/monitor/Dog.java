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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Dog{id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", recognizeScene=");
    localStringBuilder.append(this.fC);
    localStringBuilder.append(", dogFoods=");
    localStringBuilder.append(this.fD);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.id);
    paramParcel.writeList(this.fD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqpimsecure.wificore.api.recognize.monitor.Dog
 * JD-Core Version:    0.7.0.1
 */