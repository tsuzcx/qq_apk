package com.tencent.mobileqq.lyric.common;

public abstract class TimerTaskManager$TimerTaskRunnable
  implements Runnable
{
  private boolean a;
  
  public abstract void a();
  
  public boolean a()
  {
    return !this.a;
  }
  
  public final void run()
  {
    if (this.a) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.common.TimerTaskManager.TimerTaskRunnable
 * JD-Core Version:    0.7.0.1
 */