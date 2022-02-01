package com.tencent.mobileqq.mini.report;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;

class MiniProgramReporter$2
  implements MiniAppCmdInterface
{
  MiniProgramReporter$2(MiniProgramReporter paramMiniProgramReporter, List paramList) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("performDataReportViaSSO  onDcReport() called with: isSuc = [true], ret = [");
      localStringBuilder.append(paramJSONObject);
      localStringBuilder.append("]");
      QLog.d("MiniProgramReporter", 2, localStringBuilder.toString());
      return;
    }
    QLog.e("MiniProgramReporter", 1, "performDataReportViaSSO onDcReport: sso command failed, try again");
    this.this$0.addDataAll(this.val$currentlyOperatedSingleDcDataList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramReporter.2
 * JD-Core Version:    0.7.0.1
 */