package com.tencent.tmdownloader.internal.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class b
  extends Binder
  implements a
{
  public b()
  {
    attachInterface(this, "com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
  }
  
  public static a a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
    if ((localIInterface != null) && ((localIInterface instanceof a))) {
      return (a)localIInterface;
    }
    return new c(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int i = 0;
    boolean bool = false;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
      a(paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
      a();
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
      b();
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
      c();
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
      d();
      paramParcel2.writeNoException();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
      a(paramParcel1.readString(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
      a(paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
      a(paramParcel1.readString(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
      a(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
      String str = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        bool = true;
      }
      a(str, bool);
      paramParcel2.writeNoException();
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
      paramParcel1 = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(paramParcel1);
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
      paramInt1 = b(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
      long l = c(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeLong(l);
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
      paramParcel1 = d(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.tmdownloader.internal.remote.IRemoteOpInterface");
    bool = e(paramParcel1.readString());
    paramParcel2.writeNoException();
    paramInt1 = i;
    if (bool) {
      paramInt1 = 1;
    }
    paramParcel2.writeInt(paramInt1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.remote.b
 * JD-Core Version:    0.7.0.1
 */