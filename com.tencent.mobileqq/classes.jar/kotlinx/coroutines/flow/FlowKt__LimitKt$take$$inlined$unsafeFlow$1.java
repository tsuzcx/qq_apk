package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref.IntRef;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class FlowKt__LimitKt$take$$inlined$unsafeFlow$1
  implements Flow<T>
{
  public FlowKt__LimitKt$take$$inlined$unsafeFlow$1(Flow paramFlow, int paramInt) {}
  
  @Nullable
  public Object collect(@NotNull FlowCollector paramFlowCollector, @NotNull Continuation paramContinuation)
  {
    if ((paramContinuation instanceof FlowKt__LimitKt.take..inlined.unsafeFlow.1.1))
    {
      localObject1 = (FlowKt__LimitKt.take..inlined.unsafeFlow.1.1)paramContinuation;
      if ((((FlowKt__LimitKt.take..inlined.unsafeFlow.1.1)localObject1).label & 0x80000000) != 0)
      {
        ((FlowKt__LimitKt.take..inlined.unsafeFlow.1.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation)localObject1;
        break label53;
      }
    }
    paramContinuation = new FlowKt__LimitKt.take..inlined.unsafeFlow.1.1(this, paramContinuation);
    label53:
    Object localObject2 = paramContinuation.result;
    Object localObject3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    if (i != 0) {
      if (i == 1)
      {
        paramFlowCollector = (Flow)paramContinuation.L$5;
        paramFlowCollector = (Ref.IntRef)paramContinuation.L$4;
        localObject1 = (FlowCollector)paramContinuation.L$3;
        paramFlowCollector = (Continuation)paramContinuation.L$2;
        paramFlowCollector = (FlowCollector)paramContinuation.L$1;
        paramFlowCollector = (1)paramContinuation.L$0;
      }
    }
    try
    {
      ResultKt.throwOnFailure(localObject2);
    }
    catch (AbortFlowException paramFlowCollector)
    {
      Ref.IntRef localIntRef;
      Flow localFlow;
      FlowCollector localFlowCollector;
      FlowExceptions_commonKt.checkOwnership(paramFlowCollector, (FlowCollector)localObject1);
    }
    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    ResultKt.throwOnFailure(localObject2);
    localObject2 = (Continuation)paramContinuation;
    localIntRef = new Ref.IntRef();
    localIntRef.element = 0;
    Object localObject1 = paramFlowCollector;
    localFlow = this.$this_take$inlined;
    localObject1 = paramFlowCollector;
    localFlowCollector = (FlowCollector)new FlowKt__LimitKt.take..inlined.unsafeFlow.1.lambda.1(paramFlowCollector, localIntRef, this);
    localObject1 = paramFlowCollector;
    paramContinuation.L$0 = this;
    localObject1 = paramFlowCollector;
    paramContinuation.L$1 = paramFlowCollector;
    localObject1 = paramFlowCollector;
    paramContinuation.L$2 = localObject2;
    localObject1 = paramFlowCollector;
    paramContinuation.L$3 = paramFlowCollector;
    localObject1 = paramFlowCollector;
    paramContinuation.L$4 = localIntRef;
    localObject1 = paramFlowCollector;
    paramContinuation.L$5 = localFlow;
    localObject1 = paramFlowCollector;
    paramContinuation.label = 1;
    localObject1 = paramFlowCollector;
    paramFlowCollector = localFlow.collect(localFlowCollector, paramContinuation);
    if (paramFlowCollector == localObject3) {
      return localObject3;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__LimitKt.take..inlined.unsafeFlow.1
 * JD-Core Version:    0.7.0.1
 */