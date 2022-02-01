package com.tencent.qqmini.sdk.report;

import NS_MINI_REPORT.REPORT.SingleDcData;
import java.util.Collection;
import java.util.Iterator;

class MiniProgramReporter$5
  implements Runnable
{
  MiniProgramReporter$5(MiniProgramReporter paramMiniProgramReporter, Collection paramCollection) {}
  
  public void run()
  {
    if (this.val$data != null)
    {
      Iterator localIterator = this.val$data.iterator();
      while (localIterator.hasNext())
      {
        REPORT.SingleDcData localSingleDcData = (REPORT.SingleDcData)localIterator.next();
        this.this$0.add(localSingleDcData);
      }
    }
    MiniProgramReporter.access$300(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramReporter.5
 * JD-Core Version:    0.7.0.1
 */