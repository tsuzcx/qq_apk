package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.view.View;
import com.tencent.mobileqq.kandian.base.view.widget.text.PressedSpan;
import com.tencent.mobileqq.kandian.biz.pts.component.CmpCtxt;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

class NativeCommentView$2
  extends PressedSpan
{
  NativeCommentView$2(NativeCommentView paramNativeCommentView, int paramInt1, int paramInt2, int paramInt3, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  public void onClick(View paramView)
  {
    RIJJumpUtils.a(this.c.getContext(), this.c.f.a.k(), 4, false, 7, false);
    RIJFrameworkReportManager.b(this.b, this.c.f.a.m());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeCommentView.2
 * JD-Core Version:    0.7.0.1
 */