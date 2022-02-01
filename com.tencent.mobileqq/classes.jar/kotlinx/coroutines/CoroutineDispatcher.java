package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.ContinuationInterceptor.DefaultImpls;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchYield", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "isDispatchNeeded", "", "plus", "other", "releaseInterceptedContinuation", "toString", "", "Key", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract class CoroutineDispatcher
  extends AbstractCoroutineContextElement
  implements ContinuationInterceptor
{
  public static final CoroutineDispatcher.Key Key = new CoroutineDispatcher.Key(null);
  
  public CoroutineDispatcher()
  {
    super((CoroutineContext.Key)ContinuationInterceptor.Key);
  }
  
  public abstract void dispatch(@NotNull CoroutineContext paramCoroutineContext, @NotNull Runnable paramRunnable);
  
  @InternalCoroutinesApi
  public void dispatchYield(@NotNull CoroutineContext paramCoroutineContext, @NotNull Runnable paramRunnable)
  {
    dispatch(paramCoroutineContext, paramRunnable);
  }
  
  @Nullable
  public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> paramKey)
  {
    return ContinuationInterceptor.DefaultImpls.get(this, paramKey);
  }
  
  @NotNull
  public final <T> Continuation<T> interceptContinuation(@NotNull Continuation<? super T> paramContinuation)
  {
    return (Continuation)new DispatchedContinuation(this, paramContinuation);
  }
  
  public boolean isDispatchNeeded(@NotNull CoroutineContext paramCoroutineContext)
  {
    return true;
  }
  
  @NotNull
  public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> paramKey)
  {
    return ContinuationInterceptor.DefaultImpls.minusKey(this, paramKey);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Operator '+' on two CoroutineDispatcher objects is meaningless. CoroutineDispatcher is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The dispatcher to the right of `+` just replaces the dispatcher to the left.")
  @NotNull
  public final CoroutineDispatcher plus(@NotNull CoroutineDispatcher paramCoroutineDispatcher)
  {
    return paramCoroutineDispatcher;
  }
  
  @InternalCoroutinesApi
  public void releaseInterceptedContinuation(@NotNull Continuation<?> paramContinuation)
  {
    if (paramContinuation != null)
    {
      paramContinuation = ((DispatchedContinuation)paramContinuation).getReusableCancellableContinuation();
      if (paramContinuation != null) {
        paramContinuation.detachChild$kotlinx_coroutines_core();
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<*>");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(DebugStringsKt.getClassSimpleName(this));
    localStringBuilder.append('@');
    localStringBuilder.append(DebugStringsKt.getHexAddress(this));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CoroutineDispatcher
 * JD-Core Version:    0.7.0.1
 */