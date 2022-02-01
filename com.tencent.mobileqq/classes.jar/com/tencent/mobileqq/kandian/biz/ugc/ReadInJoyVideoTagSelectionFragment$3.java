package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.handler.TagInfo;
import java.util.List;

class ReadInJoyVideoTagSelectionFragment$3
  extends ReadInJoyObserver
{
  ReadInJoyVideoTagSelectionFragment$3(ReadInJoyVideoTagSelectionFragment paramReadInJoyVideoTagSelectionFragment) {}
  
  public void c(List<TagInfo> paramList)
  {
    ReadInJoyVideoTagSelectionFragment.d(this.a).addAll(paramList);
    ReadInJoyLogicEngineEventDispatcher.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyVideoTagSelectionFragment.3
 * JD-Core Version:    0.7.0.1
 */