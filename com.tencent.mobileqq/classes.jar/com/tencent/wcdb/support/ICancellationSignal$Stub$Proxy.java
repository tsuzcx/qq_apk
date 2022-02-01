package com.tencent.wcdb.support;

import android.os.IBinder;
import android.os.Parcel;

class ICancellationSignal$Stub$Proxy
  implements ICancellationSignal
{
  private IBinder a;
  
  public void a()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.wcdb.support.ICancellationSignal");
      this.a.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.support.ICancellationSignal.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */