package com.tencent.mobileqq.mini.launch;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

public abstract class IAppBrandService$Stub
  extends Binder
  implements IAppBrandService
{
  private static final String DESCRIPTOR = "com.tencent.mobileqq.mini.launch.IAppBrandService";
  static final int TRANSACTION_onAppBackground = 5;
  static final int TRANSACTION_onAppForeground = 6;
  static final int TRANSACTION_onAppStart = 4;
  static final int TRANSACTION_onAppStop = 7;
  static final int TRANSACTION_preloadMiniApp = 1;
  static final int TRANSACTION_preloadPackage = 3;
  static final int TRANSACTION_sendCmd = 8;
  static final int TRANSACTION_startMiniApp = 2;
  
  public IAppBrandService$Stub()
  {
    attachInterface(this, "com.tencent.mobileqq.mini.launch.IAppBrandService");
  }
  
  public static IAppBrandService asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
    if ((localIInterface != null) && ((localIInterface instanceof IAppBrandService))) {
      return (IAppBrandService)localIInterface;
    }
    return new IAppBrandService.Stub.Proxy(paramIBinder);
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
      paramParcel2.writeString("com.tencent.mobileqq.mini.launch.IAppBrandService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
      preloadMiniApp();
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
      if (paramParcel1.readInt() != 0)
      {
        localObject = (MiniAppConfig)MiniAppConfig.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label184;
        }
      }
      for (paramParcel1 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        startMiniApp((MiniAppConfig)localObject, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject = null;
        break;
      }
    case 3: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (MiniAppInfo)MiniAppInfo.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        preloadPackage(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 4: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
      str = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
      {
        localObject = (MiniAppConfig)MiniAppConfig.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label305;
        }
      }
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        onAppStart(str, (MiniAppConfig)localObject, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject = null;
        break;
      }
    case 5: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
      str = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
      {
        localObject = (MiniAppConfig)MiniAppConfig.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label384;
        }
      }
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        onAppBackground(str, (MiniAppConfig)localObject, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject = null;
        break;
      }
    case 6: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
      str = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
      {
        localObject = (MiniAppConfig)MiniAppConfig.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label463;
        }
      }
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        onAppForeground(str, (MiniAppConfig)localObject, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject = null;
        break;
      }
    case 7: 
      label184:
      label463:
      paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
      label305:
      str = paramParcel1.readString();
      label384:
      if (paramParcel1.readInt() != 0)
      {
        localObject = (MiniAppConfig)MiniAppConfig.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label542;
        }
      }
      label542:
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        onAppStop(str, (MiniAppConfig)localObject, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject = null;
        break;
      }
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
    String str = paramParcel1.readString();
    if (paramParcel1.readInt() != 0) {}
    for (Object localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localObject = null)
    {
      sendCmd(str, (Bundle)localObject, CmdCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.IAppBrandService.Stub
 * JD-Core Version:    0.7.0.1
 */