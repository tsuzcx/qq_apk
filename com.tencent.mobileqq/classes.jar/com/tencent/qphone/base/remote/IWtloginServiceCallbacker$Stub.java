package com.tencent.qphone.base.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public abstract class IWtloginServiceCallbacker$Stub
  extends Binder
  implements IWtloginServiceCallbacker
{
  private static final String DESCRIPTOR = "com.tencent.qphone.base.remote.IWtloginServiceCallbacker";
  static final int TRANSACTION_OnCheckPictureAndGetSt = 3;
  static final int TRANSACTION_OnCheckSMSAndGetSt = 10;
  static final int TRANSACTION_OnCloseCode = 7;
  static final int TRANSACTION_OnException = 5;
  static final int TRANSACTION_OnGetStWithPasswd = 1;
  static final int TRANSACTION_OnGetStWithoutPasswd = 2;
  static final int TRANSACTION_OnRefreshPictureData = 4;
  static final int TRANSACTION_OnRefreshSMSData = 9;
  static final int TRANSACTION_OnVerifyCode = 6;
  static final int TRANSACTION_onGetA1WithA1 = 8;
  
  public IWtloginServiceCallbacker$Stub()
  {
    attachInterface(this, "com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
  }
  
  public static IWtloginServiceCallbacker asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
    if ((localIInterface != null) && ((localIInterface instanceof IWtloginServiceCallbacker))) {
      return (IWtloginServiceCallbacker)localIInterface;
    }
    return new IWtloginServiceCallbacker.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    long l1;
    long l2;
    Object localObject3;
    byte[] arrayOfByte1;
    label200:
    label254:
    long l3;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
      localObject2 = paramParcel1.readString();
      l1 = paramParcel1.readLong();
      paramInt1 = paramParcel1.readInt();
      l2 = paramParcel1.readLong();
      localObject3 = paramParcel1.readString();
      arrayOfByte1 = paramParcel1.createByteArray();
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label254;
        }
        localObject1 = (DevlockInfo)DevlockInfo.CREATOR.createFromParcel(paramParcel1);
        paramInt2 = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          break label260;
        }
      }
      for (paramParcel1 = (ErrMsg)ErrMsg.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        OnGetStWithPasswd((String)localObject2, l1, paramInt1, l2, (String)localObject3, arrayOfByte1, paramParcel2, (DevlockInfo)localObject1, paramInt2, paramParcel1);
        return true;
        paramParcel2 = null;
        break;
        localObject1 = null;
        break label200;
      }
    case 2: 
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
      localObject1 = paramParcel1.readString();
      l1 = paramParcel1.readLong();
      l2 = paramParcel1.readLong();
      paramInt1 = paramParcel1.readInt();
      l3 = paramParcel1.readLong();
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);
        paramInt2 = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          break label370;
        }
      }
      for (paramParcel1 = (ErrMsg)ErrMsg.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        OnGetStWithoutPasswd((String)localObject1, l1, l2, paramInt1, l3, paramParcel2, paramInt2, paramParcel1);
        return true;
        paramParcel2 = null;
        break;
      }
    case 3: 
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.createByteArray();
      arrayOfByte1 = paramParcel1.createByteArray();
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label487;
        }
        localObject1 = (DevlockInfo)DevlockInfo.CREATOR.createFromParcel(paramParcel1);
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          break label493;
        }
      }
      for (paramParcel1 = (ErrMsg)ErrMsg.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        OnCheckPictureAndGetSt((String)localObject2, (byte[])localObject3, arrayOfByte1, paramParcel2, (DevlockInfo)localObject1, paramInt1, paramParcel1);
        return true;
        paramParcel2 = null;
        break;
        localObject1 = null;
        break label440;
      }
    case 4: 
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
      paramParcel2 = paramParcel1.readString();
      localObject1 = paramParcel1.createByteArray();
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (ErrMsg)ErrMsg.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        OnRefreshPictureData(paramParcel2, (byte[])localObject1, paramInt1, paramParcel1);
        return true;
      }
    case 5: 
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
      OnException(paramParcel1.readString(), paramParcel1.readInt());
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
      paramParcel2 = paramParcel1.readString();
      localObject1 = paramParcel1.createByteArray();
      l1 = paramParcel1.readLong();
      localObject2 = paramParcel1.readArrayList(getClass().getClassLoader());
      localObject3 = paramParcel1.createByteArray();
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (ErrMsg)ErrMsg.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        OnVerifyCode(paramParcel2, (byte[])localObject1, l1, (List)localObject2, (byte[])localObject3, paramInt1, paramParcel1);
        return true;
      }
    case 7: 
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
      localObject1 = paramParcel1.readString();
      localObject2 = paramParcel1.createByteArray();
      l1 = paramParcel1.readLong();
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);
        localObject3 = paramParcel1.createByteArray();
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          break label762;
        }
      }
      for (paramParcel1 = (ErrMsg)ErrMsg.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        OnCloseCode((String)localObject1, (byte[])localObject2, l1, paramParcel2, (byte[])localObject3, paramInt1, paramParcel1);
        return true;
        paramParcel2 = null;
        break;
      }
    case 8: 
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
      localObject2 = paramParcel1.readString();
      l1 = paramParcel1.readLong();
      paramInt1 = paramParcel1.readInt();
      l2 = paramParcel1.readLong();
      localObject3 = paramParcel1.createByteArray();
      l3 = paramParcel1.readLong();
      long l4 = paramParcel1.readLong();
      long l5 = paramParcel1.readLong();
      arrayOfByte1 = paramParcel1.createByteArray();
      byte[] arrayOfByte2 = paramParcel1.createByteArray();
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label935;
        }
        localObject1 = (WFastLoginInfo)WFastLoginInfo.CREATOR.createFromParcel(paramParcel1);
        paramInt2 = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          break label941;
        }
      }
      for (paramParcel1 = (ErrMsg)ErrMsg.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        onGetA1WithA1((String)localObject2, l1, paramInt1, l2, (byte[])localObject3, l3, l4, l5, arrayOfByte1, arrayOfByte2, paramParcel2, (WFastLoginInfo)localObject1, paramInt2, paramParcel1);
        return true;
        paramParcel2 = null;
        break;
        localObject1 = null;
        break label873;
      }
    case 9: 
      label260:
      label370:
      label762:
      paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
      label440:
      label487:
      label493:
      localObject1 = paramParcel1.readString();
      label873:
      l1 = paramParcel1.readLong();
      label935:
      label941:
      int i;
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);
        paramInt1 = paramParcel1.readInt();
        paramInt2 = paramParcel1.readInt();
        i = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          break label1043;
        }
      }
      label1043:
      for (paramParcel1 = (ErrMsg)ErrMsg.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        OnRefreshSMSData((String)localObject1, l1, paramParcel2, paramInt1, paramInt2, i, paramParcel1);
        return true;
        paramParcel2 = null;
        break;
      }
    }
    paramParcel1.enforceInterface("com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
    Object localObject1 = paramParcel1.readString();
    Object localObject2 = paramParcel1.createByteArray();
    if (paramParcel1.readInt() != 0)
    {
      paramParcel2 = (WUserSigInfo)WUserSigInfo.CREATOR.createFromParcel(paramParcel1);
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() == 0) {
        break label1129;
      }
    }
    label1129:
    for (paramParcel1 = (ErrMsg)ErrMsg.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      OnCheckSMSAndGetSt((String)localObject1, (byte[])localObject2, paramParcel2, paramInt1, paramParcel1);
      return true;
      paramParcel2 = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.IWtloginServiceCallbacker.Stub
 * JD-Core Version:    0.7.0.1
 */