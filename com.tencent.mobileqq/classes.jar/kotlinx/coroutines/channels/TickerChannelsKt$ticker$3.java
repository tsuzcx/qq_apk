package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", f="TickerChannels.kt", i={0, 1}, l={72, 73}, m="invokeSuspend", n={"$this$produce", "$this$produce"}, s={"L$0", "L$0"})
final class TickerChannelsKt$ticker$3
  extends SuspendLambda
  implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object>
{
  Object L$0;
  int label;
  private ProducerScope p$;
  
  TickerChannelsKt$ticker$3(TickerMode paramTickerMode, long paramLong1, long paramLong2, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 3(this.$mode, this.$delayMillis, this.$initialDelayMillis, paramContinuation);
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
    Object localObject1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    if (i != 0)
    {
      if ((i == 1) || (i == 2))
      {
        localObject1 = (ProducerScope)this.L$0;
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
      paramObject = this.p$;
      Object localObject2 = this.$mode;
      i = TickerChannelsKt.WhenMappings.$EnumSwitchMapping$0[localObject2.ordinal()];
      long l1;
      long l2;
      if (i != 1)
      {
        if (i == 2)
        {
          l1 = this.$delayMillis;
          l2 = this.$initialDelayMillis;
          localObject2 = paramObject.getChannel();
          this.L$0 = paramObject;
          this.label = 2;
          if (TickerChannelsKt.fixedDelayTicker(l1, l2, (SendChannel)localObject2, this) == localObject1) {
            return localObject1;
          }
        }
      }
      else
      {
        l1 = this.$delayMillis;
        l2 = this.$initialDelayMillis;
        localObject2 = paramObject.getChannel();
        this.L$0 = paramObject;
        this.label = 1;
        if (TickerChannelsKt.fixedPeriodTicker(l1, l2, (SendChannel)localObject2, this) == localObject1) {
          return localObject1;
        }
      }
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.TickerChannelsKt.ticker.3
 * JD-Core Version:    0.7.0.1
 */