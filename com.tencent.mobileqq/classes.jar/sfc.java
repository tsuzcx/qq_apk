import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;

public class sfc
{
  sfj<Bitmap> a;
  
  public sfc(Bitmap paramBitmap, sfk<Bitmap> paramsfk)
  {
    this.a = new sfj(paramBitmap, paramsfk);
    if (QLog.isColorLevel()) {
      sfm.a(toString(), "onCreate", true);
    }
  }
  
  public sfc(sfj<Bitmap> paramsfj)
  {
    paramsfj.a();
    this.a = paramsfj;
    if (QLog.isColorLevel()) {
      sfm.a(toString(), "createFromClone", true);
    }
  }
  
  public Bitmap a()
  {
    if (this.a != null) {
      return (Bitmap)this.a.a();
    }
    azqs.b(null, "dc01160", "", "", "0X80098F1", "0X80098F1", 0, 1, null, null, "", "");
    return null;
  }
  
  public sfc a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        sfm.a(toString(), "clone", true);
      }
      sfc localsfc = new sfc(this.a);
      return localsfc;
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
    //   3: getfield 19	sfc:a	Lsfj;
    //   6: ifnull +34 -> 40
    //   9: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +13 -> 25
    //   15: aload_0
    //   16: invokevirtual 29	sfc:toString	()Ljava/lang/String;
    //   19: ldc 70
    //   21: iconst_1
    //   22: invokestatic 36	sfm:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   25: aload_0
    //   26: getfield 19	sfc:a	Lsfj;
    //   29: invokevirtual 72	sfj:b	()V
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield 19	sfc:a	Lsfj;
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: aload_0
    //   41: invokevirtual 29	sfc:toString	()Ljava/lang/String;
    //   44: ldc 74
    //   46: invokestatic 77	sfm:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: goto -12 -> 37
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	sfc
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
 * Qualified Name:     sfc
 * JD-Core Version:    0.7.0.1
 */