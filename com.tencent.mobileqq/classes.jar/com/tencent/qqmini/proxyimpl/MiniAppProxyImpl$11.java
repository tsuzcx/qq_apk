package com.tencent.qqmini.proxyimpl;

import besl;
import bhzu;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import org.json.JSONObject;

class MiniAppProxyImpl$11
  implements bhzu
{
  MiniAppProxyImpl$11(MiniAppProxyImpl paramMiniAppProxyImpl, AsyncResult paramAsyncResult) {}
  
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
        besl.d("MiniAppProxyImpl", "tianshuRequestAdv", paramGetAdsRsp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.11
 * JD-Core Version:    0.7.0.1
 */