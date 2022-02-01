package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$ArticleRichInfoCallback$6
  implements Runnable
{
  FastWebActivity$ArticleRichInfoCallback$6(FastWebActivity.ArticleRichInfoCallback paramArticleRichInfoCallback, boolean paramBoolean) {}
  
  public void run()
  {
    if (FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a) == null) {
      return;
    }
    FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a).jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a).a(FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a).jdField_a_of_type_Boolean);
    FastWebActivity.e(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" handleLikeStateResp isliked : ");
    localStringBuilder.append(FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a).jdField_a_of_type_Boolean);
    QLog.d("FastWebActivity", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.ArticleRichInfoCallback.6
 * JD-Core Version:    0.7.0.1
 */