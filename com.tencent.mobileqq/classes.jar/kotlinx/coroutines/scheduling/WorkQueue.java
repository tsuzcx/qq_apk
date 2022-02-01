package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/scheduling/WorkQueue;", "<init>", "()V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "fair", "add", "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "addLast", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "", "offloadAllWorkTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "poll", "()Lkotlinx/coroutines/scheduling/Task;", "pollBuffer", "queue", "pollTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "victim", "", "tryStealBlockingFrom", "(Lkotlinx/coroutines/scheduling/WorkQueue;)J", "tryStealFrom", "blockingOnly", "tryStealLastScheduled", "(Lkotlinx/coroutines/scheduling/WorkQueue;Z)J", "decrementIfBlocking", "(Lkotlinx/coroutines/scheduling/Task;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "", "getBufferSize$kotlinx_coroutines_core", "()I", "bufferSize", "getSize$kotlinx_coroutines_core", "size", "kotlinx-coroutines-core", ""}, k=1, mv={1, 1, 16})
public final class WorkQueue
{
  private static final AtomicIntegerFieldUpdater blockingTasksInBuffer$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer");
  private static final AtomicIntegerFieldUpdater consumerIndex$FU;
  private static final AtomicReferenceFieldUpdater lastScheduledTask$FU = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask");
  private static final AtomicIntegerFieldUpdater producerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex");
  private volatile int blockingTasksInBuffer = 0;
  private final AtomicReferenceArray<Task> buffer = new AtomicReferenceArray(128);
  private volatile int consumerIndex = 0;
  private volatile Object lastScheduledTask = null;
  private volatile int producerIndex = 0;
  
  static
  {
    consumerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex");
  }
  
  private final Task addLast(Task paramTask)
  {
    int j = paramTask.taskContext.getTaskMode();
    int i = 1;
    if (j != 1) {
      i = 0;
    }
    if (i != 0) {
      blockingTasksInBuffer$FU.incrementAndGet(this);
    }
    if (getBufferSize$kotlinx_coroutines_core() == 127) {
      return paramTask;
    }
    i = this.producerIndex & 0x7F;
    while (this.buffer.get(i) != null) {
      Thread.yield();
    }
    this.buffer.lazySet(i, paramTask);
    producerIndex$FU.incrementAndGet(this);
    return null;
  }
  
  private final void decrementIfBlocking(@Nullable Task paramTask)
  {
    if (paramTask != null)
    {
      int i = paramTask.taskContext.getTaskMode();
      int j = 0;
      if (i == 1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        int k = blockingTasksInBuffer$FU.decrementAndGet(this);
        if (DebugKt.getASSERTIONS_ENABLED())
        {
          i = j;
          if (k >= 0) {
            i = 1;
          }
          if (i != 0) {
            return;
          }
          throw ((Throwable)new AssertionError());
        }
      }
    }
  }
  
  private final Task pollBuffer()
  {
    Task localTask;
    do
    {
      int i;
      do
      {
        i = this.consumerIndex;
        if (i - this.producerIndex == 0) {
          return null;
        }
      } while (!consumerIndex$FU.compareAndSet(this, i, i + 1));
      localTask = (Task)this.buffer.getAndSet(i & 0x7F, null);
    } while (localTask == null);
    decrementIfBlocking(localTask);
    return localTask;
  }
  
  private final boolean pollTo(GlobalQueue paramGlobalQueue)
  {
    Task localTask = pollBuffer();
    if (localTask != null)
    {
      paramGlobalQueue.addLast(localTask);
      return true;
    }
    return false;
  }
  
