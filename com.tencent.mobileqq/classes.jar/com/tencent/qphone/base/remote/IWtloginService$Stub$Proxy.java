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
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramString1 = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
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
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramString1 = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
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
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramString1 = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
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
          if (paramWFastLoginInfo != null)
          {
            localParcel1.writeInt(1);
            paramWFastLoginInfo.writeToParcel(localParcel1, 0);
            if (paramIWtloginServiceCallbacker == null) {
              break label214;
            }
            paramString1 = paramIWtloginServiceCallbacker.asBinder();
            localParcel1.writeStrongBinder(paramString1);
            this.mRemote.transact(8, localParcel1, localParcel2, 0);
            localParcel2.readException();
            int i = localParcel2.readInt();
            return i;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      continue;
      label214:
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
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramString1 = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
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
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramString1 = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
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
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramString1 = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
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
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramString1 = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public int VerifyCode(String paramString1, String paramString2, long paramLong, boolean paramBoolean, byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt, WUserSigInfo paramWUserSigInfo, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
  {
    int i = 1;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    label179:
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
          localParcel1.writeInt(i);
          localParcel1.writeByteArray(paramArrayOfByte);
          localParcel1.writeIntArray(paramArrayOfInt);
          localParcel1.writeInt(paramInt);
          if (paramWUserSigInfo != null)
          {
            localParcel1.writeInt(1);
            paramWUserSigInfo.writeToParcel(localParcel1, 0);
            if (paramIWtloginServiceCallbacker == null) {
              break label179;
            }
            paramString1 = paramIWtloginServiceCallbacker.asBinder();
            localParcel1.writeStrongBinder(paramString1);
            this.mRemote.transact(6, localParcel1, localParcel2, 0);
            localParcel2.readException();
            paramInt = localParcel2.readInt();
            return paramInt;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        localParcel1.writeInt(0);
        continue;
        paramString1 = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
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
  
  /* Error */
  public void setTestHost(String paramString1, int paramInt, String paramString2, IWtloginServiceCallbacker paramIWtloginServiceCallbacker)
  {
    // Byte code:
    //   0: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 5
    //   5: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 6
    //   10: aload 5
    //   12: ldc 26
    //   14: invokevirtual 30	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload 5
    //   19: aload_1
    //   20: invokevirtual 33	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   23: aload 5
    //   25: iload_2
    //   26: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   29: aload 5
    //   31: aload_3
    //   32: invokevirtual 33	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   35: aload 4
    //   37: ifnull +50 -> 87
    //   40: aload 4
    //   42: invokeinterface 53 1 0
    //   47: astore_1
    //   48: aload 5
    //   50: aload_1
    //   51: invokevirtual 56	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   54: aload_0
    //   55: getfield 15	com/tencent/qphone/base/remote/IWtloginService$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   58: bipush 11
    //   60: aload 5
    //   62: aload 6
    //   64: iconst_0
    //   65: invokeinterface 62 5 0
    //   70: pop
    //   71: aload 6
    //   73: invokevirtual 65	android/os/Parcel:readException	()V
    //   76: aload 6
    //   78: invokevirtual 72	android/os/Parcel:recycle	()V
    //   81: aload 5
    //   83: invokevirtual 72	android/os/Parcel:recycle	()V
    //   86: return
    //   87: aconst_null
    //   88: astore_1
    //   89: goto -41 -> 48
    //   92: astore_1
    //   93: aload 6
    //   95: invokevirtual 72	android/os/Parcel:recycle	()V
    //   98: aload 5
    //   100: invokevirtual 72	android/os/Parcel:recycle	()V
    //   103: aload_1
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	Proxy
    //   0	105	1	paramString1	String
    //   0	105	2	paramInt	int
    //   0	105	3	paramString2	String
    //   0	105	4	paramIWtloginServiceCallbacker	IWtloginServiceCallbacker
    //   3	96	5	localParcel1	Parcel
    //   8	86	6	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	35	92	finally
    //   40	48	92	finally
    //   48	76	92	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.IWtloginService.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */