package com.tencent.qmsp.sdk.g.g;

import android.os.IBinder;

public class d$a$a
  implements d
{
  public IBinder a;
  
  public d$a$a(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public java.lang.String a(java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 4
    //   5: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 5
    //   10: aload 4
    //   12: ldc 27
    //   14: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload 4
    //   19: aload_1
    //   20: invokevirtual 34	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   23: aload 4
    //   25: aload_2
    //   26: invokevirtual 34	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   29: aload 4
    //   31: aload_3
    //   32: invokevirtual 34	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 15	com/tencent/qmsp/sdk/g/g/d$a$a:a	Landroid/os/IBinder;
    //   39: iconst_1
    //   40: aload 4
    //   42: aload 5
    //   44: iconst_0
    //   45: invokeinterface 40 5 0
    //   50: pop
    //   51: aload 5
    //   53: invokevirtual 43	android/os/Parcel:readException	()V
    //   56: aload 5
    //   58: invokevirtual 47	android/os/Parcel:readString	()Ljava/lang/String;
    //   61: astore_1
    //   62: goto +24 -> 86
    //   65: astore_1
    //   66: aload 5
    //   68: invokevirtual 50	android/os/Parcel:recycle	()V
    //   71: aload 4
    //   73: invokevirtual 50	android/os/Parcel:recycle	()V
    //   76: aload_1
    //   77: athrow
    //   78: astore_1
    //   79: aload_1
    //   80: invokevirtual 53	android/os/RemoteException:printStackTrace	()V
    //   83: ldc 55
    //   85: astore_1
    //   86: aload 5
    //   88: invokevirtual 50	android/os/Parcel:recycle	()V
    //   91: aload 4
    //   93: invokevirtual 50	android/os/Parcel:recycle	()V
    //   96: aload_1
    //   97: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	a
    //   0	98	1	paramString1	java.lang.String
    //   0	98	2	paramString2	java.lang.String
    //   0	98	3	paramString3	java.lang.String
    //   3	89	4	localParcel1	android.os.Parcel
    //   8	79	5	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   10	62	65	finally
    //   76	78	78	android/os/RemoteException
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.g.d.a.a
 * JD-Core Version:    0.7.0.1
 */