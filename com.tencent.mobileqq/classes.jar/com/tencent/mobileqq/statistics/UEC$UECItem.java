package com.tencent.mobileqq.statistics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UEC$UECItem
  implements Parcelable
{
  public static final Parcelable.Creator<UECItem> CREATOR = new UEC.UECItem.1();
  public String a;
  public int b;
  public long c;
  public int d;
  public int e;
  public long f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.UEC.UECItem
 * JD-Core Version:    0.7.0.1
 */