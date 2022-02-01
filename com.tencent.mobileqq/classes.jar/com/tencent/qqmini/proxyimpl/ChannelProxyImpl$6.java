package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import org.json.JSONObject;

class ChannelProxyImpl$6
  implements TianShuGetAdvCallback
{
  ChannelProxyImpl$6(ChannelProxyImpl paramChannelProxyImpl, AsyncResult paramAsyncResult) {}
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    if (this.a != null)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("response", paramGetAdsRsp);
      }
      catch (Throwable paramGetAdsRsp)
      {
        QLog.e("ChannelProxyImpl", 1, "tianshuRequestAdv", paramGetAdsRsp);
      }
      this.a.onReceiveResult(paramBoolean, localJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.6
 * JD-Core Version:    0.7.0.1
 */