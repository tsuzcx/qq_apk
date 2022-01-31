package eipc;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

class EIPCChannel$Stub$Proxy
  implements EIPCChannel
{
  private IBinder mRemote;
  
  EIPCChannel$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public EIPCResult async(String paramString1, String paramString2, Bundle paramBundle, int paramInt1, int paramInt2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("eipc.EIPCChannel");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        if (paramBundle != null)
        {
          localParcel1.writeInt(1);
          paramBundle.writeToParcel(localParcel1, 0);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramString1 = (EIPCResult)EIPCResult.CREATOR.createFromParcel(localParcel2);
            return paramString1;
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
  
  /* Error */
  public void callback(int paramInt, EIPCResult paramEIPCResult)
  {
    // Byte code:
    //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 28
    //   12: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: iload_1
    //   17: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   20: aload_2
    //   21: ifnull +45 -> 66
    //   24: aload_3
    //   25: iconst_1
    //   26: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   29: aload_2
    //   30: aload_3
    //   31: iconst_0
    //   32: invokevirtual 76	eipc/EIPCResult:writeToParcel	(Landroid/os/Parcel;I)V
    //   35: aload_0
    //   36: getfield 15	eipc/EIPCChannel$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   39: bipush 6
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 51 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 54	android/os/Parcel:readException	()V
    //   56: aload 4
    //   58: invokevirtual 73	android/os/Parcel:recycle	()V
    //   61: aload_3
    //   62: invokevirtual 73	android/os/Parcel:recycle	()V
    //   65: return
    //   66: aload_3
    //   67: iconst_0
    //   68: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   71: goto -36 -> 35
    //   74: astore_2
    //   75: aload 4
    //   77: invokevirtual 73	android/os/Parcel:recycle	()V
    //   80: aload_3
    //   81: invokevirtual 73	android/os/Parcel:recycle	()V
    //   84: aload_2
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	Proxy
    //   0	86	1	paramInt	int
    //   0	86	2	paramEIPCResult	EIPCResult
    //   3	78	3	localParcel1	Parcel
    //   7	69	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	20	74	finally
    //   24	35	74	finally
    //   35	56	74	finally
    //   66	71	74	finally
  }
  
  public String getInterfaceDescriptor()
  {
    return "eipc.EIPCChannel";
  }
  
  public String getProcName()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("eipc.EIPCChannel");
      this.mRemote.transact(3, localParcel1, localParcel2, 0);
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
  
  /* Error */
  public int setClient(String paramString, int paramInt1, EIPCChannel paramEIPCChannel, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 5
    //   5: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 6
    //   10: aload 5
    //   12: ldc 28
    //   14: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload 5
    //   19: aload_1
    //   20: invokevirtual 35	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   23: aload 5
    //   25: iload_2
    //   26: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   29: aload_3
    //   30: ifnull +62 -> 92
    //   33: aload_3
    //   34: invokeinterface 86 1 0
    //   39: astore_1
    //   40: aload 5
    //   42: aload_1
    //   43: invokevirtual 89	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   46: aload 5
    //   48: iload 4
    //   50: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   53: aload_0
    //   54: getfield 15	eipc/EIPCChannel$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   57: iconst_4
    //   58: aload 5
    //   60: aload 6
    //   62: iconst_0
    //   63: invokeinterface 51 5 0
    //   68: pop
    //   69: aload 6
    //   71: invokevirtual 54	android/os/Parcel:readException	()V
    //   74: aload 6
    //   76: invokevirtual 58	android/os/Parcel:readInt	()I
    //   79: istore_2
    //   80: aload 6
    //   82: invokevirtual 73	android/os/Parcel:recycle	()V
    //   85: aload 5
    //   87: invokevirtual 73	android/os/Parcel:recycle	()V
    //   90: iload_2
    //   91: ireturn
    //   92: aconst_null
    //   93: astore_1
    //   94: goto -54 -> 40
    //   97: astore_1
    //   98: aload 6
    //   100: invokevirtual 73	android/os/Parcel:recycle	()V
    //   103: aload 5
    //   105: invokevirtual 73	android/os/Parcel:recycle	()V
    //   108: aload_1
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	Proxy
    //   0	110	1	paramString	String
    //   0	110	2	paramInt1	int
    //   0	110	3	paramEIPCChannel	EIPCChannel
    //   0	110	4	paramInt2	int
    //   3	101	5	localParcel1	Parcel
    //   8	91	6	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	29	97	finally
    //   33	40	97	finally
    //   40	80	97	finally
  }
  
  public IBinder setStubBinder(int paramInt, IBinder paramIBinder)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("eipc.EIPCChannel");
      localParcel1.writeInt(paramInt);
      localParcel1.writeStrongBinder(paramIBinder);
      this.mRemote.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramIBinder = localParcel2.readStrongBinder();
      return paramIBinder;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public EIPCResult sync(String paramString1, String paramString2, Bundle paramBundle, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("eipc.EIPCChannel");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        if (paramBundle != null)
        {
          localParcel1.writeInt(1);
          paramBundle.writeToParcel(localParcel1, 0);
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramString1 = (EIPCResult)EIPCResult.CREATOR.createFromParcel(localParcel2);
            return paramString1;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     eipc.EIPCChannel.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */