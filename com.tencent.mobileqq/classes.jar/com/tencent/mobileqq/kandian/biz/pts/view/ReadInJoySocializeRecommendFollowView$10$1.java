package com.tencent.mobileqq.kandian.biz.pts.view;

import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class ReadInJoySocializeRecommendFollowView$10$1
  implements Runnable
{
  ReadInJoySocializeRecommendFollowView$10$1(ReadInJoySocializeRecommendFollowView.10 param10, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateAfterAccountFollow uin = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append(" isFollow = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, ((StringBuilder)localObject).toString());
    }
    if ((ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInJoySocializeRecommendFollowView$10.a) != null) && (this.jdField_a_of_type_Long == ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInJoySocializeRecommendFollowView$10.a).mSocialFeedInfo.a.jdField_a_of_type_Long) && (!this.jdField_a_of_type_Boolean) && (ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInJoySocializeRecommendFollowView$10.a).isShowRecommendList))
    {
      ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInJoySocializeRecommendFollowView$10.a, false);
      ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInJoySocializeRecommendFollowView$10.a).isShowRecommendList = false;
    }
    if ((ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInJoySocializeRecommendFollowView$10.a) != null) && (ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInJoySocializeRecommendFollowView$10.a).mRecommendFollowInfos != null) && (ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInJoySocializeRecommendFollowView$10.a).mRecommendFollowInfos.a != null))
    {
      localObject = ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInJoySocializeRecommendFollowView$10.a).mRecommendFollowInfos.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)((Iterator)localObject).next();
        if (this.jdField_a_of_type_Long == localRecommendFollowInfo.uin)
        {
          localRecommendFollowInfo.isFollowed = this.jdField_a_of_type_Boolean;
          ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInJoySocializeRecommendFollowView$10.a, localRecommendFollowInfo);
        }
      }
      ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInJoySocializeRecommendFollowView$10.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoySocializeRecommendFollowView.10.1
 * JD-Core Version:    0.7.0.1
 */