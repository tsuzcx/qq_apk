package com.tencent.mobileqq.kandian.repo.feeds.preload;

import com.tencent.mobileqq.kandian.repo.feeds.IForeBackGroundCallback;
import com.tencent.qphone.base.util.QLog;

class FeedsPreloadManager$1
  implements IForeBackGroundCallback
{
  FeedsPreloadManager$1(FeedsPreloadManager paramFeedsPreloadManager) {}
  
  public void a()
  {
    if (!FeedsPreloadHelper.b())
    {
      QLog.d("FeedsPreloadManager", 1, "foreground, feeds preload.");
      this.a.a(false);
      return;
    }
    QLog.d("FeedsPreloadManager", 1, "lock screen enter foreground, no need to preload.");
  }
  
  public void ax_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.preload.FeedsPreloadManager.1
 * JD-Core Version:    0.7.0.1
 */