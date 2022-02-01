package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class RemoteCallback$Stub
  extends Binder
  implements RemoteCallback
{
  private static final String DESCRIPTOR = "com.tencent.mobileqq.pluginsdk.ipc.RemoteCallback";
  static final int TRANSACTION_onRemoteCallback = 1;
  
  public RemoteCallback$Stub()
  {
    attachInterface(this, "com.tencent.mobileqq.pluginsdk.ipc.RemoteCallback");
  }
  
  public static RemoteCallback asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.pluginsdk.ipc.RemoteCallback");
    if ((localIInterface != null) && ((localIInterface instanceof RemoteCallback))) {
      return (RemoteCallback)localIInterface;
    }
    return new RemoteCallback.Stub.Proxy(paramIBinder);
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
      paramParcel2.writeString("com.tencent.mobileqq.pluginsdk.ipc.RemoteCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.ipc.RemoteCallback");
    if (paramParcel1.readInt() != 0) {
      paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
    } else {
      paramParcel1 = null;
    }
    onRemoteCallback(paramParcel1);
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.RemoteCallback.Stub
 * JD-Core Version:    0.7.0.1
 */