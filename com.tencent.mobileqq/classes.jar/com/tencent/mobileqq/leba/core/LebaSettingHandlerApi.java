package com.tencent.mobileqq.leba.core;

import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class LebaSettingHandlerApi
{
  public static final String a = LebaSettingHandler.class.getName();
  
  public static void a(AppRuntime paramAppRuntime, int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!(paramAppRuntime instanceof AppInterface))
    {
      QLog.i("LebaSettingHandlerApi", 1, "notifySetPluginState !(app instanceof  AppInterface)");
      return;
    }
    ((LebaSettingHandler)((AppInterface)paramAppRuntime).getBusinessHandler(a)).notifyUI(paramInt, paramBoolean, paramObject);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean, long paramLong)
  {
    if (!(paramAppRuntime instanceof AppInterface))
    {
      QLog.i("LebaSettingHandlerApi", 1, "netSetPluginState !(app instanceof  AppInterface)");
      return;
    }
    ((LebaSettingHandler)((AppInterface)paramAppRuntime).getBusinessHandler(a)).a(paramString, paramBoolean, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.LebaSettingHandlerApi
 * JD-Core Version:    0.7.0.1
 */