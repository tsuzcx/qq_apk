package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo;
import java.util.List;

class ReadInJoyUgcSearchTopicFragment$1
  extends ReadInJoyObserver
{
  ReadInJoyUgcSearchTopicFragment$1(ReadInJoyUgcSearchTopicFragment paramReadInJoyUgcSearchTopicFragment) {}
  
  public void b(List<String> paramList, List<TopicInfo> paramList1)
  {
    ReadInJoyUgcSearchTopicFragment.a(this.a, paramList, paramList1);
    RIJDeliverUGCReportUtil.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyUgcSearchTopicFragment.1
 * JD-Core Version:    0.7.0.1
 */