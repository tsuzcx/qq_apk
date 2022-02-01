package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/CancelFutureOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "future", "Ljava/util/concurrent/Future;", "(Ljava/util/concurrent/Future;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class CancelFutureOnCancel
  extends CancelHandler
{
  private final Future<?> future;
  
  public CancelFutureOnCancel(@NotNull Future<?> paramFuture)
  {
    this.future = paramFuture;
  }
  
  public void invoke(@Nullable Throwable paramThrowable)
  {
    this.future.cancel(false);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CancelFutureOnCancel[");
    localStringBuilder.append(this.future);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CancelFutureOnCancel
 * JD-Core Version:    0.7.0.1
 */