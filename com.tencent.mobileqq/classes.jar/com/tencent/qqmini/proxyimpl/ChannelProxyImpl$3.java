package com.tencent.qqmini.proxyimpl;

import NS_MINI_INTERFACE.INTERFACE.StReportExecuteRsp;
import com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper.MiniAppCmdCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONObject;

class ChannelProxyImpl$3
  implements MiniAppSSOCmdHelper.MiniAppCmdCallback<INTERFACE.StReportExecuteRsp>
{
  ChannelProxyImpl$3(ChannelProxyImpl paramChannelProxyImpl, AsyncResult paramAsyncResult) {}
  
  public void a(boolean paramBoolean, INTERFACE.StReportExecuteRsp paramStReportExecuteRsp)
  {
    JSONObject localJSONObject;
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult != null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("response", paramStReportExecuteRsp);
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult.onReceiveResult(paramBoolean, localJSONObject);
      return;
    }
    catch (Throwable paramStReportExecuteRsp)
    {
      for (;;)
      {
        QLog.e("ChannelProxyImpl", 1, "tianshuRequestAdv", paramStReportExecuteRsp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.3
 * JD-Core Version:    0.7.0.1
 */