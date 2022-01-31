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
    QLog.d("ReportLogUtil", 1, "report upload log success: " + paramBoolean + "  url:" + this.val$url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.ReportLogUtil.1.1
 * JD-Core Version:    0.7.0.1
 */