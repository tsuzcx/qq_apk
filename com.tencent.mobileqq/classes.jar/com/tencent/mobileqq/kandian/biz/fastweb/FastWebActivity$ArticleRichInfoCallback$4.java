package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$ArticleRichInfoCallback$4
  implements Runnable
{
  FastWebActivity$ArticleRichInfoCallback$4(FastWebActivity.ArticleRichInfoCallback paramArticleRichInfoCallback, int paramInt) {}
  
  public void run()
  {
    if (FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a) == null) {
      return;
    }
    FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a).a(FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a).jdField_a_of_type_Int);
    FastWebActivity.e(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" handleLikeCntInfoResp likeCnt : ");
    localStringBuilder.append(FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a).jdField_a_of_type_Int);
    QLog.d("FastWebActivity", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.ArticleRichInfoCallback.4
 * JD-Core Version:    0.7.0.1
 */