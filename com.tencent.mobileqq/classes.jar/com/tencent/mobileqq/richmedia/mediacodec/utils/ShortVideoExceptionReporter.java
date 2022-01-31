package com.tencent.mobileqq.richmedia.mediacodec.utils;

import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.intervideo.huayang.HuayangCrashReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ThrowablesUtils;
import java.lang.reflect.Field;

public class ShortVideoExceptionReporter
{
  private static final String a = HuayangCrashReport.class.getSimpleName();
  
  public static void a(Throwable paramThrowable)
  {
    try
    {
      arrayOfField = Class.forName("java.lang.Throwable").getDeclaredFields();
      j = arrayOfField.length;
      i = 0;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Field[] arrayOfField;
        int j;
        int i;
        Field localField;
        label98:
        QLog.e(a, 2, "addStackTag failed", localThrowable);
        continue;
        label143:
        i += 1;
      }
    }
    if (i < j)
    {
      localField = arrayOfField[i];
      if (!localField.getName().equals("detailMessage")) {
        break label143;
      }
      localField.setAccessible(true);
      if (paramThrowable.getCause() == null) {
        break label98;
      }
      localField.set(paramThrowable.getCause(), "ShortVideoCatchedException:" + paramThrowable.getCause().getMessage());
    }
    for (;;)
    {
      CrashReport.handleCatchException(Thread.currentThread(), paramThrowable, ThrowablesUtils.a(paramThrowable), null);
      return;
      localField.set(paramThrowable, "ShortVideoCatchedException:" + paramThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter
 * JD-Core Version:    0.7.0.1
 */