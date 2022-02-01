package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class DefaultLogoutResult
  extends BaseLoginResult
{
  public void a(Activity paramActivity, AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      ThemeUiPlugin.destroy((QQAppInterface)paramAppRuntime);
    }
    ChatBackgroundManager.j();
    if (GlobalImageCache.a != null) {
      try
      {
        GlobalImageCache.a.evictAll();
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("DefaultLogoutResult", 1, "sImageCache.evictAll error : ", paramAppRuntime);
      }
    }
    if (QQPlayerService.b())
    {
      paramAppRuntime = new Intent();
      paramAppRuntime.setAction("qqplayer_exit_action");
      paramActivity.sendBroadcast(paramAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.DefaultLogoutResult
 * JD-Core Version:    0.7.0.1
 */