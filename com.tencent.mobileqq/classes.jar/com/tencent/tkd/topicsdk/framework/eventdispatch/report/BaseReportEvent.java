package com.tencent.tkd.topicsdk.framework.eventdispatch.report;

import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/BaseReportEvent;", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/IEvent;", "()V", "element", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventElement;", "getElement", "()Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventElement;", "setElement", "(Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventElement;)V", "eventKey", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventKey;", "getEventKey", "()Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventKey;", "setEventKey", "(Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventKey;)V", "pageId", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventPage;", "getPageId", "()Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventPage;", "setPageId", "(Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventPage;)V", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
public class BaseReportEvent
  implements IEvent
{
  @NotNull
  private ReportEventElement jdField_a_of_type_ComTencentTkdTopicsdkFrameworkEventdispatchReportReportEventElement = ReportEventElement.ELEMENT_INVALID;
  @NotNull
  private ReportEventKey jdField_a_of_type_ComTencentTkdTopicsdkFrameworkEventdispatchReportReportEventKey = ReportEventKey.EVENT_INVALID;
  @NotNull
  private ReportEventPage jdField_a_of_type_ComTencentTkdTopicsdkFrameworkEventdispatchReportReportEventPage = ReportEventPage.PAGE_INVALID;
  
  @NotNull
  public final ReportEventElement a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkEventdispatchReportReportEventElement;
  }
  
  @NotNull
  public final ReportEventKey a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkEventdispatchReportReportEventKey;
  }
  
  @NotNull
  public final ReportEventPage a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkEventdispatchReportReportEventPage;
  }
  
  public final void a(@NotNull ReportEventElement paramReportEventElement)
  {
    Intrinsics.checkParameterIsNotNull(paramReportEventElement, "<set-?>");
    this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkEventdispatchReportReportEventElement = paramReportEventElement;
  }
  
  public final void a(@NotNull ReportEventKey paramReportEventKey)
  {
    Intrinsics.checkParameterIsNotNull(paramReportEventKey, "<set-?>");
    this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkEventdispatchReportReportEventKey = paramReportEventKey;
  }
  
  public final void a(@NotNull ReportEventPage paramReportEventPage)
  {
    Intrinsics.checkParameterIsNotNull(paramReportEventPage, "<set-?>");
    this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkEventdispatchReportReportEventPage = paramReportEventPage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.eventdispatch.report.BaseReportEvent
 * JD-Core Version:    0.7.0.1
 */