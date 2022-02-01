package com.tencent.qqmini.sdk.launcher.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class IMiniServiceManager$Stub
  extends Binder
  implements IMiniServiceManager
{
  private static final String DESCRIPTOR = "com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager";
  static final int TRANSACTION_addService = 3;
  static final int TRANSACTION_checkService = 2;
  static final int TRANSACTION_getService = 1;
  
  public IMiniServiceManager$Stub()
  {
    attachInterface(this, "com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager");
  }
  
  public static IMiniServiceManager asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager");
    if ((localIInterface != null) && ((localIInterface instanceof IMiniServiceManager))) {
      return (IMiniServiceManager)localIInterface;
    }
    return new IMiniServiceManager.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager");
      paramParcel1 = getService(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager");
      paramParcel1 = checkService(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager");
    addService(paramParcel1.readString(), paramParcel1.readStrongBinder());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager.Stub
 * JD-Core Version:    0.7.0.1
 */