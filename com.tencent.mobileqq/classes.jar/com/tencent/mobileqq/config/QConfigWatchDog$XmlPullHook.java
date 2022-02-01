package com.tencent.mobileqq.config;

import com.qq.android.dexposed.XC_MethodHook;
import com.qq.android.dexposed.XC_MethodHook.MethodHookParam;
import com.tencent.qphone.base.util.QLog;

final class QConfigWatchDog$XmlPullHook
  extends XC_MethodHook
{
  public void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    try
    {
      paramMethodHookParam = QConfigWatchDog.a();
      if ((!paramMethodHookParam.contains("QConfigManager.readSync")) && (!paramMethodHookParam.contains("QConfigManager.loadConObj")) && (!paramMethodHookParam.contains("QConfigManager.save")) && (!paramMethodHookParam.contains("android.app.SharedPreferencesImpl"))) {
        QConfigWatchDog.a(new QConfigureException(paramMethodHookParam), "Can not parse xml beyond QConfigManager when app starting.", "QConfigWatchDog_Xml");
      }
      return;
    }
    catch (Exception paramMethodHookParam)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QConfigWatchDog", 2, "hook xml exception.", paramMethodHookParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.QConfigWatchDog.XmlPullHook
 * JD-Core Version:    0.7.0.1
 */