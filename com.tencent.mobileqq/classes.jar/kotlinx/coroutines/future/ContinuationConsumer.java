package kotlinx.coroutines.future;

import java.util.concurrent.CompletionException;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/future/ContinuationConsumer;", "T", "Ljava/util/function/BiConsumer;", "", "cont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/Continuation;)V", "accept", "", "result", "exception", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "kotlinx-coroutines-jdk8"}, k=1, mv={1, 1, 13})
final class ContinuationConsumer<T>
  implements BiConsumer<T, Throwable>
{
  @JvmField
  @Nullable
  public volatile Continuation<? super T> cont;
  
  public ContinuationConsumer(@Nullable Continuation<? super T> paramContinuation)
  {
    this.cont = paramContinuation;
  }
  
  public void accept(@Nullable T paramT, @Nullable Throwable paramThrowable)
  {
    Continuation localContinuation = this.cont;
    if (localContinuation != null)
    {
      if (paramThrowable == null)
      {
        paramThrowable = Result.Companion;
        localContinuation.resumeWith(Result.constructor-impl(paramT));
        return;
      }
      if (!(paramThrowable instanceof CompletionException)) {
        paramT = null;
      } else {
        paramT = paramThrowable;
      }
      paramT = (CompletionException)paramT;
      if (paramT != null)
      {
        paramT = paramT.getCause();
        if (paramT != null) {}
      }
      else
      {
        paramT = paramThrowable;
      }
      paramThrowable = Result.Companion;
      localContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramT)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.future.ContinuationConsumer
 * JD-Core Version:    0.7.0.1
 */