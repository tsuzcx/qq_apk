package com.tencent.mobileqq.relationx.friendclue;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.webview.util.WebViewComUtils;
import com.tencent.qphone.base.util.QLog;

public class FriendClueConfigHelper
{
  private QQAppInterface a;
  
  public FriendClueConfigHelper(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public static boolean a()
  {
    FriendClueConfig localFriendClueConfig = (FriendClueConfig)QConfigManager.b().b(677);
    boolean bool;
    if (localFriendClueConfig != null) {
      bool = localFriendClueConfig.a;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendClueConfigHelper", 2, String.format("isIsNeedShow isNeedShow=%s", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    paramString = String.format("%s?uin=%s", new Object[] { "https://ti.qq.com/friends/recall", paramString });
    if (QLog.isDevelopLevel()) {
      QLog.d("FriendClueConfigHelper", 1, String.format("openQQBrowser url=%s", new Object[] { paramString }));
    }
    if (paramActivity != null)
    {
      Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("finish_animation_out_to_right", true);
      localIntent.putExtra("is_wrap_content", true);
      localIntent.putExtra("hide_left_button", false);
      if (WebViewComUtils.a(1000L)) {
        paramActivity.startActivity(localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.friendclue.FriendClueConfigHelper
 * JD-Core Version:    0.7.0.1
 */