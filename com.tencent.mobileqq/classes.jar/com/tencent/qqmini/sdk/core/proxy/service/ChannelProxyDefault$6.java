package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.SenderListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.request.ProtoBufRequest;
import org.json.JSONObject;

class ChannelProxyDefault$6
  implements MiniAppProxy.SenderListener
{
  ChannelProxyDefault$6(ChannelProxyDefault paramChannelProxyDefault, ProtoBufRequest paramProtoBufRequest, AsyncResult paramAsyncResult) {}
  
  public boolean onReply(int paramInt, byte[] paramArrayOfByte, String paramString)
  {
    QMLog.w("ChannelProxyDefault", "useHttpDirectly recvData " + this.val$request + ",retCode = " + paramInt);
    if (paramInt == 0) {
      if (this.val$result != null)
      {
        paramArrayOfByte = this.val$request.getResponse(paramArrayOfByte);
        if (paramArrayOfByte == null) {
          break label99;
        }
        if (paramArrayOfByte.optInt("retCode", 0) != 0L) {
          break label86;
        }
        this.val$result.onReceiveResult(true, paramArrayOfByte);
      }
    }
    label86:
    label99:
    while (this.val$result == null)
    {
      return true;
      this.val$result.onReceiveResult(false, paramArrayOfByte);
      return true;
      this.val$result.onReceiveResult(false, new JSONObject());
      return true;
    }
    this.val$result.onReceiveResult(false, new JSONObject());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ChannelProxyDefault.6
 * JD-Core Version:    0.7.0.1
 */