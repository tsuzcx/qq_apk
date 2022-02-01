package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class FlowKt__ContextKt$flowWith$$inlined$unsafeFlow$1
  implements Flow<R>
{
  public FlowKt__ContextKt$flowWith$$inlined$unsafeFlow$1(Flow paramFlow, int paramInt, Function1 paramFunction1, CoroutineContext paramCoroutineContext) {}
  
  @Nullable
  public Object collect(@NotNull FlowCollector paramFlowCollector, @NotNull Continuation paramContinuation)
  {
    Object localObject = paramContinuation.getContext().minusKey((CoroutineContext.Key)Job.Key);
    localObject = FlowKt.buffer(FlowKt.flowOn(this.$source$inlined, (CoroutineContext)localObject), this.$bufferSize$inlined);
    paramFlowCollector = FlowKt.buffer(FlowKt.flowOn((Flow)this.$builder$inlined.invoke(localObject), this.$flowContext$inlined), this.$bufferSize$inlined).collect((FlowCollector)new FlowKt__ContextKt.flowWith..inlined.unsafeFlow.1.lambda.1(paramFlowCollector), paramContinuation);
    if (paramFlowCollector == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramFlowCollector;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ContextKt.flowWith..inlined.unsafeFlow.1
 * JD-Core Version:    0.7.0.1
 */