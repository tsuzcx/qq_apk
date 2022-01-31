package com.tencent.qphone.base.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;

public abstract class IWtloginService$Stub
  extends Binder
  implements IWtloginService
{
  private static final String DESCRIPTOR = "com.tencent.qphone.base.remote.IWtloginService";
  static final int TRANSACTION_CheckPictureAndGetSt = 4;
  static final int TRANSACTION_CheckSMSAndGetSt = 10;
  static final int TRANSACTION_CloseCode = 7;
  static final int TRANSACTION_GetA1WithA1 = 8;
  static final int TRANSACTION_GetStWithPasswd = 1;
  static final int TRANSACTION_GetStWithoutPasswd = 3;
  static final int TRANSACTION_RefreshPictureData = 5;
  static final int TRANSACTION_RefreshSMSData = 9;
  static final int TRANSACTION_VerifyCode = 6;
  static final int TRANSACTION_removeRemoteHelper = 2;
  static final int TRANSACTION_setTestHost = 11;
  
  public IWtloginService$Stub()
  {
    attachInterface(this, "com.tencent.qphone.base.remote.IWtloginService");
  }
  
  public static IWtloginService asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.qphone.base.remote.IWtloginService");
    if ((localIInterface != null) && ((localIInterface instanceof IWtloginService))) {
      return (IWtloginService)localIInterface;
    }
    return new IWtloginService.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject1;
    String str;
    long l1;
    Object localObject2;
    WUserSigInfo localWUserSigInfo;
    long l2;
    Object localObject3;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.qphone.base.remote.IWtloginService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
      localObject1 = paramParcel1.readString();
      str = paramParcel1.readString();
      l1 = paramParcel1.readLong();
      localObject2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (localWUserSigInfo = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);; localWUserSigInfo = null)
      {
        paramInt1 = GetStWithPasswd((String)localObject1, str, l1, (String)localObject2, localWUserSigInfo, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 2: 
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
      removeRemoteHelper(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
      localObject1 = paramParcel1.readString();
      str = paramParcel1.readString();
      l1 = paramParcel1.readLong();
      l2 = paramParcel1.readLong();
      if (paramParcel1.readInt() != 0) {}
      for (localWUserSigInfo = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);; localWUserSigInfo = null)
      {
        paramInt1 = GetStWithoutPasswd((String)localObject1, str, l1, l2, localWUserSigInfo, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 4: 
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
      localObject1 = paramParcel1.readString();
      str = paramParcel1.readString();
      localObject2 = paramParcel1.createByteArray();
      if (paramParcel1.readInt() != 0) {}
      for (localWUserSigInfo = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);; localWUserSigInfo = null)
      {
        paramInt1 = CheckPictureAndGetSt((String)localObject1, str, (byte[])localObject2, localWUserSigInfo, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 5: 
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
      localObject1 = paramParcel1.readString();
      str = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (localWUserSigInfo = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);; localWUserSigInfo = null)
      {
        paramInt1 = RefreshPictureData((String)localObject1, str, localWUserSigInfo, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 6: 
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
      localObject1 = paramParcel1.readString();
      str = paramParcel1.readString();
      l1 = paramParcel1.readLong();
      boolean bool;
      if (paramParcel1.readInt() != 0)
      {
        bool = true;
        localObject2 = paramParcel1.createByteArray();
        localObject3 = paramParcel1.createIntArray();
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          break label598;
        }
      }
      for (localWUserSigInfo = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);; localWUserSigInfo = null)
      {
        paramInt1 = VerifyCode((String)localObject1, str, l1, bool, (byte[])localObject2, (int[])localObject3, paramInt1, localWUserSigInfo, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
        bool = false;
        break;
      }
    case 7: 
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
      localObject1 = paramParcel1.readString();
      str = paramParcel1.readString();
      l1 = paramParcel1.readLong();
      localObject2 = paramParcel1.createByteArray();
      paramInt1 = paramParcel1.readInt();
      localObject3 = paramParcel1.readArrayList(getClass().getClassLoader());
      if (paramParcel1.readInt() != 0) {}
      for (localWUserSigInfo = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);; localWUserSigInfo = null)
      {
        paramInt1 = CloseCode((String)localObject1, str, l1, (byte[])localObject2, paramInt1, (List)localObject3, localWUserSigInfo, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 8: 
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
      str = paramParcel1.readString();
      localObject2 = paramParcel1.readString();
      l1 = paramParcel1.readLong();
      l2 = paramParcel1.readLong();
      localObject3 = paramParcel1.createByteArray();
      long l3 = paramParcel1.readLong();
      long l4 = paramParcel1.readLong();
      long l5 = paramParcel1.readLong();
      byte[] arrayOfByte1 = paramParcel1.createByteArray();
      byte[] arrayOfByte2 = paramParcel1.createByteArray();
      if (paramParcel1.readInt() != 0)
      {
        localWUserSigInfo = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label876;
        }
      }
      for (localObject1 = (WFastLoginInfo)WFastLoginInfo.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        paramInt1 = GetA1WithA1(str, (String)localObject2, l1, l2, (byte[])localObject3, l3, l4, l5, arrayOfByte1, arrayOfByte2, localWUserSigInfo, (WFastLoginInfo)localObject1, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
        localWUserSigInfo = null;
        break;
      }
    case 9: 
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
      localObject1 = paramParcel1.readString();
      str = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (localWUserSigInfo = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);; localWUserSigInfo = null)
      {
        paramInt1 = RefreshSMSData((String)localObject1, str, localWUserSigInfo, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 10: 
      label598:
      label876:
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
      localObject1 = paramParcel1.readString();
      str = paramParcel1.readString();
      localObject2 = paramParcel1.createByteArray();
      if (paramParcel1.readInt() != 0) {}
      for (localWUserSigInfo = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);; localWUserSigInfo = null)
      {
        paramInt1 = CheckSMSAndGetSt((String)localObject1, str, (byte[])localObject2, localWUserSigInfo, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    }
    paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
    setTestHost(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString(), IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.IWtloginService.Stub
 * JD-Core Version:    0.7.0.1
 */