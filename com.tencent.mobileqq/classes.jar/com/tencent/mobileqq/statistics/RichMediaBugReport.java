package com.tencent.mobileqq.statistics;

import android.text.TextUtils;

public class RichMediaBugReport
{
  public static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramString1 = new Exception(paramString1);
    if (paramString2 == null)
    {
      CaughtExceptionReport.a(paramString1);
      return;
    }
    CaughtExceptionReport.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.RichMediaBugReport
 * JD-Core Version:    0.7.0.1
 */