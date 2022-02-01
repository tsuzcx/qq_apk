package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Delay.DefaultImpls;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.EventLoop;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/test/TestCoroutineContext$Dispatcher;", "Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/Delay;", "(Lkotlinx/coroutines/test/TestCoroutineContext;)V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "processNextEvent", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "shouldBeProcessedFromContext", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class TestCoroutineContext$Dispatcher
  extends EventLoop
  implements Delay
{
  public TestCoroutineContext$Dispatcher()
  {
    EventLoop.incrementUseCount$default(this, false, 1, null);
  }
  
  @Nullable
  public Object delay(long paramLong, @NotNull Continuation<? super Unit> paramContinuation)
  {
    return Delay.DefaultImpls.delay(this, paramLong, paramContinuation);
  }
  
  public void dispatch(@NotNull CoroutineContext paramCoroutineContext, @NotNull Runnable paramRunnable)
  {
    TestCoroutineContext.access$enqueue(this.this$0, paramRunnable);
  }
  
  @NotNull
  public DisposableHandle invokeOnTimeout(long paramLong, @NotNull Runnable paramRunnable)
  {
    return (DisposableHandle)new TestCoroutineContext.Dispatcher.invokeOnTimeout.1(this, TestCoroutineContext.access$postDelayed(this.this$0, paramRunnable, paramLong));
  }
  
  public long processNextEvent()
  {
    return TestCoroutineContext.access$processNextEvent(this.this$0);
  }
  
  public void scheduleResumeAfterDelay(long paramLong, @NotNull CancellableContinuation<? super Unit> paramCancellableContinuation)
  {
    TestCoroutineContext.access$postDelayed(this.this$0, (Runnable)new TestCoroutineContext.Dispatcher.scheduleResumeAfterDelay..inlined.Runnable.1(this, paramCancellableContinuation), paramLong);
  }
  
  public boolean shouldBeProcessedFromContext()
  {
    return true;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Dispatcher(");
    localStringBuilder.append(this.this$0);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.test.TestCoroutineContext.Dispatcher
 * JD-Core Version:    0.7.0.1
 */