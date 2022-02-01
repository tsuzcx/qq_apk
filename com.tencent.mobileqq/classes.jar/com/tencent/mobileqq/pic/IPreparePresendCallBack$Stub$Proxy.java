package com.tencent.mobileqq.pic;

import android.os.IBinder;
import android.os.Parcel;

class IPreparePresendCallBack$Stub$Proxy
  implements IPreparePresendCallBack
{
  private IBinder a;
  
  public void a(IBinder paramIBinder)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.pic.IPreparePresendCallBack");
      localParcel1.writeStrongBinder(paramIBinder);
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.IPreparePresendCallBack.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */