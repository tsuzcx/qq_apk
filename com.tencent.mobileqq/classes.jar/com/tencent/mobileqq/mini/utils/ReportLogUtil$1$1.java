package com.tencent.mobileqq.mini.utils;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ReportLogUtil$1$1
  implements MiniAppCmdInterface
{
  ReportLogUtil$1$1(ReportLogUtil.1 param1, String paramString) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("report upload log success: ");
    paramJSONObject.append(paramBoolean);
    paramJSONObject.append("  url:");
    paramJSONObject.append(this.val$url);
    QLog.d("ReportLogUtil", 1, paramJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.ReportLogUtil.1.1
 * JD-Core Version:    0.7.0.1
 */