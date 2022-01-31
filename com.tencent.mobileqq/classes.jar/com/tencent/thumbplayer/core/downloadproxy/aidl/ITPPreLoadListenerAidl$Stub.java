package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class ITPPreLoadListenerAidl$Stub
  extends Binder
  implements ITPPreLoadListenerAidl
{
  private static final String DESCRIPTOR = "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl";
  static final int TRANSACTION_onPrepareDownloadProgressUpdate = 3;
  static final int TRANSACTION_onPrepareError = 2;
  static final int TRANSACTION_onPrepareOK = 1;
  
  public ITPPreLoadListenerAidl$Stub()
  {
    attachInterface(this, "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl");
  }
  
  public static ITPPreLoadListenerAidl asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl");
    if ((localIInterface != null) && ((localIInterface instanceof ITPPreLoadListenerAidl))) {
      return (ITPPreLoadListenerAidl)localIInterface;
    }
    return new ITPPreLoadListenerAidl.Stub.Proxy(paramIBinder);
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
      paramParcel2.writeString("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl");
      onPrepareOK();
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl");
      onPrepareError(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl");
    onPrepareDownloadProgressUpdate(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readLong(), paramParcel1.readLong(), paramParcel1.readString());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl.Stub
 * JD-Core Version:    0.7.0.1
 */