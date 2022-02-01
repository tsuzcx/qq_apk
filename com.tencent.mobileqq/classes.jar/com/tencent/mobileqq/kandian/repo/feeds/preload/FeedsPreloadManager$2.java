package com.tencent.mobileqq.kandian.repo.feeds.preload;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.ForeBackGround;
import com.tencent.qphone.base.util.QLog;

class FeedsPreloadManager$2
  implements Runnable
{
  FeedsPreloadManager$2(FeedsPreloadManager paramFeedsPreloadManager) {}
  
  public void run()
  {
    QLog.d("FeedsPreloadManager", 1, "add foreground, background callback.");
    ReadinjoySPEventReport.ForeBackGround.a(FeedsPreloadManager.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.preload.FeedsPreloadManager.2
 * JD-Core Version:    0.7.0.1
 */