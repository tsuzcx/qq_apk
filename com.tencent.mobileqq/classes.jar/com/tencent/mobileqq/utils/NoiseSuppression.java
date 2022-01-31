package com.tencent.mobileqq.utils;

public class NoiseSuppression
{
  public static int a;
  private static NoiseSuppression jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression;
  private static boolean jdField_a_of_type_Boolean;
  private int b = nativeCreate();
  
  static
  {
    jdField_a_of_type_Int = 160;
  }
  
  /* Error */
  public static NoiseSuppression a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 26	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression	Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   6: ifnonnull +61 -> 67
    //   9: getstatic 28	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_Boolean	Z
    //   12: ifne +25 -> 37
    //   15: aload_0
    //   16: ldc 30
    //   18: invokestatic 36	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
    //   21: istore_2
    //   22: iload_2
    //   23: ifne +10 -> 33
    //   26: aconst_null
    //   27: astore_0
    //   28: ldc 2
    //   30: monitorexit
    //   31: aload_0
    //   32: areturn
    //   33: iconst_1
    //   34: putstatic 28	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_Boolean	Z
    //   37: new 2	com/tencent/mobileqq/utils/NoiseSuppression
    //   40: dup
    //   41: invokespecial 37	com/tencent/mobileqq/utils/NoiseSuppression:<init>	()V
    //   44: putstatic 26	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression	Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   47: getstatic 40	bdic:jdField_a_of_type_Int	I
    //   50: istore_1
    //   51: getstatic 26	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression	Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   54: iload_1
    //   55: invokevirtual 43	com/tencent/mobileqq/utils/NoiseSuppression:a	(I)I
    //   58: pop
    //   59: getstatic 26	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression	Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   62: iconst_2
    //   63: invokespecial 45	com/tencent/mobileqq/utils/NoiseSuppression:b	(I)I
    //   66: pop
    //   67: getstatic 26	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression	Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   70: astore_0
    //   71: goto -43 -> 28
    //   74: astore_0
    //   75: ldc 2
    //   77: monitorexit
    //   78: aload_0
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	paramContext	android.content.Context
    //   50	5	1	i	int
    //   21	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	22	74	finally
    //   33	37	74	finally
    //   37	67	74	finally
    //   67	71	74	finally
  }
  
  private int b(int paramInt)
  {
    if (this.b != 0) {
      return nativeSetPolicy(this.b, paramInt);
    }
    return -1;
  }
  
  private native int nativeCreate();
  
  private native int nativeInit(int paramInt1, int paramInt2);
  
  private native int nativeProcess(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  private native int nativeRelease(int paramInt);
  
  private native int nativeSetPolicy(int paramInt1, int paramInt2);
  
  public int a()
  {
    if (this.b != 0) {
      return nativeRelease(this.b);
    }
    return -1;
  }
  
  public int a(int paramInt)
  {
    if (this.b != 0)
    {
      jdField_a_of_type_Int = paramInt / 50;
      if (jdField_a_of_type_Int > 320) {
        jdField_a_of_type_Int = 320;
      }
      return nativeInit(this.b, paramInt);
    }
    return -1;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 80) && (paramInt2 != 160) && (paramInt2 != jdField_a_of_type_Int)) {
      throw new IllegalArgumentException();
    }
    if (this.b != 0) {
      return nativeProcess(this.b, paramArrayOfByte, paramInt1, paramInt2);
    }
    return -1;
  }
  
  protected void finalize()
  {
    super.finalize();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.NoiseSuppression
 * JD-Core Version:    0.7.0.1
 */