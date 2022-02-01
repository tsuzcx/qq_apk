package com.tencent.mobileqq.nearby.now.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class LocalMediaInfo$1
  implements Parcelable.Creator<LocalMediaInfo>
{
  public LocalMediaInfo a(Parcel paramParcel)
  {
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo.c = paramParcel.readLong();
    localLocalMediaInfo.d = paramParcel.readString();
    localLocalMediaInfo.e = paramParcel.readLong();
    localLocalMediaInfo.f = paramParcel.readLong();
    localLocalMediaInfo.g = paramParcel.readLong();
    localLocalMediaInfo.h = paramParcel.readInt();
    localLocalMediaInfo.l = paramParcel.readInt();
    localLocalMediaInfo.i = paramParcel.readLong();
    localLocalMediaInfo.b = paramParcel.readInt();
    localLocalMediaInfo.o = paramParcel.readInt();
    localLocalMediaInfo.p = paramParcel.readInt();
    localLocalMediaInfo.q = paramParcel.readInt();
    localLocalMediaInfo.r = Integer.valueOf(paramParcel.readInt());
    localLocalMediaInfo.s = paramParcel.readString();
    localLocalMediaInfo.t = paramParcel.readString();
    localLocalMediaInfo.j = paramParcel.readInt();
    localLocalMediaInfo.k = paramParcel.readInt();
    localLocalMediaInfo.n = paramParcel.readInt();
    localLocalMediaInfo.m = paramParcel.readInt();
    return localLocalMediaInfo;
  }
  
  public LocalMediaInfo[] a(int paramInt)
  {
    return new LocalMediaInfo[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.LocalMediaInfo.1
 * JD-Core Version:    0.7.0.1
 */