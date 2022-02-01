package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/ChannelCoroutine;", "E", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/Channel;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "_channel", "active", "", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;Z)V", "get_channel", "()Lkotlinx/coroutines/channels/Channel;", "channel", "getChannel", "isClosedForReceive", "()Z", "isClosedForSend", "isEmpty", "isFull", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveOrClosed", "Lkotlinx/coroutines/channels/ValueOrClosed;", "getOnReceiveOrClosed", "onReceiveOrNull", "getOnReceiveOrNull", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "cancel", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", "close", "invokeOnClose", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "offer", "element", "(Ljava/lang/Object;)Z", "poll", "()Ljava/lang/Object;", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveOrClosed", "receiveOrNull", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendFair", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public class ChannelCoroutine<E>
  extends AbstractCoroutine<Unit>
  implements Channel<E>
{
  @NotNull
  private final Channel<E> _channel;
  
  public ChannelCoroutine(@NotNull CoroutineContext paramCoroutineContext, @NotNull Channel<E> paramChannel, boolean paramBoolean)
  {
    super(paramCoroutineContext, paramBoolean);
    this._channel = paramChannel;
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
    paramThrowable = JobSupport.toCancellationException$default(this, paramThrowable, null, 1, null);
    this._channel.cancel(paramThrowable);
    cancelCoroutine((Throwable)paramThrowable);
  }
  
  public boolean close(@Nullable Throwable paramThrowable)
  {
    return this._channel.close(paramThrowable);
  }
  
  @NotNull
  public final Channel<E> getChannel()
  {
    return (Channel)this;
  }
  
  @NotNull
  public SelectClause1<E> getOnReceive()
  {
    return this._channel.getOnReceive();
  }
  
  @NotNull
  public SelectClause1<ValueOrClosed<E>> getOnReceiveOrClosed()
  {
    return this._channel.getOnReceiveOrClosed();
  }
  
  @NotNull
  public SelectClause1<E> getOnReceiveOrNull()
  {
    return this._channel.getOnReceiveOrNull();
  }
  
  @NotNull
  public SelectClause2<E, SendChannel<E>> getOnSend()
  {
    return this._channel.getOnSend();
  }
  
  @NotNull
  protected final Channel<E> get_channel()
  {
    return this._channel;
  }
  
  @ExperimentalCoroutinesApi
  public void invokeOnClose(@NotNull Function1<? super Throwable, Unit> paramFunction1)
  {
    this._channel.invokeOnClose(paramFunction1);
  }
  
  public boolean isClosedForReceive()
  {
    return this._channel.isClosedForReceive();
  }
  
  public boolean isClosedForSend()
  {
    return this._channel.isClosedForSend();
  }
  
  public boolean isEmpty()
  {
    return this._channel.isEmpty();
  }
  
  public boolean isFull()
  {
    return this._channel.isFull();
  }
  
  @NotNull
  public ChannelIterator<E> iterator()
  {
    return this._channel.iterator();
  }
  
  public boolean offer(E paramE)
  {
    return this._channel.offer(paramE);
  }
  
  @Nullable
  public E poll()
  {
    return this._channel.poll();
  }
  
  @Nullable
  public Object receive(@NotNull Continuation<? super E> paramContinuation)
  {
    return receive$suspendImpl(this, paramContinuation);
  }
  
  @InternalCoroutinesApi
  @Nullable
  public Object receiveOrClosed(@NotNull Continuation<? super ValueOrClosed<? extends E>> paramContinuation)
  {
    return receiveOrClosed$suspendImpl(this, paramContinuation);
  }
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Deprecated in favor of receiveOrClosed and receiveOrNull extension", replaceWith=@ReplaceWith(expression="receiveOrNull", imports={"kotlinx.coroutines.channels.receiveOrNull"}))
  @LowPriorityInOverloadResolution
  @ObsoleteCoroutinesApi
  @Nullable
  public Object receiveOrNull(@NotNull Continuation<? super E> paramContinuation)
  {
    return receiveOrNull$suspendImpl(this, paramContinuation);
  }
  
  @Nullable
  public Object send(E paramE, @NotNull Continuation<? super Unit> paramContinuation)
  {
    return send$suspendImpl(this, paramE, paramContinuation);
  }
  
  @Nullable
  public final Object sendFair(E paramE, @NotNull Continuation<? super Unit> paramContinuation)
  {
    Channel localChannel = this._channel;
    if (localChannel != null)
    {
      paramE = ((AbstractSendChannel)localChannel).sendFair$kotlinx_coroutines_core(paramE, paramContinuation);
      if (paramE == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        return paramE;
      }
      return Unit.INSTANCE;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.AbstractSendChannel<E>");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ChannelCoroutine
 * JD-Core Version:    0.7.0.1
 */