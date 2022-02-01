package com.tencent.mobileqq.utils;

import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadUtilNew;

public class AudioHelper
{
  private static int jdField_a_of_type_Int = 0;
  private static boolean jdField_a_of_type_Boolean = false;
  
  public static long a(Context paramContext, byte[] paramArrayOfByte, int paramInt, float paramFloat)
  {
    try
    {
      a(paramContext);
      if (jdField_a_of_type_Boolean)
      {
        long l = enlargeVolum(paramArrayOfByte, paramInt, paramFloat);
        return l;
      }
      return 2000L;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  protected static void a(Context paramContext)
  {
    if (!jdField_a_of_type_Boolean)
    {
      int i = jdField_a_of_type_Int;
      if (i < 3)
      {
        jdField_a_of_type_Int = i + 1;
        jdField_a_of_type_Boolean = SoLoadUtilNew.loadSoByName(paramContext, "audiohelper");
      }
    }
  }
  
  @Deprecated
  public static native long enlargeVolum(byte[] paramArrayOfByte, int paramInt, float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AudioHelper
 * JD-Core Version:    0.7.0.1
 */