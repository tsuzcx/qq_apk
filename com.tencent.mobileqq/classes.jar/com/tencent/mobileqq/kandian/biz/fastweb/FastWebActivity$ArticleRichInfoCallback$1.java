package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebShareUtils;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.FastWebShareInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$ArticleRichInfoCallback$1
  implements Runnable
{
  FastWebActivity$ArticleRichInfoCallback$1(FastWebActivity.ArticleRichInfoCallback paramArticleRichInfoCallback, boolean paramBoolean, FastWebShareInfo paramFastWebShareInfo, int paramInt, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityFastWebShareInfo != null))
    {
      FastWebShareUtils localFastWebShareUtils = FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a);
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a.a;
      int i = this.jdField_a_of_type_Int;
      FastWebActivity localFastWebActivity = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a;
      String str = this.jdField_a_of_type_JavaLangString;
      if (FastWebActivity.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a)) {
        localObject = "0X8008994";
      } else {
        localObject = "0X800898D";
      }
      localFastWebShareUtils.a(localAbsBaseArticleInfo, i, localFastWebActivity, str, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityFastWebShareInfo.a(this.jdField_a_of_type_Int), FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a), FastWebActivity.i(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a), FastWebActivity.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a));
      return;
    }
    QRUtils.a(1, 2131689486);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("shareJson get false ! action : ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    QLog.d("Q.readinjoy.fast_web", 2, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.ArticleRichInfoCallback.1
 * JD-Core Version:    0.7.0.1
 */