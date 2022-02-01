package com.tencent.mobileqq.javahook;

import android.os.AsyncTask;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import java.util.Map;

final class ThreadPoolExecutorMonitor$2
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
        if (ThreadPoolExecutorMonitor.a().containsKey(paramMethodHookParam)) {
          return;
        }
        ThreadPoolExecutorMonitor.ThreadPoolExecutorMonitorResult localThreadPoolExecutorMonitorResult = new ThreadPoolExecutorMonitor.ThreadPoolExecutorMonitorResult();
        synchronized (ThreadPoolExecutorMonitor.a())
        {
          ThreadPoolExecutorMonitor.a().put(paramMethodHookParam, localThreadPoolExecutorMonitorResult);
          localThreadPoolExecutorMonitorResult.jdField_a_of_type_JavaLangString = ThreadPoolExecutorMonitor.a(paramMethodHookParam);
          localThreadPoolExecutorMonitorResult.jdField_a_of_type_Long = System.currentTimeMillis();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.ThreadPoolExecutorMonitor.2
 * JD-Core Version:    0.7.0.1
 */