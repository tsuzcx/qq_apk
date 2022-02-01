package com.tencent.mobileqq.service.friendlist.remote;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FriendSingleInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FriendSingleInfo> CREATOR = new FriendSingleInfo.1();
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public int e;
  public int f;
  public byte g;
  public int h;
  public String i = "";
  
  public FriendSingleInfo() {}
  
  public FriendSingleInfo(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public void a(Parcel paramParcel)
  {
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readByte();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeByte(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeString(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.friendlist.remote.FriendSingleInfo
 * JD-Core Version:    0.7.0.1
 */