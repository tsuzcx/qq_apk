package com.tencent.mobileqq.kandian.repo.feeds.preload;

import com.tencent.qphone.base.util.QLog;

class FeedsPreloadManager$3
  implements Runnable
{
  FeedsPreloadManager$3(FeedsPreloadManager paramFeedsPreloadManager, boolean paramBoolean) {}
  
  public void run()
  {
    if (FeedsPreloadHelper.a(this.a))
    {
      boolean bool = false;
      try
      {
        FeedsPreloadManager.a(this.this$0);
      }
      catch (Exception localException)
      {
        QLog.d("FeedsPreloadManager", 1, "preloadFeedsImp exception, e = ", localException);
        bool = true;
      }
      FeedsPreloadDataReport.a(this.a, bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.preload.FeedsPreloadManager.3
 * JD-Core Version:    0.7.0.1
 */