package com.tencent.tkd.topicsdk.publisharticle.base;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import com.tencent.tkd.topicsdk.framework.events.RichEditTextEvent;
import com.tencent.tkd.topicsdk.framework.events.UserActionEvent;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/base/BasePublishArticleReportUtils;", "", "()V", "reportClickPublishButton", "", "config", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "info", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "reportEditObjectChanged", "isAdd", "", "id", "", "type", "Lcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;", "extraInfo", "Lorg/json/JSONObject;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class BasePublishArticleReportUtils
{
  public static final BasePublishArticleReportUtils a = new BasePublishArticleReportUtils();
  
  public final void a(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramGlobalPublisherConfig, "config");
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "info");
    DispatchManager.a.a((IEvent)new UserActionEvent(null, ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_PUBLISH, ReportEventElement.BUTTON_CONFIRM, paramGlobalPublisherConfig, paramPublishArticleInfo, null, 65, null));
  }
  
  public final void a(boolean paramBoolean, @NotNull String paramString, @NotNull EditObject.EditObjectType paramEditObjectType, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "id");
    Intrinsics.checkParameterIsNotNull(paramEditObjectType, "type");
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    DispatchManager localDispatchManager = DispatchManager.a;
    RichEditTextEvent localRichEditTextEvent = new RichEditTextEvent();
    localRichEditTextEvent.a(ReportEventPage.PAGE_PUBLISH);
    localRichEditTextEvent.a(i);
    localRichEditTextEvent.a(paramString);
    localRichEditTextEvent.a(paramEditObjectType);
    localRichEditTextEvent.a(paramJSONObject);
    localDispatchManager.a((IEvent)localRichEditTextEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.base.BasePublishArticleReportUtils
 * JD-Core Version:    0.7.0.1
 */