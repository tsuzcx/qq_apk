package com.tencent.mobileqq.service.friendlist.remote;

import android.os.Parcel;

public class FriendGroupInfo
{
  public String a;
  public String b;
  public int c;
  public int d;
  public int e;
  
  public void a(Parcel paramParcel)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
  }
  
  public void b(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.friendlist.remote.FriendGroupInfo
 * JD-Core Version:    0.7.0.1
 */