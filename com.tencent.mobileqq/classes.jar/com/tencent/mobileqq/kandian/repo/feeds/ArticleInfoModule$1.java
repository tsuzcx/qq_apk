package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.kandian.repo.common.IFindRemovedEntity;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

class ArticleInfoModule$1
  implements IFindRemovedEntity<AbsBaseArticleInfo>
{
  ArticleInfoModule$1(ArticleInfoModule paramArticleInfoModule) {}
  
  public Entity a(EntityManager paramEntityManager, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool = paramEntityManager.tabbleIsExist(BaseArticleInfo.class.getSimpleName());
    Object localObject2 = null;
    Object localObject1 = null;
    if (bool)
    {
      if (paramAbsBaseArticleInfo.mChannelID != 70L) {
        localObject1 = paramEntityManager.find(BaseArticleInfo.class, "mArticleID = ? and mChannelID = ?", new String[] { String.valueOf(paramAbsBaseArticleInfo.mArticleID), String.valueOf(paramAbsBaseArticleInfo.mChannelID) });
      }
      localObject2 = paramEntityManager.find(BaseArticleInfo.class, "mRecommendSeq = ? and mChannelID = ?", new String[] { String.valueOf(paramAbsBaseArticleInfo.mRecommendSeq), String.valueOf(paramAbsBaseArticleInfo.mChannelID) });
      if (localObject1 == null) {
        localObject1 = localObject2;
      }
      if ((QLog.isColorLevel()) && (localObject1 != null))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("removeEntityIfExistsInDB, article duplicated, article been channelID=");
        ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mChannelID);
        ((StringBuilder)localObject2).append("articleID=");
        ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mArticleID);
        ((StringBuilder)localObject2).append("recommendSeq=");
        ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mRecommendSeq);
        QLog.e("ArticleInfoModule", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = localObject1;
      if (paramAbsBaseArticleInfo.mChannelID == 70L)
      {
        localObject2 = localObject1;
        if (paramAbsBaseArticleInfo.mFeedId != 0L)
        {
          paramAbsBaseArticleInfo = paramEntityManager.find(BaseArticleInfo.class, "mFeedId = ? and mChannelID = ?", new String[] { String.valueOf(paramAbsBaseArticleInfo.mFeedId), String.valueOf(paramAbsBaseArticleInfo.mChannelID) });
          localObject2 = localObject1;
          if (paramAbsBaseArticleInfo != null)
          {
            paramEntityManager.remove(paramAbsBaseArticleInfo);
            localObject2 = localObject1;
          }
        }
      }
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule.1
 * JD-Core Version:    0.7.0.1
 */