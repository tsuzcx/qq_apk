package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/flow/internal/NoOpContinuation;", "Lkotlin/coroutines/Continuation;", "", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class NoOpContinuation
  implements Continuation<Object>
{
  public static final NoOpContinuation INSTANCE = new NoOpContinuation();
  @NotNull
  private static final CoroutineContext context = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
  
  @NotNull
  public CoroutineContext getContext()
  {
    return context;
  }
  
  public void resumeWith(@NotNull Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.NoOpContinuation
 * JD-Core Version:    0.7.0.1
 */