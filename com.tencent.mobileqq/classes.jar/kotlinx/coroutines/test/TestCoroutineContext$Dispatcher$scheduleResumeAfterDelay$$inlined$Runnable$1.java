package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"}, k=3, mv={1, 1, 16})
public final class TestCoroutineContext$Dispatcher$scheduleResumeAfterDelay$$inlined$Runnable$1
  implements Runnable
{
  public TestCoroutineContext$Dispatcher$scheduleResumeAfterDelay$$inlined$Runnable$1(TestCoroutineContext.Dispatcher paramDispatcher, CancellableContinuation paramCancellableContinuation) {}
  
  public final void run()
  {
    this.$continuation$inlined.resumeUndispatched(this.this$0, Unit.INSTANCE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.test.TestCoroutineContext.Dispatcher.scheduleResumeAfterDelay..inlined.Runnable.1
 * JD-Core Version:    0.7.0.1
 */