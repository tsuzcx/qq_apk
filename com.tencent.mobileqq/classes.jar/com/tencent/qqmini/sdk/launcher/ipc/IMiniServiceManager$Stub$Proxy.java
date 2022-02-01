package com.tencent.qqmini.sdk.launcher.ipc;

import android.os.IBinder;
import android.os.Parcel;

class IMiniServiceManager$Stub$Proxy
  implements IMiniServiceManager
{
  private IBinder mRemote;
  
  IMiniServiceManager$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public void addService(String paramString, IBinder paramIBinder)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager");
      localParcel1.writeString(paramString);
      localParcel1.writeStrongBinder(paramIBinder);
      this.mRemote.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public IBinder checkService(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager");
      localParcel1.writeString(paramString);
      this.mRemote.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.readStrongBinder();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager";
  }
  
  public IBinder getService(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager");
      localParcel1.writeString(paramString);
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.readStrongBinder();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */