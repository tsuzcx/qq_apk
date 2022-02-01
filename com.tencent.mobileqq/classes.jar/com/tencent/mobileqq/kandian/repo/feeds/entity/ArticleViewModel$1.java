package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IArticleViewModelUtil;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.os.MqqHandler;

class ArticleViewModel$1
  implements Runnable
{
  public void run()
  {
    CharSequence localCharSequence = ((IArticleViewModelUtil)QRoute.api(IArticleViewModelUtil.class)).convertBiuTime(ArticleViewModel.a(this.this$0));
    ThreadManager.getUIHandler().post(new ArticleViewModel.1.1(this, localCharSequence));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleViewModel.1
 * JD-Core Version:    0.7.0.1
 */