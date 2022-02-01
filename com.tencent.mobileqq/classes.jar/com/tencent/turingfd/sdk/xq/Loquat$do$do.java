package com.tencent.turingfd.sdk.xq;

import android.os.IBinder;
import android.os.Parcel;

public class Loquat$do$do
  implements Loquat
{
  public IBinder a;
  
  public Loquat$do$do(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public int a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(Loquat.do.a);
      if (!this.a.transact(12, localParcel1, localParcel2, 0)) {
        String str = Loquat.do.a;
      }
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int a(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(Loquat.do.a);
      localParcel1.writeInt(paramInt);
      if (!this.a.transact(1, localParcel1, localParcel2, 0)) {
        String str = Loquat.do.a;
      }
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      return paramInt;
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
  
  public Mangosteen b(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(Loquat.do.a);
      localParcel1.writeInt(paramInt);
      Object localObject1;
      if (!this.a.transact(2, localParcel1, localParcel2, 0)) {
        localObject1 = Loquat.do.a;
      }
      localParcel2.readException();
      if (localParcel2.readInt() != 0) {
        localObject1 = new Mangosteen(localParcel2);
      } else {
        localObject1 = null;
      }
      return localObject1;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean c(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(Loquat.do.a);
      localParcel1.writeInt(paramInt);
      Object localObject1 = this.a;
      boolean bool = false;
      if (!((IBinder)localObject1).transact(3, localParcel1, localParcel2, 0)) {
        localObject1 = Loquat.do.a;
      }
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      if (paramInt != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int d(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(Loquat.do.a);
      localParcel1.writeInt(paramInt);
      if (!this.a.transact(7, localParcel1, localParcel2, 0)) {
        String str = Loquat.do.a;
      }
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      return paramInt;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Loquat.do.do
 * JD-Core Version:    0.7.0.1
 */