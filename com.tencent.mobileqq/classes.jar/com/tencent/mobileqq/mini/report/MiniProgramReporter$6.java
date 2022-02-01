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
    Object localObject = this.val$data;
    if (localObject != null)
    {
      localObject = ((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        REPORT.SingleDcData localSingleDcData = (REPORT.SingleDcData)((Iterator)localObject).next();
        this.this$0.add(localSingleDcData);
      }
    }
    MiniProgramReporter.access$400(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramReporter.6
 * JD-Core Version:    0.7.0.1
 */