package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.sync.Semaphore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class ChannelFlowMerge$collectTo$$inlined$collect$1
  implements FlowCollector<Flow<? extends T>>
{
  public ChannelFlowMerge$collectTo$$inlined$collect$1(Job paramJob, Semaphore paramSemaphore, ProducerScope paramProducerScope, SendingCollector paramSendingCollector) {}
  
  @Nullable
  public Object emit(Object paramObject, @NotNull Continuation paramContinuation)
  {
    Object localObject1;
    if ((paramContinuation instanceof ChannelFlowMerge.collectTo..inlined.collect.1.1))
    {
      localObject1 = (ChannelFlowMerge.collectTo..inlined.collect.1.1)paramContinuation;
      if ((((ChannelFlowMerge.collectTo..inlined.collect.1.1)localObject1).label & 0x80000000) != 0)
      {
        ((ChannelFlowMerge.collectTo..inlined.collect.1.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation)localObject1;
        break label53;
      }
    }
    paramContinuation = new ChannelFlowMerge.collectTo..inlined.collect.1.1(this, paramContinuation);
    label53:
    Object localObject2 = paramContinuation.result;
    Object localObject3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject1 = (Flow)paramContinuation.L$3;
        paramObject = (Continuation)paramContinuation.L$2;
        paramObject = paramContinuation.L$1;
        paramObject = (1)paramContinuation.L$0;
        ResultKt.throwOnFailure(localObject2);
        paramContinuation = (Continuation)localObject1;
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(localObject2);
      localObject2 = (Continuation)paramContinuation;
      localObject1 = (Flow)paramObject;
      Object localObject4 = this.$job$inlined;
      if (localObject4 != null) {
        JobKt.ensureActive((Job)localObject4);
      }
      localObject4 = this.$semaphore$inlined;
      paramContinuation.L$0 = this;
      paramContinuation.L$1 = paramObject;
      paramContinuation.L$2 = localObject2;
      paramContinuation.L$3 = localObject1;
      paramContinuation.label = 1;
      if (((Semaphore)localObject4).acquire(paramContinuation) == localObject3) {
        return localObject3;
      }
      paramObject = this;
      paramContinuation = (Continuation)localObject1;
    }
    BuildersKt.launch$default((CoroutineScope)paramObject.$scope$inlined, null, null, (Function2)new ChannelFlowMerge.collectTo..inlined.collect.1.lambda.1(paramContinuation, null, paramObject), 3, null);
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.ChannelFlowMerge.collectTo..inlined.collect.1
 * JD-Core Version:    0.7.0.1
 */