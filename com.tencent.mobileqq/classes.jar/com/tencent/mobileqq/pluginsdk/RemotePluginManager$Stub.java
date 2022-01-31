package com.tencent.mobileqq.pluginsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class RemotePluginManager$Stub
  extends Binder
  implements RemotePluginManager
{
  private static final String DESCRIPTOR = "com.tencent.mobileqq.pluginsdk.RemotePluginManager";
  static final int TRANSACTION_cancelInstall = 4;
  static final int TRANSACTION_installPlugin = 1;
  static final int TRANSACTION_isPlugininstalled = 2;
  static final int TRANSACTION_isReady = 5;
  static final int TRANSACTION_queryPlugin = 3;
  static final int TRANSACTION_setListener = 6;
  
  public RemotePluginManager$Stub()
  {
    attachInterface(this, "com.tencent.mobileqq.pluginsdk.RemotePluginManager");
  }
  
  public static RemotePluginManager asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
    if ((localIInterface != null) && ((localIInterface instanceof RemotePluginManager))) {
      return (RemotePluginManager)localIInterface;
    }
    return new RemotePluginManager.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int j = 0;
    int i = 0;
    boolean bool;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
      installPlugin(paramParcel1.readString(), OnPluginInstallListener.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
      bool = isPlugininstalled(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
      paramParcel1 = queryPlugin(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
      cancelInstall(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
      bool = isReady();
      paramParcel2.writeNoException();
      paramInt1 = j;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
    setListener(asInterface(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.RemotePluginManager.Stub
 * JD-Core Version:    0.7.0.1
 */