package com.tencent.qqmini.proxyimpl;

final class AdProxyImpl$CallbackData
{
  private static int jdField_a_of_type_Int = 0;
  private AdProxyImpl.SDKRewardedVideoAdView jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKRewardedVideoAdView;
  
  private AdProxyImpl$CallbackData(AdProxyImpl.SDKRewardedVideoAdView paramSDKRewardedVideoAdView)
  {
    this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKRewardedVideoAdView = paramSDKRewardedVideoAdView;
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("AD_PROXY_ACTION_MOTIVE_BROWSING_END#index#");
    int i = jdField_a_of_type_Int;
    jdField_a_of_type_Int = i + 1;
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.CallbackData
 * JD-Core Version:    0.7.0.1
 */