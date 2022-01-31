package com.tencent.mobileqq.miniapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import asjf;

public class MiniAppOptions
  implements Parcelable
{
  public static final Parcelable.Creator<MiniAppOptions> CREATOR = new asjf();
  
  public MiniAppOptions() {}
  
  public MiniAppOptions(Parcel paramParcel) {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.MiniAppOptions
 * JD-Core Version:    0.7.0.1
 */