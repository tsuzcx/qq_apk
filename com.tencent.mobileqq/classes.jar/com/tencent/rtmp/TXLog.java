package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog;

public class TXLog
{
  public static void d(String paramString1, String paramString2)
  {
    wrietLogMessage(1, paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    wrietLogMessage(4, paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    wrietLogMessage(2, paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    wrietLogMessage(3, paramString1, paramString2);
  }
  
  private static void wrietLogMessage(int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("thread ID:");
    localStringBuilder.append(Thread.currentThread().getId());
    localStringBuilder.append("|line:");
    localStringBuilder.append(-1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    TXCLog.log(paramInt, paramString1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.TXLog
 * JD-Core Version:    0.7.0.1
 */