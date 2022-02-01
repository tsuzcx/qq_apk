package com.tencent.mobileqq.data;

import com.tencent.mobileqq.activity.QZoneFeedsObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;

class FeedsManager$2$1
  implements Runnable
{
  FeedsManager$2$1(FeedsManager.2 param2) {}
  
  public void run()
  {
    if (!this.a.a.feedInfoCache.isEmpty()) {
      FeedsManager.access$200(this.a.a).notifyObservers(QZoneFeedsObserver.class, 10000, true, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.FeedsManager.2.1
 * JD-Core Version:    0.7.0.1
 */