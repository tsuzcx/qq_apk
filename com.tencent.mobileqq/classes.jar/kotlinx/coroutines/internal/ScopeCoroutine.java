package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CompletedExceptionallyKt;
import kotlinx.coroutines.DispatchedContinuationKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/ScopeCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "isScopedCoroutine", "", "()Z", "parent", "Lkotlinx/coroutines/Job;", "getParent$kotlinx_coroutines_core", "()Lkotlinx/coroutines/Job;", "afterCompletion", "", "state", "", "afterResume", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public class ScopeCoroutine<T>
  extends AbstractCoroutine<T>
  implements CoroutineStackFrame
{
  @JvmField
  @NotNull
  public final Continuation<T> uCont;
  
  public ScopeCoroutine(@NotNull CoroutineContext paramCoroutineContext, @NotNull Continuation<? super T> paramContinuation)
  {
    super(paramCoroutineContext, true);
    this.uCont = paramContinuation;
  }
  
  protected void afterCompletion(@Nullable Object paramObject)
  {
    DispatchedContinuationKt.resumeCancellableWith(IntrinsicsKt.intercepted(this.uCont), CompletedExceptionallyKt.recoverResult(paramObject, this.uCont));
  }
  
  protected void afterResume(@Nullable Object paramObject)
  {
    Continuation localContinuation = this.uCont;
    localContinuation.resumeWith(CompletedExceptionallyKt.recoverResult(paramObject, localContinuation));
  }
  
  @Nullable
  public final CoroutineStackFrame getCallerFrame()
  {
    return (CoroutineStackFrame)this.uCont;
  }
  
  @Nullable
  public final Job getParent$kotlinx_coroutines_core()
  {
    return (Job)this.parentContext.get((CoroutineContext.Key)Job.Key);
  }
  
  @Nullable
  public final StackTraceElement getStackTraceElement()
  {
    return null;
  }
  
  protected final boolean isScopedCoroutine()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.ScopeCoroutine
 * JD-Core Version:    0.7.0.1
 */