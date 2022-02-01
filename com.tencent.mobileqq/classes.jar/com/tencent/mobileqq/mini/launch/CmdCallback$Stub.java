package com.tencent.mobileqq.mini.launch;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class CmdCallback$Stub
  extends Binder
  implements CmdCallback
{
  private static final String DESCRIPTOR = "com.tencent.mobileqq.mini.launch.CmdCallback";
  static final int TRANSACTION_onCmdResult = 1;
  
  public CmdCallback$Stub()
  {
    attachInterface(this, "com.tencent.mobileqq.mini.launch.CmdCallback");
  }
  
  public static CmdCallback asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.mini.launch.CmdCallback");
    if ((localIInterface != null) && ((localIInterface instanceof CmdCallback))) {
      return (CmdCallback)localIInterface;
    }
    return new CmdCallback.Stub.Proxy(paramIBinder);
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
      paramParcel2.writeString("com.tencent.mobileqq.mini.launch.CmdCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.CmdCallback");
    boolean bool;
    if (paramParcel1.readInt() != 0)
    {
      bool = true;
      if (paramParcel1.readInt() == 0) {
        break label101;
      }
    }
    label101:
    for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      onCmdResult(bool, paramParcel1);
      paramParcel2.writeNoException();
      return true;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.CmdCallback.Stub
 * JD-Core Version:    0.7.0.1
 */