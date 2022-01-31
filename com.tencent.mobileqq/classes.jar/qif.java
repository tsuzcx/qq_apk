import android.os.IBinder;

class qif
  implements qid
{
  private IBinder a;
  
  qif(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore_3
    //   6: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore 4
    //   11: aload_3
    //   12: ldc 25
    //   14: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: iload_1
    //   18: ifeq +38 -> 56
    //   21: aload_3
    //   22: iload_2
    //   23: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   26: aload_0
    //   27: getfield 15	qif:a	Landroid/os/IBinder;
    //   30: iconst_1
    //   31: aload_3
    //   32: aload 4
    //   34: iconst_0
    //   35: invokeinterface 39 5 0
    //   40: pop
    //   41: aload 4
    //   43: invokevirtual 42	android/os/Parcel:readException	()V
    //   46: aload 4
    //   48: invokevirtual 45	android/os/Parcel:recycle	()V
    //   51: aload_3
    //   52: invokevirtual 45	android/os/Parcel:recycle	()V
    //   55: return
    //   56: iconst_0
    //   57: istore_2
    //   58: goto -37 -> 21
    //   61: astore 5
    //   63: aload 4
    //   65: invokevirtual 45	android/os/Parcel:recycle	()V
    //   68: aload_3
    //   69: invokevirtual 45	android/os/Parcel:recycle	()V
    //   72: aload 5
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	qif
    //   0	75	1	paramBoolean	boolean
    //   1	57	2	i	int
    //   5	64	3	localParcel1	android.os.Parcel
    //   9	55	4	localParcel2	android.os.Parcel
    //   61	12	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	17	61	finally
    //   21	46	61	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qif
 * JD-Core Version:    0.7.0.1
 */