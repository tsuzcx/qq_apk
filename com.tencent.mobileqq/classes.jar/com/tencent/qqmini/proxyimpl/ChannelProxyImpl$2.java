package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

final class ChannelProxyImpl$2
  implements MiniAppCmdInterface
{
  ChannelProxyImpl$2(AsyncResult paramAsyncResult) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (this.val$result != null) {
      this.val$result.onReceiveResult(paramBoolean, paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */