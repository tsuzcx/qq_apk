package com.tencent.mobileqq.mini.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import java.util.ArrayList;
import java.util.List;

final class MiniProgramLpReportDC04239$15
  implements Runnable
{
  MiniProgramLpReportDC04239$15(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, MiniAppConfig paramMiniAppConfig) {}
  
  public void run()
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(MiniProgramReportHelper.newUserInfoEntries());
    ((List)localObject).addAll(MiniProgramReportHelper.newQQqunInfoBusinessEntries(this.val$actionType, this.val$subActionType, this.val$reserves, this.val$reserves2, this.val$groupid));
    ((List)localObject).addAll(MiniProgramReportHelper.newGenericEntries());
    ((List)localObject).addAll(MiniProgramReportHelper.newVersionEntries(this.val$miniAppConfig));
    localObject = MiniProgramReportHelper.newSingleReportData(2, (List)localObject, null);
    MiniProgramReporter.getInstance().addData((APP_REPORT_TRANSFER.SingleDcData)localObject);
    MiniProgramReporter.getInstance().flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.15
 * JD-Core Version:    0.7.0.1
 */