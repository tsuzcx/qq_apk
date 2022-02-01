package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/flow/internal/ChannelFlowMerge;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flow", "Lkotlinx/coroutines/flow/Flow;", "concurrency", "", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "(Lkotlinx/coroutines/flow/Flow;ILkotlin/coroutines/CoroutineContext;I)V", "additionalToStringProps", "", "collectTo", "", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "produceImpl", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class ChannelFlowMerge<T>
  extends ChannelFlow<T>
{
  private final int concurrency;
  private final Flow<Flow<T>> flow;
  
  public ChannelFlowMerge(@NotNull Flow<? extends Flow<? extends T>> paramFlow, int paramInt1, @NotNull CoroutineContext paramCoroutineContext, int paramInt2)
  {
    super(paramCoroutineContext, paramInt2);
    this.flow = paramFlow;
    this.concurrency = paramInt1;
  }
  
  @NotNull
  public String additionalToStringProps()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("concurrency=");
    localStringBuilder.append(this.concurrency);
    localStringBuilder.append(", ");
    return localStringBuilder.toString();
  }
  
  @Nullable
  protected Object collectTo(@NotNull ProducerScope<? super T> paramProducerScope, @NotNull Continuation<? super Unit> paramContinuation)
  {
    Semaphore localSemaphore = SemaphoreKt.Semaphore$default(this.concurrency, 0, 2, null);
    SendingCollector localSendingCollector = new SendingCollector((SendChannel)paramProducerScope);
    Job localJob = (Job)paramContinuation.getContext().get((CoroutineContext.Key)Job.Key);
    paramProducerScope = this.flow.collect((FlowCollector)new ChannelFlowMerge.collectTo..inlined.collect.1(localJob, localSemaphore, paramProducerScope, localSendingCollector), paramContinuation);
    if (paramProducerScope == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramProducerScope;
    }
    return Unit.INSTANCE;
  }
  
  @NotNull
  protected ChannelFlow<T> create(@NotNull CoroutineContext paramCoroutineContext, int paramInt)
  {
    return (ChannelFlow)new ChannelFlowMerge(this.flow, this.concurrency, paramCoroutineContext, paramInt);
  }
  
  @NotNull
  public ReceiveChannel<T> produceImpl(@NotNull CoroutineScope paramCoroutineScope)
  {
    return FlowCoroutineKt.flowProduce(paramCoroutineScope, this.context, this.capacity, getCollectToFun$kotlinx_coroutines_core());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.ChannelFlowMerge
 * JD-Core Version:    0.7.0.1
 */