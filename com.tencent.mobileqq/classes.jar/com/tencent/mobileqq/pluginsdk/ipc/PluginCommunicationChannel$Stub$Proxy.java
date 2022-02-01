package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

class PluginCommunicationChannel$Stub$Proxy
  implements PluginCommunicationChannel
{
  private IBinder mRemote;
  
  PluginCommunicationChannel$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel";
  }
  
  public String getNickName()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
      this.mRemote.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public String getSKey()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
      this.mRemote.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public String getSid()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
      this.mRemote.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public long getUin()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      long l = localParcel2.readLong();
      return l;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public Bundle transfer(String paramString, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
      localParcel1.writeString(paramString);
      if (paramBundle != null)
      {
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      this.mRemote.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0) {
        paramString = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
      } else {
        paramString = null;
      }
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void transferAsync(String paramString, Bundle paramBundle, RemoteCallback paramRemoteCallback)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
        localParcel1.writeString(paramString);
        if (paramBundle != null)
        {
          localParcel1.writeInt(1);
          paramBundle.writeToParcel(localParcel1, 0);
        }
        else
        {
          localParcel1.writeInt(0);
        }
        if (paramRemoteCallback != null)
        {
          paramString = paramRemoteCallback.asBinder();
          localParcel1.writeStrongBinder(paramString);
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */