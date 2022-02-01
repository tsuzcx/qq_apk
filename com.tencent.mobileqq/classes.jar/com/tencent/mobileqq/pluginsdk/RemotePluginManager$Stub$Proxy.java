package com.tencent.mobileqq.pluginsdk;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

class RemotePluginManager$Stub$Proxy
  implements RemotePluginManager
{
  private IBinder mRemote;
  
  RemotePluginManager$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public void cancelInstall(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
      localParcel1.writeString(paramString);
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
  
  public String getInterfaceDescriptor()
  {
    return "com.tencent.mobileqq.pluginsdk.RemotePluginManager";
  }
  
  public void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
        localParcel1.writeString(paramString);
        if (paramOnPluginInstallListener != null)
        {
          paramString = paramOnPluginInstallListener.asBinder();
          localParcel1.writeStrongBinder(paramString);
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
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
  
  public boolean isPlugininstalled(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
      localParcel1.writeString(paramString);
      paramString = this.mRemote;
      boolean bool = false;
      paramString.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean isReady()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
      IBinder localIBinder = this.mRemote;
      boolean bool = false;
      localIBinder.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public PluginBaseInfo queryPlugin(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
      localParcel1.writeString(paramString);
      this.mRemote.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0) {
        paramString = (PluginBaseInfo)PluginBaseInfo.CREATOR.createFromParcel(localParcel2);
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
  
  public void setListener(RemotePluginManager paramRemotePluginManager)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
        if (paramRemotePluginManager != null)
        {
          paramRemotePluginManager = paramRemotePluginManager.asBinder();
          localParcel1.writeStrongBinder(paramRemotePluginManager);
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
      paramRemotePluginManager = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.RemotePluginManager.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */