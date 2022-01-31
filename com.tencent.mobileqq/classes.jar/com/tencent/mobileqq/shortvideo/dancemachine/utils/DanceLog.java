package com.tencent.mobileqq.shortvideo.dancemachine.utils;

import android.os.Process;
import com.tencent.sveffects.SLog;

public class DanceLog
{
  private static String a()
  {
    return " TName=" + Thread.currentThread().getName() + " ,pid=" + Process.myPid() + ",tid=" + Process.myTid();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (SLog.a()) {
      SLog.d("DanceLog", paramString1 + ": " + paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (SLog.a()) {
      SLog.a("DanceLog", paramString1 + ": " + paramString2, paramThrowable);
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (SLog.a()) {
      SLog.a("DanceLog", a() + " [" + paramString1 + "]: " + paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog
 * JD-Core Version:    0.7.0.1
 */