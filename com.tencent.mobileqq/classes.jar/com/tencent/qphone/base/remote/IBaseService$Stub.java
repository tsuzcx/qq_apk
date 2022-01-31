package com.tencent.qphone.base.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IBaseService$Stub
  extends Binder
  implements IBaseService
{
  private static final String DESCRIPTOR = "com.tencent.qphone.base.remote.IBaseService";
  static final int TRANSACTION_getMsfConnectedIPFamily = 4;
  static final int TRANSACTION_getMsfConnectedNetType = 3;
  static final int TRANSACTION_onProcessViewableChanged = 5;
  static final int TRANSACTION_sendSyncToServiceMsg = 1;
  static final int TRANSACTION_sendToServiceMsg = 2;
  
  public IBaseService$Stub()
  {
    attachInterface(this, "com.tencent.qphone.base.remote.IBaseService");
  }
  
  public static IBaseService asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.qphone.base.remote.IBaseService");
    if ((localIInterface != null) && ((localIInterface instanceof IBaseService))) {
      return (IBaseService)localIInterface;
    }
    return new IBaseService.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.qphone.base.remote.IBaseService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IBaseService");
      if (paramParcel1.readInt() != 0) {
        localObject1 = (ToServiceMsg)ToServiceMsg.CREATOR.createFromParcel(paramParcel1);
      }
      paramParcel1 = sendSyncToServiceMsg((ToServiceMsg)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IBaseService");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (ToServiceMsg)ToServiceMsg.CREATOR.createFromParcel(paramParcel1);
      }
      paramInt1 = sendToServiceMsg((ToServiceMsg)localObject1);
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IBaseService");
      paramInt1 = getMsfConnectedNetType();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IBaseService");
      paramInt1 = getMsfConnectedIPFamily();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IBaseService");
    if (paramParcel1.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramInt1 = onProcessViewableChanged(bool, paramParcel1.readLong(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.IBaseService.Stub
 * JD-Core Version:    0.7.0.1
 */