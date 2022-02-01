package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.kandian.repo.common.IFindRemovedEntity;
import com.tencent.mobileqq.kandian.repo.db.struct.ArticleReadInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

class ArticleReadInfoModule$1
  implements IFindRemovedEntity<ArticleReadInfo>
{
  ArticleReadInfoModule$1(ArticleReadInfoModule paramArticleReadInfoModule) {}
  
  public Entity a(EntityManager paramEntityManager, ArticleReadInfo paramArticleReadInfo)
  {
    if (paramEntityManager.tabbleIsExist("ArticleInfo")) {
      return paramEntityManager.find(ArticleReadInfo.class, "mArticleID = ?", new String[] { String.valueOf(paramArticleReadInfo.mArticleID) });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ArticleReadInfoModule.1
 * JD-Core Version:    0.7.0.1
 */