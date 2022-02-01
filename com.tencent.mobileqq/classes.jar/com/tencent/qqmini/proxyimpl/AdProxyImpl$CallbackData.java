package com.tencent.qqmini.proxyimpl;

final class AdProxyImpl$CallbackData
{
  private static int a;
  private AdProxyImpl.SDKRewardedVideoAdView b;
  
  private AdProxyImpl$CallbackData(AdProxyImpl.SDKRewardedVideoAdView paramSDKRewardedVideoAdView)
  {
    this.b = paramSDKRewardedVideoAdView;
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AD_PROXY_ACTION_MOTIVE_BROWSING_END#index#");
    int i = a;
    a = i + 1;
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.CallbackData
 * JD-Core Version:    0.7.0.1
 */