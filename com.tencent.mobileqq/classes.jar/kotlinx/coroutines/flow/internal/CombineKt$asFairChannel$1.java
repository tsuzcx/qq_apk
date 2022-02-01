package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelCoroutine;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.flow.internal.CombineKt$asFairChannel$1", f="Combine.kt", i={0, 0, 0}, l={143}, m="invokeSuspend", n={"$this$produce", "channel", "$this$collect$iv"}, s={"L$0", "L$1", "L$2"})
final class CombineKt$asFairChannel$1
  extends SuspendLambda
  implements Function2<ProducerScope<? super Object>, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  Object L$2;
  int label;
  private ProducerScope p$;
  
  CombineKt$asFairChannel$1(Flow paramFlow, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 1(this.$flow, paramContinuation);
    paramContinuation.p$ = ((ProducerScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((1)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject1 = (Flow)this.L$2;
        localObject1 = (ChannelCoroutine)this.L$1;
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
      Object localObject2 = paramObject.getChannel();
      if (localObject2 == null) {
        break label150;
      }
      localObject2 = (ChannelCoroutine)localObject2;
      Flow localFlow = this.$flow;
      FlowCollector localFlowCollector = (FlowCollector)new CombineKt.asFairChannel.1.invokeSuspend..inlined.collect.1((ChannelCoroutine)localObject2);
      this.L$0 = paramObject;
      this.L$1 = localObject2;
      this.L$2 = localFlow;
      this.label = 1;
      if (localFlow.collect(localFlowCollector, this) == localObject1) {
        return localObject1;
      }
    }
    return Unit.INSTANCE;
    label150:
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelCoroutine<kotlin.Any>");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.CombineKt.asFairChannel.1
 * JD-Core Version:    0.7.0.1
 */