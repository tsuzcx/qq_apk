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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$2"}, k=3, mv={1, 1, 16})
final class FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2
  extends SuspendLambda
  implements Function2<Unit, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  int label;
  private Unit p$0;
  
  FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2(Continuation paramContinuation, ReceiveChannel paramReceiveChannel1, ReceiveChannel paramReceiveChannel2, Ref.ObjectRef paramObjectRef, FlowCollector paramFlowCollector)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 2(paramContinuation, this.$values$inlined, this.$ticker$inlined, this.$lastValue$inlined, this.$downstream$inlined);
    paramContinuation.p$0 = ((Unit)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((2)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    Object localObject1;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject1 = this.L$1;
        localObject1 = (Unit)this.L$0;
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
      Unit localUnit = this.p$0;
      localObject1 = this.$lastValue$inlined.element;
      if (localObject1 == null) {
        break label140;
      }
      Object localObject3 = this.$lastValue$inlined;
      paramObject = null;
      ((Ref.ObjectRef)localObject3).element = null;
      localObject3 = this.$downstream$inlined;
      if (localObject1 != NullSurrogateKt.NULL) {
        paramObject = localObject1;
      }
      this.L$0 = localUnit;
      this.L$1 = localObject1;
      this.label = 1;
      if (((FlowCollector)localObject3).emit(paramObject, this) == localObject2) {
        return localObject2;
      }
    }
    return Unit.INSTANCE;
    label140:
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2.invokeSuspend..inlined.select.lambda.2
 * JD-Core Version:    0.7.0.1
 */