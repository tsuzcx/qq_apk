package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

class RIJArticleInfoRepo$8
  implements Runnable
{
  RIJArticleInfoRepo$8(RIJArticleInfoRepo paramRIJArticleInfoRepo, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void run()
  {
    if (!RIJArticleInfoRepo.b(this.this$0).remove(this.a))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("delete article fail ! title : ");
      localStringBuilder.append(this.a.mTitle);
      localStringBuilder.append(" , articleID : ");
      localStringBuilder.append(this.a.mArticleID);
      QLog.d("RIJArticleInfoRepo", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo.8
 * JD-Core Version:    0.7.0.1
 */