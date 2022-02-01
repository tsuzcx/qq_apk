package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/ReceiveChannel;", "E", "", "isClosedForReceive", "", "isClosedForReceive$annotations", "()V", "()Z", "isEmpty", "isEmpty$annotations", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveOrClosed", "Lkotlinx/coroutines/channels/ValueOrClosed;", "onReceiveOrClosed$annotations", "getOnReceiveOrClosed", "onReceiveOrNull", "onReceiveOrNull$annotations", "getOnReceiveOrNull", "cancel", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "poll", "()Ljava/lang/Object;", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveOrClosed", "receiveOrNull", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract interface ReceiveChannel<E>
{
  public abstract void cancel(@Nullable CancellationException paramCancellationException);
  
  @NotNull
  public abstract SelectClause1<E> getOnReceive();
  
  @NotNull
  public abstract SelectClause1<ValueOrClosed<E>> getOnReceiveOrClosed();
  
  @NotNull
  public abstract SelectClause1<E> getOnReceiveOrNull();
  
  public abstract boolean isClosedForReceive();
  
  public abstract boolean isEmpty();
  
  @NotNull
  public abstract ChannelIterator<E> iterator();
  
  @Nullable
  public abstract E poll();
  
  @Nullable
  public abstract Object receive(@NotNull Continuation<? super E> paramContinuation);
  
  @InternalCoroutinesApi
  @Nullable
  public abstract Object receiveOrClosed(@NotNull Continuation<? super ValueOrClosed<? extends E>> paramContinuation);
  
  @Deprecated(level=DeprecationLevel.WARNING, message="Deprecated in favor of receiveOrClosed and receiveOrNull extension", replaceWith=@ReplaceWith(expression="receiveOrNull", imports={"kotlinx.coroutines.channels.receiveOrNull"}))
  @LowPriorityInOverloadResolution
  @ObsoleteCoroutinesApi
  @Nullable
  public abstract Object receiveOrNull(@NotNull Continuation<? super E> paramContinuation);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ReceiveChannel
 * JD-Core Version:    0.7.0.1
 */