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
    Object localObject2;
    if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("gameInnerReport() called with args: ");
      localObject1 = this.val$jsonObject;
      if (localObject1 != null) {
        localObject1 = ((JSONObject)localObject1).toString();
      } else {
        localObject1 = "empty";
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      QMLog.d("MiniProgramLpReportDC04239", ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.val$jsonObject;
    if (localObject1 != null)
    {
      localObject1 = ((JSONObject)localObject1).optString("actiontype");
      localObject2 = this.val$jsonObject.optString("sub_actiontype");
      String str = this.val$jsonObject.optString("reserves_action");
      SDKMiniProgramLpReportDC04239.access$300(this.val$miniAppConfig, "1", null, (String)localObject1, (String)localObject2, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.9
 * JD-Core Version:    0.7.0.1
 */