package com.tencent.mobileqq.kandian.biz.publisher.impls;

import com.tencent.tkd.topicsdk.framework.eventdispatch.IEventObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/publisher/impls/UserActionHandlerImpl$coverChangeObserver$1", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/IEventObserver;", "Lcom/tencent/mobileqq/kandian/biz/publisher/impls/TopicCoverChangeEvent;", "onEvent", "", "event", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class UserActionHandlerImpl$coverChangeObserver$1
  implements IEventObserver<TopicCoverChangeEvent>
{
  public void a(@NotNull TopicCoverChangeEvent paramTopicCoverChangeEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicCoverChangeEvent, "event");
    UserActionHandlerImpl.a(this.a, paramTopicCoverChangeEvent.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.UserActionHandlerImpl.coverChangeObserver.1
 * JD-Core Version:    0.7.0.1
 */