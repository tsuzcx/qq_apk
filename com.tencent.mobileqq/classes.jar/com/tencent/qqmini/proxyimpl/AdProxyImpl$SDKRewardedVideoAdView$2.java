package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.IRewardVideoAdListener;

class AdProxyImpl$SDKRewardedVideoAdView$2
  extends ResultReceiver
{
  AdProxyImpl$SDKRewardedVideoAdView$2(AdProxyImpl.SDKRewardedVideoAdView paramSDKRewardedVideoAdView, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("AdProxyImpl", 2, "onReceiveResult() called with: resultCode = [" + paramInt + "], resultData = [" + paramBundle + "]");
    }
    long l1 = paramBundle.getLong("duration_time");
    long l2 = paramBundle.getLong("elapsed_time");
    boolean bool = paramBundle.getBoolean("profitable_flag", false);
    if (this.this$1.mRewardedListener != null)
    {
      if ((bool) && (paramInt == -1)) {
        this.this$1.mRewardedListener.onReward();
      }
      this.this$1.mRewardedListener.onADClose();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AdProxyImpl", 1, "RewardedAd ActivityResultListener receive durationTime= " + l1 + " elaspedTime=" + l2 + " profitable=" + bool + ", resultCode = " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKRewardedVideoAdView.2
 * JD-Core Version:    0.7.0.1
 */