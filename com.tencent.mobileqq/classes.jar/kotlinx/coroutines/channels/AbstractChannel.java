package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.CondAddOp;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/AbstractChannel;", "E", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/Channel;", "()V", "hasReceiveOrClosed", "", "getHasReceiveOrClosed", "()Z", "isBufferAlwaysEmpty", "isBufferEmpty", "isClosedForReceive", "isEmpty", "isEmptyImpl", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveOrClosed", "Lkotlinx/coroutines/channels/ValueOrClosed;", "getOnReceiveOrClosed", "onReceiveOrNull", "getOnReceiveOrNull", "cancel", "cause", "", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", "cancelInternal$kotlinx_coroutines_core", "describeTryPoll", "Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "enqueueReceive", "receive", "Lkotlinx/coroutines/channels/Receive;", "enqueueReceiveInternal", "enqueueReceiveSelect", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "receiveMode", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)Z", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "onCancelIdempotent", "wasClosed", "onReceiveDequeued", "onReceiveEnqueued", "poll", "()Ljava/lang/Object;", "pollInternal", "pollSelectInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveOrClosed", "receiveOrNull", "receiveOrNullResult", "result", "(Ljava/lang/Object;)Ljava/lang/Object;", "receiveSuspend", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerSelectReceiveMode", "(Lkotlinx/coroutines/selects/SelectInstance;ILkotlin/jvm/functions/Function2;)V", "removeReceiveOnCancel", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "takeFirstReceiveOrPeekClosed", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "tryStartBlockUnintercepted", "value", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/selects/SelectInstance;ILjava/lang/Object;)V", "Itr", "ReceiveElement", "ReceiveHasNext", "ReceiveSelect", "RemoveReceiveOnCancel", "TryPollDesc", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract class AbstractChannel<E>
  extends AbstractSendChannel<E>
  implements Channel<E>
{
  private final boolean enqueueReceive(Receive<? super E> paramReceive)
  {
    boolean bool = enqueueReceiveInternal(paramReceive);
    if (bool) {
      onReceiveEnqueued();
    }
    return bool;
  }
  
  private final <R> boolean enqueueReceiveSelect(SelectInstance<? super R> paramSelectInstance, Function2<Object, ? super Continuation<? super R>, ? extends Object> paramFunction2, int paramInt)
  {
    paramFunction2 = new AbstractChannel.ReceiveSelect(this, paramSelectInstance, paramFunction2, paramInt);
    boolean bool = enqueueReceive((Receive)paramFunction2);
    if (bool) {
      paramSelectInstance.disposeOnSelect((DisposableHandle)paramFunction2);
    }
    return bool;
  }
  
  private final E receiveOrNullResult(Object paramObject)
  {
    if ((paramObject instanceof Closed))
    {
      paramObject = (Closed)paramObject;
      if (paramObject.closeCause == null) {
        return null;
      }
      throw StackTraceRecoveryKt.recoverStackTrace(paramObject.closeCause);
    }
    return paramObject;
  }
  
  private final <R> void registerSelectReceiveMode(SelectInstance<? super R> paramSelectInstance, int paramInt, Function2<Object, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    for (;;)
    {
      if (paramSelectInstance.isSelected()) {
        return;
      }
      if (isEmptyImpl())
      {
        if (!enqueueReceiveSelect(paramSelectInstance, paramFunction2, paramInt)) {}
      }
      else
      {
        Object localObject = pollSelectInternal(paramSelectInstance);
        if (localObject == SelectKt.getALREADY_SELECTED()) {
          return;
        }
        if ((localObject != AbstractChannelKt.POLL_FAILED) && (localObject != AtomicKt.RETRY_ATOMIC)) {
          tryStartBlockUnintercepted(paramFunction2, paramSelectInstance, paramInt, localObject);
        }
      }
    }
  }
  
  private final void removeReceiveOnCancel(CancellableContinuation<?> paramCancellableContinuation, Receive<?> paramReceive)
  {
    paramCancellableContinuation.invokeOnCancellation((Function1)new AbstractChannel.RemoveReceiveOnCancel(this, paramReceive));
  }
  
  private final <R> void tryStartBlockUnintercepted(@NotNull Function2<Object, ? super Continuation<? super R>, ? extends Object> paramFunction2, SelectInstance<? super R> paramSelectInstance, int paramInt, Object paramObject)
  {
    boolean bool = paramObject instanceof Closed;
    ValueOrClosed.Companion localCompanion;
    if (bool)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2) {
            return;
          }
          if (!paramSelectInstance.trySelect()) {
            return;
          }
          localCompanion = ValueOrClosed.Companion;
          UndispatchedKt.startCoroutineUnintercepted(paramFunction2, ValueOrClosed.box-impl(ValueOrClosed.constructor-impl(new ValueOrClosed.Closed(((Closed)paramObject).closeCause))), paramSelectInstance.getCompletion());
          return;
        }
        paramObject = (Closed)paramObject;
        if (paramObject.closeCause == null)
        {
          if (!paramSelectInstance.trySelect()) {
            return;
          }
          UndispatchedKt.startCoroutineUnintercepted(paramFunction2, null, paramSelectInstance.getCompletion());
          return;
        }
        throw StackTraceRecoveryKt.recoverStackTrace(paramObject.getReceiveException());
      }
      throw StackTraceRecoveryKt.recoverStackTrace(((Closed)paramObject).getReceiveException());
    }
    if (paramInt == 2)
    {
      if (bool)
      {
        localCompanion = ValueOrClosed.Companion;
        paramObject = ValueOrClosed.constructor-impl(new ValueOrClosed.Closed(((Closed)paramObject).closeCause));
      }
      else
      {
        localCompanion = ValueOrClosed.Companion;
        paramObject = ValueOrClosed.constructor-impl(paramObject);
      }
      UndispatchedKt.startCoroutineUnintercepted(paramFunction2, ValueOrClosed.box-impl(paramObject), paramSelectInstance.getCompletion());
      return;
    }
    UndispatchedKt.startCoroutineUnintercepted(paramFunction2, paramObject, paramSelectInstance.getCompletion());
  }
  
  public final void cancel(@Nullable CancellationException paramCancellationException)
  {
    if (paramCancellationException == null)
    {
      paramCancellationException = new StringBuilder();
      paramCancellationException.append(DebugStringsKt.getClassSimpleName(this));
      paramCancellationException.append(" was cancelled");
      paramCancellationException = new CancellationException(paramCancellationException.toString());
    }
    cancelInternal$kotlinx_coroutines_core((Throwable)paramCancellationException);
  }
  
  public final boolean cancelInternal$kotlinx_coroutines_core(@Nullable Throwable paramThrowable)
  {
    boolean bool = close(paramThrowable);
    onCancelIdempotent(bool);
    return bool;
  }
  
  @NotNull
  protected final AbstractChannel.TryPollDesc<E> describeTryPoll()
  {
    return new AbstractChannel.TryPollDesc(getQueue());
  }
  
  protected boolean enqueueReceiveInternal(@NotNull Receive<? super E> paramReceive)
  {
    boolean bool1 = isBufferAlwaysEmpty();
    boolean bool2 = false;
    LockFreeLinkedListNode localLockFreeLinkedListNode1;
    Object localObject;
    int i;
    if (bool1)
    {
      localLockFreeLinkedListNode1 = (LockFreeLinkedListNode)getQueue();
      do
      {
        localObject = localLockFreeLinkedListNode1.getPrevNode();
        if (!(localObject instanceof Send)) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0) {
          return false;
        }
      } while (!((LockFreeLinkedListNode)localObject).addNext((LockFreeLinkedListNode)paramReceive, localLockFreeLinkedListNode1));
    }
    else
    {
      localLockFreeLinkedListNode1 = (LockFreeLinkedListNode)getQueue();
      paramReceive = (LockFreeLinkedListNode)paramReceive;
      localObject = (LockFreeLinkedListNode.CondAddOp)new AbstractChannel.enqueueReceiveInternal..inlined.addLastIfPrevAndIf.1(paramReceive, paramReceive, this);
      for (;;)
      {
        LockFreeLinkedListNode localLockFreeLinkedListNode2 = localLockFreeLinkedListNode1.getPrevNode();
        if (!(localLockFreeLinkedListNode2 instanceof Send)) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0) {
          return false;
        }
        i = localLockFreeLinkedListNode2.tryCondAddNext(paramReceive, localLockFreeLinkedListNode1, (LockFreeLinkedListNode.CondAddOp)localObject);
        if (i == 1) {
          break;
        }
        bool1 = bool2;
        if (i == 2) {
          return bool1;
        }
      }
    }
    bool1 = true;
    return bool1;
  }
  
  protected final boolean getHasReceiveOrClosed()
  {
    return getQueue().getNextNode() instanceof ReceiveOrClosed;
  }
  
  @NotNull
  public final SelectClause1<E> getOnReceive()
  {
    return (SelectClause1)new AbstractChannel.onReceive.1(this);
  }
  
  @NotNull
  public final SelectClause1<ValueOrClosed<E>> getOnReceiveOrClosed()
  {
    return (SelectClause1)new AbstractChannel.onReceiveOrClosed.1(this);
  }
  
  @NotNull
  public final SelectClause1<E> getOnReceiveOrNull()
  {
    return (SelectClause1)new AbstractChannel.onReceiveOrNull.1(this);
  }
  
  protected abstract boolean isBufferAlwaysEmpty();
  
  protected abstract boolean isBufferEmpty();
  
  public boolean isClosedForReceive()
  {
    return (getClosedForReceive() != null) && (isBufferEmpty());
  }
  
  public boolean isEmpty()
  {
    return isEmptyImpl();
  }
  
  protected final boolean isEmptyImpl()
  {
    return (!(getQueue().getNextNode() instanceof Send)) && (isBufferEmpty());
  }
  
  @NotNull
  public final ChannelIterator<E> iterator()
  {
    return (ChannelIterator)new AbstractChannel.Itr(this);
  }
  
  protected void onCancelIdempotent(boolean paramBoolean)
  {
    Closed localClosed = getClosedForSend();
    if (localClosed != null)
    {
      localObject = InlineList.constructor-impl$default(null, 1, null);
      for (;;)
      {
        LockFreeLinkedListNode localLockFreeLinkedListNode = localClosed.getPrevNode();
        if ((localLockFreeLinkedListNode instanceof LockFreeLinkedListHead))
        {
          if (localObject == null) {
            return;
          }
          if (!(localObject instanceof ArrayList))
          {
            ((Send)localObject).resumeSendClosed(localClosed);
            return;
          }
          if (localObject != null)
          {
            localObject = (ArrayList)localObject;
            int i = ((ArrayList)localObject).size() - 1;
            while (i >= 0)
            {
              ((Send)((ArrayList)localObject).get(i)).resumeSendClosed(localClosed);
              i -= 1;
            }
            return;
          }
          throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<E> /* = java.util.ArrayList<E> */");
        }
        if ((DebugKt.getASSERTIONS_ENABLED()) && (!(localLockFreeLinkedListNode instanceof Send))) {
          throw ((Throwable)new AssertionError());
        }
        if (!localLockFreeLinkedListNode.remove())
        {
          localLockFreeLinkedListNode.helpRemove();
        }
        else
        {
          if (localLockFreeLinkedListNode == null) {
            break;
          }
          localObject = InlineList.plus-impl(localObject, (Send)localLockFreeLinkedListNode);
        }
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.Send");
    }
    Object localObject = (Throwable)new IllegalStateException("Cannot happen".toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  protected void onReceiveDequeued() {}
  
  protected void onReceiveEnqueued() {}
  
  @Nullable
  public final E poll()
  {
    Object localObject = pollInternal();
    if (localObject == AbstractChannelKt.POLL_FAILED) {
      return null;
    }
    return receiveOrNullResult(localObject);
  }
  
  @Nullable
  protected Object pollInternal()
  {
    Send localSend;
    Symbol localSymbol;
    do
    {
      localSend = takeFirstSendOrPeekClosed();
      if (localSend == null) {
        break;
      }
      localSymbol = localSend.tryResumeSend(null);
    } while (localSymbol == null);
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      int i;
      if (localSymbol == CancellableContinuationImplKt.RESUME_TOKEN) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    localSend.completeResumeSend();
    return localSend.getPollResult();
    return AbstractChannelKt.POLL_FAILED;
  }
  
  @Nullable
  protected Object pollSelectInternal(@NotNull SelectInstance<?> paramSelectInstance)
  {
    AbstractChannel.TryPollDesc localTryPollDesc = describeTryPoll();
    paramSelectInstance = paramSelectInstance.performAtomicTrySelect((AtomicDesc)localTryPollDesc);
    if (paramSelectInstance != null) {
      return paramSelectInstance;
    }
    ((Send)localTryPollDesc.getResult()).completeResumeSend();
    return ((Send)localTryPollDesc.getResult()).getPollResult();
  }
  
  @Nullable
  public final Object receive(@NotNull Continuation<? super E> paramContinuation)
  {
    Object localObject = pollInternal();
    if ((localObject != AbstractChannelKt.POLL_FAILED) && (!(localObject instanceof Closed))) {
      return localObject;
    }
    return receiveSuspend(0, paramContinuation);
  }
  
  @Nullable
  public final Object receiveOrClosed(@NotNull Continuation<? super ValueOrClosed<? extends E>> paramContinuation)
  {
    Object localObject = pollInternal();
    if (localObject != AbstractChannelKt.POLL_FAILED)
    {
      if ((localObject instanceof Closed))
      {
        paramContinuation = ValueOrClosed.Companion;
        paramContinuation = ValueOrClosed.constructor-impl(new ValueOrClosed.Closed(((Closed)localObject).closeCause));
      }
      else
      {
        paramContinuation = ValueOrClosed.Companion;
        paramContinuation = ValueOrClosed.constructor-impl(localObject);
      }
      return ValueOrClosed.box-impl(paramContinuation);
    }
    return receiveSuspend(2, paramContinuation);
  }
  
  @Nullable
  public final Object receiveOrNull(@NotNull Continuation<? super E> paramContinuation)
  {
    Object localObject = pollInternal();
    if ((localObject != AbstractChannelKt.POLL_FAILED) && (!(localObject instanceof Closed))) {
      return localObject;
    }
    return receiveSuspend(1, paramContinuation);
  }
  
  @Nullable
  protected ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed()
  {
    ReceiveOrClosed localReceiveOrClosed = super.takeFirstReceiveOrPeekClosed();
    if ((localReceiveOrClosed != null) && (!(localReceiveOrClosed instanceof Closed))) {
      onReceiveDequeued();
    }
    return localReceiveOrClosed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.AbstractChannel
 * JD-Core Version:    0.7.0.1
 */