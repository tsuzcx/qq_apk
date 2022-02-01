package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlin/coroutines/Continuation;", "delegate", "", "resumeMode", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "", "proposedUpdate", "", "alreadyResumedError", "(Ljava/lang/Object;)V", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "cancelLater", "state", "cancelResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelResult", "checkCompleted", "()Z", "token", "completeResume", "detachChild$kotlinx_coroutines_core", "()V", "detachChild", "detachChildIfNonResuable", "mode", "dispatchResume", "(I)V", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "initCancellability", "Lkotlin/Function0;", "block", "invokeHandlerSafely", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "isReusable", "Lkotlinx/coroutines/CancelHandler;", "makeHandler", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CancelHandler;", "multipleHandlersError", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "", "nameString", "()Ljava/lang/String;", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "parentCancelled", "resetState$kotlinx_coroutines_core", "resetState", "value", "onCancellation", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CancelledContinuation;", "resumeImpl", "(Ljava/lang/Object;I)Lkotlinx/coroutines/CancelledContinuation;", "Lkotlin/Result;", "result", "resumeWith", "setupCancellation", "takeState$kotlinx_coroutines_core", "takeState", "toString", "tryResume", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "trySuspend", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "isActive", "isCancelled", "isCompleted", "Lkotlinx/coroutines/DisposableHandle;", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setParentHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;"}, k=1, mv={1, 1, 16})
@PublishedApi
public class CancellableContinuationImpl<T>
  extends DispatchedTask<T>
  implements CoroutineStackFrame, CancellableContinuation<T>
{
  private static final AtomicIntegerFieldUpdater _decision$FU = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decision");
  private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state");
  private volatile int _decision;
  private volatile Object _parentHandle;
  private volatile Object _state;
  @NotNull
  private final CoroutineContext context;
  @NotNull
  private final Continuation<T> delegate;
  
  public CancellableContinuationImpl(@NotNull Continuation<? super T> paramContinuation, int paramInt)
  {
    super(paramInt);
    this.delegate = paramContinuation;
    this.context = this.delegate.getContext();
    this._decision = 0;
    this._state = Active.INSTANCE;
    this._parentHandle = null;
  }
  
  private final void alreadyResumedError(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Already resumed, but proposed with update ");
    localStringBuilder.append(paramObject);
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString().toString()));
  }
  
  private final boolean cancelLater(Throwable paramThrowable)
  {
    if (this.resumeMode != 0) {
      return false;
    }
    Continuation localContinuation = this.delegate;
    Object localObject = localContinuation;
    if (!(localContinuation instanceof DispatchedContinuation)) {
      localObject = null;
    }
    localObject = (DispatchedContinuation)localObject;
    if (localObject != null) {
      return ((DispatchedContinuation)localObject).postponeCancellation(paramThrowable);
    }
    return false;
  }
  
  private final boolean checkCompleted()
  {
    boolean bool2 = isCompleted();
    if (this.resumeMode != 0) {
      return bool2;
    }
    Continuation localContinuation = this.delegate;
    Object localObject = localContinuation;
    if (!(localContinuation instanceof DispatchedContinuation)) {
      localObject = null;
    }
    localObject = (DispatchedContinuation)localObject;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((DispatchedContinuation)localObject).checkPostponedCancellation((CancellableContinuation)this);
      bool1 = bool2;
      if (localObject != null)
      {
        if (!bool2) {
          cancel((Throwable)localObject);
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private final void detachChildIfNonResuable()
  {
    if (!isReusable()) {
      detachChild$kotlinx_coroutines_core();
    }
  }
  
  private final void dispatchResume(int paramInt)
  {
    if (tryResume()) {
      return;
    }
    DispatchedTaskKt.dispatch(this, paramInt);
  }
  
  private final DisposableHandle getParentHandle()
  {
    return (DisposableHandle)this._parentHandle;
  }
  
  private final void invokeHandlerSafely(Function0<Unit> paramFunction0)
  {
    try
    {
      paramFunction0.invoke();
      return;
    }
    catch (Throwable paramFunction0)
    {
      CoroutineContext localCoroutineContext = getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception in cancellation handler for ");
      localStringBuilder.append(this);
      CoroutineExceptionHandlerKt.handleCoroutineException(localCoroutineContext, (Throwable)new CompletionHandlerException(localStringBuilder.toString(), paramFunction0));
    }
  }
  
  private final boolean isReusable()
  {
    Continuation localContinuation = this.delegate;
    return ((localContinuation instanceof DispatchedContinuation)) && (((DispatchedContinuation)localContinuation).isReusable());
  }
  
  private final CancelHandler makeHandler(Function1<? super Throwable, Unit> paramFunction1)
  {
    if ((paramFunction1 instanceof CancelHandler)) {
      return (CancelHandler)paramFunction1;
    }
    return (CancelHandler)new InvokeOnCancel(paramFunction1);
  }
  
  private final void multipleHandlersError(Function1<? super Throwable, Unit> paramFunction1, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("It's prohibited to register multiple handlers, tried to register ");
    localStringBuilder.append(paramFunction1);
    localStringBuilder.append(", already has ");
    localStringBuilder.append(paramObject);
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString().toString()));
  }
  
  private final CancelledContinuation resumeImpl(Object paramObject, int paramInt)
  {
    for (;;)
    {
      Object localObject = this._state;
      if ((localObject instanceof NotCompleted))
      {
        if (_state$FU.compareAndSet(this, localObject, paramObject))
        {
          detachChildIfNonResuable();
          dispatchResume(paramInt);
          return null;
        }
      }
      else
      {
        if ((localObject instanceof CancelledContinuation))
        {
          localObject = (CancelledContinuation)localObject;
          if (((CancelledContinuation)localObject).makeResumed()) {
            return localObject;
          }
        }
        alreadyResumedError(paramObject);
      }
    }
  }
  
  private final void setParentHandle(DisposableHandle paramDisposableHandle)
  {
    this._parentHandle = paramDisposableHandle;
  }
  
  private final void setupCancellation()
  {
    if (checkCompleted()) {
      return;
    }
    if (getParentHandle() != null) {
      return;
    }
    Object localObject = (Job)this.delegate.getContext().get((CoroutineContext.Key)Job.Key);
    if (localObject != null)
    {
      ((Job)localObject).start();
      localObject = Job.DefaultImpls.invokeOnCompletion$default((Job)localObject, true, false, (Function1)new ChildContinuation((Job)localObject, this), 2, null);
      setParentHandle((DisposableHandle)localObject);
      if ((isCompleted()) && (!isReusable()))
      {
        ((DisposableHandle)localObject).dispose();
        setParentHandle((DisposableHandle)NonDisposableHandle.INSTANCE);
      }
    }
  }
  
  private final boolean tryResume()
  {
    do
    {
      int i = this._decision;
      if (i != 0)
      {
        if (i == 1) {
          return false;
        }
        throw ((Throwable)new IllegalStateException("Already resumed".toString()));
      }
    } while (!_decision$FU.compareAndSet(this, 0, 2));
    return true;
  }
  
  private final boolean trySuspend()
  {
    do
    {
      int i = this._decision;
      if (i != 0)
      {
        if (i == 2) {
          return false;
        }
        throw ((Throwable)new IllegalStateException("Already suspended".toString()));
      }
    } while (!_decision$FU.compareAndSet(this, 0, 1));
    return true;
  }
  
  public boolean cancel(@Nullable Throwable paramThrowable)
  {
    Object localObject1;
    Object localObject2;
    boolean bool;
    do
    {
      localObject1 = this._state;
      if (!(localObject1 instanceof NotCompleted)) {
        return false;
      }
      localObject2 = (Continuation)this;
      bool = localObject1 instanceof CancelHandler;
      localObject2 = new CancelledContinuation((Continuation)localObject2, paramThrowable, bool);
    } while (!_state$FU.compareAndSet(this, localObject1, localObject2));
    if (bool) {
      try
      {
        ((CancelHandler)localObject1).invoke(paramThrowable);
      }
      catch (Throwable paramThrowable)
      {
        localObject1 = getContext();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Exception in cancellation handler for ");
        ((StringBuilder)localObject2).append(this);
        CoroutineExceptionHandlerKt.handleCoroutineException((CoroutineContext)localObject1, (Throwable)new CompletionHandlerException(((StringBuilder)localObject2).toString(), paramThrowable));
      }
    }
    detachChildIfNonResuable();
    dispatchResume(0);
    return true;
  }
  
  public void cancelResult$kotlinx_coroutines_core(@Nullable Object paramObject, @NotNull Throwable paramThrowable)
  {
    if ((paramObject instanceof CompletedWithCancellation)) {
      try
      {
        ((CompletedWithCancellation)paramObject).onCancellation.invoke(paramThrowable);
        return;
      }
      catch (Throwable paramObject)
      {
        paramThrowable = getContext();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Exception in cancellation handler for ");
        localStringBuilder.append(this);
        CoroutineExceptionHandlerKt.handleCoroutineException(paramThrowable, (Throwable)new CompletionHandlerException(localStringBuilder.toString(), paramObject));
      }
    }
  }
  
  public void completeResume(@NotNull Object paramObject)
  {
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      int i;
      if (paramObject == CancellableContinuationImplKt.RESUME_TOKEN) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    dispatchResume(this.resumeMode);
  }
  
  public final void detachChild$kotlinx_coroutines_core()
  {
    DisposableHandle localDisposableHandle = getParentHandle();
    if (localDisposableHandle != null) {
      localDisposableHandle.dispose();
    }
    setParentHandle((DisposableHandle)NonDisposableHandle.INSTANCE);
  }
  
  @Nullable
  public CoroutineStackFrame getCallerFrame()
  {
    Continuation localContinuation2 = this.delegate;
    Continuation localContinuation1 = localContinuation2;
    if (!(localContinuation2 instanceof CoroutineStackFrame)) {
      localContinuation1 = null;
    }
    return (CoroutineStackFrame)localContinuation1;
  }
  
  @NotNull
  public CoroutineContext getContext()
  {
    return this.context;
  }
  
  @NotNull
  public Throwable getContinuationCancellationCause(@NotNull Job paramJob)
  {
    return (Throwable)paramJob.getCancellationException();
  }
  
  @NotNull
  public final Continuation<T> getDelegate$kotlinx_coroutines_core()
  {
    return this.delegate;
  }
  
  @PublishedApi
  @Nullable
  public final Object getResult()
  {
    setupCancellation();
    if (trySuspend()) {
      return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }
    Object localObject1 = getState$kotlinx_coroutines_core();
    Object localObject2;
    Continuation localContinuation;
    if ((localObject1 instanceof CompletedExceptionally))
    {
      localObject2 = ((CompletedExceptionally)localObject1).cause;
      localContinuation = (Continuation)this;
      localObject1 = localObject2;
      if (DebugKt.getRECOVER_STACK_TRACES()) {
        if (!(localContinuation instanceof CoroutineStackFrame)) {
          localObject1 = localObject2;
        } else {
          localObject1 = StackTraceRecoveryKt.access$recoverFromStackFrame((Throwable)localObject2, (CoroutineStackFrame)localContinuation);
        }
      }
      throw ((Throwable)localObject1);
    }
    if (this.resumeMode == 1)
    {
      localObject2 = (Job)getContext().get((CoroutineContext.Key)Job.Key);
      if ((localObject2 != null) && (!((Job)localObject2).isActive()))
      {
        localObject2 = (Throwable)((Job)localObject2).getCancellationException();
        cancelResult$kotlinx_coroutines_core(localObject1, (Throwable)localObject2);
        localContinuation = (Continuation)this;
        localObject1 = localObject2;
        if (DebugKt.getRECOVER_STACK_TRACES()) {
          if (!(localContinuation instanceof CoroutineStackFrame)) {
            localObject1 = localObject2;
          } else {
            localObject1 = StackTraceRecoveryKt.access$recoverFromStackFrame((Throwable)localObject2, (CoroutineStackFrame)localContinuation);
          }
        }
        throw ((Throwable)localObject1);
      }
    }
    return getSuccessfulResult$kotlinx_coroutines_core(localObject1);
  }
  
  @Nullable
  public StackTraceElement getStackTraceElement()
  {
    return null;
  }
  
  @Nullable
  public final Object getState$kotlinx_coroutines_core()
  {
    return this._state;
  }
  
  public <T> T getSuccessfulResult$kotlinx_coroutines_core(@Nullable Object paramObject)
  {
    if ((paramObject instanceof CompletedIdempotentResult)) {
      return ((CompletedIdempotentResult)paramObject).result;
    }
    Object localObject = paramObject;
    if ((paramObject instanceof CompletedWithCancellation)) {
      localObject = ((CompletedWithCancellation)paramObject).result;
    }
    return localObject;
  }
  
  public void invokeOnCancellation(@NotNull Function1<? super Throwable, Unit> paramFunction1)
  {
    Object localObject3 = null;
    Object localObject1 = (CancelHandler)null;
    Object localObject4;
    Object localObject2;
    for (;;)
    {
      localObject4 = this._state;
      if ((localObject4 instanceof Active))
      {
        if (localObject1 != null) {
          localObject2 = localObject1;
        } else {
          localObject2 = makeHandler(paramFunction1);
        }
        localObject1 = localObject2;
        if (!_state$FU.compareAndSet(this, localObject4, localObject2)) {}
      }
      else
      {
        if (!(localObject4 instanceof CancelHandler)) {
          break;
        }
        multipleHandlersError(paramFunction1, localObject4);
      }
    }
    if ((localObject4 instanceof CancelledContinuation))
    {
      if (!((CancelledContinuation)localObject4).makeHandled()) {
        multipleHandlersError(paramFunction1, localObject4);
      }
      localObject1 = localObject4;
      try
      {
        if (!(localObject4 instanceof CompletedExceptionally)) {
          localObject1 = null;
        }
        localObject2 = (CompletedExceptionally)localObject1;
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = ((CompletedExceptionally)localObject2).cause;
        }
        paramFunction1.invoke(localObject1);
        return;
      }
      catch (Throwable paramFunction1)
      {
        localObject1 = getContext();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Exception in cancellation handler for ");
        ((StringBuilder)localObject2).append(this);
        CoroutineExceptionHandlerKt.handleCoroutineException((CoroutineContext)localObject1, (Throwable)new CompletionHandlerException(((StringBuilder)localObject2).toString(), paramFunction1));
      }
    }
  }
  
  public boolean isActive()
  {
    return getState$kotlinx_coroutines_core() instanceof NotCompleted;
  }
  
  public boolean isCancelled()
  {
    return getState$kotlinx_coroutines_core() instanceof CancelledContinuation;
  }
  
  public boolean isCompleted()
  {
    return !(getState$kotlinx_coroutines_core() instanceof NotCompleted);
  }
  
  @NotNull
  protected String nameString()
  {
    return "CancellableContinuation";
  }
  
  public final void parentCancelled$kotlinx_coroutines_core(@NotNull Throwable paramThrowable)
  {
    if (cancelLater(paramThrowable)) {
      return;
    }
    cancel(paramThrowable);
    detachChildIfNonResuable();
  }
  
  public final boolean resetState$kotlinx_coroutines_core()
  {
    int i;
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      if (getParentHandle() != NonDisposableHandle.INSTANCE) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    Object localObject = this._state;
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      if (!(localObject instanceof NotCompleted)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    if ((localObject instanceof CompletedIdempotentResult))
    {
      detachChild$kotlinx_coroutines_core();
      return false;
    }
    this._decision = 0;
    this._state = Active.INSTANCE;
    return true;
  }
  
  public void resume(T paramT, @NotNull Function1<? super Throwable, Unit> paramFunction1)
  {
    paramT = resumeImpl(new CompletedWithCancellation(paramT, paramFunction1), this.resumeMode);
    if (paramT != null) {
      try
      {
        paramFunction1.invoke(paramT.cause);
        return;
      }
      catch (Throwable paramT)
      {
        paramFunction1 = getContext();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Exception in cancellation handler for ");
        localStringBuilder.append(this);
        CoroutineExceptionHandlerKt.handleCoroutineException(paramFunction1, (Throwable)new CompletionHandlerException(localStringBuilder.toString(), paramT));
      }
    }
  }
  
  public void resumeUndispatched(@NotNull CoroutineDispatcher paramCoroutineDispatcher, T paramT)
  {
    Object localObject1 = this.delegate;
    boolean bool = localObject1 instanceof DispatchedContinuation;
    Object localObject2 = null;
    if (!bool) {
      localObject1 = null;
    }
    DispatchedContinuation localDispatchedContinuation = (DispatchedContinuation)localObject1;
    localObject1 = localObject2;
    if (localDispatchedContinuation != null) {
      localObject1 = localDispatchedContinuation.dispatcher;
    }
    int i;
    if (localObject1 == paramCoroutineDispatcher) {
      i = 2;
    } else {
      i = this.resumeMode;
    }
    resumeImpl(paramT, i);
  }
  
  public void resumeUndispatchedWithException(@NotNull CoroutineDispatcher paramCoroutineDispatcher, @NotNull Throwable paramThrowable)
  {
    Object localObject1 = this.delegate;
    boolean bool = localObject1 instanceof DispatchedContinuation;
    Object localObject2 = null;
    if (!bool) {
      localObject1 = null;
    }
    localObject1 = (DispatchedContinuation)localObject1;
    int i = 2;
    CompletedExceptionally localCompletedExceptionally = new CompletedExceptionally(paramThrowable, false, 2, null);
    paramThrowable = localObject2;
    if (localObject1 != null) {
      paramThrowable = ((DispatchedContinuation)localObject1).dispatcher;
    }
    if (paramThrowable != paramCoroutineDispatcher) {
      i = this.resumeMode;
    }
    resumeImpl(localCompletedExceptionally, i);
  }
  
  public void resumeWith(@NotNull Object paramObject)
  {
    resumeImpl(CompletedExceptionallyKt.toState(paramObject, (CancellableContinuation)this), this.resumeMode);
  }
  
  @Nullable
  public Object takeState$kotlinx_coroutines_core()
  {
    return getState$kotlinx_coroutines_core();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(nameString());
    localStringBuilder.append('(');
    localStringBuilder.append(DebugStringsKt.toDebugString(this.delegate));
    localStringBuilder.append("){");
    localStringBuilder.append(getState$kotlinx_coroutines_core());
    localStringBuilder.append("}@");
    localStringBuilder.append(DebugStringsKt.getHexAddress(this));
    return localStringBuilder.toString();
  }
  
  @Nullable
  public Object tryResume(T paramT, @Nullable Object paramObject)
  {
    Object localObject3;
    do
    {
      localObject3 = this._state;
      if (!(localObject3 instanceof NotCompleted)) {
        break;
      }
      if (paramObject == null) {
        localObject1 = paramT;
      } else {
        localObject1 = new CompletedIdempotentResult(paramObject, paramT);
      }
    } while (!_state$FU.compareAndSet(this, localObject3, localObject1));
    detachChildIfNonResuable();
    return CancellableContinuationImplKt.RESUME_TOKEN;
    boolean bool = localObject3 instanceof CompletedIdempotentResult;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (bool)
    {
      localObject3 = (CompletedIdempotentResult)localObject3;
      localObject1 = localObject2;
      if (((CompletedIdempotentResult)localObject3).idempotentResume == paramObject)
      {
        if (DebugKt.getASSERTIONS_ENABLED())
        {
          int i;
          if (((CompletedIdempotentResult)localObject3).result == paramT) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == 0) {
            throw ((Throwable)new AssertionError());
          }
        }
        localObject1 = CancellableContinuationImplKt.RESUME_TOKEN;
      }
    }
    return localObject1;
  }
  
  @Nullable
  public Object tryResumeWithException(@NotNull Throwable paramThrowable)
  {
    Object localObject;
    CompletedExceptionally localCompletedExceptionally;
    do
    {
      localObject = this._state;
      if (!(localObject instanceof NotCompleted)) {
        break;
      }
      localCompletedExceptionally = new CompletedExceptionally(paramThrowable, false, 2, null);
    } while (!_state$FU.compareAndSet(this, localObject, localCompletedExceptionally));
    detachChildIfNonResuable();
    return CancellableContinuationImplKt.RESUME_TOKEN;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CancellableContinuationImpl
 * JD-Core Version:    0.7.0.1
 */