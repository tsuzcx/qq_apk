package dov.com.qq.im.aeeditor.lyric.util;

import android.os.Handler;
import dov.com.qq.im.aeeditor.lyric.common.TimerTaskManager;

public class LyricContext
{
  private static final Singleton<Handler, Void> a = new LyricContext.1();
  private static Singleton<TimerTaskManager, Void> b = new LyricContext.2();
  
  public static Handler a()
  {
    return (Handler)a.b(null);
  }
  
  public static TimerTaskManager a()
  {
    return (TimerTaskManager)b.b(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.util.LyricContext
 * JD-Core Version:    0.7.0.1
 */