package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.pts.util.PGCShortContentUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qqlive.module.videoreport.VideoReport;

public class OnSocialHeaderClickListener
  implements ViewBase.OnClickListener
{
  private AbsBaseArticleInfo a;
  private Context b;
  
  public OnSocialHeaderClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext)
  {
    this.a = paramAbsBaseArticleInfo;
    this.b = paramContext;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    int i = RIJBaseItemViewType.c(this.a);
    paramViewBase = this.a;
    if ((paramViewBase != null) && (this.b != null) && (i != 76) && (i != 78) && (i != 77))
    {
      if (RIJItemViewTypeUtils.E(paramViewBase)) {
        return;
      }
      if (this.a.isPGCShortContent())
      {
        paramViewBase = this.a;
        paramViewBase.clickArea = 6;
        PGCShortContentUtils.a(this.b, paramViewBase);
        paramViewBase = this.b;
        AbsBaseArticleInfo localAbsBaseArticleInfo = this.a;
        RIJFrameworkReportManager.a(paramViewBase, localAbsBaseArticleInfo, (int)localAbsBaseArticleInfo.mChannelID);
      }
      else if (this.a.mFeedType == 36)
      {
        RIJJumpUtils.b(this.b, this.a, 6);
      }
      else if (RIJItemViewTypeUtils.j(this.a))
      {
        paramViewBase = new StringBuilder();
        paramViewBase.append(ReadInJoyConstants.l);
        paramViewBase.append(Base64Util.encodeToString(String.valueOf(this.a.mSubscribeID).getBytes(), 2));
        paramViewBase = paramViewBase.toString();
        ReadInJoyUtils.a(this.b, paramViewBase);
      }
      else
      {
        RIJJumpUtils.a(this.b, this.a, false);
      }
      VideoReport.reportEvent("clck", new RIJDtParamBuilder().f("card").e(this.a.innerUniqueID).g(this.a.dtReportBackendInfo).b("list").a(Long.valueOf(this.a.mChannelID)).a("14").b(Integer.valueOf(this.a.dtReportContentType)).c("click_contentid").a().c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnSocialHeaderClickListener
 * JD-Core Version:    0.7.0.1
 */