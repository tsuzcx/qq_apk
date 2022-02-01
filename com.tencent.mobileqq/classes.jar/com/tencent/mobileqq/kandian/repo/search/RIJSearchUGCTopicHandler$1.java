package com.tencent.mobileqq.kandian.repo.search;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class RIJSearchUGCTopicHandler$1
  implements Runnable
{
  RIJSearchUGCTopicHandler$1(RIJSearchUGCTopicHandler paramRIJSearchUGCTopicHandler, List paramList1, List paramList2) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTopicInfoListFetched: keywordList: ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" topicInfoList: ");
      localStringBuilder.append(this.b);
      QLog.d("RIJSearchUGCTopicHandler", 2, localStringBuilder.toString());
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.search.RIJSearchUGCTopicHandler.1
 * JD-Core Version:    0.7.0.1
 */