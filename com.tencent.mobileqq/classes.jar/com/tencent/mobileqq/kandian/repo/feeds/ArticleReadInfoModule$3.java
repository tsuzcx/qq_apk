package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.kandian.repo.db.struct.ArticleReadInfo;
import java.util.Iterator;
import java.util.List;

class ArticleReadInfoModule$3
  implements Runnable
{
  ArticleReadInfoModule$3(ArticleReadInfoModule paramArticleReadInfoModule, List paramList) {}
  
  public void run()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ArticleReadInfo localArticleReadInfo = (ArticleReadInfo)((Iterator)localObject).next();
        this.this$0.a(localArticleReadInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ArticleReadInfoModule.3
 * JD-Core Version:    0.7.0.1
 */