package com.tencent.mobileqq.kandian.biz.ugc.finishdialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.ugc.RIJDeliverUGCReportUtil;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class KanDianPublishFinishGuideDialog$onCreate$3
  implements View.OnClickListener
{
  KanDianPublishFinishGuideDialog$onCreate$3(KanDianPublishFinishGuideDialog paramKanDianPublishFinishGuideDialog, RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder) {}
  
  public final void onClick(View paramView)
  {
    RIJJumpUtils.c(this.a.getContext(), "https://viola.qq.com/js/columnMyVideo.js?_rij_violaUrl=1&v_tid=6&hideNav=1&v_nav_immer=1&v_bundleName=columnMyVideo&v_bid=3740");
    this.a.dismiss();
    this.b.addString("btn", "2");
    RIJDeliverUGCReportUtil.d(this.b.build());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.finishdialog.KanDianPublishFinishGuideDialog.onCreate.3
 * JD-Core Version:    0.7.0.1
 */