package com.tencent.mobileqq.theme;

import android.os.IBinder;
import android.os.Parcel;

class ISwitchCallback$Stub$Proxy
  implements ISwitchCallback
{
  private IBinder a;
  
  ISwitchCallback$Stub$Proxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public void beginSwitch()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.theme.ISwitchCallback");
      this.a.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void doSwitch(String paramString1, String paramString2)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.theme.ISwitchCallback");
      localParcel.writeString(paramString1);
      localParcel.writeString(paramString2);
      this.a.transact(3, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void onProgress(long paramLong1, long paramLong2)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.theme.ISwitchCallback");
      localParcel.writeLong(paramLong1);
      localParcel.writeLong(paramLong2);
      this.a.transact(2, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void postSwitch(int paramInt)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mobileqq.theme.ISwitchCallback");
      localParcel.writeInt(paramInt);
      this.a.transact(4, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ISwitchCallback.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */