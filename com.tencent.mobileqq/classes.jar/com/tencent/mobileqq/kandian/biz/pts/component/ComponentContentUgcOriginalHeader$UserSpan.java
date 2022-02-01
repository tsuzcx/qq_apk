package com.tencent.mobileqq.kandian.biz.pts.component;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.kandian.base.view.widget.text.ClickableSpanPressed;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;

public class ComponentContentUgcOriginalHeader$UserSpan
  extends ClickableSpan
  implements ClickableSpanPressed
{
  private int jdField_a_of_type_Int = -1;
  protected long a;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  boolean jdField_a_of_type_Boolean;
  
  public ComponentContentUgcOriginalHeader$UserSpan(ComponentContentUgcOriginalHeader paramComponentContentUgcOriginalHeader, long paramLong, int paramInt)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    TextPaint localTextPaint = this.jdField_a_of_type_AndroidTextTextPaint;
    if (localTextPaint != null) {
      updateDrawState(localTextPaint);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = new StringBuilder();
    paramView.append(ReadInJoyConstants.g);
    paramView.append(Base64Util.encodeToString(String.valueOf(this.jdField_a_of_type_Long).getBytes(), 2));
    paramView = paramView.toString();
    ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcOriginalHeader.getContext(), paramView);
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcOriginalHeader.a.a.a();
    com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.a = localAbsBaseArticleInfo;
    String str = RIJTransMergeKanDianReport.a("2", localAbsBaseArticleInfo, this.jdField_a_of_type_Long);
    if (ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcOriginalHeader.a.a.c())) {
      paramView = "0X800935C";
    } else {
      paramView = "0X8007BA3";
    }
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    long l1 = localAbsBaseArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_Long;
    long l2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcOriginalHeader.a.a.a().mFeedId;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(localAbsBaseArticleInfo.mStrategyId);
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, String.valueOf(l1), paramView, paramView, 0, 0, String.valueOf(l2), "0", localStringBuilder.toString(), str, false);
    RIJFrameworkReportManager.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcOriginalHeader.a.a.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcOriginalHeader.a.a.c());
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    this.jdField_a_of_type_AndroidTextTextPaint = paramTextPaint;
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor("#285c95"));
    paramTextPaint = this.jdField_a_of_type_AndroidTextTextPaint;
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = this.jdField_a_of_type_Int;
    } else {
      i = Color.parseColor("#F8F8F8");
    }
    paramTextPaint.bgColor = i;
    this.jdField_a_of_type_AndroidTextTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentUgcOriginalHeader.UserSpan
 * JD-Core Version:    0.7.0.1
 */