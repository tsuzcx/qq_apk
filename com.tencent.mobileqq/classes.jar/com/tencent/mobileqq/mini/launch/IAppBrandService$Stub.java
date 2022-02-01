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
    if (paramInt1 != 1598968902)
    {
      Object localObject2 = null;
      String str1 = null;
      String str2 = null;
      Object localObject3 = null;
      Object localObject5 = null;
      Object localObject4 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 8: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
        localObject2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        sendCmd((String)localObject2, (Bundle)localObject1, CmdCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
        str1 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject1 = (MiniAppConfig)MiniAppConfig.CREATOR.createFromParcel(paramParcel1);
        } else {
          localObject1 = null;
        }
        if (paramParcel1.readInt() != 0) {
          localObject2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        onAppStop(str1, (MiniAppConfig)localObject1, (Bundle)localObject2);
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
        str2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject1 = (MiniAppConfig)MiniAppConfig.CREATOR.createFromParcel(paramParcel1);
        } else {
          localObject1 = null;
        }
        localObject2 = str1;
        if (paramParcel1.readInt() != 0) {
          localObject2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        onAppForeground(str2, (MiniAppConfig)localObject1, (Bundle)localObject2);
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
        str1 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject1 = (MiniAppConfig)MiniAppConfig.CREATOR.createFromParcel(paramParcel1);
        } else {
          localObject1 = null;
        }
        localObject2 = str2;
        if (paramParcel1.readInt() != 0) {
          localObject2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        onAppBackground(str1, (MiniAppConfig)localObject1, (Bundle)localObject2);
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
        str1 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject1 = (MiniAppConfig)MiniAppConfig.CREATOR.createFromParcel(paramParcel1);
        } else {
          localObject1 = null;
        }
        localObject2 = localObject3;
        if (paramParcel1.readInt() != 0) {
          localObject2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        onAppStart(str1, (MiniAppConfig)localObject1, (Bundle)localObject2);
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
        localObject1 = localObject5;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (MiniAppInfo)MiniAppInfo.CREATOR.createFromParcel(paramParcel1);
        }
        preloadPackage((MiniAppInfo)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
        if (paramParcel1.readInt() != 0) {
          localObject1 = (MiniAppConfig)MiniAppConfig.CREATOR.createFromParcel(paramParcel1);
        } else {
          localObject1 = null;
        }
        localObject2 = localObject4;
        if (paramParcel1.readInt() != 0) {
          localObject2 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel1);
        }
        startMiniApp((MiniAppConfig)localObject1, (ResultReceiver)localObject2);
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.mini.launch.IAppBrandService");
      preloadMiniApp();
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel2.writeString("com.tencent.mobileqq.mini.launch.IAppBrandService");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.IAppBrandService.Stub
 * JD-Core Version:    0.7.0.1
 */