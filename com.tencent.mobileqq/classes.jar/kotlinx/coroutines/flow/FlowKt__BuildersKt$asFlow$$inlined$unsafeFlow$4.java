package kotlinx.coroutines.flow;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4
  implements Flow<T>
{
  public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4(Iterator paramIterator) {}
  
  @Nullable
  public Object collect(@NotNull FlowCollector paramFlowCollector, @NotNull Continuation paramContinuation)
  {
    if ((paramContinuation instanceof FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.4.1))
    {
      local1 = (FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.4.1)paramContinuation;
      if ((local1.label & 0x80000000) != 0)
      {
        local1.label += -2147483648;
        break label51;
      }
    }
    FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.4.1 local1 = new FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.4.1(this, paramContinuation);
    label51:
    Object localObject3 = local1.result;
    Object localObject4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = local1.label;
    Object localObject2;
    Object localObject1;
    Continuation localContinuation;
    FlowCollector localFlowCollector;
    if (i != 0)
    {
      if (i == 1)
      {
        paramFlowCollector = local1.L$7;
        paramFlowCollector = local1.L$6;
        localObject2 = (Iterator)local1.L$5;
        localObject1 = (Iterator)local1.L$4;
        paramFlowCollector = (FlowCollector)local1.L$3;
        localContinuation = (Continuation)local1.L$2;
        localFlowCollector = (FlowCollector)local1.L$1;
        paramContinuation = (4)local1.L$0;
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
      localContinuation = (Continuation)local1;
      paramContinuation = this.$this_asFlow$inlined;
      localObject3 = this;
      localFlowCollector = paramFlowCollector;
      localObject2 = paramContinuation;
      localObject1 = paramContinuation;
      paramContinuation = (Continuation)localObject3;
    }
    Object localObject5;
    do
    {
      localObject3 = localObject4;
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject5 = ((Iterator)localObject2).next();
      local1.L$0 = paramContinuation;
      local1.L$1 = localFlowCollector;
      local1.L$2 = localContinuation;
      local1.L$3 = paramFlowCollector;
      local1.L$4 = localObject1;
      local1.L$5 = localObject2;
      local1.L$6 = localObject5;
      local1.L$7 = localObject5;
      local1.label = 1;
    } while (paramFlowCollector.emit(localObject5, local1) != localObject3);
    return localObject3;
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__BuildersKt.asFlow..inlined.unsafeFlow.4
 * JD-Core Version:    0.7.0.1
 */