package com.tencent.mobileqq.subaccount;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareUtil;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.loginregister.LoginProgressClazz;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.api.IQQPlayer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.open.OpenProxy;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.PatternLockUtils;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class SubAccountAssistantForward
{
  public static void a(AppInterface paramAppInterface, Context paramContext)
  {
    if ((paramAppInterface != null) && (paramContext != null) && (paramAppInterface.isRunning()))
    {
      if (paramContext.getApplicationContext() == null) {
        return;
      }
      paramContext = paramContext.getApplicationContext();
      ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).loginSuccessInit(paramAppInterface, paramAppInterface.getCurrentAccountUin());
      ((ITroopInfoHandler)paramAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopInfoHandlerName())).a();
      QvipSpecialCareUtil.a(true);
      OpenProxy.a().a(paramAppInterface.getCurrentAccountUin());
      PatternLockUtils.setFirstEnterAfterLoginState(paramContext, paramAppInterface.getCurrentAccountUin(), true);
      ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getQCircleTabConfig(paramAppInterface, paramContext.getClass());
      ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getKandianTabConfig(paramAppInterface, paramContext.getClass(), System.currentTimeMillis(), false);
      paramAppInterface = paramContext.getSharedPreferences(((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getQRCodeKey(), 0).edit();
      paramAppInterface.clear();
      paramAppInterface.commit();
    }
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    if (paramAppInterface == null) {
      return;
    }
    paramAppInterface = new Intent(paramContext, AssociatedAccountActivity.class);
    paramAppInterface.putExtra("subAccount", paramString);
    paramContext.startActivity(paramAppInterface);
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (!(paramAppRuntime instanceof AppInterface))
    {
      QLog.e("qqBaseActivity", 1, "closeSubAccountUgActivity, appruntime is not QQAppInterface");
      return;
    }
    paramAppRuntime = ((AppInterface)paramAppRuntime).getHandler(SubAccountUgActivity.class);
    if (paramAppRuntime != null) {
      paramAppRuntime.sendEmptyMessage(1980);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, long paramLong)
  {
    if (!(paramAppRuntime instanceof AppInterface))
    {
      QLog.e("qqBaseActivity", 1, "closeSubAccountBindDailog, appruntime is not QQAppInterface");
      return;
    }
    paramAppRuntime = ((AppInterface)paramAppRuntime).getHandler(SubAccountBindActivity.class);
    if (paramAppRuntime != null) {
      paramAppRuntime.sendEmptyMessageDelayed(1990, paramLong);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, Context paramContext)
  {
    if ((paramAppRuntime != null) && (paramContext != null) && (paramAppRuntime.isRunning()))
    {
      if (paramContext.getApplicationContext() == null) {
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
  }
  
  public static void b(AppInterface paramAppInterface, Context paramContext)
  {
    if ((paramAppInterface != null) && (paramContext != null) && (paramAppInterface.isRunning()))
    {
      if (paramContext.getApplicationContext() == null) {
        return;
      }
      paramAppInterface = paramContext.getApplicationContext();
      if (((IQQPlayer)QRoute.api(IQQPlayer.class)).isPlaying())
      {
        paramContext = new Intent();
        paramContext.setAction("qqplayer_exit_action");
        paramAppInterface.sendBroadcast(paramContext);
      }
    }
  }
  
  public static void b(AppRuntime paramAppRuntime)
  {
    if (!(paramAppRuntime instanceof AppInterface))
    {
      QLog.e("qqBaseActivity", 1, "closeSubAccountBindActivity, appruntime is not QQAppInterface");
      return;
    }
    paramAppRuntime = ((AppInterface)paramAppRuntime).getHandler(SubAccountBindActivity.class);
    if (paramAppRuntime != null) {
      paramAppRuntime.sendEmptyMessage(1981);
    }
  }
  
  public static void c(AppRuntime paramAppRuntime)
  {
    if (!(paramAppRuntime instanceof AppInterface))
    {
      QLog.e("qqBaseActivity", 1, "closeSubLoginActivity, appruntime is not QQAppInterface");
      return;
    }
    paramAppRuntime = ((AppInterface)paramAppRuntime).getHandler(LoginProgressClazz.class);
    if (paramAppRuntime != null) {
      paramAppRuntime.sendEmptyMessage(1982);
    }
  }
  
  public static void d(AppRuntime paramAppRuntime)
  {
    if (!(paramAppRuntime instanceof AppInterface))
    {
      QLog.e("qqBaseActivity", 1, "closePhoneNumActivity, appruntime is not QQAppInterface");
      return;
    }
    paramAppRuntime = ((AppInterface)paramAppRuntime).getHandler(((ILoginRegisterApi)QRoute.api(ILoginRegisterApi.class)).getLoginPhoneNumActivityClass());
    if (paramAppRuntime != null) {
      paramAppRuntime.sendEmptyMessage(2014);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.SubAccountAssistantForward
 * JD-Core Version:    0.7.0.1
 */