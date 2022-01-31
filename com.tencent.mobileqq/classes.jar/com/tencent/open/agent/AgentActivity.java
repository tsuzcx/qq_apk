package com.tencent.open.agent;

import abtu;
import amtp;
import amtu;
import amtv;
import amtw;
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
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import aqgh;
import axrl;
import bbdm;
import bcpq;
import bcxn;
import bcxq;
import bded;
import bdem;
import bden;
import bdix;
import bdjo;
import bdke;
import bdna;
import bdnb;
import bdnm;
import bdno;
import bdnz;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

public class AgentActivity
  extends BaseActivity
{
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bcxq(this);
  private Intent jdField_a_of_type_AndroidContentIntent;
  protected Handler a;
  protected bcpq a;
  public OpenSDKAppInterface a;
  protected String a;
  protected boolean a;
  protected boolean b;
  private boolean c;
  
  public AgentActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private String a()
  {
    bdnb.a().a();
    Object localObject3 = bdke.a();
    Object localObject2 = null;
    if (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.isLogin()) {
      localObject2 = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount();
    }
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = (String)((ArrayList)localObject3).get(0);
      }
    }
    localObject3 = bdem.a(getIntent(), "login_success_uin");
    localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject2 = localObject1;
      if (!((String)localObject3).equals(localObject1))
      {
        QLog.d("AgentActivity", 1, "--> doRouterForNewAuth set currentUin loginUin");
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
      paramContext = bbdm.a(localMessageDigest.digest());
      if (paramContext == null) {
        return "";
      }
      localObject = str;
      paramContext = paramContext.toLowerCase();
      localObject = str;
      QLog.i("AgentActivity", 1, "-->getAppSignatureMD5, sign: " + paramContext);
      localObject = str;
      localMessageDigest.reset();
      localObject = str;
      localMessageDigest.update((paramString1 + "_" + paramContext + "_" + paramString2 + "").getBytes());
      localObject = str;
      paramContext = bbdm.a(localMessageDigest.digest());
      localObject = paramContext;
      localMessageDigest.reset();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return localObject;
  }
  
  private void a(int paramInt, String paramString)
  {
    if (isFinishing()) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", paramString);
    localIntent.putExtra("key_error_detail", "");
    localIntent.putExtra("key_response", "");
    setResult(-1, localIntent);
    finish();
  }
  
  private void a(String paramString1, Bundle paramBundle, String paramString2)
  {
    QLog.d("AgentActivity", 1, new Object[] { "--> doRouterForNewAuth time = ", Long.valueOf(System.currentTimeMillis()) });
    String str = a();
    if (TextUtils.isEmpty(str))
    {
      QLog.d("AgentActivity", 1, "--> doRouterForNewAuth currentUin is null,goto old auth");
      a(paramString1, paramBundle, paramString2, false);
      return;
    }
    long l = System.currentTimeMillis();
    new bdna().jdField_a_of_type_JavaLangString = str;
    aqgh.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, str, new bcxn(this, paramString1, paramBundle, paramString2, l));
  }
  
  private void a(String paramString1, Bundle paramBundle, String paramString2, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    Intent localIntent;
    if (paramBoolean)
    {
      localIntent = new Intent();
      localIntent.putExtra("intent_router", 1);
      localIntent.putExtra("public_fragment_window_feature", 1);
    }
    for (;;)
    {
      localIntent.putExtra("key_action", paramString1);
      Object localObject1 = b();
      boolean bool;
      if ((TextUtils.isEmpty((CharSequence)localObject1)) && (amtp.e()))
      {
        Object localObject2 = paramBundle.getString("ppsts");
        QLog.d("AgentActivity", 1, new Object[] { "ppsts=", localObject2 });
        HashMap localHashMap;
        Object localObject3;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = bden.a(paramBundle);
          localHashMap = new HashMap();
          localHashMap.put("appid", paramString2);
          localHashMap.put("ppsts", localObject2);
          localHashMap.put("sha", localObject1);
          localObject1 = bden.a((String)localObject2, (String)localObject1);
          QLog.d("AgentActivity", 1, new Object[] { "can not get calling package name, use ppsts callFromPackageName=", localObject1 });
          localObject2 = axrl.a(BaseApplicationImpl.getApplication());
          localObject3 = a();
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            bool = true;
            label209:
            ((axrl)localObject2).a((String)localObject3, "use_third_pkg_name", bool, 0L, 0L, localHashMap, "", false);
          }
        }
        else
        {
          label228:
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label640;
          }
          localObject3 = bdnz.a(this, (String)localObject1);
          localHashMap = localObject3[0];
          localObject2 = localObject3[1];
          localObject3 = localObject3[2];
          QLog.d("AgentActivity", 1, new Object[] { "-->onCreate appid: ", paramString2, ", package: ", localObject1, ", getAuthorizeSign.sign: ", localHashMap });
          paramBundle.putString("packagename", (String)localObject1);
          paramBundle.putString("packagesign", localHashMap);
          paramBundle.putString("sign", (String)localObject2);
          paramBundle.putString("time", (String)localObject3);
          if (QLog.isColorLevel()) {
            QLog.d("AgentActivity", 2, new Object[] { "-->onCreate, getAuthorizeSign.sign: ", localObject2 });
          }
        }
      }
      try
      {
        bdjo.a().a(0, "LOGIN_CHECK_AGENT", null, paramString2, null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
        for (;;)
        {
          label390:
          if (localIntent != null)
          {
            localIntent.putExtra("key_params", paramBundle);
            if ((getAppInterface() == null) || (getAppInterface().isLogin())) {
              break label723;
            }
            if (QLog.isColorLevel()) {
              QLog.d("AgentActivity", 2, " qq is not login");
            }
            if ((!"action_login".equals(paramString1)) && (!"action_quick_login".equals(paramString1)) && (!"action_ptlogin_login".equals(paramString1))) {
              break label723;
            }
            this.jdField_a_of_type_AndroidContentIntent = localIntent;
            this.jdField_a_of_type_AndroidContentIntent.putExtra("authority_start_qq_login", true);
            if (QLog.isColorLevel()) {
              QLog.d("AgentActivity", 2, "qq is not login, first login it");
            }
            paramBundle = new Intent(this, LoginActivity.class);
            paramBundle.putExtra("authority_start_qq_login", true);
            if (!"action_ptlogin_login".equals(paramString1))
            {
              paramBundle.setFlags(268435456);
              paramBundle.addFlags(32768);
            }
            paramString1 = new IntentFilter("action_login_sucess");
            registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramString1);
            startActivity(paramBundle);
          }
          return;
          localIntent = new Intent(this, AuthorityActivity.class);
          break;
          bool = false;
          break label209;
          QLog.d("AgentActivity", 1, new Object[] { "isUseThirdTransformPkgName=", Boolean.valueOf(amtp.e()), ", ppsts=", paramBundle.getString("ppsts") });
          break label228;
          label640:
          QLog.i("AgentActivity", 1, "-->onCreate can not get calling package name!");
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("appid", paramString2);
          axrl.a(BaseApplicationImpl.getApplication()).a(a(), "login_pkg_name_empty", true, 0L, 0L, (HashMap)localObject1, "", false);
          try
          {
            bdjo.a().a(1, "LOGIN_CHECK_AGENT", null, paramString2, null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "AgentActivity callFromPackageName is null");
          }
          catch (Exception paramString2) {}
        }
        label723:
        if (paramBoolean) {
          try
          {
            abtu.a(this, localIntent, PublicFragmentActivityForOpenSDK.class, OpenAuthorityFragment.class, 0);
            QLog.d("AgentActivity", 1, new Object[] { "start_auth_use_time", " launch OpenAuthFragment use time = ", Long.valueOf(System.currentTimeMillis() - l) });
            QLog.d("AgentActivity", 1, new Object[] { "start_auth_use_time", " start Auth total time = ", Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
            return;
          }
          catch (ActivityNotFoundException paramString1)
          {
            QLog.e("AgentActivity", 1, new Object[] { "start_auth_use_time", "start Auth ActivityNotFoundException ", paramString1 });
            a(-6);
            super.finish();
            return;
          }
        }
        super.startActivityForResult(localIntent, 0);
        QLog.d("AgentActivity", 1, new Object[] { "start_auth_use_time start Auth total time = ", Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
        return;
      }
      catch (Exception paramString2)
      {
        break label390;
      }
    }
  }
  
  private boolean a()
  {
    long l1 = System.currentTimeMillis();
    amtu localamtu = amtw.b(467);
    long l2 = System.currentTimeMillis();
    if (localamtu == null) {}
    for (String str = "is null";; str = "enable: " + localamtu.a().jdField_a_of_type_Boolean)
    {
      QLog.d("AgentActivity", 1, new Object[] { "start_auth_use_time", " load config use time: ", Long.valueOf(l2 - l1), " -->OpenSdkSwitchConfBean ", str });
      if ((localamtu == null) || (!localamtu.a().jdField_a_of_type_Boolean)) {
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
          QLog.i("AgentActivity", 1, "-->getCallingPackage returns null!");
          localObject = super.getCallingActivity();
          if (localObject == null) {
            break label76;
          }
          str = ((ComponentName)localObject).getPackageName();
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            QLog.i("AgentActivity", 1, "-->getPackageName from component returns null!");
          }
        }
      }
      for (localObject = str; !TextUtils.isEmpty((CharSequence)localObject); localObject = str)
      {
        return localObject;
        label76:
        QLog.i("AgentActivity", 1, "-->getCallingActivity returns null!");
      }
      i += 1;
    }
  }
  
  private void b()
  {
    if (isFinishing()) {
      QLog.i("AgentActivity", 1, "-->showLoading activity is finishing");
    }
    for (;;)
    {
      return;
      try
      {
        if (this.jdField_a_of_type_Bcpq != null)
        {
          if (this.jdField_a_of_type_Bcpq.isShowing()) {
            continue;
          }
          this.jdField_a_of_type_Bcpq.show();
        }
      }
      catch (Exception localException)
      {
        QLog.i("AgentActivity", 1, "-->showLoading Exception:", localException);
        return;
      }
    }
    this.jdField_a_of_type_Bcpq = new bcpq(this, 0, 2131561034, 17);
    this.jdField_a_of_type_Bcpq.a(-1);
    this.jdField_a_of_type_Bcpq.show();
  }
  
  protected void a()
  {
    if ((!super.isFinishing()) && (this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bcpq.dismiss();
      return;
    }
    catch (Exception localException)
    {
      QLog.i("AgentActivity", 1, "-->dismissDialogProgress Exception:", localException);
    }
  }
  
  protected void a(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", bdix.c);
    localIntent.putExtra("key_error_detail", "");
    localIntent.putExtra("key_response", "");
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Bundle localBundle = null;
    super.doOnCreate(paramBundle);
    aqgh.a();
    aqgh.a("KEY_LOGIN_STAGE_1_TOTAL");
    aqgh.a("KEY_AUTHORITY_TOTAL");
    b();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)super.getAppRuntime());
    if ((super.getIntent() == null) || (paramBundle != null)) {
      QLog.d("AgentActivity", 1, new Object[] { "-->onCreate, intent: ", super.getIntent(), " | savedInstanceState: ", paramBundle });
    }
    for (;;)
    {
      try
      {
        bdjo.a().a(1, "LOGIN_CHECK_AGENT", null, null, null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "AgentActivity getIntent is null");
        return true;
      }
      catch (Exception paramBundle) {}
      Object localObject2 = "";
      try
      {
        paramBundle = super.getIntent().getStringExtra("key_action");
        localObject2 = paramBundle;
      }
      catch (Exception paramBundle)
      {
        Object localObject1;
        continue;
      }
      this.jdField_a_of_type_JavaLangString = ((String)localObject2);
      QLog.d("AgentActivity", 1, new Object[] { "-->onCreate, action: ", localObject2 });
      try
      {
        paramBundle = super.getIntent().getBundleExtra("key_params");
        localBundle = paramBundle;
        if (localBundle == null)
        {
          a(-5);
          if (!"action_login".equals(localObject2)) {
            continue;
          }
          try
          {
            bdjo.a().a(1, "LOGIN_CHECK_AGENT", null, null, null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "AgentActivity bundle is null");
            return true;
          }
          catch (Exception paramBundle)
          {
            return true;
          }
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("AgentActivity", 1, "-->onCreate Exception", paramBundle);
        continue;
        String str = localBundle.getString("client_id");
        if ("action_login".equals(localObject2))
        {
          QLog.d("AgentActivity", 1, new Object[] { "-->loginAction, action: ", localObject2, " time = ", Long.valueOf(System.currentTimeMillis()), ", appid=", str });
          if (a())
          {
            ThreadManager.executeOnNetWorkThread(new AgentActivity.1(this, (String)localObject2, localBundle, str));
            return true;
          }
          a((String)localObject2, localBundle, str, false);
          return true;
        }
        if ("action_pay".equals(localObject2))
        {
          localObject1 = new Intent(this, AuthorityActivity.class);
          ((Intent)localObject1).putExtra("key_action", (String)localObject2);
          if (localObject1 == null) {
            continue;
          }
          ((Intent)localObject1).putExtra("key_params", localBundle);
          if ((getAppInterface() == null) || (getAppInterface().isLogin())) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("AgentActivity", 2, " qq is not login");
          }
          if ((!"action_login".equals(localObject2)) && (!"action_quick_login".equals(localObject2)) && (!"action_ptlogin_login".equals(localObject2))) {
            continue;
          }
          this.jdField_a_of_type_AndroidContentIntent = ((Intent)localObject1);
          this.jdField_a_of_type_AndroidContentIntent.putExtra("authority_start_qq_login", true);
          if (QLog.isColorLevel()) {
            QLog.d("AgentActivity", 2, "qq is not login, first login it");
          }
          paramBundle = new Intent(this, LoginActivity.class);
          paramBundle.putExtra("authority_start_qq_login", true);
          if (!"action_ptlogin_login".equals(localObject2))
          {
            paramBundle.setFlags(268435456);
            paramBundle.addFlags(32768);
          }
          localObject1 = new IntentFilter("action_login_sucess");
          registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject1);
          startActivity(paramBundle);
          try
          {
            bded.a().a(getAppInterface().getCurrentAccountUin(), "", str, "1", "8", "0", true);
            return true;
          }
          catch (Exception paramBundle)
          {
            paramBundle.printStackTrace();
            return true;
          }
        }
        if (("action_quick_login".equals(localObject2)) || ("action_ptlogin_login".equals(localObject2)))
        {
          this.c = true;
          paramBundle = super.getCallingPackage();
          if (QLog.isColorLevel()) {
            QLog.d("AgentActivity", 2, "-->packagename: " + paramBundle);
          }
          localObject1 = new Intent(this, QuickLoginAuthorityActivity.class);
          ((Intent)localObject1).putExtra("key_action", (String)localObject2);
          localBundle.putString("packagename", paramBundle);
        }
        else if (("action_invite".equals(localObject2)) || ("action_gift".equals(localObject2)) || ("action_ask".equals(localObject2)) || ("action_reactive".equals(localObject2)))
        {
          paramBundle = new Intent(this, SocialFriendChooser.class);
          localObject1 = paramBundle;
          if (paramBundle != null)
          {
            paramBundle.putExtra("key_action", (String)localObject2);
            localObject1 = localBundle.getString("hopenid");
            localBundle.putString("encrytoken", bdnm.a(this, "openid_encrytoken").getString((String)localObject1, ""));
            localObject1 = paramBundle;
          }
        }
        else if ("action_story".equals(localObject2))
        {
          paramBundle = new Intent(this, SendStoryActivity.class);
        }
        else if ("action_brag".equals(localObject2))
        {
          paramBundle = new Intent(this, BragActivity.class);
        }
        else if ("action_challenge".equals(localObject2))
        {
          paramBundle = new Intent(this, ChallengeActivity.class);
        }
        else
        {
          a(-5);
          return true;
        }
      }
    }
    try
    {
      super.startActivityForResult((Intent)localObject1, 0);
      return true;
    }
    catch (ActivityNotFoundException paramBundle)
    {
      paramBundle.printStackTrace();
      a(-6);
      super.finish();
      return true;
    }
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((QLog.isColorLevel()) && (getAppInterface() != null)) {
      QLog.d("AgentActivity", 2, "-->onResume, app.isLogin(): " + getAppInterface().isLogin());
    }
    if (this.b)
    {
      setResult(0);
      finish();
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.b = true;
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AgentActivity", 2, "-->onActivityResult, action: " + this.jdField_a_of_type_JavaLangString + " | requestCode: " + paramInt1 + " | resultCode: " + paramInt2 + " | data: " + paramIntent);
    }
    super.setResult(paramInt2, paramIntent);
    super.finish();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a();
    if (QLog.isColorLevel()) {
      QLog.d("AgentActivity", 2, "-->onDestroy, action: " + this.jdField_a_of_type_JavaLangString);
    }
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