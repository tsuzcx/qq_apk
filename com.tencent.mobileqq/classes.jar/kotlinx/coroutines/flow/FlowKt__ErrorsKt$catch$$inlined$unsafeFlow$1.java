package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1
  implements Flow<T>
{
  public FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(Flow paramFlow, Function3 paramFunction3) {}
  
  @Nullable
  public Object collect(@NotNull FlowCollector paramFlowCollector, @NotNull Continuation paramContinuation)
  {
    Object localObject1;
    if ((paramContinuation instanceof FlowKt__ErrorsKt.catch..inlined.unsafeFlow.1.1))
    {
      localObject1 = (FlowKt__ErrorsKt.catch..inlined.unsafeFlow.1.1)paramContinuation;
      if ((((FlowKt__ErrorsKt.catch..inlined.unsafeFlow.1.1)localObject1).label & 0x80000000) != 0)
      {
        ((FlowKt__ErrorsKt.catch..inlined.unsafeFlow.1.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation)localObject1;
        break label53;
      }
    }
    paramContinuation = new FlowKt__ErrorsKt.catch..inlined.unsafeFlow.1.1(this, paramContinuation);
    label53:
    Object localObject2 = paramContinuation.result;
    Object localObject4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    FlowCollector localFlowCollector;
    1 local1;
    Object localObject3;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          paramFlowCollector = (Throwable)paramContinuation.L$4;
          paramFlowCollector = (FlowCollector)paramContinuation.L$3;
          paramFlowCollector = (Continuation)paramContinuation.L$2;
          paramFlowCollector = (FlowCollector)paramContinuation.L$1;
          paramFlowCollector = (1)paramContinuation.L$0;
          ResultKt.throwOnFailure(localObject2);
          break label331;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      localFlowCollector = (FlowCollector)paramContinuation.L$3;
      paramFlowCollector = (Continuation)paramContinuation.L$2;
      localObject1 = (FlowCollector)paramContinuation.L$1;
      local1 = (1)paramContinuation.L$0;
      ResultKt.throwOnFailure(localObject2);
    }
    else
    {
      ResultKt.throwOnFailure(localObject2);
      localObject3 = (Continuation)paramContinuation;
      localObject1 = this.$this_catch$inlined;
      paramContinuation.L$0 = this;
      paramContinuation.L$1 = paramFlowCollector;
      paramContinuation.L$2 = localObject3;
      paramContinuation.L$3 = paramFlowCollector;
      paramContinuation.label = 1;
      localObject2 = FlowKt.catchImpl((Flow)localObject1, paramFlowCollector, paramContinuation);
      if (localObject2 == localObject4) {
        return localObject4;
      }
      local1 = this;
      localObject1 = paramFlowCollector;
      localFlowCollector = paramFlowCollector;
      paramFlowCollector = (FlowCollector)localObject3;
    }
    localObject2 = (Throwable)localObject2;
    if (localObject2 != null)
    {
      localObject3 = local1.$action$inlined;
      paramContinuation.L$0 = local1;
      paramContinuation.L$1 = localObject1;
      paramContinuation.L$2 = paramFlowCollector;
      paramContinuation.L$3 = localFlowCollector;
      paramContinuation.L$4 = localObject2;
      paramContinuation.label = 2;
      if (((Function3)localObject3).invoke(localFlowCollector, localObject2, paramContinuation) == localObject4) {
        return localObject4;
      }
    }
    label331:
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ErrorsKt.catch..inlined.unsafeFlow.1
 * JD-Core Version:    0.7.0.1
 */