package com.tencent.tkd.topicsdk.adapter.publisharticle;

import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import com.tencent.tkd.topicsdk.framework.events.LocationChangeEvent;
import com.tencent.tkd.topicsdk.framework.events.LocationChangeEvent.Companion;
import com.tencent.tkd.topicsdk.framework.events.UserActionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/adapter/publisharticle/QQPublishArticleReportUtils;", "", "()V", "reportKDCommunityPageClick", "", "communityInfo", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "element", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventElement;", "reportLocationChanged", "isAdd", "", "qq-adapter_release"}, k=1, mv={1, 1, 16})
public final class QQPublishArticleReportUtils
{
  public static final QQPublishArticleReportUtils a = new QQPublishArticleReportUtils();
  
  public final void a(@Nullable CommunityInfo paramCommunityInfo, @NotNull ReportEventElement paramReportEventElement)
  {
    Intrinsics.checkParameterIsNotNull(paramReportEventElement, "element");
    if (paramCommunityInfo != null)
    {
      DispatchManager localDispatchManager = DispatchManager.a;
      ReportEventKey localReportEventKey = ReportEventKey.EVENT_CLICK;
      ReportEventPage localReportEventPage = ReportEventPage.PAGE_KD_COMMUNITY;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("kdCommunityId", paramCommunityInfo.getCommunityId());
      localDispatchManager.a((IEvent)new UserActionEvent(null, localReportEventKey, localReportEventPage, paramReportEventElement, null, null, localJSONObject, 49, null));
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = LocationChangeEvent.a.a();
    } else {
      i = LocationChangeEvent.a.b();
    }
    DispatchManager.a.a((IEvent)new LocationChangeEvent(i, 0, 2, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.QQPublishArticleReportUtils
 * JD-Core Version:    0.7.0.1
 */