package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardIMByThirdPartyHelper;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJDeliverUGCUtils;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.QQMiniManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingApi;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.open.OpenProxy;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.open.agent.BindTroopPreVerificationFragment;
import com.tencent.open.agent.JoinTroopPreVerificationFragment;
import com.tencent.open.agent.util.AuthParamUtil;
import com.tencent.open.data.SharedPrefs;
import com.tencent.qphone.base.util.QLog;
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
    Intent localIntent = this.jdField_a_of_type_AndroidContentIntent;
    boolean bool1 = false;
    if (localIntent.getBooleanExtra("fromThirdAppByOpenSDK", false))
    {
      localIntent = new Intent();
      localIntent.putExtra("key_params", localBundle);
      int i = localBundle.getInt("action");
      boolean bool2 = true;
      if (i == 3)
      {
        PublicFragmentActivity.Launcher.a(paramActivity, localIntent, PublicTransFragmentActivity.class, JoinTroopPreVerificationFragment.class);
        return true;
      }
      bool1 = bool2;
      if (i == 1)
      {
        PublicFragmentActivity.Launcher.a(paramActivity, localIntent, PublicTransFragmentActivity.class, BindTroopPreVerificationFragment.class);
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  private boolean a(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("scheme_content");
    String str1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("pkg_name");
    if ((str2 != null) && ((str2.startsWith("mqqopensdkapi://bizAgent/")) || (str2.startsWith("http://qm.qq.com/cgi-bin/")) || (str2.startsWith("mqq://shop/")) || (str2.startsWith("mqqapi://wallet/open")) || (str2.startsWith("mqqmdpass://wallet/modify_pass")) || (str2.startsWith("mqqapi://qqdataline/openqqdataline")) || (str2.startsWith("mqqapi://dating/")) || (str2.startsWith("mqqapi://qlink/openqlink")) || (str2.startsWith("mqqapi://qqc2b/callc2bphone"))))
    {
      paramAppRuntime = a(paramAppRuntime);
      if (paramAppRuntime == null)
      {
        QLog.e("JumpLoginResult", 1, "handleScheduleJumpAction, app is null");
        return false;
      }
      paramAppRuntime = JumpParser.a(paramAppRuntime, paramActivity, str2);
      if (paramAppRuntime != null)
      {
        paramAppRuntime.c(str1);
        paramAppRuntime.a();
        return true;
      }
    }
    return false;
  }
  
  private boolean a(AppRuntime paramAppRuntime, Activity paramActivity, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    if (AuthParamUtil.a(this.jdField_a_of_type_AndroidContentIntent))
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
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && ((BindGroupActivity.class.getSimpleName().equals(localObject)) || (((ITroopSettingApi)QRoute.api(ITroopSettingApi.class)).getSimpleNameForTroopSettingActivity().equals(localObject)) || ("key_sdk_add_friend".equals(localObject)) || (ForwardIMByThirdPartyHelper.class.getSimpleName().equals(localObject)) || (ForwardMiniAppThirdPartyHelper.class.getSimpleName().equals(localObject)))) {
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
    paramActivity.overridePendingTransition(2130772119, 0);
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleODJumpAction: schemeStr:");
      localStringBuilder.append(str2);
      localStringBuilder.append("pkgName :");
      localStringBuilder.append(str1);
      QLog.d("ODProxy", 2, localStringBuilder.toString());
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
    if ((!JumpActivity.sIsStartFromWpa) && (!JumpActivity.sIsStartFromThirdParty))
    {
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
        if ((TextUtils.isEmpty(str)) && (!"web".equals(paramAppRuntime.b("src_type"))) && (!paramAppRuntime.g()) && (!paramAppRuntime.h()))
        {
          if (("h5".equalsIgnoreCase(paramAppRuntime.b("jump_from"))) && (paramAppRuntime.i()))
          {
            this.jdField_a_of_type_AndroidContentIntent.putExtra("package_from_h5", "pakage_from_h5");
            this.jdField_a_of_type_AndroidContentIntent.putExtra("jump_action_from_h5", paramString);
            b(paramActivity);
            return true;
          }
        }
        else
        {
          paramAppRuntime.c(str);
          if ((paramAppRuntime.g()) || (((IMiniAppService)QRoute.api(IMiniAppService.class)).asyncShareMiniProgram(paramAppRuntime))) {
            this.jdField_a_of_type_Boolean = false;
          }
          paramAppRuntime.a();
          return true;
        }
      }
      return false;
    }
    paramActivity.setResult(-1);
    return true;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleScheduleJumpAction: schemeStr:");
      localStringBuilder.append(str2);
      localStringBuilder.append("pkgName :");
      localStringBuilder.append(str1);
      QLog.d("schedule", 2, localStringBuilder.toString());
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
    Object localObject1 = this.jdField_a_of_type_AndroidContentIntent;
    boolean bool2 = false;
    boolean bool3 = ((Intent)localObject1).getBooleanExtra("is_from_king_moment", false);
    localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("king_moment_cover_url");
    long l = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("arg_wang_zhe_app_id", 0L);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("url is ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("KingShareReadInjoyModule", 2, ((StringBuilder)localObject2).toString());
    }
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new Intent(paramActivity, ((IRIJDeliverUGCUtils)QRoute.api(IRIJDeliverUGCUtils.class)).getReadInJoyDeliverVideoActivityClazz());
        bool2 = true;
        ((Intent)localObject2).putExtra("arg_is_from_wang_zhe", true);
        ((Intent)localObject2).putExtra("arg_wang_zhe_app_id", l);
        paramActivity.startActivity((Intent)localObject2);
        paramAppRuntime = a(paramAppRuntime);
        if (paramAppRuntime == null)
        {
          QLog.e("JumpLoginResult", 1, "handleScheduleJumpAction, app is null");
          return true;
        }
        paramActivity = ((IReadInJoyLogicManager)paramAppRuntime.getRuntimeService(IReadInJoyLogicManager.class)).getReadInJoyLogicEngine();
        bool1 = bool2;
        if (paramActivity != null)
        {
          paramActivity.a((String)localObject1, paramAppRuntime.getAccount());
          bool1 = bool2;
        }
      }
    }
    return bool1;
  }
  
  private boolean e(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("UploadPhoto.key_from_album_shortcut", false))
    {
      Bundle localBundle = this.jdField_a_of_type_AndroidContentIntent.getExtras();
      QZoneHelper.goQZoneAlbumPhotoList(paramActivity, localBundle.getString("UploadPhoto.key_album_id"), localBundle.getLong("UploadPhoto.key_album_owner_uin", 0L), String.valueOf(paramAppRuntime.getLongAccountUin()));
      paramActivity.finish();
      return true;
    }
    return false;
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    QLog.d("JumpLoginResult", 1, "onQrCodeLoginSuccess");
    if (AuthParamUtil.a(paramActivity.getIntent()))
    {
      Intent localIntent = new Intent("action_login_sucess");
      localIntent.putExtra("param_qr_code_url", paramString);
      localIntent.putExtra("param_is_qr_code_login", true);
      paramActivity.sendBroadcast(localIntent);
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity, String paramString)
  {
    a(paramQBaseActivity);
    Intent localIntent = this.jdField_a_of_type_AndroidContentIntent;
    if (localIntent == null)
    {
      QLog.e("JumpLoginResult", 1, "handleIMBlockLogin intent is null");
      return;
    }
    int i;
    if ((localIntent.getFlags() & 0x100000) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
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
        boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("IS_ADD_ACCOUNT", false);
        OpenProxy.a().a(paramString);
        if ((localIntent.getFlags() & 0x100000) == 0) {
          break label554;
        }
        i = 1;
        if ((!a(paramAppRuntime, paramActivity)) && ((i != 0) || (!a(paramAppRuntime, paramActivity, paramString, false))) && ((i != 0) || (!b(paramAppRuntime, paramActivity, paramString))) && (!c(paramActivity)) && (!b(paramActivity)) && (!b(paramAppRuntime, paramActivity)) && (!a(paramActivity))) {
          if (this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("shortcut_jump_key") != null)
          {
            paramAppRuntime = (Intent)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("shortcut_jump_key");
            paramAppRuntime.setClass(paramActivity, ShortcutRouterActivity.class);
            paramActivity.startActivity(paramAppRuntime);
          }
          else if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("jump_shortcut_dataline", false))
          {
            paramAppRuntime = new Intent();
            paramAppRuntime.putExtras(this.jdField_a_of_type_AndroidContentIntent.getExtras());
            paramAppRuntime.setClass(paramActivity, qfileJumpActivity.class);
            paramActivity.startActivity(paramAppRuntime);
          }
          else
          {
            paramString = this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("QLINK_SHORTCUT_JUMP_KEY");
            if (paramString != null)
            {
              paramAppRuntime = new Intent(paramActivity, JumpActivity.class);
              paramAppRuntime.putExtra("_goto_qlink_when_login_suc_", true);
              paramAppRuntime.putExtra("IS_LOGIN_SUC_CALL", true);
              paramActivity.startActivity(paramAppRuntime);
            }
            else if (this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("QFILE_SHORTCUT_JUMP_KEY") != null)
            {
              paramAppRuntime = new Intent(paramActivity, JumpActivity.class);
              paramAppRuntime.putExtra("_goto_qfile_when_login_suc_", true);
              paramAppRuntime.putExtra("IS_LOGIN_SUC_CALL", true);
              paramActivity.startActivity(paramAppRuntime);
            }
            else if (this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("qlink_share_intent_data") != null)
            {
              paramAppRuntime = (Intent)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("qlink_share_intent_data");
              paramAppRuntime.putExtra("qlink_share_login_suc_flag", true);
              paramActivity.startActivity(paramAppRuntime);
            }
            else if (this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("MINI_SHORTCUT_JUMP_KEY") != null)
            {
              paramAppRuntime = (Intent)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("MINI_SHORTCUT_JUMP_KEY");
              paramString = new Intent(paramActivity, QQMiniManager.getAppBrandUIClass());
              paramString.putExtras(paramAppRuntime);
              paramActivity.startActivity(paramString);
            }
            else if ((!c(paramAppRuntime, paramActivity)) && (!d(paramAppRuntime, paramActivity)) && (!e(paramAppRuntime, paramActivity)))
            {
              paramActivity.setResult(-1);
              if (!bool) {
                b(paramActivity);
              }
            }
          }
        }
      }
      catch (Exception paramAppRuntime)
      {
        paramActivity = new StringBuilder();
        paramActivity.append("loginSuccess error: ");
        paramActivity.append(paramAppRuntime.getMessage());
        QLog.e("JumpLoginResult", 1, paramActivity.toString());
      }
      return this.jdField_a_of_type_Boolean;
      label554:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.JumpLoginResult
 * JD-Core Version:    0.7.0.1
 */