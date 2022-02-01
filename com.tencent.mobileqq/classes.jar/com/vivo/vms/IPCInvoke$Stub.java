package com.vivo.vms;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IPCInvoke$Stub
  extends Binder
  implements IPCInvoke
{
  private static final String DESCRIPTOR = "com.vivo.vms.IPCInvoke";
  static final int TRANSACTION_asyncCall = 1;
  
  public IPCInvoke$Stub()
  {
    attachInterface(this, "com.vivo.vms.IPCInvoke");
  }
  
  public static IPCInvoke asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.vivo.vms.IPCInvoke");
    if ((localIInterface != null) && ((localIInterface instanceof IPCInvoke))) {
      return (IPCInvoke)localIInterface;
    }
    return new IPCInvoke.Stub.Proxy(paramIBinder);
  }
  
  public static IPCInvoke getDefaultImpl()
  {
    return IPCInvoke.Stub.Proxy.sDefaultImpl;
  }
  
  public static boolean setDefaultImpl(IPCInvoke paramIPCInvoke)
  {
    if ((IPCInvoke.Stub.Proxy.sDefaultImpl == null) && (paramIPCInvoke != null))
    {
      IPCInvoke.Stub.Proxy.sDefaultImpl = paramIPCInvoke;
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
      paramParcel2.writeString("com.vivo.vms.IPCInvoke");
      return true;
    }
    paramParcel1.enforceInterface("com.vivo.vms.IPCInvoke");
    Bundle localBundle;
    if (paramParcel1.readInt() != 0) {
      localBundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
    } else {
      localBundle = null;
    }
    paramParcel1 = asyncCall(localBundle, IPCCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    if (paramParcel1 != null)
    {
      paramParcel2.writeInt(1);
      paramParcel1.writeToParcel(paramParcel2, 1);
      return true;
    }
    paramParcel2.writeInt(0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.vms.IPCInvoke.Stub
 * JD-Core Version:    0.7.0.1
 */