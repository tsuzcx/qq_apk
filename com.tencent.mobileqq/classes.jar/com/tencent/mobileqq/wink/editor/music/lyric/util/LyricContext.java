package com.tencent.mobileqq.wink.editor.music.lyric.util;

import android.os.Handler;
import com.tencent.mobileqq.wink.editor.music.lyric.common.TimerTaskManager;

public class LyricContext
{
  private static final Singleton<Handler, Void> a = new LyricContext.1();
  private static Singleton<TimerTaskManager, Void> b = new LyricContext.2();
  
  public static TimerTaskManager a()
  {
    return (TimerTaskManager)b.b(null);
  }
  
  public static Handler b()
  {
    return (Handler)a.b(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.util.LyricContext
 * JD-Core Version:    0.7.0.1
 */