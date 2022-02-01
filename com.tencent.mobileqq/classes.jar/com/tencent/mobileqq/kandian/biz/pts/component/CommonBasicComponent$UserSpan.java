package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
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
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;

public class CommonBasicComponent$UserSpan
  extends ClickableSpan
  implements ClickableSpanPressed
{
  private int jdField_a_of_type_Int = -1;
  protected long a;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private CmpCtxt jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
  boolean jdField_a_of_type_Boolean;
  
  public CommonBasicComponent$UserSpan(long paramLong, int paramInt, CmpCtxt paramCmpCtxt)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt = paramCmpCtxt;
  }
  
  private void a(long paramLong, Context paramContext)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo == null) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ReadInJoyConstants.g);
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
      com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.a = (AbsBaseArticleInfo)localObject;
      String str = RIJTransMergeKanDianReport.a("3", (AbsBaseArticleInfo)localObject, paramLong);
      if (ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c())) {
        paramContext = "0X800935C";
      } else {
        paramContext = "0X8007BA3";
      }
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      paramLong = ((AbsBaseArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
      long l = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mFeedId;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(((AbsBaseArticleInfo)localObject).mStrategyId);
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, String.valueOf(paramLong), paramContext, paramContext, 0, 0, String.valueOf(l), "0", localStringBuilder.toString(), str, false);
      RIJFrameworkReportManager.b((AbsBaseArticleInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c());
    }
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
    if (paramView != null) {
      a(this.jdField_a_of_type_Long, paramView.getContext());
    }
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
      i = -1;
    }
    paramTextPaint.bgColor = i;
    this.jdField_a_of_type_AndroidTextTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.CommonBasicComponent.UserSpan
 * JD-Core Version:    0.7.0.1
 */