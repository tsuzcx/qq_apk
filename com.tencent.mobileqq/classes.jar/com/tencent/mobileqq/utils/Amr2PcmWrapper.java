package com.tencent.mobileqq.utils;

import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class Amr2PcmWrapper
{
  private static boolean jdField_a_of_type_Boolean;
  static final int[] jdField_a_of_type_ArrayOfInt = { 12, 13, 15, 17, 19, 20, 26, 31, 5, 0 };
  private int jdField_a_of_type_Int = 14;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private byte[] jdField_b_of_type_ArrayOfByte = new byte[320];
  private int jdField_c_of_type_Int;
  private byte[] jdField_c_of_type_ArrayOfByte;
  private int jdField_d_of_type_Int;
  private byte[] jdField_d_of_type_ArrayOfByte = new byte[1024];
  private int e;
  
  public Amr2PcmWrapper(Context paramContext, int paramInt)
  {
    if ((!jdField_a_of_type_Boolean) && (SoLoadUtilNew.loadSoByName(paramContext, "amrnb"))) {
      jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Int = a(paramInt);
    this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
    this.jdField_c_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
    this.jdField_b_of_type_Int = AmrInputStreamWrapper.CreateDecoder();
    this.jdField_c_of_type_Int = AmrInputStreamWrapper.GsmAmrDecoderNew(this.jdField_b_of_type_Int);
    AmrInputStreamWrapper.GsmAmrDecoderInitialize(this.jdField_c_of_type_Int);
  }
  
  public static int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 8)) {
      return jdField_a_of_type_ArrayOfInt[paramInt] + 1;
    }
    return 14;
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((this.jdField_c_of_type_Int == 0) || (this.jdField_b_of_type_Int == 0)) {
      throw new IllegalStateException("not open");
    }
    if (AmrInputStreamWrapper.GsmAmrDecoderDecode(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, paramArrayOfByte1, 0, paramArrayOfByte2, 0) < 0) {
      b();
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	com/tencent/mobileqq/utils/Amr2PcmWrapper:jdField_c_of_type_Int	I
    //   4: ifeq +14 -> 18
    //   7: aload_0
    //   8: getfield 53	com/tencent/mobileqq/utils/Amr2PcmWrapper:jdField_b_of_type_Int	I
    //   11: aload_0
    //   12: getfield 58	com/tencent/mobileqq/utils/Amr2PcmWrapper:jdField_c_of_type_Int	I
    //   15: invokestatic 80	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrDecoderCleanup	(II)V
    //   18: aload_0
    //   19: getfield 58	com/tencent/mobileqq/utils/Amr2PcmWrapper:jdField_c_of_type_Int	I
    //   22: ifeq +14 -> 36
    //   25: aload_0
    //   26: getfield 53	com/tencent/mobileqq/utils/Amr2PcmWrapper:jdField_b_of_type_Int	I
    //   29: aload_0
    //   30: getfield 58	com/tencent/mobileqq/utils/Amr2PcmWrapper:jdField_c_of_type_Int	I
    //   33: invokestatic 83	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrDecoderDelete	(II)V
    //   36: aload_0
    //   37: iconst_0
    //   38: putfield 58	com/tencent/mobileqq/utils/Amr2PcmWrapper:jdField_c_of_type_Int	I
    //   41: aload_0
    //   42: invokevirtual 76	com/tencent/mobileqq/utils/Amr2PcmWrapper:b	()V
    //   45: return
    //   46: astore_1
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 58	com/tencent/mobileqq/utils/Amr2PcmWrapper:jdField_c_of_type_Int	I
    //   52: aload_1
    //   53: athrow
    //   54: astore_1
    //   55: aload_0
    //   56: getfield 58	com/tencent/mobileqq/utils/Amr2PcmWrapper:jdField_c_of_type_Int	I
    //   59: ifeq +14 -> 73
    //   62: aload_0
    //   63: getfield 53	com/tencent/mobileqq/utils/Amr2PcmWrapper:jdField_b_of_type_Int	I
    //   66: aload_0
    //   67: getfield 58	com/tencent/mobileqq/utils/Amr2PcmWrapper:jdField_c_of_type_Int	I
    //   70: invokestatic 83	com/tencent/mobileqq/utils/AmrInputStreamWrapper:GsmAmrDecoderDelete	(II)V
    //   73: aload_0
    //   74: iconst_0
    //   75: putfield 58	com/tencent/mobileqq/utils/Amr2PcmWrapper:jdField_c_of_type_Int	I
    //   78: aload_1
    //   79: athrow
    //   80: astore_1
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 58	com/tencent/mobileqq/utils/Amr2PcmWrapper:jdField_c_of_type_Int	I
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	Amr2PcmWrapper
    //   46	7	1	localObject1	Object
    //   54	25	1	localObject2	Object
    //   80	7	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   18	36	46	finally
    //   0	18	54	finally
    //   55	73	80	finally
  }
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.jdField_d_of_type_Int + paramInt > 1024) {
      this.jdField_d_of_type_ArrayOfByte = new byte[this.jdField_d_of_type_Int + paramInt];
    }
    if (this.jdField_d_of_type_Int + paramInt < this.jdField_a_of_type_Int)
    {
      System.arraycopy(paramArrayOfByte, 0, this.jdField_c_of_type_ArrayOfByte, this.jdField_d_of_type_Int, paramInt);
      return null;
    }
    System.arraycopy(this.jdField_c_of_type_ArrayOfByte, 0, this.jdField_d_of_type_ArrayOfByte, 0, this.jdField_d_of_type_Int);
    System.arraycopy(paramArrayOfByte, 0, this.jdField_d_of_type_ArrayOfByte, this.jdField_d_of_type_Int, paramInt);
    this.e = (this.jdField_d_of_type_Int + paramInt);
    paramInt = this.e % this.jdField_a_of_type_Int;
    this.jdField_d_of_type_Int = paramInt;
    if (paramInt != 0) {
      System.arraycopy(this.jdField_d_of_type_ArrayOfByte, this.e - paramInt, this.jdField_c_of_type_ArrayOfByte, 0, paramInt);
    }
    paramArrayOfByte = new byte[this.e / this.jdField_a_of_type_Int * 320];
    int i = 0;
    paramInt = 0;
    while (this.e >= this.jdField_a_of_type_Int)
    {
      System.arraycopy(this.jdField_d_of_type_ArrayOfByte, paramInt, this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_Int);
      try
      {
        a(this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte);
        System.arraycopy(this.jdField_b_of_type_ArrayOfByte, 0, paramArrayOfByte, i, this.jdField_b_of_type_ArrayOfByte.length);
        i += this.jdField_b_of_type_ArrayOfByte.length;
        paramInt += this.jdField_a_of_type_Int;
        this.e -= this.jdField_a_of_type_Int;
      }
      catch (IOException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Amr2PcmWrapper", 2, "========mAmr2Pcm.amr2pcmParser==IOException=====", paramArrayOfByte);
        }
        b();
        return null;
      }
    }
    if (i == paramArrayOfByte.length) {
      return paramArrayOfByte;
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public void b()
  {
    this.jdField_d_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.Amr2PcmWrapper
 * JD-Core Version:    0.7.0.1
 */