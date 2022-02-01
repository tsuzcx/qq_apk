package com.tencent.qqmini.sdk.report;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class MiniAppRealTimeLogReporter$1
  implements AsyncResult
{
  MiniAppRealTimeLogReporter$1(MiniAppRealTimeLogReporter paramMiniAppRealTimeLogReporter) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("realTimeLogReport  ReportLog isSuc: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("  ret:");
    localStringBuilder.append(paramJSONObject);
    QMLog.d("MiniAppRealTimeLogReporter", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniAppRealTimeLogReporter.1
 * JD-Core Version:    0.7.0.1
 */