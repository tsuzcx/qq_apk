package com.tencent.wcdb.support;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class ICancellationSignal$Stub
  extends Binder
  implements ICancellationSignal
{
  public ICancellationSignal$Stub()
  {
    attachInterface(this, "com.tencent.wcdb.support.ICancellationSignal");
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
      paramParcel2.writeString("com.tencent.wcdb.support.ICancellationSignal");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.wcdb.support.ICancellationSignal");
    a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.support.ICancellationSignal.Stub
 * JD-Core Version:    0.7.0.1
 */