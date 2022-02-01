package com.tencent.mobileqq.utils;

import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadUtilNew;

public class AudioHelper
{
  private static boolean a = false;
  private static int b;
  
  public static long a(Context paramContext, byte[] paramArrayOfByte, int paramInt, float paramFloat)
  {
    try
    {
      a(paramContext);
      if (a)
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
    if (!a)
    {
      int i = b;
      if (i < 3)
      {
        b = i + 1;
        a = SoLoadUtilNew.loadSoByName(paramContext, "audiohelper");
      }
    }
  }
  
  @Deprecated
  public static native long enlargeVolum(byte[] paramArrayOfByte, int paramInt, float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AudioHelper
 * JD-Core Version:    0.7.0.1
 */