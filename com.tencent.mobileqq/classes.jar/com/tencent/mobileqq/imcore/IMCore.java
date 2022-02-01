package com.tencent.mobileqq.imcore;

import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.GetStaticProxy;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class IMCore
{
  private static final String TAG = "IMCore";
  private static boolean isInit;
  private static IMCoreProxyRoute.GetStaticProxy<AppRuntime> runtimeGetStaticProxy;
  
  public static AppRuntime getAppRuntime()
  {
    if ((isInit) && (runtimeGetStaticProxy != null) && (runtimeGetStaticProxy.get() != null)) {
      return (AppRuntime)runtimeGetStaticProxy.get();
    }
    StringBuilder localStringBuilder = new StringBuilder().append("Init IMCore Fail, AppRuntime==null ,isInit=").append(isInit).append(" proxy=");
    if (runtimeGetStaticProxy == null) {}
    for (String str = "null";; str = "not null") {
      throw new RuntimeException(str);
    }
  }
  
  public static void init(IMCoreProxyRoute.GetStaticProxy<AppRuntime> paramGetStaticProxy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore", 2, new Object[] { "call init, isInit=", Boolean.valueOf(isInit) });
    }
    if (isInit) {
      return;
    }
    runtimeGetStaticProxy = paramGetStaticProxy;
    isInit = true;
  }
  
  public static boolean isInit()
  {
    return isInit;
  }
  
  public static void syncAppSetting(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    com.tencent.mobileqq.imcore.constants.AppSetting.isPublicVersion = paramBoolean1;
    com.tencent.mobileqq.imcore.constants.AppSetting.isDebugVersion = paramBoolean2;
    com.tencent.mobileqq.imcore.constants.AppSetting.isGrayVersion = paramBoolean3;
    com.tencent.mobileqq.imcore.constants.AppSetting.isGooglePlayVersion = paramBoolean4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.IMCore
 * JD-Core Version:    0.7.0.1
 */