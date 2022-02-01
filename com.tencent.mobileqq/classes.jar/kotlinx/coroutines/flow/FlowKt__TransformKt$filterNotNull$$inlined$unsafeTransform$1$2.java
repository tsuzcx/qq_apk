package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$4", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$4$lambda$1"}, k=1, mv={1, 1, 16})
public final class FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2
  implements FlowCollector<T>
{
  public FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2(FlowCollector paramFlowCollector, FlowKt__TransformKt.filterNotNull..inlined.unsafeTransform.1 param1) {}
  
  @Nullable
  public Object emit(Object paramObject, @NotNull Continuation paramContinuation)
  {
    FlowCollector localFlowCollector = this.$this_unsafeFlow$inlined;
    if (paramObject != null)
    {
      paramObject = localFlowCollector.emit(paramObject, paramContinuation);
      if (paramObject == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        return paramObject;
      }
      return Unit.INSTANCE;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__TransformKt.filterNotNull..inlined.unsafeTransform.1.2
 * JD-Core Version:    0.7.0.1
 */