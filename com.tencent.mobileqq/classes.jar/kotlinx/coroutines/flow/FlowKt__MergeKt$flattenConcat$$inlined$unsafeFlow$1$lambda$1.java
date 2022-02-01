package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__MergeKt$$special$$inlined$collect$3"}, k=1, mv={1, 1, 16})
public final class FlowKt__MergeKt$flattenConcat$$inlined$unsafeFlow$1$lambda$1
  implements FlowCollector<Flow<? extends T>>
{
  public FlowKt__MergeKt$flattenConcat$$inlined$unsafeFlow$1$lambda$1(FlowCollector paramFlowCollector) {}
  
  @Nullable
  public Object emit(Object paramObject, @NotNull Continuation paramContinuation)
  {
    paramObject = ((Flow)paramObject).collect(this.$this_unsafeFlow$inlined, paramContinuation);
    if (paramObject == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramObject;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__MergeKt.flattenConcat..inlined.unsafeFlow.1.lambda.1
 * JD-Core Version:    0.7.0.1
 */