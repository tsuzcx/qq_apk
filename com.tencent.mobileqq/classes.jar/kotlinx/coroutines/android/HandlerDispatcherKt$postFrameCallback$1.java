package kotlinx.coroutines.android;

import android.view.Choreographer.FrameCallback;
import kotlin.Metadata;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "nanos", "", "doFrame"}, k=3, mv={1, 1, 16})
final class HandlerDispatcherKt$postFrameCallback$1
  implements Choreographer.FrameCallback
{
  HandlerDispatcherKt$postFrameCallback$1(CancellableContinuation paramCancellableContinuation) {}
  
  public final void doFrame(long paramLong)
  {
    this.$cont.resumeUndispatched((CoroutineDispatcher)Dispatchers.getMain(), Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.android.HandlerDispatcherKt.postFrameCallback.1
 * JD-Core Version:    0.7.0.1
 */