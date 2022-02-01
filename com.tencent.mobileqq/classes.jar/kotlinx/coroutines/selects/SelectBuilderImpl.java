package kotlinx.coroutines.selects;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletedExceptionallyKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/selects/SelectBuilderImpl;", "R", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/Continuation;)V", "Lkotlinx/coroutines/DisposableHandle;", "handle", "", "disposeOnSelect", "(Lkotlinx/coroutines/DisposableHandle;)V", "doAfterSelect", "()V", "Lkotlin/Function0;", "", "value", "block", "doResume", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "", "e", "handleBuilderException", "(Ljava/lang/Throwable;)V", "initCancellability", "", "timeMillis", "Lkotlin/Function1;", "onTimeout", "(JLkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/AtomicDesc;", "desc", "performAtomicTrySelect", "(Lkotlinx/coroutines/internal/AtomicDesc;)Ljava/lang/Object;", "exception", "resumeSelectWithException", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "", "trySelect", "()Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "trySelectOther", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectClause0;", "invoke", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "getCompletion", "()Lkotlin/coroutines/Continuation;", "completion", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "isSelected", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setParentHandle", "parentHandle", "Lkotlin/coroutines/Continuation;", "AtomicSelectOp", "DisposeNode", "PairSelectOp", "SelectOnCancelling", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstance;"}, k=1, mv={1, 1, 16})
@PublishedApi
public final class SelectBuilderImpl<R>
  extends LockFreeLinkedListHead
  implements Continuation<R>, CoroutineStackFrame, SelectBuilder<R>, SelectInstance<R>
{
  static final AtomicReferenceFieldUpdater _result$FU = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_result");
  static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_state");
  private volatile Object _parentHandle;
  volatile Object _result;
  volatile Object _state;
  private final Continuation<R> uCont;
  
  public SelectBuilderImpl(@NotNull Continuation<? super R> paramContinuation)
  {
    this.uCont = paramContinuation;
    this._state = this;
    this._result = SelectKt.access$getUNDECIDED$p();
    this._parentHandle = null;
  }
  
  private final void doAfterSelect()
  {
    Object localObject = getParentHandle();
    if (localObject != null) {
      ((DisposableHandle)localObject).dispose();
    }
    LockFreeLinkedListHead localLockFreeLinkedListHead = (LockFreeLinkedListHead)this;
    localObject = localLockFreeLinkedListHead.getNext();
    if (localObject != null)
    {
      for (localObject = (LockFreeLinkedListNode)localObject; (Intrinsics.areEqual(localObject, localLockFreeLinkedListHead) ^ true); localObject = ((LockFreeLinkedListNode)localObject).getNextNode()) {
        if ((localObject instanceof SelectBuilderImpl.DisposeNode)) {
          ((SelectBuilderImpl.DisposeNode)localObject).handle.dispose();
        }
      }
      return;
    }
    localObject = new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private final void doResume(Function0<? extends Object> paramFunction0, Function0<Unit> paramFunction01)
  {
    if ((DebugKt.getASSERTIONS_ENABLED()) && (!isSelected())) {
      throw ((Throwable)new AssertionError());
    }
    do
    {
      Object localObject;
      do
      {
        localObject = this._result;
        if (localObject != SelectKt.access$getUNDECIDED$p()) {
          break;
        }
        localObject = paramFunction0.invoke();
      } while (!_result$FU.compareAndSet(this, SelectKt.access$getUNDECIDED$p(), localObject));
      return;
      if (localObject != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        break;
      }
    } while (!_result$FU.compareAndSet(this, IntrinsicsKt.getCOROUTINE_SUSPENDED(), SelectKt.access$getRESUMED$p()));
    paramFunction01.invoke();
    return;
    paramFunction0 = (Throwable)new IllegalStateException("Already resumed");
    for (;;)
    {
      throw paramFunction0;
    }
  }
  
  private final DisposableHandle getParentHandle()
  {
    return (DisposableHandle)this._parentHandle;
  }
  
  private final void initCancellability()
  {
    Object localObject = (Job)getContext().get((CoroutineContext.Key)Job.Key);
    if (localObject != null)
    {
      localObject = Job.DefaultImpls.invokeOnCompletion$default((Job)localObject, true, false, (Function1)new SelectBuilderImpl.SelectOnCancelling(this, (Job)localObject), 2, null);
      setParentHandle((DisposableHandle)localObject);
      if (isSelected()) {
        ((DisposableHandle)localObject).dispose();
      }
    }
  }
  
  private final void setParentHandle(DisposableHandle paramDisposableHandle)
  {
    this._parentHandle = paramDisposableHandle;
  }
  
  public void disposeOnSelect(@NotNull DisposableHandle paramDisposableHandle)
  {
    SelectBuilderImpl.DisposeNode localDisposeNode = new SelectBuilderImpl.DisposeNode(paramDisposableHandle);
    if (!isSelected())
    {
      addLast((LockFreeLinkedListNode)localDisposeNode);
      if (!isSelected()) {
        return;
      }
    }
    paramDisposableHandle.dispose();
  }
  
  @Nullable
  public CoroutineStackFrame getCallerFrame()
  {
    Continuation localContinuation2 = this.uCont;
    Continuation localContinuation1 = localContinuation2;
    if (!(localContinuation2 instanceof CoroutineStackFrame)) {
      localContinuation1 = null;
    }
    return (CoroutineStackFrame)localContinuation1;
  }
  
  @NotNull
  public Continuation<R> getCompletion()
  {
    return (Continuation)this;
  }
  
  @NotNull
  public CoroutineContext getContext()
  {
    return this.uCont.getContext();
  }
  
  @PublishedApi
  @Nullable
  public final Object getResult()
  {
    if (!isSelected()) {
      initCancellability();
    }
    Object localObject2 = this._result;
    Object localObject1 = localObject2;
    if (localObject2 == SelectKt.access$getUNDECIDED$p())
    {
      if (_result$FU.compareAndSet(this, SelectKt.access$getUNDECIDED$p(), IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
      }
      localObject1 = this._result;
    }
    if (localObject1 != SelectKt.access$getRESUMED$p())
    {
      if (!(localObject1 instanceof CompletedExceptionally)) {
        return localObject1;
      }
      throw ((CompletedExceptionally)localObject1).cause;
    }
    throw ((Throwable)new IllegalStateException("Already resumed"));
  }
  
  @Nullable
  public StackTraceElement getStackTraceElement()
  {
    return null;
  }
  
  @PublishedApi
  public final void handleBuilderException(@NotNull Throwable paramThrowable)
  {
    Object localObject;
    if (trySelect())
    {
      localObject = Result.Companion;
      resumeWith(Result.constructor-impl(ResultKt.createFailure(paramThrowable)));
      return;
    }
    if (!(paramThrowable instanceof CancellationException))
    {
      localObject = getResult();
      if ((localObject instanceof CompletedExceptionally))
      {
        localObject = ((CompletedExceptionally)localObject).cause;
        if (DebugKt.getRECOVER_STACK_TRACES()) {
          localObject = StackTraceRecoveryKt.unwrapImpl((Throwable)localObject);
        }
        Throwable localThrowable;
        if (!DebugKt.getRECOVER_STACK_TRACES()) {
          localThrowable = paramThrowable;
        } else {
          localThrowable = StackTraceRecoveryKt.unwrapImpl(paramThrowable);
        }
        if (localObject == localThrowable) {}
      }
      else
      {
        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), paramThrowable);
      }
    }
  }
  
  public void invoke(@NotNull SelectClause0 paramSelectClause0, @NotNull Function1<? super Continuation<? super R>, ? extends Object> paramFunction1)
  {
    paramSelectClause0.registerSelectClause0((SelectInstance)this, paramFunction1);
  }
  
  public <Q> void invoke(@NotNull SelectClause1<? extends Q> paramSelectClause1, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    paramSelectClause1.registerSelectClause1((SelectInstance)this, paramFunction2);
  }
  
  public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> paramSelectClause2, P paramP, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    paramSelectClause2.registerSelectClause2((SelectInstance)this, paramP, paramFunction2);
  }
  
  public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> paramSelectClause2, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    SelectBuilder.DefaultImpls.invoke(this, paramSelectClause2, paramFunction2);
  }
  
  public boolean isSelected()
  {
    for (;;)
    {
      Object localObject = this._state;
      if (localObject == (SelectBuilderImpl)this) {
        return false;
      }
      if (!(localObject instanceof OpDescriptor)) {
        break;
      }
      ((OpDescriptor)localObject).perform(this);
    }
    return true;
  }
  
  public void onTimeout(long paramLong, @NotNull Function1<? super Continuation<? super R>, ? extends Object> paramFunction1)
  {
    if (paramLong <= 0L)
    {
      if (trySelect()) {
        UndispatchedKt.startCoroutineUnintercepted(paramFunction1, getCompletion());
      }
      return;
    }
    paramFunction1 = (Runnable)new SelectBuilderImpl.onTimeout..inlined.Runnable.1(this, paramFunction1);
    disposeOnSelect(DelayKt.getDelay(getContext()).invokeOnTimeout(paramLong, paramFunction1));
  }
  
  @Nullable
  public Object performAtomicTrySelect(@NotNull AtomicDesc paramAtomicDesc)
  {
    return new SelectBuilderImpl.AtomicSelectOp(this, paramAtomicDesc).perform(null);
  }
  
  public void resumeSelectWithException(@NotNull Throwable paramThrowable)
  {
    if ((DebugKt.getASSERTIONS_ENABLED()) && (!isSelected())) {
      throw ((Throwable)new AssertionError());
    }
    do
    {
      do
      {
        localObject = this._result;
        if (localObject != SelectKt.access$getUNDECIDED$p()) {
          break;
        }
        localObject = this.uCont;
        if ((DebugKt.getRECOVER_STACK_TRACES()) && ((localObject instanceof CoroutineStackFrame))) {
          localObject = StackTraceRecoveryKt.access$recoverFromStackFrame(paramThrowable, (CoroutineStackFrame)localObject);
        } else {
          localObject = paramThrowable;
        }
        localObject = new CompletedExceptionally((Throwable)localObject, false, 2, null);
      } while (!_result$FU.compareAndSet(this, SelectKt.access$getUNDECIDED$p(), localObject));
      return;
      if (localObject != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        break;
      }
    } while (!_result$FU.compareAndSet(this, IntrinsicsKt.getCOROUTINE_SUSPENDED(), SelectKt.access$getRESUMED$p()));
    Object localObject = IntrinsicsKt.intercepted(this.uCont);
    Result.Companion localCompanion = Result.Companion;
    ((Continuation)localObject).resumeWith(Result.constructor-impl(ResultKt.createFailure(paramThrowable)));
    return;
    paramThrowable = (Throwable)new IllegalStateException("Already resumed");
    for (;;)
    {
      throw paramThrowable;
    }
  }
  
  public void resumeWith(@NotNull Object paramObject)
  {
    if ((DebugKt.getASSERTIONS_ENABLED()) && (!isSelected())) {
      throw ((Throwable)new AssertionError());
    }
    Object localObject;
    do
    {
      do
      {
        localObject = this._result;
        if (localObject != SelectKt.access$getUNDECIDED$p()) {
          break;
        }
        localObject = CompletedExceptionallyKt.toState(paramObject);
      } while (!_result$FU.compareAndSet(this, SelectKt.access$getUNDECIDED$p(), localObject));
      return;
      if (localObject != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        break;
      }
    } while (!_result$FU.compareAndSet(this, IntrinsicsKt.getCOROUTINE_SUSPENDED(), SelectKt.access$getRESUMED$p()));
    if (Result.isFailure-impl(paramObject))
    {
      Continuation localContinuation = this.uCont;
      localObject = Result.exceptionOrNull-impl(paramObject);
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      paramObject = Result.Companion;
      paramObject = localObject;
      if (DebugKt.getRECOVER_STACK_TRACES()) {
        if (!(localContinuation instanceof CoroutineStackFrame)) {
          paramObject = localObject;
        } else {
          paramObject = StackTraceRecoveryKt.access$recoverFromStackFrame((Throwable)localObject, (CoroutineStackFrame)localContinuation);
        }
      }
      localContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramObject)));
      return;
    }
    this.uCont.resumeWith(paramObject);
    return;
    paramObject = (Throwable)new IllegalStateException("Already resumed");
    for (;;)
    {
      throw paramObject;
    }
  }
  
  @NotNull
  public String toString()
  {
    Object localObject = this._state;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SelectInstance(state=");
    if (localObject == (SelectBuilderImpl)this) {
      localObject = "this";
    } else {
      localObject = String.valueOf(localObject);
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", result=");
    localStringBuilder.append(this._result);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public boolean trySelect()
  {
    Object localObject = trySelectOther(null);
    if (localObject == CancellableContinuationImplKt.RESUME_TOKEN) {
      return true;
    }
    if (localObject == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected trySelectIdempotent result ");
    localStringBuilder.append(localObject);
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString().toString()));
  }
  
  @Nullable
  public Object trySelectOther(@Nullable LockFreeLinkedListNode.PrepareOp paramPrepareOp)
  {
    Object localObject;
    for (;;)
    {
      localObject = this._state;
      SelectBuilderImpl localSelectBuilderImpl = (SelectBuilderImpl)this;
      if (localObject == localSelectBuilderImpl)
      {
        if (paramPrepareOp == null)
        {
          if (_state$FU.compareAndSet(this, this, null)) {}
        }
        else
        {
          localObject = new SelectBuilderImpl.PairSelectOp(paramPrepareOp);
          if (!_state$FU.compareAndSet(this, this, localObject)) {
            continue;
          }
          paramPrepareOp = ((SelectBuilderImpl.PairSelectOp)localObject).perform(this);
          if (paramPrepareOp != null) {
            return paramPrepareOp;
          }
        }
        doAfterSelect();
        return CancellableContinuationImplKt.RESUME_TOKEN;
      }
      else
      {
        if (!(localObject instanceof OpDescriptor)) {
          break;
        }
        if (paramPrepareOp != null)
        {
          AtomicOp localAtomicOp = paramPrepareOp.getAtomicOp();
          if (((localAtomicOp instanceof SelectBuilderImpl.AtomicSelectOp)) && (((SelectBuilderImpl.AtomicSelectOp)localAtomicOp).impl == localSelectBuilderImpl)) {
            throw ((Throwable)new IllegalStateException("Cannot use matching select clauses on the same object".toString()));
          }
          if (localAtomicOp.isEarlierThan((OpDescriptor)localObject)) {
            return AtomicKt.RETRY_ATOMIC;
          }
        }
        ((OpDescriptor)localObject).perform(this);
      }
    }
    if (paramPrepareOp == null) {
      return null;
    }
    if (localObject == paramPrepareOp.desc) {
      return CancellableContinuationImplKt.RESUME_TOKEN;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.selects.SelectBuilderImpl
 * JD-Core Version:    0.7.0.1
 */