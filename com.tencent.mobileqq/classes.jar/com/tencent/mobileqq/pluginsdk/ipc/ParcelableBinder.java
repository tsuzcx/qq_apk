package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableBinder
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new a();
  private IBinder a;
  
  public ParcelableBinder(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  private ParcelableBinder(Parcel paramParcel)
  {
    this.a = paramParcel.readStrongBinder();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public IBinder getBinder()
  {
    return this.a;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStrongBinder(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.ParcelableBinder
 * JD-Core Version:    0.7.0.1
 */