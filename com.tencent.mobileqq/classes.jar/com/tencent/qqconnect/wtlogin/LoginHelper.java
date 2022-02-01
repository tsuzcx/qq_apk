package com.tencent.qqconnect.wtlogin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.OpenSdkIFrameProcessor;
import com.tencent.mobileqq.loginregister.LoginProgressClazz;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.open.agent.AgentActivity;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.observer.SSOAccountObserver;
import mqq.os.MqqHandler;

public class LoginHelper
{
  protected LoginHelper.Callback a;
  
  public static String a(AppInterface paramAppInterface)
  {
    return ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount());
  }
  
  public static void a(Activity paramActivity)
  {
    QLog.d("LoginHelper", 1, "ssoLoginByIMBlock");
    Intent localIntent1 = paramActivity.getIntent();
    if (localIntent1 == null)
    {
      QLog.e("LoginHelper", 1, "ssoLoginByIMBlock null == srcIntent");
      return;
    }
    Intent localIntent2 = new Intent(paramActivity, AgentActivity.class);
    localIntent2.putExtra("appid", "0");
    localIntent2.putExtra("uin", localIntent1.getStringExtra("uin"));
    localIntent2.putExtra("passwd", localIntent1.getStringExtra("passwd"));
    localIntent2.putExtra("is_from_login", localIntent1.getBooleanExtra("is_from_login", false));
    localIntent2.putExtra("key_action", "action_sso_login_by_im_block");
    paramActivity.startActivity(localIntent2);
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundManager.b();
    Object localObject = paramQQAppInterface.getApp().getSharedPreferences("unreadcount", 4).edit();
    ((SharedPreferences.Editor)localObject).putInt("unread", 0);
    ((SharedPreferences.Editor)localObject).commit();
    paramQQAppInterface.logout(true);
    if (GlobalImageCache.a != null) {
      GlobalImageCache.a.evictAll();
    }
    if ((QQPlayerService.a()) && (paramActivity != null))
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("qqplayer_exit_action");
      paramActivity.sendBroadcast((Intent)localObject);
    }
    SharedPreUtils.a(BaseApplicationImpl.sApplication, paramQQAppInterface.getCurrentAccountUin(), false);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, EIPCResultCallback paramEIPCResultCallback)
  {
    if (paramEIPCResultCallback == null)
    {
      QLog.d("LoginHelper", 1, "toWtLoginOnOpenSdk callback is null");
      return;
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      QLog.d("LoginHelper", 1, new Object[] { "toWtLoginOnOpenSdk appId=", paramString3, ", uin=", AuthorityUtil.a(paramString1) });
      paramString2 = new Bundle();
      paramString2.putString("uin", paramString1);
      paramString2.putInt("key_sso_ret", 1007);
      paramEIPCResultCallback.onCallback(EIPCResult.createResult(-102, paramString2));
      return;
    }
    QLog.d("LoginHelper", 1, "toWtLoginOnOpenSdk");
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString1);
    localBundle.putString("passwd", paramString2);
    localBundle.putString("appid", paramString3);
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:openSdk", "ae_camera_get_info_client", "action_to_wt_login", localBundle, paramEIPCResultCallback);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, SSOAccountObserver paramSSOAccountObserver)
  {
    QLog.d("LoginHelper", 1, new Object[] { "doWtLoginOnOpenSdk appId=", paramString1, ", uin=", AuthorityUtil.a(paramString2), ", observer=", paramSSOAccountObserver });
    if (!a(paramString1, paramString2, paramString3, paramSSOAccountObserver)) {
      return;
    }
    AppRuntime localAppRuntime;
    try
    {
      localAppRuntime = BaseApplicationImpl.sApplication.peekAppRuntime();
      QLog.d("LoginHelper", 1, new Object[] { "doWtLoginOnOpenSdk app = ", localAppRuntime });
      if (localAppRuntime == null)
      {
        paramSSOAccountObserver.onFailed(paramString1, 1100, -1012, null);
        return;
      }
    }
    catch (Exception paramString2)
    {
      QLog.e("LoginHelper", 1, "Exception ", paramString2);
      paramSSOAccountObserver.onFailed(paramString1, 1100, -1012, null);
      return;
    }
    Bundle localBundle = new Bundle();
    if (OpenSdkIFrameProcessor.a()) {
      localBundle.putInt("puzzle_verify_code", 130);
    }
    localBundle.putByteArray("connect_data", AuthorityUtil.a(paramString1));
    localAppRuntime.ssoLogin(paramString2, paramString3, 4096, paramSSOAccountObserver, localBundle);
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (!(paramAppRuntime instanceof AppInterface)) {
      QLog.e("LoginHelper", 1, "clearProgressDialog appRuntime is not AppInterface");
    }
    do
    {
      return;
      paramAppRuntime = ((AppInterface)paramAppRuntime).getHandler(LoginProgressClazz.class);
    } while (paramAppRuntime == null);
    paramAppRuntime.sendEmptyMessage(20140107);
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3, SSOAccountObserver paramSSOAccountObserver)
  {
    if (paramSSOAccountObserver == null)
    {
      QLog.d("LoginHelper", 1, "checkParamsValid null == observer");
      return false;
    }
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1)))
    {
      QLog.d("LoginHelper", 1, "checkParamsValid invalid params");
      paramSSOAccountObserver.onFailed(paramString1, 1100, -1012, null);
      return false;
    }
    if (!"com.tencent.mobileqq:openSdk".equals(BaseApplicationImpl.getApplication().getQQProcessName()))
    {
      QLog.d("LoginHelper", 1, new Object[] { "checkParamsValid process = ", BaseApplicationImpl.getApplication().getQQProcessName() });
      paramSSOAccountObserver.onFailed(paramString1, 1100, -1012, null);
      return false;
    }
    return true;
  }
  
  public static void b(AppRuntime paramAppRuntime)
  {
    if (!(paramAppRuntime instanceof AppInterface)) {
      QLog.e("LoginHelper", 1, "showProgressDialog appRuntime is not AppInterface");
    }
    do
    {
      return;
      paramAppRuntime = ((AppInterface)paramAppRuntime).getHandler(LoginProgressClazz.class);
    } while (paramAppRuntime == null);
    paramAppRuntime.sendEmptyMessage(20200515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.LoginHelper
 * JD-Core Version:    0.7.0.1
 */