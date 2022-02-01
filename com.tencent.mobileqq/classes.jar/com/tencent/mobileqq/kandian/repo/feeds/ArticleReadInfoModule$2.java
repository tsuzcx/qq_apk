package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.kandian.repo.db.struct.ArticleReadInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class ArticleReadInfoModule$2
  implements Runnable
{
  ArticleReadInfoModule$2(ArticleReadInfoModule paramArticleReadInfoModule) {}
  
  public void run()
  {
    List localList = ArticleReadInfoModule.a(this.this$0).query(ArticleReadInfo.class, true, null, null, null, null, null, null);
    ArticleReadInfoModule.a(this.this$0, localList);
    ArticleReadInfoModule.b(this.this$0).set(true);
    QLog.d("ArticleReadInfoModule", 1, "article info read load from db finish");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ArticleReadInfoModule.2
 * JD-Core Version:    0.7.0.1
 */