package com.tencent.open.agent.strategy;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.business.OpenSdkConfProcessor;
import com.tencent.mobileqq.config.business.OpenSdkSwitchConfBean;
import com.tencent.mobileqq.config.business.OpenSdkSwitchConfBean.OpenSdkSwitchConfig;
import com.tencent.mobileqq.config.business.OpenSdkSwitchProcessor;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.agent.PublicFragmentActivityForOpenSDK;
import com.tencent.open.agent.auth.presenter.SSOPreAuthPresenter;
import com.tencent.open.agent.entity.AuthMemoryCache;
import com.tencent.open.agent.util.AuthModelUtil;
import com.tencent.open.agent.util.AuthParamUtil;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.OpenSdkDESUtils;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.data.SharedPrefs;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.model.AccountManage;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.qqconnect.wtlogin.AbstractOpenSdkAppInterface;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class SSOLoginAction
  extends BaseAction
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private BroadcastReceiver b;
  
  public SSOLoginAction(String paramString)
  {
    super(paramString);
  }
  
  private AbstractOpenSdkAppInterface a()
  {
    return (AbstractOpenSdkAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  private String a(Bundle paramBundle, String paramString)
  {
    String str2 = AuthorityUtil.a(this.jdField_a_of_type_AndroidAppActivity);
    SSOLog.a("SSOLoginAction", new Object[] { "getCallingPkgName pkgName=", str2 });
    if (!TextUtils.isEmpty(str2)) {
      return str2;
    }
    if (!OpenSdkConfProcessor.a())
    {
      SSOLog.a("SSOLoginAction", new Object[] { "getCallingPkgName do not use third transform name" });
      return str2;
    }
    String str1 = paramBundle.getString("ppsts");
    if (TextUtils.isEmpty(str1))
    {
      SSOLog.a("SSOLoginAction", new Object[] { "getCallingPkgName ppsts is empty" });
      return str2;
    }
    paramBundle = OpenSdkDESUtils.a(paramBundle);
    str2 = OpenSdkDESUtils.a(str1, paramBundle);
    SSOLog.a("SSOLoginAction", new Object[] { "getCallingPkgName can not get calling package name, use decryptPkgName=", str2 });
    String str3 = AuthorityUtil.a(SharedPrefs.a(), this.jdField_a_of_type_AndroidAppActivity.getIntent());
    HashMap localHashMap = new HashMap();
    localHashMap.put("appId", paramString);
    localHashMap.put("ppsts", str1);
    localHashMap.put("sha", paramBundle);
    StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(str3, "use_third_pkg_name", TextUtils.isEmpty(str2) ^ true, 0L, 0L, localHashMap, "", false);
    return str2;
  }
  
  private String a(Bundle paramBundle, String paramString1, String paramString2)
  {
    return AuthorityUtil.a(paramBundle, a(paramBundle, paramString1), paramString2);
  }
  
  private void a()
  {
    SSOLog.a("SSOLoginAction", new Object[] { "registerLoginReceiver mLoginReceiver=", this.jdField_a_of_type_AndroidContentBroadcastReceiver });
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      return;
    }
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new SSOLoginAction.7(this);
    this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("action_login_sucess"));
  }
  
  private void a(int paramInt, String paramString)
  {
    String str;
    if (paramInt == -1) {
      str = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131694647);
    } else if (TextUtils.isEmpty(paramString)) {
      str = String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131694636), new Object[] { Integer.valueOf(paramInt) });
    } else {
      str = String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696495), new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    AuthUIUtil.a(str, this.jdField_a_of_type_AndroidAppActivity, new SSOLoginAction.5(this, paramInt, paramString));
  }
  
  private void a(int paramInt1, String paramString1, Bundle paramBundle, String paramString2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      a(paramInt1, paramString1);
      return;
    case 110513: 
      a(0, "", "");
      return;
    case 110509: 
      b(paramBundle, paramString2, paramInt2);
      return;
    case 1002: 
    case 110530: 
      a(paramBundle, paramString2, false);
      return;
    }
    a(paramBundle, paramString2, false, true);
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", paramString1);
    localIntent.putExtra("key_error_detail", paramString2);
    localIntent.putExtra("key_response", "");
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  private void a(Bundle paramBundle, String paramString)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new SSOLoginAction.8(this, paramBundle, paramString));
  }
  
  private void a(Bundle paramBundle, String paramString, int paramInt)
  {
    SSOLog.a("SSOLoginAction", new Object[] { "doVirtualAuth" });
    String str3 = AuthorityUtil.a(SharedPrefs.a(), this.jdField_a_of_type_AndroidAppActivity.getIntent());
    if (TextUtils.isEmpty(str3))
    {
      SSOLog.a("SSOLoginAction", new Object[] { "doVirtualAuth currentUin is null, goto old auth" });
      a(paramBundle, paramString, false);
      return;
    }
    String str2 = paramBundle.getString("key_proxy_appid");
    String str1;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramString;
    } else {
      str1 = str2;
    }
    long l = System.currentTimeMillis();
    AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
    AccountManage.a().a(str3, str1, paramInt, new SSOLoginAction.3(this, paramBundle, paramString, l, str2, paramInt));
  }
  
  private void a(Bundle paramBundle, String paramString, Intent paramIntent, boolean paramBoolean)
  {
    SSOLog.a("SSOLoginAction", new Object[] { "toMainLogin qq is not login, first login it" });
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_AndroidContentIntent.putExtra("authority_start_qq_login", true);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("intent_router", paramBoolean);
    paramIntent = new Intent();
    paramIntent.putExtra("authority_start_qq_login", true);
    paramIntent.putExtra("appid", paramString);
    paramIntent.putExtra("param_qr_code_url", a(paramBundle, paramString, "main"));
    paramIntent.setFlags(268435456);
    paramIntent.addFlags(32768);
    AuthModelUtil.a(paramIntent, paramBundle, paramString);
    a();
    RouteUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramIntent, "/base/login");
  }
  
  private void a(Bundle paramBundle, String paramString1, String paramString2)
  {
    SSOLog.a("SSOLoginAction", new Object[] { "doRouterForImBlock" });
    String str2 = paramBundle.getString("key_proxy_appid");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramString1;
    }
    AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
    AccountManage.a().a(paramString2, str1, 1, new SSOLoginAction.6(this, paramBundle, paramString1, paramString2));
  }
  
  private void a(Bundle paramBundle, String paramString, boolean paramBoolean)
  {
    a(paramBundle, paramString, paramBoolean, false);
  }
  
  private void a(Bundle paramBundle, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    SSOLog.a("SSOLoginAction", new Object[] { "routerToAuthActivity isForceToLogin=", Boolean.valueOf(paramBoolean2), ", isNew=", Boolean.valueOf(paramBoolean1) });
    if ((!paramBoolean1) && (!TextUtils.isEmpty(AuthParamUtil.a(paramBundle, "key_proxy_appid"))))
    {
      SSOLog.a("SSOLoginAction", new Object[] { "routerToAuthActivity to old login, not support" });
      a(-10000, "error", "not support proxy login");
      return;
    }
    b();
    Intent localIntent = new Intent();
    localIntent.putExtra("key_action", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("key_params", paramBundle);
    localIntent.putExtra("param_qr_code_url", a(paramBundle, paramString, "add"));
    if (a(paramBoolean2))
    {
      a(paramBundle, paramString, localIntent, paramBoolean1);
      return;
    }
    a(paramBoolean1, localIntent);
  }
  
  private void a(AccountInfo paramAccountInfo, String paramString1, String paramString2, Bundle paramBundle, int paramInt)
  {
    AuthMemoryCache.a().a(paramString1, paramAccountInfo);
    b(paramAccountInfo, paramString1, paramString2, paramBundle, paramInt);
  }
  
  private void a(String paramString1, Bundle paramBundle, String paramString2)
  {
    SSOLog.a("SSOLoginAction", new Object[] { "getTicketNoPasswd onFail" });
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(SharedPrefs.a())))
    {
      a(paramBundle, paramString2, false, true);
      AuthReporter.a(paramString1, "0X800B65D");
      return;
    }
    a(paramBundle, paramString2, false);
  }
  
  private void a(boolean paramBoolean, Intent paramIntent)
  {
    try
    {
      SSOLog.a("SSOLoginAction", new Object[] { "go to auth UI" });
      if (paramBoolean)
      {
        paramIntent.putExtra("public_fragment_window_feature", 1);
        QPublicFragmentActivity.Launcher.a(this.jdField_a_of_type_AndroidAppActivity, paramIntent, PublicFragmentActivityForOpenSDK.class, OpenAuthorityFragment.class, 0);
        return;
      }
      paramIntent.setComponent(new ComponentName(this.jdField_a_of_type_AndroidAppActivity, AuthorityActivity.class));
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramIntent, 0);
      return;
    }
    catch (ActivityNotFoundException paramIntent)
    {
      SSOLog.c("SSOLoginAction", "start Auth ActivityNotFoundException ", paramIntent);
      a(this.jdField_a_of_type_AndroidAppActivity, -6);
    }
  }
  
  private boolean a(Bundle paramBundle, String paramString)
  {
    if (!OpenSdkSwitchProcessor.b(467).a().a) {
      return false;
    }
    ThreadManager.excute(new SSOLoginAction.1(this, paramBundle, paramString), 128, null, false);
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return true;
    }
    if ((a() != null) && (a().isLogin())) {
      return false;
    }
    return TextUtils.isEmpty(SharedPrefs.a());
  }
  
  private String[] a(Bundle paramBundle, String paramString)
  {
    String str = a(paramBundle, paramString);
    if (TextUtils.isEmpty(str))
    {
      paramBundle = new HashMap();
      paramBundle.put("appId", paramString);
      str = AuthorityUtil.a(SharedPrefs.a(), this.jdField_a_of_type_AndroidAppActivity.getIntent());
      StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(str, "login_pkg_name_empty", true, 0L, 0L, paramBundle, "", false);
      AuthReporter.a(1, "LOGIN_CHECK_AGENT", null, paramString, 0, "AgentActivity callingPkgName is null");
      return new String[] { "", "" };
    }
    String[] arrayOfString = OpenSdkVirtualUtil.a(str);
    paramBundle.putString("packagename", str);
    paramBundle.putString("packagesign", arrayOfString[0]);
    paramBundle.putString("sign", arrayOfString[1]);
    paramBundle.putString("time", arrayOfString[2]);
    AuthReporter.a(0, "LOGIN_CHECK_AGENT", null, paramString, 0, null);
    return new String[] { arrayOfString[1], arrayOfString[2] };
  }
  
  private void b()
  {
    a().a(new SSOLoginAction.9(this));
  }
  
  private void b(Bundle paramBundle, String paramString)
  {
    SSOLog.a("SSOLoginAction", new Object[] { "addExpiredRunnable mExpiredRunnable=", this.jdField_a_of_type_JavaLangRunnable });
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      return;
    }
    this.jdField_a_of_type_JavaLangRunnable = new SSOLoginAction.11(this, paramBundle, paramString);
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 20000L);
  }
  
  private void b(Bundle paramBundle, String paramString, int paramInt)
  {
    if (paramInt == 1)
    {
      a(paramBundle, paramString, 3);
      return;
    }
    a(paramBundle, paramString, true, true);
  }
  
  private void b(AccountInfo paramAccountInfo, String paramString1, String paramString2, Bundle paramBundle, int paramInt)
  {
    a(paramBundle, paramString1);
    new SSOPreAuthPresenter().a(AuthorityUtil.a(this.jdField_a_of_type_AndroidAppActivity), paramString1, paramString2, paramBundle, paramAccountInfo, new SSOLoginAction.4(this, paramBundle, paramString1, paramInt), 0);
  }
  
  private boolean b(Bundle paramBundle, String paramString)
  {
    String str = AuthorityUtil.a(SharedPrefs.a(), this.jdField_a_of_type_AndroidAppActivity.getIntent());
    if (!TextUtils.isEmpty(str))
    {
      if (!str.equals(SharedPrefs.a())) {
        return false;
      }
      ThreadManager.excute(new SSOLoginAction.2(this, paramBundle, paramString, str), 128, null, false);
      return true;
    }
    return false;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new SSOLoginAction.10(this));
  }
  
  private void c(Bundle paramBundle, String paramString)
  {
    SSOLog.a("SSOLoginAction", new Object[] { "registerExpiredReceiver mExpiredReceiver=", this.b });
    if (this.b != null) {
      return;
    }
    this.b = new SSOLoginAction.12(this, paramBundle, paramString);
    this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.b, new IntentFilter("mqq.intent.action.ACCOUNT_EXPIRED"));
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      SSOLog.a("SSOLoginAction", new Object[] { "removeExpiredRunnable" });
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
  
  private void e()
  {
    SSOLog.a("SSOLoginAction", new Object[] { "unregisterExpiredReceiver mExpiredReceiver=", this.b });
    BroadcastReceiver localBroadcastReceiver = this.b;
    if (localBroadcastReceiver == null) {
      return;
    }
    try
    {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(localBroadcastReceiver);
    }
    catch (Exception localException)
    {
      SSOLog.c("SSOLoginAction", "unregisterExpiredReceiver", localException);
    }
    this.b = null;
  }
  
  private void f()
  {
    SSOLog.b("SSOLoginAction", new Object[] { "unregisterLoginReceiver=", this.jdField_a_of_type_AndroidContentBroadcastReceiver });
    BroadcastReceiver localBroadcastReceiver = this.jdField_a_of_type_AndroidContentBroadcastReceiver;
    if (localBroadcastReceiver == null) {
      return;
    }
    try
    {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(localBroadcastReceiver);
    }
    catch (Exception localException)
    {
      SSOLog.c("SSOLoginAction", "unRegisterLoginReceiver", localException);
    }
    this.b = null;
  }
  
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    paramActivity = paramBundle.getString("client_id");
    SSOLog.a("SSOLoginAction", new Object[] { "ssoLogin appId=", paramActivity, ", sdkv=", AuthParamUtil.a(paramBundle, "sdkv") });
    AuthReporter.a(a().getCurrentAccountUin(), paramActivity, "8", "0", true);
    if (a(paramBundle, paramActivity)) {
      return;
    }
    if (b(paramBundle, paramActivity)) {
      return;
    }
    a(paramBundle, paramActivity, false);
  }
  
  protected boolean a(Activity paramActivity, Bundle paramBundle)
  {
    if (super.a(paramActivity, paramBundle)) {
      return true;
    }
    AuthReporter.a(1, "LOGIN_CHECK_AGENT", null, null, 0, "AgentActivity bundle is null");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.strategy.SSOLoginAction
 * JD-Core Version:    0.7.0.1
 */