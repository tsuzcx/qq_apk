package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlinx.coroutines.CancelHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/sync/CancelSemaphoreAcquisitionHandler;", "Lkotlinx/coroutines/CancelHandler;", "semaphore", "Lkotlinx/coroutines/sync/SemaphoreImpl;", "segment", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "index", "", "(Lkotlinx/coroutines/sync/SemaphoreImpl;Lkotlinx/coroutines/sync/SemaphoreSegment;I)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class CancelSemaphoreAcquisitionHandler
  extends CancelHandler
{
  private final int index;
  private final SemaphoreSegment segment;
  private final SemaphoreImpl semaphore;
  
  public CancelSemaphoreAcquisitionHandler(@NotNull SemaphoreImpl paramSemaphoreImpl, @NotNull SemaphoreSegment paramSemaphoreSegment, int paramInt)
  {
    this.semaphore = paramSemaphoreImpl;
    this.segment = paramSemaphoreSegment;
    this.index = paramInt;
  }
  
  public void invoke(@Nullable Throwable paramThrowable)
  {
    if (this.semaphore.incPermits() >= 0) {
      return;
    }
    if (this.segment.cancel(this.index)) {
      return;
    }
    this.semaphore.resumeNextFromQueue$kotlinx_coroutines_core();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CancelSemaphoreAcquisitionHandler[");
    localStringBuilder.append(this.semaphore);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.segment);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.index);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.sync.CancelSemaphoreAcquisitionHandler
 * JD-Core Version:    0.7.0.1
 */