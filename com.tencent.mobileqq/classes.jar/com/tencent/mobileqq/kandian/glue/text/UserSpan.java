package com.tencent.mobileqq.kandian.glue.text;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.kandian.base.view.widget.text.PressedSpan;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.pts.component.CmpCtxt;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;

public class UserSpan
  extends PressedSpan
{
  private final long jdField_a_of_type_Long;
  private final AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private final String jdField_a_of_type_JavaLangString;
  
  public UserSpan(long paramLong, String paramString, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    super(-15504151, 13421772, 860716207);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public UserSpan(long paramLong, String paramString, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    super(paramInt, 13421772, 860716207);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(long paramLong, Context paramContext)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localObject1 != null)
    {
      if (((AbsBaseArticleInfo)localObject1).mSocialFeedInfo == null) {
        return;
      }
      QLog.d("UserSpan", 1, new Object[] { "openPersonUrl, uin = ", Long.valueOf(paramLong) });
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(ReadInJoyConstants.g);
      ((StringBuilder)localObject1).append(Base64Util.encodeToString(String.valueOf(paramLong).getBytes(), 2));
      ReadInJoyUtils.a(paramContext, ((StringBuilder)localObject1).toString());
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = (AbsBaseArticleInfo)localObject1;
      String str = RIJTransMergeKanDianReport.a(this.jdField_a_of_type_JavaLangString, (AbsBaseArticleInfo)localObject1, paramLong);
      if (ReadinjoyReportUtils.a(((AbsBaseArticleInfo)localObject1).mChannelID)) {
        paramContext = "0X800935C";
      } else {
        paramContext = "0X8007BA3";
      }
      IPublicAccountReportUtils localIPublicAccountReportUtils;
      long l;
      Object localObject2;
      if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "3"))
      {
        localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        paramLong = ((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
        l = ((AbsBaseArticleInfo)localObject1).mFeedId;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(((AbsBaseArticleInfo)localObject1).mStrategyId);
        localIPublicAccountReportUtils.publicAccountReportClickEvent(null, String.valueOf(paramLong), paramContext, paramContext, 0, 0, String.valueOf(l), "0", ((StringBuilder)localObject2).toString(), str, false);
        RIJFrameworkReportManager.b((AbsBaseArticleInfo)localObject1, (int)((AbsBaseArticleInfo)localObject1).mChannelID);
        return;
      }
      if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "5"))
      {
        if (CmpCtxt.a((AbsBaseArticleInfo)localObject1))
        {
          localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
          paramLong = ((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long;
          l = ((AbsBaseArticleInfo)localObject1).mFeedId;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(((AbsBaseArticleInfo)localObject1).mStrategyId);
          localIPublicAccountReportUtils.publicAccountReportClickEvent(null, String.valueOf(paramLong), paramContext, paramContext, 0, 0, String.valueOf(l), "0", ((StringBuilder)localObject2).toString(), str, false);
          RIJFrameworkReportManager.b((AbsBaseArticleInfo)localObject1, (int)((AbsBaseArticleInfo)localObject1).mChannelID);
          return;
        }
        localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        localObject2 = ((AbsBaseArticleInfo)localObject1).mSubscribeID;
        paramLong = ((AbsBaseArticleInfo)localObject1).mFeedId;
        l = ((AbsBaseArticleInfo)localObject1).mArticleID;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(((AbsBaseArticleInfo)localObject1).mStrategyId);
        localIPublicAccountReportUtils.publicAccountReportClickEvent(null, (String)localObject2, paramContext, paramContext, 0, 0, String.valueOf(paramLong), String.valueOf(l), localStringBuilder.toString(), str, false);
        return;
      }
      if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "2"))
      {
        localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        paramLong = ((AbsBaseArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
        l = ((AbsBaseArticleInfo)localObject1).mFeedId;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(((AbsBaseArticleInfo)localObject1).mStrategyId);
        localIPublicAccountReportUtils.publicAccountReportClickEvent(null, String.valueOf(paramLong), paramContext, paramContext, 0, 0, String.valueOf(l), "0", ((StringBuilder)localObject2).toString(), str, false);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    a(this.jdField_a_of_type_Long, paramView.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.text.UserSpan
 * JD-Core Version:    0.7.0.1
 */