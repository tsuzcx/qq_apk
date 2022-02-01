package com.tencent.qmsp.sdk.g.d;

import android.os.IBinder;

class a$a$a
  implements a
{
  private IBinder a;
  
  a$a$a(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public java.lang.String a()
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_1
    //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_2
    //   8: aload_1
    //   9: ldc 27
    //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 15	com/tencent/qmsp/sdk/g/d/a$a$a:a	Landroid/os/IBinder;
    //   18: iconst_3
    //   19: aload_1
    //   20: aload_2
    //   21: iconst_0
    //   22: invokeinterface 37 5 0
    //   27: pop
    //   28: aload_2
    //   29: invokevirtual 40	android/os/Parcel:readException	()V
    //   32: aload_2
    //   33: invokevirtual 43	android/os/Parcel:readString	()Ljava/lang/String;
    //   36: astore_3
    //   37: aload_2
    //   38: invokevirtual 46	android/os/Parcel:recycle	()V
    //   41: aload_1
    //   42: invokevirtual 46	android/os/Parcel:recycle	()V
    //   45: aload_3
    //   46: areturn
    //   47: astore_3
    //   48: goto +19 -> 67
    //   51: astore_3
    //   52: aload_3
    //   53: invokevirtual 49	android/os/RemoteException:printStackTrace	()V
    //   56: aload_2
    //   57: invokevirtual 46	android/os/Parcel:recycle	()V
    //   60: aload_1
    //   61: invokevirtual 46	android/os/Parcel:recycle	()V
    //   64: ldc 51
    //   66: areturn
    //   67: aload_2
    //   68: invokevirtual 46	android/os/Parcel:recycle	()V
    //   71: aload_1
    //   72: invokevirtual 46	android/os/Parcel:recycle	()V
    //   75: aload_3
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	a
    //   3	69	1	localParcel1	android.os.Parcel
    //   7	61	2	localParcel2	android.os.Parcel
    //   36	10	3	str	java.lang.String
    //   47	1	3	localObject	Object
    //   51	25	3	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   8	37	47	finally
    //   52	56	47	finally
    //   8	37	51	android/os/RemoteException
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  /* Error */
  public java.lang.String b()
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_1
    //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_2
    //   8: aload_1
    //   9: ldc 27
    //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 15	com/tencent/qmsp/sdk/g/d/a$a$a:a	Landroid/os/IBinder;
    //   18: iconst_5
    //   19: aload_1
    //   20: aload_2
    //   21: iconst_0
    //   22: invokeinterface 37 5 0
    //   27: pop
    //   28: aload_2
    //   29: invokevirtual 40	android/os/Parcel:readException	()V
    //   32: aload_2
    //   33: invokevirtual 43	android/os/Parcel:readString	()Ljava/lang/String;
    //   36: astore_3
    //   37: aload_2
    //   38: invokevirtual 46	android/os/Parcel:recycle	()V
    //   41: aload_1
    //   42: invokevirtual 46	android/os/Parcel:recycle	()V
    //   45: aload_3
    //   46: areturn
    //   47: astore_3
    //   48: goto +19 -> 67
    //   51: astore_3
    //   52: aload_3
    //   53: invokevirtual 49	android/os/RemoteException:printStackTrace	()V
    //   56: aload_2
    //   57: invokevirtual 46	android/os/Parcel:recycle	()V
    //   60: aload_1
    //   61: invokevirtual 46	android/os/Parcel:recycle	()V
    //   64: ldc 51
    //   66: areturn
    //   67: aload_2
    //   68: invokevirtual 46	android/os/Parcel:recycle	()V
    //   71: aload_1
    //   72: invokevirtual 46	android/os/Parcel:recycle	()V
    //   75: aload_3
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	a
    //   3	69	1	localParcel1	android.os.Parcel
    //   7	61	2	localParcel2	android.os.Parcel
    //   36	10	3	str	java.lang.String
    //   47	1	3	localObject	Object
    //   51	25	3	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   8	37	47	finally
    //   52	56	47	finally
    //   8	37	51	android/os/RemoteException
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: iconst_0
    //   10: istore_2
    //   11: aload_3
    //   12: ldc 27
    //   14: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 15	com/tencent/qmsp/sdk/g/d/a$a$a:a	Landroid/os/IBinder;
    //   21: iconst_2
    //   22: aload_3
    //   23: aload 4
    //   25: iconst_0
    //   26: invokeinterface 37 5 0
    //   31: pop
    //   32: aload 4
    //   34: invokevirtual 40	android/os/Parcel:readException	()V
    //   37: aload 4
    //   39: invokevirtual 60	android/os/Parcel:readInt	()I
    //   42: istore_1
    //   43: iload_1
    //   44: ifeq +20 -> 64
    //   47: iconst_1
    //   48: istore_2
    //   49: goto +15 -> 64
    //   52: astore 5
    //   54: goto +21 -> 75
    //   57: astore 5
    //   59: aload 5
    //   61: invokevirtual 49	android/os/RemoteException:printStackTrace	()V
    //   64: aload 4
    //   66: invokevirtual 46	android/os/Parcel:recycle	()V
    //   69: aload_3
    //   70: invokevirtual 46	android/os/Parcel:recycle	()V
    //   73: iload_2
    //   74: ireturn
    //   75: aload 4
    //   77: invokevirtual 46	android/os/Parcel:recycle	()V
    //   80: aload_3
    //   81: invokevirtual 46	android/os/Parcel:recycle	()V
    //   84: aload 5
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	a
    //   42	2	1	i	int
    //   10	64	2	bool	boolean
    //   3	78	3	localParcel1	android.os.Parcel
    //   7	69	4	localParcel2	android.os.Parcel
    //   52	1	5	localObject	Object
    //   57	28	5	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   11	43	52	finally
    //   59	64	52	finally
    //   11	43	57	android/os/RemoteException
  }
  
  /* Error */
  public boolean d()
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: iconst_1
    //   10: istore_2
    //   11: aload_3
    //   12: ldc 27
    //   14: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 15	com/tencent/qmsp/sdk/g/d/a$a$a:a	Landroid/os/IBinder;
    //   21: iconst_1
    //   22: aload_3
    //   23: aload 4
    //   25: iconst_0
    //   26: invokeinterface 37 5 0
    //   31: pop
    //   32: aload 4
    //   34: invokevirtual 40	android/os/Parcel:readException	()V
    //   37: aload 4
    //   39: invokevirtual 60	android/os/Parcel:readInt	()I
    //   42: istore_1
    //   43: iload_1
    //   44: ifeq +18 -> 62
    //   47: goto +17 -> 64
    //   50: astore 5
    //   52: goto +23 -> 75
    //   55: astore 5
    //   57: aload 5
    //   59: invokevirtual 49	android/os/RemoteException:printStackTrace	()V
    //   62: iconst_0
    //   63: istore_2
    //   64: aload 4
    //   66: invokevirtual 46	android/os/Parcel:recycle	()V
    //   69: aload_3
    //   70: invokevirtual 46	android/os/Parcel:recycle	()V
    //   73: iload_2
    //   74: ireturn
    //   75: aload 4
    //   77: invokevirtual 46	android/os/Parcel:recycle	()V
    //   80: aload_3
    //   81: invokevirtual 46	android/os/Parcel:recycle	()V
    //   84: aload 5
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	a
    //   42	2	1	i	int
    //   10	64	2	bool	boolean
    //   3	78	3	localParcel1	android.os.Parcel
    //   7	69	4	localParcel2	android.os.Parcel
    //   50	1	5	localObject	Object
    //   55	30	5	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   11	43	50	finally
    //   57	62	50	finally
    //   11	43	55	android/os/RemoteException
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_1
    //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_2
    //   8: aload_1
    //   9: ldc 27
    //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 15	com/tencent/qmsp/sdk/g/d/a$a$a:a	Landroid/os/IBinder;
    //   18: bipush 6
    //   20: aload_1
    //   21: aload_2
    //   22: iconst_0
    //   23: invokeinterface 37 5 0
    //   28: pop
    //   29: aload_2
    //   30: invokevirtual 40	android/os/Parcel:readException	()V
    //   33: goto +12 -> 45
    //   36: astore_3
    //   37: goto +17 -> 54
    //   40: astore_3
    //   41: aload_3
    //   42: invokevirtual 49	android/os/RemoteException:printStackTrace	()V
    //   45: aload_2
    //   46: invokevirtual 46	android/os/Parcel:recycle	()V
    //   49: aload_1
    //   50: invokevirtual 46	android/os/Parcel:recycle	()V
    //   53: return
    //   54: aload_2
    //   55: invokevirtual 46	android/os/Parcel:recycle	()V
    //   58: aload_1
    //   59: invokevirtual 46	android/os/Parcel:recycle	()V
    //   62: aload_3
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	a
    //   3	56	1	localParcel1	android.os.Parcel
    //   7	48	2	localParcel2	android.os.Parcel
    //   36	1	3	localObject	Object
    //   40	23	3	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   8	33	36	finally
    //   41	45	36	finally
    //   8	33	40	android/os/RemoteException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.d.a.a.a
 * JD-Core Version:    0.7.0.1
 */