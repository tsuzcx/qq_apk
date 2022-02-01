package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/LazyBroadcastCoroutine;", "E", "Lkotlinx/coroutines/channels/BroadcastCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "channel", "Lkotlinx/coroutines/channels/BroadcastChannel;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function2;)V", "continuation", "onStart", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class LazyBroadcastCoroutine<E>
  extends BroadcastCoroutine<E>
{
  private final Continuation<Unit> continuation = IntrinsicsKt.createCoroutineUnintercepted(paramFunction2, this, (Continuation)this);
  
  public LazyBroadcastCoroutine(@NotNull CoroutineContext paramCoroutineContext, @NotNull BroadcastChannel<E> paramBroadcastChannel, @NotNull Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    super(paramCoroutineContext, paramBroadcastChannel, false);
  }
  
  protected void onStart()
  {
    CancellableKt.startCoroutineCancellable(this.continuation, (Continuation)this);
  }
  
  @NotNull
  public ReceiveChannel<E> openSubscription()
  {
    ReceiveChannel localReceiveChannel = get_channel().openSubscription();
    start();
    return localReceiveChannel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.LazyBroadcastCoroutine
 * JD-Core Version:    0.7.0.1
 */