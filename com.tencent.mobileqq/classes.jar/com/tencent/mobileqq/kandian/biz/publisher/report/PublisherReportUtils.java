package com.tencent.mobileqq.kandian.biz.publisher.report;

import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/report/PublisherReportUtils;", "", "()V", "CLICK_ADD_AT_PERSON", "", "CLICK_ADD_LOCATION", "CLICK_ADD_TOPIC", "CLICK_AT_PERSON_BUTTON", "CLICK_CANCEL_COLUMN", "CLICK_COLUMN_COVER", "CLICK_COLUMN_DIALOG", "CLICK_CREATE_COLUMN", "CLICK_DELETE_AT_PERSON", "CLICK_DELETE_LOCATION", "CLICK_DELETE_TOPIC", "CLICK_LOCATION_BUTTON", "CLICK_TOPIC_BUTTON", "CLICK_UPLOAD_COLUMN", "CLICK_UPLOAD_VIDEO_CANCEL", "CLICK_UPLOAD_VIDEO_FINISH", "EMPTY_T_CODE", "EXPOSE_AT_PERSON_BUTTON", "EXPOSE_COLUMN_DIALOG", "EXPOSE_LOCATION_BUTTON", "EXPOSE_TOPIC_BUTTON", "clickReport", "pageId", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventPage;", "element", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventElement;", "convertToPublishTCode", "userActionKey", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventKey;", "editObjectType", "Lcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;", "action", "", "exposeReport", "getFromForReport", "from", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PublisherReportUtils
{
  public static final PublisherReportUtils a = new PublisherReportUtils();
  
  private final String a(ReportEventPage paramReportEventPage, ReportEventElement paramReportEventElement)
  {
    switch (PublisherReportUtils.WhenMappings.d[paramReportEventPage.ordinal()])
    {
    default: 
      return "";
    case 1: 
    case 2: 
      switch (PublisherReportUtils.WhenMappings.b[paramReportEventElement.ordinal()])
      {
      default: 
        return "";
      case 1: 
        return "0X800AC5C";
      case 2: 
        return "0X800AC5B";
      }
      return "0X800AC5A";
    case 3: 
    case 4: 
      return "0X800AD2E";
    case 5: 
      return "0X800AC60";
    }
    switch (PublisherReportUtils.WhenMappings.c[paramReportEventElement.ordinal()])
    {
    default: 
      return "";
    case 1: 
      return "0X800AC5F";
    case 2: 
      return "0X800AC5E";
    case 3: 
      return "0X800B4D4";
    case 4: 
      return "0X800B24B";
    }
    return "0X800B4C8";
  }
  
  private final String b(ReportEventPage paramReportEventPage, ReportEventElement paramReportEventElement)
  {
    switch (PublisherReportUtils.WhenMappings.f[paramReportEventPage.ordinal()])
    {
    default: 
      return "";
    case 1: 
    case 2: 
      return "0X800AD2D";
    }
    switch (PublisherReportUtils.WhenMappings.e[paramReportEventElement.ordinal()])
    {
    default: 
      return "";
    case 1: 
      return "0X800B4D2";
    case 2: 
      return "0X800B24A";
    }
    return "0X800B4C6";
  }
  
  public final int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 3;
    case 2: 
      return 2;
    case 3: 
    case 4: 
      return 1;
    }
    return 4;
  }
  
  @NotNull
  public final String a(@NotNull ReportEventKey paramReportEventKey, @NotNull ReportEventPage paramReportEventPage, @NotNull ReportEventElement paramReportEventElement)
  {
    Intrinsics.checkParameterIsNotNull(paramReportEventKey, "userActionKey");
    Intrinsics.checkParameterIsNotNull(paramReportEventPage, "pageId");
    Intrinsics.checkParameterIsNotNull(paramReportEventElement, "element");
    switch (PublisherReportUtils.WhenMappings.a[paramReportEventKey.ordinal()])
    {
    default: 
      return a(paramReportEventPage, paramReportEventElement);
    }
    return b(paramReportEventPage, paramReportEventElement);
  }
  
  @NotNull
  public final String a(@NotNull EditObject.EditObjectType paramEditObjectType, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramEditObjectType, "editObjectType");
    switch (PublisherReportUtils.WhenMappings.g[paramEditObjectType.ordinal()])
    {
    default: 
      return "";
    case 1: 
      switch (paramInt)
      {
      default: 
        return "";
      case 1: 
        return "0X800B24C";
      }
      return "0X800B24D";
    }
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "0X800B4D6";
    }
    return "0X800B4D8";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.report.PublisherReportUtils
 * JD-Core Version:    0.7.0.1
 */