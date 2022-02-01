import android.os.IBinder;

class qse
  implements qsc
{
  private IBinder a;
  
  qse(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public void a(boolean paramBoolean, java.lang.String paramString)
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
    //   20: ifeq +47 -> 67
    //   23: aload 4
    //   25: iload_3
    //   26: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   29: aload 4
    //   31: aload_2
    //   32: invokevirtual 36	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 15	qse:a	Landroid/os/IBinder;
    //   39: iconst_1
    //   40: aload 4
    //   42: aload 5
    //   44: iconst_0
    //   45: invokeinterface 42 5 0
    //   50: pop
    //   51: aload 5
    //   53: invokevirtual 45	android/os/Parcel:readException	()V
    //   56: aload 5
    //   58: invokevirtual 48	android/os/Parcel:recycle	()V
    //   61: aload 4
    //   63: invokevirtual 48	android/os/Parcel:recycle	()V
    //   66: return
    //   67: iconst_0
    //   68: istore_3
    //   69: goto -46 -> 23
    //   72: astore_2
    //   73: aload 5
    //   75: invokevirtual 48	android/os/Parcel:recycle	()V
    //   78: aload 4
    //   80: invokevirtual 48	android/os/Parcel:recycle	()V
    //   83: aload_2
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	qse
    //   0	85	1	paramBoolean	boolean
    //   0	85	2	paramString	java.lang.String
    //   1	68	3	i	int
    //   5	74	4	localParcel1	android.os.Parcel
    //   10	64	5	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   12	19	72	finally
    //   23	56	72	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qse
 * JD-Core Version:    0.7.0.1
 */