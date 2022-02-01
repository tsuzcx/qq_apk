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
  private Intent a;
  private boolean b = true;
  
  private QQAppInterface a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)paramAppRuntime;
    }
    return null;
  }
  
  private void a(Activity paramActivity)
  {
    if (this.a != null)
    {
      QLog.d("JumpLoginResult", 1, "intent has bean inited");
      return;
    }
    this.a = paramActivity.getIntent();
  }
  
  private boolean a(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    String str2 = this.a.getStringExtra("scheme_content");
    String str1 = this.a.getStringExtra("pkg_name");
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
        paramAppRuntime.d(str1);
        paramAppRuntime.a();
        return true;
      }
    }
    return false;
  }
  
  private boolean a(AppRuntime paramAppRuntime, Activity paramActivity, String paramString, boolean paramBoolean)
  {
    this.b = false;
    if (AuthParamUtil.a(this.a))
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
  
  private boolean b(Activity paramActivity)
  {
    Bundle localBundle = this.a.getBundleExtra("key_params");
    Intent localIntent = this.a;
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
  
  private boolean b(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    Object localObject = this.a.getBundleExtra("key_params");
    if (this.a.getBooleanExtra("fromGuildOpen", false))
    {
      paramAppRuntime = a(paramAppRuntime);
      if (paramAppRuntime == null)
      {
        QLog.e("JumpLoginResult", 1, "handleScheduleJumpAction, app is null");
        return true;
      }
      str = ((Bundle)localObject).getString("extra_raw_url");
      localObject = ((Bundle)localObject).getString("pkg_name");
      paramAppRuntime = JumpParser.a(paramAppRuntime, paramActivity, str);
      paramAppRuntime.d((String)localObject);
      paramAppRuntime.a();
      return true;
    }
    String str = this.a.getStringExtra("scheme_content_original");
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.a.getStringExtra("scheme_content");
    }
    if ((localObject != null) && (((String)localObject).length() > 0) && (((String)localObject).startsWith("mqqguild://guild")))
    {
      paramAppRuntime = a(paramAppRuntime);
      if (paramAppRuntime == null)
      {
        QLog.e("JumpLoginResult", 1, "handleScheduleJumpAction, app is null");
        return false;
      }
      paramAppRuntime = JumpParser.a(paramAppRuntime, paramActivity, (String)localObject);
      paramAppRuntime.d(this.a.getStringExtra("pkg_name"));
      paramAppRuntime.a();
      return true;
    }
    return false;
  }
  
  private boolean b(AppRuntime paramAppRuntime, Activity paramActivity, String paramString)
  {
    boolean bool = this.a.getBooleanExtra("key_gesture_from_authority", false);
    this.b = true;
    if (bool)
    {
      paramAppRuntime = new Intent();
      paramAppRuntime.putExtra("uin", paramString);
      paramActivity.setResult(-1, paramAppRuntime);
      return true;
    }
    if ((!JumpActivity.sIsStartFromWpa) && (!JumpActivity.sIsStartFromThirdParty))
    {
      paramString = this.a.getStringExtra("scheme_content");
      if (this.a.getBooleanExtra("isActionSend", false))
      {
        paramActivity.setResult(-1);
        return true;
      }
      String str = this.a.getStringExtra("pkg_name");
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramAppRuntime = a(paramAppRuntime);
        if (paramAppRuntime == null)
        {
          QLog.e("JumpLoginResult", 1, "handleScheduleJumpAction, app is null");
          return false;
        }
        if (paramString.startsWith("mqqguild://guild")) {
          return false;
        }
        paramAppRuntime = JumpParser.a(paramAppRuntime, paramActivity, paramString);
        if ((TextUtils.isEmpty(str)) && (!"web".equals(paramAppRuntime.b("src_type"))) && (!paramAppRuntime.m()) && (!paramAppRuntime.n()))
        {
          if (("h5".equalsIgnoreCase(paramAppRuntime.b("jump_from"))) && (paramAppRuntime.o()))
          {
            this.a.putExtra("package_from_h5", "pakage_from_h5");
            this.a.putExtra("jump_action_from_h5", paramString);
            e(paramActivity);
            return true;
          }
        }
        else
        {
          paramAppRuntime.d(str);
          if ((paramAppRuntime.m()) || (((IMiniAppService)QRoute.api(IMiniAppService.class)).asyncShareMiniProgram(paramAppRuntime))) {
            this.b = false;
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
    Intent localIntent = this.a;
    if ("webview".equals(localIntent.getStringExtra("action_name")))
    {
      localIntent = new Intent(localIntent);
      localIntent.setClass(paramActivity, QQBrowserActivity.class);
      paramActivity.startActivity(localIntent);
      return true;
    }
    return false;
  }
  
  private boolean c(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    String str2 = this.a.getStringExtra("scheme_content");
    String str1 = this.a.getStringExtra("pkg_name");
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
      paramAppRuntime.d(str1);
      paramAppRuntime.a();
      return true;
    }
    return false;
  }
  
  private boolean d(Activity paramActivity)
  {
    boolean bool = this.a.getBooleanExtra("key_req_by_contact_sync", false);
    if (bool)
    {
      Intent localIntent = new Intent(paramActivity, ContactSyncJumpActivity.class);
      localIntent.putExtra("key_req_from_switch_account", true);
      localIntent.putExtra("key_change", true);
      localIntent.putExtra("key_orginal_intent", this.a.getParcelableExtra("key_orginal_intent"));
      paramActivity.startActivity(localIntent);
      paramActivity.moveTaskToBack(true);
      paramActivity.finish();
    }
    return bool;
  }
  
  private boolean d(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    String str2 = this.a.getStringExtra("scheme_content");
    String str1 = this.a.getStringExtra("pkg_name");
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
      paramAppRuntime.d(str1);
      paramAppRuntime.a();
      return true;
    }
    return false;
  }
  
  private void e(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, SplashActivity.class);
    Object localObject = this.a.getStringExtra("key_action");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && ((BindGroupActivity.class.getSimpleName().equals(localObject)) || (((ITroopSettingApi)QRoute.api(ITroopSettingApi.class)).getSimpleNameForTroopSettingActivity().equals(localObject)) || ("key_sdk_add_friend".equals(localObject)) || (ForwardIMByThirdPartyHelper.class.getSimpleName().equals(localObject)) || (ForwardMiniAppThirdPartyHelper.class.getSimpleName().equals(localObject)))) {
      localIntent.putExtras(this.a.getExtras());
    }
    localIntent.addFlags(67108864);
    localIntent.putExtra("k_from_login", true);
    localObject = this.a.getExtras();
    if (localObject != null)
    {
      if (((Bundle)localObject).containsKey("tab_index")) {
        localIntent.putExtra("tab_index", this.a.getExtras().getInt("tab_index"));
      }
      if (((Bundle)localObject).containsKey("main_tab_id")) {
        localIntent.putExtra("main_tab_id", ((Bundle)localObject).getInt("main_tab_id"));
      }
      if (((Bundle)localObject).containsKey("jump_action_from_h5")) {
        localIntent.putExtra("jump_action_from_h5", this.a.getExtras().getString("jump_action_from_h5"));
      }
      if (((Bundle)localObject).containsKey("package_from_h5")) {
        localIntent.putExtra("package_from_h5", this.a.getExtras().getString("package_from_h5"));
      }
    }
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2130772165, 0);
  }
  
  private boolean e(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    Object localObject1 = this.a;
    boolean bool2 = false;
    boolean bool3 = ((Intent)localObject1).getBooleanExtra("is_from_king_moment", false);
    localObject1 = this.a.getStringExtra("king_moment_cover_url");
    long l = this.a.getLongExtra("arg_wang_zhe_app_id", 0L);
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
  
  private boolean f(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    if (this.a.getBooleanExtra("UploadPhoto.key_from_album_shortcut", false))
    {
      Bundle localBundle = this.a.getExtras();
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
    Intent localIntent = this.a;
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
    SharedPrefs.c(paramString);
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
          return this.b;
        }
        this.a = localIntent;
        boolean bool = this.a.getBooleanExtra("IS_ADD_ACCOUNT", false);
        OpenProxy.a().a(paramString);
        if ((localIntent.getFlags() & 0x100000) == 0) {
          break label564;
        }
        i = 1;
        if ((!a(paramAppRuntime, paramActivity)) && (!b(paramAppRuntime, paramActivity)) && ((i != 0) || (!a(paramAppRuntime, paramActivity, paramString, false))) && ((i != 0) || (!b(paramAppRuntime, paramActivity, paramString))) && (!d(paramActivity)) && (!c(paramActivity)) && (!c(paramAppRuntime, paramActivity)) && (!b(paramActivity))) {
          if (this.a.getParcelableExtra("shortcut_jump_key") != null)
          {
            paramAppRuntime = (Intent)this.a.getParcelableExtra("shortcut_jump_key");
            paramAppRuntime.setClass(paramActivity, ShortcutRouterActivity.class);
            paramActivity.startActivity(paramAppRuntime);
          }
          else if (this.a.getBooleanExtra("jump_shortcut_dataline", false))
          {
            paramAppRuntime = new Intent();
            paramAppRuntime.putExtras(this.a.getExtras());
            paramAppRuntime.setClass(paramActivity, qfileJumpActivity.class);
            paramActivity.startActivity(paramAppRuntime);
          }
          else
          {
            paramString = this.a.getParcelableExtra("QLINK_SHORTCUT_JUMP_KEY");
            if (paramString != null)
            {
              paramAppRuntime = new Intent(paramActivity, JumpActivity.class);
              paramAppRuntime.putExtra("_goto_qlink_when_login_suc_", true);
              paramAppRuntime.putExtra("IS_LOGIN_SUC_CALL", true);
              paramActivity.startActivity(paramAppRuntime);
            }
            else if (this.a.getParcelableExtra("QFILE_SHORTCUT_JUMP_KEY") != null)
            {
              paramAppRuntime = new Intent(paramActivity, JumpActivity.class);
              paramAppRuntime.putExtra("_goto_qfile_when_login_suc_", true);
              paramAppRuntime.putExtra("IS_LOGIN_SUC_CALL", true);
              paramActivity.startActivity(paramAppRuntime);
            }
            else if (this.a.getParcelableExtra("qlink_share_intent_data") != null)
            {
              paramAppRuntime = (Intent)this.a.getParcelableExtra("qlink_share_intent_data");
              paramAppRuntime.putExtra("qlink_share_login_suc_flag", true);
              paramActivity.startActivity(paramAppRuntime);
            }
            else if (this.a.getParcelableExtra("MINI_SHORTCUT_JUMP_KEY") != null)
            {
              paramAppRuntime = (Intent)this.a.getParcelableExtra("MINI_SHORTCUT_JUMP_KEY");
              paramString = new Intent(paramActivity, QQMiniManager.getAppBrandUIClass());
              paramString.putExtras(paramAppRuntime);
              paramActivity.startActivity(paramString);
            }
            else if ((!d(paramAppRuntime, paramActivity)) && (!e(paramAppRuntime, paramActivity)) && (!f(paramAppRuntime, paramActivity)))
            {
              paramActivity.setResult(-1);
              if (!bool) {
                e(paramActivity);
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
      return this.b;
      label564:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.JumpLoginResult
 * JD-Core Version:    0.7.0.1
 */