package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.Continuation<-TT;>;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/CompletableDeferredImpl;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableDeferred;", "Lkotlinx/coroutines/selects/SelectClause1;", "parent", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "onAwait", "getOnAwait", "()Lkotlinx/coroutines/selects/SelectClause1;", "onCancelComplete", "", "getOnCancelComplete$kotlinx_coroutines_core", "()Z", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "complete", "value", "(Ljava/lang/Object;)Z", "completeExceptionally", "exception", "", "getCompleted", "()Ljava/lang/Object;", "registerSelectClause1", "", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class CompletableDeferredImpl<T>
  extends JobSupport
  implements CompletableDeferred<T>, SelectClause1<T>
{
  public CompletableDeferredImpl(@Nullable Job paramJob)
  {
    super(true);
    initParentJobInternal$kotlinx_coroutines_core(paramJob);
  }
  
  @Nullable
  public Object await(@NotNull Continuation<? super T> paramContinuation)
  {
    if ((paramContinuation instanceof CompletableDeferredImpl.await.1))
    {
      localObject1 = (CompletableDeferredImpl.await.1)paramContinuation;
      if ((((CompletableDeferredImpl.await.1)localObject1).label & 0x80000000) != 0)
      {
        ((CompletableDeferredImpl.await.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation<? super T>)localObject1;
        break label48;
      }
    }
    paramContinuation = new CompletableDeferredImpl.await.1(this, paramContinuation);
    label48:
    Object localObject1 = paramContinuation.result;
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    if (i != 0)
    {
      if (i == 1)
      {
        paramContinuation = (CompletableDeferredImpl)paramContinuation.L$0;
        ResultKt.throwOnFailure(localObject1);
        return localObject1;
      }
      throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
    ResultKt.throwOnFailure(localObject1);
    paramContinuation.L$0 = this;
    paramContinuation.label = 1;
    paramContinuation = awaitInternal$kotlinx_coroutines_core(paramContinuation);
    if (paramContinuation == localObject2) {
      return localObject2;
    }
    return paramContinuation;
  }
  
  public boolean complete(T paramT)
  {
    return makeCompleting$kotlinx_coroutines_core(paramT);
  }
  
  public boolean completeExceptionally(@NotNull Throwable paramThrowable)
  {
    return makeCompleting$kotlinx_coroutines_core(new CompletedExceptionally(paramThrowable, false, 2, null));
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
  
  public boolean getOnCancelComplete$kotlinx_coroutines_core()
  {
    return true;
  }
  
  public <R> void registerSelectClause1(@NotNull SelectInstance<? super R> paramSelectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    registerSelectClause1Internal$kotlinx_coroutines_core(paramSelectInstance, paramFunction2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CompletableDeferredImpl
 * JD-Core Version:    0.7.0.1
 */