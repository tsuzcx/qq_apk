package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "handler", "Landroid/os/Handler;", "name", "", "(Landroid/os/Handler;Ljava/lang/String;)V", "invokeImmediately", "", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "_immediate", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "equals", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "isDispatchNeeded", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-android"}, k=1, mv={1, 1, 16})
public final class HandlerContext
  extends HandlerDispatcher
  implements Delay
{
  private volatile HandlerContext _immediate;
  private final Handler handler;
  @NotNull
  private final HandlerContext immediate;
  private final boolean invokeImmediately;
  private final String name;
  
  public HandlerContext(@NotNull Handler paramHandler, @Nullable String paramString)
  {
    this(paramHandler, paramString, false);
  }
  
  private HandlerContext(Handler paramHandler, String paramString, boolean paramBoolean)
  {
    super(null);
    this.handler = paramHandler;
    this.name = paramString;
    this.invokeImmediately = paramBoolean;
    paramHandler = localObject;
    if (this.invokeImmediately) {
      paramHandler = this;
    }
    this._immediate = paramHandler;
    paramHandler = this._immediate;
    if (paramHandler == null)
    {
      paramHandler = new HandlerContext(this.handler, this.name, true);
      this._immediate = paramHandler;
    }
    this.immediate = paramHandler;
  }
  
  public void dispatch(@NotNull CoroutineContext paramCoroutineContext, @NotNull Runnable paramRunnable)
  {
    this.handler.post(paramRunnable);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof HandlerContext)) && (((HandlerContext)paramObject).handler == this.handler);
  }
  
  @NotNull
  public HandlerContext getImmediate()
  {
    return this.immediate;
  }
  
  public int hashCode()
  {
    return System.identityHashCode(this.handler);
  }
  
  @NotNull
  public DisposableHandle invokeOnTimeout(long paramLong, @NotNull Runnable paramRunnable)
  {
    this.handler.postDelayed(paramRunnable, RangesKt.coerceAtMost(paramLong, 4611686018427387903L));
    return (DisposableHandle)new HandlerContext.invokeOnTimeout.1(this, paramRunnable);
  }
  
  public boolean isDispatchNeeded(@NotNull CoroutineContext paramCoroutineContext)
  {
    boolean bool2 = this.invokeImmediately;
    boolean bool1 = true;
    if (bool2)
    {
      if ((Intrinsics.areEqual(Looper.myLooper(), this.handler.getLooper()) ^ true)) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public void scheduleResumeAfterDelay(long paramLong, @NotNull CancellableContinuation<? super Unit> paramCancellableContinuation)
  {
    Runnable localRunnable = (Runnable)new HandlerContext.scheduleResumeAfterDelay..inlined.Runnable.1(this, paramCancellableContinuation);
    this.handler.postDelayed(localRunnable, RangesKt.coerceAtMost(paramLong, 4611686018427387903L));
    paramCancellableContinuation.invokeOnCancellation((Function1)new HandlerContext.scheduleResumeAfterDelay.1(this, localRunnable));
  }
  
  @NotNull
  public String toString()
  {
    Object localObject = this.name;
    if (localObject != null)
    {
      if (this.invokeImmediately)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.name);
        ((StringBuilder)localObject).append(" [immediate]");
        return ((StringBuilder)localObject).toString();
      }
    }
    else {
      localObject = this.handler.toString();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.android.HandlerContext
 * JD-Core Version:    0.7.0.1
 */