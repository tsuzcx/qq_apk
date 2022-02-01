package kotlinx.coroutines.flow;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5
  implements Flow<T>
{
  public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5(Sequence paramSequence) {}
  
  @Nullable
  public Object collect(@NotNull FlowCollector paramFlowCollector, @NotNull Continuation paramContinuation)
  {
    Object localObject1;
    if ((paramContinuation instanceof FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.5.1))
    {
      localObject1 = (FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.5.1)paramContinuation;
      if ((((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.5.1)localObject1).label & 0x80000000) != 0)
      {
        ((FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.5.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation)localObject1;
        break label53;
      }
    }
    paramContinuation = new FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.5.1(this, paramContinuation);
    label53:
    Object localObject3 = paramContinuation.result;
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    Iterator localIterator;
    Sequence localSequence;
    Continuation localContinuation;
    FlowCollector localFlowCollector;
    if (i != 0)
    {
      if (i == 1)
      {
        paramFlowCollector = paramContinuation.L$7;
        paramFlowCollector = paramContinuation.L$6;
        localIterator = (Iterator)paramContinuation.L$5;
        localSequence = (Sequence)paramContinuation.L$4;
        paramFlowCollector = (FlowCollector)paramContinuation.L$3;
        localContinuation = (Continuation)paramContinuation.L$2;
        localFlowCollector = (FlowCollector)paramContinuation.L$1;
        localObject1 = (5)paramContinuation.L$0;
        ResultKt.throwOnFailure(localObject3);
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(localObject3);
      localContinuation = (Continuation)paramContinuation;
      localSequence = this.$this_asFlow$inlined;
      localIterator = localSequence.iterator();
      localObject1 = this;
      localFlowCollector = paramFlowCollector;
    }
    Object localObject4;
    do
    {
      localObject3 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject4 = localIterator.next();
      paramContinuation.L$0 = localObject1;
      paramContinuation.L$1 = localFlowCollector;
      paramContinuation.L$2 = localContinuation;
      paramContinuation.L$3 = paramFlowCollector;
      paramContinuation.L$4 = localSequence;
      paramContinuation.L$5 = localIterator;
      paramContinuation.L$6 = localObject4;
      paramContinuation.L$7 = localObject4;
      paramContinuation.label = 1;
    } while (paramFlowCollector.emit(localObject4, paramContinuation) != localObject3);
    return localObject3;
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.5
 * JD-Core Version:    0.7.0.1
 */