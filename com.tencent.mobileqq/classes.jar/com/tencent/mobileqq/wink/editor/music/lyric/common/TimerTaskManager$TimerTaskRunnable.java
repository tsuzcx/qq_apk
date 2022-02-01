package com.tencent.mobileqq.wink.editor.music.lyric.common;

public abstract class TimerTaskManager$TimerTaskRunnable
  implements Runnable
{
  private boolean a;
  
  public abstract void a();
  
  public boolean b()
  {
    return this.a ^ true;
  }
  
  public final void run()
  {
    if (this.a) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.common.TimerTaskManager.TimerTaskRunnable
 * JD-Core Version:    0.7.0.1
 */