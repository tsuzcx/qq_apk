package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__DelayKt$debounce$2$1$2$1", "kotlinx/coroutines/flow/FlowKt__DelayKt$debounce$2$$special$$inlined$let$lambda$1"}, k=3, mv={1, 1, 16})
final class FlowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$2
  extends SuspendLambda
  implements Function1<Continuation<? super Unit>, Object>
{
  int label;
  
  FlowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$2(Object paramObject, Continuation paramContinuation, SelectBuilder paramSelectBuilder, FlowKt__DelayKt.debounce.2 param2, ReceiveChannel paramReceiveChannel, Ref.ObjectRef paramObjectRef, FlowCollector paramFlowCollector)
  {
    super(1, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@NotNull Continuation<?> paramContinuation)
  {
    return new 2(this.$value, paramContinuation, this.$this_select$inlined, this.this$0, this.$values$inlined, this.$lastValue$inlined, this.$downstream$inlined);
  }
  
  public final Object invoke(Object paramObject)
  {
    return ((2)create((Continuation)paramObject)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    if (i != 0)
    {
      if (i == 1) {
        ResultKt.throwOnFailure(paramObject);
      } else {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      Object localObject1 = this.$lastValue$inlined;
      paramObject = null;
      ((Ref.ObjectRef)localObject1).element = null;
      FlowCollector localFlowCollector = this.$downstream$inlined;
      Symbol localSymbol = NullSurrogateKt.NULL;
      localObject1 = this.$value;
      if (localObject1 != localSymbol) {
        paramObject = localObject1;
      }
      this.label = 1;
      if (localFlowCollector.emit(paramObject, this) == localObject2) {
        return localObject2;
      }
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__DelayKt.debounce.2.invokeSuspend..inlined.select.lambda.2
 * JD-Core Version:    0.7.0.1
 */