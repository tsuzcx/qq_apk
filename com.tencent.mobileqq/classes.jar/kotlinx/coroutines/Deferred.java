package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/Deferred;", "T", "Lkotlinx/coroutines/Job;", "onAwait", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnAwait", "()Lkotlinx/coroutines/selects/SelectClause1;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCompleted", "()Ljava/lang/Object;", "getCompletionExceptionOrNull", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract interface Deferred<T>
  extends Job
{
  @Nullable
  public abstract Object await(@NotNull Continuation<? super T> paramContinuation);
  
  @ExperimentalCoroutinesApi
  public abstract T getCompleted();
  
  @ExperimentalCoroutinesApi
  @Nullable
  public abstract Throwable getCompletionExceptionOrNull();
  
  @NotNull
  public abstract SelectClause1<T> getOnAwait();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.Deferred
 * JD-Core Version:    0.7.0.1
 */