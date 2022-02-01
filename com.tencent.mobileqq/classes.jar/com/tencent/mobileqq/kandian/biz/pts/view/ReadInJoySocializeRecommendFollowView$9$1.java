package com.tencent.mobileqq.kandian.biz.pts.view;

import android.widget.LinearLayout;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class ReadInJoySocializeRecommendFollowView$9$1
  implements Runnable
{
  ReadInJoySocializeRecommendFollowView$9$1(ReadInJoySocializeRecommendFollowView.9 param9) {}
  
  public void run()
  {
    ReadInJoySocializeRecommendFollowView.b(this.a.b).requestLayout();
    ReadInJoySocializeRecommendFollowView.a(this.a.b, true);
    if (!ReadInJoySocializeRecommendFollowView.g(this.a.b).mRecommendFollowInfos.i)
    {
      ReadInJoySocializeRecommendFollowView.g(this.a.b).mRecommendFollowInfos.i = true;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(RIJQQAppInterfaceUtil.c());
      localStringBuilder.append("");
      PublicAccountReportUtils.a(null, localStringBuilder.toString(), "0X8009847", "0X8009847", 0, 0, "1", "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoySocializeRecommendFollowView.9.1
 * JD-Core Version:    0.7.0.1
 */