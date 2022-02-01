package com.tencent.mobileqq.kandian.biz.pts.listeners;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AccountProfileInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;

public class OnAccountCardClickListener
  implements ViewBase.OnClickListener
{
  AbsBaseArticleInfo a;
  
  public OnAccountCardClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.a = paramAbsBaseArticleInfo;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.a.mSocialFeedInfo.s.k.f;
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.a;
    RIJFrameworkReportManager.b(localAbsBaseArticleInfo, (int)localAbsBaseArticleInfo.mChannelID);
    ReadInJoyUtils.a(localBaseActivity, paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnAccountCardClickListener
 * JD-Core Version:    0.7.0.1
 */