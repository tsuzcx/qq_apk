package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__DelayKt$debounce$2$1$1"}, k=3, mv={1, 1, 16})
final class FlowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$1
  extends SuspendLambda
  implements Function2<Object, Continuation<? super Unit>, Object>
{
  Object L$0;
  int label;
  private Object p$0;
  
  FlowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$1(Continuation paramContinuation, FlowKt__DelayKt.debounce.2 param2, ReceiveChannel paramReceiveChannel, Ref.ObjectRef paramObjectRef, FlowCollector paramFlowCollector)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 1(paramContinuation, this.this$0, this.$values$inlined, this.$lastValue$inlined, this.$downstream$inlined);
    paramContinuation.p$0 = paramObject;
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((1)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    Object localObject1;
    Object localObject3;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject1 = this.L$0;
        ResultKt.throwOnFailure(paramObject);
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      localObject3 = this.p$0;
      if (localObject3 != null) {
        break label136;
      }
      if (this.$lastValue$inlined.element != null)
      {
        FlowCollector localFlowCollector = this.$downstream$inlined;
        Symbol localSymbol = NullSurrogateKt.NULL;
        localObject1 = this.$lastValue$inlined.element;
        paramObject = localObject1;
        if (localObject1 == localSymbol) {
          paramObject = null;
        }
        this.L$0 = localObject3;
        this.label = 1;
        if (localFlowCollector.emit(paramObject, this) == localObject2) {
          return localObject2;
        }
      }
    }
    this.$lastValue$inlined.element = NullSurrogateKt.DONE;
    break label145;
    label136:
    this.$lastValue$inlined.element = localObject3;
    label145:
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__DelayKt.debounce.2.invokeSuspend..inlined.select.lambda.1
 * JD-Core Version:    0.7.0.1
 */