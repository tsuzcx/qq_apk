package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.Intent;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;

class PayJsPlugin$3
  implements MiniAppController.ActivityResultListener
{
  PayJsPlugin$3(PayJsPlugin paramPayJsPlugin, int paramInt, String paramString) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 3001)
    {
      if (paramInt2 == 0) {
        PayJsPlugin.access$000(this.this$0, this.val$callbackId, this.val$eventName, null);
      }
      MiniAppController.getInstance().removeActivityResultListener(this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.PayJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */