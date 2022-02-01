package com.tencent.mobileqq.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.logincallback.TicketCheckDialogCallback;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.request.Ticket;

public class TicketChecker
{
  private static long a;
  private static long b;
  
  protected long a(AppRuntime paramAppRuntime)
  {
    long l = b;
    if (l > 0L) {
      return l;
    }
    if (paramAppRuntime != null) {
      try
      {
        b = paramAppRuntime.getPreferences().getLong("sp_key_ticket_checker_logout", 0L);
      }
      catch (Exception paramAppRuntime)
      {
        QLog.i("TicketChecker", 1, "getLastLogoutTime", paramAppRuntime);
      }
    }
    return b;
  }
  
  protected void a(Activity paramActivity, AppRuntime paramAppRuntime)
  {
    Object localObject = paramAppRuntime.getCurrentAccountUin();
    boolean bool = false;
    paramAppRuntime.updateSubAccountLogin((String)localObject, false);
    paramAppRuntime.getApplication().refreAccountList();
    paramAppRuntime.logout(true);
    try
    {
      localObject = new Intent().addFlags(67108864);
      ((Intent)localObject).putExtra("logout_intent", true);
      RouteUtils.a(paramActivity, (Intent)localObject, "/base/login");
      paramActivity.finish();
    }
    catch (Exception paramActivity)
    {
      QLog.i("TicketChecker", 1, "forceLogout", paramActivity);
    }
    paramActivity = paramAppRuntime.getManager(1);
    if (paramActivity != null)
    {
      localObject = (WtloginManager)paramActivity;
      paramAppRuntime = paramAppRuntime.getAccount();
      ((WtloginManager)localObject).clearUserFastLoginData(paramAppRuntime, 16L);
      ((WtloginManager)localObject).clearUserFastLoginData(paramAppRuntime, 1600001540L);
      ((WtloginManager)localObject).refreshMemorySig();
    }
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("forceLogout manage = ");
    if (paramActivity == null) {
      bool = true;
    }
    paramAppRuntime.append(bool);
    QLog.i("TicketChecker", 1, paramAppRuntime.toString());
  }
  
