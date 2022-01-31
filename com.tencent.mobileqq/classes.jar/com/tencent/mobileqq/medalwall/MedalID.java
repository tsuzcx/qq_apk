package com.tencent.mobileqq.medalwall;

import aefv;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MedalID
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new aefv();
  public int a;
  public int b;
  
  public MedalID(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public MedalID(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalID
 * JD-Core Version:    0.7.0.1
 */