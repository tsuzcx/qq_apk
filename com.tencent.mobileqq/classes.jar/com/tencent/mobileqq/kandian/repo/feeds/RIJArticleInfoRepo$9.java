package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.persistence.EntityManager;

class RIJArticleInfoRepo$9
  implements Runnable
{
  RIJArticleInfoRepo$9(RIJArticleInfoRepo paramRIJArticleInfoRepo, int paramInt) {}
  
  public void run()
  {
    EntityManager localEntityManager = RIJArticleInfoRepo.b(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DELETE FROM ArticleInfo WHERE mChannelID = ");
    localStringBuilder.append(this.a);
    localEntityManager.execSQL(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo.9
 * JD-Core Version:    0.7.0.1
 */