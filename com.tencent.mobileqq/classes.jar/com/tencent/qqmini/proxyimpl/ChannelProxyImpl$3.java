package com.tencent.qqmini.proxyimpl;

import NS_MINI_INTERFACE.INTERFACE.StReportExecuteRsp;
import besl;
import com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper.MiniAppCmdCallback;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class ChannelProxyImpl$3
  implements MiniAppSSOCmdHelper.MiniAppCmdCallback<INTERFACE.StReportExecuteRsp>
{
  ChannelProxyImpl$3(ChannelProxyImpl paramChannelProxyImpl, AsyncResult paramAsyncResult) {}
  
  public void onReceived(boolean paramBoolean, INTERFACE.StReportExecuteRsp paramStReportExecuteRsp)
  {
    JSONObject localJSONObject;
    if (this.val$listener != null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("response", paramStReportExecuteRsp);
      this.val$listener.onReceiveResult(paramBoolean, localJSONObject);
      return;
    }
    catch (Throwable paramStReportExecuteRsp)
    {
      for (;;)
      {
        besl.d("ChannelProxyImpl", "tianshuRequestAdv", paramStReportExecuteRsp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.3
 * JD-Core Version:    0.7.0.1
 */