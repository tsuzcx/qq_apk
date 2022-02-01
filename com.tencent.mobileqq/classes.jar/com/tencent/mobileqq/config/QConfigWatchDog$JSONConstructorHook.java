package com.tencent.mobileqq.config;

import com.qq.android.dexposed.XC_MethodHook;
import com.qq.android.dexposed.XC_MethodHook.MethodHookParam;
import com.tencent.qphone.base.util.QLog;

final class QConfigWatchDog$JSONConstructorHook
  extends XC_MethodHook
{
  public void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    try
    {
      paramMethodHookParam = QConfigWatchDog.a();
      if ((!paramMethodHookParam.contains("QConfigManager.readSync")) && (!paramMethodHookParam.contains("QConfigManager.loadConObj")) && (!paramMethodHookParam.contains("QConfigManager.save"))) {
        QConfigWatchDog.a(new QConfigureException(paramMethodHookParam), "Can not parse json beyond QConfigManager when app starting.", "QConfigWatchDog_Json");
      }
      return;
    }
    catch (Exception paramMethodHookParam)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QConfigWatchDog", 2, "hook json exception.", paramMethodHookParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.QConfigWatchDog.JSONConstructorHook
 * JD-Core Version:    0.7.0.1
 */