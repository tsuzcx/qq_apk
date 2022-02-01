package com.tencent.mobileqq.mini.report;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import org.json.JSONObject;

final class MiniProgramLpReportDC04239$8
  implements Runnable
{
  MiniProgramLpReportDC04239$8(JSONObject paramJSONObject, MiniAppConfig paramMiniAppConfig) {}
  
  public void run()
  {
    Object localObject = this.val$jsonObject;
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optString("actiontype");
      String str1 = this.val$jsonObject.optString("sub_actiontype");
      String str2 = this.val$jsonObject.optString("reserves_action");
      MiniProgramLpReportDC04239.access$000(this.val$miniAppConfig, "1", null, (String)localObject, str1, str2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.8
 * JD-Core Version:    0.7.0.1
 */