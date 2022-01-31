package com.tencent.qqpimsecure.wificore.api.recognize.monitor;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DogFood
  implements Parcelable
{
  public static final Parcelable.Creator<DogFood> CREATOR = new DogFood.1();
  public String fE = "";
  public long time = -1L;
  
  private DogFood(Parcel paramParcel)
  {
    this.fE = paramParcel.readString();
    this.time = paramParcel.readLong();
  }
  
  public DogFood(b paramb)
  {
    this.fE = paramb.fX;
    this.time = System.currentTimeMillis();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "DogFood{stage=(" + this.fE + "," + b.e(this.fE) + "), time=" + this.time + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.fE);
    paramParcel.writeLong(this.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqpimsecure.wificore.api.recognize.monitor.DogFood
 * JD-Core Version:    0.7.0.1
 */