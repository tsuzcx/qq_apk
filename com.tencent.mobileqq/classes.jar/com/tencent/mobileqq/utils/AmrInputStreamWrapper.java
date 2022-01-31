package com.tencent.mobileqq.utils;

import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.ptt.processor.IPttProcessor.ProcessData;
import com.tencent.mobileqq.ptt.processor.PttComponentProcessor;
import java.io.PipedInputStream;

public final class AmrInputStreamWrapper
  extends PttComponentProcessor
{
  private static boolean a;
  private int b;
  private int c;
  private int d;
  
  public AmrInputStreamWrapper(Context paramContext)
  {
    super(paramContext);
    if ((!jdField_a_of_type_Boolean) && (SoLoadUtilNew.loadSoByName(paramContext, "amrnb"))) {
      jdField_a_of_type_Boolean = true;
    }
    this.jdField_c_of_type_Int = CreateEncoder();
    this.d = GsmAmrEncoderNew(this.jdField_c_of_type_Int);
    GsmAmrEncoderInitialize(this.d);
  }
  
  public static native int CreateDecoder();
  
  public static native int CreateEncoder();
  
  public static native void GsmAmrDecoderCleanup(int paramInt1, int paramInt2);
  
  public static native int GsmAmrDecoderDecode(int paramInt1, int paramInt2, byte[] paramArrayOfByte1, int paramInt3, byte[] paramArrayOfByte2, int paramInt4);
  
  public static native void GsmAmrDecoderDelete(int paramInt1, int paramInt2);
  
  public static native void GsmAmrDecoderInitialize(int paramInt);
  
  public static native int GsmAmrDecoderNew(int paramInt);
  
  public static native void GsmAmrEncoderCleanup(int paramInt1, int paramInt2);
  
  public static native void GsmAmrEncoderDelete(int paramInt1, int paramInt2);
  
  public static native int GsmAmrEncoderEncode(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, int paramInt4, byte[] paramArrayOfByte2, int paramInt5);
  
  public static native void GsmAmrEncoderInitialize(int paramInt);
  
  public static native int GsmAmrEncoderNew(int paramInt);
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramInt1, paramInt2, paramInt3);
    this.jdField_a_of_type_Int = 320;
    this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
    this.jdField_c_of_type_ArrayOfByte = new byte[960];
    this.jdField_a_of_type_ComTencentMobileqqPttProcessorIPttProcessor$ProcessData = new IPttProcessor.ProcessData(this.jdField_c_of_type_ArrayOfByte, 0);
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 77	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_a_of_type_JavaIoPipedInputStream	Ljava/io/PipedInputStream;
    //   4: ifnull +10 -> 14
    //   7: aload_0
    //   8: getfield 77	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_a_of_type_JavaIoPipedInputStream	Ljava/io/PipedInputStream;
    //   11: invokevirtual 81	java/io/PipedInputStream:close	()V
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 77	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_a_of_type_JavaIoPipedInputStream	Ljava/io/PipedInputStream;
    //   19: aload_0
    //   20: getfield 36	com/tencent/mobileqq/utils/AmrInputStreamWrapper:d	I
    //   23: ifeq +14 -> 37
    //   26: aload_0
    //   27: getfield 30	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_c_of_type_Int	I
    //   30: aload_0
    //   31: getfield 36	com/tencent/mobileqq/utils/AmrInputStreamWrapper:d	I
    //   34: invokestatic 83	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderCleanup	(II)V
    //   37: aload_0
    //   38: getfield 36	com/tencent/mobileqq/utils/AmrInputStreamWrapper:d	I
    //   41: ifeq +14 -> 55
    //   44: aload_0
    //   45: getfield 30	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_c_of_type_Int	I
    //   48: aload_0
    //   49: getfield 36	com/tencent/mobileqq/utils/AmrInputStreamWrapper:d	I
    //   52: invokestatic 85	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(II)V
    //   55: aload_0
    //   56: iconst_0
    //   57: putfield 36	com/tencent/mobileqq/utils/AmrInputStreamWrapper:d	I
    //   60: return
    //   61: astore_1
    //   62: aload_0
    //   63: iconst_0
    //   64: putfield 36	com/tencent/mobileqq/utils/AmrInputStreamWrapper:d	I
    //   67: aload_1
    //   68: athrow
    //   69: astore_1
    //   70: aload_0
    //   71: getfield 36	com/tencent/mobileqq/utils/AmrInputStreamWrapper:d	I
    //   74: ifeq +14 -> 88
    //   77: aload_0
    //   78: getfield 30	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_c_of_type_Int	I
    //   81: aload_0
    //   82: getfield 36	com/tencent/mobileqq/utils/AmrInputStreamWrapper:d	I
    //   85: invokestatic 85	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(II)V
    //   88: aload_0
    //   89: iconst_0
    //   90: putfield 36	com/tencent/mobileqq/utils/AmrInputStreamWrapper:d	I
    //   93: aload_1
    //   94: athrow
    //   95: astore_1
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 36	com/tencent/mobileqq/utils/AmrInputStreamWrapper:d	I
    //   101: aload_1
    //   102: athrow
    //   103: astore_1
    //   104: aload_0
    //   105: aconst_null
    //   106: putfield 77	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_a_of_type_JavaIoPipedInputStream	Ljava/io/PipedInputStream;
    //   109: aload_0
    //   110: getfield 36	com/tencent/mobileqq/utils/AmrInputStreamWrapper:d	I
    //   113: ifeq +14 -> 127
    //   116: aload_0
    //   117: getfield 30	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_c_of_type_Int	I
    //   120: aload_0
    //   121: getfield 36	com/tencent/mobileqq/utils/AmrInputStreamWrapper:d	I
    //   124: invokestatic 83	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderCleanup	(II)V
    //   127: aload_0
    //   128: getfield 36	com/tencent/mobileqq/utils/AmrInputStreamWrapper:d	I
    //   131: ifeq +14 -> 145
    //   134: aload_0
    //   135: getfield 30	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_c_of_type_Int	I
    //   138: aload_0
    //   139: getfield 36	com/tencent/mobileqq/utils/AmrInputStreamWrapper:d	I
    //   142: invokestatic 85	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(II)V
    //   145: aload_0
    //   146: iconst_0
    //   147: putfield 36	com/tencent/mobileqq/utils/AmrInputStreamWrapper:d	I
    //   150: aload_1
    //   151: athrow
    //   152: astore_1
    //   153: aload_0
    //   154: iconst_0
    //   155: putfield 36	com/tencent/mobileqq/utils/AmrInputStreamWrapper:d	I
    //   158: aload_1
    //   159: athrow
    //   160: astore_1
    //   161: aload_0
    //   162: getfield 36	com/tencent/mobileqq/utils/AmrInputStreamWrapper:d	I
    //   165: ifeq +14 -> 179
    //   168: aload_0
    //   169: getfield 30	com/tencent/mobileqq/utils/AmrInputStreamWrapper:jdField_c_of_type_Int	I
    //   172: aload_0
    //   173: getfield 36	com/tencent/mobileqq/utils/AmrInputStreamWrapper:d	I
    //   176: invokestatic 85	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrEncoderDelete	(II)V
    //   179: aload_0
    //   180: iconst_0
    //   181: putfield 36	com/tencent/mobileqq/utils/AmrInputStreamWrapper:d	I
    //   184: aload_1
    //   185: athrow
    //   186: astore_1
    //   187: aload_0
    //   188: iconst_0
    //   189: putfield 36	com/tencent/mobileqq/utils/AmrInputStreamWrapper:d	I
    //   192: aload_1
    //   193: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	AmrInputStreamWrapper
    //   61	7	1	localObject1	java.lang.Object
    //   69	25	1	localObject2	java.lang.Object
    //   95	7	1	localObject3	java.lang.Object
    //   103	48	1	localObject4	java.lang.Object
    //   152	7	1	localObject5	java.lang.Object
    //   160	25	1	localObject6	java.lang.Object
    //   186	7	1	localObject7	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   37	55	61	finally
    //   19	37	69	finally
    //   70	88	95	finally
    //   0	14	103	finally
    //   127	145	152	finally
    //   109	127	160	finally
    //   161	179	186	finally
  }
  
  protected void finalize()
  {
    if (this.d != 0) {}
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
    if ((this.d == 0) || (this.jdField_c_of_type_Int == 0)) {
      throw new IllegalStateException("not open");
    }
    if (this.jdField_a_of_type_JavaIoPipedInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_Int) == -1) {
      return -1;
    }
    this.b = GsmAmrEncoderEncode(this.jdField_c_of_type_Int, this.d, 1, this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0);
    System.arraycopy(this.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte, paramInt1, this.b);
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AmrInputStreamWrapper
 * JD-Core Version:    0.7.0.1
 */