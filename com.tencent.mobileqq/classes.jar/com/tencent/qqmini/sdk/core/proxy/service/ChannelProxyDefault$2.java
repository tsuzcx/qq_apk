package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONObject;

class ChannelProxyDefault$2
  implements AsyncResult
{
  ChannelProxyDefault$2(ChannelProxyDefault paramChannelProxyDefault, AsyncResult paramAsyncResult) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (this.val$asyncResult != null) {
      this.val$asyncResult.onReceiveResult(paramBoolean, paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ChannelProxyDefault.2
 * JD-Core Version:    0.7.0.1
 */