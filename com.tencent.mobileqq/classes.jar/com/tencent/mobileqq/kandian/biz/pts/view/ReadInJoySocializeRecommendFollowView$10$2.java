package com.tencent.mobileqq.kandian.biz.pts.view;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;

class ReadInJoySocializeRecommendFollowView$10$2
  implements Runnable
{
  ReadInJoySocializeRecommendFollowView$10$2(ReadInJoySocializeRecommendFollowView.10 param10, AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateAfterAccountFollow articleInfo = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      ((StringBuilder)localObject).append(" isFollow = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, ((StringBuilder)localObject).toString());
    }
    long l = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.a.a;
    Object localObject = ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInJoySocializeRecommendFollowView$10.a);
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if ((localObject == localAbsBaseArticleInfo) && (this.jdField_a_of_type_Boolean) && (localAbsBaseArticleInfo.mChannelID == 70L)) {
      ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInJoySocializeRecommendFollowView$10.a, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoySocializeRecommendFollowView.10.2
 * JD-Core Version:    0.7.0.1
 */