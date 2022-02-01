package com.tencent.mobileqq.kandian.biz.publisher.report;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEventObserver;
import com.tencent.tkd.topicsdk.framework.events.RichEditTextEvent;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/report/RichEditTextReportListener;", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/IEventObserver;", "Lcom/tencent/tkd/topicsdk/framework/events/RichEditTextEvent;", "()V", "onEvent", "", "event", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RichEditTextReportListener
  implements IEventObserver<RichEditTextEvent>
{
  public void a(@NotNull RichEditTextEvent paramRichEditTextEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramRichEditTextEvent, "event");
    HashMap localHashMap = new HashMap();
    String str = PublisherReportUtils.a.a(paramRichEditTextEvent.a(), paramRichEditTextEvent.a());
    if ((paramRichEditTextEvent.a() == EditObject.EditObjectType.TYPE_AT) || (paramRichEditTextEvent.a() == EditObject.EditObjectType.TYPE_TOPIC)) {
      ((Map)localHashMap).put("type", paramRichEditTextEvent.a());
    }
    for (;;)
    {
      paramRichEditTextEvent = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(paramRichEditTextEvent, "BaseApplicationImpl.getApplication()");
      paramRichEditTextEvent = paramRichEditTextEvent.getRuntime();
      if (paramRichEditTextEvent != null) {
        break;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
      ((Map)localHashMap).put("type", "");
    }
    paramRichEditTextEvent = (QQAppInterface)paramRichEditTextEvent;
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent((AppInterface)paramRichEditTextEvent, "", str, str, 0, 0, String.valueOf(localHashMap.get("type")), "", "", String.valueOf(localHashMap.get("type")), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.report.RichEditTextReportListener
 * JD-Core Version:    0.7.0.1
 */