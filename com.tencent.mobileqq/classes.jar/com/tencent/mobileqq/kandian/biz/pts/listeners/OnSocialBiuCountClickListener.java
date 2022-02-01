package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;

public class OnSocialBiuCountClickListener
  implements ViewBase.OnClickListener
{
  AbsBaseArticleInfo a;
  Context b;
  ReadInJoyBaseAdapter c;
  
  public OnSocialBiuCountClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.a = paramAbsBaseArticleInfo;
    this.b = paramContext;
    this.c = paramReadInJoyBaseAdapter;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if (RIJItemViewTypeUtils.a(this.a)) {
      RIJJumpUtils.a(this.b, this.a, 1, false, 0, 4);
    } else {
      RIJJumpUtils.a(this.b, this.a, 0, false, 0, 4);
    }
    GalleryReportedUtils.a(this.b, this.a, this.c);
    OnSocialOperationListener.a(this.a, "0X8009441", "0X8009444");
    if (this.a != null) {
      VideoReport.reportEvent("clck", new RIJDtParamBuilder().f("card").e(this.a.innerUniqueID).g(this.a.dtReportBackendInfo).b("list").a(Long.valueOf(this.a.mChannelID)).a("14").b(Integer.valueOf(this.a.dtReportContentType)).c("click_contentid").a().c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnSocialBiuCountClickListener
 * JD-Core Version:    0.7.0.1
 */