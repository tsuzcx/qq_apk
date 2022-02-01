package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"isActive", "", "Lkotlinx/coroutines/CoroutineScope;", "isActive$annotations", "(Lkotlinx/coroutines/CoroutineScope;)V", "(Lkotlinx/coroutines/CoroutineScope;)Z", "CoroutineScope", "context", "Lkotlin/coroutines/CoroutineContext;", "MainScope", "coroutineScope", "R", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "message", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "ensureActive", "plus", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class CoroutineScopeKt
{
  @NotNull
  public static final CoroutineScope CoroutineScope(@NotNull CoroutineContext paramCoroutineContext)
  {
    if (paramCoroutineContext.get((CoroutineContext.Key)Job.Key) == null) {
      paramCoroutineContext = paramCoroutineContext.plus((CoroutineContext)JobKt.Job$default(null, 1, null));
    }
    return (CoroutineScope)new ContextScope(paramCoroutineContext);
  }
  
  @NotNull
  public static final CoroutineScope MainScope()
  {
    return (CoroutineScope)new ContextScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus((CoroutineContext)Dispatchers.getMain()));
  }
  
  public static final void cancel(@NotNull CoroutineScope paramCoroutineScope, @NotNull String paramString, @Nullable Throwable paramThrowable)
  {
    cancel(paramCoroutineScope, ExceptionsKt.CancellationException(paramString, paramThrowable));
  }
  
  public static final void cancel(@NotNull CoroutineScope paramCoroutineScope, @Nullable CancellationException paramCancellationException)
  {
    Job localJob = (Job)paramCoroutineScope.getCoroutineContext().get((CoroutineContext.Key)Job.Key);
    if (localJob != null)
    {
      localJob.cancel(paramCancellationException);
      return;
    }
    paramCancellationException = new StringBuilder();
    paramCancellationException.append("Scope cannot be cancelled because it does not have a job: ");
    paramCancellationException.append(paramCoroutineScope);
    throw ((Throwable)new IllegalStateException(paramCancellationException.toString().toString()));
  }
  
  @Nullable
  public static final <R> Object coroutineScope(@NotNull Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> paramFunction2, @NotNull Continuation<? super R> paramContinuation)
  {
    ScopeCoroutine localScopeCoroutine = new ScopeCoroutine(paramContinuation.getContext(), paramContinuation);
    paramFunction2 = UndispatchedKt.startUndispatchedOrReturn(localScopeCoroutine, localScopeCoroutine, paramFunction2);
    if (paramFunction2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    return paramFunction2;
  }
  
  public static final void ensureActive(@NotNull CoroutineScope paramCoroutineScope)
  {
    JobKt.ensureActive(paramCoroutineScope.getCoroutineContext());
  }
  
  public static final boolean isActive(@NotNull CoroutineScope paramCoroutineScope)
  {
    paramCoroutineScope = (Job)paramCoroutineScope.getCoroutineContext().get((CoroutineContext.Key)Job.Key);
    if (paramCoroutineScope != null) {
      return paramCoroutineScope.isActive();
    }
    return true;
  }
  
  @NotNull
  public static final CoroutineScope plus(@NotNull CoroutineScope paramCoroutineScope, @NotNull CoroutineContext paramCoroutineContext)
  {
    return (CoroutineScope)new ContextScope(paramCoroutineScope.getCoroutineContext().plus(paramCoroutineContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CoroutineScopeKt
 * JD-Core Version:    0.7.0.1
 */