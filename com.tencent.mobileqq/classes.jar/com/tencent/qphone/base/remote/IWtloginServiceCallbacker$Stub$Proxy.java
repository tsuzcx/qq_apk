package com.tencent.qphone.base.remote;

import android.os.IBinder;
import android.os.Parcel;
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
    for (;;)
    {
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
          if (paramDevlockInfo != null)
          {
            localParcel.writeInt(1);
            paramDevlockInfo.writeToParcel(localParcel, 0);
            localParcel.writeInt(paramInt);
            if (paramErrMsg == null) {
              break label141;
            }
            localParcel.writeInt(1);
            paramErrMsg.writeToParcel(localParcel, 0);
            this.mRemote.transact(3, localParcel, null, 1);
          }
        }
        else
        {
          localParcel.writeInt(0);
          continue;
        }
        localParcel.writeInt(0);
      }
      finally
      {
        localParcel.recycle();
      }
      continue;
      label141:
      localParcel.writeInt(0);
    }
  }
  
  public void OnCheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    Parcel localParcel = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
        localParcel.writeString(paramString);
        localParcel.writeByteArray(paramArrayOfByte);
        if (paramWUserSigInfo != null)
        {
          localParcel.writeInt(1);
          paramWUserSigInfo.writeToParcel(localParcel, 0);
          localParcel.writeInt(paramInt);
          if (paramErrMsg != null)
          {
            localParcel.writeInt(1);
            paramErrMsg.writeToParcel(localParcel, 0);
            this.mRemote.transact(10, localParcel, null, 1);
          }
        }
        else
        {
          localParcel.writeInt(0);
          continue;
        }
        localParcel.writeInt(0);
      }
      finally
      {
        localParcel.recycle();
      }
    }
  }
  
  public void OnCloseCode(String paramString, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    Parcel localParcel = Parcel.obtain();
    for (;;)
    {
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
          localParcel.writeByteArray(paramArrayOfByte2);
          localParcel.writeInt(paramInt);
          if (paramErrMsg != null)
          {
            localParcel.writeInt(1);
            paramErrMsg.writeToParcel(localParcel, 0);
            this.mRemote.transact(7, localParcel, null, 1);
          }
        }
        else
        {
          localParcel.writeInt(0);
          continue;
        }
        localParcel.writeInt(0);
      }
      finally
      {
        localParcel.recycle();
      }
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
    for (;;)
    {
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
          if (paramDevlockInfo != null)
          {
            localParcel.writeInt(1);
            paramDevlockInfo.writeToParcel(localParcel, 0);
            localParcel.writeInt(paramInt2);
            if (paramErrMsg == null) {
              break label163;
            }
            localParcel.writeInt(1);
            paramErrMsg.writeToParcel(localParcel, 0);
            this.mRemote.transact(1, localParcel, null, 1);
          }
        }
        else
        {
          localParcel.writeInt(0);
          continue;
        }
        localParcel.writeInt(0);
      }
      finally
      {
        localParcel.recycle();
      }
      continue;
      label163:
      localParcel.writeInt(0);
    }
  }
  
  public void OnGetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    Parcel localParcel = Parcel.obtain();
    for (;;)
    {
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
          localParcel.writeInt(paramInt2);
          if (paramErrMsg != null)
          {
            localParcel.writeInt(1);
            paramErrMsg.writeToParcel(localParcel, 0);
            this.mRemote.transact(2, localParcel, null, 1);
          }
        }
        else
        {
          localParcel.writeInt(0);
          continue;
        }
        localParcel.writeInt(0);
      }
      finally
      {
        localParcel.recycle();
      }
    }
  }
  
  /* Error */
  public void OnRefreshPictureData(String paramString, byte[] paramArrayOfByte, int paramInt, ErrMsg paramErrMsg)
  {
    // Byte code:
    //   0: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 5
    //   5: aload 5
    //   7: ldc 26
    //   9: invokevirtual 30	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   12: aload 5
    //   14: aload_1
    //   15: invokevirtual 33	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   18: aload 5
    //   20: aload_2
    //   21: invokevirtual 37	android/os/Parcel:writeByteArray	([B)V
    //   24: aload 5
    //   26: iload_3
    //   27: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   30: aload 4
    //   32: ifnull +38 -> 70
    //   35: aload 5
    //   37: iconst_1
    //   38: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   41: aload 4
    //   43: aload 5
    //   45: iconst_0
    //   46: invokevirtual 53	oicq/wlogin_sdk/tools/ErrMsg:writeToParcel	(Landroid/os/Parcel;I)V
    //   49: aload_0
    //   50: getfield 15	com/tencent/qphone/base/remote/IWtloginServiceCallbacker$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   53: iconst_4
    //   54: aload 5
    //   56: aconst_null
    //   57: iconst_1
    //   58: invokeinterface 59 5 0
    //   63: pop
    //   64: aload 5
    //   66: invokevirtual 62	android/os/Parcel:recycle	()V
    //   69: return
    //   70: aload 5
    //   72: iconst_0
    //   73: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   76: goto -27 -> 49
    //   79: astore_1
    //   80: aload 5
    //   82: invokevirtual 62	android/os/Parcel:recycle	()V
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	Proxy
    //   0	87	1	paramString	String
    //   0	87	2	paramArrayOfByte	byte[]
    //   0	87	3	paramInt	int
    //   0	87	4	paramErrMsg	ErrMsg
    //   3	78	5	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   5	30	79	finally
    //   35	49	79	finally
    //   49	64	79	finally
    //   70	76	79	finally
  }
  
  public void OnRefreshSMSData(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
  {
    Parcel localParcel = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel.writeInterfaceToken("com.tencent.qphone.base.remote.IWtloginServiceCallbacker");
        localParcel.writeString(paramString);
        localParcel.writeLong(paramLong);
        if (paramWUserSigInfo != null)
        {
          localParcel.writeInt(1);
          paramWUserSigInfo.writeToParcel(localParcel, 0);
          localParcel.writeInt(paramInt1);
          localParcel.writeInt(paramInt2);
          localParcel.writeInt(paramInt3);
          if (paramErrMsg != null)
          {
            localParcel.writeInt(1);
            paramErrMsg.writeToParcel(localParcel, 0);
            this.mRemote.transact(9, localParcel, null, 1);
          }
        }
        else
        {
          localParcel.writeInt(0);
          continue;
        }
        localParcel.writeInt(0);
      }
      finally
      {
        localParcel.recycle();
      }
    }
  }
  
  /* Error */
  public void OnVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, java.util.List paramList, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    // Byte code:
    //   0: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 9
    //   5: aload 9
    //   7: ldc 26
    //   9: invokevirtual 30	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   12: aload 9
    //   14: aload_1
    //   15: invokevirtual 33	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   18: aload 9
    //   20: aload_2
    //   21: invokevirtual 37	android/os/Parcel:writeByteArray	([B)V
    //   24: aload 9
    //   26: lload_3
    //   27: invokevirtual 70	android/os/Parcel:writeLong	(J)V
    //   30: aload 9
    //   32: aload 5
    //   34: invokevirtual 86	android/os/Parcel:writeList	(Ljava/util/List;)V
    //   37: aload 9
    //   39: aload 6
    //   41: invokevirtual 37	android/os/Parcel:writeByteArray	([B)V
    //   44: aload 9
    //   46: iload 7
    //   48: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   51: aload 8
    //   53: ifnull +39 -> 92
    //   56: aload 9
    //   58: iconst_1
    //   59: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   62: aload 8
    //   64: aload 9
    //   66: iconst_0
    //   67: invokevirtual 53	oicq/wlogin_sdk/tools/ErrMsg:writeToParcel	(Landroid/os/Parcel;I)V
    //   70: aload_0
    //   71: getfield 15	com/tencent/qphone/base/remote/IWtloginServiceCallbacker$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   74: bipush 6
    //   76: aload 9
    //   78: aconst_null
    //   79: iconst_1
    //   80: invokeinterface 59 5 0
    //   85: pop
    //   86: aload 9
    //   88: invokevirtual 62	android/os/Parcel:recycle	()V
    //   91: return
    //   92: aload 9
    //   94: iconst_0
    //   95: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   98: goto -28 -> 70
    //   101: astore_1
    //   102: aload 9
    //   104: invokevirtual 62	android/os/Parcel:recycle	()V
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	Proxy
    //   0	109	1	paramString	String
    //   0	109	2	paramArrayOfByte1	byte[]
    //   0	109	3	paramLong	long
    //   0	109	5	paramList	java.util.List
    //   0	109	6	paramArrayOfByte2	byte[]
    //   0	109	7	paramInt	int
    //   0	109	8	paramErrMsg	ErrMsg
    //   3	100	9	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   5	51	101	finally
    //   56	70	101	finally
    //   70	86	101	finally
    //   92	98	101	finally
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
    for (;;)
    {
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
          if (paramWFastLoginInfo != null)
          {
            localParcel.writeInt(1);
            paramWFastLoginInfo.writeToParcel(localParcel, 0);
            localParcel.writeInt(paramInt2);
            if (paramErrMsg == null) {
              break label192;
            }
            localParcel.writeInt(1);
            paramErrMsg.writeToParcel(localParcel, 0);
            this.mRemote.transact(8, localParcel, null, 1);
          }
        }
        else
        {
          localParcel.writeInt(0);
          continue;
        }
        localParcel.writeInt(0);
      }
      finally
      {
        localParcel.recycle();
      }
      continue;
      label192:
      localParcel.writeInt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.IWtloginServiceCallbacker.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */