package com.tencent.turingfd.sdk.ams.ga;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class Norma$do$do
  implements Norma
{
  public static Norma ae;
  public IBinder be;
  
  public Norma$do$do(IBinder paramIBinder)
  {
    this.be = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.be;
  }
  
  public int getVersion()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(Norma.do.j);
      if ((!this.be.transact(12, localParcel1, localParcel2, 0)) && (Norma.do.i() != null))
      {
        Object localObject1 = Norma.do.i();
        localObject1 = (do)localObject1;
        i = ((do)localObject1).getVersion();
        return i;
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
  
  public int i(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(Norma.do.j);
      localParcel1.writeInt(paramInt);
      if ((!this.be.transact(1, localParcel1, localParcel2, 0)) && (Norma.do.i() != null))
      {
        Object localObject1 = Norma.do.i();
        localObject1 = (do)localObject1;
        paramInt = ((do)localObject1).i(paramInt);
        return paramInt;
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
  
  public Perseus j(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(Norma.do.j);
      localParcel1.writeInt(paramInt);
      Object localObject1;
      if ((!this.be.transact(2, localParcel1, localParcel2, 0)) && (Norma.do.i() != null))
      {
        localObject1 = Norma.do.i();
        localObject1 = (do)localObject1;
        localObject1 = ((do)localObject1).j(paramInt);
        return localObject1;
      }
      localParcel2.readException();
      if (localParcel2.readInt() != 0) {
        localObject1 = (Perseus)Perseus.CREATOR.createFromParcel(localParcel2);
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
  
  public boolean k(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(Norma.do.j);
      localParcel1.writeInt(paramInt);
      Object localObject1 = this.be;
      boolean bool = false;
      if ((!((IBinder)localObject1).transact(3, localParcel1, localParcel2, 0)) && (Norma.do.i() != null))
      {
        localObject1 = Norma.do.i();
        localObject1 = (do)localObject1;
        bool = ((do)localObject1).k(paramInt);
        return bool;
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
  
  public int l(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(Norma.do.j);
      localParcel1.writeInt(paramInt);
      if ((!this.be.transact(7, localParcel1, localParcel2, 0)) && (Norma.do.i() != null))
      {
        Object localObject1 = Norma.do.i();
        localObject1 = (do)localObject1;
        paramInt = ((do)localObject1).l(paramInt);
        return paramInt;
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
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Norma.do.do
 * JD-Core Version:    0.7.0.1
 */