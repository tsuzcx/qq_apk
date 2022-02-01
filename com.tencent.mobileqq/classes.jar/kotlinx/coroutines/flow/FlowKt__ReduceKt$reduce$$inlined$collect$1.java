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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class FlowKt__ReduceKt$reduce$$inlined$collect$1
  implements FlowCollector<T>
{
  public FlowKt__ReduceKt$reduce$$inlined$collect$1(Ref.ObjectRef paramObjectRef, Function3 paramFunction3) {}
  
  @Nullable
  public Object emit(Object paramObject, @NotNull Continuation paramContinuation)
  {
    if ((paramContinuation instanceof FlowKt__ReduceKt.reduce..inlined.collect.1.1))
    {
      local1 = (FlowKt__ReduceKt.reduce..inlined.collect.1.1)paramContinuation;
      if ((local1.label & 0x80000000) != 0)
      {
        local1.label += -2147483648;
        break label51;
      }
    }
    FlowKt__ReduceKt.reduce..inlined.collect.1.1 local1 = new FlowKt__ReduceKt.reduce..inlined.collect.1.1(this, paramContinuation);
    label51:
    paramContinuation = local1.result;
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = local1.label;
    Object localObject1;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject1 = (Ref.ObjectRef)local1.L$4;
        paramObject = local1.L$3;
        paramObject = (Continuation)local1.L$2;
        paramObject = local1.L$1;
        paramObject = (1)local1.L$0;
        ResultKt.throwOnFailure(paramContinuation);
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(paramContinuation);
      Continuation localContinuation = (Continuation)local1;
      Ref.ObjectRef localObjectRef = this.$accumulator$inlined;
      localObject1 = localObjectRef;
      paramContinuation = paramObject;
      if (localObjectRef.element != NullSurrogateKt.NULL)
      {
        paramContinuation = this.$operation$inlined;
        localObject1 = this.$accumulator$inlined.element;
        local1.L$0 = this;
        local1.L$1 = paramObject;
        local1.L$2 = localContinuation;
        local1.L$3 = paramObject;
        local1.L$4 = localObjectRef;
        local1.label = 1;
        paramObject = paramContinuation.invoke(localObject1, paramObject, local1);
        localObject1 = localObjectRef;
        paramContinuation = paramObject;
        if (paramObject == localObject2) {
          return localObject2;
        }
      }
    }
    ((Ref.ObjectRef)localObject1).element = paramContinuation;
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ReduceKt.reduce..inlined.collect.1
 * JD-Core Version:    0.7.0.1
 */