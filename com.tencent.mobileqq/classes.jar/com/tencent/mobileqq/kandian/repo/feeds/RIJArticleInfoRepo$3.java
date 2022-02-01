package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.kandian.repo.db.struct.ChannelTopCookie;
import java.util.Iterator;
import java.util.List;

class RIJArticleInfoRepo$3
  implements Runnable
{
  RIJArticleInfoRepo$3(RIJArticleInfoRepo paramRIJArticleInfoRepo, List paramList) {}
  
  public void run()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ChannelTopCookie localChannelTopCookie = (ChannelTopCookie)((Iterator)localObject).next();
        RIJArticleInfoRepo.a(this.this$0, localChannelTopCookie);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo.3
 * JD-Core Version:    0.7.0.1
 */