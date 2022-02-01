package com.tencent.mobileqq.javahook;

import android.os.AsyncTask;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import java.util.Map;

final class AsyncTaskMonitor$2
  implements HookMethodCallback
{
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    paramMethodHookParam = (AsyncTask)paramMethodHookParam.thisObject;
    AsyncTaskMonitor.AsyncTaskMonitorResult localAsyncTaskMonitorResult = (AsyncTaskMonitor.AsyncTaskMonitorResult)AsyncTaskMonitor.a().get(paramMethodHookParam);
    if (localAsyncTaskMonitorResult == null) {
      return;
    }
    localAsyncTaskMonitorResult.c = System.currentTimeMillis();
    AsyncTaskMonitor.a().remove(paramMethodHookParam);
    AsyncTaskMonitor.a(paramMethodHookParam, localAsyncTaskMonitorResult);
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    paramMethodHookParam = (AsyncTask)paramMethodHookParam.thisObject;
    paramMethodHookParam = (AsyncTaskMonitor.AsyncTaskMonitorResult)AsyncTaskMonitor.a().get(paramMethodHookParam);
    if (paramMethodHookParam == null) {
      return;
    }
    paramMethodHookParam.a = Thread.currentThread().getName();
    paramMethodHookParam.b = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.AsyncTaskMonitor.2
 * JD-Core Version:    0.7.0.1
 */