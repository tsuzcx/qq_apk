import android.os.IBinder;

class llu
  implements lls
{
  private IBinder a;
  
  llu(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public void a(boolean paramBoolean, com.tencent.av.service.AVRedPacketConfig paramAVRedPacketConfig)
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
    //   38: invokevirtual 39	com/tencent/av/service/AVRedPacketConfig:writeToParcel	(Landroid/os/Parcel;I)V
    //   41: aload_0
    //   42: getfield 15	llu:a	Landroid/os/IBinder;
    //   45: iconst_1
    //   46: aload 4
    //   48: aconst_null
    //   49: iconst_1
    //   50: invokeinterface 45 5 0
    //   55: pop
    //   56: aload 4
    //   58: invokevirtual 48	android/os/Parcel:recycle	()V
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
    //   79: invokevirtual 48	android/os/Parcel:recycle	()V
    //   82: aload_2
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	llu
    //   0	84	1	paramBoolean	boolean
    //   0	84	2	paramAVRedPacketConfig	com.tencent.av.service.AVRedPacketConfig
    //   1	63	3	i	int
    //   5	73	4	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   7	14	76	finally
    //   18	24	76	finally
    //   28	41	76	finally
    //   41	56	76	finally
    //   67	73	76	finally
  }
  
  /* Error */
  public void a(boolean paramBoolean, java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 5
    //   8: aload 5
    //   10: ldc 25
    //   12: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: iload_1
    //   16: ifeq +43 -> 59
    //   19: aload 5
    //   21: iload 4
    //   23: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   26: aload 5
    //   28: aload_2
    //   29: invokevirtual 52	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   32: aload 5
    //   34: aload_3
    //   35: invokevirtual 52	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   38: aload_0
    //   39: getfield 15	llu:a	Landroid/os/IBinder;
    //   42: iconst_2
    //   43: aload 5
    //   45: aconst_null
    //   46: iconst_1
    //   47: invokeinterface 45 5 0
    //   52: pop
    //   53: aload 5
    //   55: invokevirtual 48	android/os/Parcel:recycle	()V
    //   58: return
    //   59: iconst_0
    //   60: istore 4
    //   62: goto -43 -> 19
    //   65: astore_2
    //   66: aload 5
    //   68: invokevirtual 48	android/os/Parcel:recycle	()V
    //   71: aload_2
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	llu
    //   0	73	1	paramBoolean	boolean
    //   0	73	2	paramString1	java.lang.String
    //   0	73	3	paramString2	java.lang.String
    //   1	60	4	i	int
    //   6	61	5	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   8	15	65	finally
    //   19	53	65	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     llu
 * JD-Core Version:    0.7.0.1
 */