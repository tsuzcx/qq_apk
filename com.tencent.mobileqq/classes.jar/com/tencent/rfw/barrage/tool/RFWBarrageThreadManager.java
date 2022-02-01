package com.tencent.rfw.barrage.tool;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.rfw.barrage.inject.RFWBarrageContext;
import com.tencent.rfw.barrage.util.RFWBarrageLogger;
import com.tencent.rfw.barrage.util.RFWBarrageUncaughtExceptionHandler;

public class RFWBarrageThreadManager
{
  private static volatile RFWBarrageThreadManager a;
  private HandlerThread b;
  
  public RFWBarrageThreadManager(RFWBarrageContext paramRFWBarrageContext)
  {
    this.b = new HandlerThread("RFWBarrageDrawThreadPriority", paramRFWBarrageContext.g());
    this.b.setUncaughtExceptionHandler(new RFWBarrageUncaughtExceptionHandler());
    this.b.start();
  }
  
  public static RFWBarrageThreadManager a(RFWBarrageContext paramRFWBarrageContext)
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new RFWBarrageThreadManager(paramRFWBarrageContext);
        }
      }
      finally {}
    }
    return a;
  }
  
  public static void a()
  {
    RFWBarrageLogger.b("RFWBarrageThreadManager", "releaseInstance");
    if (a == null) {
      return;
    }
    try
    {
      if (a == null) {
        return;
      }
      a.d();
      a = null;
      return;
    }
    finally {}
  }
  
  private void d()
  {
    HandlerThread localHandlerThread = this.b;
    if (localHandlerThread == null) {
      return;
    }
    if (!localHandlerThread.isAlive()) {
      return;
    }
    RFWBarrageLogger.b("RFWBarrageThreadManager", "[quitThreadHandler] handle thread interrupt.");
    this.b.interrupt();
  }
  
  public HandlerThread b()
  {
    return this.b;
  }
  
  public Looper c()
  {
    return this.b.getLooper();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.tool.RFWBarrageThreadManager
 * JD-Core Version:    0.7.0.1
 */