package com.tencent.mobileqq.kandian.biz.publisher.report;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEventObserver;
import com.tencent.tkd.topicsdk.framework.events.RichEditTextEvent;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/report/RichEditTextReportListener;", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/IEventObserver;", "Lcom/tencent/tkd/topicsdk/framework/events/RichEditTextEvent;", "()V", "onEvent", "", "event", "reportAtObjectChanged", "reportObject", "Lorg/json/JSONObject;", "reportTopicObjectChanged", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RichEditTextReportListener
  implements IEventObserver<RichEditTextEvent>
{
  private final void a(JSONObject paramJSONObject, RichEditTextEvent paramRichEditTextEvent)
  {
    paramJSONObject.put("type", paramRichEditTextEvent.e());
  }
  
  private final void b(JSONObject paramJSONObject, RichEditTextEvent paramRichEditTextEvent)
  {
    paramJSONObject.put("topic_id", paramRichEditTextEvent.e());
    int i;
    if (((CharSequence)paramRichEditTextEvent.e()).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramJSONObject.put("is_new_topic", 1);
    } else {
      paramJSONObject.put("is_new_topic", 0);
    }
    paramRichEditTextEvent = paramRichEditTextEvent.g();
    if (paramRichEditTextEvent != null) {
      paramRichEditTextEvent = paramRichEditTextEvent.get("from");
    } else {
      paramRichEditTextEvent = null;
    }
    if (Intrinsics.areEqual(paramRichEditTextEvent, Integer.valueOf(1))) {
      paramJSONObject.put("topic_from", 2);
    } else {
      paramJSONObject.put("topic_from", 1);
    }
    paramJSONObject.put("publisher_type", 1);
  }
  
  public void a(@NotNull RichEditTextEvent paramRichEditTextEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramRichEditTextEvent, "event");
    JSONObject localJSONObject = new JSONObject();
    String str = PublisherReportUtils.a.a(paramRichEditTextEvent.f(), paramRichEditTextEvent.d());
    EditObject.EditObjectType localEditObjectType = paramRichEditTextEvent.f();
    int i = RichEditTextReportListener.WhenMappings.$EnumSwitchMapping$0[localEditObjectType.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        localJSONObject.put("type", "");
      } else {
        b(localJSONObject, paramRichEditTextEvent);
      }
    }
    else {
      a(localJSONObject, paramRichEditTextEvent);
    }
    paramRichEditTextEvent = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(paramRichEditTextEvent, "BaseApplicationImpl.getApplication()");
    paramRichEditTextEvent = paramRichEditTextEvent.getRuntime();
    if (paramRichEditTextEvent != null)
    {
      PublicAccountReportUtils.a((AppInterface)paramRichEditTextEvent, "", str, str, 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.report.RichEditTextReportListener
 * JD-Core Version:    0.7.0.1
 */