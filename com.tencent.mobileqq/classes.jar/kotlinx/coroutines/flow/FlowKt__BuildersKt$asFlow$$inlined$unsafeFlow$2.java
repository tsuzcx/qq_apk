package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2
  implements Flow<T>
{
  public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2(Function1 paramFunction1) {}
  
  @Nullable
  public Object collect(@NotNull FlowCollector paramFlowCollector, @NotNull Continuation paramContinuation)
  {
    if ((paramContinuation instanceof FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.2.1))
    {
      local1 = (FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.2.1)paramContinuation;
      if ((local1.label & 0x80000000) != 0)
      {
        local1.label += -2147483648;
        break label51;
      }
    }
    FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.2.1 local1 = new FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.2.1(this, paramContinuation);
    label51:
    Object localObject2 = local1.result;
    Object localObject3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = local1.label;
    FlowCollector localFlowCollector;
    Object localObject1;
    Continuation localContinuation;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          paramFlowCollector = (FlowCollector)local1.L$3;
          paramFlowCollector = (Continuation)local1.L$2;
          paramFlowCollector = (FlowCollector)local1.L$1;
          paramFlowCollector = (2)local1.L$0;
          ResultKt.throwOnFailure(localObject2);
          break label332;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      localFlowCollector = (FlowCollector)local1.L$4;
      localObject1 = (FlowCollector)local1.L$3;
      localContinuation = (Continuation)local1.L$2;
      paramContinuation = (FlowCollector)local1.L$1;
      paramFlowCollector = (2)local1.L$0;
      ResultKt.throwOnFailure(localObject2);
    }
    else
    {
      ResultKt.throwOnFailure(localObject2);
      localContinuation = (Continuation)local1;
      paramContinuation = this.$this_asFlow$inlined;
      local1.L$0 = this;
      local1.L$1 = paramFlowCollector;
      local1.L$2 = localContinuation;
      local1.L$3 = paramFlowCollector;
      local1.L$4 = paramFlowCollector;
      local1.label = 1;
      localObject2 = paramContinuation.invoke(local1);
      if (localObject2 == localObject3) {
        return localObject3;
      }
      2 local2 = this;
      paramContinuation = paramFlowCollector;
      localObject1 = paramContinuation;
      localFlowCollector = paramFlowCollector;
      paramFlowCollector = local2;
    }
    local1.L$0 = paramFlowCollector;
    local1.L$1 = paramContinuation;
    local1.L$2 = localContinuation;
    local1.L$3 = localObject1;
    local1.label = 2;
    if (localFlowCollector.emit(localObject2, local1) == localObject3) {
      return localObject3;
    }
    label332:
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.2
 * JD-Core Version:    0.7.0.1
 */