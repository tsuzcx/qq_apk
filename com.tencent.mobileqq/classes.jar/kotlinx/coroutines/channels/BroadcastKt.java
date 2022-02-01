package kotlinx.coroutines.channels;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"broadcast", "Lkotlinx/coroutines/channels/BroadcastChannel;", "E", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "start", "Lkotlinx/coroutines/CoroutineStart;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class BroadcastKt
{
  @NotNull
  public static final <E> BroadcastChannel<E> broadcast(@NotNull CoroutineScope paramCoroutineScope, @NotNull CoroutineContext paramCoroutineContext, int paramInt, @NotNull CoroutineStart paramCoroutineStart, @Nullable Function1<? super Throwable, Unit> paramFunction1, @BuilderInference @NotNull Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    paramCoroutineScope = CoroutineContextKt.newCoroutineContext(paramCoroutineScope, paramCoroutineContext);
    paramCoroutineContext = BroadcastChannelKt.BroadcastChannel(paramInt);
    if (paramCoroutineStart.isLazy()) {
      paramCoroutineScope = (BroadcastCoroutine)new LazyBroadcastCoroutine(paramCoroutineScope, paramCoroutineContext, paramFunction2);
    } else {
      paramCoroutineScope = new BroadcastCoroutine(paramCoroutineScope, paramCoroutineContext, true);
    }
    if (paramFunction1 != null) {
      paramCoroutineScope.invokeOnCompletion(paramFunction1);
    }
    paramCoroutineScope.start(paramCoroutineStart, paramCoroutineScope, paramFunction2);
    return (BroadcastChannel)paramCoroutineScope;
  }
  
  @NotNull
  public static final <E> BroadcastChannel<E> broadcast(@NotNull ReceiveChannel<? extends E> paramReceiveChannel, int paramInt, @NotNull CoroutineStart paramCoroutineStart)
  {
    return broadcast((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)Dispatchers.getUnconfined(), paramInt, paramCoroutineStart, ChannelsKt.consumes(paramReceiveChannel), (Function2)new BroadcastKt.broadcast.1(paramReceiveChannel, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.BroadcastKt
 * JD-Core Version:    0.7.0.1
 */