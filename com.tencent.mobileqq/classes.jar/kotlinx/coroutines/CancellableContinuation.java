package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/CancellableContinuation;", "T", "Lkotlin/coroutines/Continuation;", "isActive", "", "()Z", "isCancelled", "isCompleted", "cancel", "cause", "", "completeResume", "", "token", "", "initCancellability", "invokeOnCancellation", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "resume", "value", "onCancellation", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "tryResume", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryResumeWithException", "exception", "resumeUndispatched", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract interface CancellableContinuation<T>
  extends Continuation<T>
{
  public abstract boolean cancel(@Nullable Throwable paramThrowable);
  
  @InternalCoroutinesApi
  public abstract void completeResume(@NotNull Object paramObject);
  
  public abstract void invokeOnCancellation(@NotNull Function1<? super Throwable, Unit> paramFunction1);
  
  public abstract boolean isActive();
  
  public abstract boolean isCancelled();
  
  public abstract boolean isCompleted();
  
  @ExperimentalCoroutinesApi
  public abstract void resume(T paramT, @NotNull Function1<? super Throwable, Unit> paramFunction1);
  
  @ExperimentalCoroutinesApi
  public abstract void resumeUndispatched(@NotNull CoroutineDispatcher paramCoroutineDispatcher, T paramT);
  
  @ExperimentalCoroutinesApi
  public abstract void resumeUndispatchedWithException(@NotNull CoroutineDispatcher paramCoroutineDispatcher, @NotNull Throwable paramThrowable);
  
  @InternalCoroutinesApi
  @Nullable
  public abstract Object tryResume(T paramT, @Nullable Object paramObject);
  
  @InternalCoroutinesApi
  @Nullable
  public abstract Object tryResumeWithException(@NotNull Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CancellableContinuation
 * JD-Core Version:    0.7.0.1
 */