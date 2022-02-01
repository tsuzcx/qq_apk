package kotlin.coroutines.experimental;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/experimental/Continuation;", "T", "", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "resume", "", "value", "(Ljava/lang/Object;)V", "resumeWithException", "exception", "", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.1")
public abstract interface Continuation<T>
{
  @NotNull
  public abstract CoroutineContext getContext();
  
  public abstract void resume(T paramT);
  
  public abstract void resumeWithException(@NotNull Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.coroutines.experimental.Continuation
 * JD-Core Version:    0.7.0.1
 */