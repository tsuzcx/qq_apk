package com.tencent.mobileqq.kandian.biz.diandian;

import com.tencent.mobileqq.kandian.biz.reddot.OnEntryIconRefreshListener;
import com.tencent.qphone.base.util.QLog;

class RecommendFeedsDiandianEntranceManager$3
  implements Runnable
{
  RecommendFeedsDiandianEntranceManager$3(RecommendFeedsDiandianEntranceManager paramRecommendFeedsDiandianEntranceManager, OnEntryIconRefreshListener paramOnEntryIconRefreshListener) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAccountChange | refreshEntranceView curEntryInfo ");
    localStringBuilder.append(RecommendFeedsDiandianEntranceManager.access$100());
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, localStringBuilder.toString());
    this.a.b(RecommendFeedsDiandianEntranceManager.access$100());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.diandian.RecommendFeedsDiandianEntranceManager.3
 * JD-Core Version:    0.7.0.1
 */