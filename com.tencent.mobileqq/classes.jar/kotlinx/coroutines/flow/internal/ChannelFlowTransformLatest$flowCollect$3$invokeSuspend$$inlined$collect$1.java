package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1
  implements FlowCollector<T>
{
  public ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1(ChannelFlowTransformLatest.flowCollect.3 param3, CoroutineScope paramCoroutineScope, Ref.ObjectRef paramObjectRef) {}
  
  @Nullable
  public Object emit(Object paramObject, @NotNull Continuation paramContinuation)
  {
    if ((paramContinuation instanceof ChannelFlowTransformLatest.flowCollect.3.invokeSuspend..inlined.collect.1.1))
    {
      localObject1 = (ChannelFlowTransformLatest.flowCollect.3.invokeSuspend..inlined.collect.1.1)paramContinuation;
      if ((((ChannelFlowTransformLatest.flowCollect.3.invokeSuspend..inlined.collect.1.1)localObject1).label & 0x80000000) != 0)
      {
        ((ChannelFlowTransformLatest.flowCollect.3.invokeSuspend..inlined.collect.1.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation)localObject1;
        break label53;
      }
    }
    paramContinuation = new ChannelFlowTransformLatest.flowCollect.3.invokeSuspend..inlined.collect.1.1(this, paramContinuation);
    label53:
    Object localObject1 = paramContinuation.result;
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    if (i != 0)
    {
      if (i == 1)
      {
        paramObject = (Job)paramContinuation.L$5;
        paramObject = (Job)paramContinuation.L$4;
        paramObject = paramContinuation.L$3;
        localObject2 = (Continuation)paramContinuation.L$2;
        localObject2 = paramContinuation.L$1;
        paramContinuation = (1)paramContinuation.L$0;
        ResultKt.throwOnFailure(localObject1);
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(localObject1);
      localObject1 = (Continuation)paramContinuation;
      Job localJob = (Job)this.$previousFlow$inlined.element;
      if (localJob != null)
      {
        localJob.cancel((CancellationException)new ChildCancelledException());
        paramContinuation.L$0 = this;
        paramContinuation.L$1 = paramObject;
        paramContinuation.L$2 = localObject1;
        paramContinuation.L$3 = paramObject;
        paramContinuation.L$4 = localJob;
        paramContinuation.L$5 = localJob;
        paramContinuation.label = 1;
        if (localJob.join(paramContinuation) == localObject2) {
          return localObject2;
        }
      }
      paramContinuation = this;
    }
    paramContinuation.$previousFlow$inlined.element = BuildersKt.launch$default(paramContinuation.$this_flowScope$inlined, null, CoroutineStart.UNDISPATCHED, (Function2)new ChannelFlowTransformLatest.flowCollect.3.invokeSuspend..inlined.collect.1.lambda.1(paramObject, null, paramContinuation), 1, null);
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest.flowCollect.3.invokeSuspend..inlined.collect.1
 * JD-Core Version:    0.7.0.1
 */