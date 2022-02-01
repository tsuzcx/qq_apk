package com.tencent.tkd.topicsdk.publisharticle;

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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "publishArticleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initTitleBar$2$1
  extends Lambda
  implements Function1<PublishArticleInfo, Unit>
{
  PublishArticlePage$initTitleBar$2$1(PublishArticlePage.initTitleBar.2 param2)
  {
    super(1);
  }
  
  public final void invoke(@NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "publishArticleInfo");
    PublishArticlePage.a(this.this$0.a, paramPublishArticleInfo);
    DispatchManager.a.a((IEvent)new UserActionEvent(ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_PUBLISH, ReportEventElement.BUTTON_CONFIRM, PublishArticlePage.a(this.this$0.a), paramPublishArticleInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.initTitleBar.2.1
 * JD-Core Version:    0.7.0.1
 */