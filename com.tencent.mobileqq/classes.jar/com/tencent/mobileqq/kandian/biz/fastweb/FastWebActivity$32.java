package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebActivityStackUtil.PopPageListener;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebActivityStackUtil.SaveState;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$32
  implements FastWebActivityStackUtil.PopPageListener
{
  FastWebActivity$32(FastWebActivity paramFastWebActivity) {}
  
  public void a(FastWebActivityStackUtil.SaveState paramSaveState)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramSaveState.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    int i = FastWebActivity.f(this.a);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("articleInfo");
      localStringBuilder.append(localAbsBaseArticleInfo);
      QLog.i("FastWebActivity", 2, localStringBuilder.toString());
    }
    ReportUtil.a(localAbsBaseArticleInfo, FastWebActivity.g(this.a), i, paramSaveState.jdField_a_of_type_Boolean, this.a.b, FastWebActivity.h(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.32
 * JD-Core Version:    0.7.0.1
 */