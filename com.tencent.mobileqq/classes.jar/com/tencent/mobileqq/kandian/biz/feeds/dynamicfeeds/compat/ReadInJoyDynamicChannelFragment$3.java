package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.compat;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.BannerInfoModule;

class ReadInJoyDynamicChannelFragment$3
  implements Runnable
{
  ReadInJoyDynamicChannelFragment$3(ReadInJoyDynamicChannelFragment paramReadInJoyDynamicChannelFragment) {}
  
  public void run()
  {
    BannerInfoModule localBannerInfoModule = ReadInJoyLogicEngine.a().a();
    if (localBannerInfoModule != null) {
      localBannerInfoModule.a(ReadInJoyDynamicChannelFragment.l(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.compat.ReadInJoyDynamicChannelFragment.3
 * JD-Core Version:    0.7.0.1
 */