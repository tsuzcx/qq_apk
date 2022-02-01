package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class FlowKt__CollectKt$collect$3
  implements FlowCollector<T>
{
  public FlowKt__CollectKt$collect$3(Function2 paramFunction2) {}
  
  @Nullable
  public Object emit(T paramT, @NotNull Continuation<? super Unit> paramContinuation)
  {
    return this.$action.invoke(paramT, paramContinuation);
  }
  
  @Nullable
  public Object emit$$forInline(Object paramObject, @NotNull Continuation paramContinuation)
  {
    InlineMarker.mark(4);
    new FlowKt__CollectKt.collect.3.emit.1(this, paramContinuation);
    InlineMarker.mark(5);
    return this.$action.invoke(paramObject, paramContinuation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__CollectKt.collect.3
 * JD-Core Version:    0.7.0.1
 */