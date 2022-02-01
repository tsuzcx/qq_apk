package com.tencent.rfw.barrage.util;

public class RFWBarrageUncaughtExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("barrage crash thread:");
    localStringBuilder.append(paramThread.getName());
    RFWBarrageLogger.a("RFWBarrageManager", localStringBuilder.toString(), paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.util.RFWBarrageUncaughtExceptionHandler
 * JD-Core Version:    0.7.0.1
 */