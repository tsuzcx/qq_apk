package com.tencent.qqmini.sdk.launcher.ipc;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

class MiniCmdCallback$Stub$Proxy
  implements MiniCmdCallback
{
  private IBinder mRemote;
  
  MiniCmdCallback$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback";
  }
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback");
        if (paramBoolean)
        {
          i = 1;
          localParcel1.writeInt(i);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          else
          {
            localParcel1.writeInt(0);
          }
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
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */