package com.tencent.tkd.topicsdk.framework.eventdispatch.report;

import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/BaseReportEvent;", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/IEvent;", "()V", "business", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventBusiness;", "getBusiness", "()Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventBusiness;", "setBusiness", "(Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventBusiness;)V", "element", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventElement;", "getElement", "()Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventElement;", "setElement", "(Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventElement;)V", "eventKey", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventKey;", "getEventKey", "()Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventKey;", "setEventKey", "(Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventKey;)V", "pageId", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventPage;", "getPageId", "()Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventPage;", "setPageId", "(Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventPage;)V", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
public class BaseReportEvent
  implements IEvent
{
  @NotNull
  private ReportEventBusiness a = ReportEventBusiness.BUSINESS_PUBLISHER;
  @NotNull
  private ReportEventKey b = ReportEventKey.EVENT_INVALID;
  @NotNull
  private ReportEventPage c = ReportEventPage.PAGE_INVALID;
  @NotNull
  private ReportEventElement d = ReportEventElement.ELEMENT_INVALID;
  
  @NotNull
  public final ReportEventKey a()
  {
    return this.b;
  }
  
  public final void a(@NotNull ReportEventBusiness paramReportEventBusiness)
  {
    Intrinsics.checkParameterIsNotNull(paramReportEventBusiness, "<set-?>");
    this.a = paramReportEventBusiness;
  }
  
  public final void a(@NotNull ReportEventElement paramReportEventElement)
  {
    Intrinsics.checkParameterIsNotNull(paramReportEventElement, "<set-?>");
    this.d = paramReportEventElement;
  }
  
  public final void a(@NotNull ReportEventKey paramReportEventKey)
  {
    Intrinsics.checkParameterIsNotNull(paramReportEventKey, "<set-?>");
    this.b = paramReportEventKey;
  }
  
  public final void a(@NotNull ReportEventPage paramReportEventPage)
  {
    Intrinsics.checkParameterIsNotNull(paramReportEventPage, "<set-?>");
    this.c = paramReportEventPage;
  }
  
  @NotNull
  public final ReportEventPage b()
  {
    return this.c;
  }
  
  @NotNull
  public final ReportEventElement c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.eventdispatch.report.BaseReportEvent
 * JD-Core Version:    0.7.0.1
 */