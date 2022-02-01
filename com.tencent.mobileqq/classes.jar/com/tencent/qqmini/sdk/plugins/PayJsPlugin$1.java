package com.tencent.qqmini.sdk.plugins;

import android.content.Intent;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;

class PayJsPlugin$1
  implements IActivityResultListener
{
  PayJsPlugin$1(PayJsPlugin paramPayJsPlugin, RequestEvent paramRequestEvent) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 3001)
    {
      if (paramInt2 == 0) {
        PayJsPlugin.access$000(this.this$0, this.val$req, null);
      }
      ActivityResultManager.g().removeActivityResultListener(this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PayJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */