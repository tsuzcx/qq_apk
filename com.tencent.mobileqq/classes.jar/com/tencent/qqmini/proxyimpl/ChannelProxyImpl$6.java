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
    JSONObject localJSONObject;
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult != null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("response", paramGetAdsRsp);
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult.onReceiveResult(paramBoolean, localJSONObject);
      return;
    }
    catch (Throwable paramGetAdsRsp)
    {
      for (;;)
      {
        QLog.e("ChannelProxyImpl", 1, "tianshuRequestAdv", paramGetAdsRsp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.6
 * JD-Core Version:    0.7.0.1
 */