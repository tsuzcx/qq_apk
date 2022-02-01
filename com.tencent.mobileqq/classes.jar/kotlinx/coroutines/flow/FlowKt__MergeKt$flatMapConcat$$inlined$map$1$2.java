package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__MergeKt$$special$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$1$lambda$1", "kotlinx/coroutines/flow/FlowKt__MergeKt$map$$inlined$unsafeTransform$1$2"}, k=1, mv={1, 1, 16})
public final class FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2
  implements FlowCollector<T>
{
  public FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2(FlowCollector paramFlowCollector, FlowKt__MergeKt.flatMapConcat..inlined.map.1 param1) {}
  
  @Nullable
  public Object emit(Object paramObject, @NotNull Continuation paramContinuation)
  {
    Object localObject1;
    if ((paramContinuation instanceof FlowKt__MergeKt.flatMapConcat..inlined.map.1.2.1))
    {
      localObject1 = (FlowKt__MergeKt.flatMapConcat..inlined.map.1.2.1)paramContinuation;
      if ((((FlowKt__MergeKt.flatMapConcat..inlined.map.1.2.1)localObject1).label & 0x80000000) != 0)
      {
        ((FlowKt__MergeKt.flatMapConcat..inlined.map.1.2.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation)localObject1;
        break label53;
      }
    }
    paramContinuation = new FlowKt__MergeKt.flatMapConcat..inlined.map.1.2.1(this, paramContinuation);
    label53:
    Object localObject7 = paramContinuation.result;
    Object localObject9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    Object localObject6;
    Object localObject4;
    Object localObject2;
    Object localObject3;
    Object localObject5;
    2 local2;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          paramObject = (FlowCollector)paramContinuation.L$6;
          paramObject = paramContinuation.L$5;
          paramObject = (FlowKt__MergeKt.flatMapConcat..inlined.map.1.2.1)paramContinuation.L$4;
          paramObject = paramContinuation.L$3;
          paramObject = (FlowKt__MergeKt.flatMapConcat..inlined.map.1.2.1)paramContinuation.L$2;
          paramObject = paramContinuation.L$1;
          paramObject = (2)paramContinuation.L$0;
          ResultKt.throwOnFailure(localObject7);
          break label399;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      localObject6 = (FlowCollector)paramContinuation.L$7;
      localObject4 = (FlowCollector)paramContinuation.L$6;
      paramObject = paramContinuation.L$5;
      localObject2 = (FlowKt__MergeKt.flatMapConcat..inlined.map.1.2.1)paramContinuation.L$4;
      localObject1 = paramContinuation.L$3;
      localObject3 = (FlowKt__MergeKt.flatMapConcat..inlined.map.1.2.1)paramContinuation.L$2;
      localObject5 = paramContinuation.L$1;
      local2 = (2)paramContinuation.L$0;
      ResultKt.throwOnFailure(localObject7);
    }
    else
    {
      ResultKt.throwOnFailure(localObject7);
      localObject3 = this.$this_unsafeFlow$inlined;
      localObject1 = this.this$0.$transform$inlined$1;
      paramContinuation.L$0 = this;
      paramContinuation.L$1 = paramObject;
      paramContinuation.L$2 = paramContinuation;
      paramContinuation.L$3 = paramObject;
      paramContinuation.L$4 = paramContinuation;
      paramContinuation.L$5 = paramObject;
      paramContinuation.L$6 = localObject3;
      paramContinuation.L$7 = localObject3;
      paramContinuation.label = 1;
      localObject7 = ((Function2)localObject1).invoke(paramObject, paramContinuation);
      if (localObject7 == localObject9) {
        return localObject9;
      }
      local2 = this;
      localObject1 = paramObject;
      localObject5 = localObject1;
      localObject2 = paramContinuation;
      Object localObject8 = localObject2;
      localObject4 = localObject3;
      localObject6 = localObject3;
      localObject3 = localObject8;
    }
    paramContinuation.L$0 = local2;
    paramContinuation.L$1 = localObject5;
    paramContinuation.L$2 = localObject3;
    paramContinuation.L$3 = localObject1;
    paramContinuation.L$4 = localObject2;
    paramContinuation.L$5 = paramObject;
    paramContinuation.L$6 = localObject4;
    paramContinuation.label = 2;
    if (((FlowCollector)localObject6).emit(localObject7, paramContinuation) == localObject9) {
      return localObject9;
    }
    label399:
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__MergeKt.flatMapConcat..inlined.map.1.2
 * JD-Core Version:    0.7.0.1
 */