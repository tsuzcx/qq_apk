import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;

public class suk
{
  sur<Bitmap> a;
  
  public suk(Bitmap paramBitmap, sus<Bitmap> paramsus)
  {
    this.a = new sur(paramBitmap, paramsus);
    if (QLog.isColorLevel()) {
      suv.a(toString(), "onCreate", true);
    }
  }
  
  public suk(sur<Bitmap> paramsur)
  {
    paramsur.a();
    this.a = paramsur;
    if (QLog.isColorLevel()) {
      suv.a(toString(), "createFromClone", true);
    }
  }
  
  public Bitmap a()
  {
    if (this.a != null) {
      return (Bitmap)this.a.a();
    }
    bdll.b(null, "dc01160", "", "", "0X80098F1", "0X80098F1", 0, 1, null, null, "", "");
    return null;
  }
  
  public suk a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        suv.a(toString(), "clone", true);
      }
      suk localsuk = new suk(this.a);
      return localsuk;
    }
    finally {}
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	suk:a	Lsur;
    //   6: ifnull +34 -> 40
    //   9: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +13 -> 25
    //   15: aload_0
    //   16: invokevirtual 29	suk:toString	()Ljava/lang/String;
    //   19: ldc 70
    //   21: iconst_1
    //   22: invokestatic 36	suv:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   25: aload_0
    //   26: getfield 19	suk:a	Lsur;
    //   29: invokevirtual 72	sur:b	()V
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield 19	suk:a	Lsur;
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: aload_0
    //   41: invokevirtual 29	suk:toString	()Ljava/lang/String;
    //   44: ldc 74
    //   46: invokestatic 77	suv:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: goto -12 -> 37
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	suk
    //   52	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	52	finally
    //   25	37	52	finally
    //   37	39	52	finally
    //   40	49	52	finally
    //   53	55	52	finally
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("zimage.closeable@").append(hashCode()).append("_bitmap@");
    if ((this.a != null) && (this.a.a() != null)) {}
    for (Integer localInteger = Integer.valueOf(((Bitmap)this.a.a()).hashCode());; localInteger = null) {
      return localInteger;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     suk
 * JD-Core Version:    0.7.0.1
 */