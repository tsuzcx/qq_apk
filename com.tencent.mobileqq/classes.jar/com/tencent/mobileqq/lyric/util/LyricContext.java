package com.tencent.mobileqq.lyric.util;

import android.os.Handler;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;

public class LyricContext
{
  private static final Singleton<Handler, Void> a = new LyricContext.1();
  private static Singleton<TimerTaskManager, Void> b = new LyricContext.2();
  
  public static Handler a()
  {
    return (Handler)a.get(null);
  }
  
  public static TimerTaskManager a()
  {
    return (TimerTaskManager)b.get(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.util.LyricContext
 * JD-Core Version:    0.7.0.1
 */