package com.tencent.mobileqq.mini.report;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;

final class MiniProgramLpReportDC04239$14
  implements Runnable
{
  public void run()
  {
    if (MiniProgramLpReportDC04239.access$400() != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("app_config", MiniProgramLpReportDC04239.access$400());
      localBundle.putLong("add_duration_ms", MiniProgramLpReportDC04239.access$500());
      QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "record_duration", localBundle);
      MiniProgramLpReportDC04239.access$600();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239.14
 * JD-Core Version:    0.7.0.1
 */