package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"actor", "Lkotlinx/coroutines/channels/SendChannel;", "E", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "start", "Lkotlinx/coroutines/CoroutineStart;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ActorScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/SendChannel;", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class ActorKt
{
  @ObsoleteCoroutinesApi
  @NotNull
  public static final <E> SendChannel<E> actor(@NotNull CoroutineScope paramCoroutineScope, @NotNull CoroutineContext paramCoroutineContext, int paramInt, @NotNull CoroutineStart paramCoroutineStart, @Nullable Function1<? super Throwable, Unit> paramFunction1, @NotNull Function2<? super ActorScope<E>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    paramCoroutineScope = CoroutineContextKt.newCoroutineContext(paramCoroutineScope, paramCoroutineContext);
    paramCoroutineContext = ChannelKt.Channel(paramInt);
    if (paramCoroutineStart.isLazy()) {
      paramCoroutineScope = (ActorCoroutine)new LazyActorCoroutine(paramCoroutineScope, paramCoroutineContext, paramFunction2);
    } else {
      paramCoroutineScope = new ActorCoroutine(paramCoroutineScope, paramCoroutineContext, true);
    }
    if (paramFunction1 != null) {
      paramCoroutineScope.invokeOnCompletion(paramFunction1);
    }
    paramCoroutineScope.start(paramCoroutineStart, paramCoroutineScope, paramFunction2);
    return (SendChannel)paramCoroutineScope;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ActorKt
 * JD-Core Version:    0.7.0.1
 */