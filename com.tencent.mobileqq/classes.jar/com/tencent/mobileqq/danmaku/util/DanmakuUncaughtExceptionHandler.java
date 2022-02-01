package com.tencent.mobileqq.danmaku.util;

public class DanmakuUncaughtExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Logger.a("DanmakuManager", "danmaku crash thread:" + paramThread.getName(), paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.util.DanmakuUncaughtExceptionHandler
 * JD-Core Version:    0.7.0.1
 */