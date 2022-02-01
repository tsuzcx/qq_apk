package com.tencent.qqmini.proxyimpl;

final class AdProxyImpl$CallbackData
{
  private static int jdField_a_of_type_Int;
  private AdProxyImpl.SDKRewardedVideoAdView jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKRewardedVideoAdView;
  
  private AdProxyImpl$CallbackData(AdProxyImpl.SDKRewardedVideoAdView paramSDKRewardedVideoAdView)
  {
    this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKRewardedVideoAdView = paramSDKRewardedVideoAdView;
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AD_PROXY_ACTION_MOTIVE_BROWSING_END#index#");
    int i = jdField_a_of_type_Int;
    jdField_a_of_type_Int = i + 1;
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.CallbackData
 * JD-Core Version:    0.7.0.1
 */