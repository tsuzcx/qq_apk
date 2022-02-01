package com.tencent.mobileqq.troop.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bffi;

public class InviteToGroupInfo$UinInfo
  implements Parcelable
{
  public static final Parcelable.Creator<UinInfo> CREATOR = new bffi();
  public String a;
  public String b;
  public String c;
  
  public InviteToGroupInfo$UinInfo() {}
  
  public InviteToGroupInfo$UinInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "UinInfo{uin=" + this.a + ", groupCode=" + this.b + ", confCode=" + this.c + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.InviteToGroupInfo.UinInfo
 * JD-Core Version:    0.7.0.1
 */