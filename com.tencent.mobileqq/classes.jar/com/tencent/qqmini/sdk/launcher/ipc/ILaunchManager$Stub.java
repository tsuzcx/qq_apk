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
    if (paramInt1 != 1598968902)
    {
      Object localObject5 = null;
      Object localObject2 = null;
      Object localObject4 = null;
      Object localObject6 = null;
      Object localObject3 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 7: 
        paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager");
        localObject2 = paramParcel1.readString();
        localObject3 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1 = requestAync((String)localObject2, (String)localObject3, (Bundle)localObject1);
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager");
        localObject2 = paramParcel1.readString();
        localObject3 = paramParcel1.readString();
        localObject1 = localObject5;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        sendCmd((String)localObject2, (String)localObject3, (Bundle)localObject1, MiniCmdCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager");
        paramInt1 = paramParcel1.readInt();
        localObject3 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject1 = (MiniAppInfo)MiniAppInfo.CREATOR.createFromParcel(paramParcel1);
        } else {
          localObject1 = null;
        }
        if (paramParcel1.readInt() != 0) {
          localObject2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        onAppLifecycle(paramInt1, (String)localObject3, (MiniAppInfo)localObject1, (Bundle)localObject2);
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager");
        if (paramParcel1.readInt() != 0) {
          localObject1 = (MiniAppInfo)MiniAppInfo.CREATOR.createFromParcel(paramParcel1);
        } else {
          localObject1 = null;
        }
        localObject2 = localObject4;
        if (paramParcel1.readInt() != 0) {
          localObject2 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel1);
        }
        preloadDownloadPackage((MiniAppInfo)localObject1, (ResultReceiver)localObject2);
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager");
        stopAllMiniApp();
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager");
        localObject1 = localObject6;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (MiniAppInfo)MiniAppInfo.CREATOR.createFromParcel(paramParcel1);
        }
        stopMiniApp((MiniAppInfo)localObject1);
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager");
      if (paramParcel1.readInt() != 0) {
        localObject1 = (MiniAppInfo)MiniAppInfo.CREATOR.createFromParcel(paramParcel1);
      } else {
        localObject1 = null;
      }
      if (paramParcel1.readInt() != 0) {
        localObject2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      } else {
        localObject2 = null;
      }
      if (paramParcel1.readInt() != 0) {
        localObject3 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel1);
      }
      startMiniApp((MiniAppInfo)localObject1, (Bundle)localObject2, (ResultReceiver)localObject3);
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel2.writeString("com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager.Stub
 * JD-Core Version:    0.7.0.1
 */