package com.vivo.vms;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class IPCCallback$Stub
  extends Binder
  implements IPCCallback
{
  private static final String DESCRIPTOR = "com.vivo.vms.IPCCallback";
  static final int TRANSACTION_call = 1;
  
  public IPCCallback$Stub()
  {
    attachInterface(this, "com.vivo.vms.IPCCallback");
  }
  
  public static IPCCallback asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.vivo.vms.IPCCallback");
    if ((localIInterface != null) && ((localIInterface instanceof IPCCallback))) {
      return (IPCCallback)localIInterface;
    }
    return new IPCCallback.Stub.Proxy(paramIBinder);
  }
  
  public static IPCCallback getDefaultImpl()
  {
    return IPCCallback.Stub.Proxy.sDefaultImpl;
  }
  
  public static boolean setDefaultImpl(IPCCallback paramIPCCallback)
  {
    if ((IPCCallback.Stub.Proxy.sDefaultImpl == null) && (paramIPCCallback != null))
    {
      IPCCallback.Stub.Proxy.sDefaultImpl = paramIPCCallback;
      return true;
    }
    return false;
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 1598968902) {
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      paramParcel2.writeString("com.vivo.vms.IPCCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.vivo.vms.IPCCallback");
    paramParcel1 = new Bundle();
    call(paramParcel1);
    paramParcel2.writeNoException();
    paramParcel2.writeInt(1);
    paramParcel1.writeToParcel(paramParcel2, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.vms.IPCCallback.Stub
 * JD-Core Version:    0.7.0.1
 */