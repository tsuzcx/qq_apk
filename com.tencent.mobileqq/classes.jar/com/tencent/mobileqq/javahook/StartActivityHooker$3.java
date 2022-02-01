package com.tencent.mobileqq.javahook;

import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.qphone.base.util.QLog;

final class StartActivityHooker$3
  implements HookMethodCallback
{
  public void afterHookedMethod(MethodHookParam paramMethodHookParam) {}
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StartActivityHooker", 2, "shinkencai");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.StartActivityHooker.3
 * JD-Core Version:    0.7.0.1
 */