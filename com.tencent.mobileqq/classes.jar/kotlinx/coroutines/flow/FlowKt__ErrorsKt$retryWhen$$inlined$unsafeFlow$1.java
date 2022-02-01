package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1
  implements Flow<T>
{
  public FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(Flow paramFlow, Function4 paramFunction4) {}
  
  @Nullable
  public Object collect(@NotNull FlowCollector paramFlowCollector, @NotNull Continuation paramContinuation)
  {
    Object localObject1;
    if ((paramContinuation instanceof FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1.1))
    {
      localObject1 = (FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1.1)paramContinuation;
      if ((((FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1.1)localObject1).label & 0x80000000) != 0)
      {
        ((FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation)localObject1;
        break label53;
      }
    }
    paramContinuation = new FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1.1(this, paramContinuation);
    label53:
    Object localObject6 = paramContinuation.result;
    Object localObject5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    long l;
    Object localObject4;
    Object localObject3;
    Object localObject7;
    Object localObject2;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          paramFlowCollector = (Throwable)paramContinuation.L$4;
          l = paramContinuation.J$0;
          localObject4 = (FlowCollector)paramContinuation.L$3;
          localObject3 = (Continuation)paramContinuation.L$2;
          localObject7 = (FlowCollector)paramContinuation.L$1;
          localObject1 = (1)paramContinuation.L$0;
          ResultKt.throwOnFailure(localObject6);
          localObject2 = paramContinuation;
          paramContinuation = (Continuation)localObject7;
          localObject7 = paramFlowCollector;
          break label464;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      i = paramContinuation.I$0;
      l = paramContinuation.J$0;
      localObject4 = (FlowCollector)paramContinuation.L$3;
      localObject3 = (Continuation)paramContinuation.L$2;
      localObject7 = (FlowCollector)paramContinuation.L$1;
      localObject1 = (1)paramContinuation.L$0;
      ResultKt.throwOnFailure(localObject6);
      localObject2 = paramContinuation;
      paramFlowCollector = (FlowCollector)localObject5;
      paramContinuation = (Continuation)localObject7;
      localObject7 = localObject6;
    }
    else
    {
      ResultKt.throwOnFailure(localObject6);
      localObject4 = (Continuation)paramContinuation;
      l = 0L;
      localObject1 = localObject5;
      localObject5 = paramFlowCollector;
      localObject2 = this;
      localObject3 = paramFlowCollector;
      paramFlowCollector = (FlowCollector)localObject2;
      localObject2 = paramContinuation;
    }
    for (;;)
    {
      paramContinuation = paramFlowCollector.$this_retryWhen$inlined;
      ((FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1.1)localObject2).L$0 = paramFlowCollector;
      ((FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1.1)localObject2).L$1 = localObject5;
      ((FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1.1)localObject2).L$2 = localObject4;
      ((FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1.1)localObject2).L$3 = localObject3;
      ((FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1.1)localObject2).J$0 = l;
      ((FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1.1)localObject2).I$0 = 0;
      ((FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1.1)localObject2).label = 1;
      localObject7 = FlowKt.catchImpl(paramContinuation, (FlowCollector)localObject3, (Continuation)localObject2);
      if (localObject7 == localObject1) {
        return localObject1;
      }
      paramContinuation = (Continuation)localObject5;
      localObject5 = localObject1;
      localObject6 = localObject3;
      i = 0;
      localObject1 = paramFlowCollector;
      localObject3 = localObject4;
      localObject4 = localObject6;
      paramFlowCollector = (FlowCollector)localObject5;
      localObject7 = (Throwable)localObject7;
      if (localObject7 != null)
      {
        localObject5 = ((1)localObject1).$predicate$inlined;
        localObject6 = Boxing.boxLong(l);
        ((FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1.1)localObject2).L$0 = localObject1;
        ((FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1.1)localObject2).L$1 = paramContinuation;
        ((FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1.1)localObject2).L$2 = localObject3;
        ((FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1.1)localObject2).L$3 = localObject4;
        ((FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1.1)localObject2).J$0 = l;
        ((FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1.1)localObject2).L$4 = localObject7;
        ((FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1.1)localObject2).label = 2;
        Object localObject8 = ((Function4)localObject5).invoke(localObject4, localObject7, localObject6, localObject2);
        localObject5 = paramFlowCollector;
        localObject6 = localObject8;
        if (localObject8 == paramFlowCollector) {
          return paramFlowCollector;
        }
        label464:
        if (((Boolean)localObject6).booleanValue())
        {
          l += 1L;
          localObject6 = localObject4;
          i = 1;
          paramFlowCollector = (FlowCollector)localObject5;
          localObject4 = localObject3;
          localObject3 = localObject6;
        }
        else
        {
          throw ((Throwable)localObject7);
        }
      }
      else
      {
        localObject5 = localObject4;
        localObject4 = localObject3;
        localObject3 = localObject5;
      }
      localObject5 = paramContinuation;
      if (i == 0) {
        return Unit.INSTANCE;
      }
      paramContinuation = (Continuation)localObject1;
      localObject1 = paramFlowCollector;
      paramFlowCollector = paramContinuation;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1
 * JD-Core Version:    0.7.0.1
 */