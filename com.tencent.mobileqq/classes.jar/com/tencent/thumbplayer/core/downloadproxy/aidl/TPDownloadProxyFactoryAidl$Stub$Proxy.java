package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.IBinder;
import android.os.Parcel;

class TPDownloadProxyFactoryAidl$Stub$Proxy
  implements TPDownloadProxyFactoryAidl
{
  private IBinder mRemote;
  
  TPDownloadProxyFactoryAidl$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl";
  }
  
  public String getNativeVersion()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl");
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
  
  public ITPDownloadProxyAidl getTPDownloadProxy(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      ITPDownloadProxyAidl localITPDownloadProxyAidl = ITPDownloadProxyAidl.Stub.asInterface(localParcel2.readStrongBinder());
      return localITPDownloadProxyAidl;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean isReadyForDownload()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl");
      IBinder localIBinder = this.mRemote;
      boolean bool = false;
      localIBinder.transact(3, localParcel1, localParcel2, 0);
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
  
  public boolean isReadyForPlay()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl");
      IBinder localIBinder = this.mRemote;
      boolean bool = false;
      localIBinder.transact(2, localParcel1, localParcel2, 0);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */