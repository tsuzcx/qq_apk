package com.tencent.tkd.topicsdk.adapter.publisharticle;

import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "show", "", "invoke", "com/tencent/tkd/topicsdk/adapter/publisharticle/PublishArticlePage$initSelectPopupController$1$2"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initSelectPopupController$$inlined$also$lambda$2
  extends Lambda
  implements Function1<Boolean, Unit>
{
  PublishArticlePage$initSelectPopupController$$inlined$also$lambda$2(PublishArticlePage paramPublishArticlePage)
  {
    super(1);
  }
  
  public final void invoke(boolean paramBoolean)
  {
    if (paramBoolean) {
      PublishArticlePage.a(this.this$0, ReportEventKey.EVENT_EXPOSURE, ReportEventPage.PAGE_PUBLISH, ReportEventElement.WIDGET_CREATE_TOPIC_POPUP);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.initSelectPopupController..inlined.also.lambda.2
 * JD-Core Version:    0.7.0.1
 */