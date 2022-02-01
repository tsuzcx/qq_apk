package com.tencent.tkd.topicsdk.adapter.publisharticle;

import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import com.tencent.tkd.topicsdk.framework.events.UserActionEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$reportPublishUserAction$1
  extends Lambda
  implements Function1<PublishArticleInfo, Unit>
{
  PublishArticlePage$reportPublishUserAction$1(PublishArticlePage paramPublishArticlePage, ReportEventKey paramReportEventKey, ReportEventPage paramReportEventPage, ReportEventElement paramReportEventElement)
  {
    super(1);
  }
  
  public final void invoke(@NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "it");
    DispatchManager.a.a((IEvent)new UserActionEvent(null, this.$eventId, this.$pageId, this.$elementId, PublishArticlePage.c(this.this$0), paramPublishArticleInfo, null, 65, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.reportPublishUserAction.1
 * JD-Core Version:    0.7.0.1
 */