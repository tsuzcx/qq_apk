package com.tencent.mobileqq.revokemsg;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class RevokeMsgInfo$1
  implements Parcelable.Creator<RevokeMsgInfo>
{
  public RevokeMsgInfo a(Parcel paramParcel)
  {
    RevokeMsgInfo localRevokeMsgInfo = new RevokeMsgInfo();
    localRevokeMsgInfo.a = paramParcel.readInt();
    localRevokeMsgInfo.b = paramParcel.readLong();
    localRevokeMsgInfo.c = paramParcel.readString();
    localRevokeMsgInfo.h = paramParcel.readString();
    localRevokeMsgInfo.f = paramParcel.readLong();
    localRevokeMsgInfo.g = paramParcel.readLong();
    localRevokeMsgInfo.l = paramParcel.readString();
    localRevokeMsgInfo.m = paramParcel.readInt();
    localRevokeMsgInfo.n = paramParcel.readInt();
    int i = paramParcel.readInt();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    localRevokeMsgInfo.o = bool;
    localRevokeMsgInfo.p = paramParcel.readInt();
    localRevokeMsgInfo.q = paramParcel.readString();
    return localRevokeMsgInfo;
  }
  
  public RevokeMsgInfo[] a(int paramInt)
  {
    return new RevokeMsgInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.revokemsg.RevokeMsgInfo.1
 * JD-Core Version:    0.7.0.1
 */