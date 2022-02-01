package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$unsafeFlow$3
  implements Flow<T>
{
  public FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$unsafeFlow$3(Flow paramFlow, Function1 paramFunction1, Function2 paramFunction2) {}
  
  @Nullable
  public Object collect(@NotNull FlowCollector paramFlowCollector, @NotNull Continuation paramContinuation)
  {
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = NullSurrogateKt.NULL;
    paramFlowCollector = this.$this_distinctUntilChangedBy$inlined.collect((FlowCollector)new FlowKt__DistinctKt.distinctUntilChangedBy..inlined.unsafeFlow.3.lambda.1(paramFlowCollector, localObjectRef, this), paramContinuation);
    if (paramFlowCollector == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramFlowCollector;
    }
    return Unit.INSTANCE;
  }
  
  @Nullable
  public Object collect$$forInline(@NotNull FlowCollector paramFlowCollector, @NotNull Continuation paramContinuation)
  {
    InlineMarker.mark(4);
    new FlowKt__DistinctKt.distinctUntilChangedBy..inlined.unsafeFlow.3.1(this, paramContinuation);
    InlineMarker.mark(5);
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = NullSurrogateKt.NULL;
    Flow localFlow = this.$this_distinctUntilChangedBy$inlined;
    paramFlowCollector = (FlowCollector)new FlowKt__DistinctKt.distinctUntilChangedBy..inlined.unsafeFlow.3.lambda.1(paramFlowCollector, localObjectRef, this);
    InlineMarker.mark(0);
    localFlow.collect(paramFlowCollector, paramContinuation);
    InlineMarker.mark(2);
    InlineMarker.mark(1);
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__DistinctKt.distinctUntilChangedBy..inlined.unsafeFlow.3
 * JD-Core Version:    0.7.0.1
 */