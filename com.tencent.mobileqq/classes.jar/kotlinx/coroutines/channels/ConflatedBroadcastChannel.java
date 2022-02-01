package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "E", "value", "<init>", "(Ljava/lang/Object;)V", "()V", "", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "list", "subscriber", "addSubscriber", "([Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "(Ljava/util/concurrent/CancellationException;)V", "close", "closeSubscriber", "(Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "invokeOnCloseHandler", "(Ljava/lang/Throwable;)V", "element", "offer", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "offerInternal", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "", "block", "registerSelectSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "removeSubscriber", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isClosedForSend", "()Z", "isFull", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "getValue", "()Ljava/lang/Object;", "value$annotations", "getValueOrNull", "valueOrNull", "Companion", "Closed", "State", "Subscriber", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/BroadcastChannel;"}, k=1, mv={1, 1, 16})
@ExperimentalCoroutinesApi
public final class ConflatedBroadcastChannel<E>
  implements BroadcastChannel<E>
{
  private static final ConflatedBroadcastChannel.Closed CLOSED;
  private static final ConflatedBroadcastChannel.Companion Companion = new ConflatedBroadcastChannel.Companion(null);
  private static final ConflatedBroadcastChannel.State<Object> INITIAL_STATE = new ConflatedBroadcastChannel.State(UNDEFINED, null);
  private static final Symbol UNDEFINED;
  private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, Object.class, "_state");
  private static final AtomicIntegerFieldUpdater _updating$FU = AtomicIntegerFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, "_updating");
  private static final AtomicReferenceFieldUpdater onCloseHandler$FU = AtomicReferenceFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, Object.class, "onCloseHandler");
  private volatile Object _state = INITIAL_STATE;
  private volatile int _updating = 0;
  private volatile Object onCloseHandler = null;
  
  static
  {
    CLOSED = new ConflatedBroadcastChannel.Closed(null);
    UNDEFINED = new Symbol("UNDEFINED");
  }
  
  public ConflatedBroadcastChannel() {}
  
  public ConflatedBroadcastChannel(E paramE)
  {
    this();
    _state$FU.lazySet(this, new ConflatedBroadcastChannel.State(paramE, null));
  }
  
  private final ConflatedBroadcastChannel.Subscriber<E>[] addSubscriber(ConflatedBroadcastChannel.Subscriber<E>[] paramArrayOfSubscriber, ConflatedBroadcastChannel.Subscriber<E> paramSubscriber)
  {
    if (paramArrayOfSubscriber == null)
    {
      paramArrayOfSubscriber = new ConflatedBroadcastChannel.Subscriber[1];
      int i = 0;
      while (i < 1)
      {
        paramArrayOfSubscriber[i] = paramSubscriber;
        i += 1;
      }
      return paramArrayOfSubscriber;
    }
    return (ConflatedBroadcastChannel.Subscriber[])ArraysKt.plus(paramArrayOfSubscriber, paramSubscriber);
  }
  
  private final void closeSubscriber(ConflatedBroadcastChannel.Subscriber<E> paramSubscriber)
  {
    Object localObject1;
    Object localObject2;
    do
    {
      localObject1 = this._state;
      if ((localObject1 instanceof ConflatedBroadcastChannel.Closed)) {
        return;
      }
      if (!(localObject1 instanceof ConflatedBroadcastChannel.State)) {
        break label90;
      }
      Object localObject3 = (ConflatedBroadcastChannel.State)localObject1;
      localObject2 = ((ConflatedBroadcastChannel.State)localObject3).value;
      if (localObject1 == null) {
        break;
      }
      localObject3 = ((ConflatedBroadcastChannel.State)localObject3).subscribers;
      if (localObject3 == null) {
        Intrinsics.throwNpe();
      }
      localObject2 = new ConflatedBroadcastChannel.State(localObject2, removeSubscriber((ConflatedBroadcastChannel.Subscriber[])localObject3, paramSubscriber));
    } while (!_state$FU.compareAndSet(this, localObject1, localObject2));
    return;
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
    label90:
    paramSubscriber = new StringBuilder();
    paramSubscriber.append("Invalid state ");
    paramSubscriber.append(localObject1);
    paramSubscriber = (Throwable)new IllegalStateException(paramSubscriber.toString().toString());
    for (;;)
    {
      throw paramSubscriber;
    }
  }
  
  private final void invokeOnCloseHandler(Throwable paramThrowable)
  {
    Object localObject = this.onCloseHandler;
    if ((localObject != null) && (localObject != AbstractChannelKt.HANDLER_INVOKED) && (onCloseHandler$FU.compareAndSet(this, localObject, AbstractChannelKt.HANDLER_INVOKED))) {
      ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(localObject, 1)).invoke(paramThrowable);
    }
  }
  
  private final ConflatedBroadcastChannel.Closed offerInternal(E paramE)
  {
    if (!_updating$FU.compareAndSet(this, 0, 1)) {
      return null;
    }
    try
    {
      ConflatedBroadcastChannel.State localState;
      do
      {
        localObject = this._state;
        if ((localObject instanceof ConflatedBroadcastChannel.Closed))
        {
          paramE = (ConflatedBroadcastChannel.Closed)localObject;
          this._updating = 0;
          return paramE;
        }
        if (!(localObject instanceof ConflatedBroadcastChannel.State)) {
          break label145;
        }
        if (localObject == null) {
          break;
        }
        localState = new ConflatedBroadcastChannel.State(paramE, ((ConflatedBroadcastChannel.State)localObject).subscribers);
      } while (!_state$FU.compareAndSet(this, localObject, localState));
      Object localObject = ((ConflatedBroadcastChannel.State)localObject).subscribers;
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localObject[i].offerInternal(paramE);
          i += 1;
        }
      }
      this._updating = 0;
      return null;
      throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
      label145:
      paramE = new StringBuilder();
      paramE.append("Invalid state ");
      paramE.append(localObject);
      throw ((Throwable)new IllegalStateException(paramE.toString().toString()));
    }
    finally
    {
      this._updating = 0;
    }
    for (;;)
    {
      throw paramE;
    }
  }
  
  private final <R> void registerSelectSend(SelectInstance<? super R> paramSelectInstance, E paramE, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    if (!paramSelectInstance.trySelect()) {
      return;
    }
    paramE = offerInternal(paramE);
    if (paramE != null)
    {
      paramSelectInstance.resumeSelectWithException(paramE.getSendException());
      return;
    }
    UndispatchedKt.startCoroutineUnintercepted(paramFunction2, this, paramSelectInstance.getCompletion());
  }
  
  private final ConflatedBroadcastChannel.Subscriber<E>[] removeSubscriber(ConflatedBroadcastChannel.Subscriber<E>[] paramArrayOfSubscriber, ConflatedBroadcastChannel.Subscriber<E> paramSubscriber)
  {
    int j = paramArrayOfSubscriber.length;
    int k = ArraysKt.indexOf(paramArrayOfSubscriber, paramSubscriber);
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      int i;
      if (k >= 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    if (j == 1) {
      return null;
    }
    paramSubscriber = new ConflatedBroadcastChannel.Subscriber[j - 1];
    ArraysKt.copyInto$default(paramArrayOfSubscriber, paramSubscriber, 0, 0, k, 6, null);
    ArraysKt.copyInto$default(paramArrayOfSubscriber, paramSubscriber, k, k + 1, 0, 8, null);
    return paramSubscriber;
  }
  
  public void cancel(@Nullable CancellationException paramCancellationException)
  {
    close((Throwable)paramCancellationException);
  }
  
  public boolean close(@Nullable Throwable paramThrowable)
  {
    Object localObject2;
    int i;
    Object localObject1;
    do
    {
      localObject2 = this._state;
      boolean bool = localObject2 instanceof ConflatedBroadcastChannel.Closed;
      i = 0;
      if (bool) {
        return false;
      }
      if (!(localObject2 instanceof ConflatedBroadcastChannel.State)) {
        break;
      }
      if (paramThrowable == null) {
        localObject1 = CLOSED;
      } else {
        localObject1 = new ConflatedBroadcastChannel.Closed(paramThrowable);
      }
    } while (!_state$FU.compareAndSet(this, localObject2, localObject1));
    if (localObject2 != null)
    {
      localObject1 = ((ConflatedBroadcastChannel.State)localObject2).subscribers;
      if (localObject1 != null)
      {
        int j = localObject1.length;
        while (i < j)
        {
          localObject1[i].close(paramThrowable);
          i += 1;
        }
      }
      invokeOnCloseHandler(paramThrowable);
      return true;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
    paramThrowable = new StringBuilder();
    paramThrowable.append("Invalid state ");
    paramThrowable.append(localObject2);
    paramThrowable = (Throwable)new IllegalStateException(paramThrowable.toString().toString());
    for (;;)
    {
      throw paramThrowable;
    }
  }
  
  @NotNull
  public SelectClause2<E, SendChannel<E>> getOnSend()
  {
    return (SelectClause2)new ConflatedBroadcastChannel.onSend.1(this);
  }
  
  public final E getValue()
  {
    Object localObject = this._state;
    if (!(localObject instanceof ConflatedBroadcastChannel.Closed))
    {
      if ((localObject instanceof ConflatedBroadcastChannel.State))
      {
        localObject = (ConflatedBroadcastChannel.State)localObject;
        if (((ConflatedBroadcastChannel.State)localObject).value != UNDEFINED) {
          return ((ConflatedBroadcastChannel.State)localObject).value;
        }
        throw ((Throwable)new IllegalStateException("No value"));
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid state ");
      localStringBuilder.append(localObject);
      throw ((Throwable)new IllegalStateException(localStringBuilder.toString().toString()));
    }
    throw ((ConflatedBroadcastChannel.Closed)localObject).getValueException();
  }
  
  @Nullable
  public final E getValueOrNull()
  {
    Object localObject1 = this._state;
    if ((localObject1 instanceof ConflatedBroadcastChannel.Closed)) {
      return null;
    }
    if ((localObject1 instanceof ConflatedBroadcastChannel.State))
    {
      localObject2 = UNDEFINED;
      localObject1 = ((ConflatedBroadcastChannel.State)localObject1).value;
      if (localObject1 == localObject2) {
        return null;
      }
      return localObject1;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Invalid state ");
    ((StringBuilder)localObject2).append(localObject1);
    throw ((Throwable)new IllegalStateException(((StringBuilder)localObject2).toString().toString()));
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
    Object localObject = this._state;
    if (((localObject instanceof ConflatedBroadcastChannel.Closed)) && (onCloseHandler$FU.compareAndSet(this, paramFunction1, AbstractChannelKt.HANDLER_INVOKED))) {
      paramFunction1.invoke(((ConflatedBroadcastChannel.Closed)localObject).closeCause);
    }
  }
  
  public boolean isClosedForSend()
  {
    return this._state instanceof ConflatedBroadcastChannel.Closed;
  }
  
  public boolean isFull()
  {
    return false;
  }
  
  public boolean offer(E paramE)
  {
    paramE = offerInternal(paramE);
    if (paramE == null) {
      return true;
    }
    throw paramE.getSendException();
  }
  
  @NotNull
  public ReceiveChannel<E> openSubscription()
  {
    Object localObject2 = new ConflatedBroadcastChannel.Subscriber(this);
    ConflatedBroadcastChannel.State localState;
    do
    {
      localObject1 = this._state;
      if ((localObject1 instanceof ConflatedBroadcastChannel.Closed))
      {
        ((ConflatedBroadcastChannel.Subscriber)localObject2).close(((ConflatedBroadcastChannel.Closed)localObject1).closeCause);
        return (ReceiveChannel)localObject2;
      }
      if (!(localObject1 instanceof ConflatedBroadcastChannel.State)) {
        break label125;
      }
      localState = (ConflatedBroadcastChannel.State)localObject1;
      if (localState.value != UNDEFINED) {
        ((ConflatedBroadcastChannel.Subscriber)localObject2).offerInternal(localState.value);
      }
      Object localObject3 = localState.value;
      if (localObject1 == null) {
        break;
      }
      localState = new ConflatedBroadcastChannel.State(localObject3, addSubscriber(localState.subscribers, (ConflatedBroadcastChannel.Subscriber)localObject2));
    } while (!_state$FU.compareAndSet(this, localObject1, localState));
    return (ReceiveChannel)localObject2;
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
    label125:
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Invalid state ");
    ((StringBuilder)localObject2).append(localObject1);
    Object localObject1 = (Throwable)new IllegalStateException(((StringBuilder)localObject2).toString().toString());
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  @Nullable
  public Object send(E paramE, @NotNull Continuation<? super Unit> paramContinuation)
  {
    paramE = offerInternal(paramE);
    if (paramE == null)
    {
      if (paramE == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        return paramE;
      }
      return Unit.INSTANCE;
    }
    throw paramE.getSendException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ConflatedBroadcastChannel
 * JD-Core Version:    0.7.0.1
 */