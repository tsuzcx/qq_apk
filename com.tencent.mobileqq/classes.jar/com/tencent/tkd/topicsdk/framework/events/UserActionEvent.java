package com.tencent.tkd.topicsdk.framework.events;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.BaseReportEvent;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/events/UserActionEvent;", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/BaseReportEvent;", "eventKey", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventKey;", "pageId", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventPage;", "element", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventElement;", "globalPublisherConfig", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "publishArticleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "(Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventKey;Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventPage;Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventElement;Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;)V", "()V", "getGlobalPublisherConfig", "()Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "setGlobalPublisherConfig", "(Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;)V", "getPublishArticleInfo", "()Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "setPublishArticleInfo", "(Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;)V", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class UserActionEvent
  extends BaseReportEvent
{
  @Nullable
  private GlobalPublisherConfig jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
  @Nullable
  private PublishArticleInfo jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo;
  
  public UserActionEvent() {}
  
  public UserActionEvent(@NotNull ReportEventKey paramReportEventKey, @NotNull ReportEventPage paramReportEventPage, @NotNull ReportEventElement paramReportEventElement, @Nullable GlobalPublisherConfig paramGlobalPublisherConfig, @Nullable PublishArticleInfo paramPublishArticleInfo)
  {
    this();
    a(paramReportEventKey);
    a(paramReportEventPage);
    a(paramReportEventElement);
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig = paramGlobalPublisherConfig;
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo = paramPublishArticleInfo;
  }
  
  @Nullable
  public final GlobalPublisherConfig a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
  }
  
  @Nullable
  public final PublishArticleInfo a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.events.UserActionEvent
 * JD-Core Version:    0.7.0.1
 */