package kotlinx.coroutines.channels;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ConcurrentKt;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "E", "", "capacity", "<init>", "(I)V", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "(Ljava/util/concurrent/CancellationException;)V", "cancelInternal", "checkSubOffers", "()V", "close", "", "computeMinHead", "()J", "index", "elementAt", "(J)Ljava/lang/Object;", "element", "", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", "addSub", "removeSub", "updateHead", "(Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;)V", "", "buffer", "[Ljava/lang/Object;", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "bufferLock", "Ljava/util/concurrent/locks/ReentrantLock;", "I", "getCapacity", "()I", "value", "getHead", "setHead", "(J)V", "head", "isBufferAlwaysFull", "()Z", "isBufferFull", "getSize", "setSize", "size", "", "Lkotlinx/coroutines/internal/SubscribersList;", "subscribers", "Ljava/util/List;", "getTail", "setTail", "tail", "Subscriber", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/BroadcastChannel;"}, k=1, mv={1, 1, 16})
public final class ArrayBroadcastChannel<E>
  extends AbstractSendChannel<E>
  implements BroadcastChannel<E>
{
  private volatile long _head;
  private volatile int _size;
  private volatile long _tail;
  private final Object[] buffer;
  private final ReentrantLock bufferLock;
  private final int capacity;
  private final List<ArrayBroadcastChannel.Subscriber<E>> subscribers;
  
  public ArrayBroadcastChannel(int paramInt)
  {
    this.capacity = paramInt;
    int i = this.capacity;
    paramInt = 1;
    if (i < 1) {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      this.bufferLock = new ReentrantLock();
      this.buffer = new Object[this.capacity];
      this._head = 0L;
      this._tail = 0L;
      this._size = 0;
      this.subscribers = ConcurrentKt.subscriberList();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ArrayBroadcastChannel capacity must be at least 1, but ");
    localStringBuilder.append(this.capacity);
    localStringBuilder.append(" was specified");
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString().toString()));
  }
  
  private final boolean cancelInternal(Throwable paramThrowable)
  {
    boolean bool = close(paramThrowable);
    Iterator localIterator = this.subscribers.iterator();
    while (localIterator.hasNext()) {
      ((ArrayBroadcastChannel.Subscriber)localIterator.next()).cancelInternal$kotlinx_coroutines_core(paramThrowable);
    }
    return bool;
  }
  
  private final void checkSubOffers()
  {
    Iterator localIterator = this.subscribers.iterator();
    int i = 0;
    for (int j = 0; localIterator.hasNext(); j = 1) {
      if (((ArrayBroadcastChannel.Subscriber)localIterator.next()).checkOffer()) {
        i = 1;
      }
    }
    if ((i != 0) || (j == 0)) {
      updateHead$default(this, null, null, 3, null);
    }
  }
  
  private final long computeMinHead()
  {
    Iterator localIterator = this.subscribers.iterator();
    for (long l = 9223372036854775807L; localIterator.hasNext(); l = RangesKt.coerceAtMost(l, ((ArrayBroadcastChannel.Subscriber)localIterator.next()).getSubHead())) {}
    return l;
  }
  
  private final E elementAt(long paramLong)
  {
    return this.buffer[((int)(paramLong % this.capacity))];
  }
  
  private final long getHead()
  {
    return this._head;
  }
  
  private final int getSize()
  {
    return this._size;
  }
  
  private final long getTail()
  {
    return this._tail;
  }
  
  private final void setHead(long paramLong)
  {
    this._head = paramLong;
  }
  
  private final void setSize(int paramInt)
  {
    this._size = paramInt;
  }
  
  private final void setTail(long paramLong)
  {
    this._tail = paramLong;
  }
  
  private final void updateHead(ArrayBroadcastChannel.Subscriber<E> paramSubscriber1, ArrayBroadcastChannel.Subscriber<E> paramSubscriber2)
  {
    Object localObject = (Send)null;
    localObject = (Lock)this.bufferLock;
    ((Lock)localObject).lock();
    if (paramSubscriber1 != null) {
      try
      {
        paramSubscriber1.setSubHead(getTail());
        boolean bool = this.subscribers.isEmpty();
        this.subscribers.add(paramSubscriber1);
        if (!bool)
        {
          ((Lock)localObject).unlock();
          return;
        }
      }
      finally
      {
        break label419;
      }
    }
    if (paramSubscriber2 != null)
    {
      this.subscribers.remove(paramSubscriber2);
      l1 = getHead();
      l2 = paramSubscriber2.getSubHead();
      if (l1 != l2)
      {
        ((Lock)localObject).unlock();
        return;
      }
    }
    long l2 = computeMinHead();
    long l3 = getTail();
    long l1 = getHead();
    long l4 = RangesKt.coerceAtMost(l2, l3);
    if (l4 <= l1)
    {
      ((Lock)localObject).unlock();
      return;
    }
    int i = getSize();
    int j;
    label208:
    int m;
    for (;;)
    {
      if (l1 < l4)
      {
        this.buffer[((int)(l1 % this.capacity))] = null;
        j = this.capacity;
        int k = 0;
        if (i < j) {
          break label434;
        }
        j = 1;
        l2 = l1 + 1L;
        setHead(l2);
        m = i - 1;
        setSize(m);
        l1 = l2;
        i = m;
        if (j != 0)
        {
          do
          {
            paramSubscriber1 = takeFirstSendOrPeekClosed();
            l1 = l2;
            i = m;
            if (paramSubscriber1 == null) {
              break;
            }
            if ((paramSubscriber1 instanceof Closed))
            {
              l1 = l2;
              i = m;
              break;
            }
            if (paramSubscriber1 == null) {
              Intrinsics.throwNpe();
            }
            paramSubscriber2 = paramSubscriber1.tryResumeSend(null);
          } while (paramSubscriber2 == null);
          if (DebugKt.getASSERTIONS_ENABLED())
          {
            i = k;
            if (paramSubscriber2 != CancellableContinuationImplKt.RESUME_TOKEN) {
              break label440;
            }
            i = 1;
            break label440;
            label314:
            throw ((Throwable)new AssertionError());
          }
        }
      }
    }
    for (;;)
    {
      paramSubscriber2 = this.buffer;
      i = (int)(l3 % this.capacity);
      if (paramSubscriber1 != null)
      {
        paramSubscriber2[i] = paramSubscriber1.getPollResult();
        setSize(m + 1);
        setTail(l3 + 1L);
        paramSubscriber2 = Unit.INSTANCE;
        ((Lock)localObject).unlock();
        if (paramSubscriber1 == null) {
          Intrinsics.throwNpe();
        }
        paramSubscriber1.completeResumeSend();
        checkSubOffers();
        paramSubscriber1 = null;
        paramSubscriber2 = paramSubscriber1;
        break;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.Send");
      ((Lock)localObject).unlock();
      return;
      label419:
      ((Lock)localObject).unlock();
      for (;;)
      {
        throw paramSubscriber1;
      }
      label434:
      j = 0;
      break label208;
      label440:
      if (i == 0) {
        break label314;
      }
    }
  }
  
  public void cancel(@Nullable CancellationException paramCancellationException)
  {
    cancelInternal((Throwable)paramCancellationException);
  }
  
  public boolean close(@Nullable Throwable paramThrowable)
  {
    if (!super.close(paramThrowable)) {
      return false;
    }
    checkSubOffers();
    return true;
  }
  
  @NotNull
  protected String getBufferDebugString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(buffer:capacity=");
    localStringBuilder.append(this.buffer.length);
    localStringBuilder.append(",size=");
    localStringBuilder.append(getSize());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public final int getCapacity()
  {
    return this.capacity;
  }
  
  protected boolean isBufferAlwaysFull()
  {
    return false;
  }
  
  protected boolean isBufferFull()
  {
    return getSize() >= this.capacity;
  }
  
  @NotNull
  protected Object offerInternal(E paramE)
  {
    Lock localLock = (Lock)this.bufferLock;
    localLock.lock();
    try
    {
      Closed localClosed = getClosedForSend();
      if (localClosed != null) {
        return localClosed;
      }
      int i = getSize();
      if (i >= this.capacity)
      {
        paramE = AbstractChannelKt.OFFER_FAILED;
        return paramE;
      }
      long l = getTail();
      this.buffer[((int)(l % this.capacity))] = paramE;
      setSize(i + 1);
      setTail(l + 1L);
      paramE = Unit.INSTANCE;
      localLock.unlock();
      checkSubOffers();
      return AbstractChannelKt.OFFER_SUCCESS;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  @NotNull
  protected Object offerSelectInternal(E paramE, @NotNull SelectInstance<?> paramSelectInstance)
  {
    Lock localLock = (Lock)this.bufferLock;
    localLock.lock();
    try
    {
      Closed localClosed = getClosedForSend();
      if (localClosed != null) {
        return localClosed;
      }
      int i = getSize();
      if (i >= this.capacity)
      {
        paramE = AbstractChannelKt.OFFER_FAILED;
        return paramE;
      }
      if (!paramSelectInstance.trySelect())
      {
        paramE = SelectKt.getALREADY_SELECTED();
        return paramE;
      }
      long l = getTail();
      this.buffer[((int)(l % this.capacity))] = paramE;
      setSize(i + 1);
      setTail(l + 1L);
      paramE = Unit.INSTANCE;
      localLock.unlock();
      checkSubOffers();
      return AbstractChannelKt.OFFER_SUCCESS;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  @NotNull
  public ReceiveChannel<E> openSubscription()
  {
    ArrayBroadcastChannel.Subscriber localSubscriber = new ArrayBroadcastChannel.Subscriber(this);
    updateHead$default(this, localSubscriber, null, 2, null);
    return (ReceiveChannel)localSubscriber;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ArrayBroadcastChannel
 * JD-Core Version:    0.7.0.1
 */