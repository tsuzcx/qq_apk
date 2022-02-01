package dov.com.qq.im.aeeditor.lyric.common;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.common.TimerTaskManager.TimerTaskRunnable
 * JD-Core Version:    0.7.0.1
 */