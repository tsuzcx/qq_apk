package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class FlowKt__ReduceKt$singleOrNull$$inlined$collect$1
  implements FlowCollector<T>
{
  public FlowKt__ReduceKt$singleOrNull$$inlined$collect$1(Ref.ObjectRef paramObjectRef) {}
  
  @Nullable
  public Object emit(Object paramObject, @NotNull Continuation paramContinuation)
  {
    if (this.$result$inlined.element == null)
    {
      this.$result$inlined.element = paramObject;
      return Unit.INSTANCE;
    }
    throw ((Throwable)new IllegalStateException("Expected only one element".toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ReduceKt.singleOrNull..inlined.collect.1
 * JD-Core Version:    0.7.0.1
 */