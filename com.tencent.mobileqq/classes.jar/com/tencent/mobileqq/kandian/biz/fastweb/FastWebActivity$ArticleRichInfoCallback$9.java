package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSDataConverter;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ItemDatasListUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class FastWebActivity$ArticleRichInfoCallback$9
  implements Runnable
{
  FastWebActivity$ArticleRichInfoCallback$9(FastWebActivity.ArticleRichInfoCallback paramArticleRichInfoCallback, String paramString, FastWebArticleInfo paramFastWebArticleInfo) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[handleTopicTag], rowKey = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    QLog.i("FastWebActivity", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
    if ((localObject != null) && (((FastWebArticleInfo)localObject).b != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.b.size() > 0))
    {
      if (!ReadInJoyHelper.f())
      {
        QLog.i("FastWebActivity", 1, "[handleTopicTag] topic switch is off.");
        return;
      }
      localObject = FastWebPTSDataConverter.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a.jdField_a_of_type_AndroidUtilSparseArray);
      if ((FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a) != null) && (localObject != null))
      {
        ItemDatasListUtils.d(FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a));
        ItemDatasListUtils.a(FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a), (BaseData)localObject);
        FastWebActivity.e(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity$ArticleRichInfoCallback.a);
      }
      return;
    }
    QLog.i("FastWebActivity", 1, "[handleTopicTag] topicTagList is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.ArticleRichInfoCallback.9
 * JD-Core Version:    0.7.0.1
 */