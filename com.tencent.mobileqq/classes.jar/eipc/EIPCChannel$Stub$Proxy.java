package eipc;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

class EIPCChannel$Stub$Proxy
  implements EIPCChannel
{
  private IBinder mRemote;
  
  EIPCChannel$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public EIPCResult async(String paramString1, String paramString2, Bundle paramBundle, int paramInt1, int paramInt2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("eipc.EIPCChannel");
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
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      this.mRemote.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0) {
        paramString1 = (EIPCResult)EIPCResult.CREATOR.createFromParcel(localParcel2);
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
  
  public void callback(int paramInt, EIPCResult paramEIPCResult)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("eipc.EIPCChannel");
      localParcel1.writeInt(paramInt);
      if (paramEIPCResult != null)
      {
        localParcel1.writeInt(1);
        paramEIPCResult.writeToParcel(localParcel1, 0);
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
  
  public String getInterfaceDescriptor()
  {
    return "eipc.EIPCChannel";
  }
  
  public String getProcName()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("eipc.EIPCChannel");
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
  
  public int setClient(String paramString, int paramInt1, EIPCChannel paramEIPCChannel, int paramInt2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("eipc.EIPCChannel");
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt1);
        if (paramEIPCChannel != null)
        {
          paramString = paramEIPCChannel.asBinder();
          localParcel1.writeStrongBinder(paramString);
          localParcel1.writeInt(paramInt2);
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt1 = localParcel2.readInt();
          return paramInt1;
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
  
  public IBinder setStubBinder(int paramInt, IBinder paramIBinder)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("eipc.EIPCChannel");
      localParcel1.writeInt(paramInt);
      localParcel1.writeStrongBinder(paramIBinder);
      this.mRemote.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramIBinder = localParcel2.readStrongBinder();
      return paramIBinder;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public EIPCResult sync(String paramString1, String paramString2, Bundle paramBundle, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("eipc.EIPCChannel");
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
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0) {
        paramString1 = (EIPCResult)EIPCResult.CREATOR.createFromParcel(localParcel2);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     eipc.EIPCChannel.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */