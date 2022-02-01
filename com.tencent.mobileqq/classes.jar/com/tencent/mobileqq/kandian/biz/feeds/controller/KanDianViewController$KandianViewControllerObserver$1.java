package com.tencent.mobileqq.kandian.biz.feeds.controller;

import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListViewGroup;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup;
import com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyArticleAdapter;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.repo.feeds.api.IInsertArticleCallback;
import java.util.List;

class KanDianViewController$KandianViewControllerObserver$1
  implements Runnable
{
  KanDianViewController$KandianViewControllerObserver$1(KanDianViewController.KandianViewControllerObserver paramKandianViewControllerObserver, String paramString, List paramList, IInsertArticleCallback paramIInsertArticleCallback, int paramInt) {}
  
  public void run()
  {
    if (((KanDianViewController.b(this.e.a) instanceof ReadInJoyListViewGroup)) && (KanDianViewController.b(this.e.a).getChannelID() == 0) && (((ReadInJoyListViewGroup)KanDianViewController.b(this.e.a)).getAdapter() != null) && (((ReadInJoyListViewGroup)KanDianViewController.b(this.e.a)).getAdapter().E() != null))
    {
      if (KanDianViewController.a(this.e.a, this.a, this.b))
      {
        KanDianViewController.a(this.e.a, this.c);
        KanDianViewController.a(this.e.a, this.d, this.a);
      }
      RIJFeedsDynamicInsertController.INSTANCE.updateAdReadStatus(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.KanDianViewController.KandianViewControllerObserver.1
 * JD-Core Version:    0.7.0.1
 */