package com.tencent.qqmini.sdk.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import beyo;
import java.util.Collection;
import java.util.Iterator;

public class MiniProgramReporter$6
  implements Runnable
{
  public MiniProgramReporter$6(beyo parambeyo, Collection paramCollection) {}
  
  public void run()
  {
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        APP_REPORT_TRANSFER.SingleDcData localSingleDcData = (APP_REPORT_TRANSFER.SingleDcData)localIterator.next();
        this.this$0.a(localSingleDcData);
      }
    }
    beyo.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramReporter.6
 * JD-Core Version:    0.7.0.1
 */