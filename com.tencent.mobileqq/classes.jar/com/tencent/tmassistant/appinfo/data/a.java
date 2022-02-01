package com.tencent.tmassistant.appinfo.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator<AppDetail>
{
  public AppDetail a(Parcel paramParcel)
  {
    return new AppDetail(paramParcel);
  }
  
  public AppDetail[] a(int paramInt)
  {
    return new AppDetail[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistant.appinfo.data.a
 * JD-Core Version:    0.7.0.1
 */