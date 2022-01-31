package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.manager.GameLoadManager;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qphone.base.util.QLog;

class RewardedVideoAdPlugin$2
  extends ResultReceiver
{
  RewardedVideoAdPlugin$2(RewardedVideoAdPlugin paramRewardedVideoAdPlugin, Handler paramHandler, String paramString1, Activity paramActivity, String paramString2, JsRuntime paramJsRuntime, int paramInt, boolean paramBoolean)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("[minigame] RewardedVideoAdPlugin", 2, "onReceiveResult() called with: resultCode = [" + paramInt + "], resultData = [" + paramBundle + "]");
    }
    RewardedVideoAdPlugin.access$000(this.this$0, paramInt, paramBundle, this.val$compId, this.val$activity, this.val$event, this.val$webview, this.val$callbackId);
    if ((this.val$currentIsMiniGame) && (GameLoadManager.g().getGameEngine() != null)) {
      GameLoadManager.g().getGameEngine().handleFocusGain();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RewardedVideoAdPlugin.2
 * JD-Core Version:    0.7.0.1
 */