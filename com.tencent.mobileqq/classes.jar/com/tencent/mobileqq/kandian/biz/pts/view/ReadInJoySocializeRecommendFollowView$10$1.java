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
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(" isFollow = ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, ((StringBuilder)localObject).toString());
    }
    if ((ReadInJoySocializeRecommendFollowView.g(this.c.a) != null) && (this.a == ReadInJoySocializeRecommendFollowView.g(this.c.a).mSocialFeedInfo.c.a) && (!this.b) && (ReadInJoySocializeRecommendFollowView.g(this.c.a).isShowRecommendList))
    {
      ReadInJoySocializeRecommendFollowView.a(this.c.a, false);
      ReadInJoySocializeRecommendFollowView.g(this.c.a).isShowRecommendList = false;
    }
    if ((ReadInJoySocializeRecommendFollowView.g(this.c.a) != null) && (ReadInJoySocializeRecommendFollowView.g(this.c.a).mRecommendFollowInfos != null) && (ReadInJoySocializeRecommendFollowView.g(this.c.a).mRecommendFollowInfos.c != null))
    {
      localObject = ReadInJoySocializeRecommendFollowView.g(this.c.a).mRecommendFollowInfos.c.iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)((Iterator)localObject).next();
        if (this.a == localRecommendFollowInfo.uin)
        {
          localRecommendFollowInfo.isFollowed = this.b;
          ReadInJoySocializeRecommendFollowView.a(this.c.a, localRecommendFollowInfo);
        }
      }
      ReadInJoySocializeRecommendFollowView.c(this.c.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoySocializeRecommendFollowView.10.1
 * JD-Core Version:    0.7.0.1
 */