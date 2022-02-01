package kotlinx.coroutines.android;

import android.os.Handler;
import kotlin.Metadata;
import kotlinx.coroutines.DisposableHandle;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/android/HandlerContext$invokeOnTimeout$1", "Lkotlinx/coroutines/DisposableHandle;", "dispose", "", "kotlinx-coroutines-android"}, k=1, mv={1, 1, 16})
public final class HandlerContext$invokeOnTimeout$1
  implements DisposableHandle
{
  HandlerContext$invokeOnTimeout$1(Runnable paramRunnable) {}
  
  public void dispose()
  {
    HandlerContext.access$getHandler$p(this.this$0).removeCallbacks(this.$block);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.android.HandlerContext.invokeOnTimeout.1
 * JD-Core Version:    0.7.0.1
 */