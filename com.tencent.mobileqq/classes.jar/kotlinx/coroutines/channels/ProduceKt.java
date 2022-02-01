package kotlinx.coroutines.channels;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"awaitClose", "", "Lkotlinx/coroutines/channels/ProducerScope;", "block", "Lkotlin/Function0;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produce", "Lkotlinx/coroutines/channels/ReceiveChannel;", "E", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "start", "Lkotlinx/coroutines/CoroutineStart;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class ProduceKt
{
  @ExperimentalCoroutinesApi
  @Nullable
  public static final Object awaitClose(@NotNull ProducerScope<?> paramProducerScope, @NotNull Function0<Unit> paramFunction0, @NotNull Continuation<? super Unit> paramContinuation)
  {
    if ((paramContinuation instanceof ProduceKt.awaitClose.1))
    {
      local1 = (ProduceKt.awaitClose.1)paramContinuation;
      if ((local1.label & 0x80000000) != 0)
      {
        local1.label += -2147483648;
        break label50;
      }
    }
    ProduceKt.awaitClose.1 local1 = new ProduceKt.awaitClose.1(paramContinuation);
    label50:
    Object localObject2 = local1.result;
    Object localObject1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = local1.label;
    if (i != 0)
    {
      if (i == 1)
      {
        paramProducerScope = (Function0)local1.L$1;
        paramFunction0 = (ProducerScope)local1.L$0;
        paramContinuation = paramProducerScope;
        try
        {
          ResultKt.throwOnFailure(localObject2);
        }
        finally
        {
          break label279;
        }
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(localObject2);
      if ((Job)local1.getContext().get((CoroutineContext.Key)Job.Key) == paramProducerScope) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        break label288;
      }
      paramContinuation = paramFunction0;
      local1.L$0 = paramProducerScope;
      paramContinuation = paramFunction0;
      local1.L$1 = paramFunction0;
      paramContinuation = paramFunction0;
      local1.label = 1;
      paramContinuation = paramFunction0;
      localObject2 = new CancellableContinuationImpl(IntrinsicsKt.intercepted((Continuation)local1), 1);
      paramContinuation = paramFunction0;
      paramProducerScope.invokeOnClose((Function1)new ProduceKt.awaitClose.4.1((CancellableContinuation)localObject2));
      paramContinuation = paramFunction0;
      localObject2 = ((CancellableContinuationImpl)localObject2).getResult();
      paramContinuation = paramFunction0;
      if (localObject2 == IntrinsicsKt.getCOROUTINE_SUSPENDED())
      {
        paramContinuation = paramFunction0;
        DebugProbesKt.probeCoroutineSuspended((Continuation)local1);
      }
      paramProducerScope = paramFunction0;
      if (localObject2 == localObject1) {
        return localObject1;
      }
    }
    paramProducerScope.invoke();
    return Unit.INSTANCE;
    label279:
    paramContinuation.invoke();
    throw paramProducerScope;
    label288:
    throw ((Throwable)new IllegalStateException("awaitClose() can only be invoked from the producer context".toString()));
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <E> ReceiveChannel<E> produce(@NotNull CoroutineScope paramCoroutineScope, @NotNull CoroutineContext paramCoroutineContext, int paramInt, @BuilderInference @NotNull Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    Channel localChannel = ChannelKt.Channel(paramInt);
    paramCoroutineScope = new ProducerCoroutine(CoroutineContextKt.newCoroutineContext(paramCoroutineScope, paramCoroutineContext), localChannel);
    paramCoroutineScope.start(CoroutineStart.DEFAULT, paramCoroutineScope, paramFunction2);
    return (ReceiveChannel)paramCoroutineScope;
  }
  
  @InternalCoroutinesApi
  @NotNull
  public static final <E> ReceiveChannel<E> produce(@NotNull CoroutineScope paramCoroutineScope, @NotNull CoroutineContext paramCoroutineContext, int paramInt, @NotNull CoroutineStart paramCoroutineStart, @Nullable Function1<? super Throwable, Unit> paramFunction1, @BuilderInference @NotNull Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    Channel localChannel = ChannelKt.Channel(paramInt);
    paramCoroutineScope = new ProducerCoroutine(CoroutineContextKt.newCoroutineContext(paramCoroutineScope, paramCoroutineContext), localChannel);
    if (paramFunction1 != null) {
      paramCoroutineScope.invokeOnCompletion(paramFunction1);
    }
    paramCoroutineScope.start(paramCoroutineStart, paramCoroutineScope, paramFunction2);
    return (ReceiveChannel)paramCoroutineScope;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ProduceKt
 * JD-Core Version:    0.7.0.1
 */