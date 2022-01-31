package com.tencent.qqmini.sdk.utils;

import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class MiniAppReportShareUtil$1
  implements AsyncResult
{
  MiniAppReportShareUtil$1(MiniAppReportShareUtil paramMiniAppReportShareUtil, long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.d("MiniAppReportShareUtil", "report share success: " + paramBoolean + "  reportTime:" + this.val$reportTime + "  appid:" + this.val$appid + "  appType:" + this.val$appType + "  shareScene:" + this.val$mShareScene + "  shareType:" + 0 + "  destType:" + this.val$destType + "  destId:" + this.val$destId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.MiniAppReportShareUtil.1
 * JD-Core Version:    0.7.0.1
 */