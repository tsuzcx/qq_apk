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
    QMLog.d("PayJsPlugin", "doOnActivityResult requestCode" + paramInt1 + " resultCode:" + paramInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PayJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */