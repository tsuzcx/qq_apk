package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;

public class AdProxyImpl$AdResultReceiver
  extends ResultReceiver
{
  private AdProxyImpl.SDKRewardedVideoAdView a;
  
  public AdProxyImpl$AdResultReceiver(Handler paramHandler, AdProxyImpl.SDKRewardedVideoAdView paramSDKRewardedVideoAdView)
  {
    super(paramHandler);
    this.a = paramSDKRewardedVideoAdView;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    AdProxyImpl.SDKRewardedVideoAdView localSDKRewardedVideoAdView = this.a;
    if (localSDKRewardedVideoAdView != null)
    {
      localSDKRewardedVideoAdView.a(paramInt, paramBundle);
      return;
    }
    QLog.d("AdResultReceiver", 1, "adView is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.AdResultReceiver
 * JD-Core Version:    0.7.0.1
 */