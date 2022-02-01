package com.tencent.qqmini.sdk.utils;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class MiniAppReportShareUtil$1
  implements AsyncResult
{
  MiniAppReportShareUtil$1(MiniAppReportShareUtil paramMiniAppReportShareUtil, long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("report share success: ");
    paramJSONObject.append(paramBoolean);
    paramJSONObject.append("  reportTime:");
    paramJSONObject.append(this.val$reportTime);
    paramJSONObject.append("  appid:");
    paramJSONObject.append(this.val$appid);
    paramJSONObject.append("  appType:");
    paramJSONObject.append(this.val$appType);
    paramJSONObject.append("  shareScene:");
    paramJSONObject.append(this.val$mShareScene);
    paramJSONObject.append("  shareType:");
    paramJSONObject.append(0);
    paramJSONObject.append("  destType:");
    paramJSONObject.append(this.val$destType);
    paramJSONObject.append("  destId:");
    paramJSONObject.append(this.val$destId);
    QMLog.d("MiniAppReportShareUtil", paramJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.MiniAppReportShareUtil.1
 * JD-Core Version:    0.7.0.1
 */