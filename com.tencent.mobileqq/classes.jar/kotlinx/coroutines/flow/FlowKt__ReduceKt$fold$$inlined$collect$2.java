package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class FlowKt__ReduceKt$fold$$inlined$collect$2
  implements FlowCollector<T>
{
  public FlowKt__ReduceKt$fold$$inlined$collect$2(Ref.ObjectRef paramObjectRef, Function3 paramFunction3) {}
  
  @Nullable
  public Object emit(Object paramObject, @NotNull Continuation paramContinuation)
  {
    if ((paramContinuation instanceof FlowKt__ReduceKt.fold..inlined.collect.2.1))
    {
      localObject1 = (FlowKt__ReduceKt.fold..inlined.collect.2.1)paramContinuation;
      if ((((FlowKt__ReduceKt.fold..inlined.collect.2.1)localObject1).label & 0x80000000) != 0)
      {
        ((FlowKt__ReduceKt.fold..inlined.collect.2.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation)localObject1;
        break label53;
      }
    }
    paramContinuation = new FlowKt__ReduceKt.fold..inlined.collect.2.1(this, paramContinuation);
    label53:
    Object localObject1 = paramContinuation.result;
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    if (i != 0)
    {
      if (i == 1)
      {
        paramObject = (Ref.ObjectRef)paramContinuation.L$4;
        localObject2 = paramContinuation.L$3;
        localObject2 = (Continuation)paramContinuation.L$2;
        localObject2 = paramContinuation.L$1;
        paramContinuation = (2)paramContinuation.L$0;
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
      Continuation localContinuation = (Continuation)paramContinuation;
      localObject1 = this.$accumulator$inlined;
      Function3 localFunction3 = this.$operation$inlined;
      Object localObject3 = ((Ref.ObjectRef)localObject1).element;
      paramContinuation.L$0 = this;
      paramContinuation.L$1 = paramObject;
      paramContinuation.L$2 = localContinuation;
      paramContinuation.L$3 = paramObject;
      paramContinuation.L$4 = localObject1;
      paramContinuation.label = 1;
      paramContinuation = localFunction3.invoke(localObject3, paramObject, paramContinuation);
      if (paramContinuation == localObject2) {
        return localObject2;
      }
      paramObject = localObject1;
    }
    paramObject.element = paramContinuation;
    return Unit.INSTANCE;
  }
  
  @Nullable
  public Object emit$$forInline(Object paramObject, @NotNull Continuation paramContinuation)
  {
    InlineMarker.mark(4);
    new FlowKt__ReduceKt.fold..inlined.collect.2.1(this, paramContinuation);
    InlineMarker.mark(5);
    Ref.ObjectRef localObjectRef = this.$accumulator$inlined;
    localObjectRef.element = this.$operation$inlined.invoke(localObjectRef.element, paramObject, paramContinuation);
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ReduceKt.fold..inlined.collect.2
 * JD-Core Version:    0.7.0.1
 */