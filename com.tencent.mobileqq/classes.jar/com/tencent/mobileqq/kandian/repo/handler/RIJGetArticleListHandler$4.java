package com.tencent.mobileqq.kandian.repo.handler;

import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import java.util.List;

class RIJGetArticleListHandler$4
  implements Runnable
{
  RIJGetArticleListHandler$4(RIJGetArticleListHandler paramRIJGetArticleListHandler, boolean paramBoolean, int paramInt, List paramList) {}
  
  public void run()
  {
    if (!this.a) {
      return;
    }
    this.this$0.a.i().b(this.b, this.c);
    List localList = RIJGetArticleListHandler.a(this.this$0, this.c);
    ReadInJoyLogicEngineEventDispatcher.a().c(this.b, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJGetArticleListHandler.4
 * JD-Core Version:    0.7.0.1
 */