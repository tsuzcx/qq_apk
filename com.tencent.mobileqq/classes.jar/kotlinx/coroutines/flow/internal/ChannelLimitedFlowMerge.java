package kotlinx.coroutines.flow.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/flow/internal/ChannelLimitedFlowMerge;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flows", "", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "(Ljava/lang/Iterable;Lkotlin/coroutines/CoroutineContext;I)V", "collectTo", "", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "produceImpl", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class ChannelLimitedFlowMerge<T>
  extends ChannelFlow<T>
{
  private final Iterable<Flow<T>> flows;
  
  public ChannelLimitedFlowMerge(@NotNull Iterable<? extends Flow<? extends T>> paramIterable, @NotNull CoroutineContext paramCoroutineContext, int paramInt)
  {
    super(paramCoroutineContext, paramInt);
    this.flows = paramIterable;
  }
  
  @Nullable
  protected Object collectTo(@NotNull ProducerScope<? super T> paramProducerScope, @NotNull Continuation<? super Unit> paramContinuation)
  {
    paramContinuation = new SendingCollector((SendChannel)paramProducerScope);
    Iterator localIterator = this.flows.iterator();
    while (localIterator.hasNext())
    {
      Flow localFlow = (Flow)localIterator.next();
      BuildersKt.launch$default((CoroutineScope)paramProducerScope, null, null, (Function2)new ChannelLimitedFlowMerge.collectTo..inlined.forEach.lambda.1(localFlow, null, paramProducerScope, paramContinuation), 3, null);
    }
    return Unit.INSTANCE;
  }
  
  @NotNull
  protected ChannelFlow<T> create(@NotNull CoroutineContext paramCoroutineContext, int paramInt)
  {
    return (ChannelFlow)new ChannelLimitedFlowMerge(this.flows, paramCoroutineContext, paramInt);
  }
  
  @NotNull
  public ReceiveChannel<T> produceImpl(@NotNull CoroutineScope paramCoroutineScope)
  {
    return FlowCoroutineKt.flowProduce(paramCoroutineScope, this.context, this.capacity, getCollectToFun$kotlinx_coroutines_core());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge
 * JD-Core Version:    0.7.0.1
 */