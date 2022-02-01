package com.tencent.open;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.loginregister.LoginProgressClazz;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.OpenSdkIMBlockFragment;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.data.SharedPrefs;
import com.tencent.qqconnect.wtlogin.LoginHelper;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class OpenSdkQIPCModule
  extends BaseOpenSdkQIPCModule
{
  private static volatile OpenSdkQIPCModule a;
  
  private OpenSdkQIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static OpenSdkQIPCModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new OpenSdkQIPCModule("open_sdk_qipc_module");
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle.getInt("key_sso_ret", -1000) == 0)
    {
      String str = paramBundle.getString("uin");
      boolean bool = paramBundle.getBoolean("is_from_login");
      SharedPrefs.c(str);
      LoginHelper.a(BaseActivity.sTopActivity, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      OpenSdkIMBlockFragment.a(BaseActivity.sTopActivity, str, bool);
    }
    else
    {
      QQToast.makeText(BaseActivity.sTopActivity, 2131892333, 0).show();
    }
    if (((ISafeBlockApi)QRoute.api(ISafeBlockApi.class)).isBlockNotifyActivity(QBaseActivity.sTopActivity)) {
      QBaseActivity.sTopActivity.finish();
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCall main proc action : ");
    ((StringBuilder)localObject).append(paramString);
    SSOLog.b("OpenSdkQIPCModule", ((StringBuilder)localObject).toString());
    if ("action_get_accountInfo".equals(paramString))
    {
      paramString = new Bundle();
      localObject = EIPCResult.createResult(0, paramString);
      paramBundle = paramBundle.getString("uin");
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((!TextUtils.isEmpty(paramBundle)) && ((localAppRuntime instanceof QQAppInterface))) {
        paramString.putString("key_nickname", ContactUtils.c((QQAppInterface)localAppRuntime, paramBundle));
      }
      callbackResult(paramInt, (EIPCResult)localObject);
      return null;
    }
    if ("action_ptlogin_cancel".equals(paramString))
    {
      paramString = BaseActivity.sTopActivity;
      paramBundle = new StringBuilder();
      paramBundle.append("onCall ptlogin cancel activity=");
      paramBundle.append(paramString);
      SSOLog.b("OpenSdkQIPCModule", paramBundle.toString());
      if ((paramString instanceof SplashActivity))
      {
        paramString.doOnBackPressed();
        return null;
      }
    }
    else
    {
      if ("action_on_sso_login_complete".equals(paramString))
      {
        ThreadManager.getUIHandler().post(new OpenSdkQIPCModule.1(this, paramBundle));
        return null;
      }
      if ("action_on_agent_activity_destroy".equals(paramString))
      {
        GuardManager.sInstance.noticeSubThreadBackground("com.tencent.mobileqq:openSdk");
        return EIPCResult.createResult(0, null);
      }
      if ("action_on_qr_code_login_success".equals(paramString))
      {
        paramString = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (paramString != null)
        {
          paramString = paramString.getHandler(LoginProgressClazz.class);
          if (paramString != null) {
            paramString.sendEmptyMessage(2004);
          }
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.OpenSdkQIPCModule
 * JD-Core Version:    0.7.0.1
 */