package com.tencent.mobileqq.mini.report;

import NS_MINI_REPORT.REPORT.SingleDcData;
import java.util.Collection;
import java.util.Iterator;

class MiniProgramReporter$6
  implements Runnable
{
  MiniProgramReporter$6(MiniProgramReporter paramMiniProgramReporter, Collection paramCollection) {}
  
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
    MiniProgramReporter.access$400(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramReporter.6
 * JD-Core Version:    0.7.0.1
 */