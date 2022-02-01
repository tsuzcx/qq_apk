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
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class NativeSummaryView$ReadArticleSpan
  extends ClickableSpan
  implements ClickableSpanPressed
{
  private int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  CmpCtxt jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
  AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  boolean jdField_a_of_type_Boolean;
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
    {
      int j = -1;
      CmpCtxt localCmpCtxt = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
      int i = j;
      if (localCmpCtxt != null)
      {
        i = j;
        if (localCmpCtxt.a != null) {
          i = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c();
        }
      }
      RIJFrameworkReportManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, i);
      return;
    }
    QLog.d("Q.readinjoy.ui", 1, "ComponentAccountSummary report click read article data, articleInfo is null!");
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    TimeUtil.b("fast_web_show_light_house_1");
    ReadInJoyLogicEngine.a().a().a(paramAbsBaseArticleInfo.mArticleContentUrl, String.valueOf(paramAbsBaseArticleInfo.innerUniqueID), paramAbsBaseArticleInfo.mSubscribeID, 1, null);
    a(paramAbsBaseArticleInfo, null);
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    RIJJumpUtils.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramAbsBaseArticleInfo);
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
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleContentUrl)) {
      if (RIJFeedsType.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleContentUrl, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelID, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) {
        a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      } else {
        ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleContentUrl);
      }
    }
    a();
    if ((RIJFeedsType.j(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) || (RIJFeedsType.k(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)))
    {
      paramView = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      String str1 = RIJFeedsType.c(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      String str2 = Long.toString(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId);
      String str3 = Long.toString(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID);
      String str4 = Integer.toString(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId);
      String str5 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.businessId);
      localStringBuilder.append("");
      paramView.publicAccountReportClickEvent(null, str1, "0X8008A62", "0X8008A62", 0, 0, str2, str3, str4, RIJTransMergeKanDianReport.a(str5, localStringBuilder.toString(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), false);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    this.jdField_a_of_type_AndroidTextTextPaint = paramTextPaint;
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-14132075);
    paramTextPaint = this.jdField_a_of_type_AndroidTextTextPaint;
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = this.jdField_a_of_type_Int;
    } else {
      i = 16777215;
    }
    paramTextPaint.bgColor = i;
    this.jdField_a_of_type_AndroidTextTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeSummaryView.ReadArticleSpan
 * JD-Core Version:    0.7.0.1
 */