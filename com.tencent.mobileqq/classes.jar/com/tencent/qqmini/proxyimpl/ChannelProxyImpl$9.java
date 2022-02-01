package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONObject;

final class ChannelProxyImpl$9
  implements MiniAppCmdInterface
{
  ChannelProxyImpl$9(AsyncResult paramAsyncResult) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AsyncResult localAsyncResult = this.a;
    if (localAsyncResult != null) {
      localAsyncResult.onReceiveResult(paramBoolean, paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.9
 * JD-Core Version:    0.7.0.1
 */