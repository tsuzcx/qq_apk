package com.tencent.qqmini.proxyimpl;

import bkgo;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.log.QMLog;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import org.json.JSONObject;

class ChannelProxyImpl$4
  implements bkgo
{
  ChannelProxyImpl$4(ChannelProxyImpl paramChannelProxyImpl, AsyncResult paramAsyncResult) {}
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    JSONObject localJSONObject;
    if (this.val$asyncResult != null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("response", paramGetAdsRsp);
      this.val$asyncResult.onReceiveResult(paramBoolean, localJSONObject);
      return;
    }
    catch (Throwable paramGetAdsRsp)
    {
      for (;;)
      {
        QMLog.e("ChannelProxyImpl", "tianshuRequestAdv", paramGetAdsRsp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.4
 * JD-Core Version:    0.7.0.1
 */