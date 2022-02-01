package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1
  implements Flow<T>
{
  public FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1(Flow paramFlow, Function3 paramFunction3) {}
  
  @Nullable
  public Object collect(@NotNull FlowCollector paramFlowCollector, @NotNull Continuation paramContinuation)
  {
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = NullSurrogateKt.NULL;
    paramFlowCollector = this.$this_scanReduce$inlined.collect((FlowCollector)new FlowKt__TransformKt.scanReduce..inlined.unsafeFlow.1.lambda.1(paramFlowCollector, localObjectRef, this), paramContinuation);
    if (paramFlowCollector == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramFlowCollector;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__TransformKt.scanReduce..inlined.unsafeFlow.1
 * JD-Core Version:    0.7.0.1
 */