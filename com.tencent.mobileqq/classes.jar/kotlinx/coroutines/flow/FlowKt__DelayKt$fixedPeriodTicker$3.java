package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$3", f="Delay.kt", i={0, 1, 2}, l={129, 131, 132}, m="invokeSuspend", n={"$this$produce", "$this$produce", "$this$produce"}, s={"L$0", "L$0", "L$0"})
final class FlowKt__DelayKt$fixedPeriodTicker$3
  extends SuspendLambda
  implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object>
{
  Object L$0;
  int label;
  private ProducerScope p$;
  
  FlowKt__DelayKt$fixedPeriodTicker$3(long paramLong1, long paramLong2, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 3(this.$initialDelayMillis, this.$delayMillis, paramContinuation);
    paramContinuation.p$ = ((ProducerScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((3)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    label58:
    Object localObject2;
    long l;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          break label58;
        }
        if (i != 3) {}
      }
      else
      {
        localObject1 = (ProducerScope)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject1;
        break label117;
      }
      throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      localObject1 = (ProducerScope)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      localObject2 = this;
      paramObject = localObject1;
      break label168;
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.p$;
      l = this.$initialDelayMillis;
      this.L$0 = paramObject;
      this.label = 1;
      if (DelayKt.delay(l, this) == localObject3) {
        return localObject3;
      }
    }
    label117:
    Object localObject1 = this;
    label168:
    do
    {
      SendChannel localSendChannel = paramObject.getChannel();
      Unit localUnit = Unit.INSTANCE;
      ((3)localObject1).L$0 = paramObject;
      ((3)localObject1).label = 2;
      localObject2 = localObject1;
      if (localSendChannel.send(localUnit, (Continuation)localObject1) == localObject3) {
        return localObject3;
      }
      l = ((3)localObject2).$delayMillis;
      ((3)localObject2).L$0 = paramObject;
      ((3)localObject2).label = 3;
      localObject1 = localObject2;
    } while (DelayKt.delay(l, (Continuation)localObject2) != localObject3);
    return localObject3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__DelayKt.fixedPeriodTicker.3
 * JD-Core Version:    0.7.0.1
 */