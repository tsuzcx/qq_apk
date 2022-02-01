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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("realTimeLogReport  ReportLog isSuc: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("  ret:");
    localStringBuilder.append(paramJSONObject);
    QLog.e("[mini] MiniAppRealTimeLogReporter", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppRealTimeLogReporter.1
 * JD-Core Version:    0.7.0.1
 */