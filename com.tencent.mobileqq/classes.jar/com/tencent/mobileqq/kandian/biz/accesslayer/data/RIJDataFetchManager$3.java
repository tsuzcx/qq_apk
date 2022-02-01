package com.tencent.mobileqq.kandian.biz.accesslayer.data;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.BannerInfoModule;

final class RIJDataFetchManager$3
  implements Runnable
{
  RIJDataFetchManager$3(int paramInt) {}
  
  public void run()
  {
    BannerInfoModule localBannerInfoModule = ReadInJoyLogicEngine.a().i();
    if (localBannerInfoModule != null) {
      localBannerInfoModule.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager.3
 * JD-Core Version:    0.7.0.1
 */