package kotlinx.coroutines.android;

import kotlin.Metadata;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"}, k=3, mv={1, 1, 16})
public final class HandlerDispatcherKt$$special$$inlined$Runnable$1
  implements Runnable
{
  public HandlerDispatcherKt$$special$$inlined$Runnable$1(CancellableContinuation paramCancellableContinuation) {}
  
  public final void run()
  {
    HandlerDispatcherKt.access$updateChoreographerAndPostFrameCallback(this.$cont$inlined);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.android.HandlerDispatcherKt..special..inlined.Runnable.1
 * JD-Core Version:    0.7.0.1
 */