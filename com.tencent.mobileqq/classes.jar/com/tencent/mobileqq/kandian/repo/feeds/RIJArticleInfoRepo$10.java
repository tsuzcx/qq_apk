package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

class RIJArticleInfoRepo$10
  implements Runnable
{
  RIJArticleInfoRepo$10(RIJArticleInfoRepo paramRIJArticleInfoRepo, String paramString) {}
  
  public void run()
  {
    boolean bool = RIJArticleInfoRepo.b(this.this$0).execSQL(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[clearChannelArticleInfoAndKeepCache] deleteRes = ");
    localStringBuilder.append(bool);
    localStringBuilder.append(", deleteSql = ");
    localStringBuilder.append(this.a);
    QLog.i("RIJArticleInfoRepo", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo.10
 * JD-Core Version:    0.7.0.1
 */