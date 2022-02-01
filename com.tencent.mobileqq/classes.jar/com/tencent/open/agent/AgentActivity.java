package com.tencent.open.agent;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.decoupleim.ThirdPartyLoginBlockUtilImpl;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.business.OpenSdkConfProcessor;
import com.tencent.mobileqq.config.business.OpenSdkIFrameProcessor;
import com.tencent.mobileqq.config.business.OpenSdkSwitchConfBean;
import com.tencent.mobileqq.config.business.OpenSdkSwitchConfBean.OpenSdkSwitchConfig;
import com.tencent.mobileqq.config.business.OpenSdkSwitchProcessor;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.open.OpenSdkQIPCClient;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.OpenSdkDESUtils;
import com.tencent.open.business.base.Constants;
import com.tencent.open.data.SharedPrefs;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.settings.OpensdkPreference;
import com.tencent.open.virtual.OpenSdkVirtualManager;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.LoginHelper;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.security.MessageDigest;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.observer.SSOAccountObserver;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class AgentActivity
  extends BaseActivity
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Intent jdField_a_of_type_AndroidContentIntent = null;
  protected Handler a;
  protected QQProgressDialog a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  protected String a;
  private SSOAccountObserver jdField_a_of_type_MqqObserverSSOAccountObserver;
  protected boolean a;
  private BroadcastReceiver b;
  protected boolean b;
  private BroadcastReceiver jdField_c_of_type_AndroidContentBroadcastReceiver = new AgentActivity.9(this);
  private boolean jdField_c_of_type_Boolean = false;
  
  public AgentActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_b_of_type_Boolean = false;
  }
  
  private OpenSDKAppInterface a()
  {
    OpenSDKAppInterface localOpenSDKAppInterface = (OpenSDKAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    QLog.d("qqBaseActivity", 1, "waitAppRuntime app=" + localOpenSDKAppInterface.hashCode());
    return localOpenSDKAppInterface;
  }
  
  private String a()
  {
    Object localObject = "";
    int i = 0;
    for (;;)
    {
      String str;
      if (i < 3)
      {
        str = super.getCallingPackage();
        localObject = str;
        if (TextUtils.isEmpty(str))
        {
          QLog.i("SDK_LOGIN.AgentActivity", 1, "-->getCallingPackage returns null!");
          localObject = super.getCallingActivity();
          if (localObject == null) {
            break label74;
          }
          str = ((ComponentName)localObject).getPackageName();
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            QLog.i("SDK_LOGIN.AgentActivity", 1, "-->getPackageName from component returns null!");
          }
        }
      }
      for (localObject = str; !TextUtils.isEmpty((CharSequence)localObject); localObject = str)
      {
        return localObject;
        label74:
        QLog.i("SDK_LOGIN.AgentActivity", 1, "-->getCallingActivity returns null!");
      }
      i += 1;
    }
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    String str = "";
    Object localObject = str;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString1, 64).signatures;
      localObject = str;
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localObject = str;
      localMessageDigest.update(paramContext[0].toByteArray());
      localObject = str;
      paramContext = HexUtil.bytes2HexStr(localMessageDigest.digest());
      if (paramContext == null) {
        return "";
      }
      localObject = str;
      paramContext = paramContext.toLowerCase();
      localObject = str;
      QLog.i("SDK_LOGIN.AgentActivity", 1, "-->getAppSignatureMD5, sign: " + paramContext);
      localObject = str;
      localMessageDigest.reset();
      localObject = str;
      localMessageDigest.update((paramString1 + "_" + paramContext + "_" + paramString2 + "").getBytes());
      localObject = str;
      paramContext = HexUtil.bytes2HexStr(localMessageDigest.digest());
      localObject = paramContext;
      localMessageDigest.reset();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      QLog.i("SDK_LOGIN.AgentActivity", 1, "Exception", paramContext);
    }
    return localObject;
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("param_qr_code_url");
    paramIntent.putExtra("key_error_code", 0);
    paramIntent.putExtra("key_response", AuthorityUtil.a(str).toString());
    super.setResult(paramInt, paramIntent);
    super.finish();
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if (isFinishing()) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", paramString1);
    localIntent.putExtra("key_error_detail", paramString2);
    localIntent.putExtra("key_response", "");
    setResult(-1, localIntent);
    finish();
  }
  
  private void a(Bundle paramBundle1, String paramString1, Bundle paramBundle2, String paramString2, String paramString3, String paramString4)
  {
    paramBundle1 = paramBundle1.getString("key_proxy_appid");
    if (TextUtils.isEmpty(paramBundle1)) {}
    for (;;)
    {
      ForwardStatisticsReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      this.jdField_a_of_type_MqqObserverSSOAccountObserver = a().a().a(a(), paramString4, paramString1, 1, new AgentActivity.3(this, paramString3, paramBundle2, paramString2, paramString4));
      return;
      paramString1 = paramBundle1;
    }
  }
  
  private void a(String paramString1, Bundle paramBundle, String paramString2, int paramInt)
  {
    QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "--> doRouterForNewAuth time = ", Long.valueOf(System.currentTimeMillis()) });
    String str3 = AuthorityUtil.a(a(), SharedPrefs.a(), getIntent());
    if (TextUtils.isEmpty(str3))
    {
      QLog.d("SDK_LOGIN.AgentActivity", 1, "--> doRouterForNewAuth currentUin is null,goto old auth");
      d(paramString1, paramBundle, paramString2, false);
      return;
    }
    long l = System.currentTimeMillis();
    new AccountInfo().jdField_a_of_type_JavaLangString = str3;
    ForwardStatisticsReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
    String str2 = paramBundle.getString("key_proxy_appid");
    if (TextUtils.isEmpty(str2)) {}
    for (String str1 = paramString2;; str1 = str2)
    {
      this.jdField_a_of_type_MqqObserverSSOAccountObserver = a().a().a(a(), str3, str1, paramInt, new AgentActivity.8(this, paramString1, paramBundle, paramString2, l, str2, paramInt));
      return;
    }
  }
  
  private void a(String paramString1, Bundle paramBundle, String paramString2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      QLog.d("SDK_LOGIN.AgentActivity", 1, "addExpiredRunnable null != mExpiredRunnable");
      return;
    }
    QLog.d("SDK_LOGIN.AgentActivity", 1, "addExpiredRunnable");
    this.jdField_a_of_type_JavaLangRunnable = new AgentActivity.4(this, paramString1, paramBundle, paramString2, paramBoolean);
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 20000L);
  }
  
  private void a(String paramString1, Bundle paramBundle, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = System.currentTimeMillis();
    Intent localIntent;
    Object localObject1;
    Object localObject2;
    boolean bool;
    if (paramBoolean1)
    {
      localIntent = new Intent();
      localIntent.putExtra("intent_router", 1);
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.putExtra("key_action", paramString1);
      localObject1 = a();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (!OpenSdkConfProcessor.a())) {
        break label692;
      }
      Object localObject3 = paramBundle.getString("ppsts");
      QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "ppsts=", localObject3 });
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject1 = OpenSdkDESUtils.a(paramBundle);
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("appid", paramString2);
        ((HashMap)localObject2).put("ppsts", localObject3);
        ((HashMap)localObject2).put("sha", localObject1);
        localObject1 = OpenSdkDESUtils.a((String)localObject3, (String)localObject1);
        QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "can not get calling package name, use ppsts callFromPackageName=", localObject1 });
        localObject3 = AuthorityUtil.a(a(), SharedPrefs.a(), getIntent());
        localStatisticCollector = StatisticCollector.getInstance(BaseApplicationImpl.getApplication());
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label686;
        }
        bool = true;
        label219:
        localStatisticCollector.collectPerformance((String)localObject3, "use_third_pkg_name", bool, 0L, 0L, (HashMap)localObject2, "", false);
      }
      label238:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label736;
      }
      localObject3 = OpenSdkVirtualUtil.a(this, (String)localObject1);
      StatisticCollector localStatisticCollector = localObject3[0];
      localObject2 = localObject3[1];
      localObject3 = localObject3[2];
      QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "-->onCreate appid: ", paramString2, ", package: ", localObject1, ", getAuthorizeSign.sign: ", localStatisticCollector });
      paramBundle.putString("packagename", (String)localObject1);
      paramBundle.putString("packagesign", localStatisticCollector);
      paramBundle.putString("sign", (String)localObject2);
      paramBundle.putString("time", (String)localObject3);
      AuthorityUtil.a(0, "LOGIN_CHECK_AGENT", null, paramString2, null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
      localObject1 = localObject3;
    }
    for (;;)
    {
      localIntent.putExtra("key_params", paramBundle);
      localIntent.putExtra("param_qr_code_url", AuthorityUtil.a(paramBundle, (String)localObject2, (String)localObject1, "add"));
      if ((!paramBoolean2) && ((getAppInterface() == null) || (getAppInterface().isLogin()) || (!TextUtils.isEmpty(SharedPrefs.a())))) {
        break label834;
      }
      QLog.d("SDK_LOGIN.AgentActivity", 1, " qq is not login isForce = " + paramBoolean2);
      if ((!"action_login".equals(paramString1)) && (!"action_quick_login".equals(paramString1)) && (!"action_ptlogin_login".equals(paramString1))) {
        break label834;
      }
      this.jdField_a_of_type_AndroidContentIntent = localIntent;
      this.jdField_a_of_type_AndroidContentIntent.putExtra("authority_start_qq_login", true);
      QLog.d("SDK_LOGIN.AgentActivity", 1, "qq is not login, first login it");
      localIntent = new Intent();
      localIntent.putExtra("authority_start_qq_login", true);
      localIntent.putExtra("appid", paramString2);
      localIntent.putExtra("param_qr_code_url", AuthorityUtil.a(paramBundle, (String)localObject2, (String)localObject1, "main"));
      ThirdPartyLoginBlockUtilImpl.a().a(localIntent, paramBundle, paramString2);
      if (!"action_ptlogin_login".equals(paramString1))
      {
        localIntent.setFlags(268435456);
        localIntent.addFlags(32768);
      }
      paramString1 = new IntentFilter("action_login_sucess");
      registerReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver, paramString1);
      RouteUtils.a(this, localIntent, "/base/login");
      return;
      if (!TextUtils.isEmpty(paramBundle.getString("key_proxy_appid")))
      {
        QLog.d("SDK_LOGIN.AgentActivity", 1, "routerToAuthActivity to old login, not support");
        a(-10000, "error", "not support proxy login");
        return;
      }
      localIntent = new Intent(this, AuthorityActivity.class);
      break;
      label686:
      bool = false;
      break label219;
      label692:
      QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "isUseThirdTransformPkgName=", Boolean.valueOf(OpenSdkConfProcessor.a()), ", ppsts=", paramBundle.getString("ppsts") });
      break label238;
      label736:
      QLog.i("SDK_LOGIN.AgentActivity", 1, "-->onCreate can not get calling package name!");
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("appid", paramString2);
      localObject2 = AuthorityUtil.a(a(), SharedPrefs.a(), getIntent());
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance((String)localObject2, "login_pkg_name_empty", true, 0L, 0L, (HashMap)localObject1, "", false);
      AuthorityUtil.a(1, "LOGIN_CHECK_AGENT", null, paramString2, null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "AgentActivity callFromPackageName is null");
      localObject1 = "";
      localObject2 = "";
    }
    label834:
    if (paramBoolean1) {}
    for (;;)
    {
      try
      {
        PublicFragmentActivity.Launcher.a(this, localIntent, PublicFragmentActivityForOpenSDK.class, OpenAuthorityFragment.class, 0);
        QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "start_auth_use_time", " launch OpenAuthFragment use time = ", Long.valueOf(System.currentTimeMillis() - l) });
        QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "start_auth_use_time", " start Auth total time = ", Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
        return;
      }
      catch (ActivityNotFoundException paramString1)
      {
        QLog.e("SDK_LOGIN.AgentActivity", 1, new Object[] { "start_auth_use_time", "start Auth ActivityNotFoundException ", paramString1 });
        a(-6);
        super.finish();
        return;
      }
      super.startActivityForResult(localIntent, 0);
    }
  }
  
  private boolean a()
  {
    long l = System.currentTimeMillis();
    OpenSdkSwitchConfBean localOpenSdkSwitchConfBean = OpenSdkSwitchProcessor.b(467);
    QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "start_auth_use_time", " load config use time: ", Long.valueOf(System.currentTimeMillis() - l), " -->OpenSdkSwitchConfBean ", "enable: " + localOpenSdkSwitchConfBean.a().jdField_a_of_type_Boolean });
    return localOpenSdkSwitchConfBean.a().jdField_a_of_type_Boolean;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      QLog.d("SDK_LOGIN.AgentActivity", 1, "removeExpiredRunnable");
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
  
  private void b(String paramString1, Bundle paramBundle, String paramString2, boolean paramBoolean)
  {
    QLog.d("SDK_LOGIN.AgentActivity", 1, "registerExpiredReceiver");
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      QLog.d("SDK_LOGIN.AgentActivity", 1, "null != mExpiredReceiver");
      return;
    }
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new AgentActivity.5(this, paramString1, paramBundle, paramString2, paramBoolean);
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("mqq.intent.action.ACCOUNT_EXPIRED"));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      QLog.d("SDK_LOGIN.AgentActivity", 1, "unRegisterLoginReceiver");
    }
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("SDK_LOGIN.AgentActivity", 1, "unRegisterLoginReceiver", localException);
      }
    }
  }
  
  private void c(String paramString1, Bundle paramBundle, String paramString2, boolean paramBoolean)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      QLog.d("SDK_LOGIN.AgentActivity", 1, "registerExpiredCallback");
      a(paramString1, paramBundle, paramString2, paramBoolean);
      b(paramString1, paramBundle, paramString2, paramBoolean);
      return;
    }
    QLog.d("SDK_LOGIN.AgentActivity", 1, "registerExpiredCallback post");
    ThreadManager.getUIHandler().post(new AgentActivity.6(this, paramString1, paramBundle, paramString2, paramBoolean));
  }
  
  private void d()
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      QLog.d("SDK_LOGIN.AgentActivity", 1, "unregisterExpiredCallback");
      c();
      b();
      return;
    }
    QLog.d("SDK_LOGIN.AgentActivity", 1, "unregisterExpiredCallback post");
    ThreadManager.getUIHandler().post(new AgentActivity.7(this));
  }
  
  private void d(String paramString1, Bundle paramBundle, String paramString2, boolean paramBoolean)
  {
    a(paramString1, paramBundle, paramString2, paramBoolean, false);
  }
  
  private void e()
  {
    if (isFinishing()) {
      QLog.i("SDK_LOGIN.AgentActivity", 1, "-->showLoading activity is finishing");
    }
    for (;;)
    {
      return;
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
      }
      catch (Exception localException)
      {
        QLog.i("SDK_LOGIN.AgentActivity", 1, "-->showLoading Exception:", localException);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, 0, 2131561556, 17);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(-1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void f()
  {
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      QLog.d("qqBaseActivity", 1, "ssoLoginByImBlock null == intent");
      return;
    }
    String str1 = localIntent.getStringExtra("appid");
    String str2 = localIntent.getStringExtra("uin");
    String str3 = localIntent.getStringExtra("passwd");
    boolean bool = localIntent.getBooleanExtra("is_from_login", false);
    if (OpenSdkIFrameProcessor.a())
    {
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = new AgentActivity.10(this);
      registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, new IntentFilter("mqq.opensdk.intent.action.PUZZLEVERIFYCODE"));
    }
    this.jdField_a_of_type_Int += 1;
    LoginHelper.a(str1, str2, str3, new AgentActivity.11(this, bool));
  }
  
  private void g()
  {
    Object localObject = getIntent();
    label259:
    for (;;)
    {
      try
      {
        localObject = ((Intent)localObject).getBundleExtra("key_params");
        if (localObject == null)
        {
          QLog.e("qqBaseActivity", 1, "extra bundle is null");
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("qqBaseActivity", 1, "-->checkIntentParam Exception", localException);
        return;
      }
      String str = localException.getString("client_id");
      if (TextUtils.isEmpty(str))
      {
        QLog.e("qqBaseActivity", 1, "appid is empty");
        str = localException.getString("key_proxy_appid");
        if (!TextUtils.isEmpty(str)) {
          break label194;
        }
        QLog.d("qqBaseActivity", 1, "proxy appid is empty");
        label86:
        if (TextUtils.isEmpty(localException.getString("ppsts"))) {
          QLog.e("qqBaseActivity", 1, "ppst is empty");
        }
        str = getCallingPackage();
        if (!TextUtils.isEmpty(str)) {
          break label236;
        }
        QLog.e("qqBaseActivity", 1, "unable to get package name");
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(localException.getString("scope"))) {
          break label259;
        }
        QLog.e("qqBaseActivity", 1, "scope is empty");
        return;
        if (PortalUtils.a(str)) {
          break;
        }
        QLog.e("qqBaseActivity", 1, "appid " + str + " is not numeric");
        break;
        label194:
        if (PortalUtils.a(str)) {
          break label86;
        }
        QLog.e("qqBaseActivity", 1, "proxy appid " + str + " is not numeric");
        break label86;
        label236:
        if (TextUtils.isEmpty(OpenSdkVirtualUtil.a(this, str)[1])) {
          QLog.e("qqBaseActivity", 1, "unable to get signature");
        }
      }
    }
  }
  
  protected void a()
  {
    if ((!super.isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      return;
    }
    catch (Exception localException)
    {
      QLog.i("SDK_LOGIN.AgentActivity", 1, "-->dismissDialogProgress Exception:", localException);
    }
  }
  
  protected void a(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", Constants.c);
    localIntent.putExtra("key_error_detail", "");
    localIntent.putExtra("key_response", "");
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    OpenSdkQIPCClient.a();
    ForwardStatisticsReporter.a();
    ForwardStatisticsReporter.a("KEY_LOGIN_STAGE_1_TOTAL");
    ForwardStatisticsReporter.a("KEY_AUTHORITY_TOTAL");
    e();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if ((super.getIntent() == null) || (paramBundle != null))
    {
      QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "-->onCreate, intent: ", super.getIntent(), " | savedInstanceState: ", paramBundle });
      AuthorityUtil.a(1, "LOGIN_CHECK_AGENT", null, null, null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "AgentActivity getIntent is null");
    }
    Object localObject;
    for (;;)
    {
      return true;
      g();
      String str1 = AuthorityUtil.a(super.getIntent(), "key_action");
      this.jdField_a_of_type_JavaLangString = str1;
      QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "-->onCreate, action: ", str1 });
      if ("action_sso_login_by_im_block".equals(str1))
      {
        f();
        return true;
      }
      try
      {
        localBundle = super.getIntent().getBundleExtra("key_params");
        if (localBundle == null)
        {
          a(-5);
          if (!"action_login".equals(str1)) {
            continue;
          }
          AuthorityUtil.a(1, "LOGIN_CHECK_AGENT", null, null, null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "AgentActivity bundle is null");
          return true;
        }
      }
      catch (Exception paramBundle)
      {
        Bundle localBundle;
        for (;;)
        {
          QLog.e("SDK_LOGIN.AgentActivity", 1, "-->onCreate Exception", paramBundle);
          localBundle = null;
        }
        String str2 = localBundle.getString("client_id");
        if ("action_login".equals(str1))
        {
          QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "-->loginAction, action: ", str1, ", appid=", str2, ", sdkv=", localBundle.getString("sdkv") });
          if (a()) {
            ThreadManager.executeOnNetWorkThread(new AgentActivity.1(this, str1, localBundle, str2));
          }
          for (;;)
          {
            ReportCenter.a().a(getAppInterface().getCurrentAccountUin(), "", str2, "1", "8", "0", true, true);
            return true;
            paramBundle = AuthorityUtil.a(a(), SharedPrefs.a(), getIntent());
            if ((!TextUtils.isEmpty(paramBundle)) && (paramBundle.equals(SharedPrefs.a()))) {
              ThreadManager.executeOnNetWorkThread(new AgentActivity.2(this, localBundle, str2, str1, paramBundle));
            } else {
              d(str1, localBundle, str2, false);
            }
          }
        }
        if ("action_pay".equals(str1))
        {
          localObject = new Intent(this, AuthorityActivity.class);
          ((Intent)localObject).putExtra("key_action", str1);
        }
        while (localObject != null)
        {
          ((Intent)localObject).putExtra("key_params", localBundle);
          if ((getAppInterface() == null) || (getAppInterface().isLogin())) {
            break label968;
          }
          QLog.d("SDK_LOGIN.AgentActivity", 1, " qq is not login");
          if ((!"action_login".equals(str1)) && (!"action_quick_login".equals(str1)) && (!"action_ptlogin_login".equals(str1))) {
            break label968;
          }
          this.jdField_a_of_type_AndroidContentIntent = ((Intent)localObject);
          this.jdField_a_of_type_AndroidContentIntent.putExtra("authority_start_qq_login", true);
          QLog.d("SDK_LOGIN.AgentActivity", 1, "qq is not login, first login it");
          paramBundle = new Intent();
          paramBundle.putExtra("authority_start_qq_login", true);
          ThirdPartyLoginBlockUtilImpl.a().a(paramBundle, localBundle, str2);
          if (!"action_ptlogin_login".equals(str1))
          {
            paramBundle.setFlags(268435456);
            paramBundle.addFlags(32768);
          }
          localObject = new IntentFilter("action_login_sucess");
          registerReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
          RouteUtils.a(this, paramBundle, "/base/login");
          AuthorityUtil.a(getAppInterface().getCurrentAccountUin(), "", str2, "1", "8", "0", true);
          return true;
          if ((!"action_quick_login".equals(str1)) && (!"action_ptlogin_login".equals(str1))) {
            break label751;
          }
          this.jdField_c_of_type_Boolean = true;
          paramBundle = a();
          QLog.d("SDK_LOGIN.AgentActivity", 1, "-->packagename: " + paramBundle);
          localObject = new Intent(this, QuickLoginAuthorityActivity.class);
          ((Intent)localObject).putExtra("key_action", str1);
          localBundle.putString("packagename", paramBundle);
        }
        label751:
        if (("action_invite".equals(str1)) || ("action_gift".equals(str1)) || ("action_ask".equals(str1)) || ("action_reactive".equals(str1)))
        {
          ForwardStatisticsReporter.a(str1, 0L);
          paramBundle = new Intent(this, SocialFriendChooser.class);
        }
        for (;;)
        {
          localObject = paramBundle;
          if (paramBundle == null) {
            break;
          }
          paramBundle.putExtra("key_action", str1);
          localObject = localBundle.getString("hopenid");
          localBundle.putString("encrytoken", OpensdkPreference.a(this, "openid_encrytoken").getString((String)localObject, ""));
          localObject = paramBundle;
          break;
          if ("action_story".equals(str1))
          {
            ForwardStatisticsReporter.a(str1, 0L);
            paramBundle = new Intent(this, SendStoryActivity.class);
          }
          else if ("action_brag".equals(str1))
          {
            ForwardStatisticsReporter.a(str1, 0L);
            paramBundle = new Intent(this, BragActivity.class);
          }
          else
          {
            if (!"action_challenge".equals(str1)) {
              break label960;
            }
            ForwardStatisticsReporter.a(str1, 0L);
            paramBundle = new Intent(this, ChallengeActivity.class);
          }
        }
        label960:
        a(-5);
        return true;
      }
    }
    try
    {
      label968:
      super.startActivityForResult((Intent)localObject, 0);
      return true;
    }
    catch (ActivityNotFoundException paramBundle)
    {
      QLog.e("SDK_LOGIN.AgentActivity", 1, "ActivityNotFoundException", paramBundle);
      a(-6);
      super.finish();
    }
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    boolean bool = this.jdField_b_of_type_Boolean;
    int i = this.jdField_a_of_type_Int;
    if (getAppInterface() == null) {}
    for (Boolean localBoolean = null;; localBoolean = Boolean.valueOf(getAppInterface().isLogin()))
    {
      QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "-->onResume mOnResumeIsInited=", Boolean.valueOf(bool), ", mWaitingCallbackCount=", Integer.valueOf(i), ", isLogin=", localBoolean });
      if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Int != 0)) {
        break;
      }
      setResult(0);
      finish();
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.d("SDK_LOGIN.AgentActivity", 1, "-->onActivityResult, action: " + this.jdField_a_of_type_JavaLangString + " | requestCode: " + paramInt1 + " | resultCode: " + paramInt2 + " | data: " + paramIntent);
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("param_is_qr_code_login", false)))
    {
      a(paramInt2, paramIntent);
      return;
    }
    super.setResult(paramInt2, paramIntent);
    super.finish();
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("moveTaskToBack", false))) {
      moveTaskToBack(true);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a();
    QLog.d("SDK_LOGIN.AgentActivity", 1, "-->onDestroy, action: " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = null;
    d();
    if (this.jdField_a_of_type_Boolean)
    {
      boolean bool = GesturePWDUtils.isAppOnForeground(this);
      if (!bool) {
        GesturePWDUtils.setAppForground(this, bool);
      }
      EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("open_sdk_qipc_module", "action_on_agent_activity_destroy", new Bundle());
      QLog.d("qqBaseActivity", 1, "[onDestroy] ipc result: " + localEIPCResult.code);
    }
    OpenSdkQIPCClient.b();
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.flushLog(true);
      Process.killProcess(Process.myPid());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.open.agent.AgentActivity
 * JD-Core Version:    0.7.0.1
 */