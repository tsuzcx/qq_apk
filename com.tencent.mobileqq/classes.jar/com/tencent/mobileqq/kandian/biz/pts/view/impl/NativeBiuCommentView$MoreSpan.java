package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.kandian.base.view.widget.text.PressedSpan;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

public class NativeBiuCommentView$MoreSpan
  extends PressedSpan
{
  AbsBaseArticleInfo b;
  
  public NativeBiuCommentView$MoreSpan(NativeBiuCommentView paramNativeBiuCommentView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    super(paramInt, 13421772, 860716207);
    this.b = paramAbsBaseArticleInfo;
  }
  
  public void onClick(View paramView)
  {
    if (RIJItemViewTypeUtils.l(this.b))
    {
      RIJJumpUtils.a(this.c.getContext(), this.b, 0, false, 5, false);
      paramView = this.b;
      RIJFrameworkReportManager.b(paramView, (int)paramView.mChannelID);
      return;
    }
    if (RIJItemViewTypeUtils.h(this.b))
    {
      paramView = this.c.getContext();
      if ((paramView instanceof Activity)) {
        RIJJumpUtils.b(paramView, this.b, 6);
      }
      paramView = this.b;
      RIJFrameworkReportManager.b(paramView, (int)paramView.mChannelID);
      return;
    }
    RIJJumpUtils.a(this.c.getContext(), this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeBiuCommentView.MoreSpan
 * JD-Core Version:    0.7.0.1
 */