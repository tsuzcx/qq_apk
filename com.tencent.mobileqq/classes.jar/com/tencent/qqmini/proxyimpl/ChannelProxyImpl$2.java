package com.tencent.qqmini.proxyimpl;

import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp;
import betc;
import com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper.MiniAppCmdCallback;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class ChannelProxyImpl$2
  implements MiniAppSSOCmdHelper.MiniAppCmdCallback<INTERFACE.StJudgeTimingRsp>
{
  ChannelProxyImpl$2(ChannelProxyImpl paramChannelProxyImpl, AsyncResult paramAsyncResult) {}
  
  public void onReceived(boolean paramBoolean, INTERFACE.StJudgeTimingRsp paramStJudgeTimingRsp)
  {
    JSONObject localJSONObject;
    if (this.val$listener != null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("response", paramStJudgeTimingRsp);
      this.val$listener.onReceiveResult(paramBoolean, localJSONObject);
      return;
    }
    catch (Throwable paramStJudgeTimingRsp)
    {
      for (;;)
      {
        betc.d("ChannelProxyImpl", "tianshuRequestAdv", paramStJudgeTimingRsp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */