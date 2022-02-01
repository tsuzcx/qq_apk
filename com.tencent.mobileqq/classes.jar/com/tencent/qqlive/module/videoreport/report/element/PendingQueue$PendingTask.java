package com.tencent.qqlive.module.videoreport.report.element;

import java.util.ArrayList;
import java.util.List;

class PendingQueue$PendingTask
  implements Runnable
{
  final List<ExposureElementInfo> pendingExposureElementInfoRef = new ArrayList();
  
  private PendingQueue$PendingTask(PendingQueue paramPendingQueue) {}
  
  void add(ExposureElementInfo paramExposureElementInfo)
  {
    this.pendingExposureElementInfoRef.add(paramExposureElementInfo);
  }
  
  public void run()
  {
    int j = this.pendingExposureElementInfoRef.size();
    int i = 0;
    while (i < j)
    {
      ExposureElementInfo localExposureElementInfo = (ExposureElementInfo)this.pendingExposureElementInfoRef.get(i);
      if ((localExposureElementInfo != null) && (PendingQueue.access$100(this.this$0) != null)) {
        PendingQueue.access$100(this.this$0).onDequeue(localExposureElementInfo);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.PendingQueue.PendingTask
 * JD-Core Version:    0.7.0.1
 */