package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.kandian.repo.common.IFindRemovedEntity;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

class ChannelInfoModule$1
  implements IFindRemovedEntity<ChannelInfo>
{
  ChannelInfoModule$1(ChannelInfoModule paramChannelInfoModule) {}
  
  public Entity a(EntityManager paramEntityManager, ChannelInfo paramChannelInfo)
  {
    if (paramEntityManager.tabbleIsExist(ChannelInfo.class.getSimpleName())) {
      return paramEntityManager.find(ChannelInfo.class, "mChannelID = ?", new String[] { String.valueOf(paramChannelInfo.mChannelID) });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ChannelInfoModule.1
 * JD-Core Version:    0.7.0.1
 */