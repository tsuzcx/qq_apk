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
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/ConflatedChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "()V", "bufferDebugString", "", "getBufferDebugString", "()Ljava/lang/String;", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "isEmpty", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "value", "", "enqueueReceiveInternal", "receive", "Lkotlinx/coroutines/channels/Receive;", "offerInternal", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "onCancelIdempotent", "", "wasClosed", "pollInternal", "pollSelectInternal", "Companion", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public class ConflatedChannel<E>
  extends AbstractChannel<E>
{
  private static final ConflatedChannel.Companion Companion = new ConflatedChannel.Companion(null);
  private static final Symbol EMPTY = new Symbol("EMPTY");
  private final ReentrantLock lock = new ReentrantLock();
  private Object value = EMPTY;
  
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
  
  @NotNull
  protected String getBufferDebugString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(value=");
    localStringBuilder.append(this.value);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
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
    return this.value == EMPTY;
  }
  
  protected final boolean isBufferFull()
  {
    return false;
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
  
  @NotNull
  protected Object offerInternal(E paramE)
  {
    localObject1 = (ReceiveOrClosed)null;
    localObject1 = (Lock)this.lock;
    ((Lock)localObject1).lock();
    try
    {
      localObject2 = getClosedForSend();
      if (localObject2 != null)
      {
        ((Lock)localObject1).unlock();
        return localObject2;
      }
      if (this.value != EMPTY) {
        break label182;
      }
      do
      {
        localObject2 = takeFirstReceiveOrPeekClosed();
        if (localObject2 == null) {
          break;
        }
        if ((localObject2 instanceof Closed))
        {
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
        break label139;
      }
      if (localObject3 != CancellableContinuationImplKt.RESUME_TOKEN) {
        break label214;
      }
      i = 1;
    }
    finally
    {
      for (;;)
      {
        Object localObject2;
        Object localObject3;
        label139:
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
    label182:
    this.value = paramE;
    paramE = AbstractChannelKt.OFFER_SUCCESS;
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
      Object localObject2 = getClosedForSend();
      if (localObject2 != null)
      {
        ((Lock)localObject1).unlock();
        return localObject2;
      }
      if (this.value == EMPTY)
      {
        do
        {
          AbstractSendChannel.TryOfferDesc localTryOfferDesc = describeTryOffer(paramE);
          localObject2 = paramSelectInstance.performAtomicTrySelect((AtomicDesc)localTryOfferDesc);
          if (localObject2 == null)
          {
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
        ((Lock)localObject1).unlock();
        return localObject2;
      }
      if (!paramSelectInstance.trySelect())
      {
        paramE = SelectKt.getALREADY_SELECTED();
        ((Lock)localObject1).unlock();
        return paramE;
      }
      this.value = paramE;
      paramE = AbstractChannelKt.OFFER_SUCCESS;
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
    Lock localLock;
    if (paramBoolean)
    {
      localLock = (Lock)this.lock;
      localLock.lock();
    }
    try
    {
      this.value = EMPTY;
      Unit localUnit = Unit.INSTANCE;
      localLock.unlock();
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  @Nullable
  protected Object pollInternal()
  {
    Lock localLock = (Lock)this.lock;
    localLock.lock();
    try
    {
      if (this.value == EMPTY)
      {
        localObject1 = getClosedForSend();
        if (localObject1 == null) {
          localObject1 = AbstractChannelKt.POLL_FAILED;
        }
        return localObject1;
      }
      Object localObject1 = this.value;
      this.value = EMPTY;
      Unit localUnit = Unit.INSTANCE;
      return localObject1;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  @Nullable
  protected Object pollSelectInternal(@NotNull SelectInstance<?> paramSelectInstance)
  {
    Lock localLock = (Lock)this.lock;
    localLock.lock();
    try
    {
      if (this.value == EMPTY)
      {
        paramSelectInstance = getClosedForSend();
        if (paramSelectInstance == null) {
          paramSelectInstance = AbstractChannelKt.POLL_FAILED;
        }
        return paramSelectInstance;
      }
      if (!paramSelectInstance.trySelect())
      {
        paramSelectInstance = SelectKt.getALREADY_SELECTED();
        return paramSelectInstance;
      }
      paramSelectInstance = this.value;
      this.value = EMPTY;
      Unit localUnit = Unit.INSTANCE;
      return paramSelectInstance;
    }
    finally
    {
      localLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ConflatedChannel
 * JD-Core Version:    0.7.0.1
 */