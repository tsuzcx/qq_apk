package kotlinx.coroutines.android;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "invoke"}, k=3, mv={1, 1, 16})
final class HandlerContext$scheduleResumeAfterDelay$1
  extends Lambda
  implements Function1<Throwable, Unit>
{
  HandlerContext$scheduleResumeAfterDelay$1(HandlerContext paramHandlerContext, Runnable paramRunnable)
  {
    super(1);
  }
  
  public final void invoke(@Nullable Throwable paramThrowable)
  {
    HandlerContext.access$getHandler$p(this.this$0).removeCallbacks(this.$block);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.android.HandlerContext.scheduleResumeAfterDelay.1
 * JD-Core Version:    0.7.0.1
 */