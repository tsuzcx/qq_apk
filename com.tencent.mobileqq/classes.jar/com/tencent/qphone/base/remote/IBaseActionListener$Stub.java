package com.tencent.qphone.base.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IBaseActionListener$Stub
  extends Binder
  implements IBaseActionListener
{
  private static final String DESCRIPTOR = "com.tencent.qphone.base.remote.IBaseActionListener";
  static final int TRANSACTION_onActionResult = 2;
  static final int TRANSACTION_onRecvFromMsg = 1;
  
  public IBaseActionListener$Stub()
  {
    attachInterface(this, "com.tencent.qphone.base.remote.IBaseActionListener");
  }
  
  public static IBaseActionListener asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.qphone.base.remote.IBaseActionListener");
    if ((localIInterface != null) && ((localIInterface instanceof IBaseActionListener))) {
      return (IBaseActionListener)localIInterface;
    }
    return new IBaseActionListener.Stub.Proxy(paramIBinder);
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
      paramParcel2.writeString("com.tencent.qphone.base.remote.IBaseActionListener");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IBaseActionListener");
      paramParcel2 = localObject1;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (FromServiceMsg)FromServiceMsg.CREATOR.createFromParcel(paramParcel1);
      }
      onRecvFromMsg(paramParcel2);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IBaseActionListener");
    paramParcel2 = localObject2;
    if (paramParcel1.readInt() != 0) {
      paramParcel2 = (FromServiceMsg)FromServiceMsg.CREATOR.createFromParcel(paramParcel1);
    }
    onActionResult(paramParcel2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.IBaseActionListener.Stub
 * JD-Core Version:    0.7.0.1
 */