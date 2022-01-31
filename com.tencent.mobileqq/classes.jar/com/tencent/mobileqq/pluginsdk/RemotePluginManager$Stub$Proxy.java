package com.tencent.mobileqq.pluginsdk;

import android.os.IBinder;
import android.os.Parcel;

class RemotePluginManager$Stub$Proxy
  implements RemotePluginManager
{
  private IBinder mRemote;
  
  RemotePluginManager$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public void cancelInstall(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
      localParcel1.writeString(paramString);
      this.mRemote.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.tencent.mobileqq.pluginsdk.RemotePluginManager";
  }
  
  /* Error */
  public void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener)
  {
    // Byte code:
    //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 28
    //   12: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: aload_1
    //   17: invokevirtual 34	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   20: aload_2
    //   21: ifnull +45 -> 66
    //   24: aload_2
    //   25: invokeinterface 54 1 0
    //   30: astore_1
    //   31: aload_3
    //   32: aload_1
    //   33: invokevirtual 57	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   36: aload_0
    //   37: getfield 15	com/tencent/mobileqq/pluginsdk/RemotePluginManager$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   40: iconst_1
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 40 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 43	android/os/Parcel:readException	()V
    //   56: aload 4
    //   58: invokevirtual 46	android/os/Parcel:recycle	()V
    //   61: aload_3
    //   62: invokevirtual 46	android/os/Parcel:recycle	()V
    //   65: return
    //   66: aconst_null
    //   67: astore_1
    //   68: goto -37 -> 31
    //   71: astore_1
    //   72: aload 4
    //   74: invokevirtual 46	android/os/Parcel:recycle	()V
    //   77: aload_3
    //   78: invokevirtual 46	android/os/Parcel:recycle	()V
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	Proxy
    //   0	83	1	paramString	String
    //   0	83	2	paramOnPluginInstallListener	OnPluginInstallListener
    //   3	75	3	localParcel1	Parcel
    //   7	66	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	20	71	finally
    //   24	31	71	finally
    //   31	56	71	finally
  }
  
  public boolean isPlugininstalled(String paramString)
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
      localParcel1.writeString(paramString);
      this.mRemote.transact(2, localParcel1, localParcel2, 0);
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
  
  public boolean isReady()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.RemotePluginManager");
      this.mRemote.transact(5, localParcel1, localParcel2, 0);
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
  
  /* Error */
  public PluginBaseInfo queryPlugin(String paramString)
  {
    // Byte code:
    //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 28
    //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_2
    //   15: aload_1
    //   16: invokevirtual 34	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: getfield 15	com/tencent/mobileqq/pluginsdk/RemotePluginManager$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   23: iconst_3
    //   24: aload_2
    //   25: aload_3
    //   26: iconst_0
    //   27: invokeinterface 40 5 0
    //   32: pop
    //   33: aload_3
    //   34: invokevirtual 43	android/os/Parcel:readException	()V
    //   37: aload_3
    //   38: invokevirtual 63	android/os/Parcel:readInt	()I
    //   41: ifeq +26 -> 67
    //   44: getstatic 73	com/tencent/mobileqq/pluginsdk/PluginBaseInfo:CREATOR	Landroid/os/Parcelable$Creator;
    //   47: aload_3
    //   48: invokeinterface 79 2 0
    //   53: checkcast 69	com/tencent/mobileqq/pluginsdk/PluginBaseInfo
    //   56: astore_1
    //   57: aload_3
    //   58: invokevirtual 46	android/os/Parcel:recycle	()V
    //   61: aload_2
    //   62: invokevirtual 46	android/os/Parcel:recycle	()V
    //   65: aload_1
    //   66: areturn
    //   67: aconst_null
    //   68: astore_1
    //   69: goto -12 -> 57
    //   72: astore_1
    //   73: aload_3
    //   74: invokevirtual 46	android/os/Parcel:recycle	()V
    //   77: aload_2
    //   78: invokevirtual 46	android/os/Parcel:recycle	()V
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	Proxy
    //   0	83	1	paramString	String
    //   3	75	2	localParcel1	Parcel
    //   7	67	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	57	72	finally
  }
  
  /* Error */
  public void setListener(RemotePluginManager paramRemotePluginManager)
  {
    // Byte code:
    //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 28
    //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +43 -> 58
    //   18: aload_1
    //   19: invokeinterface 82 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 57	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 15	com/tencent/mobileqq/pluginsdk/RemotePluginManager$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   34: bipush 6
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 40 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 43	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 46	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 46	android/os/Parcel:recycle	()V
    //   57: return
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -35 -> 25
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 46	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 46	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	Proxy
    //   0	74	1	paramRemotePluginManager	RemotePluginManager
    //   3	66	2	localParcel1	Parcel
    //   7	58	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	63	finally
    //   18	25	63	finally
    //   25	49	63	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.RemotePluginManager.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */