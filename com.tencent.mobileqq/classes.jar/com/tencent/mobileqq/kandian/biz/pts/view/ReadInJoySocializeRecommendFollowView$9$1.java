package com.tencent.mobileqq.kandian.biz.pts.view;

import android.widget.LinearLayout;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInJoySocializeRecommendFollowView$9$1
  implements Runnable
{
  ReadInJoySocializeRecommendFollowView$9$1(ReadInJoySocializeRecommendFollowView.9 param9) {}
  
  public void run()
  {
    ReadInJoySocializeRecommendFollowView.a(this.a.a).requestLayout();
    ReadInJoySocializeRecommendFollowView.a(this.a.a, true);
    if (!ReadInJoySocializeRecommendFollowView.a(this.a.a).mRecommendFollowInfos.b)
    {
      ReadInJoySocializeRecommendFollowView.a(this.a.a).mRecommendFollowInfos.b = true;
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
      localStringBuilder.append("");
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, localStringBuilder.toString(), "0X8009847", "0X8009847", 0, 0, "1", "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoySocializeRecommendFollowView.9.1
 * JD-Core Version:    0.7.0.1
 */