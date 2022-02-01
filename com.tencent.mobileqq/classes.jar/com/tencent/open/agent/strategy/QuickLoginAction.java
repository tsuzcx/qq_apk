package com.tencent.open.agent.strategy;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.open.agent.QuickLoginAuthorityActivity;
import com.tencent.open.agent.util.AuthModelUtil;
import com.tencent.open.agent.util.AuthParamUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class QuickLoginAction
  extends BaseAction
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new QuickLoginAction.1(this);
  private Intent jdField_a_of_type_AndroidContentIntent;
  
  public QuickLoginAction(String paramString)
  {
    super(paramString);
  }
  
  private AppRuntime a()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  private void a(Intent paramIntent)
  {
    paramIntent = AuthParamUtil.a(paramIntent, "login_success_uin");
    if (!TextUtils.isEmpty(paramIntent)) {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("login_success_uin", paramIntent);
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 0);
  }
  
  private void b(Intent paramIntent)
  {
    if (a().isLogin())
    {
      SSOLog.b("QuickLoginAction", "syncLogin isLogin");
      return;
    }
    if (paramIntent.getBooleanExtra("forbid_quick_login_after", false))
    {
      SSOLog.b("QuickLoginAction", "syncLogin FORBID_QUICK_LOGIN_AFTER");
      return;
    }
    paramIntent = a().getAccount();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("syncLogin not login, to login uin= ");
    ((StringBuilder)localObject).append(paramIntent);
    SSOLog.b("QuickLoginAction", ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(paramIntent)) {
      return;
    }
    localObject = a().getApplication().getAllAccounts();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject).next();
        if (paramIntent.equals(localSimpleAccount.getUin())) {
          a().login(localSimpleAccount);
        }
      }
      return;
    }
    SSOLog.b("QuickLoginAction", "syncLogin list == null || list.isEmpty()");
  }
  
  private void b(Intent paramIntent, Activity paramActivity, Bundle paramBundle)
  {
    SSOLog.a("QuickLoginAction", new Object[] { "qq is not login, first login it" });
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_AndroidContentIntent.putExtra("authority_start_qq_login", true);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("key_action", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("key_params", paramBundle);
    paramIntent = new Intent();
    paramIntent.putExtra("authority_start_qq_login", true);
    if (!"action_ptlogin_login".equals(this.jdField_a_of_type_JavaLangString))
    {
      paramIntent.setFlags(268435456);
      paramIntent.addFlags(32768);
    }
    AuthModelUtil.a(paramIntent, paramBundle, paramBundle.getString("client_id"));
    paramBundle = new IntentFilter("action_login_sucess");
    paramActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    RouteUtils.a(paramActivity, paramIntent, "/base/login");
  }
  
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramActivity, QuickLoginAuthorityActivity.class);
    paramBundle.putString("packagename", AuthorityUtil.a(paramActivity));
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime != null) && (!localAppRuntime.isLogin()))
    {
      b(localIntent, paramActivity, paramBundle);
      return;
    }
    a(localIntent, paramActivity, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.strategy.QuickLoginAction
 * JD-Core Version:    0.7.0.1
 */