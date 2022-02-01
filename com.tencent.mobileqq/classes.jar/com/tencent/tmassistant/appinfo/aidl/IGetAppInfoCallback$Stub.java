package com.tencent.tmassistant.appinfo.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.tmassistant.appinfo.data.AppDetail;

public abstract class IGetAppInfoCallback$Stub
  extends Binder
  implements IGetAppInfoCallback
{
  private static final String DESCRIPTOR = "com.tencent.tmassistant.appinfo.aidl.IGetAppInfoCallback";
  
  public IGetAppInfoCallback$Stub()
  {
    attachInterface(this, "com.tencent.tmassistant.appinfo.aidl.IGetAppInfoCallback");
  }
  
  public static IGetAppInfoCallback asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.tmassistant.appinfo.aidl.IGetAppInfoCallback");
    if ((localIInterface != null) && ((localIInterface instanceof IGetAppInfoCallback))) {
      return (IGetAppInfoCallback)localIInterface;
    }
    return new a(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.tmassistant.appinfo.aidl.IGetAppInfoCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.tmassistant.appinfo.aidl.IGetAppInfoCallback");
    onGetAppInfoResponse(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.createTypedArrayList(AppDetail.CREATOR));
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistant.appinfo.aidl.IGetAppInfoCallback.Stub
 * JD-Core Version:    0.7.0.1
 */