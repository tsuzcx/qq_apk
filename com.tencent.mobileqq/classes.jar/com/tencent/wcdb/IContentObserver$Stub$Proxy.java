package com.tencent.wcdb;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;

class IContentObserver$Stub$Proxy
  implements IContentObserver
{
  private IBinder a;
  
  IContentObserver$Stub$Proxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public void a(boolean paramBoolean, Uri paramUri)
  {
    Parcel localParcel = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel.writeInterfaceToken("com.tencent.wcdb.IContentObserver");
        if (paramBoolean)
        {
          i = 1;
          localParcel.writeInt(i);
          if (paramUri != null)
          {
            localParcel.writeInt(1);
            paramUri.writeToParcel(localParcel, 0);
          }
          else
          {
            localParcel.writeInt(0);
          }
          this.a.transact(1, localParcel, null, 1);
          return;
        }
      }
      finally
      {
        localParcel.recycle();
      }
      int i = 0;
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.IContentObserver.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */