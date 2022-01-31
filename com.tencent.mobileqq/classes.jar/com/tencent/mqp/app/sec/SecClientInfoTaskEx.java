package com.tencent.mqp.app.sec;

import algy;
import com.tencent.mobileqq.app.ThreadManager;

public class SecClientInfoTaskEx
  implements Runnable
{
  private static String jdField_a_of_type_JavaLangString;
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long = 1L;
  private int b = 1;
  
  public SecClientInfoTaskEx(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  private static byte[] b(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >>> 24) };
  }
  
  public void run()
  {
    ThreadManager.post(new algy(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mqp.app.sec.SecClientInfoTaskEx
 * JD-Core Version:    0.7.0.1
 */