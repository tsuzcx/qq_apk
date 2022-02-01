package com.tencent.tmassistant.appinfo.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c
  implements Parcelable.Creator<AppParam>
{
  public AppParam a(Parcel paramParcel)
  {
    return new AppParam(paramParcel);
  }
  
  public AppParam[] a(int paramInt)
  {
    return new AppParam[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistant.appinfo.data.c
 * JD-Core Version:    0.7.0.1
 */