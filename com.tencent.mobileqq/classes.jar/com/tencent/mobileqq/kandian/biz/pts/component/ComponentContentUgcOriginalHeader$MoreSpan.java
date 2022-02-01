package com.tencent.mobileqq.kandian.biz.pts.component;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.view.widget.text.ClickableSpanPressed;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

public class ComponentContentUgcOriginalHeader$MoreSpan
  extends ClickableSpan
  implements ClickableSpanPressed
{
  boolean a;
  AbsBaseArticleInfo b;
  private int d = -1;
  private TextPaint e;
  
  public ComponentContentUgcOriginalHeader$MoreSpan(ComponentContentUgcOriginalHeader paramComponentContentUgcOriginalHeader, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    this.b = paramAbsBaseArticleInfo;
    this.d = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    TextPaint localTextPaint = this.e;
    if (localTextPaint != null) {
      updateDrawState(localTextPaint);
    }
  }
  
  public void onClick(View paramView)
  {
    RIJJumpUtils.a(this.c.getContext(), this.b, 2, false, 6, false);
    RIJFrameworkReportManager.b(this.b, this.c.b.a.m());
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    this.e = paramTextPaint;
    this.e.setColor(Color.parseColor("#285c95"));
    paramTextPaint = this.e;
    int i;
    if (this.a) {
      i = this.d;
    } else {
      i = Color.parseColor("#F8F8F8");
    }
    paramTextPaint.bgColor = i;
    this.e.setTextSize(AIOUtils.a(2, 14, this.c.getResources()));
    this.e.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentUgcOriginalHeader.MoreSpan
 * JD-Core Version:    0.7.0.1
 */