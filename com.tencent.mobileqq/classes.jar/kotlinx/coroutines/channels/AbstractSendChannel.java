package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.YieldKt;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.AddLastDesc;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.CondAddOp;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/AbstractSendChannel;", "E", "<init>", "()V", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "", "countQueueSize", "()I", "element", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/AddLastDesc;", "describeSendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "describeSendConflated", "Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "describeTryOffer", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "Lkotlinx/coroutines/channels/Send;", "send", "", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Closed;", "closed", "", "helpClose", "(Lkotlinx/coroutines/channels/Closed;)V", "helpCloseAndGetSendException", "(Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "invokeOnCloseHandler", "(Ljava/lang/Throwable;)V", "offer", "(Ljava/lang/Object;)Z", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "onClosedIdempotent", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "R", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendFair$kotlinx_coroutines_core", "sendFair", "sendSuspend", "takeFirstReceiveOrPeekClosed", "()Lkotlinx/coroutines/channels/ReceiveOrClosed;", "takeFirstSendOrPeekClosed", "()Lkotlinx/coroutines/channels/Send;", "", "toString", "()Ljava/lang/String;", "helpCloseAndResumeWithSendException", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/channels/Closed;)V", "getBufferDebugString", "bufferDebugString", "getClosedForReceive", "()Lkotlinx/coroutines/channels/Closed;", "closedForReceive", "getClosedForSend", "closedForSend", "isBufferAlwaysFull", "()Z", "isBufferFull", "isClosedForSend", "isFull", "isFullImpl", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueue", "()Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueueDebugStateString", "queueDebugStateString", "SendBuffered", "SendBufferedDesc", "SendConflatedDesc", "SendSelect", "TryOfferDesc", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract class AbstractSendChannel<E>
  implements SendChannel<E>
{
  private static final AtomicReferenceFieldUpdater onCloseHandler$FU = AtomicReferenceFieldUpdater.newUpdater(AbstractSendChannel.class, Object.class, "onCloseHandler");
  private volatile Object onCloseHandler = null;
  @NotNull
  private final LockFreeLinkedListHead queue = new LockFreeLinkedListHead();
  
  private final int countQueueSize()
  {
    LockFreeLinkedListHead localLockFreeLinkedListHead = this.queue;
    Object localObject = localLockFreeLinkedListHead.getNext();
    if (localObject != null)
    {
      localObject = (LockFreeLinkedListNode)localObject;
      int j;
      for (int i = 0; (Intrinsics.areEqual(localObject, localLockFreeLinkedListHead) ^ true); i = j)
      {
        j = i;
        if ((localObject instanceof LockFreeLinkedListNode)) {
          j = i + 1;
        }
        localObject = ((LockFreeLinkedListNode)localObject).getNextNode();
      }
      return i;
    }
    localObject = new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private final String getQueueDebugStateString()
  {
    LockFreeLinkedListNode localLockFreeLinkedListNode1 = this.queue.getNextNode();
    if (localLockFreeLinkedListNode1 == this.queue) {
      return "EmptyQueue";
    }
    Object localObject1;
    if ((localLockFreeLinkedListNode1 instanceof Closed))
    {
      localObject1 = localLockFreeLinkedListNode1.toString();
    }
    else if ((localLockFreeLinkedListNode1 instanceof Receive))
    {
      localObject1 = "ReceiveQueued";
    }
    else if ((localLockFreeLinkedListNode1 instanceof Send))
    {
      localObject1 = "SendQueued";
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("UNEXPECTED:");
      ((StringBuilder)localObject1).append(localLockFreeLinkedListNode1);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    LockFreeLinkedListNode localLockFreeLinkedListNode2 = this.queue.getPrevNode();
    Object localObject2 = localObject1;
    if (localLockFreeLinkedListNode2 != localLockFreeLinkedListNode1)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(",queueSize=");
      ((StringBuilder)localObject2).append(countQueueSize());
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = localObject1;
      if ((localLockFreeLinkedListNode2 instanceof Closed))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(",closedForSend=");
        ((StringBuilder)localObject2).append(localLockFreeLinkedListNode2);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    return localObject2;
  }
  
  private final void helpClose(Closed<?> paramClosed)
  {
    Object localObject1 = InlineList.constructor-impl$default(null, 1, null);
    for (;;)
    {
      LockFreeLinkedListNode localLockFreeLinkedListNode = paramClosed.getPrevNode();
      Object localObject2 = localLockFreeLinkedListNode;
      if (!(localLockFreeLinkedListNode instanceof Receive)) {
        localObject2 = null;
      }
      localObject2 = (Receive)localObject2;
      if (localObject2 == null) {
        break;
      }
      if (!((Receive)localObject2).remove()) {
        ((Receive)localObject2).helpRemove();
      } else {
        localObject1 = InlineList.plus-impl(localObject1, localObject2);
      }
    }
    if (localObject1 != null) {
      if (!(localObject1 instanceof ArrayList))
      {
        ((Receive)localObject1).resumeReceiveClosed(paramClosed);
      }
      else
      {
        if (localObject1 == null) {
          break label139;
        }
        localObject1 = (ArrayList)localObject1;
        int i = ((ArrayList)localObject1).size() - 1;
        while (i >= 0)
        {
          ((Receive)((ArrayList)localObject1).get(i)).resumeReceiveClosed(paramClosed);
          i -= 1;
        }
      }
    }
    onClosedIdempotent((LockFreeLinkedListNode)paramClosed);
    return;
    label139:
    paramClosed = new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<E> /* = java.util.ArrayList<E> */");
    for (;;)
    {
      throw paramClosed;
    }
  }
  
  private final Throwable helpCloseAndGetSendException(Closed<?> paramClosed)
  {
    helpClose(paramClosed);
    return paramClosed.getSendException();
  }
  
  private final void helpCloseAndResumeWithSendException(@NotNull Continuation<?> paramContinuation, Closed<?> paramClosed)
  {
    helpClose(paramClosed);
    paramClosed = paramClosed.getSendException();
    Result.Companion localCompanion = Result.Companion;
    paramContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramClosed)));
  }
  
  private final void invokeOnCloseHandler(Throwable paramThrowable)
  {
    Object localObject = this.onCloseHandler;
    if ((localObject != null) && (localObject != AbstractChannelKt.HANDLER_INVOKED) && (onCloseHandler$FU.compareAndSet(this, localObject, AbstractChannelKt.HANDLER_INVOKED))) {
      ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(localObject, 1)).invoke(paramThrowable);
    }
  }
  
  private final <R> void registerSelectSend(SelectInstance<? super R> paramSelectInstance, E paramE, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    Object localObject;
    do
    {
      if (paramSelectInstance.isSelected()) {
        return;
      }
      if (isFullImpl())
      {
        AbstractSendChannel.SendSelect localSendSelect = new AbstractSendChannel.SendSelect(paramE, this, paramSelectInstance, paramFunction2);
        localObject = enqueueSend((Send)localSendSelect);
        if (localObject == null)
        {
          paramSelectInstance.disposeOnSelect((DisposableHandle)localSendSelect);
          return;
        }
        if (!(localObject instanceof Closed))
        {
          if ((localObject != AbstractChannelKt.ENQUEUE_FAILED) && (!(localObject instanceof Receive)))
          {
            paramSelectInstance = new StringBuilder();
            paramSelectInstance.append("enqueueSend returned ");
            paramSelectInstance.append(localObject);
            paramSelectInstance.append(' ');
            throw ((Throwable)new IllegalStateException(paramSelectInstance.toString().toString()));
          }
        }
        else {
          throw StackTraceRecoveryKt.recoverStackTrace(helpCloseAndGetSendException((Closed)localObject));
        }
      }
      localObject = offerSelectInternal(paramE, paramSelectInstance);
      if (localObject == SelectKt.getALREADY_SELECTED()) {
        return;
      }
    } while ((localObject == AbstractChannelKt.OFFER_FAILED) || (localObject == AtomicKt.RETRY_ATOMIC));
    if (localObject == AbstractChannelKt.OFFER_SUCCESS)
    {
      UndispatchedKt.startCoroutineUnintercepted(paramFunction2, this, paramSelectInstance.getCompletion());
      return;
    }
    if ((localObject instanceof Closed)) {
      throw StackTraceRecoveryKt.recoverStackTrace(helpCloseAndGetSendException((Closed)localObject));
    }
    paramSelectInstance = new StringBuilder();
    paramSelectInstance.append("offerSelectInternal returned ");
    paramSelectInstance.append(localObject);
    paramSelectInstance = (Throwable)new IllegalStateException(paramSelectInstance.toString().toString());
    for (;;)
    {
      throw paramSelectInstance;
    }
  }
  
  public boolean close(@Nullable Throwable paramThrowable)
  {
    Object localObject = new Closed(paramThrowable);
    LockFreeLinkedListNode localLockFreeLinkedListNode1 = (LockFreeLinkedListNode)this.queue;
    LockFreeLinkedListNode localLockFreeLinkedListNode2;
    boolean bool1;
    do
    {
      localLockFreeLinkedListNode2 = localLockFreeLinkedListNode1.getPrevNode();
      boolean bool2 = localLockFreeLinkedListNode2 instanceof Closed;
      bool1 = true;
      int i;
      if (!bool2) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        bool1 = false;
        break;
      }
    } while (!localLockFreeLinkedListNode2.addNext((LockFreeLinkedListNode)localObject, localLockFreeLinkedListNode1));
    if (!bool1)
    {
      localObject = this.queue.getPrevNode();
      if (localObject != null) {
        localObject = (Closed)localObject;
      }
    }
    else
    {
      helpClose((Closed)localObject);
      if (bool1) {
        invokeOnCloseHandler(paramThrowable);
      }
      return bool1;
    }
    paramThrowable = new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.Closed<*>");
    for (;;)
    {
      throw paramThrowable;
    }
  }
  
  @NotNull
  protected final LockFreeLinkedListNode.AddLastDesc<?> describeSendBuffered(E paramE)
  {
    return (LockFreeLinkedListNode.AddLastDesc)new AbstractSendChannel.SendBufferedDesc(this.queue, paramE);
  }
  
  @NotNull
  protected final LockFreeLinkedListNode.AddLastDesc<?> describeSendConflated(E paramE)
  {
    return (LockFreeLinkedListNode.AddLastDesc)new AbstractSendChannel.SendConflatedDesc(this.queue, paramE);
  }
  
  @NotNull
  protected final AbstractSendChannel.TryOfferDesc<E> describeTryOffer(E paramE)
  {
    return new AbstractSendChannel.TryOfferDesc(paramE, this.queue);
  }
  
  @Nullable
  protected Object enqueueSend(@NotNull Send paramSend)
  {
    LockFreeLinkedListNode localLockFreeLinkedListNode1;
    Object localObject;
    if (isBufferAlwaysFull())
    {
      localLockFreeLinkedListNode1 = (LockFreeLinkedListNode)this.queue;
      do
      {
        localObject = localLockFreeLinkedListNode1.getPrevNode();
        if ((localObject instanceof ReceiveOrClosed)) {
          return localObject;
        }
      } while (!((LockFreeLinkedListNode)localObject).addNext((LockFreeLinkedListNode)paramSend, localLockFreeLinkedListNode1));
    }
    else
    {
      localLockFreeLinkedListNode1 = (LockFreeLinkedListNode)this.queue;
      paramSend = (LockFreeLinkedListNode)paramSend;
      localObject = (LockFreeLinkedListNode.CondAddOp)new AbstractSendChannel.enqueueSend..inlined.addLastIfPrevAndIf.1(paramSend, paramSend, this);
      int j;
      do
      {
        LockFreeLinkedListNode localLockFreeLinkedListNode2 = localLockFreeLinkedListNode1.getPrevNode();
        if ((localLockFreeLinkedListNode2 instanceof ReceiveOrClosed)) {
          return localLockFreeLinkedListNode2;
        }
        j = localLockFreeLinkedListNode2.tryCondAddNext(paramSend, localLockFreeLinkedListNode1, (LockFreeLinkedListNode.CondAddOp)localObject);
        i = 1;
        if (j == 1) {
          break;
        }
      } while (j != 2);
      int i = 0;
      if (i == 0) {
        return AbstractChannelKt.ENQUEUE_FAILED;
      }
    }
    return null;
  }
  
  @NotNull
  protected String getBufferDebugString()
  {
    return "";
  }
  
  @Nullable
  protected final Closed<?> getClosedForReceive()
  {
    LockFreeLinkedListNode localLockFreeLinkedListNode = this.queue.getNextNode();
    Object localObject = localLockFreeLinkedListNode;
    if (!(localLockFreeLinkedListNode instanceof Closed)) {
      localObject = null;
    }
    localObject = (Closed)localObject;
    if (localObject != null)
    {
      helpClose((Closed)localObject);
      return localObject;
    }
    return null;
  }
  
  @Nullable
  protected final Closed<?> getClosedForSend()
  {
    LockFreeLinkedListNode localLockFreeLinkedListNode = this.queue.getPrevNode();
    Object localObject = localLockFreeLinkedListNode;
    if (!(localLockFreeLinkedListNode instanceof Closed)) {
      localObject = null;
    }
    localObject = (Closed)localObject;
    if (localObject != null)
    {
      helpClose((Closed)localObject);
      return localObject;
    }
    return null;
  }
  
  @NotNull
  public final SelectClause2<E, SendChannel<E>> getOnSend()
  {
    return (SelectClause2)new AbstractSendChannel.onSend.1(this);
  }
  
  @NotNull
  protected final LockFreeLinkedListHead getQueue()
  {
    return this.queue;
  }
  
  public void invokeOnClose(@NotNull Function1<? super Throwable, Unit> paramFunction1)
  {
    if (!onCloseHandler$FU.compareAndSet(this, null, paramFunction1))
    {
      paramFunction1 = this.onCloseHandler;
      if (paramFunction1 == AbstractChannelKt.HANDLER_INVOKED) {
        throw ((Throwable)new IllegalStateException("Another handler was already registered and successfully invoked"));
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Another handler was already registered: ");
      ((StringBuilder)localObject).append(paramFunction1);
      throw ((Throwable)new IllegalStateException(((StringBuilder)localObject).toString()));
    }
    Object localObject = getClosedForSend();
    if ((localObject != null) && (onCloseHandler$FU.compareAndSet(this, paramFunction1, AbstractChannelKt.HANDLER_INVOKED))) {
      paramFunction1.invoke(((Closed)localObject).closeCause);
    }
  }
  
  protected abstract boolean isBufferAlwaysFull();
  
  protected abstract boolean isBufferFull();
  
  public final boolean isClosedForSend()
  {
    return getClosedForSend() != null;
  }
  
  public boolean isFull()
  {
    return isFullImpl();
  }
  
  protected final boolean isFullImpl()
  {
    return (!(this.queue.getNextNode() instanceof ReceiveOrClosed)) && (isBufferFull());
  }
  
  public final boolean offer(E paramE)
  {
    paramE = offerInternal(paramE);
    if (paramE == AbstractChannelKt.OFFER_SUCCESS) {
      return true;
    }
    if (paramE == AbstractChannelKt.OFFER_FAILED)
    {
      paramE = getClosedForSend();
      if (paramE == null) {
        return false;
      }
      throw StackTraceRecoveryKt.recoverStackTrace(helpCloseAndGetSendException(paramE));
    }
    if ((paramE instanceof Closed)) {
      throw StackTraceRecoveryKt.recoverStackTrace(helpCloseAndGetSendException((Closed)paramE));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("offerInternal returned ");
    localStringBuilder.append(paramE);
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString().toString()));
  }
  
  @NotNull
  protected Object offerInternal(E paramE)
  {
    ReceiveOrClosed localReceiveOrClosed;
    Symbol localSymbol;
    do
    {
      localReceiveOrClosed = takeFirstReceiveOrPeekClosed();
      if (localReceiveOrClosed == null) {
        break;
      }
      localSymbol = localReceiveOrClosed.tryResumeReceive(paramE, null);
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
    localReceiveOrClosed.completeResumeReceive(paramE);
    return localReceiveOrClosed.getOfferResult();
    return AbstractChannelKt.OFFER_FAILED;
  }
  
  @NotNull
  protected Object offerSelectInternal(E paramE, @NotNull SelectInstance<?> paramSelectInstance)
  {
    AbstractSendChannel.TryOfferDesc localTryOfferDesc = describeTryOffer(paramE);
    paramSelectInstance = paramSelectInstance.performAtomicTrySelect((AtomicDesc)localTryOfferDesc);
    if (paramSelectInstance != null) {
      return paramSelectInstance;
    }
    paramSelectInstance = (ReceiveOrClosed)localTryOfferDesc.getResult();
    paramSelectInstance.completeResumeReceive(paramE);
    return paramSelectInstance.getOfferResult();
  }
  
  protected void onClosedIdempotent(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode) {}
  
  @Nullable
  public final Object send(E paramE, @NotNull Continuation<? super Unit> paramContinuation)
  {
    if (offerInternal(paramE) == AbstractChannelKt.OFFER_SUCCESS) {
      return Unit.INSTANCE;
    }
    paramE = sendSuspend(paramE, paramContinuation);
    if (paramE == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramE;
    }
    return Unit.INSTANCE;
  }
  
  @Nullable
  protected final ReceiveOrClosed<?> sendBuffered(E paramE)
  {
    LockFreeLinkedListNode localLockFreeLinkedListNode1 = (LockFreeLinkedListNode)this.queue;
    paramE = (LockFreeLinkedListNode)new AbstractSendChannel.SendBuffered(paramE);
    LockFreeLinkedListNode localLockFreeLinkedListNode2;
    do
    {
      localLockFreeLinkedListNode2 = localLockFreeLinkedListNode1.getPrevNode();
      if ((localLockFreeLinkedListNode2 instanceof ReceiveOrClosed)) {
        return (ReceiveOrClosed)localLockFreeLinkedListNode2;
      }
    } while (!localLockFreeLinkedListNode2.addNext(paramE, localLockFreeLinkedListNode1));
    return null;
  }
  
  @Nullable
  public final Object sendFair$kotlinx_coroutines_core(E paramE, @NotNull Continuation<? super Unit> paramContinuation)
  {
    if (offerInternal(paramE) == AbstractChannelKt.OFFER_SUCCESS)
    {
      paramE = YieldKt.yield(paramContinuation);
      if (paramE == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        return paramE;
      }
      return Unit.INSTANCE;
    }
    paramE = sendSuspend(paramE, paramContinuation);
    if (paramE == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramE;
    }
    return Unit.INSTANCE;
  }
  
  @Nullable
  protected ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed()
  {
    LockFreeLinkedListNode localLockFreeLinkedListNode2 = (LockFreeLinkedListNode)this.queue;
    for (;;)
    {
      localObject = localLockFreeLinkedListNode2.getNext();
      if (localObject == null) {
        break;
      }
      localObject = (LockFreeLinkedListNode)localObject;
      LockFreeLinkedListNode localLockFreeLinkedListNode1 = null;
      if (localObject == localLockFreeLinkedListNode2)
      {
        localObject = localLockFreeLinkedListNode1;
      }
      else if (!(localObject instanceof ReceiveOrClosed))
      {
        localObject = localLockFreeLinkedListNode1;
      }
      else if ((!((ReceiveOrClosed)localObject instanceof Closed)) || (((LockFreeLinkedListNode)localObject).isRemoved()))
      {
        localLockFreeLinkedListNode1 = ((LockFreeLinkedListNode)localObject).removeOrNext();
        if (localLockFreeLinkedListNode1 != null) {
          break label80;
        }
      }
      return (ReceiveOrClosed)localObject;
      label80:
      localLockFreeLinkedListNode1.helpRemovePrev();
    }
    Object localObject = new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  @Nullable
  protected final Send takeFirstSendOrPeekClosed()
  {
    LockFreeLinkedListNode localLockFreeLinkedListNode2 = (LockFreeLinkedListNode)this.queue;
    for (;;)
    {
      localObject = localLockFreeLinkedListNode2.getNext();
      if (localObject == null) {
        break;
      }
      localObject = (LockFreeLinkedListNode)localObject;
      LockFreeLinkedListNode localLockFreeLinkedListNode1 = null;
      if (localObject == localLockFreeLinkedListNode2)
      {
        localObject = localLockFreeLinkedListNode1;
      }
      else if (!(localObject instanceof Send))
      {
        localObject = localLockFreeLinkedListNode1;
      }
      else if ((!((Send)localObject instanceof Closed)) || (((LockFreeLinkedListNode)localObject).isRemoved()))
      {
        localLockFreeLinkedListNode1 = ((LockFreeLinkedListNode)localObject).removeOrNext();
        if (localLockFreeLinkedListNode1 != null) {
          break label80;
        }
      }
      return (Send)localObject;
      label80:
      localLockFreeLinkedListNode1.helpRemovePrev();
    }
    Object localObject = new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(DebugStringsKt.getClassSimpleName(this));
    localStringBuilder.append('@');
    localStringBuilder.append(DebugStringsKt.getHexAddress(this));
    localStringBuilder.append('{');
    localStringBuilder.append(getQueueDebugStateString());
    localStringBuilder.append('}');
    localStringBuilder.append(getBufferDebugString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.AbstractSendChannel
 * JD-Core Version:    0.7.0.1
 */