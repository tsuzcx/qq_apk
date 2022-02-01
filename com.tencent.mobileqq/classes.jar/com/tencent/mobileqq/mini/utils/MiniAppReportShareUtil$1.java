package com.tencent.mobileqq.mini.utils;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniAppReportShareUtil$1
  implements MiniAppCmdInterface
{
  MiniAppReportShareUtil$1(MiniAppReportShareUtil paramMiniAppReportShareUtil, long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
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
    QLog.d("MiniAppReportShareUtil", 1, paramJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.MiniAppReportShareUtil.1
 * JD-Core Version:    0.7.0.1
 */