package com.tencent.mobileqq.javahook;

import android.os.AsyncTask;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import java.util.Set;

final class ThreadPoolExecutorMonitor$1
  implements HookMethodCallback
{
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (!AsyncTask.THREAD_POOL_EXECUTOR.equals(paramMethodHookParam.thisObject))
    {
      if (AsyncTask.SERIAL_EXECUTOR.equals(paramMethodHookParam.thisObject)) {
        return;
      }
      paramMethodHookParam = paramMethodHookParam.thisObject.getClass();
      if (!ThreadPoolExecutorMonitor.a().contains(paramMethodHookParam))
      {
        ThreadPoolExecutorMonitor.a().add(paramMethodHookParam);
        ThreadPoolExecutorMonitor.a(paramMethodHookParam);
      }
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.ThreadPoolExecutorMonitor.1
 * JD-Core Version:    0.7.0.1
 */