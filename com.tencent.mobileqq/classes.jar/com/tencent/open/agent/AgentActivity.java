package com.tencent.open.agent;

import Override;
import afez;
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
import aonw;
import arfu;
import argf;
import argg;
import argh;
import avcw;
import bdmc;
import bhml;
import bjbs;
import bjjj;
import bjjp;
import bjjq;
import bjjt;
import bjqh;
import bjqq;
import bjqr;
import bjvb;
import bjwg;
import bjzb;
import bjzm;
import bjzo;
import bjzy;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.open.model.AccountManage;
import com.tencent.open.model.AccountManage.RefreshReason;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.observer.SSOAccountObserver;
import mqq.os.MqqHandler;

public class AgentActivity
  extends BaseActivity
{
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Intent jdField_a_of_type_AndroidContentIntent;
  protected Handler a;
  protected bjbs a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  protected String a;
  private SSOAccountObserver jdField_a_of_type_MqqObserverSSOAccountObserver;
  protected boolean a;
  private BroadcastReceiver b;
  protected boolean b;
  private boolean c;
  
  public AgentActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_b_of_type_AndroidContentBroadcastReceiver = new bjjt(this);
  }
  
  private OpenSDKAppInterface a()
  {
    OpenSDKAppInterface localOpenSDKAppInterface = (OpenSDKAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    QLog.d("qqBaseActivity", 1, "waitAppRuntime app=" + localOpenSDKAppInterface.hashCode());
    return localOpenSDKAppInterface;
  }
  
  private String a()
  {
    AccountManage.a().a();
    Object localObject3 = bjwg.a();
    Object localObject2 = null;
    if (a().isLogin()) {
      localObject2 = a().getAccount();
    }
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = (String)((ArrayList)localObject3).get(0);
      }
    }
    localObject3 = bjqq.a(getIntent(), "login_success_uin");
    localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject2 = localObject1;
      if (!((String)localObject3).equals(localObject1))
      {
        QLog.d("SDK_LOGIN.AgentActivity", 1, "--> doRouterForNewAuth set currentUin loginUin");
        localObject2 = localObject3;
      }
    }
    return localObject2;
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
      paramContext = bhml.a(localMessageDigest.digest());
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
      paramContext = bhml.a(localMessageDigest.digest());
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
  
  private void a(String paramString1, Bundle paramBundle, String paramString2)
  {
    QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "--> doRouterForNewAuth time = ", Long.valueOf(System.currentTimeMillis()) });
    String str3 = a();
    if (TextUtils.isEmpty(str3))
    {
      QLog.d("SDK_LOGIN.AgentActivity", 1, "--> doRouterForNewAuth currentUin is null,goto old auth");
      d(paramString1, paramBundle, paramString2, false);
      return;
    }
    long l = System.currentTimeMillis();
    new bjzb().jdField_a_of_type_JavaLangString = str3;
    avcw.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
    String str2 = paramBundle.getString("key_proxy_appid");
    if (TextUtils.isEmpty(str2)) {}
    for (String str1 = paramString2;; str1 = str2)
    {
      this.jdField_a_of_type_MqqObserverSSOAccountObserver = a().a().a(a(), str3, str1, AccountManage.RefreshReason.useCacheFirst, new bjjq(this, paramString1, paramBundle, paramString2, l, str2));
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
    this.jdField_a_of_type_JavaLangRunnable = new AgentActivity.2(this, paramString1, paramBundle, paramString2, paramBoolean);
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 20000L);
  }
  
  private void a(String paramString1, Bundle paramBundle, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = System.currentTimeMillis();
    Intent localIntent;
    Object localObject1;
    boolean bool;
    if (paramBoolean1)
    {
      localIntent = new Intent();
      localIntent.putExtra("intent_router", 1);
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.putExtra("key_action", paramString1);
      localObject1 = b();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (!arfu.a())) {
        break label628;
      }
      Object localObject2 = paramBundle.getString("ppsts");
      QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "ppsts=", localObject2 });
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = bjqr.a(paramBundle);
        localHashMap = new HashMap();
        localHashMap.put("appid", paramString2);
        localHashMap.put("ppsts", localObject2);
        localHashMap.put("sha", localObject1);
        localObject1 = bjqr.a((String)localObject2, (String)localObject1);
        QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "can not get calling package name, use ppsts callFromPackageName=", localObject1 });
        localObject2 = bdmc.a(BaseApplicationImpl.getApplication());
        localObject3 = a();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label622;
        }
        bool = true;
        label209:
        ((bdmc)localObject2).a((String)localObject3, "use_third_pkg_name", bool, 0L, 0L, localHashMap, "", false);
      }
      label228:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label672;
      }
      Object localObject3 = bjzy.a(this, (String)localObject1);
      HashMap localHashMap = localObject3[0];
      localObject2 = localObject3[1];
      localObject3 = localObject3[2];
      QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "-->onCreate appid: ", paramString2, ", package: ", localObject1, ", getAuthorizeSign.sign: ", localHashMap });
      paramBundle.putString("packagename", (String)localObject1);
      paramBundle.putString("packagesign", localHashMap);
      paramBundle.putString("sign", (String)localObject2);
      paramBundle.putString("time", (String)localObject3);
      bjqq.a(0, "LOGIN_CHECK_AGENT", null, paramString2, null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
    }
    for (;;)
    {
      if (localIntent != null)
      {
        localIntent.putExtra("key_params", paramBundle);
        if ((!paramBoolean2) && ((getAppInterface() == null) || (getAppInterface().isLogin()))) {
          break label748;
        }
        QLog.d("SDK_LOGIN.AgentActivity", 1, " qq is not login isForce = " + paramBoolean2);
        if ((!"action_login".equals(paramString1)) && (!"action_quick_login".equals(paramString1)) && (!"action_ptlogin_login".equals(paramString1))) {
          break label748;
        }
        this.jdField_a_of_type_AndroidContentIntent = localIntent;
        this.jdField_a_of_type_AndroidContentIntent.putExtra("authority_start_qq_login", true);
        QLog.d("SDK_LOGIN.AgentActivity", 1, "qq is not login, first login it");
        localIntent = new Intent(this, LoginActivity.class);
        localIntent.putExtra("authority_start_qq_login", true);
        aonw.a().a(localIntent, paramBundle, paramString2);
        if (!"action_ptlogin_login".equals(paramString1))
        {
          localIntent.setFlags(268435456);
          localIntent.addFlags(32768);
        }
        paramString1 = new IntentFilter("action_login_sucess");
        registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, paramString1);
        startActivity(localIntent);
      }
      return;
      if (!TextUtils.isEmpty(paramBundle.getString("key_proxy_appid")))
      {
        QLog.d("SDK_LOGIN.AgentActivity", 1, "routerToAuthActivity to old login, not support");
        a(-10000, "error", "not support proxy login");
        return;
      }
      localIntent = new Intent(this, AuthorityActivity.class);
      break;
      label622:
      bool = false;
      break label209;
      label628:
      QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "isUseThirdTransformPkgName=", Boolean.valueOf(arfu.a()), ", ppsts=", paramBundle.getString("ppsts") });
      break label228;
      label672:
      QLog.i("SDK_LOGIN.AgentActivity", 1, "-->onCreate can not get calling package name!");
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("appid", paramString2);
      bdmc.a(BaseApplicationImpl.getApplication()).a(a(), "login_pkg_name_empty", true, 0L, 0L, (HashMap)localObject1, "", false);
      bjqq.a(1, "LOGIN_CHECK_AGENT", null, paramString2, null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "AgentActivity callFromPackageName is null");
    }
    label748:
    if (paramBoolean1) {}
    for (;;)
    {
      try
      {
        afez.a(this, localIntent, PublicFragmentActivityForOpenSDK.class, OpenAuthorityFragment.class, 0);
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
    long l1 = System.currentTimeMillis();
    argf localargf = argh.b(467);
    long l2 = System.currentTimeMillis();
    if (localargf == null) {}
    for (String str = "is null";; str = "enable: " + localargf.a().jdField_a_of_type_Boolean)
    {
      QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "start_auth_use_time", " load config use time: ", Long.valueOf(l2 - l1), " -->OpenSdkSwitchConfBean ", str });
      if ((localargf == null) || (!localargf.a().jdField_a_of_type_Boolean)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private String b()
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
            break label76;
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
        label76:
        QLog.i("SDK_LOGIN.AgentActivity", 1, "-->getCallingActivity returns null!");
      }
      i += 1;
    }
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
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bjjp(this, paramString1, paramBundle, paramString2, paramBoolean);
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
    ThreadManager.getUIHandler().post(new AgentActivity.4(this, paramString1, paramBundle, paramString2, paramBoolean));
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
    ThreadManager.getUIHandler().post(new AgentActivity.5(this));
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
        if (this.jdField_a_of_type_Bjbs != null)
        {
          if (this.jdField_a_of_type_Bjbs.isShowing()) {
            continue;
          }
          this.jdField_a_of_type_Bjbs.show();
        }
      }
      catch (Exception localException)
      {
        QLog.i("SDK_LOGIN.AgentActivity", 1, "-->showLoading Exception:", localException);
        return;
      }
    }
    this.jdField_a_of_type_Bjbs = new bjbs(this, 0, 2131561502, 17);
    this.jdField_a_of_type_Bjbs.a(-1);
    this.jdField_a_of_type_Bjbs.show();
  }
  
  protected void a()
  {
    if ((!super.isFinishing()) && (this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bjbs.dismiss();
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
    localIntent.putExtra("key_error_msg", bjvb.c);
    localIntent.putExtra("key_error_detail", "");
    localIntent.putExtra("key_response", "");
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    bjjj.a();
    avcw.a();
    avcw.a("KEY_LOGIN_STAGE_1_TOTAL");
    avcw.a("KEY_AUTHORITY_TOTAL");
    e();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if ((super.getIntent() == null) || (paramBundle != null))
    {
      QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "-->onCreate, intent: ", super.getIntent(), " | savedInstanceState: ", paramBundle });
      bjqq.a(1, "LOGIN_CHECK_AGENT", null, null, null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "AgentActivity getIntent is null");
    }
    Object localObject;
    for (;;)
    {
      return true;
      String str1 = bjqq.a(super.getIntent(), "key_action");
      this.jdField_a_of_type_JavaLangString = str1;
      QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "-->onCreate, action: ", str1 });
      try
      {
        localBundle = super.getIntent().getBundleExtra("key_params");
        if (localBundle == null)
        {
          a(-5);
          if (!"action_login".equals(str1)) {
            continue;
          }
          bjqq.a(1, "LOGIN_CHECK_AGENT", null, null, null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "AgentActivity bundle is null");
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
          QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "-->loginAction, action: ", str1, " time = ", Long.valueOf(System.currentTimeMillis()), ", appid=", str2 });
          if (a()) {
            ThreadManager.executeOnNetWorkThread(new AgentActivity.1(this, str1, localBundle, str2));
          }
          for (;;)
          {
            bjqh.a().a(getAppInterface().getCurrentAccountUin(), "", str2, "1", "8", "0", true);
            return true;
            d(str1, localBundle, str2, false);
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
            break label876;
          }
          QLog.d("SDK_LOGIN.AgentActivity", 1, " qq is not login");
          if ((!"action_login".equals(str1)) && (!"action_quick_login".equals(str1)) && (!"action_ptlogin_login".equals(str1))) {
            break label876;
          }
          this.jdField_a_of_type_AndroidContentIntent = ((Intent)localObject);
          this.jdField_a_of_type_AndroidContentIntent.putExtra("authority_start_qq_login", true);
          QLog.d("SDK_LOGIN.AgentActivity", 1, "qq is not login, first login it");
          paramBundle = new Intent(this, LoginActivity.class);
          paramBundle.putExtra("authority_start_qq_login", true);
          aonw.a().a(paramBundle, localBundle, str2);
          if (!"action_ptlogin_login".equals(str1))
          {
            paramBundle.setFlags(268435456);
            paramBundle.addFlags(32768);
          }
          localObject = new IntentFilter("action_login_sucess");
          registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
          startActivity(paramBundle);
          bjqq.a(getAppInterface().getCurrentAccountUin(), "", str2, "1", "8", "0", true);
          return true;
          if ((!"action_quick_login".equals(str1)) && (!"action_ptlogin_login".equals(str1))) {
            break label683;
          }
          this.c = true;
          paramBundle = super.getCallingPackage();
          if (QLog.isColorLevel()) {
            QLog.d("SDK_LOGIN.AgentActivity", 2, "-->packagename: " + paramBundle);
          }
          localObject = new Intent(this, QuickLoginAuthorityActivity.class);
          ((Intent)localObject).putExtra("key_action", str1);
          localBundle.putString("packagename", paramBundle);
        }
        label683:
        if (("action_invite".equals(str1)) || ("action_gift".equals(str1)) || ("action_ask".equals(str1)) || ("action_reactive".equals(str1))) {
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
          localBundle.putString("encrytoken", bjzm.a(this, "openid_encrytoken").getString((String)localObject, ""));
          localObject = paramBundle;
          break;
          if ("action_story".equals(str1))
          {
            paramBundle = new Intent(this, SendStoryActivity.class);
          }
          else if ("action_brag".equals(str1))
          {
            paramBundle = new Intent(this, BragActivity.class);
          }
          else
          {
            if (!"action_challenge".equals(str1)) {
              break label868;
            }
            paramBundle = new Intent(this, ChallengeActivity.class);
          }
        }
        label868:
        a(-5);
        return true;
      }
    }
    try
    {
      label876:
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
    if (getAppInterface() != null) {
      QLog.d("SDK_LOGIN.AgentActivity", 1, "-->onResume, app.isLogin(): " + getAppInterface().isLogin());
    }
    if (this.jdField_b_of_type_Boolean)
    {
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
    super.setResult(paramInt2, paramIntent);
    super.finish();
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
    bjjj.b();
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
      Process.killProcess(Process.myPid());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.open.agent.AgentActivity
 * JD-Core Version:    0.7.0.1
 */