package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.mobileqq.kandian.base.utils.CollectionUtils.IPredicate;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;

class ReadInJoyLogicEngine$4
  implements CollectionUtils.IPredicate<TabChannelCoverInfo>
{
  ReadInJoyLogicEngine$4(ReadInJoyLogicEngine paramReadInJoyLogicEngine) {}
  
  public boolean a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    return (paramTabChannelCoverInfo != null) && (paramTabChannelCoverInfo.reason != 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine.4
 * JD-Core Version:    0.7.0.1
 */