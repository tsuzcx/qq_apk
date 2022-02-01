package com.tencent.mobileqq.mini.report;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniAppRealTimeLogReporter$1
  implements MiniAppCmdInterface
{
  MiniAppRealTimeLogReporter$1(MiniAppRealTimeLogReporter paramMiniAppRealTimeLogReporter) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.e("[mini] MiniAppRealTimeLogReporter", 1, "realTimeLogReport  ReportLog isSuc: " + paramBoolean + "  ret:" + paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppRealTimeLogReporter.1
 * JD-Core Version:    0.7.0.1
 */