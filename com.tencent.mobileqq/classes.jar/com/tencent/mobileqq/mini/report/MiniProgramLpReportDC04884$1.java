package com.tencent.mobileqq.mini.report;

import NS_COMM.COMM.Entry;
import NS_MINI_REPORT.REPORT.SingleDcData;
import android.content.SharedPreferences;
import com.tencent.mobileqq.mini.util.StorageUtil;
import java.util.ArrayList;
import java.util.Arrays;

final class MiniProgramLpReportDC04884$1
  implements Runnable
{
  MiniProgramLpReportDC04884$1(String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Object localObject = StorageUtil.getPreference().getString("version", "1.13.0.00013");
    localObject = MiniProgramReportHelper.newSingleDcData(9, String.valueOf(6), new ArrayList(Arrays.asList(new COMM.Entry[] { MiniProgramReportHelper.newEntry("appid", this.val$appId), MiniProgramReportHelper.newEntry("miniapp_version", this.val$miniapp_version), MiniProgramReportHelper.newEntry("baselib_version", (String)localObject), MiniProgramReportHelper.newEntry("apiResult", this.val$jsonParams) })), null);
    MiniProgramReporter.getInstance().add((REPORT.SingleDcData)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04884.1
 * JD-Core Version:    0.7.0.1
 */