package com.tencent.mobileqq.kandian.biz.publisher.report;

import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/report/PublisherReportUtils;", "", "()V", "CLICK_ADD_AT_PERSON", "", "CLICK_ADD_LOCATION", "CLICK_ADD_TOPIC", "CLICK_AT_PERSON_BUTTON", "CLICK_CANCEL_COLUMN", "CLICK_COLUMN_COVER", "CLICK_COLUMN_DIALOG", "CLICK_COMMUNITY_KD_PAGE_ITEM", "CLICK_CREATE_COLUMN", "CLICK_DELETE_AT_PERSON", "CLICK_DELETE_LOCATION", "CLICK_DELETE_TOPIC", "CLICK_DELIVER_TO_KD_COMMUNITY_BUTTON", "CLICK_LOCATION_BUTTON", "CLICK_PROGRESSBAR_PAUSE_BTN", "CLICK_PROGRESSBAR_RETRY_BTN", "CLICK_PROGRESSBAR_UPLOAD_BTN", "CLICK_TOPIC_BUTTON", "CLICK_UPLOAD_COLUMN", "CLICK_UPLOAD_VIDEO_CANCEL", "CLICK_UPLOAD_VIDEO_FINISH", "EMPTY_T_CODE", "EXPOSE_AT_PERSON_BUTTON", "EXPOSE_COLUMN_DIALOG", "EXPOSE_DELIVER_TO_KD_COMMUNITY_BUTTON", "EXPOSE_LOCATION_BUTTON", "EXPOSE_TOPIC_BUTTON", "EXPOSE_TWEET_TOPIC_POPUP", "clickReport", "pageId", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventPage;", "element", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventElement;", "convertToPublishTCode", "userActionKey", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventKey;", "editObjectType", "Lcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;", "action", "", "exposeReport", "getFromForReport", "from", "getR2ForReport", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PublisherReportUtils
{
  public static final PublisherReportUtils a = new PublisherReportUtils();
  
  private final String a(ReportEventPage paramReportEventPage, ReportEventElement paramReportEventElement)
  {
    int i = PublisherReportUtils.WhenMappings.e[paramReportEventPage.ordinal()];
    String str = "0X800BB31";
    switch (i)
    {
    }
    do
    {
      for (;;)
      {
        return "";
        i = PublisherReportUtils.WhenMappings.d[paramReportEventElement.ordinal()];
        paramReportEventPage = str;
        if (i == 1) {
          break;
        }
        paramReportEventPage = str;
        if (i == 2) {
          break;
        }
        continue;
        switch (PublisherReportUtils.WhenMappings.c[paramReportEventElement.ordinal()])
        {
        }
      }
      return "0X800AC63";
      return "0X800AC62";
      return "0X800AC61";
      return "0X800B4C8";
      return "0X800B24B";
      return "0X800B4D4";
      return "0X800AC5E";
      return "0X800AC5F";
      return "0X800AC60";
      return "0X800AD2E";
      i = PublisherReportUtils.WhenMappings.b[paramReportEventElement.ordinal()];
      if (i == 1) {
        break label206;
      }
      if (i == 2) {
        break;
      }
    } while (i != 3);
    return "0X800AC5A";
    return "0X800AC5B";
    label206:
    paramReportEventPage = "0X800AC5C";
    return paramReportEventPage;
  }
  
  private final String b(ReportEventPage paramReportEventPage, ReportEventElement paramReportEventElement)
  {
    int i = PublisherReportUtils.WhenMappings.g[paramReportEventPage.ordinal()];
    if ((i != 1) && (i != 2))
    {
      if (i != 3) {
        return "";
      }
      i = PublisherReportUtils.WhenMappings.f[paramReportEventElement.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                return "";
              }
              return "0X800BB66";
            }
            return "0X800BB2F";
          }
          return "0X800B4C6";
        }
        return "0X800B24A";
      }
      return "0X800B4D2";
    }
    return "0X800AD2D";
  }
  
  public final int a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if ((paramInt != 3) && (paramInt != 4))
        {
          if (paramInt != 5) {
            return paramInt;
          }
          return 4;
        }
        return 1;
      }
      return 2;
    }
    return 3;
  }
  
  @NotNull
  public final String a(@NotNull ReportEventKey paramReportEventKey, @NotNull ReportEventPage paramReportEventPage, @NotNull ReportEventElement paramReportEventElement)
  {
    Intrinsics.checkParameterIsNotNull(paramReportEventKey, "userActionKey");
    Intrinsics.checkParameterIsNotNull(paramReportEventPage, "pageId");
    Intrinsics.checkParameterIsNotNull(paramReportEventElement, "element");
    if (PublisherReportUtils.WhenMappings.a[paramReportEventKey.ordinal()] != 1) {
      return a(paramReportEventPage, paramReportEventElement);
    }
    return b(paramReportEventPage, paramReportEventElement);
  }
  
  @NotNull
  public final String a(@NotNull EditObject.EditObjectType paramEditObjectType, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramEditObjectType, "editObjectType");
    int i = PublisherReportUtils.WhenMappings.h[paramEditObjectType.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return "";
      }
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return "";
        }
        return "0X800B4D8";
      }
      return "0X800B4D6";
    }
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return "";
      }
      return "0X800B24D";
    }
    return "0X800B24C";
  }
  
  public final int b(int paramInt)
  {
    int i = 8;
    if (paramInt != 1)
    {
      if (paramInt != 5)
      {
        if (paramInt != 8) {
          return 0;
        }
      }
      else {
        return 5;
      }
    }
    else {
      i = 3;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.report.PublisherReportUtils
 * JD-Core Version:    0.7.0.1
 */