  public void a(Activity paramActivity, AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, TicketCheckDialogCallback paramTicketCheckDialogCallback)
  {
    if ((paramActivity != null) && (paramAppRuntime != null))
    {
      if (!((IFeatureRuntimeService)paramAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("Wtlogin_CleanTicket_864285725"))
      {
        QLog.i("TicketChecker", 1, "checkA1Error switch no enable");
        return;
      }
      long l = a(paramAppRuntime);
      if (Math.abs(System.currentTimeMillis() - a(paramAppRuntime)) < 10080000L)
      {
        paramActivity = new StringBuilder();
        paramActivity.append("checkA1Error lastTime=");
        paramActivity.append(l);
        QLog.i("TicketChecker", 1, paramActivity.toString());
        return;
      }
      if (a(paramActivity, paramAppRuntime)) {
        b(paramActivity, paramAppRuntime, paramString1, paramString2, paramString3, paramTicketCheckDialogCallback);
      }
      return;
    }
    QLog.i("TicketChecker", 1, "checkA1Error activity == null || app == null");
  }
  
  protected void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sub_type", "a1_empty_d2_no_empty");
    if (!TextUtils.isEmpty(paramString2)) {
      localHashMap.put("action", paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localHashMap.put("bizType", paramString3);
    }
    localHashMap.put("user_id", paramString1);
    StatisticCollector.getInstance(paramContext).collectPerformance(paramString1, "wtlogin_clean_ticket", true, 0L, 0L, localHashMap, "");
  }
  
  public void a(String paramString, Context paramContext, AppRuntime paramAppRuntime)
  {
    if (!PrivacyPolicyHelper.d())
    {
      QLog.i("TicketChecker", 1, "reportA1Error user no allow");
      return;
    }
    if (Math.abs(System.currentTimeMillis() - a) < 1440000L)
    {
      paramString = new StringBuilder();
      paramString.append("reportA1Error lastTime=");
      paramString.append(a);
      QLog.i("TicketChecker", 1, paramString.toString());
      return;
    }
    if (a(paramContext, paramAppRuntime))
    {
      paramAppRuntime = new HashMap();
      paramAppRuntime.put("sub_type", "a1_empty_d2_no_empty");
      paramAppRuntime.put("user_id", paramString);
      StatisticCollector.getInstance(paramContext).collectPerformance(paramString, "wtlogin_ticket_error", true, 0L, 0L, paramAppRuntime, "");
      a = System.currentTimeMillis();
    }
  }
  
  protected boolean a(Context paramContext, AppRuntime paramAppRuntime)
  {
    boolean bool3 = false;
    if ((paramContext != null) && (paramAppRuntime != null))
    {
      if (!paramAppRuntime.isLogin())
      {
        QLog.i("TicketChecker", 1, "isA1EmptyButD2NoEmpty is no Login ");
        return false;
      }
      paramContext = paramAppRuntime.getCurrentAccountUin();
      if (TextUtils.isEmpty(paramContext))
      {
        QLog.i("TicketChecker", 1, "isA1EmptyButD2NoEmpty uin isEmpty");
        return false;
      }
      WtloginManager localWtloginManager = (WtloginManager)paramAppRuntime.getManager(1);
      boolean bool1;
      if (localWtloginManager != null) {
        bool1 = localWtloginManager.isUserHaveA1(paramContext, 16L);
      } else {
        bool1 = true;
      }
      paramAppRuntime = (TicketManager)paramAppRuntime.getManager(2);
      if (paramAppRuntime != null)
      {
        paramContext = paramAppRuntime.getLocalTicket(paramContext, 262144);
        if ((paramContext != null) && (paramContext._sig != null))
        {
          i = paramContext._sig.length;
          break label135;
        }
      }
      int i = 0;
      label135:
      paramContext = new StringBuilder();
      paramContext.append("isA1EmptyButD2NoEmpty isUserHaveA1=");
      paramContext.append(bool1);
      paramContext.append(",d2TicketLength=");
      paramContext.append(i);
      QLog.i("TicketChecker", 1, paramContext.toString());
      boolean bool2 = bool3;
      if (!bool1)
      {
        bool2 = bool3;
        if (i > 0) {
          bool2 = true;
        }
      }
      return bool2;
    }
    QLog.i("TicketChecker", 1, "isA1EmptyButD2NoEmpty context == null || app == null");
    return false;
  }
  
  protected void b(Activity paramActivity, AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, TicketCheckDialogCallback paramTicketCheckDialogCallback)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(paramActivity, 230);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setMessage(paramString2);
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131886644), new TicketChecker.1(this, paramActivity, paramAppRuntime, paramString3, paramTicketCheckDialogCallback));
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131886643), new TicketChecker.2(this, paramTicketCheckDialogCallback, paramActivity, paramAppRuntime, paramString3));
    localQQCustomDialog.show();
    a(paramActivity, paramAppRuntime.getCurrentUin(), "dialog_show", paramString3);
    paramActivity = new StringBuilder();
    paramActivity.append("showLogoutDialog bizType=");
    paramActivity.append(paramString3);
    QLog.i("TicketChecker", 1, paramActivity.toString());
  }
  
  protected void b(AppRuntime paramAppRuntime)
  {
    b = System.currentTimeMillis();
    if (paramAppRuntime != null) {
      try
      {
        paramAppRuntime = paramAppRuntime.getPreferences().edit();
        paramAppRuntime.putLong("sp_key_ticket_checker_logout", b);
        paramAppRuntime.commit();
        return;
      }
      catch (Exception paramAppRuntime)
      {
        QLog.i("TicketChecker", 1, "saveLastLogoutTime", paramAppRuntime);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.login.TicketChecker
 * JD-Core Version:    0.7.0.1
 */