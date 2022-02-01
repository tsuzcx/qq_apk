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
    if (((KanDianViewController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController$KandianViewControllerObserver.a) instanceof ReadInJoyListViewGroup)) && (KanDianViewController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController$KandianViewControllerObserver.a).a() == 0) && (((ReadInJoyListViewGroup)KanDianViewController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController$KandianViewControllerObserver.a)).a() != null) && (((ReadInJoyListViewGroup)KanDianViewController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController$KandianViewControllerObserver.a)).a().a() != null))
    {
      if (KanDianViewController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController$KandianViewControllerObserver.a, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList))
      {
        KanDianViewController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController$KandianViewControllerObserver.a, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsApiIInsertArticleCallback);
        KanDianViewController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerKanDianViewController$KandianViewControllerObserver.a, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      RIJFeedsDynamicInsertController.INSTANCE.updateAdReadStatus(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.KanDianViewController.KandianViewControllerObserver.1
 * JD-Core Version:    0.7.0.1
 */