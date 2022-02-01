package com.tencent.mobileqq.shortvideo.dancemachine.utils;

import android.os.Process;
import com.tencent.sveffects.SLog;

public class DanceLog
{
  private static final String TAG = "DanceLog";
  
  private static String getThreadLogSignature()
  {
    return " TName=" + Thread.currentThread().getName() + " ,pid=" + Process.myPid() + ",tid=" + Process.myTid();
  }
  
  public static void print(String paramString1, String paramString2)
  {
    if (SLog.isEnable()) {
      SLog.d("DanceLog", paramString1 + ": " + paramString2);
    }
  }
  
  public static void print(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (SLog.isEnable()) {
      SLog.e("DanceLog", paramString1 + ": " + paramString2, paramThrowable);
    }
  }
  
  public static void printFrameQueue(String paramString1, String paramString2)
  {
    if (SLog.isEnable()) {
      SLog.e("DanceLog", getThreadLogSignature() + " [" + paramString1 + "]: " + paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog
 * JD-Core Version:    0.7.0.1
 */