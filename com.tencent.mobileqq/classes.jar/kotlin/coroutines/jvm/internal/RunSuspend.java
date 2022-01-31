package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
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
    for (;;)
    {
      try
      {
        Result localResult = this.result;
        if (localResult != null) {
          break;
        }
        if (this == null) {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
        }
      }
      finally {}
      ((Object)this).wait();
    }
    ResultKt.throwOnFailure(localObject.unbox-impl());
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
      if (this == null) {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
      }
    }
    finally {}
    ((Object)this).notifyAll();
    paramObject = Unit.INSTANCE;
  }
  
  public final void setResult(@Nullable Result<Unit> paramResult)
  {
    this.result = paramResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.coroutines.jvm.internal.RunSuspend
 * JD-Core Version:    0.7.0.1
 */