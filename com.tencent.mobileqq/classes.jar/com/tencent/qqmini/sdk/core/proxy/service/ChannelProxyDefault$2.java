package com.tencent.qqmini.sdk.core.proxy.service;

import bdtz;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy.SenderListener;
import org.json.JSONObject;

class ChannelProxyDefault$2
  implements MiniAppProxy.SenderListener
{
  ChannelProxyDefault$2(ChannelProxyDefault paramChannelProxyDefault, AsyncResult paramAsyncResult, bdtz parambdtz) {}
  
  public boolean onReply(int paramInt, byte[] paramArrayOfByte, String paramString)
  {
    if (paramInt == 0) {
      if (this.val$result != null)
      {
        paramArrayOfByte = this.val$request.a(paramArrayOfByte);
        if (paramArrayOfByte == null) {
          break label37;
        }
        this.val$result.onReceiveResult(true, paramArrayOfByte);
      }
    }
    label37:
    while (this.val$result == null)
    {
      return true;
      this.val$result.onReceiveResult(false, new JSONObject());
      return true;
    }
    this.val$result.onReceiveResult(false, new JSONObject());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ChannelProxyDefault.2
 * JD-Core Version:    0.7.0.1
 */