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
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(" isFollow = ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, ((StringBuilder)localObject).toString());
    }
    long l = this.a.mSocialFeedInfo.c.a;
    Object localObject = ReadInJoySocializeRecommendFollowView.g(this.c.a);
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.a;
    if ((localObject == localAbsBaseArticleInfo) && (this.b) && (localAbsBaseArticleInfo.mChannelID == 70L)) {
      ReadInJoySocializeRecommendFollowView.a(this.c.a, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoySocializeRecommendFollowView.10.2
 * JD-Core Version:    0.7.0.1
 */