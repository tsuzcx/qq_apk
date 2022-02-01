package com.tencent.mobileqq.kandian.biz.comment.guide;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.CommentGuideConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class GuidePopuppWindow$2$1
  implements ViewBase.OnClickListener
{
  GuidePopuppWindow$2$1(GuidePopuppWindow.2 param2) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    int i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
    if (i != 1096)
    {
      if (i != 1097) {
        return;
      }
      this.a.a.a(1);
      this.a.a.dismiss();
      return;
    }
    RIJJumpUtils.a(GuidePopuppWindow.c(this.a.a), GuidePopuppWindow.d(this.a.a), CommentGuideConfigHandler.a(GuidePopuppWindow.d(this.a.a).innerUniqueID));
    this.a.a.a(2);
    this.a.a.dismiss();
    paramViewBase = new RIJTransMergeKanDianReport.ReportR5Builder();
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = paramViewBase.addOS();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(CommentGuideConfigHandler.d());
    localReportR5Builder.addStringNotThrow("wording", localStringBuilder.toString());
    ReadInJoyCommentUtils.a("0X8009FE8", GuidePopuppWindow.d(this.a.a), paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.guide.GuidePopuppWindow.2.1
 * JD-Core Version:    0.7.0.1
 */