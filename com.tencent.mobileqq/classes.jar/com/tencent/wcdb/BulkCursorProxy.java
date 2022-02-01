package com.tencent.wcdb;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

final class BulkCursorProxy
  implements IBulkCursor
{
  private IBinder a;
  private Bundle b;
  
  public BulkCursorProxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
    this.b = null;
  }
  
  public int a(IContentObserver paramIContentObserver)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.content.IBulkCursor");
      localParcel1.writeStrongInterface(paramIContentObserver);
      boolean bool = this.a.transact(3, localParcel1, localParcel2, 0);
      DatabaseUtils.a(localParcel2);
      int i;
      if (!bool)
      {
        i = -1;
      }
      else
      {
        i = localParcel2.readInt();
        this.b = localParcel2.readBundle(getClass().getClassLoader());
      }
      return i;
    }
    finally
    {
      localParcel1.recycle();
      localParcel2.recycle();
    }
  }
  
  public Bundle a(Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.content.IBulkCursor");
      localParcel1.writeBundle(paramBundle);
      this.a.transact(6, localParcel1, localParcel2, 0);
      DatabaseUtils.a(localParcel2);
      paramBundle = localParcel2.readBundle(getClass().getClassLoader());
      return paramBundle;
    }
    finally
    {
      localParcel1.recycle();
      localParcel2.recycle();
    }
  }
  
  public CursorWindow a(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.content.IBulkCursor");
      localParcel1.writeInt(paramInt);
      this.a.transact(1, localParcel1, localParcel2, 0);
      DatabaseUtils.a(localParcel2);
      CursorWindow localCursorWindow = null;
      if (localParcel2.readInt() == 1) {
        localCursorWindow = CursorWindow.a(localParcel2);
      }
      return localCursorWindow;
    }
    finally
    {
      localParcel1.recycle();
      localParcel2.recycle();
    }
  }
  
  public void a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.content.IBulkCursor");
      this.a.transact(2, localParcel1, localParcel2, 0);
      DatabaseUtils.a(localParcel2);
      return;
    }
    finally
    {
      localParcel1.recycle();
      localParcel2.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public void b()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.content.IBulkCursor");
      this.a.transact(7, localParcel1, localParcel2, 0);
      DatabaseUtils.a(localParcel2);
      return;
    }
    finally
    {
      localParcel1.recycle();
      localParcel2.recycle();
    }
  }
  
  public void b(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.content.IBulkCursor");
      localParcel1.writeInt(paramInt);
      this.a.transact(4, localParcel1, localParcel2, 0);
      DatabaseUtils.a(localParcel2);
      return;
    }
    finally
    {
      localParcel1.recycle();
      localParcel2.recycle();
    }
  }
  
  public Bundle c()
  {
    if (this.b == null)
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("android.content.IBulkCursor");
        this.a.transact(5, localParcel1, localParcel2, 0);
        DatabaseUtils.a(localParcel2);
        this.b = localParcel2.readBundle(getClass().getClassLoader());
        localParcel1.recycle();
        localParcel2.recycle();
      }
      finally
      {
        localParcel1.recycle();
        localParcel2.recycle();
      }
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.BulkCursorProxy
 * JD-Core Version:    0.7.0.1
 */