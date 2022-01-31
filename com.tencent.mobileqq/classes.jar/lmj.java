import android.os.IBinder;
import android.os.Parcel;

class lmj
  implements lmh
{
  private IBinder a;
  
  lmj(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public void a(int paramInt, String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceLocationCallback");
      localParcel.writeInt(paramInt);
      localParcel.writeString(paramString);
      this.a.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean, com.tencent.av.service.LBSInfo paramLBSInfo)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore 4
    //   7: aload 4
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: iload_1
    //   15: ifeq +47 -> 62
    //   18: aload 4
    //   20: iload_3
    //   21: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   24: aload_2
    //   25: ifnull +42 -> 67
    //   28: aload 4
    //   30: iconst_1
    //   31: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   34: aload_2
    //   35: aload 4
    //   37: iconst_0
    //   38: invokevirtual 52	com/tencent/av/service/LBSInfo:writeToParcel	(Landroid/os/Parcel;I)V
    //   41: aload_0
    //   42: getfield 15	lmj:a	Landroid/os/IBinder;
    //   45: iconst_2
    //   46: aload 4
    //   48: aconst_null
    //   49: iconst_1
    //   50: invokeinterface 42 5 0
    //   55: pop
    //   56: aload 4
    //   58: invokevirtual 45	android/os/Parcel:recycle	()V
    //   61: return
    //   62: iconst_0
    //   63: istore_3
    //   64: goto -46 -> 18
    //   67: aload 4
    //   69: iconst_0
    //   70: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   73: goto -32 -> 41
    //   76: astore_2
    //   77: aload 4
    //   79: invokevirtual 45	android/os/Parcel:recycle	()V
    //   82: aload_2
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	lmj
    //   0	84	1	paramBoolean	boolean
    //   0	84	2	paramLBSInfo	com.tencent.av.service.LBSInfo
    //   1	63	3	i	int
    //   5	73	4	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   7	14	76	finally
    //   18	24	76	finally
    //   28	41	76	finally
    //   41	56	76	finally
    //   67	73	76	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lmj
 * JD-Core Version:    0.7.0.1
 */