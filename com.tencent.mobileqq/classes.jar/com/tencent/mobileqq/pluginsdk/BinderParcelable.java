package com.tencent.mobileqq.pluginsdk;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BinderParcelable
  implements Parcelable
{
  public static final Parcelable.Creator<BinderParcelable> CREATOR = new BinderParcelable.1();
  public IBinder mBinder;
  
  BinderParcelable(IBinder paramIBinder)
  {
    this.mBinder = paramIBinder;
  }
  
  BinderParcelable(Parcel paramParcel)
  {
    this.mBinder = paramParcel.readStrongBinder();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStrongBinder(this.mBinder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.BinderParcelable
 * JD-Core Version:    0.7.0.1
 */