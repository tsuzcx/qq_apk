package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import begz;
import beka;
import bgxy;
import bgyf;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;

public class RefreshQzoneFeedPlugin
  extends BaseJsPlugin
{
  public static final String TAG = "RefreshQzoneFeedPlugin";
  
  public void refreshQzoneFeed(beka parambeka)
  {
    Activity localActivity = this.mMiniAppContext.a();
    if (localActivity != null)
    {
      Intent localIntent = new Intent("action_personalize_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "refreshFeed");
      localIntent.putExtras(localBundle);
      bgxy.a(localActivity, bgyf.a(), localIntent);
      parambeka.a();
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