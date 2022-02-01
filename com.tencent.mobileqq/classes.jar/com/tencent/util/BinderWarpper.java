package com.tencent.util;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BinderWarpper
  implements Parcelable
{
  public static final Parcelable.Creator<BinderWarpper> CREATOR = new BinderWarpper.1();
  public IBinder a;
  
  public BinderWarpper(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStrongBinder(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.util.BinderWarpper
 * JD-Core Version:    0.7.0.1
 */