package com.tencent.qmsp.sdk.g.a;

import android.os.IBinder;
import android.os.Parcel;

public class a$a$a
  implements a
{
  public IBinder a;
  
  public a$a$a(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public String c()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
      this.a.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      localParcel2.recycle();
      localParcel1.recycle();
      return str;
    }
    finally
    {
      label47:
      break label47;
    }
    localParcel2.recycle();
    localParcel1.recycle();
    return "";
  }
  
  /* Error */
  public boolean g()
  {
    // Byte code:
    //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: iconst_0
    //   10: istore_2
    //   11: aload_3
    //   12: ldc 28
    //   14: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 15	com/tencent/qmsp/sdk/g/a/a$a$a:a	Landroid/os/IBinder;
    //   21: iconst_1
    //   22: aload_3
    //   23: aload 4
    //   25: iconst_0
    //   26: invokeinterface 38 5 0
    //   31: pop
    //   32: aload 4
    //   34: invokevirtual 41	android/os/Parcel:readException	()V
    //   37: aload 4
    //   39: invokevirtual 57	android/os/Parcel:readInt	()I
    //   42: istore_1
    //   43: iload_1
    //   44: ifne +20 -> 64
    //   47: goto +19 -> 66
    //   50: astore 5
    //   52: aload 4
    //   54: invokevirtual 47	android/os/Parcel:recycle	()V
    //   57: aload_3
    //   58: invokevirtual 47	android/os/Parcel:recycle	()V
    //   61: aload 5
    //   63: athrow
    //   64: iconst_1
    //   65: istore_2
    //   66: aload 4
    //   68: invokevirtual 47	android/os/Parcel:recycle	()V
    //   71: aload_3
    //   72: invokevirtual 47	android/os/Parcel:recycle	()V
    //   75: iload_2
    //   76: ireturn
    //   77: astore 5
    //   79: goto -15 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	a
    //   42	2	1	i	int
    //   10	66	2	bool	boolean
    //   3	69	3	localParcel1	Parcel
    //   7	60	4	localParcel2	Parcel
    //   50	12	5	localObject	Object
    //   77	1	5	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   11	43	50	finally
    //   11	43	77	java/lang/Exception
  }
  
  public String h()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
      this.a.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      localParcel2.recycle();
      localParcel1.recycle();
      return str;
    }
    finally
    {
      label47:
      break label47;
    }
    localParcel2.recycle();
    localParcel1.recycle();
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */