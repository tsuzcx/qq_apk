package com.tencent.mobileqq.pluginsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class OnPluginInstallListener$Stub
  extends Binder
  implements OnPluginInstallListener
{
  private static final String DESCRIPTOR = "com.tencent.mobileqq.pluginsdk.OnPluginInstallListener";
  static final int TRANSACTION_onInstallBegin = 1;
  static final int TRANSACTION_onInstallDownloadProgress = 2;
  static final int TRANSACTION_onInstallError = 4;
  static final int TRANSACTION_onInstallFinish = 3;
  
  public OnPluginInstallListener$Stub()
  {
    attachInterface(this, "com.tencent.mobileqq.pluginsdk.OnPluginInstallListener");
  }
  
  public static OnPluginInstallListener asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.pluginsdk.OnPluginInstallListener");
    if ((localIInterface != null) && ((localIInterface instanceof OnPluginInstallListener))) {
      return (OnPluginInstallListener)localIInterface;
    }
    return new OnPluginInstallListener.Stub.Proxy(paramIBinder);
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
          if (paramInt1 != 4)
          {
            if (paramInt1 != 1598968902) {
              return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
            }
            paramParcel2.writeString("com.tencent.mobileqq.pluginsdk.OnPluginInstallListener");
            return true;
          }
          paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.OnPluginInstallListener");
          onInstallError(paramParcel1.readString(), paramParcel1.readInt());
          paramParcel2.writeNoException();
          return true;
        }
        paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.OnPluginInstallListener");
        onInstallFinish(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.OnPluginInstallListener");
      onInstallDownloadProgress(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.OnPluginInstallListener");
    onInstallBegin(paramParcel1.readString());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub
 * JD-Core Version:    0.7.0.1
 */