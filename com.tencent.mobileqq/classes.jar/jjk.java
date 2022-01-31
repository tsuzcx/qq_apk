import android.os.IBinder;
import android.os.Parcel;
import com.tencent.av.gvideo.IGVServiceForQQ;
import com.tencent.av.service.IAVServiceCallback;

public class jjk
  implements IGVServiceForQQ
{
  private IBinder a;
  
  public jjk(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public int a(long paramLong, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.gvideo.IGVServiceForQQ");
      localParcel1.writeLong(paramLong);
      localParcel1.writeInt(paramInt);
      this.a.transact(4, localParcel1, localParcel2, 0);
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
  
  public void a()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.gvideo.IGVServiceForQQ");
      this.a.transact(5, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(IAVServiceCallback paramIAVServiceCallback)
  {
    IBinder localIBinder = null;
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.gvideo.IGVServiceForQQ");
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
    //   43: invokevirtual 70	android/app/Notification:writeToParcel	(Landroid/os/Parcel;I)V
    //   46: aload_0
    //   47: getfield 15	jjk:a	Landroid/os/IBinder;
    //   50: iconst_3
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
    //   0	105	0	this	jjk
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
      localParcel.writeInterfaceToken("com.tencent.av.gvideo.IGVServiceForQQ");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jjk
 * JD-Core Version:    0.7.0.1
 */