package com.tencent.mobileqq.statistics.crash;

import android.os.Looper;
import android.support.annotation.RequiresApi;
import java.util.concurrent.atomic.AtomicBoolean;

public class RenderInSubThreadMonitor
{
  private static final String TAG = "RendererMonitor";
  private static AtomicBoolean sPauseMonitorTemp = new AtomicBoolean(false);
  
  @RequiresApi(api=19)
  public static void checkWithObj(Object paramObject) {}
  
  public static void disableMonitor()
  {
    sPauseMonitorTemp.compareAndSet(false, true);
  }
  
  public static void enableMonitor()
  {
    sPauseMonitorTemp.compareAndSet(true, false);
  }
  
  private static boolean isMainThread()
  {
    return Thread.currentThread() == Looper.getMainLooper().getThread();
  }
  
  private static void throwException(Throwable paramThrowable)
  {
    new RenderInSubThreadMonitor.1(paramThrowable).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.crash.RenderInSubThreadMonitor
 * JD-Core Version:    0.7.0.1
 */