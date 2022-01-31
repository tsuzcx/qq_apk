package com.tencent.mobileqq.lyric.util;

import aekz;
import aela;
import android.os.Handler;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;

public class LyricContext
{
  private static final Singleton a = new aekz();
  private static Singleton b = new aela();
  
  public static Handler a()
  {
    return (Handler)a.b(null);
  }
  
  public static TimerTaskManager a()
  {
    return (TimerTaskManager)b.b(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.util.LyricContext
 * JD-Core Version:    0.7.0.1
 */