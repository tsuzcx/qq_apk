package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/flow/ChannelAsFlow;", "T", "Lkotlinx/coroutines/channels/ReceiveChannel;", "channel", "", "consume", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "<init>", "(Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/CoroutineContext;I)V", "", "additionalToStringProps", "()Ljava/lang/String;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineStart;", "start", "Lkotlinx/coroutines/channels/BroadcastChannel;", "broadcastImpl", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineStart;)Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ProducerScope;", "collectTo", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "create", "(Lkotlin/coroutines/CoroutineContext;I)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "markConsumed", "()V", "produceImpl", "(Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Z", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class ChannelAsFlow<T>
  extends ChannelFlow<T>
{
  private static final AtomicIntegerFieldUpdater consumed$FU = AtomicIntegerFieldUpdater.newUpdater(ChannelAsFlow.class, "consumed");
  private final ReceiveChannel<T> channel;
  private final boolean consume;
  private volatile int consumed;
  
  public ChannelAsFlow(@NotNull ReceiveChannel<? extends T> paramReceiveChannel, boolean paramBoolean, @NotNull CoroutineContext paramCoroutineContext, int paramInt)
  {
    super(paramCoroutineContext, paramInt);
    this.channel = paramReceiveChannel;
    this.consume = paramBoolean;
    this.consumed = 0;
  }
  
  private final void markConsumed()
  {
    if (this.consume)
    {
      AtomicIntegerFieldUpdater localAtomicIntegerFieldUpdater = consumed$FU;
      int i = 1;
      if (localAtomicIntegerFieldUpdater.getAndSet(this, 1) != 0) {
        i = 0;
      }
      if (i != 0) {
        return;
      }
      throw ((Throwable)new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString()));
    }
  }
  
  @NotNull
  public String additionalToStringProps()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("channel=");
    localStringBuilder.append(this.channel);
    localStringBuilder.append(", ");
    return localStringBuilder.toString();
  }
  
  @NotNull
  public BroadcastChannel<T> broadcastImpl(@NotNull CoroutineScope paramCoroutineScope, @NotNull CoroutineStart paramCoroutineStart)
  {
    markConsumed();
    return super.broadcastImpl(paramCoroutineScope, paramCoroutineStart);
  }
  
  @Nullable
  public Object collect(@NotNull FlowCollector<? super T> paramFlowCollector, @NotNull Continuation<? super Unit> paramContinuation)
  {
    if (this.capacity == -3)
    {
      markConsumed();
      paramFlowCollector = FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt(paramFlowCollector, this.channel, this.consume, paramContinuation);
      if (paramFlowCollector == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        return paramFlowCollector;
      }
    }
    else
    {
      paramFlowCollector = super.collect(paramFlowCollector, paramContinuation);
      if (paramFlowCollector == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        return paramFlowCollector;
      }
    }
    return Unit.INSTANCE;
  }
  
  @Nullable
  protected Object collectTo(@NotNull ProducerScope<? super T> paramProducerScope, @NotNull Continuation<? super Unit> paramContinuation)
  {
    paramProducerScope = FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt((FlowCollector)new SendingCollector((SendChannel)paramProducerScope), this.channel, this.consume, paramContinuation);
    if (paramProducerScope == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramProducerScope;
    }
    return Unit.INSTANCE;
  }
  
  @NotNull
  protected ChannelFlow<T> create(@NotNull CoroutineContext paramCoroutineContext, int paramInt)
  {
    return (ChannelFlow)new ChannelAsFlow(this.channel, this.consume, paramCoroutineContext, paramInt);
  }
  
  @NotNull
  public ReceiveChannel<T> produceImpl(@NotNull CoroutineScope paramCoroutineScope)
  {
    markConsumed();
    if (this.capacity == -3) {
      return this.channel;
    }
    return super.produceImpl(paramCoroutineScope);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.ChannelAsFlow
 * JD-Core Version:    0.7.0.1
 */