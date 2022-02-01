package com.tencent.mobileqq.kandian.biz.diandian;

import com.tencent.mobileqq.kandian.biz.reddot.OnEntryIconRefreshListener;
import com.tencent.qphone.base.util.QLog;

class RecommendFeedsDiandianEntranceManager$2
  implements Runnable
{
  RecommendFeedsDiandianEntranceManager$2(RecommendFeedsDiandianEntranceManager paramRecommendFeedsDiandianEntranceManager, OnEntryIconRefreshListener paramOnEntryIconRefreshListener) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleDianDianIconRefresh | refreshEntranceView curEntryInfo ");
    localStringBuilder.append(RecommendFeedsDiandianEntranceManager.access$100());
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, localStringBuilder.toString());
    this.a.a(RecommendFeedsDiandianEntranceManager.access$100());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.diandian.RecommendFeedsDiandianEntranceManager.2
 * JD-Core Version:    0.7.0.1
 */