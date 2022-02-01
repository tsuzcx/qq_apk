package com.tencent.mobileqq.richmedia.mediacodec.utils;

import com.tencent.mobileqq.intervideo.huayang.HuayangCrashReport;
import com.tencent.mobileqq.statistics.CaughtExceptionReport;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class ShortVideoExceptionReporter
{
  private static final String a = HuayangCrashReport.class.getSimpleName();
  
  public static void a(Throwable paramThrowable)
  {
    Throwable localThrowable = new Throwable(paramThrowable);
    try
    {
      arrayOfField = Class.forName("java.lang.Throwable").getDeclaredFields();
      j = arrayOfField.length;
      i = 0;
    }
    catch (Throwable paramThrowable)
    {
      for (;;)
      {
        Field[] arrayOfField;
        int j;
        int i;
        Field localField;
        label110:
        QLog.e(a, 2, "addStackTag failed", paramThrowable);
        continue;
        i += 1;
      }
    }
    if (i < j)
    {
      localField = arrayOfField[i];
      if (!localField.getName().equals("detailMessage")) {
        break label155;
      }
      localField.setAccessible(true);
      if ((paramThrowable.getCause() == null) || (localThrowable.getCause() == null)) {
        break label110;
      }
      localField.set(localThrowable.getCause(), "ShortVideoCatchedException:" + paramThrowable.getCause().getMessage());
    }
    for (;;)
    {
      CaughtExceptionReport.a(localThrowable, "ShortVideo Fail");
      return;
      localField.set(localThrowable, "ShortVideoCatchedException:" + paramThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter
 * JD-Core Version:    0.7.0.1
 */