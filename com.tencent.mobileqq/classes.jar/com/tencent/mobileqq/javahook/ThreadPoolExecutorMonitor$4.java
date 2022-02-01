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
    if (!AsyncTask.THREAD_POOL_EXECUTOR.equals(paramMethodHookParam.thisObject))
    {
      if (AsyncTask.SERIAL_EXECUTOR.equals(paramMethodHookParam.thisObject)) {
        return;
      }
      paramMethodHookParam = (Runnable)paramMethodHookParam.args[0];
      synchronized (ThreadPoolExecutorMonitor.a())
      {
        ThreadPoolExecutorMonitor.ThreadPoolExecutorMonitorResult localThreadPoolExecutorMonitorResult = (ThreadPoolExecutorMonitor.ThreadPoolExecutorMonitorResult)ThreadPoolExecutorMonitor.a().get(paramMethodHookParam);
        if (localThreadPoolExecutorMonitorResult == null) {
          return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.ThreadPoolExecutorMonitor.4
 * JD-Core Version:    0.7.0.1
 */