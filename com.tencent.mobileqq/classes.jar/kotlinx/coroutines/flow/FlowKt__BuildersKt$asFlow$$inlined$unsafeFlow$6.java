package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6
  implements Flow<T>
{
  public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6(Object[] paramArrayOfObject) {}
  
  @Nullable
  public Object collect(@NotNull FlowCollector paramFlowCollector, @NotNull Continuation paramContinuation)
  {
    if ((paramContinuation instanceof FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.6.1))
    {
      localObject1 = (FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.6.1)paramContinuation;
      if ((((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.6.1)localObject1).label & 0x80000000) != 0)
      {
        ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.6.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation)localObject1;
        break label53;
      }
    }
    paramContinuation = new FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.6.1(this, paramContinuation);
    label53:
    Object localObject5 = paramContinuation.result;
    Object localObject1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    int j;
    Object localObject3;
    Object localObject4;
    Object localObject2;
    Continuation localContinuation;
    FlowCollector localFlowCollector;
    Object localObject7;
    Object localObject6;
    if (i != 0)
    {
      if (i == 1)
      {
        paramFlowCollector = paramContinuation.L$7;
        paramFlowCollector = paramContinuation.L$6;
        i = paramContinuation.I$1;
        j = paramContinuation.I$0;
        localObject3 = (Object[])paramContinuation.L$5;
        localObject4 = (Object[])paramContinuation.L$4;
        localObject2 = (FlowCollector)paramContinuation.L$3;
        localContinuation = (Continuation)paramContinuation.L$2;
        localFlowCollector = (FlowCollector)paramContinuation.L$1;
        paramFlowCollector = (6)paramContinuation.L$0;
        ResultKt.throwOnFailure(localObject5);
        localObject5 = localObject1;
        localObject1 = localObject3;
        localObject7 = localObject2;
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(localObject5);
      localContinuation = (Continuation)paramContinuation;
      localObject2 = this.$this_asFlow$inlined;
      j = localObject2.length;
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject5 = this;
      localObject2 = paramFlowCollector;
      i = 0;
      localObject6 = localObject1;
      localObject4 = localObject1;
      localFlowCollector = paramFlowCollector;
      localObject1 = localObject6;
      paramFlowCollector = (FlowCollector)localObject5;
      localObject6 = paramContinuation;
    }
    while (i < j)
    {
      Object localObject8 = localObject1[i];
      ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.6.1)localObject6).L$0 = paramFlowCollector;
      ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.6.1)localObject6).L$1 = localFlowCollector;
      ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.6.1)localObject6).L$2 = localContinuation;
      ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.6.1)localObject6).L$3 = localObject2;
      ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.6.1)localObject6).L$4 = localObject4;
      ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.6.1)localObject6).L$5 = localObject1;
      ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.6.1)localObject6).I$0 = j;
      ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.6.1)localObject6).I$1 = i;
      ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.6.1)localObject6).L$6 = localObject8;
      ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.6.1)localObject6).L$7 = localObject8;
      ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.6.1)localObject6).label = 1;
      paramContinuation = (Continuation)localObject6;
      localObject5 = localObject3;
      localObject7 = localObject2;
      if (((FlowCollector)localObject2).emit(localObject8, (Continuation)localObject6) == localObject3) {
        return localObject3;
      }
      i += 1;
      localObject6 = paramContinuation;
      localObject3 = localObject5;
      localObject2 = localObject7;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.6
 * JD-Core Version:    0.7.0.1
 */