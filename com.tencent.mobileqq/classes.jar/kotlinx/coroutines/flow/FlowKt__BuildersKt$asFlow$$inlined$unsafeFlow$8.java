package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8
  implements Flow<Long>
{
  public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8(long[] paramArrayOfLong) {}
  
  @Nullable
  public Object collect(@NotNull FlowCollector paramFlowCollector, @NotNull Continuation paramContinuation)
  {
    if ((paramContinuation instanceof FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.8.1))
    {
      localObject1 = (FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.8.1)paramContinuation;
      if ((((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.8.1)localObject1).label & 0x80000000) != 0)
      {
        ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.8.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation)localObject1;
        break label53;
      }
    }
    paramContinuation = new FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.8.1(this, paramContinuation);
    label53:
    Object localObject5 = paramContinuation.result;
    Object localObject1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    long l1;
    int j;
    Object localObject4;
    Object localObject3;
    Continuation localContinuation;
    FlowCollector localFlowCollector1;
    Object localObject2;
    Object localObject6;
    FlowCollector localFlowCollector2;
    if (i != 0)
    {
      if (i == 1)
      {
        l1 = paramContinuation.J$1;
        l1 = paramContinuation.J$0;
        i = paramContinuation.I$1;
        j = paramContinuation.I$0;
        localObject4 = (long[])paramContinuation.L$5;
        localObject3 = (long[])paramContinuation.L$4;
        paramFlowCollector = (FlowCollector)paramContinuation.L$3;
        localContinuation = (Continuation)paramContinuation.L$2;
        localFlowCollector1 = (FlowCollector)paramContinuation.L$1;
        localObject2 = (8)paramContinuation.L$0;
        ResultKt.throwOnFailure(localObject5);
        localObject6 = localObject1;
        localObject1 = localObject2;
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
      localObject3 = this.$this_asFlow$inlined;
      j = localObject3.length;
      localObject2 = localObject1;
      localObject1 = localObject3;
      localObject3 = localObject1;
      i = 0;
      localFlowCollector2 = paramFlowCollector;
      localObject5 = this;
      localFlowCollector1 = paramFlowCollector;
      localObject4 = localObject1;
      localObject1 = localObject5;
      localObject5 = paramContinuation;
    }
    while (i < j)
    {
      l1 = localObject4[i];
      long l2 = ((Number)Boxing.boxLong(l1)).longValue();
      Long localLong = Boxing.boxLong(l2);
      ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.8.1)localObject5).L$0 = localObject1;
      ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.8.1)localObject5).L$1 = localFlowCollector1;
      ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.8.1)localObject5).L$2 = localContinuation;
      ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.8.1)localObject5).L$3 = localFlowCollector2;
      ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.8.1)localObject5).L$4 = localObject3;
      ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.8.1)localObject5).L$5 = localObject4;
      ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.8.1)localObject5).I$0 = j;
      ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.8.1)localObject5).I$1 = i;
      ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.8.1)localObject5).J$0 = l1;
      ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.8.1)localObject5).J$1 = l2;
      ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.8.1)localObject5).label = 1;
      paramFlowCollector = localFlowCollector2;
      paramContinuation = (Continuation)localObject5;
      localObject6 = localObject2;
      if (localFlowCollector2.emit(localLong, (Continuation)localObject5) == localObject2) {
        return localObject2;
      }
      i += 1;
      localFlowCollector2 = paramFlowCollector;
      localObject5 = paramContinuation;
      localObject2 = localObject6;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.8
 * JD-Core Version:    0.7.0.1
 */