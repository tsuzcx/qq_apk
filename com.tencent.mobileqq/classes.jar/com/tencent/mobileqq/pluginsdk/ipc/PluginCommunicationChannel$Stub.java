package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class PluginCommunicationChannel$Stub
  extends Binder
  implements PluginCommunicationChannel
{
  private static final String DESCRIPTOR = "com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel";
  static final int TRANSACTION_getNickName = 2;
  static final int TRANSACTION_getSKey = 3;
  static final int TRANSACTION_getSid = 4;
  static final int TRANSACTION_getUin = 1;
  static final int TRANSACTION_transfer = 5;
  static final int TRANSACTION_transferAsync = 6;
  
  public PluginCommunicationChannel$Stub()
  {
    attachInterface(this, "com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
  }
  
  public static PluginCommunicationChannel asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
    if ((localIInterface != null) && ((localIInterface instanceof PluginCommunicationChannel))) {
      return (PluginCommunicationChannel)localIInterface;
    }
    return new PluginCommunicationChannel.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1598968902)
    {
      String str1 = null;
      Object localObject = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 6: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
        str1 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        transferAsync(str1, (Bundle)localObject, RemoteCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
        String str2 = paramParcel1.readString();
        localObject = str1;
        if (paramParcel1.readInt() != 0) {
          localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1 = transfer(str2, (Bundle)localObject);
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
        paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
        paramParcel1 = getSid();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
        paramParcel1 = getSKey();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
        paramParcel1 = getNickName();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
      long l = getUin();
      paramParcel2.writeNoException();
      paramParcel2.writeLong(l);
      return true;
    }
    paramParcel2.writeString("com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel.Stub
 * JD-Core Version:    0.7.0.1
 */