package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;

class RewardedVideoAdPlugin$2
  implements MiniAppController.ActivityResultListener
{
  RewardedVideoAdPlugin$2(RewardedVideoAdPlugin paramRewardedVideoAdPlugin, String paramString1, Activity paramActivity, String paramString2, JsRuntime paramJsRuntime, int paramInt) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 101))
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent == null)
      {
        QLog.e("[minigame] RewardedVideoAdPlugin", 1, "RewardedAd ActivityResultListener receive b=null");
        RewardedVideoAdPlugin.access$000(this.this$0, 1003, this.val$compId);
        return true;
      }
      RewardedVideoAdPlugin.access$100(this.this$0, paramInt2, paramIntent, this.val$compId, this.val$activity, this.val$event, this.val$webview, this.val$callbackId);
      QLog.d("[minigame] RewardedVideoAdPlugin", 1, "removeActivityResultListener");
      MiniAppController.getInstance().removeActivityResultListener(this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RewardedVideoAdPlugin.2
 * JD-Core Version:    0.7.0.1
 */