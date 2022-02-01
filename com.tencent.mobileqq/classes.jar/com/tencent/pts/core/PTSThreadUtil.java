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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[registerSubHandlerThread], thread name = ");
          localStringBuilder.append(paramHandlerThread.getName());
          PTSLog.i("PTSThreadUtil", localStringBuilder.toString());
        }
        return;
      }
      finally {}
    }
  }
  
  public static void runOnSubThread(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (sSubThreadHandler == null) {
      try
      {
        if (sSubThreadHandler == null)
        {
          HandlerThread localHandlerThread = new HandlerThread("readinjoy-common-pts-sub");
          localHandlerThread.start();
          sSubThreadHandler = new Handler(localHandlerThread.getLooper());
        }
      }
      finally {}
    }
    sSubThreadHandler.post(paramRunnable);
    if ((PTSLog.isDebug()) || (PTSLog.isColorLevel()))
    {
      paramRunnable = new StringBuilder();
      paramRunnable.append("[runOnSubThread], callStack = ");
      paramRunnable.append(Log.getStackTraceString(new Throwable()));
      PTSLog.i("PTSThreadUtil", paramRunnable.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.core.PTSThreadUtil
 * JD-Core Version:    0.7.0.1
 */