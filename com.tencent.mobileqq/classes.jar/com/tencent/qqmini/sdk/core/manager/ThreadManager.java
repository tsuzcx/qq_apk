package com.tencent.qqmini.sdk.core.manager;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.utils.thread.ThreadPools;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

@MiniKeep
public class ThreadManager
{
  private static volatile Handler SUB_HANDLER;
  private static volatile Handler UI_HANDLER;
  
  public static void executeOnComputationThreadPool(Runnable paramRunnable)
  {
    ThreadPools.getComputationThreadPool().execute(paramRunnable);
  }
  
  public static void executeOnDiskIOThreadPool(Runnable paramRunnable)
  {
    getSubThreadHandler().post(paramRunnable);
  }
  
  public static void executeOnNetworkIOThreadPool(Runnable paramRunnable)
  {
    ThreadPools.getNetworkIOThreadPool().execute(paramRunnable);
  }
  
  public static Handler getSubThreadHandler()
  {
    if (SUB_HANDLER == null) {
      try
      {
        if (SUB_HANDLER == null)
        {
          HandlerThread localHandlerThread = new HandlerThread("MINIAPP_SUB", 10);
          localHandlerThread.start();
          SUB_HANDLER = new Handler(localHandlerThread.getLooper());
        }
      }
      finally {}
    }
    return SUB_HANDLER;
  }
  
  public static Handler getUIHandler()
  {
    if (UI_HANDLER == null) {
      try
      {
        if (UI_HANDLER == null) {
          UI_HANDLER = new Handler(Looper.getMainLooper());
        }
      }
      finally {}
    }
    return UI_HANDLER;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.ThreadManager
 * JD-Core Version:    0.7.0.1
 */