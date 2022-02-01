package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

@JsPlugin(secondary=true)
public class RefreshQzoneFeedPlugin
  extends BaseJsPlugin
{
  @JsEvent({"refreshQzoneFeed"})
  public void refreshQzoneFeed(RequestEvent paramRequestEvent)
  {
    Activity localActivity = this.mMiniAppContext.getAttachedActivity();
    if (localActivity != null)
    {
      Intent localIntent = new Intent("action_personalize_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "refreshFeed");
      localIntent.putExtras(localBundle);
      QZoneHelper.forwardToQzoneTransluentActivity(localActivity, QZoneHelper.UserInfo.getInstance(), localIntent);
      paramRequestEvent.ok();
      if (QLog.isColorLevel()) {
        QLog.i("RefreshQzoneFeedPlugin", 2, "RefreshQzoneFeed");
      }
      return;
    }
    QLog.e("RefreshQzoneFeedPlugin", 1, "activity is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.RefreshQzoneFeedPlugin
 * JD-Core Version:    0.7.0.1
 */