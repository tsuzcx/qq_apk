package com.tencent.mobileqq.javahook;

import android.os.AsyncTask;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import java.util.Map;
import java.util.Set;

final class AsyncTaskMonitor$1
  implements HookMethodCallback
{
  public void afterHookedMethod(MethodHookParam paramMethodHookParam) {}
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    Object localObject = paramMethodHookParam.thisObject.getClass();
    if (AsyncTaskMonitor.a().contains(localObject)) {
      return;
    }
    if (!AsyncTaskMonitor.b().contains(localObject))
    {
      AsyncTaskMonitor.b().add(localObject);
      AsyncTaskMonitor.a((Class)localObject);
    }
    paramMethodHookParam = (AsyncTask)paramMethodHookParam.thisObject;
    if (!AsyncTaskMonitor.a().containsKey(paramMethodHookParam))
    {
      localObject = new AsyncTaskMonitor.AsyncTaskMonitorResult();
      AsyncTaskMonitor.a().put(paramMethodHookParam, localObject);
      ((AsyncTaskMonitor.AsyncTaskMonitorResult)localObject).a = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.AsyncTaskMonitor.1
 * JD-Core Version:    0.7.0.1
 */