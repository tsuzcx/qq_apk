package com.tencent.mobileqq.kandian.biz.pts.view;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;

class ReadInJoySocializeRecommendFollowView$1
  implements ViewBase.OnClickListener
{
  ReadInJoySocializeRecommendFollowView$1(ReadInJoySocializeRecommendFollowView paramReadInJoySocializeRecommendFollowView) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    ReadInJoySocializeRecommendFollowView.a(this.a, false);
    ReadInJoySocializeRecommendFollowView.a(this.a);
    paramViewBase = new StringBuilder();
    paramViewBase.append(RIJQQAppInterfaceUtil.c());
    paramViewBase.append("");
    PublicAccountReportUtils.a(null, paramViewBase.toString(), "0X800984B", "0X800984B", 0, 0, "1", "", "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoySocializeRecommendFollowView.1
 * JD-Core Version:    0.7.0.1
 */