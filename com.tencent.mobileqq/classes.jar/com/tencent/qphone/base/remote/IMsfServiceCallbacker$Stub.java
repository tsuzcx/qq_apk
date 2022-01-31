package com.tencent.qphone.base.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IMsfServiceCallbacker$Stub
  extends Binder
  implements IMsfServiceCallbacker
{
  private static final String DESCRIPTOR = "com.tencent.qphone.base.remote.IMsfServiceCallbacker";
  static final int TRANSACTION_onRecvPushResp = 2;
  static final int TRANSACTION_onResponse = 1;
  
  public IMsfServiceCallbacker$Stub()
  {
    attachInterface(this, "com.tencent.qphone.base.remote.IMsfServiceCallbacker");
  }
  
  public static IMsfServiceCallbacker asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.qphone.base.remote.IMsfServiceCallbacker");
    if ((localIInterface != null) && ((localIInterface instanceof IMsfServiceCallbacker))) {
      return (IMsfServiceCallbacker)localIInterface;
    }
    return new IMsfServiceCallbacker.Stub.Proxy(paramIBinder);
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
      paramParcel2.writeString("com.tencent.qphone.base.remote.IMsfServiceCallbacker");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IMsfServiceCallbacker");
      ToServiceMsg localToServiceMsg;
      if (paramParcel1.readInt() != 0)
      {
        localToServiceMsg = (ToServiceMsg)ToServiceMsg.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label120;
        }
      }
      label120:
      for (paramParcel1 = (FromServiceMsg)FromServiceMsg.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        onResponse(localToServiceMsg, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localToServiceMsg = null;
        break;
      }
    }
    paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IMsfServiceCallbacker");
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (FromServiceMsg)FromServiceMsg.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      onRecvPushResp(paramParcel1);
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.IMsfServiceCallbacker.Stub
 * JD-Core Version:    0.7.0.1
 */