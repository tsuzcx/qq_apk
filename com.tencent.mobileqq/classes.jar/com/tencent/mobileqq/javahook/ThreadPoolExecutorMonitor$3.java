package com.tencent.mobileqq.javahook;

import android.os.AsyncTask;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import java.util.Map;

final class ThreadPoolExecutorMonitor$3
  implements HookMethodCallback
{
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (!AsyncTask.THREAD_POOL_EXECUTOR.equals(paramMethodHookParam.thisObject))
    {
      if (AsyncTask.SERIAL_EXECUTOR.equals(paramMethodHookParam.thisObject)) {
        return;
      }
      Object localObject = (Runnable)paramMethodHookParam.args[1];
      synchronized (ThreadPoolExecutorMonitor.a())
      {
        localObject = (ThreadPoolExecutorMonitor.ThreadPoolExecutorMonitorResult)ThreadPoolExecutorMonitor.a().get(localObject);
        if (localObject == null) {
          return;
        }
        ((ThreadPoolExecutorMonitor.ThreadPoolExecutorMonitorResult)localObject).jdField_b_of_type_JavaLangString = ((Thread)paramMethodHookParam.args[0]).getName();
        ((ThreadPoolExecutorMonitor.ThreadPoolExecutorMonitorResult)localObject).jdField_b_of_type_Long = System.currentTimeMillis();
        return;
      }
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.ThreadPoolExecutorMonitor.3
 * JD-Core Version:    0.7.0.1
 */