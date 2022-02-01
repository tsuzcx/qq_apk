package com.tencent.mobileqq.statistics;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class UEC$UECItem$1
  implements Parcelable.Creator<UEC.UECItem>
{
  public UEC.UECItem a(Parcel paramParcel)
  {
    UEC.UECItem localUECItem = new UEC.UECItem();
    localUECItem.a = paramParcel.readString();
    localUECItem.b = paramParcel.readInt();
    localUECItem.c = paramParcel.readLong();
    localUECItem.d = paramParcel.readInt();
    localUECItem.g = paramParcel.readString();
    localUECItem.h = paramParcel.readString();
    localUECItem.i = paramParcel.readString();
    localUECItem.j = paramParcel.readString();
    localUECItem.k = paramParcel.readString();
    return localUECItem;
  }
  
  public UEC.UECItem[] a(int paramInt)
  {
    return new UEC.UECItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.UEC.UECItem.1
 * JD-Core Version:    0.7.0.1
 */