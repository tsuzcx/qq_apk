package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.NopCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class FlowKt__ReduceKt$first$$inlined$collect$2
  implements FlowCollector<T>
{
  public FlowKt__ReduceKt$first$$inlined$collect$2(Function2 paramFunction2, Ref.ObjectRef paramObjectRef) {}
  
  @Nullable
  public Object emit(Object paramObject, @NotNull Continuation paramContinuation)
  {
    if ((paramContinuation instanceof FlowKt__ReduceKt.first..inlined.collect.2.1))
    {
      localObject1 = (FlowKt__ReduceKt.first..inlined.collect.2.1)paramContinuation;
      if ((((FlowKt__ReduceKt.first..inlined.collect.2.1)localObject1).label & 0x80000000) != 0)
      {
        ((FlowKt__ReduceKt.first..inlined.collect.2.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation)localObject1;
        break label53;
      }
    }
    paramContinuation = new FlowKt__ReduceKt.first..inlined.collect.2.1(this, paramContinuation);
    label53:
    Object localObject1 = paramContinuation.result;
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    if (i != 0)
    {
      if (i == 1)
      {
        paramObject = paramContinuation.L$3;
        localObject2 = (Continuation)paramContinuation.L$2;
        localObject2 = paramContinuation.L$1;
        paramContinuation = (2)paramContinuation.L$0;
        ResultKt.throwOnFailure(localObject1);
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(localObject1);
      localObject1 = (Continuation)paramContinuation;
      Function2 localFunction2 = this.$predicate$inlined;
      paramContinuation.L$0 = this;
      paramContinuation.L$1 = paramObject;
      paramContinuation.L$2 = localObject1;
      paramContinuation.L$3 = paramObject;
      paramContinuation.label = 1;
      localObject1 = localFunction2.invoke(paramObject, paramContinuation);
      if (localObject1 == localObject2) {
        return localObject2;
      }
      paramContinuation = this;
    }
    if (!((Boolean)localObject1).booleanValue()) {
      return Unit.INSTANCE;
    }
    paramContinuation.$result$inlined.element = paramObject;
    throw ((Throwable)new AbortFlowException((FlowCollector)NopCollector.INSTANCE));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ReduceKt.first..inlined.collect.2
 * JD-Core Version:    0.7.0.1
 */