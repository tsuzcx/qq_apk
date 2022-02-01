package com.tencent.mobileqq.theme;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class IDownloadListener$Stub
  extends Binder
  implements IDownloadListener
{
  private static final String DESCRIPTOR = "com.tencent.mobileqq.theme.IDownloadListener";
  static final int TRANSACTION_onComplete = 2;
  static final int TRANSACTION_onProgress = 1;
  
  public IDownloadListener$Stub()
  {
    attachInterface(this, "com.tencent.mobileqq.theme.IDownloadListener");
  }
  
  public static IDownloadListener asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.theme.IDownloadListener");
    if ((localIInterface != null) && ((localIInterface instanceof IDownloadListener))) {
      return (IDownloadListener)localIInterface;
    }
    return new IDownloadListener.Stub.Proxy(paramIBinder);
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
      paramParcel2.writeString("com.tencent.mobileqq.theme.IDownloadListener");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.theme.IDownloadListener");
      onProgress(paramParcel1.readString(), paramParcel1.readLong(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.theme.IDownloadListener");
    onComplete(paramParcel1.readString(), paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.IDownloadListener.Stub
 * JD-Core Version:    0.7.0.1
 */