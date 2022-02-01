package com.tencent.mobileqq.kandian.biz.reward.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class IRIJAidlInterface$Stub
  extends Binder
  implements IRIJAidlInterface
{
  public IRIJAidlInterface$Stub()
  {
    attachInterface(this, "com.tencent.mobileqq.kandian.biz.reward.aidl.IRIJAidlInterface");
  }
  
  public static IRIJAidlInterface a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.kandian.biz.reward.aidl.IRIJAidlInterface");
    if ((localIInterface != null) && ((localIInterface instanceof IRIJAidlInterface))) {
      return (IRIJAidlInterface)localIInterface;
    }
    return new IRIJAidlInterface.Stub.Proxy(paramIBinder);
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
      paramParcel2.writeString("com.tencent.mobileqq.kandian.biz.reward.aidl.IRIJAidlInterface");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.kandian.biz.reward.aidl.IRIJAidlInterface");
    paramParcel1 = a();
    paramParcel2.writeNoException();
    if (paramParcel1 != null) {
      paramParcel1 = paramParcel1.asBinder();
    } else {
      paramParcel1 = null;
    }
    paramParcel2.writeStrongBinder(paramParcel1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.aidl.IRIJAidlInterface.Stub
 * JD-Core Version:    0.7.0.1
 */