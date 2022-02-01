package com.tencent.qqperf.debug;

import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.qphone.base.util.QLog;

final class ThreadHooker$1
  implements HookMethodCallback
{
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if ((paramMethodHookParam != null) && (paramMethodHookParam.thisObject != null))
    {
      QLog.i("ThreadHooker", 2, "", new ThreadHooker.CreateThreadStack(paramMethodHookParam.thisObject.toString()));
      return;
    }
    QLog.i("ThreadHooker", 2, "", new ThreadHooker.CreateThreadStack("unknown"));
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.debug.ThreadHooker.1
 * JD-Core Version:    0.7.0.1
 */