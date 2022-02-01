package com.tencent.mobileqq.kandian.biz.pts.view;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInJoySocializeRecommendFollowView$1
  implements ViewBase.OnClickListener
{
  ReadInJoySocializeRecommendFollowView$1(ReadInJoySocializeRecommendFollowView paramReadInJoySocializeRecommendFollowView) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    ReadInJoySocializeRecommendFollowView.a(this.a, false);
    ReadInJoySocializeRecommendFollowView.a(this.a);
    paramViewBase = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
    localStringBuilder.append("");
    paramViewBase.publicAccountReportClickEvent(null, localStringBuilder.toString(), "0X800984B", "0X800984B", 0, 0, "1", "", "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoySocializeRecommendFollowView.1
 * JD-Core Version:    0.7.0.1
 */