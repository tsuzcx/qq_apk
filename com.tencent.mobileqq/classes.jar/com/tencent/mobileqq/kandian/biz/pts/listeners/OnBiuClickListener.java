package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.pts.util.ReadInjoyFeedsUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.biu.BiuBehaviour;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class OnBiuClickListener
  extends OnSocialOperationListener
{
  public OnBiuClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext)
  {
    super(paramAbsBaseArticleInfo, paramContext);
  }
  
  public static Intent a(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramActivity = new Intent(paramActivity, ReadInJoyDeliverBiuActivity.class);
    paramActivity.putExtra("arg_article_info", paramAbsBaseArticleInfo);
    paramActivity.putExtra("feedsType", paramAbsBaseArticleInfo.mFeedType);
    if (paramAbsBaseArticleInfo.mChannelID == 70L)
    {
      paramActivity.putExtra("biu_src", 9);
      paramActivity.putExtra("arg_from_type", 14);
    }
    else
    {
      paramActivity.putExtra("biu_src", 1);
      paramActivity.putExtra("arg_from_type", 1);
    }
    if (RIJItemViewTypeUtils.B(paramAbsBaseArticleInfo)) {
      paramActivity.putExtra("biu_src", 2);
    }
    if (ReadInjoyFeedsUtils.a(paramAbsBaseArticleInfo)) {
      paramActivity.putExtra("arg_type", 4);
    }
    return paramActivity;
  }
  
  private void a()
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = a(localActivity, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    int i = BiuBehaviour.a();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    localIntent.putExtra("fast_biu_type", bool);
    localActivity.startActivity(localIntent);
    localActivity.overridePendingTransition(0, 0);
  }
  
  protected int a()
  {
    return 25;
  }
  
  protected void a(ViewBase paramViewBase)
  {
    QLog.d("OnBiuClickListener", 1, "click biu");
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.b()))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 0, 2131717988, 0).a();
      return;
    }
    if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)) {
      RIJUserLevelModule.getInstance().doActionsByUserLevel(this.jdField_a_of_type_AndroidContentContext, 2, new OnBiuClickListener.1(this));
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject = paramAbsBaseArticleInfo.mSocialFeedInfo;
    String str1;
    if (ReadinjoyReportUtils.a(paramAbsBaseArticleInfo.mChannelID)) {
      str1 = "0X8009361";
    } else {
      str1 = "0X8007EE4";
    }
    String str2 = RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo);
    IPublicAccountReportUtils localIPublicAccountReportUtils;
    long l1;
    long l2;
    if ((!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo)))
    {
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      String str3 = paramAbsBaseArticleInfo.mSubscribeID;
      l1 = ((SocializeFeedsInfo)localObject).jdField_a_of_type_Long;
      l2 = paramAbsBaseArticleInfo.mArticleID;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mStrategyId);
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str3, str1, str1, 0, 0, String.valueOf(l1), String.valueOf(l2), ((StringBuilder)localObject).toString(), str2, false);
      return;
    }
    if (!RIJItemViewTypeUtils.v(paramAbsBaseArticleInfo))
    {
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      l1 = ((SocializeFeedsInfo)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long;
      l2 = ((SocializeFeedsInfo)localObject).jdField_a_of_type_Long;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mStrategyId);
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, String.valueOf(l1), str1, str1, 0, 0, String.valueOf(l2), "0", ((StringBuilder)localObject).toString(), str2, false);
    }
    if ((!RIJFeedsType.s(paramAbsBaseArticleInfo)) && (!RIJFeedsType.t(paramAbsBaseArticleInfo))) {
      RIJFrameworkReportManager.b(paramAbsBaseArticleInfo, (int)paramAbsBaseArticleInfo.mChannelID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnBiuClickListener
 * JD-Core Version:    0.7.0.1
 */