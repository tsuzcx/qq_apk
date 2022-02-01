package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__DistinctKt$$special$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__DistinctKt$distinctUntilChangedBy$$inlined$unsafeFlow$1$lambda$1"}, k=1, mv={1, 1, 16})
public final class FlowKt__DistinctKt$distinctUntilChanged$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1$2
  implements FlowCollector<T>
{
  public FlowKt__DistinctKt$distinctUntilChanged$$inlined$distinctUntilChangedBy$FlowKt__DistinctKt$1$2(FlowCollector paramFlowCollector, Ref.ObjectRef paramObjectRef, FlowKt__DistinctKt.distinctUntilChanged..inlined.distinctUntilChangedBy.FlowKt__DistinctKt.1 param1) {}
  
  @Nullable
  public Object emit(Object paramObject, @NotNull Continuation paramContinuation)
  {
    if ((paramContinuation instanceof FlowKt__DistinctKt.distinctUntilChanged..inlined.distinctUntilChangedBy.FlowKt__DistinctKt.1.2.1))
    {
      localObject1 = (FlowKt__DistinctKt.distinctUntilChanged..inlined.distinctUntilChangedBy.FlowKt__DistinctKt.1.2.1)paramContinuation;
      if ((((FlowKt__DistinctKt.distinctUntilChanged..inlined.distinctUntilChangedBy.FlowKt__DistinctKt.1.2.1)localObject1).label & 0x80000000) != 0)
      {
        ((FlowKt__DistinctKt.distinctUntilChanged..inlined.distinctUntilChangedBy.FlowKt__DistinctKt.1.2.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation)localObject1;
        break label53;
      }
    }
    paramContinuation = new FlowKt__DistinctKt.distinctUntilChanged..inlined.distinctUntilChangedBy.FlowKt__DistinctKt.1.2.1(this, paramContinuation);
    label53:
    Object localObject1 = paramContinuation.result;
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    if (i != 0)
    {
      if (i == 1)
      {
        paramObject = paramContinuation.L$4;
        paramObject = paramContinuation.L$3;
        paramObject = (FlowKt__DistinctKt.distinctUntilChanged..inlined.distinctUntilChangedBy.FlowKt__DistinctKt.1.2.1)paramContinuation.L$2;
        paramObject = paramContinuation.L$1;
        paramObject = (2)paramContinuation.L$0;
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
      if ((this.$previousKey$inlined.element == NullSurrogateKt.NULL) || (!((Boolean)this.this$0.$areEquivalent$inlined.invoke(this.$previousKey$inlined.element, paramObject)).booleanValue()))
      {
        this.$previousKey$inlined.element = paramObject;
        localObject1 = this.$this_unsafeFlow$inlined;
        paramContinuation.L$0 = this;
        paramContinuation.L$1 = paramObject;
        paramContinuation.L$2 = paramContinuation;
        paramContinuation.L$3 = paramObject;
        paramContinuation.L$4 = paramObject;
        paramContinuation.label = 1;
        if (((FlowCollector)localObject1).emit(paramObject, paramContinuation) == localObject2) {
          return localObject2;
        }
      }
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__DistinctKt.distinctUntilChanged..inlined.distinctUntilChangedBy.FlowKt__DistinctKt.1.2
 * JD-Core Version:    0.7.0.1
 */