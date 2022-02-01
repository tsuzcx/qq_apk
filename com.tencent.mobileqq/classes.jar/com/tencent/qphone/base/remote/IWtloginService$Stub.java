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
    if (paramInt1 != 1598968902)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      long l2;
      Object localObject4;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 11: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
        setTestHost(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString(), IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
        localObject2 = paramParcel1.readString();
        str = paramParcel1.readString();
        localObject3 = paramParcel1.createByteArray();
        if (paramParcel1.readInt() != 0) {
          localObject1 = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);
        } else {
          localObject1 = null;
        }
        paramInt1 = CheckSMSAndGetSt((String)localObject2, str, (byte[])localObject3, (WUserSigInfo)localObject1, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
        localObject2 = paramParcel1.readString();
        str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject1 = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = RefreshSMSData((String)localObject2, str, (WUserSigInfo)localObject1, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
        str = paramParcel1.readString();
        localObject3 = paramParcel1.readString();
        l1 = paramParcel1.readLong();
        l2 = paramParcel1.readLong();
        localObject4 = paramParcel1.createByteArray();
        long l3 = paramParcel1.readLong();
        long l4 = paramParcel1.readLong();
        long l5 = paramParcel1.readLong();
        byte[] arrayOfByte1 = paramParcel1.createByteArray();
        byte[] arrayOfByte2 = paramParcel1.createByteArray();
        if (paramParcel1.readInt() != 0) {
          localObject1 = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);
        } else {
          localObject1 = null;
        }
        if (paramParcel1.readInt() != 0) {
          localObject2 = (WFastLoginInfo)WFastLoginInfo.CREATOR.createFromParcel(paramParcel1);
        } else {
          localObject2 = null;
        }
        paramInt1 = GetA1WithA1(str, (String)localObject3, l1, l2, (byte[])localObject4, l3, l4, l5, arrayOfByte1, arrayOfByte2, (WUserSigInfo)localObject1, (WFastLoginInfo)localObject2, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
        localObject2 = paramParcel1.readString();
        str = paramParcel1.readString();
        l1 = paramParcel1.readLong();
        localObject3 = paramParcel1.createByteArray();
        paramInt1 = paramParcel1.readInt();
        localObject4 = paramParcel1.readArrayList(getClass().getClassLoader());
        if (paramParcel1.readInt() != 0) {
          localObject1 = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);
        } else {
          localObject1 = null;
        }
        paramInt1 = CloseCode((String)localObject2, str, l1, (byte[])localObject3, paramInt1, (List)localObject4, (WUserSigInfo)localObject1, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
        localObject2 = paramParcel1.readString();
        str = paramParcel1.readString();
        l1 = paramParcel1.readLong();
        boolean bool;
        if (paramParcel1.readInt() != 0) {
          bool = true;
        } else {
          bool = false;
        }
        localObject3 = paramParcel1.createByteArray();
        localObject4 = paramParcel1.createIntArray();
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {
          localObject1 = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);
        } else {
          localObject1 = null;
        }
        paramInt1 = VerifyCode((String)localObject2, str, l1, bool, (byte[])localObject3, (int[])localObject4, paramInt1, (WUserSigInfo)localObject1, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
        str = paramParcel1.readString();
        localObject3 = paramParcel1.readString();
        localObject1 = localObject2;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = RefreshPictureData(str, (String)localObject3, (WUserSigInfo)localObject1, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
        localObject2 = paramParcel1.readString();
        str = paramParcel1.readString();
        localObject3 = paramParcel1.createByteArray();
        if (paramParcel1.readInt() != 0) {
          localObject1 = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);
        } else {
          localObject1 = null;
        }
        paramInt1 = CheckPictureAndGetSt((String)localObject2, str, (byte[])localObject3, (WUserSigInfo)localObject1, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
        localObject2 = paramParcel1.readString();
        str = paramParcel1.readString();
        l1 = paramParcel1.readLong();
        l2 = paramParcel1.readLong();
        if (paramParcel1.readInt() != 0) {
          localObject1 = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);
        } else {
          localObject1 = null;
        }
        paramInt1 = GetStWithoutPasswd((String)localObject2, str, l1, l2, (WUserSigInfo)localObject1, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
        removeRemoteHelper(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginService");
      localObject2 = paramParcel1.readString();
      String str = paramParcel1.readString();
      long l1 = paramParcel1.readLong();
      Object localObject3 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject1 = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);
      } else {
        localObject1 = null;
      }
      paramInt1 = GetStWithPasswd((String)localObject2, str, l1, (String)localObject3, (WUserSigInfo)localObject1, IWtloginServiceCallbacker.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    paramParcel2.writeString("com.tencent.qphone.base.remote.IWtloginService");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.remote.IWtloginService.Stub
 * JD-Core Version:    0.7.0.1
 */