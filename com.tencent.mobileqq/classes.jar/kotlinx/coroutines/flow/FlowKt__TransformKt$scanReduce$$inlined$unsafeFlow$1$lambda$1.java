package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$10"}, k=1, mv={1, 1, 16})
public final class FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1
  implements FlowCollector<T>
{
  public FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1$lambda$1(FlowCollector paramFlowCollector, Ref.ObjectRef paramObjectRef, FlowKt__TransformKt.scanReduce..inlined.unsafeFlow.1 param1) {}
  
  @Nullable
  public Object emit(Object paramObject, @NotNull Continuation paramContinuation)
  {
    if ((paramContinuation instanceof FlowKt__TransformKt.scanReduce..inlined.unsafeFlow.1.lambda.1.1))
    {
      local11 = (FlowKt__TransformKt.scanReduce..inlined.unsafeFlow.1.lambda.1.1)paramContinuation;
      if ((local11.label & 0x80000000) != 0)
      {
        local11.label += -2147483648;
        break label51;
      }
    }
    FlowKt__TransformKt.scanReduce..inlined.unsafeFlow.1.lambda.1.1 local11 = new FlowKt__TransformKt.scanReduce..inlined.unsafeFlow.1.lambda.1.1(this, paramContinuation);
    label51:
    paramContinuation = local11.result;
    Object localObject4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = local11.label;
    Continuation localContinuation;
    Object localObject1;
    1 local1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          paramObject = local11.L$3;
          paramObject = (Continuation)local11.L$2;
          paramObject = local11.L$1;
          paramObject = (1)local11.L$0;
          ResultKt.throwOnFailure(paramContinuation);
          break label384;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      localObject2 = (Ref.ObjectRef)local11.L$4;
      Object localObject3 = local11.L$3;
      localContinuation = (Continuation)local11.L$2;
      localObject1 = local11.L$1;
      local1 = (1)local11.L$0;
      ResultKt.throwOnFailure(paramContinuation);
      paramObject = paramContinuation;
      paramContinuation = localObject3;
    }
    else
    {
      ResultKt.throwOnFailure(paramContinuation);
      localContinuation = (Continuation)local11;
      localObject2 = this.$accumulator$inlined;
      if (((Ref.ObjectRef)localObject2).element == NullSurrogateKt.NULL)
      {
        local1 = this;
        paramContinuation = paramObject;
        localObject1 = paramContinuation;
      }
      else
      {
        paramContinuation = this.this$0.$operation$inlined;
        localObject1 = this.$accumulator$inlined.element;
        local11.L$0 = this;
        local11.L$1 = paramObject;
        local11.L$2 = localContinuation;
        local11.L$3 = paramObject;
        local11.L$4 = localObject2;
        local11.label = 1;
        paramContinuation = paramContinuation.invoke(localObject1, paramObject, local11);
        if (paramContinuation == localObject4) {
          return localObject4;
        }
        local1 = this;
        localObject1 = paramObject;
        paramObject = paramContinuation;
        paramContinuation = (Continuation)localObject1;
      }
    }
    ((Ref.ObjectRef)localObject2).element = paramObject;
    paramObject = local1.$this_unsafeFlow$inlined;
    Object localObject2 = local1.$accumulator$inlined.element;
    local11.L$0 = local1;
    local11.L$1 = localObject1;
    local11.L$2 = localContinuation;
    local11.L$3 = paramContinuation;
    local11.label = 2;
    if (paramObject.emit(localObject2, local11) == localObject4) {
      return localObject4;
    }
    label384:
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__TransformKt.scanReduce..inlined.unsafeFlow.1.lambda.1
 * JD-Core Version:    0.7.0.1
 */