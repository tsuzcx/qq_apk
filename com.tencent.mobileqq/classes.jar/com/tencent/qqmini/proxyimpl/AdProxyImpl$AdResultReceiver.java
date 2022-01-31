package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;

public class AdProxyImpl$AdResultReceiver
  extends ResultReceiver
{
  private AdProxyImpl.SDKRewardedVideoAdView mAdView;
  
  public AdProxyImpl$AdResultReceiver(Handler paramHandler, AdProxyImpl.SDKRewardedVideoAdView paramSDKRewardedVideoAdView)
  {
    super(paramHandler);
    this.mAdView = paramSDKRewardedVideoAdView;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (this.mAdView != null)
    {
      this.mAdView.onReceiveVideoClose(paramInt, paramBundle);
      return;
    }
    QLog.d("AdResultReceiver", 1, "adView is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.AdResultReceiver
 * JD-Core Version:    0.7.0.1
 */