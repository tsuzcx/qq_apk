package kotlinx.coroutines.channels;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectInstance<*>;
import kotlinx.coroutines.selects.SelectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", "E", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "broadcastChannel", "<init>", "(Lkotlinx/coroutines/channels/ArrayBroadcastChannel;)V", "", "checkOffer", "()Z", "needsToCheckOfferWithoutLock", "wasClosed", "", "onCancelIdempotent", "(Z)V", "", "peekUnderLock", "()Ljava/lang/Object;", "pollInternal", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "isBufferAlwaysEmpty", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "", "value", "getSubHead", "()J", "setSubHead", "(J)V", "subHead", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "subLock", "Ljava/util/concurrent/locks/ReentrantLock;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/AbstractChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;"}, k=1, mv={1, 1, 16})
final class ArrayBroadcastChannel$Subscriber<E>
  extends AbstractChannel<E>
  implements ReceiveChannel<E>
{
  private volatile long _subHead;
  private final ArrayBroadcastChannel<E> broadcastChannel;
  private final ReentrantLock subLock;
  
  public ArrayBroadcastChannel$Subscriber(@NotNull ArrayBroadcastChannel<E> paramArrayBroadcastChannel)
  {
    this.broadcastChannel = paramArrayBroadcastChannel;
    this.subLock = new ReentrantLock();
    this._subHead = 0L;
  }
  
  private final boolean needsToCheckOfferWithoutLock()
  {
    if (getClosedForReceive() != null) {
      return false;
    }
    return (!isBufferEmpty()) || (this.broadcastChannel.getClosedForReceive() != null);
  }
  
  private final Object peekUnderLock()
  {
    long l = getSubHead();
    Object localObject = this.broadcastChannel.getClosedForReceive();
    if (l >= ArrayBroadcastChannel.access$getTail$p(this.broadcastChannel))
    {
      if (localObject == null) {
        localObject = getClosedForReceive();
      }
      if (localObject != null) {
        return localObject;
      }
      return AbstractChannelKt.POLL_FAILED;
    }
    localObject = ArrayBroadcastChannel.access$elementAt(this.broadcastChannel, l);
    Closed localClosed = getClosedForReceive();
    if (localClosed != null) {
      return localClosed;
    }
    return localObject;
  }
  
  public final boolean checkOffer()
  {
    Closed localClosed = (Closed)null;
    boolean bool = false;
    Object localObject1 = localClosed;
    if (needsToCheckOfferWithoutLock()) {
      if (!this.subLock.tryLock()) {
        localObject1 = localClosed;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject3 = peekUnderLock();
        localObject1 = AbstractChannelKt.POLL_FAILED;
        if (localObject3 == localObject1)
        {
          this.subLock.unlock();
          break;
        }
        if ((localObject3 instanceof Closed))
        {
          localObject1 = (Closed)localObject3;
          this.subLock.unlock();
        }
        else
        {
          ReceiveOrClosed localReceiveOrClosed = takeFirstReceiveOrPeekClosed();
          localObject1 = localClosed;
          if (localReceiveOrClosed == null) {
            continue;
          }
          if ((localReceiveOrClosed instanceof Closed))
          {
            localObject1 = localClosed;
            continue;
          }
          localObject1 = localReceiveOrClosed.tryResumeReceive(localObject3, null);
          if (localObject1 == null) {
            continue;
          }
          if (DebugKt.getASSERTIONS_ENABLED())
          {
            if (localObject1 != CancellableContinuationImplKt.RESUME_TOKEN) {
              break label220;
            }
            i = 1;
            break label222;
            throw ((Throwable)new AssertionError());
          }
          setSubHead(getSubHead() + 1L);
          this.subLock.unlock();
          if (localReceiveOrClosed == null) {
            Intrinsics.throwNpe();
          }
          localReceiveOrClosed.completeResumeReceive(localObject3);
          bool = true;
          break;
        }
      }
      finally
      {
        this.subLock.unlock();
      }
      if (localObject2 != null) {
        close(localObject2.closeCause);
      }
      return bool;
      label220:
      int i = 0;
      label222:
      if (i == 0) {}
    }
  }
  
  public final long getSubHead()
  {
    return this._subHead;
  }
  
  protected boolean isBufferAlwaysEmpty()
  {
    return false;
  }
  
  protected boolean isBufferAlwaysFull()
  {
    throw ((Throwable)new IllegalStateException("Should not be used".toString()));
  }
  
  protected boolean isBufferEmpty()
  {
    return getSubHead() >= ArrayBroadcastChannel.access$getTail$p(this.broadcastChannel);
  }
  
  protected boolean isBufferFull()
  {
    throw ((Throwable)new IllegalStateException("Should not be used".toString()));
  }
  
  protected void onCancelIdempotent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ArrayBroadcastChannel.updateHead$default(this.broadcastChannel, null, this, 1, null);
      Lock localLock = (Lock)this.subLock;
      localLock.lock();
      try
      {
        setSubHead(ArrayBroadcastChannel.access$getTail$p(this.broadcastChannel));
        Unit localUnit = Unit.INSTANCE;
        return;
      }
      finally
      {
        localLock.unlock();
      }
    }
  }
  
  @Nullable
  protected Object pollInternal()
  {
    Object localObject1 = (Lock)this.subLock;
    ((Lock)localObject1).lock();
    for (;;)
    {
      try
      {
        Object localObject2 = peekUnderLock();
        if ((!(localObject2 instanceof Closed)) && (localObject2 != AbstractChannelKt.POLL_FAILED))
        {
          setSubHead(getSubHead() + 1L);
          i = 1;
          ((Lock)localObject1).unlock();
          if (!(localObject2 instanceof Closed)) {
            localObject1 = null;
          } else {
            localObject1 = localObject2;
          }
          localObject1 = (Closed)localObject1;
          if (localObject1 != null) {
            close(((Closed)localObject1).closeCause);
          }
          if (checkOffer()) {
            i = 1;
          }
          if (i != 0) {
            ArrayBroadcastChannel.updateHead$default(this.broadcastChannel, null, null, 3, null);
          }
          return localObject2;
        }
      }
      finally
      {
        ((Lock)localObject1).unlock();
      }
      int i = 0;
    }
  }
  
  @Nullable
  protected Object pollSelectInternal(@NotNull SelectInstance<?> paramSelectInstance)
  {
    Lock localLock = (Lock)this.subLock;
    localLock.lock();
    try
    {
      Object localObject = peekUnderLock();
      boolean bool = localObject instanceof Closed;
      int j = 1;
      int i = 0;
      if (bool)
      {
        paramSelectInstance = (SelectInstance<?>)localObject;
      }
      else if (localObject == AbstractChannelKt.POLL_FAILED)
      {
        paramSelectInstance = (SelectInstance<?>)localObject;
      }
      else if (!paramSelectInstance.trySelect())
      {
        paramSelectInstance = SelectKt.getALREADY_SELECTED();
      }
      else
      {
        setSubHead(getSubHead() + 1L);
        i = 1;
        paramSelectInstance = (SelectInstance<?>)localObject;
      }
      localLock.unlock();
      if (!(paramSelectInstance instanceof Closed)) {
        localObject = null;
      } else {
        localObject = paramSelectInstance;
      }
      localObject = (Closed)localObject;
      if (localObject != null) {
        close(((Closed)localObject).closeCause);
      }
      if (checkOffer()) {
        i = j;
      }
      if (i != 0) {
        ArrayBroadcastChannel.updateHead$default(this.broadcastChannel, null, null, 3, null);
      }
      return paramSelectInstance;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public final void setSubHead(long paramLong)
  {
    this._subHead = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ArrayBroadcastChannel.Subscriber
 * JD-Core Version:    0.7.0.1
 */