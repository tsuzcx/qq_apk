package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.ScopeCoroutine;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/TimeoutCoroutine;", "U", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "time", "", "uCont", "Lkotlin/coroutines/Continuation;", "(JLkotlin/coroutines/Continuation;)V", "nameString", "", "nameString$kotlinx_coroutines_core", "run", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class TimeoutCoroutine<U, T extends U>
  extends ScopeCoroutine<T>
  implements Runnable
{
  @JvmField
  public final long time;
  
  public TimeoutCoroutine(long paramLong, @NotNull Continuation<? super U> paramContinuation)
  {
    super(paramContinuation.getContext(), paramContinuation);
    this.time = paramLong;
  }
  
  @NotNull
  public String nameString$kotlinx_coroutines_core()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.nameString$kotlinx_coroutines_core());
    localStringBuilder.append("(timeMillis=");
    localStringBuilder.append(this.time);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public void run()
  {
    cancelCoroutine((Throwable)TimeoutKt.TimeoutCancellationException(this.time, (Job)this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.TimeoutCoroutine
 * JD-Core Version:    0.7.0.1
 */