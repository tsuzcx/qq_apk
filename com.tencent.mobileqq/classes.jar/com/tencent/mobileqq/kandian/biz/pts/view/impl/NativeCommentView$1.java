package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.view.View;
import com.tencent.mobileqq.kandian.base.view.widget.text.PressedSpan;
import com.tencent.mobileqq.kandian.biz.pts.component.CmpCtxt;
import com.tencent.mobileqq.kandian.biz.pts.util.PGCShortContentUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

class NativeCommentView$1
  extends PressedSpan
{
  NativeCommentView$1(NativeCommentView paramNativeCommentView, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  public void onClick(View paramView)
  {
    paramView = this.b.f.a.k();
    if (paramView.isPGCShortContent())
    {
      RIJFrameworkReportManager.a(this.b.getContext(), paramView, (int)paramView.mChannelID);
      PGCShortContentUtils.a(this.b.getContext(), paramView);
      return;
    }
    RIJJumpUtils.a(this.b.getContext(), this.b.f.a.k(), 1, false, 8, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeCommentView.1
 * JD-Core Version:    0.7.0.1
 */