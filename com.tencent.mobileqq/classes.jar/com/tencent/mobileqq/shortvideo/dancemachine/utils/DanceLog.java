package com.tencent.mobileqq.shortvideo.dancemachine.utils;

import android.os.Process;
import com.tencent.sveffects.SLog;

public class DanceLog
{
  private static final String TAG = "DanceLog";
  
  private static String getThreadLogSignature()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" TName=");
    localStringBuilder.append(Thread.currentThread().getName());
    localStringBuilder.append(" ,pid=");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append(",tid=");
    localStringBuilder.append(Process.myTid());
    return localStringBuilder.toString();
  }
  
  public static void print(String paramString1, String paramString2)
  {
    if (SLog.isEnable())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramString2);
      SLog.d("DanceLog", localStringBuilder.toString());
    }
  }
  
  public static void print(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (SLog.isEnable())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramString2);
      SLog.e("DanceLog", localStringBuilder.toString(), paramThrowable);
    }
  }
  
  public static void printFrameQueue(String paramString1, String paramString2)
  {
    if (SLog.isEnable())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getThreadLogSignature());
      localStringBuilder.append(" [");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("]: ");
      localStringBuilder.append(paramString2);
      SLog.e("DanceLog", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog
 * JD-Core Version:    0.7.0.1
 */