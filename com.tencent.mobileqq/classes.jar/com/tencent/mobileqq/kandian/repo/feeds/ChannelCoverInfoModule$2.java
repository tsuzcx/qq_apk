package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.kandian.repo.common.IFindRemovedEntity;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

class ChannelCoverInfoModule$2
  implements IFindRemovedEntity<ChannelCoverInfo>
{
  ChannelCoverInfoModule$2(ChannelCoverInfoModule paramChannelCoverInfoModule) {}
  
  public Entity a(EntityManager paramEntityManager, ChannelCoverInfo paramChannelCoverInfo)
  {
    if (paramEntityManager.tabbleIsExist(ChannelCoverInfo.class.getSimpleName())) {
      return paramEntityManager.find(ChannelCoverInfo.class, "mChannelCoverId = ?", new String[] { String.valueOf(paramChannelCoverInfo.mChannelCoverId) });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule.2
 * JD-Core Version:    0.7.0.1
 */