  private final long tryStealLastScheduled(WorkQueue paramWorkQueue, boolean paramBoolean)
  {
    Task localTask;
    do
    {
      localTask = (Task)paramWorkQueue.lastScheduledTask;
      if (localTask == null) {
        break;
      }
      if (paramBoolean)
      {
        int j = localTask.taskContext.getTaskMode();
        int i = 1;
        if (j != 1) {
          i = 0;
        }
        if (i == 0) {
          return -2L;
        }
      }
      long l = TasksKt.schedulerTimeSource.nanoTime() - localTask.submissionTime;
      if (l < TasksKt.WORK_STEALING_TIME_RESOLUTION_NS) {
        return TasksKt.WORK_STEALING_TIME_RESOLUTION_NS - l;
      }
    } while (!lastScheduledTask$FU.compareAndSet(paramWorkQueue, localTask, null));
    add$default(this, localTask, false, 2, null);
    return -1L;
    return -2L;
  }
  
  @Nullable
  public final Task add(@NotNull Task paramTask, boolean paramBoolean)
  {
    if (paramBoolean) {
      return addLast(paramTask);
    }
    paramTask = (Task)lastScheduledTask$FU.getAndSet(this, paramTask);
    if (paramTask != null) {
      return addLast(paramTask);
    }
    return null;
  }
  
  public final int getBufferSize$kotlinx_coroutines_core()
  {
    return this.producerIndex - this.consumerIndex;
  }
  
  public final int getSize$kotlinx_coroutines_core()
  {
    if (this.lastScheduledTask != null) {
      return getBufferSize$kotlinx_coroutines_core() + 1;
    }
    return getBufferSize$kotlinx_coroutines_core();
  }
  
  public final void offloadAllWorkTo(@NotNull GlobalQueue paramGlobalQueue)
  {
    Task localTask = (Task)lastScheduledTask$FU.getAndSet(this, null);
    if (localTask != null) {
      paramGlobalQueue.addLast(localTask);
    }
    while (pollTo(paramGlobalQueue)) {}
  }
  
  @Nullable
  public final Task poll()
  {
    Task localTask = (Task)lastScheduledTask$FU.getAndSet(this, null);
    if (localTask != null) {
      return localTask;
    }
    return pollBuffer();
  }
  
  public final long tryStealBlockingFrom(@NotNull WorkQueue paramWorkQueue)
  {
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      if (getBufferSize$kotlinx_coroutines_core() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    int i = paramWorkQueue.consumerIndex;
    int k = paramWorkQueue.producerIndex;
    AtomicReferenceArray localAtomicReferenceArray = paramWorkQueue.buffer;
    while (i != k)
    {
      int m = i & 0x7F;
      if (paramWorkQueue.blockingTasksInBuffer == 0) {
        break;
      }
      Task localTask = (Task)localAtomicReferenceArray.get(m);
      if (localTask != null)
      {
        int j;
        if (localTask.taskContext.getTaskMode() == 1) {
          j = 1;
        } else {
          j = 0;
        }
        if ((j != 0) && (localAtomicReferenceArray.compareAndSet(m, localTask, null)))
        {
          blockingTasksInBuffer$FU.decrementAndGet(paramWorkQueue);
          add$default(this, localTask, false, 2, null);
          return -1L;
        }
      }
      i += 1;
    }
    return tryStealLastScheduled(paramWorkQueue, true);
  }
  
  public final long tryStealFrom(@NotNull WorkQueue paramWorkQueue)
  {
    boolean bool = DebugKt.getASSERTIONS_ENABLED();
    int j = 1;
    int i;
    if (bool)
    {
      if (getBufferSize$kotlinx_coroutines_core() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    Task localTask = paramWorkQueue.pollBuffer();
    if (localTask != null)
    {
      paramWorkQueue = add$default(this, localTask, false, 2, null);
      if (DebugKt.getASSERTIONS_ENABLED())
      {
        if (paramWorkQueue == null) {
          i = j;
        } else {
          i = 0;
        }
        if (i == 0) {
          throw ((Throwable)new AssertionError());
        }
      }
      return -1L;
    }
    return tryStealLastScheduled(paramWorkQueue, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.scheduling.WorkQueue
 * JD-Core Version:    0.7.0.1
 */