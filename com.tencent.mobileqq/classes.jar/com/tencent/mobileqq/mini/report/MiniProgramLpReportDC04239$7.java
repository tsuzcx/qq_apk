package com.tencent.mobileqq.mini.report;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import org.json.JSONObject;

final class MiniProgramLpReportDC04239$7
  implements Runnable
{
  MiniProgramLpReportDC04239$7(JSONObject paramJSONObject, MiniAppConfig paramMiniAppConfig) {}
  
  public void run()
  {
    if (this.val$jsonObject != null)
    {
      String str1 = this.val$jsonObject.optString("actiontype");
      String str2 = this.val$jsonObject.optString("sub_actiontype");
      String str3 = this.val$jsonObject.optString("reserves_action");
      MiniProgramLpReportDC04239.access$000(this.val$miniAppConfig, "1", null, str1, str2, str3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.7
 * JD-Core Version:    0.7.0.1
 */