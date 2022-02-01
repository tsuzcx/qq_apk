package com.tencent.qphone.base.remote;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class IWtloginServiceCallbacker$Stub$Proxy
  implements IWtloginServiceCallbacker
{
  private IBinder mRemote;
  
  IWtloginServiceCallbacker$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public void OnCheckPictureAndGetSt(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
      localParcel.writeString(paramString);
      localParcel.writeByteArray(paramArrayOfByte1);
      localParcel.writeByteArray(paramArrayOfByte2);
      if (paramWUserSigInfo != null)
      {
        localParcel.writeInt(1);
        paramWUserSigInfo.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      if (paramDevlockInfo != null)
      {
        localParcel.writeInt(1);
        paramDevlockInfo.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      localParcel.writeInt(paramInt);
      if (paramErrMsg != null)
      {
        localParcel.writeInt(1);
        paramErrMsg.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      this.mRemote.transact(3, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void OnCheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
      localParcel.writeString(paramString);
      localParcel.writeByteArray(paramArrayOfByte);
      if (paramWUserSigInfo != null)
      {
        localParcel.writeInt(1);
        paramWUserSigInfo.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      localParcel.writeInt(paramInt);
      if (paramErrMsg != null)
      {
        localParcel.writeInt(1);
        paramErrMsg.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      this.mRemote.transact(10, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void OnCloseCode(String paramString, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
      localParcel.writeString(paramString);
      localParcel.writeByteArray(paramArrayOfByte1);
      localParcel.writeLong(paramLong);
      if (paramWUserSigInfo != null)
      {
        localParcel.writeInt(1);
        paramWUserSigInfo.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      localParcel.writeByteArray(paramArrayOfByte2);
      localParcel.writeInt(paramInt);
      if (paramErrMsg != null)
      {
        localParcel.writeInt(1);
        paramErrMsg.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      this.mRemote.transact(7, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void OnException(String paramString, int paramInt)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
      localParcel.writeString(paramString);
      localParcel.writeInt(paramInt);
      this.mRemote.transact(5, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void OnGetStWithPasswd(String paramString1, long paramLong1, int paramInt1, long paramLong2, String paramString2, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
      localParcel.writeString(paramString1);
      localParcel.writeLong(paramLong1);
      localParcel.writeInt(paramInt1);
      localParcel.writeLong(paramLong2);
      localParcel.writeString(paramString2);
      localParcel.writeByteArray(paramArrayOfByte);
      if (paramWUserSigInfo != null)
      {
        localParcel.writeInt(1);
        paramWUserSigInfo.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      if (paramDevlockInfo != null)
      {
        localParcel.writeInt(1);
        paramDevlockInfo.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      localParcel.writeInt(paramInt2);
      if (paramErrMsg != null)
      {
        localParcel.writeInt(1);
        paramErrMsg.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      this.mRemote.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void OnGetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
      localParcel.writeString(paramString);
      localParcel.writeLong(paramLong1);
      localParcel.writeLong(paramLong2);
      localParcel.writeInt(paramInt1);
      localParcel.writeLong(paramLong3);
      if (paramWUserSigInfo != null)
      {
        localParcel.writeInt(1);
        paramWUserSigInfo.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      localParcel.writeInt(paramInt2);
      if (paramErrMsg != null)
      {
        localParcel.writeInt(1);
        paramErrMsg.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      this.mRemote.transact(2, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void OnRefreshPictureData(String paramString, byte[] paramArrayOfByte, int paramInt, ErrMsg paramErrMsg)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
      localParcel.writeString(paramString);
      localParcel.writeByteArray(paramArrayOfByte);
      localParcel.writeInt(paramInt);
      if (paramErrMsg != null)
      {
        localParcel.writeInt(1);
        paramErrMsg.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      this.mRemote.transact(4, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void OnRefreshSMSData(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
      localParcel.writeString(paramString);
      localParcel.writeLong(paramLong);
      if (paramWUserSigInfo != null)
      {
        localParcel.writeInt(1);
        paramWUserSigInfo.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      localParcel.writeInt(paramInt1);
      localParcel.writeInt(paramInt2);
      localParcel.writeInt(paramInt3);
      if (paramErrMsg != null)
      {
        localParcel.writeInt(1);
        paramErrMsg.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      this.mRemote.transact(9, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void OnVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, List paramList, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
      localParcel.writeString(paramString);
      localParcel.writeByteArray(paramArrayOfByte1);
      localParcel.writeLong(paramLong);
      localParcel.writeList(paramList);
      localParcel.writeByteArray(paramArrayOfByte2);
      localParcel.writeInt(paramInt);
      if (paramErrMsg != null)
      {
        localParcel.writeInt(1);
        paramErrMsg.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      this.mRemote.transact(6, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.tencent.qphone.base.remote.IWtloginServiceCallbacker";
  }
  
  public void onGetA1WithA1(String paramString, long paramLong1, int paramInt1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
      localParcel.writeString(paramString);
      localParcel.writeLong(paramLong1);
      localParcel.writeInt(paramInt1);
      localParcel.writeLong(paramLong2);
      localParcel.writeByteArray(paramArrayOfByte1);
      localParcel.writeLong(paramLong3);
      localParcel.writeLong(paramLong4);
      localParcel.writeLong(paramLong5);
      localParcel.writeByteArray(paramArrayOfByte2);
      localParcel.writeByteArray(paramArrayOfByte3);
      if (paramWUserSigInfo != null)
      {
        localParcel.writeInt(1);
        paramWUserSigInfo.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      if (paramWFastLoginInfo != null)
      {
        localParcel.writeInt(1);
        paramWFastLoginInfo.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      localParcel.writeInt(paramInt2);
      if (paramErrMsg != null)
      {
        localParcel.writeInt(1);
        paramErrMsg.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      try
      {
        this.mRemote.transact(8, localParcel, null, 1);
        localParcel.recycle();
        return;
      }
      finally {}
      localParcel.recycle();
    }
    finally {}
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.remote.IWtloginServiceCallbacker.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */