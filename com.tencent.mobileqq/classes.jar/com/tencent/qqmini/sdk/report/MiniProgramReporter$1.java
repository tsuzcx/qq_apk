package com.tencent.qqmini.sdk.report;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;
import org.json.JSONObject;

class MiniProgramReporter$1
  implements AsyncResult
{
  MiniProgramReporter$1(MiniProgramReporter paramMiniProgramReporter, List paramList) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDcReport() called with: isSuc = [true], ret = [");
      localStringBuilder.append(paramJSONObject);
      localStringBuilder.append("]");
      QMLog.d("MiniProgramReporter", localStringBuilder.toString());
      return;
    }
    QMLog.e("MiniProgramReporter", "performReportViaSSO onDcReport: sso command failed, try again");
    this.this$0.addAll(this.val$currentlyOperatedSingleDcDataList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramReporter.1
 * JD-Core Version:    0.7.0.1
 */