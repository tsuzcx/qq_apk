package com.tencent.qqmini.sdk.report;

import bepi;
import bezf;
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
      bepi localbepi = (bepi)localIterator.next();
      if (localbepi != null) {
        localbepi.a();
      }
    }
    bezf.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.13
 * JD-Core Version:    0.7.0.1
 */