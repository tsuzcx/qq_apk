package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import bgho;
import bgkd;
import bizm;
import bizt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;

public class RefreshQzoneFeedPlugin
  extends BaseJsPlugin
{
  public static final String TAG = "RefreshQzoneFeedPlugin";
  
  public void refreshQzoneFeed(bgkd parambgkd)
  {
    Activity localActivity = this.mMiniAppContext.a();
    if (localActivity != null)
    {
      Intent localIntent = new Intent("action_personalize_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "refreshFeed");
      localIntent.putExtras(localBundle);
      bizm.a(localActivity, bizt.a(), localIntent);
      parambgkd.a();
      if (QLog.isColorLevel()) {
        QLog.i("RefreshQzoneFeedPlugin", 2, "RefreshQzoneFeed");
      }
      return;
    }
    QLog.e("RefreshQzoneFeedPlugin", 1, "activity is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.RefreshQzoneFeedPlugin
 * JD-Core Version:    0.7.0.1
 */