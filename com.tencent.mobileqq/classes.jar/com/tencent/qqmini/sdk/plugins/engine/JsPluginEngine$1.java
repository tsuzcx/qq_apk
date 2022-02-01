package com.tencent.qqmini.sdk.plugins.engine;

import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import java.util.List;

class JsPluginEngine$1
  implements Runnable
{
  JsPluginEngine$1(JsPluginEngine paramJsPluginEngine, String paramString, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    Object localObject1 = ReportConst.apiReportList;
    Object localObject2 = (WnsConfigProxy)ProxyManager.get(WnsConfigProxy.class);
    if (localObject2 != null)
    {
      localObject2 = ((WnsConfigProxy)localObject2).getApiReportConfig();
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((List)localObject1).contains(this.val$eventName))) {
        SDKMiniProgramLpReportDC04239.reportApiInvoke(this.val$miniAppInfo, this.val$eventName);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine.1
 * JD-Core Version:    0.7.0.1
 */