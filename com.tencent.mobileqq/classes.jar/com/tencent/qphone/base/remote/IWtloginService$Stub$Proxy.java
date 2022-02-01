package com.tencent.qphone.base.remote;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;

class IWtloginService$Stub$Proxy
  implements IWtloginService
{
  private IBinder mRemote;
  
  IWtloginService$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public int CheckPictureAndGetSt(String paramString1, String paramString2, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginService");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        localParcel1.writeByteArray(paramArrayOfByte);
        if (paramWUserSigInfo != null)
        {
          localParcel1.writeInt(1);
          paramWUserSigInfo.writeToParcel(localParcel1, 0);
        }
        else
        {
          localParcel1.writeInt(0);
        }
        if (paramIWtloginServiceCallbacker != null)
        {
          paramString1 = paramIWtloginServiceCallbacker.asBinder();
          localParcel1.writeStrongBinder(paramString1);
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      paramString1 = null;
    }
  }
  
  public int CheckSMSAndGetSt(String paramString1, String paramString2, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginService");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        localParcel1.writeByteArray(paramArrayOfByte);
        if (paramWUserSigInfo != null)
        {
          localParcel1.writeInt(1);
          paramWUserSigInfo.writeToParcel(localParcel1, 0);
        }
        else
        {
          localParcel1.writeInt(0);
        }
        if (paramIWtloginServiceCallbacker != null)
        {
          paramString1 = paramIWtloginServiceCallbacker.asBinder();
          localParcel1.writeStrongBinder(paramString1);
          this.mRemote.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      paramString1 = null;
    }
  }
  
  public int CloseCode(String paramString1, String paramString2, long paramLong, byte[] paramArrayOfByte, int paramInt, List paramList, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginService");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        localParcel1.writeLong(paramLong);
        localParcel1.writeByteArray(paramArrayOfByte);
        localParcel1.writeInt(paramInt);
        localParcel1.writeList(paramList);
        if (paramWUserSigInfo != null)
        {
          localParcel1.writeInt(1);
          paramWUserSigInfo.writeToParcel(localParcel1, 0);
        }
        else
        {
          localParcel1.writeInt(0);
        }
        if (paramIWtloginServiceCallbacker != null)
        {
          paramString1 = paramIWtloginServiceCallbacker.asBinder();
          localParcel1.writeStrongBinder(paramString1);
          this.mRemote.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          return paramInt;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      paramString1 = null;
    }
  }
  
  public int GetA1WithA1(String paramString1, String paramString2, long paramLong1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginService");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        localParcel1.writeLong(paramLong1);
        localParcel1.writeLong(paramLong2);
        localParcel1.writeByteArray(paramArrayOfByte1);
        localParcel1.writeLong(paramLong3);
        localParcel1.writeLong(paramLong4);
        localParcel1.writeLong(paramLong5);
        localParcel1.writeByteArray(paramArrayOfByte2);
        localParcel1.writeByteArray(paramArrayOfByte3);
        if (paramWUserSigInfo != null)
        {
          localParcel1.writeInt(1);
          paramWUserSigInfo.writeToParcel(localParcel1, 0);
        }
        else
        {
          localParcel1.writeInt(0);
        }
        if (paramWFastLoginInfo != null)
        {
          localParcel1.writeInt(1);
          paramWFastLoginInfo.writeToParcel(localParcel1, 0);
        }
        else
        {
          localParcel1.writeInt(0);
        }
        if (paramIWtloginServiceCallbacker == null) {
          break label221;
        }
        paramString1 = paramIWtloginServiceCallbacker.asBinder();
        localParcel1.writeStrongBinder(paramString1);
        try
        {
          this.mRemote.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          localParcel2.recycle();
          localParcel1.recycle();
          return i;
        }
        finally {}
        localParcel2.recycle();
      }
      finally {}
      localParcel1.recycle();
      throw paramString1;
      label221:
      paramString1 = null;
    }
  }
  
  public int GetStWithPasswd(String paramString1, String paramString2, long paramLong, String paramString3, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginService");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        localParcel1.writeLong(paramLong);
        localParcel1.writeString(paramString3);
        if (paramWUserSigInfo != null)
        {
          localParcel1.writeInt(1);
          paramWUserSigInfo.writeToParcel(localParcel1, 0);
        }
        else
        {
          localParcel1.writeInt(0);
        }
        if (paramIWtloginServiceCallbacker != null)
        {
          paramString1 = paramIWtloginServiceCallbacker.asBinder();
          localParcel1.writeStrongBinder(paramString1);
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      paramString1 = null;
    }
  }
  
  public int GetStWithoutPasswd(String paramString1, String paramString2, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginService");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        localParcel1.writeLong(paramLong1);
        localParcel1.writeLong(paramLong2);
        if (paramWUserSigInfo != null)
        {
          localParcel1.writeInt(1);
          paramWUserSigInfo.writeToParcel(localParcel1, 0);
        }
        else
        {
          localParcel1.writeInt(0);
        }
        if (paramIWtloginServiceCallbacker != null)
        {
          paramString1 = paramIWtloginServiceCallbacker.asBinder();
          localParcel1.writeStrongBinder(paramString1);
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      paramString1 = null;
    }
  }
  
  public int RefreshPictureData(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginService");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        if (paramWUserSigInfo != null)
        {
          localParcel1.writeInt(1);
          paramWUserSigInfo.writeToParcel(localParcel1, 0);
        }
        else
        {
          localParcel1.writeInt(0);
        }
        if (paramIWtloginServiceCallbacker != null)
        {
          paramString1 = paramIWtloginServiceCallbacker.asBinder();
          localParcel1.writeStrongBinder(paramString1);
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      paramString1 = null;
    }
  }
  
  public int RefreshSMSData(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginService");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        if (paramWUserSigInfo != null)
        {
          localParcel1.writeInt(1);
          paramWUserSigInfo.writeToParcel(localParcel1, 0);
        }
        else
        {
          localParcel1.writeInt(0);
        }
        if (paramIWtloginServiceCallbacker != null)
        {
          paramString1 = paramIWtloginServiceCallbacker.asBinder();
          localParcel1.writeStrongBinder(paramString1);
          this.mRemote.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      paramString1 = null;
    }
  }
  
  public int VerifyCode(String paramString1, String paramString2, long paramLong, boolean paramBoolean, byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginService");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        localParcel1.writeLong(paramLong);
        if (paramBoolean)
        {
          i = 1;
          localParcel1.writeInt(i);
          localParcel1.writeByteArray(paramArrayOfByte);
          localParcel1.writeIntArray(paramArrayOfInt);
          localParcel1.writeInt(paramInt);
          if (paramWUserSigInfo != null)
          {
            localParcel1.writeInt(1);
            paramWUserSigInfo.writeToParcel(localParcel1, 0);
          }
          else
          {
            localParcel1.writeInt(0);
          }
          if (paramIWtloginServiceCallbacker == null) {
            break label185;
          }
          paramString1 = paramIWtloginServiceCallbacker.asBinder();
          localParcel1.writeStrongBinder(paramString1);
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          return paramInt;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      int i = 0;
      continue;
      label185:
      paramString1 = null;
    }
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.tencent.qphone.base.remote.IWtloginService";
  }
  
  public void removeRemoteHelper(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginService");
      localParcel1.writeString(paramString);
      this.mRemote.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void setTestHost(String paramString1, int paramInt, String paramString2, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginService");
        localParcel1.writeString(paramString1);
        localParcel1.writeInt(paramInt);
        localParcel1.writeString(paramString2);
        if (paramIWtloginServiceCallbacker != null)
        {
          paramString1 = paramIWtloginServiceCallbacker.asBinder();
          localParcel1.writeStrongBinder(paramString1);
          this.mRemote.transact(11, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      paramString1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.remote.IWtloginService.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */