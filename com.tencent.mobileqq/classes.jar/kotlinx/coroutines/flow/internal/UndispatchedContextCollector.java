package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/flow/internal/UndispatchedContextCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "downstream", "emitContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;)V", "countOrElement", "", "emitRef", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/jvm/functions/Function2;", "emit", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class UndispatchedContextCollector<T>
  implements FlowCollector<T>
{
  private final Object countOrElement;
  private final CoroutineContext emitContext;
  private final Function2<T, Continuation<? super Unit>, Object> emitRef;
  
  public UndispatchedContextCollector(@NotNull FlowCollector<? super T> paramFlowCollector, @NotNull CoroutineContext paramCoroutineContext)
  {
    this.emitContext = paramCoroutineContext;
    this.countOrElement = ThreadContextKt.threadContextElements(this.emitContext);
    this.emitRef = ((Function2)new UndispatchedContextCollector.emitRef.1(paramFlowCollector, null));
  }
  
  @Nullable
  public Object emit(T paramT, @NotNull Continuation<? super Unit> paramContinuation)
  {
    paramT = ChannelFlowKt.withContextUndispatched(this.emitContext, this.countOrElement, this.emitRef, paramT, paramContinuation);
    if (paramT == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramT;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.UndispatchedContextCollector
 * JD-Core Version:    0.7.0.1
 */