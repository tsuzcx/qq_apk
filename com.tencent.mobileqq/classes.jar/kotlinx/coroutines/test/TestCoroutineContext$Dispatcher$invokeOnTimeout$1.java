package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/test/TestCoroutineContext$Dispatcher$invokeOnTimeout$1", "Lkotlinx/coroutines/DisposableHandle;", "dispose", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class TestCoroutineContext$Dispatcher$invokeOnTimeout$1
  implements DisposableHandle
{
  TestCoroutineContext$Dispatcher$invokeOnTimeout$1(TimedRunnableObsolete paramTimedRunnableObsolete) {}
  
  public void dispose()
  {
    TestCoroutineContext.access$getQueue$p(this.this$0.this$0).remove((ThreadSafeHeapNode)this.$node);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.test.TestCoroutineContext.Dispatcher.invokeOnTimeout.1
 * JD-Core Version:    0.7.0.1
 */