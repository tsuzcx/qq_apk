package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"withContextUndispatched", "T", "V", "newContext", "Lkotlin/coroutines/CoroutineContext;", "countOrElement", "", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "value", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asChannelFlow", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/Flow;", "withUndispatchedContextCollector", "Lkotlinx/coroutines/flow/FlowCollector;", "emitContext", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class ChannelFlowKt
{
  @NotNull
  public static final <T> ChannelFlow<T> asChannelFlow(@NotNull Flow<? extends T> paramFlow)
  {
    if (!(paramFlow instanceof ChannelFlow)) {
      localObject = null;
    } else {
      localObject = paramFlow;
    }
    Object localObject = (ChannelFlow)localObject;
    if (localObject != null) {
      return localObject;
    }
    return (ChannelFlow)new ChannelFlowOperatorImpl(paramFlow, null, 0, 6, null);
  }
  
  private static final <T> FlowCollector<T> withUndispatchedContextCollector(@NotNull FlowCollector<? super T> paramFlowCollector, CoroutineContext paramCoroutineContext)
  {
    if ((paramFlowCollector instanceof SendingCollector)) {
      return paramFlowCollector;
    }
    if ((paramFlowCollector instanceof NopCollector)) {
      return paramFlowCollector;
    }
    return (FlowCollector)new UndispatchedContextCollector(paramFlowCollector, paramCoroutineContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.ChannelFlowKt
 * JD-Core Version:    0.7.0.1
 */