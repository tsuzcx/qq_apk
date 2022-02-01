package com.tencent.tkd.topicsdk.framework.events;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.BaseReportEvent;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventBusiness;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/events/UserActionEvent;", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/BaseReportEvent;", "business", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventBusiness;", "eventKey", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventKey;", "pageId", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventPage;", "element", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventElement;", "globalPublisherConfig", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "publishArticleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "extraInfo", "Lorg/json/JSONObject;", "(Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventBusiness;Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventKey;Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventPage;Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventElement;Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;Lorg/json/JSONObject;)V", "()V", "getExtraInfo", "()Lorg/json/JSONObject;", "setExtraInfo", "(Lorg/json/JSONObject;)V", "getGlobalPublisherConfig", "()Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "setGlobalPublisherConfig", "(Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;)V", "getPublishArticleInfo", "()Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "setPublishArticleInfo", "(Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;)V", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class UserActionEvent
  extends BaseReportEvent
{
  @Nullable
  private GlobalPublisherConfig a;
  @Nullable
  private PublishArticleInfo b;
  @Nullable
  private JSONObject c;
  
  public UserActionEvent() {}
  
  public UserActionEvent(@NotNull ReportEventBusiness paramReportEventBusiness, @NotNull ReportEventKey paramReportEventKey, @NotNull ReportEventPage paramReportEventPage, @NotNull ReportEventElement paramReportEventElement, @Nullable GlobalPublisherConfig paramGlobalPublisherConfig, @Nullable PublishArticleInfo paramPublishArticleInfo, @Nullable JSONObject paramJSONObject)
  {
    this();
    a(paramReportEventBusiness);
    a(paramReportEventKey);
    a(paramReportEventPage);
    a(paramReportEventElement);
    this.a = paramGlobalPublisherConfig;
    this.b = paramPublishArticleInfo;
    this.c = paramJSONObject;
  }
  
  public final void a(@Nullable GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    this.a = paramGlobalPublisherConfig;
  }
  
  @Nullable
  public final GlobalPublisherConfig d()
  {
    return this.a;
  }
  
  @Nullable
  public final PublishArticleInfo e()
  {
    return this.b;
  }
  
  @Nullable
  public final JSONObject f()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.events.UserActionEvent
 * JD-Core Version:    0.7.0.1
 */