package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1
  implements Flow<T>
{
  public FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1(Object[] paramArrayOfObject) {}
  
  @Nullable
  public Object collect(@NotNull FlowCollector paramFlowCollector, @NotNull Continuation paramContinuation)
  {
    if ((paramContinuation instanceof FlowKt__BuildersKt.flowOf..inlined.unsafeFlow.1.1))
    {
      localObject1 = (FlowKt__BuildersKt.flowOf..inlined.unsafeFlow.1.1)paramContinuation;
      if ((((FlowKt__BuildersKt.flowOf..inlined.unsafeFlow.1.1)localObject1).label & 0x80000000) != 0)
      {
        ((FlowKt__BuildersKt.flowOf..inlined.unsafeFlow.1.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation)localObject1;
        break label53;
      }
    }
    paramContinuation = new FlowKt__BuildersKt.flowOf..inlined.unsafeFlow.1.1(this, paramContinuation);
    label53:
    Object localObject3 = paramContinuation.result;
    Object localObject1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    int j;
    Object[] arrayOfObject;
    Object localObject2;
    Continuation localContinuation1;
    FlowCollector localFlowCollector;
    Object localObject4;
    Continuation localContinuation2;
    if (i != 0)
    {
      if (i == 1)
      {
        paramFlowCollector = paramContinuation.L$5;
        i = paramContinuation.I$1;
        j = paramContinuation.I$0;
        arrayOfObject = (Object[])paramContinuation.L$4;
        localObject2 = (FlowCollector)paramContinuation.L$3;
        localContinuation1 = (Continuation)paramContinuation.L$2;
        localFlowCollector = (FlowCollector)paramContinuation.L$1;
        paramFlowCollector = (1)paramContinuation.L$0;
        ResultKt.throwOnFailure(localObject3);
        localObject3 = localObject1;
        localObject4 = localObject2;
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(localObject3);
      localContinuation1 = (Continuation)paramContinuation;
      arrayOfObject = this.$elements$inlined;
      j = arrayOfObject.length;
      localObject2 = localObject1;
      localObject3 = this;
      localObject1 = paramFlowCollector;
      i = 0;
      localFlowCollector = paramFlowCollector;
      paramFlowCollector = (FlowCollector)localObject3;
      localContinuation2 = paramContinuation;
    }
    while (i < j)
    {
      Object localObject5 = arrayOfObject[i];
      localContinuation2.L$0 = paramFlowCollector;
      localContinuation2.L$1 = localFlowCollector;
      localContinuation2.L$2 = localContinuation1;
      localContinuation2.L$3 = localObject1;
      localContinuation2.L$4 = arrayOfObject;
      localContinuation2.I$0 = j;
      localContinuation2.I$1 = i;
      localContinuation2.L$5 = localObject5;
      localContinuation2.label = 1;
      paramContinuation = localContinuation2;
      localObject3 = localObject2;
      localObject4 = localObject1;
      if (((FlowCollector)localObject1).emit(localObject5, localContinuation2) == localObject2) {
        return localObject2;
      }
      i += 1;
      localContinuation2 = paramContinuation;
      localObject2 = localObject3;
      localObject1 = localObject4;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__BuildersKt.flowOf..inlined.unsafeFlow.1
 * JD-Core Version:    0.7.0.1
 */