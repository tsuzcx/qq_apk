package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.kandian.base.view.widget.text.PressedSpan;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

public class NativeSummaryView$MoreSpan
  extends PressedSpan
{
  AbsBaseArticleInfo b;
  
  public NativeSummaryView$MoreSpan(NativeSummaryView paramNativeSummaryView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    super(-15504151, 13421772, 860716207);
    this.b = paramAbsBaseArticleInfo;
  }
  
  public void onClick(View paramView)
  {
    if ((RIJItemViewTypeUtils.h(this.b)) && ((this.c.getContext() instanceof Activity)))
    {
      RIJJumpUtils.b((Activity)this.c.getContext(), this.b);
      paramView = this.b;
      RIJFrameworkReportManager.b(paramView, (int)paramView.mChannelID);
      return;
    }
    int i;
    if (RIJItemViewTypeUtils.l(this.b)) {
      i = 2;
    } else {
      i = 3;
    }
    RIJJumpUtils.a(this.c.getContext(), this.b, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeSummaryView.MoreSpan
 * JD-Core Version:    0.7.0.1
 */