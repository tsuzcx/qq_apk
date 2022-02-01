package com.tencent.qqmini.sdk.plugins;

import android.content.Intent;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import org.json.JSONObject;

class PayJsPlugin$5
  implements IActivityResultListener
{
  PayJsPlugin$5(PayJsPlugin paramPayJsPlugin, RequestEvent paramRequestEvent) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramIntent = new StringBuilder();
    paramIntent.append("doOnActivityResult requestCode");
    paramIntent.append(paramInt1);
    paramIntent.append(" resultCode:");
    paramIntent.append(paramInt2);
    QMLog.d("PayJsPlugin", paramIntent.toString());
    if (paramInt1 == 3005)
    {
      new JSONObject();
      this.val$req.ok();
      ActivityResultManager.g().removeActivityResultListener(this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PayJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */