package com.tencent.mobileqq.subaccount;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.KandianConfigServlet;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.loginregister.LoginProgressClazz;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.open.OpenProxy;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.PatternLockUtils;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class SubAccountAssistantForward
{
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (!paramQQAppInterface.isRunning()) || (paramContext.getApplicationContext() == null)) {
      return;
    }
    paramContext = paramContext.getApplicationContext();
    BusinessUtils.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
    TroopNotificationHelper.a();
    QvipSpecialCareManager.a(true);
    OpenProxy.a().a(paramQQAppInterface.getCurrentAccountUin());
    PatternLockUtils.setFirstEnterAfterLoginState(paramContext, paramQQAppInterface.getCurrentAccountUin(), true);
    KandianConfigServlet.a(paramQQAppInterface, paramContext.getClass(), System.currentTimeMillis(), false);
    paramQQAppInterface = paramContext.getSharedPreferences("qrcode", 0).edit();
    paramQQAppInterface.clear();
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = new Intent(paramContext, AssociatedAccountActivity.class);
    paramQQAppInterface.putExtra("subAccount", paramString);
    paramContext.startActivity(paramQQAppInterface);
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (!(paramAppRuntime instanceof QQAppInterface)) {
      QLog.e("qqBaseActivity", 1, "closeSubAccountUgActivity, appruntime is not QQAppInterface");
    }
    do
    {
      return;
      paramAppRuntime = ((QQAppInterface)paramAppRuntime).getHandler(SubAccountUgActivity.class);
    } while (paramAppRuntime == null);
    paramAppRuntime.sendEmptyMessage(1980);
  }
  
  public static void a(AppRuntime paramAppRuntime, long paramLong)
  {
    if (!(paramAppRuntime instanceof QQAppInterface)) {
      QLog.e("qqBaseActivity", 1, "closeSubAccountBindDailog, appruntime is not QQAppInterface");
    }
    do
    {
      return;
      paramAppRuntime = ((QQAppInterface)paramAppRuntime).getHandler(SubAccountBindActivity.class);
    } while (paramAppRuntime == null);
    paramAppRuntime.sendEmptyMessageDelayed(1990, paramLong);
  }
  
  public static void a(AppRuntime paramAppRuntime, Context paramContext)
  {
    if ((paramAppRuntime == null) || (paramContext == null) || (!paramAppRuntime.isRunning()) || (paramContext.getApplicationContext() == null)) {
      return;
    }
    paramContext = paramContext.getApplicationContext();
    if (QQPlayerService.a())
    {
      Intent localIntent = new Intent();
      localIntent.setAction("qqplayer_exit_action");
      paramContext.sendBroadcast(localIntent);
    }
    PatternLockUtils.setFirstEnterAfterLoginState(paramContext, paramAppRuntime.getAccount(), true);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (!paramQQAppInterface.isRunning()) || (paramContext.getApplicationContext() == null)) {}
    do
    {
      return;
      paramQQAppInterface = paramContext.getApplicationContext();
    } while (!QQPlayerService.a());
    paramContext = new Intent();
    paramContext.setAction("qqplayer_exit_action");
    paramQQAppInterface.sendBroadcast(paramContext);
  }
  
  public static void b(AppRuntime paramAppRuntime)
  {
    if (!(paramAppRuntime instanceof QQAppInterface)) {
      QLog.e("qqBaseActivity", 1, "closeSubAccountBindActivity, appruntime is not QQAppInterface");
    }
    do
    {
      return;
      paramAppRuntime = ((QQAppInterface)paramAppRuntime).getHandler(SubAccountBindActivity.class);
    } while (paramAppRuntime == null);
    paramAppRuntime.sendEmptyMessage(1981);
  }
  
  public static void c(AppRuntime paramAppRuntime)
  {
    if (!(paramAppRuntime instanceof QQAppInterface)) {
      QLog.e("qqBaseActivity", 1, "closeSubLoginActivity, appruntime is not QQAppInterface");
    }
    do
    {
      return;
      paramAppRuntime = ((QQAppInterface)paramAppRuntime).getHandler(LoginProgressClazz.class);
    } while (paramAppRuntime == null);
    paramAppRuntime.sendEmptyMessage(1982);
  }
  
  public static void d(AppRuntime paramAppRuntime)
  {
    if (!(paramAppRuntime instanceof QQAppInterface)) {
      QLog.e("qqBaseActivity", 1, "closePhoneNumActivity, appruntime is not QQAppInterface");
    }
    do
    {
      return;
      paramAppRuntime = ((QQAppInterface)paramAppRuntime).getHandler(((ILoginRegisterApi)QRoute.api(ILoginRegisterApi.class)).getLoginPhoneNumActivityClass());
    } while (paramAppRuntime == null);
    paramAppRuntime.sendEmptyMessage(2014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.SubAccountAssistantForward
 * JD-Core Version:    0.7.0.1
 */