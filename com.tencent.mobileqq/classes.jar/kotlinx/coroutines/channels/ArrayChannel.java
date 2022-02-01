package kotlinx.coroutines.channels;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/ArrayChannel;", "E", "", "capacity", "<init>", "(I)V", "Lkotlinx/coroutines/channels/Receive;", "receive", "", "enqueueReceiveInternal", "(Lkotlinx/coroutines/channels/Receive;)Z", "Lkotlinx/coroutines/channels/Send;", "send", "", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "currentSize", "", "ensureCapacity", "element", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "wasClosed", "onCancelIdempotent", "(Z)V", "pollInternal", "()Ljava/lang/Object;", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "", "buffer", "[Ljava/lang/Object;", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "I", "getCapacity", "()I", "head", "isBufferAlwaysEmpty", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "isClosedForReceive", "isEmpty", "isFull", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/AbstractChannel;"}, k=1, mv={1, 1, 16})
public class ArrayChannel<E>
  extends AbstractChannel<E>
{
  private Object[] buffer;
  private final int capacity;
  private int head;
  private final ReentrantLock lock;
  private volatile int size;
  
  public ArrayChannel(int paramInt)
  {
    this.capacity = paramInt;
    int i = this.capacity;
    paramInt = 1;
    if (i < 1) {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      this.lock = new ReentrantLock();
      this.buffer = new Object[Math.min(this.capacity, 8)];
      this.size = 0;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ArrayChannel capacity must be at least 1, but ");
    localStringBuilder.append(this.capacity);
    localStringBuilder.append(" was specified");
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString().toString()));
  }
  
  private final void ensureCapacity(int paramInt)
  {
    Object[] arrayOfObject1 = this.buffer;
    if (paramInt >= arrayOfObject1.length)
    {
      arrayOfObject1 = new Object[Math.min(arrayOfObject1.length * 2, this.capacity)];
      int i = 0;
      while (i < paramInt)
      {
        Object[] arrayOfObject2 = this.buffer;
        arrayOfObject1[i] = arrayOfObject2[((this.head + i) % arrayOfObject2.length)];
        i += 1;
      }
      this.buffer = arrayOfObject1;
      this.head = 0;
    }
  }
  
  protected boolean enqueueReceiveInternal(@NotNull Receive<? super E> paramReceive)
  {
    Lock localLock = (Lock)this.lock;
    localLock.lock();
    try
    {
      boolean bool = super.enqueueReceiveInternal(paramReceive);
      return bool;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  @Nullable
  protected Object enqueueSend(@NotNull Send paramSend)
  {
    Lock localLock = (Lock)this.lock;
    localLock.lock();
    try
    {
      paramSend = super.enqueueSend(paramSend);
      return paramSend;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  @NotNull
  protected String getBufferDebugString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(buffer:capacity=");
    localStringBuilder.append(this.capacity);
    localStringBuilder.append(",size=");
    localStringBuilder.append(this.size);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public final int getCapacity()
  {
    return this.capacity;
  }
  
  protected final boolean isBufferAlwaysEmpty()
  {
    return false;
  }
  
  protected final boolean isBufferAlwaysFull()
  {
    return false;
  }
  
  protected final boolean isBufferEmpty()
  {
    return this.size == 0;
  }
  
  protected final boolean isBufferFull()
  {
    return this.size == this.capacity;
  }
  
  public boolean isClosedForReceive()
  {
    Lock localLock = (Lock)this.lock;
    localLock.lock();
    try
    {
      boolean bool = super.isClosedForReceive();
      return bool;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public boolean isEmpty()
  {
    Lock localLock = (Lock)this.lock;
    localLock.lock();
    try
    {
      boolean bool = isEmptyImpl();
      return bool;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public boolean isFull()
  {
    Lock localLock = (Lock)this.lock;
    localLock.lock();
    try
    {
      boolean bool = isFullImpl();
      return bool;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  @NotNull
  protected Object offerInternal(E paramE)
  {
    localObject1 = (ReceiveOrClosed)null;
    localObject1 = (Lock)this.lock;
    ((Lock)localObject1).lock();
    try
    {
      j = this.size;
      localObject2 = getClosedForSend();
      if (localObject2 != null)
      {
        ((Lock)localObject1).unlock();
        return localObject2;
      }
      if (j >= this.capacity) {
        break label248;
      }
      this.size = (j + 1);
      if (j != 0) {
        break label212;
      }
      do
      {
        localObject2 = takeFirstReceiveOrPeekClosed();
        if (localObject2 == null) {
          break;
        }
        if ((localObject2 instanceof Closed))
        {
          this.size = j;
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          ((Lock)localObject1).unlock();
          return localObject2;
        }
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        localObject3 = ((ReceiveOrClosed)localObject2).tryResumeReceive(paramE, null);
      } while (localObject3 == null);
      if (!DebugKt.getASSERTIONS_ENABLED()) {
        break label163;
      }
      if (localObject3 != CancellableContinuationImplKt.RESUME_TOKEN) {
        break label277;
      }
      i = 1;
    }
    finally
    {
      for (;;)
      {
        int j;
        Object localObject2;
        Object localObject3;
        ((Lock)localObject1).unlock();
        for (;;)
        {
          throw paramE;
        }
        int i = 0;
        if (i == 0) {}
      }
    }
    throw ((Throwable)new AssertionError());
    label163:
    this.size = j;
    localObject3 = Unit.INSTANCE;
    ((Lock)localObject1).unlock();
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    ((ReceiveOrClosed)localObject2).completeResumeReceive(paramE);
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    return ((ReceiveOrClosed)localObject2).getOfferResult();
    label212:
    ensureCapacity(j);
    this.buffer[((this.head + j) % this.buffer.length)] = paramE;
    paramE = AbstractChannelKt.OFFER_SUCCESS;
    ((Lock)localObject1).unlock();
    return paramE;
    label248:
    paramE = AbstractChannelKt.OFFER_FAILED;
    ((Lock)localObject1).unlock();
    return paramE;
  }
  
  @NotNull
  protected Object offerSelectInternal(E paramE, @NotNull SelectInstance<?> paramSelectInstance)
  {
    Object localObject1 = (ReceiveOrClosed)null;
    localObject1 = (Lock)this.lock;
    ((Lock)localObject1).lock();
    try
    {
      int i = this.size;
      Object localObject2 = getClosedForSend();
      if (localObject2 != null)
      {
        ((Lock)localObject1).unlock();
        return localObject2;
      }
      if (i < this.capacity)
      {
        this.size = (i + 1);
        if (i == 0)
        {
          do
          {
            AbstractSendChannel.TryOfferDesc localTryOfferDesc = describeTryOffer(paramE);
            localObject2 = paramSelectInstance.performAtomicTrySelect((AtomicDesc)localTryOfferDesc);
            if (localObject2 == null)
            {
              this.size = i;
              paramSelectInstance = (ReceiveOrClosed)localTryOfferDesc.getResult();
              localObject2 = Unit.INSTANCE;
              ((Lock)localObject1).unlock();
              if (paramSelectInstance == null) {
                Intrinsics.throwNpe();
              }
              paramSelectInstance.completeResumeReceive(paramE);
              if (paramSelectInstance == null) {
                Intrinsics.throwNpe();
              }
              return paramSelectInstance.getOfferResult();
            }
            if (localObject2 == AbstractChannelKt.OFFER_FAILED) {
              break;
            }
          } while (localObject2 == AtomicKt.RETRY_ATOMIC);
          if ((localObject2 != SelectKt.getALREADY_SELECTED()) && (!(localObject2 instanceof Closed)))
          {
            paramE = new StringBuilder();
            paramE.append("performAtomicTrySelect(describeTryOffer) returned ");
            paramE.append(localObject2);
            throw ((Throwable)new IllegalStateException(paramE.toString().toString()));
          }
          this.size = i;
          ((Lock)localObject1).unlock();
          return localObject2;
        }
        if (!paramSelectInstance.trySelect())
        {
          this.size = i;
          paramE = SelectKt.getALREADY_SELECTED();
          ((Lock)localObject1).unlock();
          return paramE;
        }
        ensureCapacity(i);
        this.buffer[((this.head + i) % this.buffer.length)] = paramE;
        paramE = AbstractChannelKt.OFFER_SUCCESS;
        ((Lock)localObject1).unlock();
        return paramE;
      }
      paramE = AbstractChannelKt.OFFER_FAILED;
      ((Lock)localObject1).unlock();
      return paramE;
    }
    finally
    {
      ((Lock)localObject1).unlock();
    }
    for (;;)
    {
      throw paramE;
    }
  }
  
  protected void onCancelIdempotent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Lock localLock = (Lock)this.lock;
      localLock.lock();
      try
      {
        int j = this.size;
        int i = 0;
        while (i < j)
        {
          this.buffer[this.head] = Integer.valueOf(0);
          this.head = ((this.head + 1) % this.buffer.length);
          i += 1;
        }
        this.size = 0;
        Unit localUnit = Unit.INSTANCE;
      }
      finally
      {
        localLock.unlock();
      }
    }
    super.onCancelIdempotent(paramBoolean);
  }
  
  @Nullable
  protected Object pollInternal()
  {
    localObject4 = (Send)null;
    localLock = (Lock)this.lock;
    localLock.lock();
    try
    {
      m = this.size;
      if (m == 0)
      {
        localObject1 = getClosedForSend();
        if (localObject1 == null) {
          localObject1 = AbstractChannelKt.POLL_FAILED;
        }
        localLock.unlock();
        return localObject1;
      }
      localObject7 = this.buffer[this.head];
      this.buffer[this.head] = null;
      this.size = (m - 1);
      localObject6 = AbstractChannelKt.POLL_FAILED;
      int n = this.capacity;
      k = 0;
      j = 0;
      localObject1 = localObject4;
      localObject5 = localObject6;
      i = j;
      if (m != n) {
        break label221;
      }
      localObject1 = localObject4;
    }
    finally
    {
      for (;;)
      {
        int m;
        Object localObject1;
        Object localObject7;
        Object localObject6;
        int k;
        int j;
        Object localObject5;
        int i;
        localLock.unlock();
        for (;;)
        {
          throw localObject2;
        }
        if (i != 0)
        {
          continue;
          Object localObject3 = localObject4;
        }
      }
    }
    localObject4 = takeFirstSendOrPeekClosed();
    localObject5 = localObject6;
    i = j;
    if (localObject4 != null)
    {
      if (localObject4 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((Send)localObject4).tryResumeSend(null);
      if (localObject1 == null) {
        break label336;
      }
      if (DebugKt.getASSERTIONS_ENABLED())
      {
        i = k;
        if (localObject1 != CancellableContinuationImplKt.RESUME_TOKEN) {
          break label329;
        }
        i = 1;
        break label329;
        throw ((Throwable)new AssertionError());
      }
      if (localObject4 == null) {
        Intrinsics.throwNpe();
      }
      localObject5 = ((Send)localObject4).getPollResult();
      localObject1 = localObject4;
      i = 1;
    }
    label221:
    if ((localObject5 != AbstractChannelKt.POLL_FAILED) && (!(localObject5 instanceof Closed)))
    {
      this.size = m;
      this.buffer[((this.head + m) % this.buffer.length)] = localObject5;
    }
    this.head = ((this.head + 1) % this.buffer.length);
    localObject4 = Unit.INSTANCE;
    localLock.unlock();
    if (i != 0)
    {
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      ((Send)localObject1).completeResumeSend();
    }
    return localObject7;
  }
  
  @Nullable
  protected Object pollSelectInternal(@NotNull SelectInstance<?> paramSelectInstance)
  {
    Send localSend = (Send)null;
    localLock = (Lock)this.lock;
    localLock.lock();
    try
    {
      j = this.size;
      if (j == 0)
      {
        paramSelectInstance = getClosedForSend();
        if (paramSelectInstance == null) {
          paramSelectInstance = AbstractChannelKt.POLL_FAILED;
        }
        localLock.unlock();
        return paramSelectInstance;
      }
      localObject3 = this.buffer[this.head];
      this.buffer[this.head] = null;
      this.size = (j - 1);
      localObject2 = AbstractChannelKt.POLL_FAILED;
      if (j != this.capacity) {
        break label412;
      }
      do
      {
        AbstractChannel.TryPollDesc localTryPollDesc = describeTryPoll();
        localObject1 = paramSelectInstance.performAtomicTrySelect((AtomicDesc)localTryPollDesc);
        if (localObject1 == null)
        {
          localSend = (Send)localTryPollDesc.getResult();
          if (localSend == null) {
            Intrinsics.throwNpe();
          }
          localObject1 = localSend.getPollResult();
          break;
        }
        if (localObject1 == AbstractChannelKt.POLL_FAILED) {
          break label412;
        }
      } while (localObject1 == AtomicKt.RETRY_ATOMIC);
      if (localObject1 == SelectKt.getALREADY_SELECTED())
      {
        this.size = j;
        this.buffer[this.head] = localObject3;
        localLock.unlock();
        return localObject1;
      }
      if ((localObject1 instanceof Closed))
      {
        localSend = (Send)localObject1;
        break label407;
      }
      paramSelectInstance = new StringBuilder();
      paramSelectInstance.append("performAtomicTrySelect(describeTryOffer) returned ");
      paramSelectInstance.append(localObject1);
      throw ((Throwable)new IllegalStateException(paramSelectInstance.toString().toString()));
    }
    finally
    {
      for (;;)
      {
        int j;
        Object localObject3;
        Object localObject2;
        localLock.unlock();
        for (;;)
        {
          throw paramSelectInstance;
        }
        int i = 1;
        continue;
        i = 0;
        Object localObject1 = localObject2;
      }
    }
    if ((localObject1 != AbstractChannelKt.POLL_FAILED) && (!(localObject1 instanceof Closed)))
    {
      this.size = j;
      this.buffer[((this.head + j) % this.buffer.length)] = localObject1;
    }
    else if (!paramSelectInstance.trySelect())
    {
      this.size = j;
      this.buffer[this.head] = localObject3;
      paramSelectInstance = SelectKt.getALREADY_SELECTED();
      localLock.unlock();
      return paramSelectInstance;
    }
    this.head = ((this.head + 1) % this.buffer.length);
    paramSelectInstance = Unit.INSTANCE;
    localLock.unlock();
    if (i != 0)
    {
      if (localSend == null) {
        Intrinsics.throwNpe();
      }
      localSend.completeResumeSend();
    }
    return localObject3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ArrayChannel
 * JD-Core Version:    0.7.0.1
 */