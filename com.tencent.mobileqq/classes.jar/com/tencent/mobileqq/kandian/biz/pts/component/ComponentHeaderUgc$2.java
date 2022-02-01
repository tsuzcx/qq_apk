package com.tencent.mobileqq.kandian.biz.pts.component;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

class ComponentHeaderUgc$2
  extends ClickableSpan
{
  ComponentHeaderUgc$2(ComponentHeaderUgc paramComponentHeaderUgc, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void onClick(View paramView)
  {
    RIJJumpUtils.a(this.b.getContext(), this.b.a.a.k(), 4, false, 7, false);
    RIJFrameworkReportManager.b(this.a, this.b.a.a.m());
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-14132075);
    paramTextPaint.setTextSize(AIOUtils.a(2, 14, this.b.getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderUgc.2
 * JD-Core Version:    0.7.0.1
 */