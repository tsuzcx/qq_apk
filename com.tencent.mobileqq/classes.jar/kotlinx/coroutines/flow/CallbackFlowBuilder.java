package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.Continuation<-Lkotlin.Unit;>;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/flow/CallbackFlowBuilder;", "T", "Lkotlinx/coroutines/flow/ChannelFlowBuilder;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/CoroutineContext;I)V", "Lkotlin/jvm/functions/Function2;", "collectTo", "scope", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class CallbackFlowBuilder<T>
  extends ChannelFlowBuilder<T>
{
  private final Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> block;
  
  public CallbackFlowBuilder(@NotNull Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2, @NotNull CoroutineContext paramCoroutineContext, int paramInt)
  {
    super(paramFunction2, paramCoroutineContext, paramInt);
    this.block = paramFunction2;
  }
  
  @Nullable
  protected Object collectTo(@NotNull ProducerScope<? super T> paramProducerScope, @NotNull Continuation<? super Unit> paramContinuation)
  {
    Object localObject1;
    if ((paramContinuation instanceof CallbackFlowBuilder.collectTo.1))
    {
      localObject1 = (CallbackFlowBuilder.collectTo.1)paramContinuation;
      if ((((CallbackFlowBuilder.collectTo.1)localObject1).label & 0x80000000) != 0)
      {
        ((CallbackFlowBuilder.collectTo.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation<? super Unit>)localObject1;
        break label53;
      }
    }
    paramContinuation = new CallbackFlowBuilder.collectTo.1(this, paramContinuation);
    label53:
    Object localObject2 = paramContinuation.result;
    Object localObject3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject1 = (ProducerScope)paramContinuation.L$1;
        paramProducerScope = (CallbackFlowBuilder)paramContinuation.L$0;
        ResultKt.throwOnFailure(localObject2);
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(localObject2);
      paramContinuation.L$0 = this;
      paramContinuation.L$1 = paramProducerScope;
      paramContinuation.label = 1;
      localObject1 = paramProducerScope;
      if (super.collectTo(paramProducerScope, paramContinuation) == localObject3) {
        return localObject3;
      }
    }
    if (((ProducerScope)localObject1).isClosedForSend()) {
      return Unit.INSTANCE;
    }
    throw ((Throwable)new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."));
  }
  
  @NotNull
  protected ChannelFlow<T> create(@NotNull CoroutineContext paramCoroutineContext, int paramInt)
  {
    return (ChannelFlow)new CallbackFlowBuilder(this.block, paramCoroutineContext, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.CallbackFlowBuilder
 * JD-Core Version:    0.7.0.1
 */