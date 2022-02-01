package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0x87c.RspBody;

class ChannelProxyImpl$5
  extends MiniAppSendSmsCodeObserver
{
  ChannelProxyImpl$5(ChannelProxyImpl paramChannelProxyImpl, AsyncResult paramAsyncResult) {}
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    super.onFailedResponse(paramString1, paramInt, paramString2);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("verify onFailedResponse cmd : ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", code : ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("; message : ");
    ((StringBuilder)localObject).append(paramString2);
    QLog.e("ChannelProxyImpl", 1, ((StringBuilder)localObject).toString());
    try
    {
      if (this.a != null)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("message", paramString2);
        ((JSONObject)localObject).put("code", paramInt);
        ((JSONObject)localObject).put("cmd", paramString1);
        this.a.onReceiveResult(false, (JSONObject)localObject);
        return;
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("ChannelProxyImpl", 1, "onFailedResponse error,", paramString1);
    }
  }
  
  public void verifySmsCodeSuccess(oidb_0x87c.RspBody paramRspBody)
  {
    super.verifySmsCodeSuccess(paramRspBody);
    QLog.d("ChannelProxyImpl", 1, "verify success");
    try
    {
      if (this.a != null)
      {
        paramRspBody = new JSONObject();
        this.a.onReceiveResult(true, paramRspBody);
        return;
      }
    }
    catch (Throwable paramRspBody)
    {
      QLog.e("ChannelProxyImpl", 1, "onFailedResponse error,", paramRspBody);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.5
 * JD-Core Version:    0.7.0.1
 */