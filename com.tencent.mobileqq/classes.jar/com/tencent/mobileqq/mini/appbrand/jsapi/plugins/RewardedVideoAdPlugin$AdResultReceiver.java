package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.mini.appbrand.jsapi.AdFrequencyLimit;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class RewardedVideoAdPlugin$AdResultReceiver
  extends ResultReceiver
{
  private WeakReference<Activity> mActivity;
  private int mCallbackId;
  private String mCompId;
  private String mEvent;
  private boolean mIsMiniGame;
  RewardedVideoAdPlugin mRewardedVideoAdPlugin;
  private JsRuntime mWebview;
  
  public RewardedVideoAdPlugin$AdResultReceiver(Handler paramHandler, RewardedVideoAdPlugin paramRewardedVideoAdPlugin, String paramString1, Activity paramActivity, String paramString2, JsRuntime paramJsRuntime, int paramInt, boolean paramBoolean)
  {
    super(paramHandler);
    this.mRewardedVideoAdPlugin = paramRewardedVideoAdPlugin;
    this.mCompId = paramString1;
    this.mActivity = new WeakReference(paramActivity);
    this.mEvent = paramString2;
    this.mWebview = paramJsRuntime;
    this.mCallbackId = paramInt;
    this.mIsMiniGame = paramBoolean;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("[minigame] RewardedVideoAdPlugin", 2, "onReceiveResult() called with: resultCode = [" + paramInt + "], resultData = [" + paramBundle + "]");
    }
    if (this.mRewardedVideoAdPlugin != null) {
      this.mRewardedVideoAdPlugin.onReceiveVideoClose(paramInt, paramBundle, this.mCompId, (Activity)this.mActivity.get(), this.mEvent, this.mWebview, this.mCallbackId, this.mIsMiniGame);
    }
    for (;;)
    {
      AdFrequencyLimit.setRewardVideoAdShowing(false);
      return;
      QLog.e("[minigame] RewardedVideoAdPlugin", 1, "adplugin is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RewardedVideoAdPlugin.AdResultReceiver
 * JD-Core Version:    0.7.0.1
 */