package com.tencent.qqmini.sdk.report;

import android.os.Bundle;
import bgpn;
import bgyg;

public final class SDKMiniProgramLpReportDC04239$14
  implements Runnable
{
  public void run()
  {
    if (bgyg.a() != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("app_config", bgyg.a());
      localBundle.putLong("add_duration_ms", bgyg.a());
      bgpn.a().a("record_duration", localBundle, null);
      bgyg.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.14
 * JD-Core Version:    0.7.0.1
 */