package com.tencent.mobileqq.flashshow.report.datong;

import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;

final class FSDaTongLoginReporter$1
  implements Runnable
{
  public void run()
  {
    Map localMap = new FSDTParamBuilder().a();
    localMap.put("ks_main_entrance", "qq_main_tab");
    localMap.put("ks_sub_entrance", "default");
    VideoReport.reportEvent("ks_login", localMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.report.datong.FSDaTongLoginReporter.1
 * JD-Core Version:    0.7.0.1
 */