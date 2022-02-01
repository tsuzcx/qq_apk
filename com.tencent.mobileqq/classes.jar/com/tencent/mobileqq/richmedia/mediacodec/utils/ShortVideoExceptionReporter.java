package com.tencent.mobileqq.richmedia.mediacodec.utils;

import com.tencent.mobileqq.intervideo.huayang.IHuayangCrashReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import java.lang.reflect.Field;

public class ShortVideoExceptionReporter
{
  private static final String a = IHuayangCrashReport.class.getSimpleName();
  
  public static void a(Throwable paramThrowable)
  {
    Throwable localThrowable = new Throwable(paramThrowable);
    try
    {
      Object localObject2 = Class.forName("java.lang.Throwable").getDeclaredFields();
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        Object localObject1 = localObject2[i];
        if (localObject1.getName().equals("detailMessage"))
        {
          localObject1.setAccessible(true);
          localObject2 = paramThrowable.getCause();
          if ((localObject2 != null) && (localThrowable.getCause() != null))
          {
            localObject2 = localThrowable.getCause();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("ShortVideoCatchedException:");
            localStringBuilder.append(paramThrowable.getCause().getMessage());
            localObject1.set(localObject2, localStringBuilder.toString());
            break;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("ShortVideoCatchedException:");
          ((StringBuilder)localObject2).append(paramThrowable.getMessage());
          localObject1.set(localThrowable, ((StringBuilder)localObject2).toString());
          break;
        }
        i += 1;
      }
      return;
    }
    catch (Throwable paramThrowable)
    {
      QLog.e(a, 2, "addStackTag failed", paramThrowable);
      CaughtExceptionReport.a(localThrowable, "ShortVideo Fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter
 * JD-Core Version:    0.7.0.1
 */