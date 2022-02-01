package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$8", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$7$lambda$1"}, k=1, mv={1, 1, 16})
public final class FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2
  implements FlowCollector<T>
{
  public FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2(FlowCollector paramFlowCollector, FlowKt__TransformKt.onEach..inlined.unsafeTransform.1 param1) {}
  
  @Nullable
  public Object emit(Object paramObject, @NotNull Continuation paramContinuation)
  {
    Object localObject1;
    if ((paramContinuation instanceof FlowKt__TransformKt.onEach..inlined.unsafeTransform.1.2.1))
    {
      localObject1 = (FlowKt__TransformKt.onEach..inlined.unsafeTransform.1.2.1)paramContinuation;
      if ((((FlowKt__TransformKt.onEach..inlined.unsafeTransform.1.2.1)localObject1).label & 0x80000000) != 0)
      {
        ((FlowKt__TransformKt.onEach..inlined.unsafeTransform.1.2.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation)localObject1;
        break label53;
      }
    }
    paramContinuation = new FlowKt__TransformKt.onEach..inlined.unsafeTransform.1.2.1(this, paramContinuation);
    label53:
    Object localObject4 = paramContinuation.result;
    Object localObject5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    FlowCollector localFlowCollector;
    Object localObject2;
    Continuation localContinuation;
    Object localObject3;
    2 local2;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          paramObject = (FlowCollector)paramContinuation.L$6;
          paramObject = paramContinuation.L$5;
          paramObject = (Continuation)paramContinuation.L$4;
          paramObject = paramContinuation.L$3;
          paramObject = (FlowKt__TransformKt.onEach..inlined.unsafeTransform.1.2.1)paramContinuation.L$2;
          paramObject = paramContinuation.L$1;
          paramObject = (2)paramContinuation.L$0;
          ResultKt.throwOnFailure(localObject4);
          break label379;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      localFlowCollector = (FlowCollector)paramContinuation.L$6;
      localObject2 = paramContinuation.L$5;
      localContinuation = (Continuation)paramContinuation.L$4;
      paramObject = paramContinuation.L$3;
      localObject1 = (FlowKt__TransformKt.onEach..inlined.unsafeTransform.1.2.1)paramContinuation.L$2;
      localObject3 = paramContinuation.L$1;
      local2 = (2)paramContinuation.L$0;
      ResultKt.throwOnFailure(localObject4);
    }
    else
    {
      ResultKt.throwOnFailure(localObject4);
      localFlowCollector = this.$this_unsafeFlow$inlined;
      localContinuation = (Continuation)paramContinuation;
      localObject1 = this.this$0.$action$inlined;
      paramContinuation.L$0 = this;
      paramContinuation.L$1 = paramObject;
      paramContinuation.L$2 = paramContinuation;
      paramContinuation.L$3 = paramObject;
      paramContinuation.L$4 = localContinuation;
      paramContinuation.L$5 = paramObject;
      paramContinuation.L$6 = localFlowCollector;
      paramContinuation.label = 1;
      if (((Function2)localObject1).invoke(paramObject, paramContinuation) == localObject5) {
        return localObject5;
      }
      local2 = this;
      localObject1 = paramObject;
      localObject4 = paramContinuation;
      localObject2 = localObject1;
      localObject3 = localObject1;
      localObject1 = localObject4;
    }
    paramContinuation.L$0 = local2;
    paramContinuation.L$1 = localObject3;
    paramContinuation.L$2 = localObject1;
    paramContinuation.L$3 = paramObject;
    paramContinuation.L$4 = localContinuation;
    paramContinuation.L$5 = localObject2;
    paramContinuation.L$6 = localFlowCollector;
    paramContinuation.label = 2;
    if (localFlowCollector.emit(localObject2, paramContinuation) == localObject5) {
      return localObject5;
    }
    label379:
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__TransformKt.onEach..inlined.unsafeTransform.1.2
 * JD-Core Version:    0.7.0.1
 */