package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.kandian.repo.db.struct.ChannelTopCookie;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

class RIJArticleInfoRepo$2
  implements Runnable
{
  RIJArticleInfoRepo$2(RIJArticleInfoRepo paramRIJArticleInfoRepo) {}
  
  public void run()
  {
    List localList = RIJArticleInfoRepo.a(this.this$0).query(ChannelTopCookie.class, true, null, null, null, null, null, null);
    RIJArticleInfoRepo.a(this.this$0, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo.2
 * JD-Core Version:    0.7.0.1
 */