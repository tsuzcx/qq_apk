package com.vivo.vms;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

class IPCCallback$Stub$Proxy
  implements IPCCallback
{
  public static IPCCallback sDefaultImpl;
  private IBinder mRemote;
  
  IPCCallback$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public void call(Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.vivo.vms.IPCCallback");
      if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (IPCCallback.Stub.getDefaultImpl() != null)) {
        IPCCallback.Stub.getDefaultImpl().call(paramBundle);
      }
      for (;;)
      {
        localParcel2.recycle();
        localParcel1.recycle();
        return;
        localParcel2.readException();
        if (localParcel2.readInt() != 0) {
          paramBundle.readFromParcel(localParcel2);
        }
      }
      throw paramBundle;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
    for (;;) {}
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.vivo.vms.IPCCallback";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.vms.IPCCallback.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */