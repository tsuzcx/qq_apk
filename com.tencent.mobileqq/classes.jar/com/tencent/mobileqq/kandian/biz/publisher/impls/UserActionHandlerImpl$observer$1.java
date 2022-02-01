package com.tencent.mobileqq.kandian.biz.publisher.impls;

import com.tencent.tkd.topicsdk.framework.eventdispatch.IEventObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/publisher/impls/UserActionHandlerImpl$observer$1", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/IEventObserver;", "Lcom/tencent/mobileqq/kandian/biz/publisher/impls/ClickActionEvent;", "onEvent", "", "event", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class UserActionHandlerImpl$observer$1
  implements IEventObserver<ClickActionEvent>
{
  public void a(@NotNull ClickActionEvent paramClickActionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramClickActionEvent, "event");
    int i = paramClickActionEvent.a();
    if (i != 30001)
    {
      if (i != 50001)
      {
        if (i != 60001) {
          return;
        }
        UserActionHandlerImpl.c(this.a, paramClickActionEvent.a());
        return;
      }
      UserActionHandlerImpl.b(this.a, paramClickActionEvent.a());
      return;
    }
    UserActionHandlerImpl.a(this.a, paramClickActionEvent.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.UserActionHandlerImpl.observer.1
 * JD-Core Version:    0.7.0.1
 */