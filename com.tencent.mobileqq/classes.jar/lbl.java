import android.support.v4.util.LruCache;

public class lbl
{
  private int jdField_a_of_type_Int;
  LruCache<String, String> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  
  public lbl(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    a();
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = (String)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new lbm(this, this.jdField_a_of_type_Int);
  }
  
  /* Error */
  public void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: getfield 22	lbl:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   7: aload_1
    //   8: invokevirtual 28	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11: ifnonnull +17 -> 28
    //   14: aload_0
    //   15: getfield 22	lbl:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   18: aload_1
    //   19: aload_2
    //   20: invokevirtual 40	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   23: pop
    //   24: ldc 2
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: getfield 22	lbl:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   32: aload_1
    //   33: invokevirtual 43	android/support/v4/util/LruCache:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   36: pop
    //   37: aload_0
    //   38: getfield 22	lbl:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   41: aload_1
    //   42: aload_2
    //   43: invokevirtual 40	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   46: pop
    //   47: goto -23 -> 24
    //   50: astore_1
    //   51: ldc 2
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	lbl
    //   0	56	1	paramString1	String
    //   0	56	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   3	24	50	finally
    //   24	27	50	finally
    //   28	47	50	finally
    //   51	54	50	finally
  }
  
  public void a(String paramString1, String paramString2, long paramLong, Boolean paramBoolean)
  {
    a(lbp.a(paramString1, paramString2, paramLong) + "tween", paramBoolean.toString());
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = a(lbp.a(paramString1, paramString2, paramLong) + "tween");
    if (paramString1 == null) {
      return false;
    }
    return Boolean.valueOf(paramString1).booleanValue();
  }
  
  public void b(String paramString1, String paramString2, long paramLong, Boolean paramBoolean)
  {
    a(lbp.a(paramString1, paramString2, paramLong) + "HasChangeToOriginalText", paramBoolean.toString());
  }
  
  public boolean b(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = a(lbp.a(paramString1, paramString2, paramLong) + "HasChangeToOriginalText");
    if (paramString1 == null) {
      return false;
    }
    return Boolean.valueOf(paramString1).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     lbl
 * JD-Core Version:    0.7.0.1
 */