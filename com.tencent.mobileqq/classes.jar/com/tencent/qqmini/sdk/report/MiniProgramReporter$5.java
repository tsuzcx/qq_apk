package com.tencent.qqmini.sdk.report;

import NS_MINI_REPORT.REPORT.SingleDcData;
import bdsr;
import java.util.Collection;
import java.util.Iterator;

public class MiniProgramReporter$5
  implements Runnable
{
  public MiniProgramReporter$5(bdsr parambdsr, Collection paramCollection) {}
  
  public void run()
  {
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        REPORT.SingleDcData localSingleDcData = (REPORT.SingleDcData)localIterator.next();
        this.this$0.a(localSingleDcData);
      }
    }
    bdsr.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramReporter.5
 * JD-Core Version:    0.7.0.1
 */