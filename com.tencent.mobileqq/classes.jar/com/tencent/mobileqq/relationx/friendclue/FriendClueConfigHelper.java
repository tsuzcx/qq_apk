package com.tencent.mobileqq.relationx.friendclue;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfigManager;
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
    FriendClueConfig localFriendClueConfig = (FriendClueConfig)QConfigManager.a().a(677);
    if (localFriendClueConfig != null) {}
    for (boolean bool = localFriendClueConfig.a;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendClueConfigHelper", 2, String.format("isIsNeedShow isNeedShow=%s", new Object[] { Boolean.valueOf(bool) }));
      }
      return bool;
    }
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    paramString = String.format("%s?uin=%s", new Object[] { "https://ti.qq.com/friends/recall", paramString });
    if (QLog.isDevelopLevel()) {
      QLog.d("FriendClueConfigHelper", 1, String.format("openQQBrowser url=%s", new Object[] { paramString }));
    }
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("finish_animation_out_to_right", true);
    localIntent.putExtra("is_wrap_content", true);
    localIntent.putExtra("hide_left_button", false);
    if ((paramActivity != null) && (QQBrowserActivity.checkNotFrequentlyThenEnter(1000L))) {
      paramActivity.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.friendclue.FriendClueConfigHelper
 * JD-Core Version:    0.7.0.1
 */