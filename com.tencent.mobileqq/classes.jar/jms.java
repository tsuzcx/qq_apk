import android.os.IBinder;
import android.os.Parcel;
import com.tencent.av.service.IAVServiceCallback;
import com.tencent.av.service.IAVServiceForQQ;

public class jms
  implements IAVServiceForQQ
{
  private IBinder a;
  
  public jms(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public int a(long paramLong, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
      localParcel1.writeLong(paramLong);
      localParcel1.writeInt(paramInt);
      this.a.transact(7, localParcel1, localParcel2, 0);
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
  public com.tencent.av.service.AVPbInfo a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_2
    //   15: aload_1
    //   16: invokevirtual 58	android/os/Parcel:writeByteArray	([B)V
    //   19: aload_0
    //   20: getfield 15	jms:a	Landroid/os/IBinder;
    //   23: bipush 9
    //   25: aload_2
    //   26: aload_3
    //   27: iconst_0
    //   28: invokeinterface 43 5 0
    //   33: pop
    //   34: aload_3
    //   35: invokevirtual 46	android/os/Parcel:readException	()V
    //   38: aload_3
    //   39: invokevirtual 50	android/os/Parcel:readInt	()I
    //   42: ifeq +26 -> 68
    //   45: getstatic 64	com/tencent/av/service/AVPbInfo:CREATOR	Landroid/os/Parcelable$Creator;
    //   48: aload_3
    //   49: invokeinterface 70 2 0
    //   54: checkcast 60	com/tencent/av/service/AVPbInfo
    //   57: astore_1
    //   58: aload_3
    //   59: invokevirtual 53	android/os/Parcel:recycle	()V
    //   62: aload_2
    //   63: invokevirtual 53	android/os/Parcel:recycle	()V
    //   66: aload_1
    //   67: areturn
    //   68: aconst_null
    //   69: astore_1
    //   70: goto -12 -> 58
    //   73: astore_1
    //   74: aload_3
    //   75: invokevirtual 53	android/os/Parcel:recycle	()V
    //   78: aload_2
    //   79: invokevirtual 53	android/os/Parcel:recycle	()V
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	jms
    //   0	84	1	paramArrayOfByte	byte[]
    //   3	76	2	localParcel1	Parcel
    //   7	68	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	58	73	finally
  }
  
  public void a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
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
  
  public void a(long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
      localParcel1.writeLong(paramLong);
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
  
  public void a(long paramLong, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
      localParcel1.writeLong(paramLong);
      localParcel1.writeString(paramString);
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
  
  public void a(IAVServiceCallback paramIAVServiceCallback)
  {
    IBinder localIBinder = null;
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
      if (paramIAVServiceCallback != null) {
        localIBinder = paramIAVServiceCallback.asBinder();
      }
      localParcel.writeStrongBinder(localIBinder);
      this.a.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
      localParcel.writeString(paramString);
      this.a.transact(8, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  /* Error */
  public void a(String paramString, android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: aload_3
    //   5: ldc 25
    //   7: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_3
    //   11: aload_1
    //   12: invokevirtual 74	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   15: aload_2
    //   16: ifnull +34 -> 50
    //   19: aload_3
    //   20: iconst_1
    //   21: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   24: aload_2
    //   25: aload_3
    //   26: iconst_0
    //   27: invokevirtual 91	android/graphics/Bitmap:writeToParcel	(Landroid/os/Parcel;I)V
    //   30: aload_0
    //   31: getfield 15	jms:a	Landroid/os/IBinder;
    //   34: bipush 6
    //   36: aload_3
    //   37: aconst_null
    //   38: iconst_1
    //   39: invokeinterface 43 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 53	android/os/Parcel:recycle	()V
    //   49: return
    //   50: aload_3
    //   51: iconst_0
    //   52: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   55: goto -25 -> 30
    //   58: astore_1
    //   59: aload_3
    //   60: invokevirtual 53	android/os/Parcel:recycle	()V
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	jms
    //   0	65	1	paramString	String
    //   0	65	2	paramBitmap	android.graphics.Bitmap
    //   3	57	3	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   4	15	58	finally
    //   19	30	58	finally
    //   30	45	58	finally
    //   50	55	58	finally
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 0;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      this.a.transact(14, localParcel1, localParcel2, 0);
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
  public void a(boolean paramBoolean, android.app.Notification paramNotification)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore 4
    //   7: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore 5
    //   12: aload 4
    //   14: ldc 25
    //   16: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   19: iload_1
    //   20: ifeq +58 -> 78
    //   23: aload 4
    //   25: iload_3
    //   26: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   29: aload_2
    //   30: ifnull +53 -> 83
    //   33: aload 4
    //   35: iconst_1
    //   36: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   39: aload_2
    //   40: aload 4
    //   42: iconst_0
    //   43: invokevirtual 96	android/app/Notification:writeToParcel	(Landroid/os/Parcel;I)V
    //   46: aload_0
    //   47: getfield 15	jms:a	Landroid/os/IBinder;
    //   50: iconst_5
    //   51: aload 4
    //   53: aload 5
    //   55: iconst_0
    //   56: invokeinterface 43 5 0
    //   61: pop
    //   62: aload 5
    //   64: invokevirtual 46	android/os/Parcel:readException	()V
    //   67: aload 5
    //   69: invokevirtual 53	android/os/Parcel:recycle	()V
    //   72: aload 4
    //   74: invokevirtual 53	android/os/Parcel:recycle	()V
    //   77: return
    //   78: iconst_0
    //   79: istore_3
    //   80: goto -57 -> 23
    //   83: aload 4
    //   85: iconst_0
    //   86: invokevirtual 37	android/os/Parcel:writeInt	(I)V
    //   89: goto -43 -> 46
    //   92: astore_2
    //   93: aload 5
    //   95: invokevirtual 53	android/os/Parcel:recycle	()V
    //   98: aload 4
    //   100: invokevirtual 53	android/os/Parcel:recycle	()V
    //   103: aload_2
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	jms
    //   0	105	1	paramBoolean	boolean
    //   0	105	2	paramNotification	android.app.Notification
    //   1	79	3	i	int
    //   5	94	4	localParcel1	Parcel
    //   10	84	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   12	19	92	finally
    //   23	29	92	finally
    //   33	46	92	finally
    //   46	67	92	finally
    //   83	89	92	finally
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
      localParcel.writeByteArray(paramArrayOfByte);
      this.a.transact(2, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public void b()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
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
  
  public void b(byte[] paramArrayOfByte)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
      localParcel1.writeByteArray(paramArrayOfByte);
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
  
  public void c()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
      this.a.transact(15, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.service.IAVServiceForQQ");
      localParcel1.writeByteArray(paramArrayOfByte);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jms
 * JD-Core Version:    0.7.0.1
 */