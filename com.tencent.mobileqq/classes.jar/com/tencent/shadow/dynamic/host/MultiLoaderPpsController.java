package com.tencent.shadow.dynamic.host;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.shadow.proguard.m;

public class MultiLoaderPpsController
{
  private final IBinder a;
  
  MultiLoaderPpsController(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public void exit()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(m.a);
      this.a.transact(6, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public IBinder getPluginLoaderForPlugin(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(m.a);
      localParcel1.writeString(paramString);
      this.a.transact(5, localParcel1, localParcel2, 0);
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
  
  public PpsStatus getPpsStatusForPlugin(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(m.a);
      localParcel1.writeString(paramString);
      this.a.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = new PpsStatus(localParcel2);
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void loadPluginLoaderForPlugin(String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    int i;
    try
    {
      localParcel1.writeInterfaceToken(m.a);
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      this.a.transact(2, localParcel1, localParcel2, 0);
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
  
  public void loadRuntimeForPlugin(String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    int i;
    try
    {
      localParcel1.writeInterfaceToken(m.a);
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      this.a.transact(1, localParcel1, localParcel2, 0);
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
  
  public void setUuidManagerForPlugin(String paramString, IBinder paramIBinder)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(m.a);
      localParcel1.writeString(paramString);
      localParcel1.writeStrongBinder(paramIBinder);
      this.a.transact(3, localParcel1, localParcel2, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.MultiLoaderPpsController
 * JD-Core Version:    0.7.0.1
 */