package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.concurrent.ExecutorService;

public abstract class RIJBaseArticleInfoHandler
{
  protected final Handler a;
  protected final AppInterface a;
  protected final ReadInJoyMSFService a;
  protected final ArticleInfoModule a;
  protected final EntityManager a;
  protected final ExecutorService a;
  
  public RIJBaseArticleInfoHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule = paramArticleInfoModule;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseMsfReadInJoyMSFService = paramReadInJoyMSFService;
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = paramExecutorService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJBaseArticleInfoHandler
 * JD-Core Version:    0.7.0.1
 */