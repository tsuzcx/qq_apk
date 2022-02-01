package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/DeferredCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlinx/coroutines/Deferred;", "Lkotlinx/coroutines/selects/SelectClause1;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "onAwait", "getOnAwait", "()Lkotlinx/coroutines/selects/SelectClause1;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCompleted", "()Ljava/lang/Object;", "registerSelectClause1", "", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
class DeferredCoroutine<T>
  extends AbstractCoroutine<T>
  implements Deferred<T>, SelectClause1<T>
{
  public DeferredCoroutine(@NotNull CoroutineContext paramCoroutineContext, boolean paramBoolean)
  {
    super(paramCoroutineContext, paramBoolean);
  }
  
  @Nullable
  public Object await(@NotNull Continuation<? super T> paramContinuation)
  {
    return await$suspendImpl(this, paramContinuation);
  }
  
  public T getCompleted()
  {
    return getCompletedInternal$kotlinx_coroutines_core();
  }
  
  @NotNull
  public SelectClause1<T> getOnAwait()
  {
    return (SelectClause1)this;
  }
  
  public <R> void registerSelectClause1(@NotNull SelectInstance<? super R> paramSelectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    registerSelectClause1Internal$kotlinx_coroutines_core(paramSelectInstance, paramFunction2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.DeferredCoroutine
 * JD-Core Version:    0.7.0.1
 */