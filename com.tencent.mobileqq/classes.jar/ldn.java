import android.content.Context;
import com.rookery.translate.model.TranslateCache.1;
import com.tencent.mobileqq.app.ThreadManager;

public class ldn
{
  private static ldj jdField_a_of_type_Ldj;
  private static ldk jdField_a_of_type_Ldk;
  
  /* Error */
  public static ldj a(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 17	ldn:jdField_a_of_type_Ldj	Lldj;
    //   3: ifnonnull +81 -> 84
    //   6: aload_0
    //   7: ldc 19
    //   9: invokevirtual 25	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   12: checkcast 27	android/app/ActivityManager
    //   15: invokevirtual 31	android/app/ActivityManager:getMemoryClass	()I
    //   18: ldc 32
    //   20: imul
    //   21: bipush 8
    //   23: idiv
    //   24: istore_1
    //   25: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +28 -> 56
    //   31: ldc 40
    //   33: iconst_2
    //   34: new 42	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   41: ldc 45
    //   43: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload_1
    //   47: invokevirtual 52	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: ldc 2
    //   58: monitorenter
    //   59: getstatic 17	ldn:jdField_a_of_type_Ldj	Lldj;
    //   62: astore_2
    //   63: aload_2
    //   64: ifnonnull +17 -> 81
    //   67: new 62	ldj
    //   70: dup
    //   71: aload_0
    //   72: iconst_1
    //   73: iload_1
    //   74: i2l
    //   75: invokespecial 65	ldj:<init>	(Landroid/content/Context;IJ)V
    //   78: putstatic 17	ldn:jdField_a_of_type_Ldj	Lldj;
    //   81: ldc 2
    //   83: monitorexit
    //   84: getstatic 17	ldn:jdField_a_of_type_Ldj	Lldj;
    //   87: areturn
    //   88: astore_0
    //   89: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq -11 -> 81
    //   95: ldc 40
    //   97: iconst_2
    //   98: new 42	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   105: ldc 67
    //   107: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_0
    //   111: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: goto -39 -> 81
    //   123: astore_0
    //   124: ldc 2
    //   126: monitorexit
    //   127: aload_0
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramContext	Context
    //   24	50	1	i	int
    //   62	2	2	localldj	ldj
    // Exception table:
    //   from	to	target	type
    //   67	81	88	java/io/IOException
    //   59	63	123	finally
    //   67	81	123	finally
    //   81	84	123	finally
    //   89	120	123	finally
    //   124	127	123	finally
  }
  
  public static ldk a(Context paramContext)
  {
    try
    {
      if (jdField_a_of_type_Ldk == null) {
        jdField_a_of_type_Ldk = new ldk(65536);
      }
      return jdField_a_of_type_Ldk;
    }
    finally {}
  }
  
  public static ldj b(Context paramContext)
  {
    if (jdField_a_of_type_Ldj == null) {
      ThreadManager.post(new TranslateCache.1(paramContext), 5, null, true);
    }
    return jdField_a_of_type_Ldj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ldn
 * JD-Core Version:    0.7.0.1
 */