package com.tencent.mobileqq.vas.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class ISwitchCallback$Stub
  extends Binder
  implements ISwitchCallback
{
  private static final String DESCRIPTOR = "com.tencent.mobileqq.vas.aidl.ISwitchCallback";
  static final int TRANSACTION_beginSwitch = 1;
  static final int TRANSACTION_doSwitch = 3;
  static final int TRANSACTION_onProgress = 2;
  static final int TRANSACTION_postSwitch = 4;
  
  public ISwitchCallback$Stub()
  {
    attachInterface(this, "com.tencent.mobileqq.vas.aidl.ISwitchCallback");
  }
  
  public static ISwitchCallback asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.vas.aidl.ISwitchCallback");
    if ((localIInterface != null) && ((localIInterface instanceof ISwitchCallback))) {
      return (ISwitchCallback)localIInterface;
    }
    return new ISwitchCallback.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 4)
          {
            if (paramInt1 != 1598968902) {
              return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
            }
            paramParcel2.writeString("com.tencent.mobileqq.vas.aidl.ISwitchCallback");
            return true;
          }
          paramParcel1.enforceInterface("com.tencent.mobileqq.vas.aidl.ISwitchCallback");
          postSwitch(paramParcel1.readInt());
          return true;
        }
        paramParcel1.enforceInterface("com.tencent.mobileqq.vas.aidl.ISwitchCallback");
        doSwitch(paramParcel1.readString(), paramParcel1.readString());
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.vas.aidl.ISwitchCallback");
      onProgress(paramParcel1.readLong(), paramParcel1.readLong());
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.vas.aidl.ISwitchCallback");
    beginSwitch();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.aidl.ISwitchCallback.Stub
 * JD-Core Version:    0.7.0.1
 */