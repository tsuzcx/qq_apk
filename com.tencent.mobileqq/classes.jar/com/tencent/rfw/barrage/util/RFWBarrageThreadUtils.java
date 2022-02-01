package com.tencent.rfw.barrage.util;

import android.os.Handler;
import android.os.Looper;

public class RFWBarrageThreadUtils
{
  private static volatile RFWBarrageThreadUtils b;
  private Handler a = new Handler(Looper.getMainLooper());
  
  public static RFWBarrageThreadUtils a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new RFWBarrageThreadUtils();
        }
      }
      finally {}
    }
    return b;
  }
  
  public void a(Runnable paramRunnable)
  {
    Handler localHandler = this.a;
    if (localHandler == null)
    {
      RFWBarrageLogger.b("RFWBarrageThreadUtils", "[post] main handler should not be null.");
      return;
    }
    if (paramRunnable == null)
    {
      RFWBarrageLogger.b("RFWBarrageThreadUtils", "[post] runnable should not be null.");
      return;
    }
    localHandler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.util.RFWBarrageThreadUtils
 * JD-Core Version:    0.7.0.1
 */