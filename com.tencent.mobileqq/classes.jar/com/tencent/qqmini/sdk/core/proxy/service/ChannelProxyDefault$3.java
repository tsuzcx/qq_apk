package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;
import java.util.Map;

class ChannelProxyDefault$3
  implements RequestProxy.RequestListener
{
  ChannelProxyDefault$3(ChannelProxyDefault paramChannelProxyDefault) {}
  
  public void onRequestFailed(int paramInt, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("httpReport onRequestFailed code = ");
    paramString.append(paramInt);
    QMLog.e("ChannelProxyDefault", paramString.toString());
  }
  
  public void onRequestHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onRequestSucceed(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    QMLog.d("ChannelProxyDefault", "httpReport onRequestSucceed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ChannelProxyDefault.3
 * JD-Core Version:    0.7.0.1
 */