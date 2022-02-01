package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.IBinder;
import android.os.Parcel;
import java.util.Map;

class ITPDownloadProxyAidl$Stub$Proxy
  implements ITPDownloadProxyAidl
{
  private IBinder mRemote;
  
  ITPDownloadProxyAidl$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public String getClipPlayUrl(int paramInt1, int paramInt2, int paramInt3)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      localParcel1.writeInt(paramInt3);
      this.mRemote.transact(6, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl";
  }
  
  public String getPlayErrorCodeStr(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(7, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public String getPlayUrl(int paramInt1, int paramInt2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      this.mRemote.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int init(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      localParcel1.writeString(paramString);
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int pauseDownload(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(9, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      return paramInt;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void pushEvent(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(14, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int resumeDownload(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(10, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      return paramInt;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      localParcel1.writeInt(paramInt3);
      localParcel1.writeInt(paramInt4);
      localParcel1.writeInt(paramInt5);
      this.mRemote.transact(17, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean setClipInfo(int paramInt1, int paramInt2, String paramString, TPDownloadParamAidl paramTPDownloadParamAidl)
  {
    boolean bool = true;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        localParcel1.writeInt(paramInt1);
        localParcel1.writeInt(paramInt2);
        localParcel1.writeString(paramString);
        if (paramTPDownloadParamAidl != null)
        {
          localParcel1.writeInt(1);
          paramTPDownloadParamAidl.writeToParcel(localParcel1, 0);
          this.mRemote.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt1 = localParcel2.readInt();
          if (paramInt1 != 0) {
            return bool;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        bool = false;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void setMaxStorageSizeMB(long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      localParcel1.writeLong(paramLong);
      this.mRemote.transact(16, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void setPlayState(int paramInt1, int paramInt2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      this.mRemote.transact(15, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void setUserData(Map paramMap)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      localParcel1.writeMap(paramMap);
      this.mRemote.transact(13, localParcel1, localParcel2, 0);
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
  public int startClipPlay(String paramString, int paramInt, ITPPlayListenerAidl paramITPPlayListenerAidl)
  {
    // Byte code:
    //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 4
    //   5: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 5
    //   10: aload 4
    //   12: ldc 28
    //   14: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload 4
    //   19: aload_1
    //   20: invokevirtual 62	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   23: aload 4
    //   25: iload_2
    //   26: invokevirtual 36	android/os/Parcel:writeInt	(I)V
    //   29: aload_3
    //   30: ifnull +55 -> 85
    //   33: aload_3
    //   34: invokeinterface 98 1 0
    //   39: astore_1
    //   40: aload 4
    //   42: aload_1
    //   43: invokevirtual 101	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   46: aload_0
    //   47: getfield 15	com/tencent/thumbplayer/core/downloadproxy/aidl/ITPDownloadProxyAidl$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   50: iconst_3
    //   51: aload 4
    //   53: aload 5
    //   55: iconst_0
    //   56: invokeinterface 42 5 0
    //   61: pop
    //   62: aload 5
    //   64: invokevirtual 45	android/os/Parcel:readException	()V
    //   67: aload 5
    //   69: invokevirtual 66	android/os/Parcel:readInt	()I
    //   72: istore_2
    //   73: aload 5
    //   75: invokevirtual 52	android/os/Parcel:recycle	()V
    //   78: aload 4
    //   80: invokevirtual 52	android/os/Parcel:recycle	()V
    //   83: iload_2
    //   84: ireturn
    //   85: aconst_null
    //   86: astore_1
    //   87: goto -47 -> 40
    //   90: astore_1
    //   91: aload 5
    //   93: invokevirtual 52	android/os/Parcel:recycle	()V
    //   96: aload 4
    //   98: invokevirtual 52	android/os/Parcel:recycle	()V
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	Proxy
    //   0	103	1	paramString	String
    //   0	103	2	paramInt	int
    //   0	103	3	paramITPPlayListenerAidl	ITPPlayListenerAidl
    //   3	94	4	localParcel1	Parcel
    //   8	84	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	29	90	finally
    //   33	40	90	finally
    //   40	73	90	finally
  }
  
  public int startPlay(String paramString, TPDownloadParamAidl paramTPDownloadParamAidl, ITPPlayListenerAidl paramITPPlayListenerAidl)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        localParcel1.writeString(paramString);
        if (paramTPDownloadParamAidl != null)
        {
          localParcel1.writeInt(1);
          paramTPDownloadParamAidl.writeToParcel(localParcel1, 0);
          if (paramITPPlayListenerAidl != null)
          {
            paramString = paramITPPlayListenerAidl.asBinder();
            localParcel1.writeStrongBinder(paramString);
            this.mRemote.transact(2, localParcel1, localParcel2, 0);
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
        paramString = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public int startPreload(String paramString, TPDownloadParamAidl paramTPDownloadParamAidl, ITPPreLoadListenerAidl paramITPPreLoadListenerAidl)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
        localParcel1.writeString(paramString);
        if (paramTPDownloadParamAidl != null)
        {
          localParcel1.writeInt(1);
          paramTPDownloadParamAidl.writeToParcel(localParcel1, 0);
          if (paramITPPreLoadListenerAidl != null)
          {
            paramString = paramITPPreLoadListenerAidl.asBinder();
            localParcel1.writeStrongBinder(paramString);
            this.mRemote.transact(11, localParcel1, localParcel2, 0);
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
        paramString = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void stopPlay(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(8, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void stopPreload(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(12, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */