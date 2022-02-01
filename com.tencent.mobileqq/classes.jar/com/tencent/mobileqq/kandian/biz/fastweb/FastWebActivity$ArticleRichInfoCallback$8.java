package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdService;
import com.tencent.mobileqq.kandian.biz.fastweb.event.ItemShowDispatcher;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ItemDatasListUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$ArticleRichInfoCallback$8
  implements Runnable
{
  FastWebActivity$ArticleRichInfoCallback$8(FastWebActivity.ArticleRichInfoCallback paramArticleRichInfoCallback, int paramInt, FastWebArticleInfo paramFastWebArticleInfo, String paramString) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("get article business success, busiFlag:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    QLog.d("FastWebActivity", 2, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
    int i = this.jdField_a_of_type_Int;
    ((FastWebArticleInfo)localObject).c = i;
    ((FastWebArticleInfo)localObject).p = this.jdField_a_of_type_JavaLangString;
    if ((i == 0) && (FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a) != null))
    {
      ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).removeInnerAd(FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a));
      localObject = ReadInJoyLogicEngine.a().a();
      if (localObject != null) {
        ((FastWebModule)localObject).a(FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a).j, FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a));
      }
      ItemDatasListUtils.a(FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a));
      FastWebActivity.e(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a);
      FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a).a(FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.ArticleRichInfoCallback.8
 * JD-Core Version:    0.7.0.1
 */