package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref.BooleanRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__LimitKt$$special$$inlined$collect$2"}, k=1, mv={1, 1, 16})
public final class FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1
  implements FlowCollector<T>
{
  public FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1(FlowCollector paramFlowCollector, Ref.BooleanRef paramBooleanRef, FlowKt__LimitKt.dropWhile..inlined.unsafeFlow.1 param1) {}
  
  @Nullable
  public Object emit(Object paramObject, @NotNull Continuation paramContinuation)
  {
    Object localObject1;
    if ((paramContinuation instanceof FlowKt__LimitKt.dropWhile..inlined.unsafeFlow.1.lambda.1.1))
    {
      localObject1 = (FlowKt__LimitKt.dropWhile..inlined.unsafeFlow.1.lambda.1.1)paramContinuation;
      if ((((FlowKt__LimitKt.dropWhile..inlined.unsafeFlow.1.lambda.1.1)localObject1).label & 0x80000000) != 0)
      {
        ((FlowKt__LimitKt.dropWhile..inlined.unsafeFlow.1.lambda.1.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation)localObject1;
        break label53;
      }
    }
    paramContinuation = new FlowKt__LimitKt.dropWhile..inlined.unsafeFlow.1.lambda.1.1(this, paramContinuation);
    label53:
    Object localObject3 = paramContinuation.result;
    Object localObject4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    Object localObject2;
    1 local1;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          }
        }
        else
        {
          localObject2 = paramContinuation.L$3;
          paramObject = (Continuation)paramContinuation.L$2;
          localObject1 = paramContinuation.L$1;
          local1 = (1)paramContinuation.L$0;
          ResultKt.throwOnFailure(localObject3);
          break label310;
        }
      }
      paramObject = paramContinuation.L$3;
      paramObject = (Continuation)paramContinuation.L$2;
      paramObject = paramContinuation.L$1;
      paramObject = (1)paramContinuation.L$0;
      ResultKt.throwOnFailure(localObject3);
      break label383;
    }
    else
    {
      ResultKt.throwOnFailure(localObject3);
      Continuation localContinuation = (Continuation)paramContinuation;
      if (this.$matched$inlined.element)
      {
        localObject1 = this.$this_unsafeFlow$inlined;
        paramContinuation.L$0 = this;
        paramContinuation.L$1 = paramObject;
        paramContinuation.L$2 = localContinuation;
        paramContinuation.L$3 = paramObject;
        paramContinuation.label = 1;
        if (((FlowCollector)localObject1).emit(paramObject, paramContinuation) != localObject4) {
          break label383;
        }
        return localObject4;
      }
      localObject1 = this.this$0.$predicate$inlined;
      paramContinuation.L$0 = this;
      paramContinuation.L$1 = paramObject;
      paramContinuation.L$2 = localContinuation;
      paramContinuation.L$3 = paramObject;
      paramContinuation.label = 2;
      localObject3 = ((Function2)localObject1).invoke(paramObject, paramContinuation);
      if (localObject3 == localObject4) {
        return localObject4;
      }
      local1 = this;
      localObject1 = paramObject;
      localObject2 = paramObject;
      paramObject = localContinuation;
    }
    label310:
    if (!((Boolean)localObject3).booleanValue())
    {
      local1.$matched$inlined.element = true;
      localObject3 = local1.$this_unsafeFlow$inlined;
      paramContinuation.L$0 = local1;
      paramContinuation.L$1 = localObject1;
      paramContinuation.L$2 = paramObject;
      paramContinuation.L$3 = localObject2;
      paramContinuation.label = 3;
      if (((FlowCollector)localObject3).emit(localObject2, paramContinuation) == localObject4) {
        return localObject4;
      }
    }
    label383:
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__LimitKt.dropWhile..inlined.unsafeFlow.1.lambda.1
 * JD-Core Version:    0.7.0.1
 */