package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import behq;
import bekr;
import bgyp;
import bgyw;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;

public class RefreshQzoneFeedPlugin
  extends BaseJsPlugin
{
  public static final String TAG = "RefreshQzoneFeedPlugin";
  
  public void refreshQzoneFeed(bekr parambekr)
  {
    Activity localActivity = this.mMiniAppContext.a();
    if (localActivity != null)
    {
      Intent localIntent = new Intent("action_personalize_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "refreshFeed");
      localIntent.putExtras(localBundle);
      bgyp.a(localActivity, bgyw.a(), localIntent);
      parambekr.a();
      if (QLog.isColorLevel()) {
        QLog.i("RefreshQzoneFeedPlugin", 2, "RefreshQzoneFeed");
      }
      return;
    }
    QLog.e("RefreshQzoneFeedPlugin", 1, "activity is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.RefreshQzoneFeedPlugin
 * JD-Core Version:    0.7.0.1
 */