package com.tencent.mobileqq.nearby.ipc;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable.Creator;

class MainProcessInterface$Stub$Proxy
  implements MainProcessInterface
{
  private IBinder a;
  
  MainProcessInterface$Stub$Proxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public Message a(Message paramMessage)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.nearby.ipc.MainProcessInterface");
      if (paramMessage != null)
      {
        localParcel1.writeInt(1);
        paramMessage.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      this.a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0) {
        paramMessage = (Message)Message.CREATOR.createFromParcel(localParcel2);
      } else {
        paramMessage = null;
      }
      return paramMessage;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public BasicTypeDataParcel a(BasicTypeDataParcel paramBasicTypeDataParcel)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.nearby.ipc.MainProcessInterface");
      if (paramBasicTypeDataParcel != null)
      {
        localParcel1.writeInt(1);
        paramBasicTypeDataParcel.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0) {
        paramBasicTypeDataParcel = (BasicTypeDataParcel)BasicTypeDataParcel.CREATOR.createFromParcel(localParcel2);
      } else {
        paramBasicTypeDataParcel = null;
      }
      return paramBasicTypeDataParcel;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void a(NearbyProcessInterface paramNearbyProcessInterface)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mobileqq.nearby.ipc.MainProcessInterface");
        if (paramNearbyProcessInterface != null)
        {
          paramNearbyProcessInterface = paramNearbyProcessInterface.asBinder();
          localParcel1.writeStrongBinder(paramNearbyProcessInterface);
          this.a.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      paramNearbyProcessInterface = null;
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ipc.MainProcessInterface.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */