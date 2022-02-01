package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/jvm/internal/RunSuspend;", "Lkotlin/coroutines/Continuation;", "", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "Lkotlin/Result;", "getResult", "()Lkotlin/Result;", "setResult", "(Lkotlin/Result;)V", "await", "resumeWith", "(Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class RunSuspend
  implements Continuation<Unit>
{
  @Nullable
  private Result<Unit> result;
  
  public final void await()
  {
    try
    {
      Result localResult;
      for (;;)
      {
        localResult = this.result;
        if (localResult != null) {
          break;
        }
        ((Object)this).wait();
      }
      ResultKt.throwOnFailure(localResult.unbox-impl());
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  @NotNull
  public CoroutineContext getContext()
  {
    return (CoroutineContext)EmptyCoroutineContext.INSTANCE;
  }
  
  @Nullable
  public final Result<Unit> getResult()
  {
    return this.result;
  }
  
  public void resumeWith(@NotNull Object paramObject)
  {
    try
    {
      this.result = Result.box-impl(paramObject);
      ((Object)this).notifyAll();
      paramObject = Unit.INSTANCE;
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public final void setResult(@Nullable Result<Unit> paramResult)
  {
    this.result = paramResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.coroutines.jvm.internal.RunSuspend
 * JD-Core Version:    0.7.0.1
 */