package com.tencent.shadow.dynamic.host;

import android.os.IBinder;
import android.os.Parcel;

public class PpsController
{
  private final IBinder mRemote;
  
  PpsController(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public void exit()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(PpsBinder.DESCRIPTOR);
      this.mRemote.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public IBinder getPluginLoader()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(PpsBinder.DESCRIPTOR);
      this.mRemote.transact(6, localParcel1, localParcel2, 0);
      localParcel2.readException();
      IBinder localIBinder = localParcel2.readStrongBinder();
      return localIBinder;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public PpsStatus getPpsStatus()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(PpsBinder.DESCRIPTOR);
      this.mRemote.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      PpsStatus localPpsStatus = new PpsStatus(localParcel2);
      return localPpsStatus;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void loadPluginLoader(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    int i;
    try
    {
      localParcel1.writeInterfaceToken(PpsBinder.DESCRIPTOR);
      localParcel1.writeString(paramString);
      this.mRemote.transact(2, localParcel1, localParcel2, 0);
      i = localParcel2.readInt();
      if (i == 1) {
        throw new FailedException(localParcel2);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    if (i != 0) {
      throw new RuntimeException("不认识的Code==" + i);
    }
    localParcel2.recycle();
    localParcel1.recycle();
  }
  
  public void loadRuntime(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    int i;
    try
    {
      localParcel1.writeInterfaceToken(PpsBinder.DESCRIPTOR);
      localParcel1.writeString(paramString);
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      i = localParcel2.readInt();
      if (i == 1) {
        throw new FailedException(localParcel2);
      }
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    if (i != 0) {
      throw new RuntimeException("不认识的Code==" + i);
    }
    localParcel2.recycle();
    localParcel1.recycle();
  }
  
  public void setUuidManager(IBinder paramIBinder)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(PpsBinder.DESCRIPTOR);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.PpsController
 * JD-Core Version:    0.7.0.1
 */