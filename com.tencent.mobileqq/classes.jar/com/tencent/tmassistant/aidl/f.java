package com.tencent.tmassistant.aidl;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;
import java.util.Map;

class f
  implements d
{
  private IBinder a;
  
  f(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public int a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
      this.a.transact(1, localParcel1, localParcel2, 0);
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
  
  public int a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, Map paramMap)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      localParcel1.writeInt(paramInt);
      localParcel1.writeString(paramString3);
      localParcel1.writeString(paramString4);
      localParcel1.writeMap(paramMap);
      this.a.transact(8, localParcel1, localParcel2, 0);
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
  
  /* Error */
  public TMAssistantDownloadTaskInfo a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 25
    //   12: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: aload_1
    //   17: invokevirtual 48	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   20: aload_3
    //   21: aload_2
    //   22: invokevirtual 48	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 15	com/tencent/tmassistant/aidl/f:a	Landroid/os/IBinder;
    //   29: bipush 6
    //   31: aload_3
    //   32: aload 4
    //   34: iconst_0
    //   35: invokeinterface 35 5 0
    //   40: pop
    //   41: aload 4
    //   43: invokevirtual 38	android/os/Parcel:readException	()V
    //   46: aload 4
    //   48: invokevirtual 41	android/os/Parcel:readInt	()I
    //   51: ifeq +28 -> 79
    //   54: getstatic 63	com/tencent/tmassistant/aidl/TMAssistantDownloadTaskInfo:CREATOR	Landroid/os/Parcelable$Creator;
    //   57: aload 4
    //   59: invokeinterface 69 2 0
    //   64: checkcast 59	com/tencent/tmassistant/aidl/TMAssistantDownloadTaskInfo
    //   67: astore_1
    //   68: aload 4
    //   70: invokevirtual 44	android/os/Parcel:recycle	()V
    //   73: aload_3
    //   74: invokevirtual 44	android/os/Parcel:recycle	()V
    //   77: aload_1
    //   78: areturn
    //   79: aconst_null
    //   80: astore_1
    //   81: goto -13 -> 68
    //   84: astore_1
    //   85: aload 4
    //   87: invokevirtual 44	android/os/Parcel:recycle	()V
    //   90: aload_3
    //   91: invokevirtual 44	android/os/Parcel:recycle	()V
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	f
    //   0	96	1	paramString1	String
    //   0	96	2	paramString2	String
    //   3	88	3	localParcel1	Parcel
    //   7	79	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	68	84	finally
  }
  
  public List<TMAssistantDownloadTaskInfo> a(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
      localParcel1.writeString(paramString);
      this.a.transact(7, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.createTypedArrayList(TMAssistantDownloadTaskInfo.CREATOR);
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void a(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
      localParcel1.writeInt(paramInt);
      this.a.transact(4, localParcel1, localParcel2, 0);
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
  public void a(String paramString, a parama)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 25
    //   12: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: aload_1
    //   17: invokevirtual 48	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   20: aload_2
    //   21: ifnull +46 -> 67
    //   24: aload_2
    //   25: invokeinterface 83 1 0
    //   30: astore_1
    //   31: aload_3
    //   32: aload_1
    //   33: invokevirtual 86	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   36: aload_0
    //   37: getfield 15	com/tencent/tmassistant/aidl/f:a	Landroid/os/IBinder;
    //   40: bipush 14
    //   42: aload_3
    //   43: aload 4
    //   45: iconst_0
    //   46: invokeinterface 35 5 0
    //   51: pop
    //   52: aload 4
    //   54: invokevirtual 38	android/os/Parcel:readException	()V
    //   57: aload 4
    //   59: invokevirtual 44	android/os/Parcel:recycle	()V
    //   62: aload_3
    //   63: invokevirtual 44	android/os/Parcel:recycle	()V
    //   66: return
    //   67: aconst_null
    //   68: astore_1
    //   69: goto -38 -> 31
    //   72: astore_1
    //   73: aload 4
    //   75: invokevirtual 44	android/os/Parcel:recycle	()V
    //   78: aload_3
    //   79: invokevirtual 44	android/os/Parcel:recycle	()V
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	f
    //   0	84	1	paramString	String
    //   0	84	2	parama	a
    //   3	76	3	localParcel1	Parcel
    //   7	67	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	20	72	finally
    //   24	31	72	finally
    //   31	57	72	finally
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 0;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      this.a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  /* Error */
  public void b(String paramString, a parama)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 25
    //   12: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: aload_1
    //   17: invokevirtual 48	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   20: aload_2
    //   21: ifnull +46 -> 67
    //   24: aload_2
    //   25: invokeinterface 83 1 0
    //   30: astore_1
    //   31: aload_3
    //   32: aload_1
    //   33: invokevirtual 86	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   36: aload_0
    //   37: getfield 15	com/tencent/tmassistant/aidl/f:a	Landroid/os/IBinder;
    //   40: bipush 15
    //   42: aload_3
    //   43: aload 4
    //   45: iconst_0
    //   46: invokeinterface 35 5 0
    //   51: pop
    //   52: aload 4
    //   54: invokevirtual 38	android/os/Parcel:readException	()V
    //   57: aload 4
    //   59: invokevirtual 44	android/os/Parcel:recycle	()V
    //   62: aload_3
    //   63: invokevirtual 44	android/os/Parcel:recycle	()V
    //   66: return
    //   67: aconst_null
    //   68: astore_1
    //   69: goto -38 -> 31
    //   72: astore_1
    //   73: aload 4
    //   75: invokevirtual 44	android/os/Parcel:recycle	()V
    //   78: aload_3
    //   79: invokevirtual 44	android/os/Parcel:recycle	()V
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	f
    //   0	84	1	paramString	String
    //   0	84	2	parama	a
    //   3	76	3	localParcel1	Parcel
    //   7	67	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	20	72	finally
    //   24	31	72	finally
    //   31	57	72	finally
  }
  
  public void b(String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      this.a.transact(9, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    int i = 0;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      this.a.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
      this.a.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void c()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
      this.a.transact(12, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void c(String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      this.a.transact(10, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void d()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
      this.a.transact(13, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void d(String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      this.a.transact(11, localParcel1, localParcel2, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistant.aidl.f
 * JD-Core Version:    0.7.0.1
 */