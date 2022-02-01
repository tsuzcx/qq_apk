package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref.IntRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class FlowKt__CountKt$count$$inlined$collect$2
  implements FlowCollector<T>
{
  public FlowKt__CountKt$count$$inlined$collect$2(Function2 paramFunction2, Ref.IntRef paramIntRef) {}
  
  @Nullable
  public Object emit(Object paramObject, @NotNull Continuation paramContinuation)
  {
    if ((paramContinuation instanceof FlowKt__CountKt.count..inlined.collect.2.1))
    {
      localObject1 = (FlowKt__CountKt.count..inlined.collect.2.1)paramContinuation;
      if ((((FlowKt__CountKt.count..inlined.collect.2.1)localObject1).label & 0x80000000) != 0)
      {
        ((FlowKt__CountKt.count..inlined.collect.2.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation)localObject1;
        break label53;
      }
    }
    paramContinuation = new FlowKt__CountKt.count..inlined.collect.2.1(this, paramContinuation);
    label53:
    Object localObject1 = paramContinuation.result;
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    if (i != 0)
    {
      if (i == 1)
      {
        paramObject = paramContinuation.L$3;
        paramObject = (Continuation)paramContinuation.L$2;
        paramObject = paramContinuation.L$1;
        paramObject = (2)paramContinuation.L$0;
        ResultKt.throwOnFailure(localObject1);
        paramContinuation = (Continuation)localObject1;
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
      paramContinuation = localFunction2.invoke(paramObject, paramContinuation);
      if (paramContinuation == localObject2) {
        return localObject2;
      }
      paramObject = this;
    }
    if (((Boolean)paramContinuation).booleanValue())
    {
      paramObject = paramObject.$i$inlined;
      paramObject.element += 1;
      i = paramObject.element;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__CountKt.count..inlined.collect.2
 * JD-Core Version:    0.7.0.1
 */