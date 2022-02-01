package com.tencent.tkd.topicsdk.framework.eventdispatch;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/eventdispatch/IEventObserver;", "T", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/IEvent;", "", "onEvent", "", "event", "(Lcom/tencent/tkd/topicsdk/framework/eventdispatch/IEvent;)V", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
public abstract interface IEventObserver<T extends IEvent>
{
  public abstract void a(@NotNull T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.eventdispatch.IEventObserver
 * JD-Core Version:    0.7.0.1
 */