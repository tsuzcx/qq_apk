package kotlin.coroutines.experimental.migration;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/experimental/migration/ExperimentalContinuationMigration;", "T", "Lkotlin/coroutines/experimental/Continuation;", "continuation", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/Continuation;)V", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "getContinuation", "()Lkotlin/coroutines/Continuation;", "resume", "", "value", "(Ljava/lang/Object;)V", "resumeWithException", "exception", "", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 16})
final class ExperimentalContinuationMigration<T>
  implements kotlin.coroutines.experimental.Continuation<T>
{
  @NotNull
  private final CoroutineContext context;
  @NotNull
  private final kotlin.coroutines.Continuation<T> continuation;
  
  public ExperimentalContinuationMigration(@NotNull kotlin.coroutines.Continuation<? super T> paramContinuation)
  {
    this.continuation = paramContinuation;
    this.context = CoroutinesMigrationKt.toExperimentalCoroutineContext(this.continuation.getContext());
  }
  
  @NotNull
  public CoroutineContext getContext()
  {
    return this.context;
  }
  
  @NotNull
  public final kotlin.coroutines.Continuation<T> getContinuation()
  {
    return this.continuation;
  }
  
  public void resume(T paramT)
  {
    kotlin.coroutines.Continuation localContinuation = this.continuation;
    Result.Companion localCompanion = Result.Companion;
    localContinuation.resumeWith(Result.constructor-impl(paramT));
  }
  
  public void resumeWithException(@NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramThrowable, "exception");
    kotlin.coroutines.Continuation localContinuation = this.continuation;
    Result.Companion localCompanion = Result.Companion;
    localContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramThrowable)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.coroutines.experimental.migration.ExperimentalContinuationMigration
 * JD-Core Version:    0.7.0.1
 */