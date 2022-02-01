package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/AbstractChannel$Itr;", "E", "Lkotlinx/coroutines/channels/ChannelIterator;", "channel", "Lkotlinx/coroutines/channels/AbstractChannel;", "(Lkotlinx/coroutines/channels/AbstractChannel;)V", "getChannel", "()Lkotlinx/coroutines/channels/AbstractChannel;", "result", "", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "hasNext", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextResult", "hasNextSuspend", "next", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class AbstractChannel$Itr<E>
  implements ChannelIterator<E>
{
  @NotNull
  private final AbstractChannel<E> channel;
  @Nullable
  private Object result;
  
  public AbstractChannel$Itr(@NotNull AbstractChannel<E> paramAbstractChannel)
  {
    this.channel = paramAbstractChannel;
    this.result = AbstractChannelKt.POLL_FAILED;
  }
  
  private final boolean hasNextResult(Object paramObject)
  {
    if ((paramObject instanceof Closed))
    {
      paramObject = (Closed)paramObject;
      if (paramObject.closeCause == null) {
        return false;
      }
      throw StackTraceRecoveryKt.recoverStackTrace(paramObject.getReceiveException());
    }
    return true;
  }
  
  @NotNull
  public final AbstractChannel<E> getChannel()
  {
    return this.channel;
  }
  
  @Nullable
  public final Object getResult()
  {
    return this.result;
  }
  
  @Nullable
  public Object hasNext(@NotNull Continuation<? super Boolean> paramContinuation)
  {
    if (this.result != AbstractChannelKt.POLL_FAILED) {
      return Boxing.boxBoolean(hasNextResult(this.result));
    }
    this.result = this.channel.pollInternal();
    if (this.result != AbstractChannelKt.POLL_FAILED) {
      return Boxing.boxBoolean(hasNextResult(this.result));
    }
    return hasNextSuspend(paramContinuation);
  }
  
  public E next()
  {
    Object localObject = this.result;
    if (!(localObject instanceof Closed))
    {
      if (localObject != AbstractChannelKt.POLL_FAILED)
      {
        this.result = AbstractChannelKt.POLL_FAILED;
        return localObject;
      }
      throw ((Throwable)new IllegalStateException("'hasNext' should be called prior to 'next' invocation"));
    }
    throw StackTraceRecoveryKt.recoverStackTrace(((Closed)localObject).getReceiveException());
  }
  
  public final void setResult(@Nullable Object paramObject)
  {
    this.result = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.AbstractChannel.Itr
 * JD-Core Version:    0.7.0.1
 */