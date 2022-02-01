package com.tencent.qphone.base.remote;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

class IBaseService$Stub$Proxy
  implements IBaseService
{
  private IBinder mRemote;
  
  IBaseService$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.tencent.qphone.base.remote.IBaseService";
  }
  
  public int getMsfConnectedIPFamily()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IBaseService");
      this.mRemote.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int getMsfConnectedNetType()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IBaseService");
      this.mRemote.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int onKillProcess()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IBaseService");
      this.mRemote.transact(6, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int onProcessViewableChanged(boolean paramBoolean, long paramLong, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IBaseService");
        if (paramBoolean)
        {
          i = 1;
          localParcel1.writeInt(i);
          localParcel1.writeLong(paramLong);
          localParcel1.writeString(paramString);
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          i = localParcel2.readInt();
          return i;
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
  
  public FromServiceMsg sendSyncToServiceMsg(ToServiceMsg paramToServiceMsg)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IBaseService");
      if (paramToServiceMsg != null)
      {
        localParcel1.writeInt(1);
        paramToServiceMsg.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0) {
        paramToServiceMsg = (FromServiceMsg)FromServiceMsg.CREATOR.createFromParcel(localParcel2);
      } else {
        paramToServiceMsg = null;
      }
      return paramToServiceMsg;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int sendToServiceMsg(ToServiceMsg paramToServiceMsg)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IBaseService");
      if (paramToServiceMsg != null)
      {
        localParcel1.writeInt(1);
        paramToServiceMsg.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      this.mRemote.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qphone.base.remote.IBaseService.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */