package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class FlowKt__DelayKt$debounce$2$values$1$invokeSuspend$$inlined$collect$1
  implements FlowCollector<T>
{
  public FlowKt__DelayKt$debounce$2$values$1$invokeSuspend$$inlined$collect$1(ProducerScope paramProducerScope) {}
  
  @Nullable
  public Object emit(Object paramObject, @NotNull Continuation paramContinuation)
  {
    ProducerScope localProducerScope = this.$this_produce$inlined;
    if (paramObject == null) {
      paramObject = NullSurrogateKt.NULL;
    }
    paramObject = localProducerScope.send(paramObject, paramContinuation);
    if (paramObject == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramObject;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__DelayKt.debounce.2.values.1.invokeSuspend..inlined.collect.1
 * JD-Core Version:    0.7.0.1
 */