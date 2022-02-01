package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"BLOCKING_DEFAULT_PARALLELISM", "", "CORE_POOL_SIZE", "DEFAULT_SCHEDULER_NAME", "", "IDLE_WORKER_KEEP_ALIVE_NS", "", "MAX_POOL_SIZE", "TASK_NON_BLOCKING", "TASK_PROBABLY_BLOCKING", "WORK_STEALING_TIME_RESOLUTION_NS", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/TimeSource;", "isBlocking", "", "Lkotlinx/coroutines/scheduling/Task;", "(Lkotlinx/coroutines/scheduling/Task;)Z", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class TasksKt
{
  @JvmField
  public static final int BLOCKING_DEFAULT_PARALLELISM;
  @JvmField
  public static final int CORE_POOL_SIZE;
  @NotNull
  public static final String DEFAULT_SCHEDULER_NAME = "DefaultDispatcher";
  @JvmField
  public static final long IDLE_WORKER_KEEP_ALIVE_NS = TimeUnit.SECONDS.toNanos(SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null));
  @JvmField
  public static final int MAX_POOL_SIZE;
  public static final int TASK_NON_BLOCKING = 0;
  public static final int TASK_PROBABLY_BLOCKING = 1;
  @JvmField
  public static final long WORK_STEALING_TIME_RESOLUTION_NS = SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
  @JvmField
  @NotNull
  public static TimeSource schedulerTimeSource = (TimeSource)NanoTimeSource.INSTANCE;
  
  static
  {
    BLOCKING_DEFAULT_PARALLELISM = SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, null);
    CORE_POOL_SIZE = SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.core.pool.size", RangesKt.coerceAtLeast(SystemPropsKt.getAVAILABLE_PROCESSORS(), 2), 1, 0, 8, null);
    MAX_POOL_SIZE = SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.max.pool.size", RangesKt.coerceIn(SystemPropsKt.getAVAILABLE_PROCESSORS() * 128, CORE_POOL_SIZE, 2097150), 0, 2097150, 4, null);
  }
  
  public static final boolean isBlocking(@NotNull Task paramTask)
  {
    return paramTask.taskContext.getTaskMode() == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.scheduling.TasksKt
 * JD-Core Version:    0.7.0.1
 */