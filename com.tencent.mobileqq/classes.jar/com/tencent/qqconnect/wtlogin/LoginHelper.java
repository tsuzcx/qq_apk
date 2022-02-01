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
import com.tencent.mobileqq.loginregister.LoginProgressClazz;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class LoginHelper
{
  protected LoginHelper.Callback a;
  
  public static String a(AppInterface paramAppInterface)
  {
    return ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount());
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
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      QLog.d("LoginHelper", 1, "toWtLoginOnOpenSdk");
      Bundle localBundle = new Bundle();
      localBundle.putString("uin", paramString1);
      localBundle.putString("passwd", paramString2);
      localBundle.putString("appid", paramString3);
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:openSdk", "ae_camera_get_info_client", "action_to_wt_login", localBundle, paramEIPCResultCallback);
      return;
    }
    QLog.d("LoginHelper", 1, new Object[] { "toWtLoginOnOpenSdk appId=", paramString3, ", uin=", AuthorityUtil.a(paramString1) });
    paramString2 = new Bundle();
    paramString2.putString("uin", paramString1);
    paramString2.putInt("key_sso_ret", 1007);
    paramEIPCResultCallback.onCallback(EIPCResult.createResult(-102, paramString2));
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (!(paramAppRuntime instanceof AppInterface))
    {
      QLog.e("LoginHelper", 1, "clearProgressDialog appRuntime is not AppInterface");
      return;
    }
    paramAppRuntime = ((AppInterface)paramAppRuntime).getHandler(LoginProgressClazz.class);
    if (paramAppRuntime != null) {
      paramAppRuntime.sendEmptyMessage(2001);
    }
  }
  
  public static void b(AppRuntime paramAppRuntime)
  {
    if (!(paramAppRuntime instanceof AppInterface))
    {
      QLog.e("LoginHelper", 1, "showProgressDialog appRuntime is not AppInterface");
      return;
    }
    paramAppRuntime = ((AppInterface)paramAppRuntime).getHandler(LoginProgressClazz.class);
    if (paramAppRuntime != null) {
      paramAppRuntime.sendEmptyMessage(2002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.LoginHelper
 * JD-Core Version:    0.7.0.1
 */