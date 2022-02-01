package com.tencent.qqmini.sdk.launcher.ipc;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class IAppMainService$Stub$Proxy
  implements IAppMainService
{
  private IBinder mRemote;
  
  IAppMainService$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.tencent.qqmini.sdk.launcher.ipc.IAppMainService";
  }
  
  public void onAppLifecycle(int paramInt, String paramString, MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
      localParcel1.writeInt(paramInt);
      localParcel1.writeString(paramString);
      if (paramMiniAppInfo != null)
      {
        localParcel1.writeInt(1);
        paramMiniAppInfo.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      if (paramBundle != null)
      {
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      this.mRemote.transact(6, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void preloadDownloadPackage(MiniAppInfo paramMiniAppInfo)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
      if (paramMiniAppInfo != null)
      {
        localParcel1.writeInt(1);
        paramMiniAppInfo.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      this.mRemote.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void preloadMiniApp()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public Bundle requestAync(String paramString1, String paramString2, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      if (paramBundle != null)
      {
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      this.mRemote.transact(8, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0) {
        paramString1 = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
      } else {
        paramString1 = null;
      }
      return paramString1;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void sendCmd(String paramString1, String paramString2, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        if (paramBundle != null)
        {
          localParcel1.writeInt(1);
          paramBundle.writeToParcel(localParcel1, 0);
        }
        else
        {
          localParcel1.writeInt(0);
        }
        if (paramMiniCmdCallback != null)
        {
          paramString1 = paramMiniCmdCallback.asBinder();
          localParcel1.writeStrongBinder(paramString1);
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      paramString1 = null;
    }
  }
  
  public void startMiniApp(MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
      if (paramMiniAppInfo != null)
      {
        localParcel1.writeInt(1);
        paramMiniAppInfo.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      if (paramBundle != null)
      {
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      if (paramResultReceiver != null)
      {
        localParcel1.writeInt(1);
        paramResultReceiver.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      this.mRemote.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void stopAllMiniApp()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
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
  
  public void stopMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.qqmini.sdk.launcher.ipc.IAppMainService");
      if (paramMiniAppInfo != null)
      {
        localParcel1.writeInt(1);
        paramMiniAppInfo.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ipc.IAppMainService.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */