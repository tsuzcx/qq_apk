package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.kandian.repo.common.IFindRemovedEntity;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

class ChannelCoverInfoModule$1
  implements IFindRemovedEntity<TabChannelCoverInfo>
{
  ChannelCoverInfoModule$1(ChannelCoverInfoModule paramChannelCoverInfoModule) {}
  
  public Entity a(EntityManager paramEntityManager, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramEntityManager.tabbleIsExist(TabChannelCoverInfo.class.getSimpleName())) {
      return paramEntityManager.find(TabChannelCoverInfo.class, "mChannelCoverId = ?", new String[] { String.valueOf(paramTabChannelCoverInfo.mChannelCoverId) });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule.1
 * JD-Core Version:    0.7.0.1
 */