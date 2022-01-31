package com.tencent.mobileqq.highway.utils;

import com.tencent.qphone.base.util.QLog;

public class BdhLogUtil
{
  public static final String Tag = "BDH_LOG";
  
  public static void LogEvent(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BDH_LOG", 2, paramString1 + ". " + paramString2);
    }
  }
  
  public static void LogException(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("BDH_LOG", 2, paramString1 + ". " + paramString2, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.BdhLogUtil
 * JD-Core Version:    0.7.0.1
 */