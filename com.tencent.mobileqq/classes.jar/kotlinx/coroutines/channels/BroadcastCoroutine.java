package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.selects.SelectClause2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/BroadcastCoroutine;", "E", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "_channel", "active", "", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/BroadcastChannel;Z)V", "get_channel", "()Lkotlinx/coroutines/channels/BroadcastChannel;", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "isActive", "()Z", "isClosedForSend", "isFull", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "cancel", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", "close", "invokeOnClose", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "offer", "element", "(Ljava/lang/Object;)Z", "onCancelled", "handled", "onCompleted", "value", "(Lkotlin/Unit;)V", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
class BroadcastCoroutine<E>
  extends AbstractCoroutine<Unit>
  implements BroadcastChannel<E>, ProducerScope<E>
{
  @NotNull
  private final BroadcastChannel<E> _channel;
  
  public BroadcastCoroutine(@NotNull CoroutineContext paramCoroutineContext, @NotNull BroadcastChannel<E> paramBroadcastChannel, boolean paramBoolean)
  {
    super(paramCoroutineContext, paramBoolean);
    this._channel = paramBroadcastChannel;
  }
  
  public final void cancel(@Nullable CancellationException paramCancellationException)
  {
    if (paramCancellationException != null)
    {
      paramCancellationException = (Throwable)paramCancellationException;
    }
    else
    {
      paramCancellationException = (JobSupport)this;
      Object localObject = (String)null;
      localObject = (Throwable)null;
      paramCancellationException = (Throwable)new JobCancellationException(JobSupport.access$cancellationExceptionMessage(paramCancellationException), (Throwable)localObject, (Job)paramCancellationException);
    }
    cancelInternal(paramCancellationException);
  }
  
  public void cancelInternal(@NotNull Throwable paramThrowable)
  {
    this._channel.cancel(JobSupport.toCancellationException$default(this, paramThrowable, null, 1, null));
    cancelCoroutine(paramThrowable);
  }
  
  public boolean close(@Nullable Throwable paramThrowable)
  {
    return this._channel.close(paramThrowable);
  }
  
  @NotNull
  public SendChannel<E> getChannel()
  {
    return (SendChannel)this;
  }
  
  @NotNull
  public SelectClause2<E, SendChannel<E>> getOnSend()
  {
    return this._channel.getOnSend();
  }
  
  @NotNull
  protected final BroadcastChannel<E> get_channel()
  {
    return this._channel;
  }
  
  @ExperimentalCoroutinesApi
  public void invokeOnClose(@NotNull Function1<? super Throwable, Unit> paramFunction1)
  {
    this._channel.invokeOnClose(paramFunction1);
  }
  
  public boolean isActive()
  {
    return super.isActive();
  }
  
  public boolean isClosedForSend()
  {
    return this._channel.isClosedForSend();
  }
  
  public boolean isFull()
  {
    return this._channel.isFull();
  }
  
  public boolean offer(E paramE)
  {
    return this._channel.offer(paramE);
  }
  
  protected void onCancelled(@NotNull Throwable paramThrowable, boolean paramBoolean)
  {
    if ((!this._channel.close(paramThrowable)) && (!paramBoolean)) {
      CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), paramThrowable);
    }
  }
  
  protected void onCompleted(@NotNull Unit paramUnit)
  {
    SendChannel.DefaultImpls.close$default(this._channel, null, 1, null);
  }
  
  @NotNull
  public ReceiveChannel<E> openSubscription()
  {
    return this._channel.openSubscription();
  }
  
  @Nullable
  public Object send(E paramE, @NotNull Continuation<? super Unit> paramContinuation)
  {
    return send$suspendImpl(this, paramE, paramContinuation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.BroadcastCoroutine
 * JD-Core Version:    0.7.0.1
 */