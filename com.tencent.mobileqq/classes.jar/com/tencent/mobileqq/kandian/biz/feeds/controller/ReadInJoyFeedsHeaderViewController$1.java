package com.tencent.mobileqq.kandian.biz.feeds.controller;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import java.util.List;

class ReadInJoyFeedsHeaderViewController$1
  extends ReadInJoyObserver
{
  ReadInJoyFeedsHeaderViewController$1(ReadInJoyFeedsHeaderViewController paramReadInJoyFeedsHeaderViewController) {}
  
  public void b(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    if (paramBoolean)
    {
      ReadInJoyFeedsHeaderViewController localReadInJoyFeedsHeaderViewController = this.a;
      ReadInJoyFeedsHeaderViewController.a(localReadInJoyFeedsHeaderViewController, ReadInJoyFeedsHeaderViewController.a(localReadInJoyFeedsHeaderViewController, paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyFeedsHeaderViewController.1
 * JD-Core Version:    0.7.0.1
 */