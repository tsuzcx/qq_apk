package com.tencent.mobileqq.kandian.biz.pts.component;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.kandian.base.view.widget.text.ClickableSpanPressed;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

public class ComponentHeaderTopicRecommend$MoreSpan
  extends ClickableSpan
  implements ClickableSpanPressed
{
  boolean a;
  AbsBaseArticleInfo b;
  private int d = -1;
  private TextPaint e;
  
  public ComponentHeaderTopicRecommend$MoreSpan(ComponentHeaderTopicRecommend paramComponentHeaderTopicRecommend, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
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
    if (RIJItemViewTypeUtils.n(this.b))
    {
      RIJJumpUtils.a(this.c.getContext(), this.c.a.a.k(), 4, false, 7, false);
      RIJFrameworkReportManager.b(this.b, this.c.a.a.m());
      return;
    }
    if (!TextUtils.isEmpty(this.b.mArticleContentUrl)) {
      ReadInJoyUtils.a(this.c.getContext(), this.b.mArticleContentUrl);
    }
    paramView = RIJFeedsType.k(this.b);
    String str1 = Long.toString(this.b.mFeedId);
    String str2 = Long.toString(this.b.mArticleID);
    String str3 = Integer.toString(this.b.mStrategyId);
    String str4 = this.b.innerUniqueID;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.businessId);
    localStringBuilder.append("");
    PublicAccountReportUtils.a(null, paramView, "0X8008A62", "0X8008A62", 0, 0, str1, str2, str3, RIJTransMergeKanDianReport.a(str4, localStringBuilder.toString(), this.b), false);
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
      i = 16119285;
    }
    paramTextPaint.bgColor = i;
    this.e.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderTopicRecommend.MoreSpan
 * JD-Core Version:    0.7.0.1
 */