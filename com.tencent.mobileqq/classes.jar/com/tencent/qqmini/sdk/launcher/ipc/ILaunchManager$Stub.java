package com.tencent.qqmini.sdk.launcher.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract class ILaunchManager$Stub
  extends Binder
  implements ILaunchManager
{
  private static final String DESCRIPTOR = "com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager";
  static final int TRANSACTION_onAppLifecycle = 5;
  static final int TRANSACTION_preloadDownloadPackage = 4;
  static final int TRANSACTION_requestAync = 7;
  static final int TRANSACTION_sendCmd = 6;
  static final int TRANSACTION_startMiniApp = 1;
  static final int TRANSACTION_stopAllMiniApp = 3;
  static final int TRANSACTION_stopMiniApp = 2;
  
  public ILaunchManager$Stub()
  {
    attachInterface(this, "com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager");
  }
  
  public static ILaunchManager asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager");
    if ((localIInterface != null) && ((localIInterface instanceof ILaunchManager))) {
      return (ILaunchManager)localIInterface;
    }
    return new ILaunchManager.Stub.Proxy(paramIBinder);
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
      paramParcel2.writeString("com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = (MiniAppInfo)MiniAppInfo.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label183;
        }
        localObject2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label189;
        }
      }
      for (paramParcel1 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        startMiniApp((MiniAppInfo)localObject1, (Bundle)localObject2, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
        localObject2 = null;
        break label142;
      }
    case 2: 
      paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (MiniAppInfo)MiniAppInfo.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        stopMiniApp(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 3: 
      paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager");
      stopAllMiniApp();
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (MiniAppInfo)MiniAppInfo.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        preloadDownloadPackage(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 5: 
      paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager");
      paramInt1 = paramParcel1.readInt();
      localObject2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = (MiniAppInfo)MiniAppInfo.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label374;
        }
      }
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        onAppLifecycle(paramInt1, (String)localObject2, (MiniAppInfo)localObject1, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
      }
    case 6: 
      label142:
      label183:
      label189:
      label374:
      paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager");
      localObject2 = paramParcel1.readString();
      String str = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        sendCmd((String)localObject2, str, (Bundle)localObject1, MiniCmdCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
    }
    paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager");
    Object localObject1 = paramParcel1.readString();
    Object localObject2 = paramParcel1.readString();
    if (paramParcel1.readInt() != 0)
    {
      paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      paramParcel1 = requestAync((String)localObject1, (String)localObject2, paramParcel1);
      paramParcel2.writeNoException();
      if (paramParcel1 == null) {
        break label521;
      }
      paramParcel2.writeInt(1);
      paramParcel1.writeToParcel(paramParcel2, 1);
    }
    for (;;)
    {
      return true;
      paramParcel1 = null;
      break;
      label521:
      paramParcel2.writeInt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager.Stub
 * JD-Core Version:    0.7.0.1
 */