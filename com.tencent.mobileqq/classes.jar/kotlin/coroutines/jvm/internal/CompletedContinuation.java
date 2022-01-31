package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/jvm/internal/CompletedContinuation;", "Lkotlin/coroutines/Continuation;", "", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class CompletedContinuation
  implements Continuation<Object>
{
  public static final CompletedContinuation INSTANCE = new CompletedContinuation();
  
  @NotNull
  public CoroutineContext getContext()
  {
    throw ((Throwable)new IllegalStateException("This continuation is already complete".toString()));
  }
  
  public void resumeWith(@NotNull Object paramObject)
  {
    throw ((Throwable)new IllegalStateException("This continuation is already complete".toString()));
  }
  
  @NotNull
  public String toString()
  {
    return "This continuation is already complete";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.coroutines.jvm.internal.CompletedContinuation
 * JD-Core Version:    0.7.0.1
 */