package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.kandian.base.utils.TimeUtil;
import com.tencent.mobileqq.kandian.base.view.widget.text.ClickableSpanPressed;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.pts.component.CmpCtxt;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;

public class NativeSummaryView$ReadArticleSpan
  extends ClickableSpan
  implements ClickableSpanPressed
{
  boolean a;
  CmpCtxt b;
  AbsBaseArticleInfo c;
  Context d;
  private int e;
  private TextPaint f;
  
  private void a()
  {
    if (this.c != null)
    {
      int j = -1;
      CmpCtxt localCmpCtxt = this.b;
      int i = j;
      if (localCmpCtxt != null)
      {
        i = j;
        if (localCmpCtxt.a != null) {
          i = this.b.a.m();
        }
      }
      RIJFrameworkReportManager.a(this.c, i);
      return;
    }
    QLog.d("Q.readinjoy.ui", 1, "ComponentAccountSummary report click read article data, articleInfo is null!");
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    TimeUtil.b("fast_web_show_light_house_1");
    ReadInJoyLogicEngine.a().d().a(paramAbsBaseArticleInfo.mArticleContentUrl, String.valueOf(paramAbsBaseArticleInfo.innerUniqueID), paramAbsBaseArticleInfo.mSubscribeID, 1, null);
    a(paramAbsBaseArticleInfo, null);
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    RIJJumpUtils.a((Activity)this.d, paramAbsBaseArticleInfo);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    TextPaint localTextPaint = this.f;
    if (localTextPaint != null) {
      updateDrawState(localTextPaint);
    }
  }
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.c.mArticleContentUrl)) {
      if (RIJFeedsType.a(this.c.mArticleContentUrl, this.c.mChannelID, this.c)) {
        a(this.c);
      } else {
        ReadInJoyUtils.a(this.d, this.c.mArticleContentUrl);
      }
    }
    a();
    if ((RIJFeedsType.p(this.c)) || (RIJFeedsType.q(this.c)))
    {
      paramView = RIJFeedsType.k(this.c);
      String str1 = Long.toString(this.c.mFeedId);
      String str2 = Long.toString(this.c.mArticleID);
      String str3 = Integer.toString(this.c.mStrategyId);
      String str4 = this.c.innerUniqueID;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c.businessId);
      localStringBuilder.append("");
      PublicAccountReportUtils.a(null, paramView, "0X8008A62", "0X8008A62", 0, 0, str1, str2, str3, RIJTransMergeKanDianReport.a(str4, localStringBuilder.toString(), this.c), false);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    this.f = paramTextPaint;
    this.f.setColor(-14132075);
    paramTextPaint = this.f;
    int i;
    if (this.a) {
      i = this.e;
    } else {
      i = 16777215;
    }
    paramTextPaint.bgColor = i;
    this.f.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeSummaryView.ReadArticleSpan
 * JD-Core Version:    0.7.0.1
 */