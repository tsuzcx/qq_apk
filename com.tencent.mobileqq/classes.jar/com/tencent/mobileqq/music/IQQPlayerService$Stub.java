package com.tencent.mobileqq.music;

import adwk;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IQQPlayerService$Stub
  extends Binder
  implements IQQPlayerService
{
  public IQQPlayerService$Stub()
  {
    attachInterface(this, "com.tencent.mobileqq.music.IQQPlayerService");
  }
  
  public static IQQPlayerService a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.music.IQQPlayerService");
    if ((localIInterface != null) && ((localIInterface instanceof IQQPlayerService))) {
      return (IQQPlayerService)localIInterface;
    }
    return new adwk(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int j = 0;
    int i = 0;
    boolean bool;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mobileqq.music.IQQPlayerService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      a(paramParcel1.readString(), (SongInfo[])paramParcel1.createTypedArray(SongInfo.CREATOR), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      a();
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      b();
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      c();
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      a(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      d();
      paramParcel2.writeNoException();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      e();
      paramParcel2.writeNoException();
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      bool = a();
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      paramInt1 = a();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      paramInt1 = b();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      paramInt1 = c();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      paramInt1 = d();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      paramParcel1 = a();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      paramInt1 = e();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      paramInt1 = f();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      paramParcel1 = a();
      paramParcel2.writeNoException();
      paramParcel2.writeTypedArray(paramParcel1, 1);
      return true;
    case 17: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 18: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      paramParcel1 = a();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 19: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 20: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      paramParcel1 = a();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 21: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      bool = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramInt1 = j;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 22: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      paramParcel1 = a(paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 23: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      paramParcel1 = a();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 24: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      a(IQQPlayerCallback.Stub.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 25: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
      b(IQQPlayerCallback.Stub.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
    paramInt1 = g();
    paramParcel2.writeNoException();
    paramParcel2.writeInt(paramInt1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.music.IQQPlayerService.Stub
 * JD-Core Version:    0.7.0.1
 */