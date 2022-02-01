package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$addTopicButtonInSelectorLayout$1
  extends Lambda
  implements Function0<Unit>
{
  PublishArticlePage$addTopicButtonInSelectorLayout$1(PublishArticlePage paramPublishArticlePage)
  {
    super(0);
  }
  
  public final void invoke()
  {
    PublishArticlePage.d(this.this$0);
    PublishArticlePage.a(this.this$0, ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_PUBLISH, ReportEventElement.BUTTON_SELECT_TOPIC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.addTopicButtonInSelectorLayout.1
 * JD-Core Version:    0.7.0.1
 */