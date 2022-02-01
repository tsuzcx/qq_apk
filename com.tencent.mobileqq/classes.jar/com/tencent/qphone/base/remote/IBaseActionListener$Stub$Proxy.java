package com.tencent.qphone.base.remote;

import android.os.IBinder;
import android.os.Parcel;

class IBaseActionListener$Stub$Proxy
  implements IBaseActionListener
{
  private IBinder mRemote;
  
  IBaseActionListener$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.tencent.qphone.base.remote.IBaseActionListener";
  }
  
  public void onActionResult(FromServiceMsg paramFromServiceMsg)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.qphone.base.remote.IBaseActionListener");
      if (paramFromServiceMsg != null)
      {
        localParcel.writeInt(1);
        paramFromServiceMsg.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      this.mRemote.transact(2, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void onRecvFromMsg(FromServiceMsg paramFromServiceMsg)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.qphone.base.remote.IBaseActionListener");
      if (paramFromServiceMsg != null)
      {
        localParcel.writeInt(1);
        paramFromServiceMsg.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      this.mRemote.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qphone.base.remote.IBaseActionListener.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */