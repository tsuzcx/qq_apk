package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
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
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;

public class CommonBasicComponent$UserSpan
  extends ClickableSpan
  implements ClickableSpanPressed
{
  protected long a;
  boolean b;
  private int c = -1;
  private TextPaint d;
  private CmpCtxt e;
  
  public CommonBasicComponent$UserSpan(long paramLong, int paramInt, CmpCtxt paramCmpCtxt)
  {
    this.a = paramLong;
    this.c = paramInt;
    this.e = paramCmpCtxt;
  }
  
  private void a(long paramLong, Context paramContext)
  {
    if ((this.e.a != null) && (this.e.a.k() != null) && (this.e.a.k().mSocialFeedInfo != null))
    {
      if (this.e.a.k().mSocialFeedInfo.s == null) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ReadInJoyConstants.h);
      ((StringBuilder)localObject).append(Base64Util.encodeToString(String.valueOf(paramLong).getBytes(), 2));
      localObject = ((StringBuilder)localObject).toString();
      ReadInJoyUtils.a(paramContext, (String)localObject);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("personal url =");
        paramContext.append((String)localObject);
        QLog.d("CommonBasicComponent", 2, paramContext.toString());
      }
      localObject = this.e.a.k();
      com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.a = (AbsBaseArticleInfo)localObject;
      String str = RIJTransMergeKanDianReport.a("3", (AbsBaseArticleInfo)localObject, paramLong);
      if (ReadinjoyReportUtils.d(this.e.a.m())) {
        paramContext = "0X800935C";
      } else {
        paramContext = "0X8007BA3";
      }
      paramLong = ((AbsBaseArticleInfo)localObject).mSocialFeedInfo.c.a;
      long l = this.e.a.k().mFeedId;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(((AbsBaseArticleInfo)localObject).mStrategyId);
      PublicAccountReportUtils.a(null, String.valueOf(paramLong), paramContext, paramContext, 0, 0, String.valueOf(l), "0", localStringBuilder.toString(), str, false);
      RIJFrameworkReportManager.b((AbsBaseArticleInfo)localObject, this.e.a.m());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    TextPaint localTextPaint = this.d;
    if (localTextPaint != null) {
      updateDrawState(localTextPaint);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {
      a(this.a, paramView.getContext());
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    this.d = paramTextPaint;
    this.d.setColor(Color.parseColor("#285c95"));
    paramTextPaint = this.d;
    int i;
    if (this.b) {
      i = this.c;
    } else {
      i = -1;
    }
    paramTextPaint.bgColor = i;
    this.d.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.CommonBasicComponent.UserSpan
 * JD-Core Version:    0.7.0.1
 */