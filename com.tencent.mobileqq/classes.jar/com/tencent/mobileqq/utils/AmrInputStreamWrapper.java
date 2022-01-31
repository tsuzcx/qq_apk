package com.tencent.mobileqq.utils;

import android.content.Context;
import awuh;
import awuj;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import java.io.PipedInputStream;

public final class AmrInputStreamWrapper
  extends awuj
{
  private static boolean jdField_a_of_type_Boolean;
  private long jdField_a_of_type_Long;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  
  public AmrInputStreamWrapper(Context paramContext)
  {
    super(paramContext);
    if ((!jdField_a_of_type_Boolean) && (SoLoadUtilNew.loadSoByName(paramContext, "amrnb"))) {
      jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Long = CreateEncoder();
    this.jdField_b_of_type_Long = GsmAmrEncoderNew(this.jdField_a_of_type_Long);
    GsmAmrEncoderInitialize(this.jdField_b_of_type_Long);
  }
  
  public static native int CreateDecoder();
  
  public static native long CreateEncoder();
  
  public static native void GsmAmrDecoderCleanup(long paramLong1, long paramLong2);
  
  public static native int GsmAmrDecoderDecode(long paramLong1, long paramLong2, byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2);
  
  public static native void GsmAmrDecoderDelete(long paramLong1, long paramLong2);
  
  public static native void GsmAmrDecoderInitialize(long paramLong);
  
  public static native long GsmAmrDecoderNew(long paramLong);
  
  public static native void GsmAmrEncoderCleanup(long paramLong1, long paramLong2);
  
  public static native void GsmAmrEncoderDelete(long paramLong1, long paramLong2);
  
  public static native int GsmAmrEncoderEncode(long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3);
  
  public static native void GsmAmrEncoderInitialize(long paramLong);
  
  public static native long GsmAmrEncoderNew(long paramLong);
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramInt1, paramInt2, paramInt3);
    this.jdField_a_of_type_Int = 320;
    this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
    this.c = new byte[960];
    this.jdField_a_of_type_Awuh = new awuh(this.c, 0);
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 78	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_a_of_type_JavaIoPipedInputStream	Ljava/io/PipedInputStream;
    //   4: ifnull +10 -> 14
    //   7: aload_0
    //   8: getfield 78	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_a_of_type_JavaIoPipedInputStream	Ljava/io/PipedInputStream;
    //   11: invokevirtual 82	java/io/PipedInputStream:close	()V
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 78	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_a_of_type_JavaIoPipedInputStream	Ljava/io/PipedInputStream;
    //   19: aload_0
    //   20: getfield 35	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Long	J
    //   23: lconst_0
    //   24: lcmp
    //   25: ifeq +14 -> 39
    //   28: aload_0
    //   29: getfield 29	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_a_of_type_Long	J
    //   32: aload_0
    //   33: getfield 35	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Long	J
    //   36: invokestatic 84	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderCleanup	(JJ)V
    //   39: aload_0
    //   40: getfield 35	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Long	J
    //   43: lconst_0
    //   44: lcmp
    //   45: ifeq +14 -> 59
    //   48: aload_0
    //   49: getfield 29	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_a_of_type_Long	J
    //   52: aload_0
    //   53: getfield 35	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Long	J
    //   56: invokestatic 86	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(JJ)V
    //   59: aload_0
    //   60: lconst_0
    //   61: putfield 35	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Long	J
    //   64: return
    //   65: astore_1
    //   66: aload_0
    //   67: lconst_0
    //   68: putfield 35	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Long	J
    //   71: aload_1
    //   72: athrow
    //   73: astore_1
    //   74: aload_0
    //   75: getfield 35	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Long	J
    //   78: lconst_0
    //   79: lcmp
    //   80: ifeq +14 -> 94
    //   83: aload_0
    //   84: getfield 29	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_a_of_type_Long	J
    //   87: aload_0
    //   88: getfield 35	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Long	J
    //   91: invokestatic 86	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(JJ)V
    //   94: aload_0
    //   95: lconst_0
    //   96: putfield 35	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Long	J
    //   99: aload_1
    //   100: athrow
    //   101: astore_1
    //   102: aload_0
    //   103: lconst_0
    //   104: putfield 35	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Long	J
    //   107: aload_1
    //   108: athrow
    //   109: astore_1
    //   110: aload_0
    //   111: aconst_null
    //   112: putfield 78	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_a_of_type_JavaIoPipedInputStream	Ljava/io/PipedInputStream;
    //   115: aload_0
    //   116: getfield 35	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Long	J
    //   119: lconst_0
    //   120: lcmp
    //   121: ifeq +14 -> 135
    //   124: aload_0
    //   125: getfield 29	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_a_of_type_Long	J
    //   128: aload_0
    //   129: getfield 35	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Long	J
    //   132: invokestatic 84	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderCleanup	(JJ)V
    //   135: aload_0
    //   136: getfield 35	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Long	J
    //   139: lconst_0
    //   140: lcmp
    //   141: ifeq +14 -> 155
    //   144: aload_0
    //   145: getfield 29	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_a_of_type_Long	J
    //   148: aload_0
    //   149: getfield 35	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Long	J
    //   152: invokestatic 86	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(JJ)V
    //   155: aload_0
    //   156: lconst_0
    //   157: putfield 35	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Long	J
    //   160: aload_1
    //   161: athrow
    //   162: astore_1
    //   163: aload_0
    //   164: lconst_0
    //   165: putfield 35	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Long	J
    //   168: aload_1
    //   169: athrow
    //   170: astore_1
    //   171: aload_0
    //   172: getfield 35	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Long	J
    //   175: lconst_0
    //   176: lcmp
    //   177: ifeq +14 -> 191
    //   180: aload_0
    //   181: getfield 29	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_a_of_type_Long	J
    //   184: aload_0
    //   185: getfield 35	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Long	J
    //   188: invokestatic 86	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(JJ)V
    //   191: aload_0
    //   192: lconst_0
    //   193: putfield 35	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Long	J
    //   196: aload_1
    //   197: athrow
    //   198: astore_1
    //   199: aload_0
    //   200: lconst_0
    //   201: putfield 35	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_b_of_type_Long	J
    //   204: aload_1
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	AmrInputStreamWrapper
    //   65	7	1	localObject1	java.lang.Object
    //   73	27	1	localObject2	java.lang.Object
    //   101	7	1	localObject3	java.lang.Object
    //   109	52	1	localObject4	java.lang.Object
    //   162	7	1	localObject5	java.lang.Object
    //   170	27	1	localObject6	java.lang.Object
    //   198	7	1	localObject7	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   39	59	65	finally
    //   19	39	73	finally
    //   74	94	101	finally
    //   0	14	109	finally
    //   135	155	162	finally
    //   115	135	170	finally
    //   171	191	198	finally
  }
  
  protected void finalize()
  {
    if (this.jdField_b_of_type_Long != 0L) {}
    try
    {
      close();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((this.jdField_b_of_type_Long == 0L) || (this.jdField_a_of_type_Long == 0L)) {
      throw new IllegalStateException("not open");
    }
    if (this.jdField_a_of_type_JavaIoPipedInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_Int) == -1) {
      return -1;
    }
    this.jdField_b_of_type_Int = GsmAmrEncoderEncode(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, 1, this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0);
    System.arraycopy(this.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte, paramInt1, this.jdField_b_of_type_Int);
    return this.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AmrInputStreamWrapper
 * JD-Core Version:    0.7.0.1
 */