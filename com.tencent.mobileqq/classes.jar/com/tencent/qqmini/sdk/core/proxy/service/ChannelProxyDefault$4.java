package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;
import java.util.Map;

class ChannelProxyDefault$4
  implements RequestProxy.RequestListener
{
  ChannelProxyDefault$4(ChannelProxyDefault paramChannelProxyDefault, AsyncResult paramAsyncResult, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onRequestFailed(int paramInt, String paramString)
  {
    QMLog.e("ChannelProxyDefault", "onRequestFailed ");
    this.val$listener.onReceiveResult(false, null);
  }
  
  public void onRequestHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onRequestSucceed(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    ChannelProxyDefault.access$000(this.this$0, paramInt, paramArrayOfByte, paramMap, this.val$returnAsJSON, this.val$rspBase64, this.val$listener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ChannelProxyDefault.4
 * JD-Core Version:    0.7.0.1
 */