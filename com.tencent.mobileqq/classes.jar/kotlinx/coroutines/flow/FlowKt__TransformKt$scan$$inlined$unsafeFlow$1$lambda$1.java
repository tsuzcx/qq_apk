package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$9"}, k=1, mv={1, 1, 16})
public final class FlowKt__TransformKt$scan$$inlined$unsafeFlow$1$lambda$1
  implements FlowCollector<T>
{
  public FlowKt__TransformKt$scan$$inlined$unsafeFlow$1$lambda$1(FlowCollector paramFlowCollector, Ref.ObjectRef paramObjectRef, FlowKt__TransformKt.scan..inlined.unsafeFlow.1 param1) {}
  
  @Nullable
  public Object emit(Object paramObject, @NotNull Continuation paramContinuation)
  {
    Object localObject1;
    if ((paramContinuation instanceof FlowKt__TransformKt.scan..inlined.unsafeFlow.1.lambda.1.1))
    {
      localObject1 = (FlowKt__TransformKt.scan..inlined.unsafeFlow.1.lambda.1.1)paramContinuation;
      if ((((FlowKt__TransformKt.scan..inlined.unsafeFlow.1.lambda.1.1)localObject1).label & 0x80000000) != 0)
      {
        ((FlowKt__TransformKt.scan..inlined.unsafeFlow.1.lambda.1.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation)localObject1;
        break label53;
      }
    }
    paramContinuation = new FlowKt__TransformKt.scan..inlined.unsafeFlow.1.lambda.1.1(this, paramContinuation);
    label53:
    Object localObject5 = paramContinuation.result;
    Object localObject6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    Object localObject2;
    1 local1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          paramObject = paramContinuation.L$3;
          paramObject = (Continuation)paramContinuation.L$2;
          paramObject = paramContinuation.L$1;
          paramObject = (1)paramContinuation.L$0;
          ResultKt.throwOnFailure(localObject5);
          break label345;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      localObject4 = (Ref.ObjectRef)paramContinuation.L$4;
      localObject1 = paramContinuation.L$3;
      paramObject = (Continuation)paramContinuation.L$2;
      localObject2 = paramContinuation.L$1;
      local1 = (1)paramContinuation.L$0;
      ResultKt.throwOnFailure(localObject5);
    }
    else
    {
      ResultKt.throwOnFailure(localObject5);
      localObject3 = (Continuation)paramContinuation;
      localObject4 = this.$accumulator$inlined;
      localObject1 = this.this$0.$operation$inlined;
      localObject2 = this.$accumulator$inlined.element;
      paramContinuation.L$0 = this;
      paramContinuation.L$1 = paramObject;
      paramContinuation.L$2 = localObject3;
      paramContinuation.L$3 = paramObject;
      paramContinuation.L$4 = localObject4;
      paramContinuation.label = 1;
      localObject5 = ((Function3)localObject1).invoke(localObject2, paramObject, paramContinuation);
      if (localObject5 == localObject6) {
        return localObject6;
      }
      local1 = this;
      localObject1 = paramObject;
      localObject2 = paramObject;
      paramObject = localObject3;
    }
    ((Ref.ObjectRef)localObject4).element = localObject5;
    Object localObject3 = local1.$this_unsafeFlow$inlined;
    Object localObject4 = local1.$accumulator$inlined.element;
    paramContinuation.L$0 = local1;
    paramContinuation.L$1 = localObject2;
    paramContinuation.L$2 = paramObject;
    paramContinuation.L$3 = localObject1;
    paramContinuation.label = 2;
    if (((FlowCollector)localObject3).emit(localObject4, paramContinuation) == localObject6) {
      return localObject6;
    }
    label345:
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__TransformKt.scan..inlined.unsafeFlow.1.lambda.1
 * JD-Core Version:    0.7.0.1
 */