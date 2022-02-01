package com.tencent.tmassistant.aidl;

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
    attachInterface(this, "com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceCallback");
  }
  
  public static a a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceCallback");
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
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 1598968902) {
            return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
          }
          paramParcel2.writeString("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceCallback");
          return true;
        }
        paramParcel1.enforceInterface("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceCallback");
        a(paramParcel1.createStringArrayList());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceCallback");
      a(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readLong(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceCallback");
    a(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistant.aidl.b
 * JD-Core Version:    0.7.0.1
 */