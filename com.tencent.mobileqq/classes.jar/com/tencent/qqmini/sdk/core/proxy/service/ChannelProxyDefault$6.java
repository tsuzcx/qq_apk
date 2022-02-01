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
    paramString = new StringBuilder();
    paramString.append("useHttpDirectly recvData ");
    paramString.append(this.val$request);
    paramString.append(",retCode = ");
    paramString.append(paramInt);
    QMLog.w("ChannelProxyDefault", paramString.toString());
    if (paramInt == 0)
    {
      if (this.val$result != null)
      {
        paramArrayOfByte = this.val$request.getResponse(paramArrayOfByte);
        if (paramArrayOfByte != null)
        {
          if (paramArrayOfByte.optInt("retCode", 0) == 0L)
          {
            this.val$result.onReceiveResult(true, paramArrayOfByte);
            return true;
          }
          this.val$result.onReceiveResult(false, paramArrayOfByte);
          return true;
        }
        this.val$result.onReceiveResult(false, new JSONObject());
        return true;
      }
    }
    else
    {
      paramArrayOfByte = this.val$result;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.onReceiveResult(false, new JSONObject());
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ChannelProxyDefault.6
 * JD-Core Version:    0.7.0.1
 */