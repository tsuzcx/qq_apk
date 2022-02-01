package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.qphone.base.util.QLog;

public class SavaLogger
{
  public static void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      boolean bool = "FROM_PIPE".equals(paramString3);
      if (bool)
      {
        if (paramInt1 > 0)
        {
          QLog.e("sava_native_log", 1, new Object[] { "read log from Pipe:", paramString1 });
          return;
        }
        QLog.d("sava_native_log", 2, new Object[] { "read log from Pipe:", paramString1 });
        return;
      }
      if ((paramInt2 >= 0) && (paramInt1 <= 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("sava_native_log", 2, new Object[] { "level:", Integer.valueOf(paramInt1), ",code:", Integer.valueOf(paramInt2), ",info1:", paramString1, ",info2:", paramString2, ",info3:", paramString3 });
        }
      }
      else
      {
        QLog.e("sava_native_log", 1, new Object[] { "level:", Integer.valueOf(paramInt1), ",code:", Integer.valueOf(paramInt2), ",info1:", ApolloUtilImpl.logFilter(paramString1), ",info2:", ApolloUtilImpl.logFilter(paramString2), ",info3:", ApolloUtilImpl.logFilter(paramString3) });
        return;
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("[cmshow]SavaLogUtil", 1, "[printNativeLog]", paramString1);
      return;
    }
    catch (OutOfMemoryError paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]SavaLogUtil", 2, paramString1.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.SavaLogger
 * JD-Core Version:    0.7.0.1
 */