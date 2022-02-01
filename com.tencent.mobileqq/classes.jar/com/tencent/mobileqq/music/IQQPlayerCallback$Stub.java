package com.tencent.mobileqq.music;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IQQPlayerCallback$Stub
  extends Binder
  implements IQQPlayerCallback
{
  public IQQPlayerCallback$Stub()
  {
    attachInterface(this, "com.tencent.mobileqq.music.IQQPlayerCallback");
  }
  
  public static IQQPlayerCallback a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.music.IQQPlayerCallback");
    if ((localIInterface != null) && ((localIInterface instanceof IQQPlayerCallback))) {
      return (IQQPlayerCallback)localIInterface;
    }
    return new IQQPlayerCallback.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 1598968902) {
          return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        }
        paramParcel2.writeString("com.tencent.mobileqq.music.IQQPlayerCallback");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerCallback");
      if (paramParcel1.readInt() != 0) {
        paramParcel1 = (SongInfo)SongInfo.CREATOR.createFromParcel(paramParcel1);
      } else {
        paramParcel1 = null;
      }
      a(paramParcel1);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.music.IQQPlayerCallback");
    a(paramParcel1.readInt());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.music.IQQPlayerCallback.Stub
 * JD-Core Version:    0.7.0.1
 */