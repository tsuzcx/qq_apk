package com.tencent.mobileqq.kandian.biz.feeds;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.BannerInfoModule;

class ReadInJoyProteusFamilyListViewGroup$4
  implements Runnable
{
  ReadInJoyProteusFamilyListViewGroup$4(ReadInJoyProteusFamilyListViewGroup paramReadInJoyProteusFamilyListViewGroup) {}
  
  public void run()
  {
    BannerInfoModule localBannerInfoModule = ReadInJoyLogicEngine.a().i();
    if (localBannerInfoModule != null) {
      localBannerInfoModule.b(ReadInJoyProteusFamilyListViewGroup.c(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyProteusFamilyListViewGroup.4
 * JD-Core Version:    0.7.0.1
 */