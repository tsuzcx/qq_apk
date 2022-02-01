package com.tencent.mobileqq.danmaku.util;

public class DanmakuUncaughtExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("danmaku crash thread:");
    localStringBuilder.append(paramThread.getName());
    Logger.a("DanmakuManager", localStringBuilder.toString(), paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.util.DanmakuUncaughtExceptionHandler
 * JD-Core Version:    0.7.0.1
 */