package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.concurrent.ExecutorService;

public abstract class RIJBaseArticleInfoHandler
{
  protected final ArticleInfoModule a;
  protected final Handler b;
  protected final AppInterface c;
  protected final EntityManager d;
  protected final ReadInJoyMSFService e;
  protected final ExecutorService f;
  
  public RIJBaseArticleInfoHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    this.a = paramArticleInfoModule;
    this.b = paramHandler;
    this.c = paramAppInterface;
    this.d = paramEntityManager;
    this.e = paramReadInJoyMSFService;
    this.f = paramExecutorService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJBaseArticleInfoHandler
 * JD-Core Version:    0.7.0.1
 */