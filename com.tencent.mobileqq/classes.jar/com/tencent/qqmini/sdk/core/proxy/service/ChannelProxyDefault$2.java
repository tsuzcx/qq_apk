package com.tencent.qqmini.sdk.core.proxy.service;

import betc;
import com.tencent.qqmini.sdk.core.proxy.RequestProxy.RequestListener;
import java.util.List;
import java.util.Map;

class ChannelProxyDefault$2
  implements RequestProxy.RequestListener
{
  ChannelProxyDefault$2(ChannelProxyDefault paramChannelProxyDefault) {}
  
  public void onRequestFailed(int paramInt, String paramString)
  {
    betc.d("ChannelProxyDefault", "httpReport onRequestFailed code = " + paramInt);
  }
  
  public void onRequestHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onRequestSucceed(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    betc.a("ChannelProxyDefault", "httpReport onRequestSucceed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ChannelProxyDefault.2
 * JD-Core Version:    0.7.0.1
 */