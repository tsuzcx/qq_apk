package com.tencent.mobileqq.medalwall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import awuw;

public class MedalID
  implements Parcelable
{
  public static final Parcelable.Creator<MedalID> CREATOR = new awuw();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalID
 * JD-Core Version:    0.7.0.1
 */