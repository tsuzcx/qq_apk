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
    QLog.d("MiniAppReportShareUtil", 1, "report share success: " + paramBoolean + "  reportTime:" + this.val$reportTime + "  appid:" + this.val$appid + "  appType:" + this.val$appType + "  shareScene:" + this.val$mShareScene + "  shareType:" + 0 + "  destType:" + this.val$destType + "  destId:" + this.val$destId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.MiniAppReportShareUtil.1
 * JD-Core Version:    0.7.0.1
 */