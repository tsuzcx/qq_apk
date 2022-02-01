package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.Random.Default;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "", "index", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "taskMode", "", "afterTask", "(I)V", "beforeTask", "Lkotlinx/coroutines/scheduling/Task;", "task", "executeTask", "(Lkotlinx/coroutines/scheduling/Task;)V", "", "scanLocalQueue", "findAnyTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "findTask", "mode", "idleReset", "inStack", "()Z", "upperBound", "nextInt$kotlinx_coroutines_core", "(I)I", "nextInt", "park", "()V", "pollGlobalQueues", "()Lkotlinx/coroutines/scheduling/Task;", "run", "runWorker", "tryAcquireCpuPermit", "tryPark", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "tryReleaseCpu$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "tryReleaseCpu", "blockingOnly", "trySteal", "tryTerminateWorker", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "mayHaveLocalTasks", "Z", "", "minDelayUntilStealableTaskNs", "J", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "rngState", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "terminationDeadline", "kotlinx-coroutines-core", "Ljava/lang/Thread;"}, k=1, mv={1, 1, 16})
public final class CoroutineScheduler$Worker
  extends Thread
{
  static final AtomicIntegerFieldUpdater workerCtl$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl");
  private volatile int indexInArray;
  @JvmField
  @NotNull
  public final WorkQueue localQueue;
  @JvmField
  public boolean mayHaveLocalTasks;
  private long minDelayUntilStealableTaskNs;
  @Nullable
  private volatile Object nextParkedWorker;
  private int rngState;
  @JvmField
  @NotNull
  public CoroutineScheduler.WorkerState state;
  private long terminationDeadline;
  @NotNull
  volatile int workerCtl;
  
  private CoroutineScheduler$Worker()
  {
    setDaemon(true);
    this.localQueue = new WorkQueue();
    this.state = CoroutineScheduler.WorkerState.DORMANT;
    this.workerCtl = 0;
    this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
    this.rngState = Random.Default.nextInt();
  }
  
  public CoroutineScheduler$Worker(int paramInt)
  {
    this(paramInt);
    int i;
    setIndexInArray(i);
  }
  
  private final void afterTask(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    Object localObject = this.this$0;
    CoroutineScheduler.controlState$FU.addAndGet(localObject, -2097152L);
    localObject = this.state;
    if (localObject != CoroutineScheduler.WorkerState.TERMINATED)
    {
      if (DebugKt.getASSERTIONS_ENABLED())
      {
        if (localObject == CoroutineScheduler.WorkerState.BLOCKING) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if (paramInt == 0) {
          throw ((Throwable)new AssertionError());
        }
      }
      this.state = CoroutineScheduler.WorkerState.DORMANT;
    }
  }
  
  private final void beforeTask(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    if (tryReleaseCpu$kotlinx_coroutines_core(CoroutineScheduler.WorkerState.BLOCKING)) {
      this.this$0.signalCpuWork$kotlinx_coroutines_core();
    }
  }
  
  private final void executeTask(Task paramTask)
  {
    int i = paramTask.taskContext.getTaskMode();
    idleReset(i);
    beforeTask(i);
    this.this$0.runSafely(paramTask);
    afterTask(i);
  }
  
  private final Task findAnyTask(boolean paramBoolean)
  {
    Task localTask;
    if (paramBoolean)
    {
      int i;
      if (nextInt$kotlinx_coroutines_core(this.this$0.corePoolSize * 2) == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        localTask = pollGlobalQueues();
        if (localTask != null) {
          return localTask;
        }
      }
      localTask = this.localQueue.poll();
      if (localTask != null) {
        return localTask;
      }
      if (i == 0)
      {
        localTask = pollGlobalQueues();
        if (localTask != null) {
          return localTask;
        }
      }
    }
    else
    {
      localTask = pollGlobalQueues();
      if (localTask != null) {
        return localTask;
      }
    }
    return trySteal(false);
  }
  
  private final void idleReset(int paramInt)
  {
    this.terminationDeadline = 0L;
    if (this.state == CoroutineScheduler.WorkerState.PARKING)
    {
      if (DebugKt.getASSERTIONS_ENABLED())
      {
        int i = 1;
        if (paramInt == 1) {
          paramInt = i;
        } else {
          paramInt = 0;
        }
        if (paramInt == 0) {
          throw ((Throwable)new AssertionError());
        }
      }
      this.state = CoroutineScheduler.WorkerState.BLOCKING;
    }
  }
  
  private final boolean inStack()
  {
    return this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK;
  }
  
  private final void park()
  {
    if (this.terminationDeadline == 0L) {
      this.terminationDeadline = (System.nanoTime() + this.this$0.idleWorkerKeepAliveNs);
    }
    LockSupport.parkNanos(this.this$0.idleWorkerKeepAliveNs);
    if (System.nanoTime() - this.terminationDeadline >= 0L)
    {
      this.terminationDeadline = 0L;
      tryTerminateWorker();
    }
  }
  
  private final Task pollGlobalQueues()
  {
    if (nextInt$kotlinx_coroutines_core(2) == 0)
    {
      localTask = (Task)this.this$0.globalCpuQueue.removeFirstOrNull();
      if (localTask != null) {
        return localTask;
      }
      return (Task)this.this$0.globalBlockingQueue.removeFirstOrNull();
    }
    Task localTask = (Task)this.this$0.globalBlockingQueue.removeFirstOrNull();
    if (localTask != null) {
      return localTask;
    }
    return (Task)this.this$0.globalCpuQueue.removeFirstOrNull();
  }
  
  private final void runWorker()
  {
    int i = 0;
    for (;;)
    {
      if ((this.this$0.isTerminated()) || (this.state == CoroutineScheduler.WorkerState.TERMINATED)) {
        break label105;
      }
      Task localTask = findTask(this.mayHaveLocalTasks);
      if (localTask != null)
      {
        this.minDelayUntilStealableTaskNs = 0L;
        executeTask(localTask);
        break;
      }
      this.mayHaveLocalTasks = false;
      if (this.minDelayUntilStealableTaskNs != 0L)
      {
        if (i == 0)
        {
          i = 1;
          continue;
        }
        tryReleaseCpu$kotlinx_coroutines_core(CoroutineScheduler.WorkerState.PARKING);
        Thread.interrupted();
        LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
        this.minDelayUntilStealableTaskNs = 0L;
        break;
      }
      tryPark();
    }
    label105:
    tryReleaseCpu$kotlinx_coroutines_core(CoroutineScheduler.WorkerState.TERMINATED);
  }
  
  private final boolean tryAcquireCpuPermit()
  {
    if (this.state == CoroutineScheduler.WorkerState.CPU_ACQUIRED) {
      return true;
    }
    CoroutineScheduler localCoroutineScheduler = this.this$0;
    long l;
    do
    {
      l = localCoroutineScheduler.controlState;
      if ((int)((0x0 & l) >> 42) == 0)
      {
        i = 0;
        break;
      }
    } while (!CoroutineScheduler.controlState$FU.compareAndSet(localCoroutineScheduler, l, l - 4398046511104L));
    int i = 1;
    if (i != 0)
    {
      this.state = CoroutineScheduler.WorkerState.CPU_ACQUIRED;
      return true;
    }
    return false;
  }
  
  private final void tryPark()
  {
    if (!inStack())
    {
      this.this$0.parkedWorkersStackPush$kotlinx_coroutines_core(this);
      return;
    }
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      int i;
      if (this.localQueue.getSize$kotlinx_coroutines_core() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    this.workerCtl = -1;
    while ((inStack()) && (!this.this$0.isTerminated()))
    {
      if (this.state == CoroutineScheduler.WorkerState.TERMINATED) {
        return;
      }
      tryReleaseCpu$kotlinx_coroutines_core(CoroutineScheduler.WorkerState.PARKING);
      Thread.interrupted();
      park();
    }
  }
  
  private final Task trySteal(boolean paramBoolean)
  {
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      if (this.localQueue.getSize$kotlinx_coroutines_core() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    int m = CoroutineScheduler.access$getCreatedWorkers$p(this.this$0);
    if (m < 2) {
      return null;
    }
    int i = nextInt$kotlinx_coroutines_core(m);
    long l1 = 9223372036854775807L;
    int j = 0;
    while (j < m)
    {
      int k = i + 1;
      i = k;
      if (k > m) {
        i = 1;
      }
      Worker localWorker = (Worker)this.this$0.workers.get(i);
      long l3 = l1;
      if (localWorker != null)
      {
        l3 = l1;
        if (localWorker != (Worker)this)
        {
          if (DebugKt.getASSERTIONS_ENABLED())
          {
            if (this.localQueue.getSize$kotlinx_coroutines_core() == 0) {
              k = 1;
            } else {
              k = 0;
            }
            if (k == 0) {
              throw ((Throwable)new AssertionError());
            }
          }
          long l2;
          if (paramBoolean) {
            l2 = this.localQueue.tryStealBlockingFrom(localWorker.localQueue);
          } else {
            l2 = this.localQueue.tryStealFrom(localWorker.localQueue);
          }
          if (l2 == -1L) {
            return this.localQueue.poll();
          }
          l3 = l1;
          if (l2 > 0L) {
            l3 = Math.min(l1, l2);
          }
        }
      }
      j += 1;
      l1 = l3;
    }
    if (l1 == 9223372036854775807L) {
      l1 = 0L;
    }
    this.minDelayUntilStealableTaskNs = l1;
    return null;
  }
  
  private final void tryTerminateWorker()
  {
    synchronized (this.this$0.workers)
    {
      boolean bool = this.this$0.isTerminated();
      if (bool) {
        return;
      }
      int i = CoroutineScheduler.access$getCreatedWorkers$p(this.this$0);
      int j = this.this$0.corePoolSize;
      if (i <= j) {
        return;
      }
      bool = workerCtl$FU.compareAndSet(this, -1, 1);
      if (!bool) {
        return;
      }
      i = this.indexInArray;
      setIndexInArray(0);
      this.this$0.parkedWorkersStackTopUpdate$kotlinx_coroutines_core(this, i, 0);
      Object localObject1 = this.this$0;
      j = (int)(CoroutineScheduler.controlState$FU.getAndDecrement(localObject1) & 0x1FFFFF);
      if (j != i)
      {
        localObject1 = this.this$0.workers.get(j);
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = (Worker)localObject1;
        this.this$0.workers.set(i, localObject1);
        ((Worker)localObject1).setIndexInArray(i);
        this.this$0.parkedWorkersStackTopUpdate$kotlinx_coroutines_core((Worker)localObject1, j, i);
      }
      this.this$0.workers.set(j, null);
      localObject1 = Unit.INSTANCE;
      this.state = CoroutineScheduler.WorkerState.TERMINATED;
      return;
    }
  }
  
  @Nullable
  public final Task findTask(boolean paramBoolean)
  {
    if (tryAcquireCpuPermit()) {
      return findAnyTask(paramBoolean);
    }
    Task localTask;
    if (paramBoolean)
    {
      localTask = this.localQueue.poll();
      if (localTask == null) {
        localTask = (Task)this.this$0.globalBlockingQueue.removeFirstOrNull();
      }
    }
    else
    {
      localTask = (Task)this.this$0.globalBlockingQueue.removeFirstOrNull();
    }
    if (localTask != null) {
      return localTask;
    }
    return trySteal(true);
  }
  
  public final int getIndexInArray()
  {
    return this.indexInArray;
  }
  
  @Nullable
  public final Object getNextParkedWorker()
  {
    return this.nextParkedWorker;
  }
  
  @NotNull
  public final CoroutineScheduler getScheduler()
  {
    return this.this$0;
  }
  
  public final int nextInt$kotlinx_coroutines_core(int paramInt)
  {
    int i = this.rngState;
    i ^= i << 13;
    i ^= i >> 17;
    i ^= i << 5;
    this.rngState = i;
    int j = paramInt - 1;
    if ((j & paramInt) == 0) {
      return i & j;
    }
    return (i & 0x7FFFFFFF) % paramInt;
  }
  
  public void run()
  {
    runWorker();
  }
  
  public final void setIndexInArray(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0.schedulerName);
    localStringBuilder.append("-worker-");
    String str;
    if (paramInt == 0) {
      str = "TERMINATED";
    } else {
      str = String.valueOf(paramInt);
    }
    localStringBuilder.append(str);
    setName(localStringBuilder.toString());
    this.indexInArray = paramInt;
  }
  
  public final void setNextParkedWorker(@Nullable Object paramObject)
  {
    this.nextParkedWorker = paramObject;
  }
  
  public final boolean tryReleaseCpu$kotlinx_coroutines_core(@NotNull CoroutineScheduler.WorkerState paramWorkerState)
  {
    CoroutineScheduler.WorkerState localWorkerState = this.state;
    boolean bool;
    if (localWorkerState == CoroutineScheduler.WorkerState.CPU_ACQUIRED) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      CoroutineScheduler localCoroutineScheduler = this.this$0;
      CoroutineScheduler.controlState$FU.addAndGet(localCoroutineScheduler, 4398046511104L);
    }
    if (localWorkerState != paramWorkerState) {
      this.state = paramWorkerState;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.scheduling.CoroutineScheduler.Worker
 * JD-Core Version:    0.7.0.1
 */