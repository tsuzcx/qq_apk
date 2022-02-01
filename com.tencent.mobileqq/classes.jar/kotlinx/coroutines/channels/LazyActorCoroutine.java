package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/LazyActorCoroutine;", "E", "Lkotlinx/coroutines/channels/ActorCoroutine;", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "channel", "Lkotlinx/coroutines/channels/Channel;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ActorScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function2;)V", "continuation", "onSend", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "close", "", "cause", "", "offer", "element", "(Ljava/lang/Object;)Z", "onStart", "registerSelectClause2", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "param", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class LazyActorCoroutine<E>
  extends ActorCoroutine<E>
  implements SelectClause2<E, SendChannel<? super E>>
{
  private Continuation<? super Unit> continuation = IntrinsicsKt.createCoroutineUnintercepted(paramFunction2, this, (Continuation)this);
  
  public LazyActorCoroutine(@NotNull CoroutineContext paramCoroutineContext, @NotNull Channel<E> paramChannel, @NotNull Function2<? super ActorScope<E>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    super(paramCoroutineContext, paramChannel, false);
  }
  
  public boolean close(@Nullable Throwable paramThrowable)
  {
    start();
    return super.close(paramThrowable);
  }
  
  @NotNull
  public SelectClause2<E, SendChannel<E>> getOnSend()
  {
    return (SelectClause2)this;
  }
  
  public boolean offer(E paramE)
  {
    start();
    return super.offer(paramE);
  }
  
  protected void onStart()
  {
    CancellableKt.startCoroutineCancellable(this.continuation, (Continuation)this);
  }
  
  public <R> void registerSelectClause2(@NotNull SelectInstance<? super R> paramSelectInstance, E paramE, @NotNull Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    start();
    super.getOnSend().registerSelectClause2(paramSelectInstance, paramE, paramFunction2);
  }
  
  @Nullable
  public Object send(E paramE, @NotNull Continuation<? super Unit> paramContinuation)
  {
    start();
    paramE = super.send(paramE, paramContinuation);
    if (paramE == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramE;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.LazyActorCoroutine
 * JD-Core Version:    0.7.0.1
 */