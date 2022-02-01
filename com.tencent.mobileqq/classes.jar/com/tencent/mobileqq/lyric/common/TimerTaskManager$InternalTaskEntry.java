package com.tencent.mobileqq.lyric.common;

import java.util.concurrent.ScheduledFuture;

class TimerTaskManager$InternalTaskEntry
{
  private Runnable a = new TimerTaskManager.InternalTaskEntry.1(this);
  private long b = -9223372036854775808L;
  private TimerTaskManager.TimerTaskRunnable c;
  private String d;
  private ScheduledFuture<?> e;
  
  public static InternalTaskEntry a(TimerTaskManager.TimerTaskRunnable paramTimerTaskRunnable)
  {
    InternalTaskEntry localInternalTaskEntry = new InternalTaskEntry();
    TimerTaskManager.TimerTaskRunnable.a(paramTimerTaskRunnable, true);
    localInternalTaskEntry.c = paramTimerTaskRunnable;
    return localInternalTaskEntry;
  }
  
  public String toString()
  {
    long l = this.b;
    boolean bool2 = false;
    TimerTaskManager.TimerTaskRunnable localTimerTaskRunnable = this.c;
    boolean bool1 = bool2;
    if (localTimerTaskRunnable != null)
    {
      bool1 = bool2;
      if (TimerTaskManager.TimerTaskRunnable.a(localTimerTaskRunnable)) {
        bool1 = true;
      }
    }
    return String.format("Period = %d; IsValid = %b;", new Object[] { Long.valueOf(l), Boolean.valueOf(bool1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.common.TimerTaskManager.InternalTaskEntry
 * JD-Core Version:    0.7.0.1
 */