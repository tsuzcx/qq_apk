package com.tencent.qqmini.sdk.report;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

final class SDKMiniProgramLpReportDC04239$9
  implements Runnable
{
  SDKMiniProgramLpReportDC04239$9(JSONObject paramJSONObject, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    Object localObject;
    if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion())
    {
      localObject = new StringBuilder().append("gameInnerReport() called with args: ");
      if (this.val$jsonObject == null) {
        break label106;
      }
    }
    label106:
    for (String str1 = this.val$jsonObject.toString();; str1 = "empty")
    {
      QMLog.d("MiniProgramLpReportDC04239", str1);
      if (this.val$jsonObject != null)
      {
        str1 = this.val$jsonObject.optString("actiontype");
        localObject = this.val$jsonObject.optString("sub_actiontype");
        String str2 = this.val$jsonObject.optString("reserves_action");
        SDKMiniProgramLpReportDC04239.access$300(this.val$miniAppConfig, "1", null, str1, (String)localObject, str2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.9
 * JD-Core Version:    0.7.0.1
 */