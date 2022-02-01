package kotlinx.coroutines.flow;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$1"}, k=3, mv={1, 1, 16})
final class FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$1
  extends SuspendLambda
  implements Function2<Object, Continuation<? super Unit>, Object>
{
  int label;
  private Object p$0;
  
  FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$1(Continuation paramContinuation, ReceiveChannel paramReceiveChannel1, ReceiveChannel paramReceiveChannel2, Ref.ObjectRef paramObjectRef, FlowCollector paramFlowCollector)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 1(paramContinuation, this.$values$inlined, this.$ticker$inlined, this.$lastValue$inlined, this.$downstream$inlined);
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
    IntrinsicsKt.getCOROUTINE_SUSPENDED();
    if (this.label == 0)
    {
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.p$0;
      if (paramObject == null)
      {
        this.$ticker$inlined.cancel((CancellationException)new ChildCancelledException());
        this.$lastValue$inlined.element = NullSurrogateKt.DONE;
      }
      else
      {
        this.$lastValue$inlined.element = paramObject;
      }
      return Unit.INSTANCE;
    }
    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2.invokeSuspend..inlined.select.lambda.1
 * JD-Core Version:    0.7.0.1
 */