package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"startDirect", "", "T", "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function1;", "", "startCoroutineUndispatched", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "startCoroutineUnintercepted", "startUndispatchedOrReturn", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "startUndispatchedOrReturnIgnoreTimeout", "undispatchedResult", "shouldThrow", "", "", "startBlock", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class UndispatchedKt
{
  public static final <T> void startCoroutineUndispatched(@NotNull Function1<? super Continuation<? super T>, ? extends Object> paramFunction1, @NotNull Continuation<? super T> paramContinuation)
  {
    Continuation localContinuation = DebugProbesKt.probeCoroutineCreated(paramContinuation);
    try
    {
      paramContinuation = paramContinuation.getContext();
      localObject = ThreadContextKt.updateThreadContext(paramContinuation, null);
      if (paramFunction1 != null) {
        try
        {
          paramFunction1 = ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(paramFunction1, 1)).invoke(localContinuation);
          ThreadContextKt.restoreThreadContext(paramContinuation, localObject);
          if (paramFunction1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return;
          }
          paramContinuation = Result.Companion;
          localContinuation.resumeWith(Result.constructor-impl(paramFunction1));
          return;
        }
        finally
        {
          break label78;
        }
      }
      throw new TypeCastException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }
    catch (Throwable paramFunction1)
    {
      Object localObject;
      label78:
      paramContinuation = Result.Companion;
      localContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramFunction1)));
    }
    ThreadContextKt.restoreThreadContext(paramContinuation, localObject);
    throw paramFunction1;
  }
  
  public static final <R, T> void startCoroutineUndispatched(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> paramFunction2, R paramR, @NotNull Continuation<? super T> paramContinuation)
  {
    Continuation localContinuation = DebugProbesKt.probeCoroutineCreated(paramContinuation);
    try
    {
      paramContinuation = paramContinuation.getContext();
      localObject = ThreadContextKt.updateThreadContext(paramContinuation, null);
      if (paramFunction2 != null) {
        try
        {
          paramFunction2 = ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(paramFunction2, 2)).invoke(paramR, localContinuation);
          ThreadContextKt.restoreThreadContext(paramContinuation, localObject);
          if (paramFunction2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return;
          }
          paramR = Result.Companion;
          localContinuation.resumeWith(Result.constructor-impl(paramFunction2));
          return;
        }
        finally
        {
          break label81;
        }
      }
      throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }
    catch (Throwable paramFunction2)
    {
      Object localObject;
      label81:
      paramR = Result.Companion;
      localContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramFunction2)));
    }
    ThreadContextKt.restoreThreadContext(paramContinuation, localObject);
    throw paramFunction2;
  }
  
  public static final <T> void startCoroutineUnintercepted(@NotNull Function1<? super Continuation<? super T>, ? extends Object> paramFunction1, @NotNull Continuation<? super T> paramContinuation)
  {
    paramContinuation = DebugProbesKt.probeCoroutineCreated(paramContinuation);
    if (paramFunction1 != null) {
      try
      {
        paramFunction1 = ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(paramFunction1, 1)).invoke(paramContinuation);
        if (paramFunction1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
          return;
        }
        localCompanion = Result.Companion;
        paramContinuation.resumeWith(Result.constructor-impl(paramFunction1));
        return;
      }
      catch (Throwable paramFunction1) {}
    } else {
      throw new TypeCastException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }
    Result.Companion localCompanion = Result.Companion;
    paramContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramFunction1)));
  }
  
  public static final <R, T> void startCoroutineUnintercepted(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> paramFunction2, R paramR, @NotNull Continuation<? super T> paramContinuation)
  {
    paramContinuation = DebugProbesKt.probeCoroutineCreated(paramContinuation);
    if (paramFunction2 != null) {
      try
      {
        paramFunction2 = ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(paramFunction2, 2)).invoke(paramR, paramContinuation);
        if (paramFunction2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
          return;
        }
        paramR = Result.Companion;
        paramContinuation.resumeWith(Result.constructor-impl(paramFunction2));
        return;
      }
      catch (Throwable paramFunction2) {}
    } else {
      throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }
    paramR = Result.Companion;
    paramContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramFunction2)));
  }
  
  private static final <T> void startDirect(Continuation<? super T> paramContinuation, Function1<? super Continuation<? super T>, ? extends Object> paramFunction1)
  {
    paramContinuation = DebugProbesKt.probeCoroutineCreated(paramContinuation);
    try
    {
      paramFunction1 = paramFunction1.invoke(paramContinuation);
      if (paramFunction1 != IntrinsicsKt.getCOROUTINE_SUSPENDED())
      {
        localCompanion = Result.Companion;
        paramContinuation.resumeWith(Result.constructor-impl(paramFunction1));
      }
      return;
    }
    catch (Throwable paramFunction1)
    {
      Result.Companion localCompanion = Result.Companion;
      paramContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramFunction1)));
    }
  }
  
  @Nullable
  public static final <T, R> Object startUndispatchedOrReturn(@NotNull ScopeCoroutine<? super T> paramScopeCoroutine, R paramR, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> paramFunction2)
  {
    paramScopeCoroutine.initParentJob$kotlinx_coroutines_core();
    try
    {
      Continuation localContinuation = (Continuation)paramScopeCoroutine;
      if (paramFunction2 != null) {
        paramR = ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(paramFunction2, 2)).invoke(paramR, localContinuation);
      } else {
        throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
      }
    }
    catch (Throwable paramR)
    {
      paramR = new CompletedExceptionally(paramR, false, 2, null);
      if (paramR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
      }
      paramR = paramScopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(paramR);
      if (paramR == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
      }
      if ((paramR instanceof CompletedExceptionally))
      {
        paramR = (CompletedExceptionally)paramR;
        paramFunction2 = paramR.cause;
        paramR = paramR.cause;
        paramFunction2 = paramScopeCoroutine.uCont;
        paramScopeCoroutine = paramR;
        if (DebugKt.getRECOVER_STACK_TRACES()) {
          if (!(paramFunction2 instanceof CoroutineStackFrame)) {
            paramScopeCoroutine = paramR;
          } else {
            paramScopeCoroutine = StackTraceRecoveryKt.access$recoverFromStackFrame(paramR, (CoroutineStackFrame)paramFunction2);
          }
        }
        throw paramScopeCoroutine;
      }
    }
    return JobSupportKt.unboxState(paramR);
  }
  
  @Nullable
  public static final <T, R> Object startUndispatchedOrReturnIgnoreTimeout(@NotNull ScopeCoroutine<? super T> paramScopeCoroutine, R paramR, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> paramFunction2)
  {
    paramScopeCoroutine.initParentJob$kotlinx_coroutines_core();
    int i = 0;
    try
    {
      localObject = (Continuation)paramScopeCoroutine;
      if (paramFunction2 != null) {
        paramR = ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(paramFunction2, 2)).invoke(paramR, localObject);
      } else {
        throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
      }
    }
    catch (Throwable paramR)
    {
      Object localObject;
      paramR = new CompletedExceptionally(paramR, false, 2, null);
      if (paramR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
      }
      paramFunction2 = paramScopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(paramR);
      if (paramFunction2 == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
      }
      if ((paramFunction2 instanceof CompletedExceptionally))
      {
        paramFunction2 = (CompletedExceptionally)paramFunction2;
        localObject = paramFunction2.cause;
        if ((!(localObject instanceof TimeoutCancellationException)) || (((TimeoutCancellationException)localObject).coroutine != paramScopeCoroutine)) {
          i = 1;
        }
        if (i != 0)
        {
          paramR = paramFunction2.cause;
          paramFunction2 = paramScopeCoroutine.uCont;
          paramScopeCoroutine = paramR;
          if (DebugKt.getRECOVER_STACK_TRACES()) {
            if (!(paramFunction2 instanceof CoroutineStackFrame)) {
              paramScopeCoroutine = paramR;
            } else {
              paramScopeCoroutine = StackTraceRecoveryKt.access$recoverFromStackFrame(paramR, (CoroutineStackFrame)paramFunction2);
            }
          }
          throw paramScopeCoroutine;
        }
        paramFunction2 = paramR;
        if ((paramR instanceof CompletedExceptionally))
        {
          paramR = ((CompletedExceptionally)paramR).cause;
          paramFunction2 = paramScopeCoroutine.uCont;
          paramScopeCoroutine = paramR;
          if (DebugKt.getRECOVER_STACK_TRACES()) {
            if (!(paramFunction2 instanceof CoroutineStackFrame)) {
              paramScopeCoroutine = paramR;
            } else {
              paramScopeCoroutine = StackTraceRecoveryKt.access$recoverFromStackFrame(paramR, (CoroutineStackFrame)paramFunction2);
            }
          }
          throw paramScopeCoroutine;
        }
      }
      else
      {
        paramFunction2 = JobSupportKt.unboxState(paramFunction2);
      }
    }
    return paramFunction2;
  }
  
  private static final <T> Object undispatchedResult(@NotNull ScopeCoroutine<? super T> paramScopeCoroutine, Function1<? super Throwable, Boolean> paramFunction1, Function0<? extends Object> paramFunction0)
  {
    try
    {
      paramFunction0 = paramFunction0.invoke();
    }
    catch (Throwable paramFunction0)
    {
      paramFunction0 = new CompletedExceptionally(paramFunction0, false, 2, null);
    }
    if (paramFunction0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }
    Object localObject = paramScopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(paramFunction0);
    if (localObject == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
      return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }
    if ((localObject instanceof CompletedExceptionally))
    {
      localObject = (CompletedExceptionally)localObject;
      if (((Boolean)paramFunction1.invoke(((CompletedExceptionally)localObject).cause)).booleanValue())
      {
        paramFunction1 = ((CompletedExceptionally)localObject).cause;
        paramFunction0 = paramScopeCoroutine.uCont;
        paramScopeCoroutine = paramFunction1;
        if (DebugKt.getRECOVER_STACK_TRACES()) {
          if (!(paramFunction0 instanceof CoroutineStackFrame)) {
            paramScopeCoroutine = paramFunction1;
          } else {
            paramScopeCoroutine = StackTraceRecoveryKt.access$recoverFromStackFrame(paramFunction1, (CoroutineStackFrame)paramFunction0);
          }
        }
        throw paramScopeCoroutine;
      }
      paramFunction1 = paramFunction0;
      if ((paramFunction0 instanceof CompletedExceptionally))
      {
        paramFunction1 = ((CompletedExceptionally)paramFunction0).cause;
        paramFunction0 = paramScopeCoroutine.uCont;
        paramScopeCoroutine = paramFunction1;
        if (DebugKt.getRECOVER_STACK_TRACES()) {
          if (!(paramFunction0 instanceof CoroutineStackFrame)) {
            paramScopeCoroutine = paramFunction1;
          } else {
            paramScopeCoroutine = StackTraceRecoveryKt.access$recoverFromStackFrame(paramFunction1, (CoroutineStackFrame)paramFunction0);
          }
        }
        throw paramScopeCoroutine;
      }
    }
    else
    {
      paramFunction1 = JobSupportKt.unboxState(localObject);
    }
    return paramFunction1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.intrinsics.UndispatchedKt
 * JD-Core Version:    0.7.0.1
 */