package com.tencent.mobileqq.config;

import com.qq.android.dexposed.XC_MethodHook;
import com.qq.android.dexposed.XC_MethodHook.MethodHookParam;
import com.tencent.qphone.base.util.QLog;

final class QConfigWatchDog$ThreadSwitchHook
  extends XC_MethodHook
{
  protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    try
    {
      paramMethodHookParam = QConfigWatchDog.a();
      if ((paramMethodHookParam.contains("QConfigManager.save")) && (paramMethodHookParam.contains("onParsed")))
      {
        QConfigWatchDog.a(new QConfigureException(paramMethodHookParam), "Can not switch thread when parsing config.", "QConfigWatchDog_threadswitch");
        return;
      }
    }
    catch (Exception paramMethodHookParam)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigWatchDog", 2, "hook thread exception.", paramMethodHookParam);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.QConfigWatchDog.ThreadSwitchHook
 * JD-Core Version:    0.7.0.1
 */