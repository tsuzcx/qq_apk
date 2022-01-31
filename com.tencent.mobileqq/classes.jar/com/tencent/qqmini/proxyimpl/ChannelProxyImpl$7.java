package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

final class ChannelProxyImpl$7
  implements MiniAppCmdInterface
{
  ChannelProxyImpl$7(AsyncResult paramAsyncResult) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (this.val$result != null) {
      this.val$result.onReceiveResult(paramBoolean, paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.7
 * JD-Core Version:    0.7.0.1
 */