package com.tencent.mobileqq.pic;

import android.os.Binder;
import android.os.Parcel;

public abstract class IPreparePresendCallBack$Stub
  extends Binder
  implements IPreparePresendCallBack
{
  public IPreparePresendCallBack$Stub()
  {
    attachInterface(this, "com.tencent.mobileqq.pic.IPreparePresendCallBack");
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 1598968902) {
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      paramParcel2.writeString("com.tencent.mobileqq.pic.IPreparePresendCallBack");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPreparePresendCallBack");
    a(paramParcel1.readStrongBinder());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.IPreparePresendCallBack.Stub
 * JD-Core Version:    0.7.0.1
 */