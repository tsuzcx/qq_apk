package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.kandian.repo.common.IFindRemovedEntity;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

class BannerInfoModule$1
  implements IFindRemovedEntity<TopBannerInfo>
{
  BannerInfoModule$1(BannerInfoModule paramBannerInfoModule) {}
  
  public Entity a(EntityManager paramEntityManager, TopBannerInfo paramTopBannerInfo)
  {
    if (paramEntityManager.tabbleIsExist(TopBannerInfo.class.getSimpleName()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramTopBannerInfo.mChannelId);
      return paramEntityManager.find(TopBannerInfo.class, "mChannelId = ?", new String[] { localStringBuilder.toString() });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.BannerInfoModule.1
 * JD-Core Version:    0.7.0.1
 */