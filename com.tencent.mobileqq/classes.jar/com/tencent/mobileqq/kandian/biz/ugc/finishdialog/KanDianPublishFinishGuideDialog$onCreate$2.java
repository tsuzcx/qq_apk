package com.tencent.mobileqq.kandian.biz.ugc.finishdialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.ugc.RIJDeliverUGCReportUtil;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class KanDianPublishFinishGuideDialog$onCreate$2
  implements View.OnClickListener
{
  KanDianPublishFinishGuideDialog$onCreate$2(KanDianPublishFinishGuideDialog paramKanDianPublishFinishGuideDialog, RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder) {}
  
  public final void onClick(View paramView)
  {
    this.a.dismiss();
    this.b.addString("btn", "3");
    RIJDeliverUGCReportUtil.d(this.b.build());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.finishdialog.KanDianPublishFinishGuideDialog.onCreate.2
 * JD-Core Version:    0.7.0.1
 */