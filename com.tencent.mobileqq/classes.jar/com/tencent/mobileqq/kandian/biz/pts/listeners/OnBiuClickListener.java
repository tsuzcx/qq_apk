package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
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
    if (RIJItemViewTypeUtils.E(paramAbsBaseArticleInfo)) {
      paramActivity.putExtra("biu_src", 2);
    }
    if (ReadInjoyFeedsUtils.a(paramAbsBaseArticleInfo)) {
      paramActivity.putExtra("arg_type", 4);
    }
    return paramActivity;
  }
  
  private void b()
  {
    Activity localActivity = (Activity)this.b;
    Intent localIntent = a(localActivity, this.a);
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
    if ((this.a != null) && (this.a.mSocialFeedInfo != null) && (this.a.mSocialFeedInfo.d()))
    {
      QQToast.makeText(BaseApplicationImpl.sApplication, 0, 2131915468, 0).show();
      return;
    }
    if (((this.b instanceof Activity)) && (this.a != null)) {
      RIJUserLevelModule.getInstance().doActionsByUserLevel(this.b, 2, new OnBiuClickListener.1(this));
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject = paramAbsBaseArticleInfo.mSocialFeedInfo;
    String str1;
    if (ReadinjoyReportUtils.d(paramAbsBaseArticleInfo.mChannelID)) {
      str1 = "0X8009361";
    } else {
      str1 = "0X8007EE4";
    }
    String str2 = RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo);
    long l1;
    long l2;
    if ((!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo)))
    {
      String str3 = paramAbsBaseArticleInfo.mSubscribeID;
      l1 = ((SocializeFeedsInfo)localObject).a;
      l2 = paramAbsBaseArticleInfo.mArticleID;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mStrategyId);
      PublicAccountReportUtils.a(null, str3, str1, str1, 0, 0, String.valueOf(l1), String.valueOf(l2), ((StringBuilder)localObject).toString(), str2, false);
      return;
    }
    if (!RIJItemViewTypeUtils.v(paramAbsBaseArticleInfo))
    {
      l1 = ((SocializeFeedsInfo)localObject).s.e;
      l2 = ((SocializeFeedsInfo)localObject).a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mStrategyId);
      PublicAccountReportUtils.a(null, String.valueOf(l1), str1, str1, 0, 0, String.valueOf(l2), "0", ((StringBuilder)localObject).toString(), str2, false);
    }
    if ((!RIJFeedsType.y(paramAbsBaseArticleInfo)) && (!RIJFeedsType.z(paramAbsBaseArticleInfo))) {
      RIJFrameworkReportManager.b(paramAbsBaseArticleInfo, (int)paramAbsBaseArticleInfo.mChannelID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnBiuClickListener
 * JD-Core Version:    0.7.0.1
 */