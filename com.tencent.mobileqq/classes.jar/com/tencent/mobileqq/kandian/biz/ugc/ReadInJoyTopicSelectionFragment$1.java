package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.ugc.databinding.ReadInJoyTopicListAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo;
import java.util.List;

class ReadInJoyTopicSelectionFragment$1
  extends ReadInJoyObserver
{
  ReadInJoyTopicSelectionFragment$1(ReadInJoyTopicSelectionFragment paramReadInJoyTopicSelectionFragment) {}
  
  public void b(List<String> paramList, List<TopicInfo> paramList1)
  {
    if (paramList.size() == 0)
    {
      ReadInJoyTopicSelectionFragment.a(this.a).clear();
      ReadInJoyTopicSelectionFragment.a(this.a).addAll(paramList1);
      this.a.a.clear();
      this.a.a.addAll(ReadInJoyTopicSelectionFragment.a(paramList1));
      ReadInJoyTopicSelectionFragment.a(this.a).notifyDataSetChanged();
      ReadInJoyUtils.a(ReadInJoyTopicSelectionFragment.a(this.a), ReadInJoyTopicSelectionFragment.a(this.a), "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyTopicSelectionFragment.1
 * JD-Core Version:    0.7.0.1
 */