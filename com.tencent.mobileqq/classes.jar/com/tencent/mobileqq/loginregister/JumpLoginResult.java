package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.ContactSyncJumpActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.ShortcutRouterActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.qfileJumpActivity;
import com.tencent.mobileqq.app.ForwardMiniAppThirdPartyHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardIMByThirdPartyHelper;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.QQMiniManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.open.OpenProxy;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.open.agent.BindTroopPreVerificationFragment;
import com.tencent.open.agent.JoinTroopPreVerificationFragment;
import com.tencent.open.data.SharedPrefs;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqreader.QRBridgeActivity;
import cooperation.qzone.QZoneHelper;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class JumpLoginResult
  extends BaseLoginResult
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private boolean jdField_a_of_type_Boolean = true;
  
  private QQAppInterface a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)paramAppRuntime;
    }
    return null;
  }
  
  private void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      QLog.d("JumpLoginResult", 1, "intent has bean inited");
      return;
    }
    this.jdField_a_of_type_AndroidContentIntent = paramActivity.getIntent();
  }
  
  private boolean a(Activity paramActivity)
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidContentIntent.getBundleExtra("key_params");
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("fromThirdAppByOpenSDK", false))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_params", localBundle);
      int i = localBundle.getInt("action");
      if (i == 3) {
        PublicFragmentActivity.Launcher.a(paramActivity, localIntent, PublicTransFragmentActivity.class, JoinTroopPreVerificationFragment.class);
      }
      while (i != 1) {
        return true;
      }
      PublicFragmentActivity.Launcher.a(paramActivity, localIntent, PublicTransFragmentActivity.class, BindTroopPreVerificationFragment.class);
      return true;
    }
    return false;
  }
  
  private boolean a(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("scheme_content");
    String str1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("pkg_name");
    if ((str2 != null) && ((str2.startsWith("mqqopensdkapi://bizAgent/")) || (str2.startsWith("http://qm.qq.com/cgi-bin/")) || (str2.startsWith("mqq://shop/")) || (str2.startsWith("mqqapi://wallet/open")) || (str2.startsWith("mqqmdpass://wallet/modify_pass")) || (str2.startsWith("mqqapi://qqdataline/openqqdataline")) || (str2.startsWith("mqqapi://dating/")) || (str2.startsWith("mqqapi://qlink/openqlink")) || (str2.startsWith("mqqapi://qqc2b/callc2bphone"))))
    {
      paramAppRuntime = a(paramAppRuntime);
      if (paramAppRuntime != null) {
        break label136;
      }
      QLog.e("JumpLoginResult", 1, "handleScheduleJumpAction, app is null");
    }
    label136:
    do
    {
      return false;
      paramAppRuntime = JumpParser.a(paramAppRuntime, paramActivity, str2);
    } while (paramAppRuntime == null);
    paramAppRuntime.c(str1);
    paramAppRuntime.a();
    return true;
  }
  
  private boolean a(AppRuntime paramAppRuntime, Activity paramActivity, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("authority_start_qq_login", false))
    {
      Intent localIntent = new Intent("action_login_sucess");
      localIntent.putExtra("login_success_uin", paramString);
      localIntent.putExtra("forbid_quick_login_after", paramBoolean);
      paramActivity.sendBroadcast(localIntent);
      ThreadManager.getUIHandler().postDelayed(new JumpLoginResult.1(this, paramString, paramActivity), 1000L);
      ReportController.a(paramAppRuntime, "dc00898", "", "", "0x800BA1D", "0x800BA1D", 0, 0, "", "", "", "");
      return true;
    }
    return false;
  }
  
  private void b(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, SplashActivity.class);
    Object localObject = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_action");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && ((BindGroupActivity.class.getSimpleName().equals(localObject)) || (ChatSettingForTroop.class.getSimpleName().equals(localObject)) || (AddFriendLogicActivity.class.getSimpleName().equals(localObject)) || (ForwardIMByThirdPartyHelper.class.getSimpleName().equals(localObject)) || (ForwardMiniAppThirdPartyHelper.class.getSimpleName().equals(localObject)))) {
      localIntent.putExtras(this.jdField_a_of_type_AndroidContentIntent.getExtras());
    }
    localIntent.addFlags(67108864);
    localIntent.putExtra("k_from_login", true);
    localObject = this.jdField_a_of_type_AndroidContentIntent.getExtras();
    if (localObject != null)
    {
      if (((Bundle)localObject).containsKey("tab_index")) {
        localIntent.putExtra("tab_index", this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("tab_index"));
      }
      if (((Bundle)localObject).containsKey("main_tab_id")) {
        localIntent.putExtra("main_tab_id", ((Bundle)localObject).getInt("main_tab_id"));
      }
      if (((Bundle)localObject).containsKey("jump_action_from_h5")) {
        localIntent.putExtra("jump_action_from_h5", this.jdField_a_of_type_AndroidContentIntent.getExtras().getString("jump_action_from_h5"));
      }
      if (((Bundle)localObject).containsKey("package_from_h5")) {
        localIntent.putExtra("package_from_h5", this.jdField_a_of_type_AndroidContentIntent.getExtras().getString("package_from_h5"));
      }
    }
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2130772093, 0);
  }
  
  private boolean b(Activity paramActivity)
  {
    Intent localIntent = this.jdField_a_of_type_AndroidContentIntent;
    if ("webview".equals(localIntent.getStringExtra("action_name")))
    {
      localIntent = new Intent(localIntent);
      localIntent.setClass(paramActivity, QQBrowserActivity.class);
      paramActivity.startActivity(localIntent);
      return true;
    }
    return false;
  }
  
  private boolean b(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("scheme_content");
    String str1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("pkg_name");
    if (QLog.isColorLevel()) {
      QLog.d("ODProxy", 2, "handleODJumpAction: schemeStr:" + str2 + "pkgName :" + str1);
    }
    if ((str2 != null) && (str2.startsWith("mqqapi://od")))
    {
      paramAppRuntime = a(paramAppRuntime);
      if (paramAppRuntime == null)
      {
        QLog.e("JumpLoginResult", 1, "handleScheduleJumpAction, app is null");
        return true;
      }
      paramAppRuntime = JumpParser.a(paramAppRuntime, paramActivity, str2);
      paramAppRuntime.c(str1);
      paramAppRuntime.a();
      return true;
    }
    return false;
  }
  
  private boolean b(AppRuntime paramAppRuntime, Activity paramActivity, String paramString)
  {
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_gesture_from_authority", false);
    this.jdField_a_of_type_Boolean = true;
    if (bool)
    {
      paramAppRuntime = new Intent();
      paramAppRuntime.putExtra("uin", paramString);
      paramActivity.setResult(-1, paramAppRuntime);
      return true;
    }
    if ((JumpActivity.e) || (JumpActivity.f))
    {
      paramActivity.setResult(-1);
      return true;
    }
    paramString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("scheme_content");
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isActionSend", false))
    {
      paramActivity.setResult(-1);
      return true;
    }
    String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("pkg_name");
    if ((paramString != null) && (paramString.length() > 0))
    {
      paramAppRuntime = a(paramAppRuntime);
      if (paramAppRuntime == null)
      {
        QLog.e("JumpLoginResult", 1, "handleScheduleJumpAction, app is null");
        return false;
      }
      paramAppRuntime = JumpParser.a(paramAppRuntime, paramActivity, paramString);
      if ((!TextUtils.isEmpty(str)) || ("web".equals(paramAppRuntime.b("src_type"))) || (paramAppRuntime.m()) || (paramAppRuntime.n()))
      {
        paramAppRuntime.c(str);
        if ((paramAppRuntime.m()) || (((IMiniAppService)QRoute.api(IMiniAppService.class)).asyncShareMiniProgram(paramAppRuntime))) {
          this.jdField_a_of_type_Boolean = false;
        }
        paramAppRuntime.a();
        return true;
      }
      if (("h5".equalsIgnoreCase(paramAppRuntime.b("jump_from"))) && (paramAppRuntime.l()))
      {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("package_from_h5", "pakage_from_h5");
        this.jdField_a_of_type_AndroidContentIntent.putExtra("jump_action_from_h5", paramString);
        b(paramActivity);
        return true;
      }
    }
    return false;
  }
  
  private boolean c(Activity paramActivity)
  {
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_req_by_contact_sync", false);
    if (bool)
    {
      Intent localIntent = new Intent(paramActivity, ContactSyncJumpActivity.class);
      localIntent.putExtra("key_req_from_switch_account", true);
      localIntent.putExtra("key_change", true);
      localIntent.putExtra("key_orginal_intent", this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("key_orginal_intent"));
      paramActivity.startActivity(localIntent);
      paramActivity.moveTaskToBack(true);
      paramActivity.finish();
    }
    return bool;
  }
  
  private boolean c(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("scheme_content");
    String str1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("pkg_name");
    if (QLog.isColorLevel()) {
      QLog.d("schedule", 2, "handleScheduleJumpAction: schemeStr:" + str2 + "pkgName :" + str1);
    }
    if ((str2 != null) && (str2.startsWith("mqqapi://schedule/showDetail?")))
    {
      paramAppRuntime = a(paramAppRuntime);
      if (paramAppRuntime == null)
      {
        QLog.e("JumpLoginResult", 1, "handleScheduleJumpAction, app is null");
        return true;
      }
      paramAppRuntime = JumpParser.a(paramAppRuntime, paramActivity, str2);
      paramAppRuntime.c(str1);
      paramAppRuntime.a();
      return true;
    }
    return false;
  }
  
  private boolean d(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    boolean bool2 = false;
    boolean bool3 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_from_king_moment", false);
    String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("king_moment_cover_url");
    long l = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("arg_wang_zhe_app_id", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("KingShareReadInjoyModule", 2, "url is " + str);
    }
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        Intent localIntent = new Intent(paramActivity, ReadInJoyDeliverVideoActivity.class);
        localIntent.putExtra("arg_is_from_wang_zhe", true);
        localIntent.putExtra("arg_wang_zhe_app_id", l);
        paramActivity.startActivity(localIntent);
        paramAppRuntime = a(paramAppRuntime);
        if (paramAppRuntime != null) {
          break label156;
        }
        QLog.e("JumpLoginResult", 1, "handleScheduleJumpAction, app is null");
        bool1 = true;
      }
    }
    return bool1;
    label156:
    paramActivity = (ReadInJoyLogicManager)paramAppRuntime.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (paramActivity != null) {
      paramActivity.a().a(str, paramAppRuntime.getAccount());
    }
    return true;
  }
  
  private boolean e(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("UploadPhoto.key_from_album_shortcut", false))
    {
      Bundle localBundle = this.jdField_a_of_type_AndroidContentIntent.getExtras();
      QZoneHelper.goQZoneAlbumPhotoList(paramActivity, localBundle.getString("UploadPhoto.key_album_id"), localBundle.getLong("UploadPhoto.key_album_owner_uin", 0L), String.valueOf(paramAppRuntime.getLongAccountUin()));
      paramActivity.finish();
      bool = true;
    }
    return bool;
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    QLog.d("JumpLoginResult", 1, "onQrCodeLoginSuccess");
    Intent localIntent = paramActivity.getIntent();
    if ((localIntent != null) && (localIntent.getBooleanExtra("authority_start_qq_login", false)))
    {
      localIntent = new Intent("action_login_sucess");
      localIntent.putExtra("param_qr_code_url", paramString);
      localIntent.putExtra("param_is_qr_code_login", true);
      paramActivity.sendBroadcast(localIntent);
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity, String paramString)
  {
    a(paramQBaseActivity);
    if (this.jdField_a_of_type_AndroidContentIntent == null)
    {
      QLog.e("JumpLoginResult", 1, "handleIMBlockLogin intent is null");
      return;
    }
    if ((this.jdField_a_of_type_AndroidContentIntent.getFlags() & 0x100000) != 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      QLog.d("JumpLoginResult", 1, "launchedFromHistory is true, return");
      return;
    }
    QLog.d("JumpLoginResult", 1, "handleSdkLoginAuthority");
    a(paramQBaseActivity.getAppRuntime(), paramQBaseActivity, paramString, true);
    SharedPrefs.b(paramString);
  }
  
  public boolean a(AppRuntime paramAppRuntime, Activity paramActivity, String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        Intent localIntent = paramActivity.getIntent();
        if (localIntent == null)
        {
          QLog.e("JumpLoginResult", 1, "onLoginSuccess, but intent is null");
          return this.jdField_a_of_type_Boolean;
        }
        this.jdField_a_of_type_AndroidContentIntent = localIntent;
        bool1 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("IS_ADD_ACCOUNT", false);
        OpenProxy.a().a(paramString);
        if ((localIntent.getFlags() & 0x100000) != 0) {
          i = 1;
        }
        boolean bool2 = a(paramAppRuntime, paramActivity);
        if (!bool2) {
          continue;
        }
      }
      catch (Exception paramAppRuntime)
      {
        boolean bool1;
        QLog.e("JumpLoginResult", 1, "loginSuccess error: " + paramAppRuntime.getMessage());
        continue;
        if (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("jump_shortcut_dataline", false)) {
          continue;
        }
        paramAppRuntime = new Intent();
        paramAppRuntime.putExtras(this.jdField_a_of_type_AndroidContentIntent.getExtras());
        paramAppRuntime.setClass(paramActivity, qfileJumpActivity.class);
        paramActivity.startActivity(paramAppRuntime);
        continue;
        if (this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("QLINK_SHORTCUT_JUMP_KEY") == null) {
          continue;
        }
        paramAppRuntime = new Intent(paramActivity, JumpActivity.class);
        paramAppRuntime.putExtra("_goto_qlink_when_login_suc_", true);
        paramAppRuntime.putExtra("IS_LOGIN_SUC_CALL", true);
        paramActivity.startActivity(paramAppRuntime);
        continue;
        if (this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("QFILE_SHORTCUT_JUMP_KEY") == null) {
          continue;
        }
        paramAppRuntime = new Intent(paramActivity, JumpActivity.class);
        paramAppRuntime.putExtra("_goto_qfile_when_login_suc_", true);
        paramAppRuntime.putExtra("IS_LOGIN_SUC_CALL", true);
        paramActivity.startActivity(paramAppRuntime);
        continue;
        if (this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("qlink_share_intent_data") == null) {
          continue;
        }
        paramAppRuntime = (Intent)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("qlink_share_intent_data");
        paramAppRuntime.putExtra("qlink_share_login_suc_flag", true);
        paramActivity.startActivity(paramAppRuntime);
        continue;
        if (this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("QREADER_SHORTCUT_JUMP_KEY") == null) {
          continue;
        }
        paramAppRuntime = (Intent)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("QREADER_SHORTCUT_JUMP_KEY");
        paramString = new Intent(paramActivity, QRBridgeActivity.class);
        paramString.putExtras(paramAppRuntime);
        paramActivity.startActivity(paramString);
        continue;
        if (this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("MINI_SHORTCUT_JUMP_KEY") == null) {
          continue;
        }
        paramAppRuntime = (Intent)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("MINI_SHORTCUT_JUMP_KEY");
        paramString = new Intent(paramActivity, QQMiniManager.getAppBrandUIClass());
        paramString.putExtras(paramAppRuntime);
        paramActivity.startActivity(paramString);
        continue;
        if ((c(paramAppRuntime, paramActivity)) || (d(paramAppRuntime, paramActivity)) || (e(paramAppRuntime, paramActivity))) {
          continue;
        }
        paramActivity.setResult(-1);
        if (bool1) {
          continue;
        }
        b(paramActivity);
        continue;
      }
      return this.jdField_a_of_type_Boolean;
      if (((i != 0) || (!a(paramAppRuntime, paramActivity, paramString, false))) && ((i != 0) || (!b(paramAppRuntime, paramActivity, paramString))) && (!c(paramActivity)) && (!b(paramActivity)) && (!b(paramAppRuntime, paramActivity)) && (!a(paramActivity)))
      {
        if (this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("shortcut_jump_key") == null) {
          continue;
        }
        paramAppRuntime = (Intent)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("shortcut_jump_key");
        paramAppRuntime.setClass(paramActivity, ShortcutRouterActivity.class);
        paramActivity.startActivity(paramAppRuntime);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.JumpLoginResult
 * JD-Core Version:    0.7.0.1
 */