package com.tencent.qqmini.sdk.report;

import bgts;
import bhch;
import java.util.Iterator;
import java.util.List;

public final class SDKMiniProgramLpReportDC04239$13
  implements Runnable
{
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      bgts localbgts = (bgts)localIterator.next();
      if (localbgts != null) {
        localbgts.a();
      }
    }
    bhch.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.13
 * JD-Core Version:    0.7.0.1
 */