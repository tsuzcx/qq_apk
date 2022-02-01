package com.tencent.qmsp.sdk.g.h;

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
    //   15: getfield 15	com/tencent/qmsp/sdk/g/h/a$a$a:a	Landroid/os/IBinder;
    //   18: iconst_1
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
    //   48: goto +18 -> 66
    //   51: astore_3
    //   52: aload_3
    //   53: invokevirtual 49	android/os/RemoteException:printStackTrace	()V
    //   56: aload_2
    //   57: invokevirtual 46	android/os/Parcel:recycle	()V
    //   60: aload_1
    //   61: invokevirtual 46	android/os/Parcel:recycle	()V
    //   64: aconst_null
    //   65: areturn
    //   66: aload_2
    //   67: invokevirtual 46	android/os/Parcel:recycle	()V
    //   70: aload_1
    //   71: invokevirtual 46	android/os/Parcel:recycle	()V
    //   74: aload_3
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	a
    //   3	68	1	localParcel1	android.os.Parcel
    //   7	60	2	localParcel2	android.os.Parcel
    //   36	10	3	str	java.lang.String
    //   47	1	3	localObject	Object
    //   51	24	3	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   8	37	47	finally
    //   52	56	47	finally
    //   8	37	51	android/os/RemoteException
  }
  
  /* Error */
  public java.lang.String a(java.lang.String paramString)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 27
    //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_2
    //   15: aload_1
    //   16: invokevirtual 53	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: getfield 15	com/tencent/qmsp/sdk/g/h/a$a$a:a	Landroid/os/IBinder;
    //   23: iconst_3
    //   24: aload_2
    //   25: aload_3
    //   26: iconst_0
    //   27: invokeinterface 37 5 0
    //   32: pop
    //   33: aload_3
    //   34: invokevirtual 40	android/os/Parcel:readException	()V
    //   37: aload_3
    //   38: invokevirtual 43	android/os/Parcel:readString	()Ljava/lang/String;
    //   41: astore_1
    //   42: aload_3
    //   43: invokevirtual 46	android/os/Parcel:recycle	()V
    //   46: aload_2
    //   47: invokevirtual 46	android/os/Parcel:recycle	()V
    //   50: aload_1
    //   51: areturn
    //   52: astore_1
    //   53: goto +18 -> 71
    //   56: astore_1
    //   57: aload_1
    //   58: invokevirtual 49	android/os/RemoteException:printStackTrace	()V
    //   61: aload_3
    //   62: invokevirtual 46	android/os/Parcel:recycle	()V
    //   65: aload_2
    //   66: invokevirtual 46	android/os/Parcel:recycle	()V
    //   69: aconst_null
    //   70: areturn
    //   71: aload_3
    //   72: invokevirtual 46	android/os/Parcel:recycle	()V
    //   75: aload_2
    //   76: invokevirtual 46	android/os/Parcel:recycle	()V
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	a
    //   0	81	1	paramString	java.lang.String
    //   3	73	2	localParcel1	android.os.Parcel
    //   7	65	3	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   8	42	52	finally
    //   57	61	52	finally
    //   8	42	56	android/os/RemoteException
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.h.a.a.a
 * JD-Core Version:    0.7.0.1
 */