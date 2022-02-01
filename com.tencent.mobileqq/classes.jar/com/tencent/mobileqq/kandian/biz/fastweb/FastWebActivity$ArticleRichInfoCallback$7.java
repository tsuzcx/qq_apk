package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$ArticleRichInfoCallback$7
  implements Runnable
{
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a) != null) && (this.jdField_a_of_type_JavaLangString.equals(FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a).j)))
    {
      QLog.d("FastWebActivity", 2, "get related search words success! notify ui bindData");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleRelatedSearchWordsResp, msg not match !");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    QLog.d("FastWebActivity", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.ArticleRichInfoCallback.7
 * JD-Core Version:    0.7.0.1
 */