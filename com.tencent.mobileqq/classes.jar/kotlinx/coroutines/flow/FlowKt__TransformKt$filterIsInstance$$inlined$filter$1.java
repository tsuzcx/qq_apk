package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$3", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$2"}, k=1, mv={1, 1, 16})
public final class FlowKt__TransformKt$filterIsInstance$$inlined$filter$1
  implements Flow<Object>
{
  public FlowKt__TransformKt$filterIsInstance$$inlined$filter$1(Flow paramFlow) {}
  
  @Nullable
  public Object collect(@NotNull FlowCollector paramFlowCollector, @NotNull Continuation paramContinuation)
  {
    Flow localFlow = this.$this_unsafeTransform$inlined;
    Intrinsics.needClassReification();
    paramFlowCollector = localFlow.collect((FlowCollector)new FlowKt__TransformKt.filterIsInstance..inlined.filter.1.2(paramFlowCollector, this), paramContinuation);
    if (paramFlowCollector == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramFlowCollector;
    }
    return Unit.INSTANCE;
  }
  
  @Nullable
  public Object collect$$forInline(@NotNull FlowCollector paramFlowCollector, @NotNull Continuation paramContinuation)
  {
    InlineMarker.mark(4);
    new FlowKt__TransformKt.filterIsInstance..inlined.filter.1.1(this, paramContinuation);
    InlineMarker.mark(5);
    Flow localFlow = this.$this_unsafeTransform$inlined;
    Intrinsics.needClassReification();
    paramFlowCollector = (FlowCollector)new FlowKt__TransformKt.filterIsInstance..inlined.filter.1.2(paramFlowCollector, this);
    InlineMarker.mark(0);
    localFlow.collect(paramFlowCollector, paramContinuation);
    InlineMarker.mark(2);
    InlineMarker.mark(1);
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__TransformKt.filterIsInstance..inlined.filter.1
 * JD-Core Version:    0.7.0.1
 */