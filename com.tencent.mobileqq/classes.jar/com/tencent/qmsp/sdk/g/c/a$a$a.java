package com.tencent.qmsp.sdk.g.c;

import android.os.IBinder;

class a$a$a
  implements a
{
  private IBinder a;
  
  a$a$a(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  /* Error */
  public java.lang.String b(java.lang.String paramString)
  {
    // Byte code:
    //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 30
    //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_2
    //   15: aload_1
    //   16: invokevirtual 37	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: getfield 15	com/tencent/qmsp/sdk/g/c/a$a$a:a	Landroid/os/IBinder;
    //   23: iconst_5
    //   24: aload_2
    //   25: aload_3
    //   26: iconst_0
    //   27: invokeinterface 43 5 0
    //   32: pop
    //   33: aload_3
    //   34: invokevirtual 46	android/os/Parcel:readException	()V
    //   37: aload_3
    //   38: invokevirtual 50	android/os/Parcel:readString	()Ljava/lang/String;
    //   41: astore_1
    //   42: aload_3
    //   43: invokevirtual 53	android/os/Parcel:recycle	()V
    //   46: aload_2
    //   47: invokevirtual 53	android/os/Parcel:recycle	()V
    //   50: aload_1
    //   51: areturn
    //   52: astore_1
    //   53: aload_3
    //   54: invokevirtual 53	android/os/Parcel:recycle	()V
    //   57: aload_2
    //   58: invokevirtual 53	android/os/Parcel:recycle	()V
    //   61: aload_1
    //   62: athrow
    //   63: aload_3
    //   64: invokevirtual 53	android/os/Parcel:recycle	()V
    //   67: aload_2
    //   68: invokevirtual 53	android/os/Parcel:recycle	()V
    //   71: aconst_null
    //   72: areturn
    //   73: astore_1
    //   74: goto -11 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	a
    //   0	77	1	paramString	java.lang.String
    //   3	65	2	localParcel1	android.os.Parcel
    //   7	57	3	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   8	42	52	finally
    //   8	42	73	android/os/RemoteException
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: iconst_0
    //   10: istore_2
    //   11: aload_3
    //   12: ldc 30
    //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 15	com/tencent/qmsp/sdk/g/c/a$a$a:a	Landroid/os/IBinder;
    //   21: iconst_3
    //   22: aload_3
    //   23: aload 4
    //   25: iconst_0
    //   26: invokeinterface 43 5 0
    //   31: pop
    //   32: aload 4
    //   34: invokevirtual 46	android/os/Parcel:readException	()V
    //   37: aload 4
    //   39: invokevirtual 59	android/os/Parcel:readInt	()I
    //   42: istore_1
    //   43: iload_1
    //   44: ifeq +22 -> 66
    //   47: iconst_1
    //   48: istore_2
    //   49: goto +17 -> 66
    //   52: astore 5
    //   54: aload 4
    //   56: invokevirtual 53	android/os/Parcel:recycle	()V
    //   59: aload_3
    //   60: invokevirtual 53	android/os/Parcel:recycle	()V
    //   63: aload 5
    //   65: athrow
    //   66: aload 4
    //   68: invokevirtual 53	android/os/Parcel:recycle	()V
    //   71: aload_3
    //   72: invokevirtual 53	android/os/Parcel:recycle	()V
    //   75: iload_2
    //   76: ireturn
    //   77: astore 5
    //   79: goto -13 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	a
    //   42	2	1	i	int
    //   10	66	2	bool	boolean
    //   3	69	3	localParcel1	android.os.Parcel
    //   7	60	4	localParcel2	android.os.Parcel
    //   52	12	5	localObject	Object
    //   77	1	5	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   11	43	52	finally
    //   11	43	77	android/os/RemoteException
  }
  
  /* Error */
  public java.lang.String g()
  {
    // Byte code:
    //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_1
    //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_2
    //   8: aload_1
    //   9: ldc 30
    //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 15	com/tencent/qmsp/sdk/g/c/a$a$a:a	Landroid/os/IBinder;
    //   18: iconst_1
    //   19: aload_1
    //   20: aload_2
    //   21: iconst_0
    //   22: invokeinterface 43 5 0
    //   27: pop
    //   28: aload_2
    //   29: invokevirtual 46	android/os/Parcel:readException	()V
    //   32: aload_2
    //   33: invokevirtual 50	android/os/Parcel:readString	()Ljava/lang/String;
    //   36: astore_3
    //   37: aload_2
    //   38: invokevirtual 53	android/os/Parcel:recycle	()V
    //   41: aload_1
    //   42: invokevirtual 53	android/os/Parcel:recycle	()V
    //   45: aload_3
    //   46: areturn
    //   47: astore_3
    //   48: aload_2
    //   49: invokevirtual 53	android/os/Parcel:recycle	()V
    //   52: aload_1
    //   53: invokevirtual 53	android/os/Parcel:recycle	()V
    //   56: aload_3
    //   57: athrow
    //   58: aload_2
    //   59: invokevirtual 53	android/os/Parcel:recycle	()V
    //   62: aload_1
    //   63: invokevirtual 53	android/os/Parcel:recycle	()V
    //   66: aconst_null
    //   67: areturn
    //   68: astore_3
    //   69: goto -11 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	a
    //   3	60	1	localParcel1	android.os.Parcel
    //   7	52	2	localParcel2	android.os.Parcel
    //   36	10	3	str	java.lang.String
    //   47	10	3	localObject	Object
    //   68	1	3	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   8	37	47	finally
    //   8	37	68	android/os/RemoteException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.c.a.a.a
 * JD-Core Version:    0.7.0.1
 */