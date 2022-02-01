package com.tencent.mobileqq.javahook;

import android.os.AsyncTask;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import java.util.Map;

final class ThreadPoolExecutorMonitor$4
  implements HookMethodCallback
{
  public void afterHookedMethod(MethodHookParam paramMethodHookParam) {}
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if ((AsyncTask.THREAD_POOL_EXECUTOR.equals(paramMethodHookParam.thisObject)) || (AsyncTask.SERIAL_EXECUTOR.equals(paramMethodHookParam.thisObject))) {}
    for (;;)
    {
      return;
      paramMethodHookParam = (Runnable)paramMethodHookParam.args[0];
      synchronized (ThreadPoolExecutorMonitor.a())
      {
        ThreadPoolExecutorMonitor.ThreadPoolExecutorMonitorResult localThreadPoolExecutorMonitorResult = (ThreadPoolExecutorMonitor.ThreadPoolExecutorMonitorResult)ThreadPoolExecutorMonitor.a().get(paramMethodHookParam);
        if (localThreadPoolExecutorMonitorResult == null) {
          continue;
        }
        localThreadPoolExecutorMonitorResult.c = System.currentTimeMillis();
        ThreadPoolExecutorMonitor.a(paramMethodHookParam, localThreadPoolExecutorMonitorResult);
        synchronized (ThreadPoolExecutorMonitor.a())
        {
          ThreadPoolExecutorMonitor.a().remove(paramMethodHookParam);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.ThreadPoolExecutorMonitor.4
 * JD-Core Version:    0.7.0.1
 */