package com.vivo.vms;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

class IPCInvoke$Stub$Proxy
  implements IPCInvoke
{
  public static IPCInvoke sDefaultImpl;
  private IBinder mRemote;
  
  IPCInvoke$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public Bundle asyncCall(Bundle paramBundle, IPCCallback paramIPCCallback)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.vivo.vms.IPCInvoke");
        if (paramBundle != null)
        {
          localParcel1.writeInt(1);
          paramBundle.writeToParcel(localParcel1, 0);
        }
        else
        {
          localParcel1.writeInt(0);
        }
        Object localObject = null;
        if (paramIPCCallback != null)
        {
          localIBinder = paramIPCCallback.asBinder();
          localParcel1.writeStrongBinder(localIBinder);
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (IPCInvoke.Stub.getDefaultImpl() != null))
          {
            paramBundle = IPCInvoke.Stub.getDefaultImpl().asyncCall(paramBundle, paramIPCCallback);
            return paramBundle;
          }
          localParcel2.readException();
          paramBundle = localObject;
          if (localParcel2.readInt() != 0) {
            paramBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
          }
          return paramBundle;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      IBinder localIBinder = null;
    }
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.vivo.vms.IPCInvoke";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.vms.IPCInvoke.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */