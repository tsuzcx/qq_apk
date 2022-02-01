package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "cause", "", "errorHint", "", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "delay", "", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "isDispatchNeeded", "", "missing", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class MissingMainCoroutineDispatcher
  extends MainCoroutineDispatcher
  implements Delay
{
  private final Throwable cause;
  private final String errorHint;
  
  public MissingMainCoroutineDispatcher(@Nullable Throwable paramThrowable, @Nullable String paramString)
  {
    this.cause = paramThrowable;
    this.errorHint = paramString;
  }
  
  private final Void missing()
  {
    if (this.cause != null)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("Module with the Main dispatcher had failed to initialize");
      String str = this.errorHint;
      if (str != null)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(". ");
        localStringBuilder2.append(str);
        str = localStringBuilder2.toString();
        if (str != null) {}
      }
      else
      {
        str = "";
      }
      localStringBuilder1.append(str);
      throw ((Throwable)new IllegalStateException(localStringBuilder1.toString(), this.cause));
    }
    MainDispatchersKt.throwMissingMainDispatcherException();
    throw null;
  }
  
  @Nullable
  public Object delay(long paramLong, @NotNull Continuation<? super Unit> paramContinuation)
  {
    missing();
    throw null;
  }
  
  @NotNull
  public Void dispatch(@NotNull CoroutineContext paramCoroutineContext, @NotNull Runnable paramRunnable)
  {
    missing();
    throw null;
  }
  
  @NotNull
  public MainCoroutineDispatcher getImmediate()
  {
    return (MainCoroutineDispatcher)this;
  }
  
  @NotNull
  public DisposableHandle invokeOnTimeout(long paramLong, @NotNull Runnable paramRunnable)
  {
    missing();
    throw null;
  }
  
  public boolean isDispatchNeeded(@NotNull CoroutineContext paramCoroutineContext)
  {
    missing();
    throw null;
  }
  
  @NotNull
  public Void scheduleResumeAfterDelay(long paramLong, @NotNull CancellableContinuation<? super Unit> paramCancellableContinuation)
  {
    missing();
    throw null;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Main[missing");
    Object localObject;
    if (this.cause != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", cause=");
      ((StringBuilder)localObject).append(this.cause);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.MissingMainCoroutineDispatcher
 * JD-Core Version:    0.7.0.1
 */