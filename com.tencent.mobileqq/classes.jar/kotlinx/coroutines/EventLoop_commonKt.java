package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"CLOSED_EMPTY", "Lkotlinx/coroutines/internal/Symbol;", "CLOSED_EMPTY$annotations", "()V", "DISPOSED_TASK", "DISPOSED_TASK$annotations", "MAX_DELAY_NS", "", "MAX_MS", "MS_TO_NS", "SCHEDULE_COMPLETED", "", "SCHEDULE_DISPOSED", "SCHEDULE_OK", "delayNanosToMillis", "timeNanos", "delayToNanos", "timeMillis", "Queue", "T", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class EventLoop_commonKt
{
  private static final Symbol CLOSED_EMPTY = new Symbol("CLOSED_EMPTY");
  private static final Symbol DISPOSED_TASK = new Symbol("REMOVED_TASK");
  private static final long MAX_DELAY_NS = 4611686018427387903L;
  private static final long MAX_MS = 9223372036854L;
  private static final long MS_TO_NS = 1000000L;
  private static final int SCHEDULE_COMPLETED = 1;
  private static final int SCHEDULE_DISPOSED = 2;
  private static final int SCHEDULE_OK = 0;
  
  public static final long delayNanosToMillis(long paramLong)
  {
    return paramLong / 1000000L;
  }
  
  public static final long delayToNanos(long paramLong)
  {
    if (paramLong <= 0L) {
      return 0L;
    }
    if (paramLong >= 9223372036854L) {
      return 9223372036854775807L;
    }
    return 1000000L * paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.EventLoop_commonKt
 * JD-Core Version:    0.7.0.1
 */