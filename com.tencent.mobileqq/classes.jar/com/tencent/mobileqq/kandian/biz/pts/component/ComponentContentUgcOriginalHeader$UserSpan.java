package com.tencent.mobileqq.kandian.biz.pts.component;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.kandian.base.view.widget.text.ClickableSpanPressed;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.utils.Base64Util;

public class ComponentContentUgcOriginalHeader$UserSpan
  extends ClickableSpan
  implements ClickableSpanPressed
{
  protected long a;
  boolean b;
  private int d = -1;
  private TextPaint e;
  
  public ComponentContentUgcOriginalHeader$UserSpan(ComponentContentUgcOriginalHeader paramComponentContentUgcOriginalHeader, long paramLong, int paramInt)
  {
    this.a = paramLong;
    this.d = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    TextPaint localTextPaint = this.e;
    if (localTextPaint != null) {
      updateDrawState(localTextPaint);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = new StringBuilder();
    paramView.append(ReadInJoyConstants.h);
    paramView.append(Base64Util.encodeToString(String.valueOf(this.a).getBytes(), 2));
    paramView = paramView.toString();
    ReadInJoyUtils.a(this.c.getContext(), paramView);
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.c.b.a.k();
    com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.a = localAbsBaseArticleInfo;
    String str = RIJTransMergeKanDianReport.a("2", localAbsBaseArticleInfo, this.a);
    if (ReadinjoyReportUtils.d(this.c.b.a.m())) {
      paramView = "0X800935C";
    } else {
      paramView = "0X8007BA3";
    }
    long l1 = localAbsBaseArticleInfo.mSocialFeedInfo.s.e;
    long l2 = this.c.b.a.k().mFeedId;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(localAbsBaseArticleInfo.mStrategyId);
    PublicAccountReportUtils.a(null, String.valueOf(l1), paramView, paramView, 0, 0, String.valueOf(l2), "0", localStringBuilder.toString(), str, false);
    RIJFrameworkReportManager.b(this.c.b.a.k(), this.c.b.a.m());
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    this.e = paramTextPaint;
    this.e.setColor(Color.parseColor("#285c95"));
    paramTextPaint = this.e;
    int i;
    if (this.b) {
      i = this.d;
    } else {
      i = Color.parseColor("#F8F8F8");
    }
    paramTextPaint.bgColor = i;
    this.e.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentUgcOriginalHeader.UserSpan
 * JD-Core Version:    0.7.0.1
 */