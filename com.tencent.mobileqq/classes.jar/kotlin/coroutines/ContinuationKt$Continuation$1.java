package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/coroutines/ContinuationKt$Continuation$1", "Lkotlin/coroutines/Continuation;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class ContinuationKt$Continuation$1
  implements Continuation<T>
{
  public ContinuationKt$Continuation$1(CoroutineContext paramCoroutineContext, Function1 paramFunction1) {}
  
  @NotNull
  public CoroutineContext getContext()
  {
    return this.$context;
  }
  
  public void resumeWith(@NotNull Object paramObject)
  {
    this.$resumeWith.invoke(Result.box-impl(paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.coroutines.ContinuationKt.Continuation.1
 * JD-Core Version:    0.7.0.1
 */