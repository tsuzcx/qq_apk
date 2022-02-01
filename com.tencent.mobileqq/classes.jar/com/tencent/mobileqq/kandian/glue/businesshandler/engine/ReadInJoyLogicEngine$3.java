package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.mobileqq.kandian.base.utils.CollectionUtils.IPredicate;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;

class ReadInJoyLogicEngine$3
  implements CollectionUtils.IPredicate<TabChannelCoverInfo>
{
  ReadInJoyLogicEngine$3(ReadInJoyLogicEngine paramReadInJoyLogicEngine, int paramInt) {}
  
  public boolean a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    return paramTabChannelCoverInfo.mChannelCoverId == this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine.3
 * JD-Core Version:    0.7.0.1
 */