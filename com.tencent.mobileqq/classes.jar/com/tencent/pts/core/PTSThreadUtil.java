package com.tencent.pts.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.tencent.pts.utils.PTSLog;

public class PTSThreadUtil
{
  public static final String TAG = "PTSThreadUtil";
  private static volatile Handler sMainThreadHandler = new Handler(Looper.getMainLooper());
  private static volatile Handler sSubThreadHandler;
  
  public static void registerSubHandlerThread(HandlerThread paramHandlerThread)
  {
    if ((paramHandlerThread != null) && (sSubThreadHandler == null)) {
      try
      {
        if (sSubThreadHandler == null)
        {
          sSubThreadHandler = new Handler(paramHandlerThread.getLooper());
          PTSLog.i("PTSThreadUtil", "[registerSubHandlerThread], thread name = " + paramHandlerThread.getName());
        }
        return;
      }
      finally {}
    }
  }
  
  public static void runOnSubThread(Runnable paramRunnable)
  {
    if (paramRunnable == null) {}
    for (;;)
    {
      return;
      if (sSubThreadHandler == null) {}
      try
      {
        if (sSubThreadHandler == null)
        {
          HandlerThread localHandlerThread = new HandlerThread("readinjoy-common-pts-sub");
          localHandlerThread.start();
          sSubThreadHandler = new Handler(localHandlerThread.getLooper());
        }
        sSubThreadHandler.post(paramRunnable);
        if ((!PTSLog.isDebug()) && (!PTSLog.isColorLevel())) {
          continue;
        }
        PTSLog.i("PTSThreadUtil", "[runOnSubThread], callStack = " + Log.getStackTraceString(new Throwable()));
        return;
      }
      finally {}
    }
  }
  
  public static void runOnUIThread(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      return;
    }
    sMainThreadHandler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pts.core.PTSThreadUtil
 * JD-Core Version:    0.7.0.1
 */