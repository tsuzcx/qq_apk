package com.tencent.qqmini.sdk.plugins;

import android.content.Intent;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;

class SettingsJsPlugin$2
  implements IActivityResultListener
{
  SettingsJsPlugin$2(SettingsJsPlugin paramSettingsJsPlugin, RequestEvent paramRequestEvent) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnActivityResult requestCode=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",resultCode=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(",data=");
    localStringBuilder.append(paramIntent);
    QMLog.d("SettingsJsPlugin", localStringBuilder.toString());
    if (paramInt1 == 5)
    {
      SettingsJsPlugin.access$200(this.this$0, this.val$req);
      ActivityResultManager.g().removeActivityResultListener(this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.SettingsJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */