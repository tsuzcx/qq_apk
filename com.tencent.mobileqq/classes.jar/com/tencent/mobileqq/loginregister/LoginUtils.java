package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Date;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class LoginUtils
{
  public static Dialog a(Activity paramActivity, int paramInt)
  {
    return DialogUtil.b(paramActivity, paramInt);
  }
  
  public static String a(String paramString)
  {
    Object localObject1 = MobileQQ.sMobileQQ;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(Constants.PropertiesKey.uinDisplayName.toString());
    ((StringBuilder)localObject2).append(paramString);
    localObject2 = ((MobileQQ)localObject1).getProperty(((StringBuilder)localObject2).toString());
    localObject1 = paramString;
    if (localObject2 != null)
    {
      if (((String)localObject2).length() == 0) {
        return paramString;
      }
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public static MqqHandler a(AppRuntime paramAppRuntime, Class<?> paramClass)
  {
    if (!(paramAppRuntime instanceof AppInterface))
    {
      QLog.e("LoginRegister.LoginUtils", 1, "getHandler, but appRuntime is not appinterface");
      return null;
    }
    return ((AppInterface)paramAppRuntime).getHandler(paramClass);
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString)
  {
    paramContext = new ActivityURIRequest(paramContext, paramString);
    paramContext.extra().putAll(paramIntent.getExtras());
    paramContext.setFlags(paramIntent.getFlags());
    QRoute.startUri(paramContext, null);
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString, int paramInt)
  {
    paramContext = new ActivityURIRequest(paramContext, paramString);
    paramContext.extra().putAll(paramIntent.getExtras());
    paramContext.setFlags(paramIntent.getFlags());
    paramContext.setRequestCode(paramInt);
    QRoute.startUri(paramContext, null);
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (!(paramAppRuntime instanceof AppInterface))
    {
      QLog.e("LoginRegister.LoginUtils", 1, "showLoginDialog, appruntime is not appinterface");
      return;
    }
    paramAppRuntime = ((AppInterface)paramAppRuntime).getHandler(LoginProgressClazz.class);
    if (paramAppRuntime == null)
    {
      QLog.e("LoginRegister.LoginUtils", 1, "showLoginDialog, handler is null");
      return;
    }
    paramAppRuntime.sendEmptyMessage(2002);
  }
  
  public static void a(AppRuntime paramAppRuntime, Class<?> paramClass, MqqHandler paramMqqHandler)
  {
    if (!(paramAppRuntime instanceof AppInterface))
    {
      QLog.e("LoginRegister.LoginUtils", 1, "getHandler, but appRuntime is not appinterface");
      return;
    }
    ((AppInterface)paramAppRuntime).setHandler(paramClass, paramMqqHandler);
  }
  
  public static boolean a(Context paramContext)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(paramContext);
    boolean bool2 = false;
    boolean bool3 = SettingCloneUtil.readValue(paramContext, null, "security_scan_key", "qqsetting_security_scan_key", false);
    boolean bool4 = ((SharedPreferences)localObject).getBoolean("security_scan_last_result", false);
    long l = ((SharedPreferences)localObject).getLong("security_scan_last_time", 0L);
    paramContext = new Date(l);
    localObject = new Date();
    paramContext.setHours(0);
    paramContext.setMinutes(0);
    paramContext.setSeconds(0);
    boolean bool1 = bool2;
    if (bool3) {
      if ((l != 0L) && (((Date)localObject).getTime() - paramContext.getTime() <= 604800000L))
      {
        bool1 = bool2;
        if (!bool4) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(QBaseActivity paramQBaseActivity, AppRuntime paramAppRuntime)
  {
    return (BaseGesturePWDUtil.getGesturePWDState(paramQBaseActivity, paramAppRuntime.getAccount()) == 2) && (BaseGesturePWDUtil.getGesturePWDMode(paramQBaseActivity, paramAppRuntime.getAccount()) == 21);
  }
  
  public static void b(AppRuntime paramAppRuntime)
  {
    if (!(paramAppRuntime instanceof AppInterface))
    {
      QLog.e("LoginRegister.LoginUtils", 1, "hideLoginDialog, appruntime is not appinterface");
      return;
    }
    paramAppRuntime = ((AppInterface)paramAppRuntime).getHandler(LoginProgressClazz.class);
    if (paramAppRuntime == null)
    {
      QLog.e("LoginRegister.LoginUtils", 1, "hideLoginDialog, handler is null");
      return;
    }
    paramAppRuntime.sendEmptyMessage(2001);
  }
  
  public static void b(AppRuntime paramAppRuntime, Class<?> paramClass)
  {
    if (!(paramAppRuntime instanceof AppInterface))
    {
      QLog.e("LoginRegister.LoginUtils", 1, "removeHandler, but appRuntime is not appinterface");
      return;
    }
    ((AppInterface)paramAppRuntime).removeHandler(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.LoginUtils
 * JD-Core Version:    0.7.0.1
 */