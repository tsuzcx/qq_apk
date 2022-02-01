package com.tencent.superplayer.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadUtil
{
  private static final int CORE_POOL_SIZE;
  private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
  private static final int KEEP_ALIVE_SECONDS = 30;
  private static final int MAXIMUM_POOL_SIZE;
  public static final Executor THREAD_POOL_EXECUTOR;
  private static volatile ThreadUtil.UIHandler sMainThreadHandler;
  private static final BlockingQueue<Runnable> sPoolWorkQueue;
  private static volatile HandlerThread sSubThread;
  private static volatile Handler sSubThreadHandler;
  private static final ThreadFactory sThreadFactory;
  private static final Executor sThreadPool = THREAD_POOL_EXECUTOR;
  
  static
  {
    CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
    MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
    sThreadFactory = new ThreadUtil.1();
    sPoolWorkQueue = new LinkedBlockingQueue(128);
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
    localThreadPoolExecutor.allowCoreThreadTimeOut(true);
    THREAD_POOL_EXECUTOR = localThreadPoolExecutor;
  }
  
  public static Handler getSubThreadHandler()
  {
    if (sSubThreadHandler == null) {
      try
      {
        if (sSubThreadHandler == null) {
          sSubThreadHandler = new Handler(getSubThreadLooper());
        }
      }
      finally {}
    }
    return sSubThreadHandler;
  }
  
  public static Looper getSubThreadLooper()
  {
    initSubThreadHandler();
    return sSubThread.getLooper();
  }
  
  public static Handler getUIHandler()
  {
    initMainThreadHandler();
    return sMainThreadHandler;
  }
  
  private static void initMainThreadHandler()
  {
    if (sMainThreadHandler == null) {
      try
      {
        if (sMainThreadHandler == null)
        {
          Looper localLooper = Looper.getMainLooper();
          if (localLooper != null)
          {
            sMainThreadHandler = new ThreadUtil.UIHandler(localLooper);
          }
          else
          {
            sMainThreadHandler = null;
            throw new IllegalStateException("cannot get UI Thread looper!");
          }
        }
        return;
      }
      finally {}
    }
  }
  
  private static void initSubThreadHandler()
  {
    if (sSubThread == null) {
      try
      {
        if (sSubThread == null)
        {
          sSubThread = new HandlerThread("SuperPlayerSubThread");
          sSubThread.start();
        }
        return;
      }
      finally {}
    }
  }
  
  public static void runOnThreadPool(@NonNull Runnable paramRunnable)
  {
    sThreadPool.execute(paramRunnable);
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      return;
    }
    initMainThreadHandler();
    if (sMainThreadHandler != null) {
      sMainThreadHandler.post(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.utils.ThreadUtil
 * JD-Core Version:    0.7.0.1
 */