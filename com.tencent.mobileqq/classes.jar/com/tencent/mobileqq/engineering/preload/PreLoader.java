package com.tencent.mobileqq.engineering.preload;

import com.tencent.mobileqq.engineering.preload.inter.ILogger;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import java.util.concurrent.ExecutorService;

public class PreLoader
{
  public static final String TAG = "PreLoader";
  public static ILogger sLogger;
  
  public static <T> void addListener(String paramString, OnTaskListener<T> paramOnTaskListener)
  {
    PreLoaderPool.getInstance().setListener(paramString, paramOnTaskListener);
  }
  
  public static boolean exists(String paramString)
  {
    return PreLoaderPool.getInstance().exists(paramString);
  }
  
  public static void log(String paramString)
  {
    ILogger localILogger = sLogger;
    if (localILogger != null) {
      localILogger.d("PreLoader", paramString);
    }
  }
  
  public static void log(Throwable paramThrowable)
  {
    ILogger localILogger = sLogger;
    if (localILogger != null) {
      localILogger.d("PreLoader", "", paramThrowable);
    }
  }
  
  public static <T> String preLoad(String paramString, BasePreLoadTask<T> paramBasePreLoadTask)
  {
    return PreLoaderPool.getInstance().preLoad(paramString, paramBasePreLoadTask);
  }
  
  public static void remove(String paramString)
  {
    PreLoaderPool.getInstance().remove(paramString);
  }
  
  public static <T> void removeListener(String paramString, OnTaskListener<T> paramOnTaskListener)
  {
    PreLoaderPool.getInstance().removeListener(paramString, paramOnTaskListener);
  }
  
  public static void setDefaultThreadPoolExecutor(ExecutorService paramExecutorService)
  {
    Worker.setDefaultThreadPoolExecutor(paramExecutorService);
  }
  
  public static void setLogger(ILogger paramILogger)
  {
    sLogger = paramILogger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.engineering.preload.PreLoader
 * JD-Core Version:    0.7.0.1
 */