package kotlinx.coroutines.scheduling;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.TimeSourceKt;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "addToGlobalQueue", "(Lkotlinx/coroutines/scheduling/Task;)Z", "state", "availableCpuPermits", "(J)I", "blockingTasks", "", "close", "()V", "createNewWorker", "()I", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "createTask$kotlinx_coroutines_core", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "createTask", "createdWorkers", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "currentWorker", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "decrementBlockingTasks", "decrementCreatedWorkers", "tailDispatch", "dispatch", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "command", "execute", "(Ljava/lang/Runnable;)V", "incrementBlockingTasks", "()J", "incrementCreatedWorkers", "worker", "parkedWorkersStackNextIndex", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "parkedWorkersStackPop", "parkedWorkersStackPush$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "parkedWorkersStackPush", "oldIndex", "newIndex", "parkedWorkersStackTopUpdate$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "parkedWorkersStackTopUpdate", "releaseCpuPermit", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", "timeout", "shutdown", "(J)V", "skipUnpark", "signalBlockingWork", "(Z)V", "signalCpuWork$kotlinx_coroutines_core", "signalCpuWork", "toString", "()Ljava/lang/String;", "tryAcquireCpuPermit", "()Z", "tryCreateWorker", "(J)Z", "tryUnpark", "submitToLocalQueue", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "getAvailableCpuPermits", "I", "getCreatedWorkers", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "J", "isTerminated", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "workers", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;"}, k=1, mv={1, 1, 16})
public final class CoroutineScheduler
  implements Closeable, Executor
{
  private static final long BLOCKING_MASK = 4398044413952L;
  private static final int BLOCKING_SHIFT = 21;
  private static final int CLAIMED = 0;
  private static final long CPU_PERMITS_MASK = 9223367638808264704L;
  private static final int CPU_PERMITS_SHIFT = 42;
  private static final long CREATED_MASK = 2097151L;
  public static final CoroutineScheduler.Companion Companion = new CoroutineScheduler.Companion(null);
  public static final int MAX_SUPPORTED_POOL_SIZE = 2097150;
  public static final int MIN_SUPPORTED_POOL_SIZE = 1;
  @JvmField
  @NotNull
  public static final Symbol NOT_IN_STACK = new Symbol("NOT_IN_STACK");
  private static final int PARKED = -1;
  private static final long PARKED_INDEX_MASK = 2097151L;
  private static final long PARKED_VERSION_INC = 2097152L;
  private static final long PARKED_VERSION_MASK = -2097152L;
  private static final int TERMINATED = 1;
  private static final AtomicIntegerFieldUpdater _isTerminated$FU = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");
  static final AtomicLongFieldUpdater controlState$FU;
  private static final AtomicLongFieldUpdater parkedWorkersStack$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
  private volatile int _isTerminated;
  volatile long controlState;
  @JvmField
  public final int corePoolSize;
  @JvmField
  @NotNull
  public final GlobalQueue globalBlockingQueue;
  @JvmField
  @NotNull
  public final GlobalQueue globalCpuQueue;
  @JvmField
  public final long idleWorkerKeepAliveNs;
  @JvmField
  public final int maxPoolSize;
  private volatile long parkedWorkersStack;
  @JvmField
  @NotNull
  public final String schedulerName;
  @JvmField
  @NotNull
  public final AtomicReferenceArray<CoroutineScheduler.Worker> workers;
  
  static
  {
    controlState$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
  }
  
  public CoroutineScheduler(int paramInt1, int paramInt2, long paramLong, @NotNull String paramString)
  {
    this.corePoolSize = paramInt1;
    this.maxPoolSize = paramInt2;
    this.idleWorkerKeepAliveNs = paramLong;
    this.schedulerName = paramString;
    if (this.corePoolSize >= 1) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 != 0)
    {
      if (this.maxPoolSize >= this.corePoolSize) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 != 0)
      {
        if (this.maxPoolSize <= 2097150) {
          paramInt1 = 1;
        } else {
          paramInt1 = 0;
        }
        if (paramInt1 != 0)
        {
          if (this.idleWorkerKeepAliveNs > 0L) {
            paramInt1 = 1;
          } else {
            paramInt1 = 0;
          }
          if (paramInt1 != 0)
          {
            this.globalCpuQueue = new GlobalQueue();
            this.globalBlockingQueue = new GlobalQueue();
            this.parkedWorkersStack = 0L;
            this.workers = new AtomicReferenceArray(this.maxPoolSize + 1);
            this.controlState = (this.corePoolSize << 42);
            this._isTerminated = 0;
            return;
          }
          paramString = new StringBuilder();
          paramString.append("Idle worker keep alive time ");
          paramString.append(this.idleWorkerKeepAliveNs);
          paramString.append(" must be positive");
          throw ((Throwable)new IllegalArgumentException(paramString.toString().toString()));
        }
        paramString = new StringBuilder();
        paramString.append("Max pool size ");
        paramString.append(this.maxPoolSize);
        paramString.append(" should not exceed maximal supported number of threads 2097150");
        throw ((Throwable)new IllegalArgumentException(paramString.toString().toString()));
      }
      paramString = new StringBuilder();
      paramString.append("Max pool size ");
      paramString.append(this.maxPoolSize);
      paramString.append(" should be greater than or equals to core pool size ");
      paramString.append(this.corePoolSize);
      throw ((Throwable)new IllegalArgumentException(paramString.toString().toString()));
    }
    paramString = new StringBuilder();
    paramString.append("Core pool size ");
    paramString.append(this.corePoolSize);
    paramString.append(" should be at least 1");
    throw ((Throwable)new IllegalArgumentException(paramString.toString().toString()));
  }
  
  private final boolean addToGlobalQueue(Task paramTask)
  {
    int j = paramTask.taskContext.getTaskMode();
    int i = 1;
    if (j != 1) {
      i = 0;
    }
    if (i != 0) {
      return this.globalBlockingQueue.addLast(paramTask);
    }
    return this.globalCpuQueue.addLast(paramTask);
  }
  
  private final int blockingTasks(long paramLong)
  {
    return (int)((paramLong & 0xFFE00000) >> 21);
  }
  
  private final int createNewWorker()
  {
    for (;;)
    {
      synchronized (this.workers)
      {
        boolean bool = isTerminated();
        if (bool) {
          return -1;
        }
        long l = this.controlState;
        i = (int)(l & 0x1FFFFF);
        int k = (int)((l & 0xFFE00000) >> 21);
        int j = 0;
        k = RangesKt.coerceAtLeast(i - k, 0);
        int m = this.corePoolSize;
        if (k >= m) {
          return 0;
        }
        m = this.maxPoolSize;
        if (i >= m) {
          return 0;
        }
        m = (int)(this.controlState & 0x1FFFFF) + 1;
        if ((m > 0) && (this.workers.get(m) == null))
        {
          i = 1;
          if (i != 0)
          {
            CoroutineScheduler.Worker localWorker = new CoroutineScheduler.Worker(this, m);
            this.workers.set(m, localWorker);
            i = j;
            if (m == (int)(0x1FFFFF & controlState$FU.incrementAndGet(this))) {
              i = 1;
            }
            if (i != 0)
            {
              localWorker.start();
              return k + 1;
            }
            throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
          }
          throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
        }
      }
      int i = 0;
    }
  }
  
  private final int createdWorkers(long paramLong)
  {
    return (int)(paramLong & 0x1FFFFF);
  }
  
  private final CoroutineScheduler.Worker currentWorker()
  {
    Object localObject1 = Thread.currentThread();
    boolean bool = localObject1 instanceof CoroutineScheduler.Worker;
    Object localObject2 = null;
    if (!bool) {
      localObject1 = null;
    }
    CoroutineScheduler.Worker localWorker = (CoroutineScheduler.Worker)localObject1;
    localObject1 = localObject2;
    if (localWorker != null)
    {
      localObject1 = localObject2;
      if (Intrinsics.areEqual(localWorker.this$0, (CoroutineScheduler)this)) {
        localObject1 = localWorker;
      }
    }
    return localObject1;
  }
  
  private final void decrementBlockingTasks()
  {
    controlState$FU.addAndGet(this, -2097152L);
  }
  
  private final int decrementCreatedWorkers()
  {
    return (int)(controlState$FU.getAndDecrement(this) & 0x1FFFFF);
  }
  
  private final int getAvailableCpuPermits()
  {
    return (int)((this.controlState & 0x0) >> 42);
  }
  
  private final int getCreatedWorkers()
  {
    return (int)(this.controlState & 0x1FFFFF);
  }
  
  private final long incrementBlockingTasks()
  {
    return controlState$FU.addAndGet(this, 2097152L);
  }
  
  private final int incrementCreatedWorkers()
  {
    return (int)(controlState$FU.incrementAndGet(this) & 0x1FFFFF);
  }
  
  private final int parkedWorkersStackNextIndex(CoroutineScheduler.Worker paramWorker)
  {
    for (paramWorker = paramWorker.getNextParkedWorker();; paramWorker = paramWorker.getNextParkedWorker())
    {
      if (paramWorker == NOT_IN_STACK) {
        return -1;
      }
      if (paramWorker == null) {
        return 0;
      }
      paramWorker = (CoroutineScheduler.Worker)paramWorker;
      int i = paramWorker.getIndexInArray();
      if (i != 0) {
        return i;
      }
    }
  }
  
  private final CoroutineScheduler.Worker parkedWorkersStackPop()
  {
    long l;
    int i;
    CoroutineScheduler.Worker localWorker;
    do
    {
      l = this.parkedWorkersStack;
      i = (int)(0x1FFFFF & l);
      localWorker = (CoroutineScheduler.Worker)this.workers.get(i);
      if (localWorker == null) {
        break;
      }
      i = parkedWorkersStackNextIndex(localWorker);
    } while ((i < 0) || (!parkedWorkersStack$FU.compareAndSet(this, l, i | 2097152L + l & 0xFFE00000)));
    localWorker.setNextParkedWorker(NOT_IN_STACK);
    return localWorker;
    return null;
  }
  
  private final long releaseCpuPermit()
  {
    return controlState$FU.addAndGet(this, 4398046511104L);
  }
  
  private final void signalBlockingWork(boolean paramBoolean)
  {
    long l = controlState$FU.addAndGet(this, 2097152L);
    if (paramBoolean) {
      return;
    }
    if (tryUnpark()) {
      return;
    }
    if (tryCreateWorker(l)) {
      return;
    }
    tryUnpark();
  }
  
  private final Task submitToLocalQueue(@Nullable CoroutineScheduler.Worker paramWorker, Task paramTask, boolean paramBoolean)
  {
    if (paramWorker == null) {
      return paramTask;
    }
    if (paramWorker.state == CoroutineScheduler.WorkerState.TERMINATED) {
      return paramTask;
    }
    if ((paramTask.taskContext.getTaskMode() == 0) && (paramWorker.state == CoroutineScheduler.WorkerState.BLOCKING)) {
      return paramTask;
    }
    paramWorker.mayHaveLocalTasks = true;
    return paramWorker.localQueue.add(paramTask, paramBoolean);
  }
  
  private final boolean tryAcquireCpuPermit()
  {
    long l;
    do
    {
      l = this.controlState;
      if ((int)((0x0 & l) >> 42) == 0) {
        return false;
      }
    } while (!controlState$FU.compareAndSet(this, l, l - 4398046511104L));
    return true;
  }
  
  private final boolean tryCreateWorker(long paramLong)
  {
    if (RangesKt.coerceAtLeast((int)(0x1FFFFF & paramLong) - (int)((paramLong & 0xFFE00000) >> 21), 0) < this.corePoolSize)
    {
      int i = createNewWorker();
      if ((i == 1) && (this.corePoolSize > 1)) {
        createNewWorker();
      }
      if (i > 0) {
        return true;
      }
    }
    return false;
  }
  
  private final boolean tryUnpark()
  {
    CoroutineScheduler.Worker localWorker;
    do
    {
      localWorker = parkedWorkersStackPop();
      if (localWorker == null) {
        break;
      }
    } while (!CoroutineScheduler.Worker.workerCtl$FU.compareAndSet(localWorker, -1, 0));
    LockSupport.unpark((Thread)localWorker);
    return true;
    return false;
  }
  
  public final int availableCpuPermits(long paramLong)
  {
    return (int)((paramLong & 0x0) >> 42);
  }
  
  public void close()
  {
    shutdown(10000L);
  }
  
  @NotNull
  public final Task createTask$kotlinx_coroutines_core(@NotNull Runnable paramRunnable, @NotNull TaskContext paramTaskContext)
  {
    long l = TasksKt.schedulerTimeSource.nanoTime();
    if ((paramRunnable instanceof Task))
    {
      paramRunnable = (Task)paramRunnable;
      paramRunnable.submissionTime = l;
      paramRunnable.taskContext = paramTaskContext;
      return paramRunnable;
    }
    return (Task)new TaskImpl(paramRunnable, l, paramTaskContext);
  }
  
  public final void dispatch(@NotNull Runnable paramRunnable, @NotNull TaskContext paramTaskContext, boolean paramBoolean)
  {
    Object localObject = TimeSourceKt.getTimeSource();
    if (localObject != null) {
      ((kotlinx.coroutines.TimeSource)localObject).trackTask();
    }
    paramRunnable = createTask$kotlinx_coroutines_core(paramRunnable, paramTaskContext);
    paramTaskContext = currentWorker();
    localObject = submitToLocalQueue(paramTaskContext, paramRunnable, paramBoolean);
    if ((localObject != null) && (!addToGlobalQueue((Task)localObject)))
    {
      paramRunnable = new StringBuilder();
      paramRunnable.append(this.schedulerName);
      paramRunnable.append(" was terminated");
      throw ((Throwable)new RejectedExecutionException(paramRunnable.toString()));
    }
    if ((paramBoolean) && (paramTaskContext != null)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    if (paramRunnable.taskContext.getTaskMode() == 0)
    {
      if (paramBoolean) {
        return;
      }
      signalCpuWork$kotlinx_coroutines_core();
      return;
    }
    signalBlockingWork(paramBoolean);
  }
  
  public void execute(@NotNull Runnable paramRunnable)
  {
    dispatch$default(this, paramRunnable, null, false, 6, null);
  }
  
  public final boolean isTerminated()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final boolean parkedWorkersStackPush$kotlinx_coroutines_core(@NotNull CoroutineScheduler.Worker paramWorker)
  {
    if (paramWorker.getNextParkedWorker() != NOT_IN_STACK) {
      return false;
    }
    long l;
    int k;
    do
    {
      l = this.parkedWorkersStack;
      int j = (int)(0x1FFFFF & l);
      k = paramWorker.getIndexInArray();
      if (DebugKt.getASSERTIONS_ENABLED())
      {
        int i;
        if (k != 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0) {
          throw ((Throwable)new AssertionError());
        }
      }
      paramWorker.setNextParkedWorker(this.workers.get(j));
    } while (!parkedWorkersStack$FU.compareAndSet(this, l, k | 2097152L + l & 0xFFE00000));
    return true;
  }
  
  public final void parkedWorkersStackTopUpdate$kotlinx_coroutines_core(@NotNull CoroutineScheduler.Worker paramWorker, int paramInt1, int paramInt2)
  {
    long l;
    int i;
    do
    {
      l = this.parkedWorkersStack;
      i = (int)(0x1FFFFF & l);
      if (i == paramInt1) {
        if (paramInt2 == 0) {
          i = parkedWorkersStackNextIndex(paramWorker);
        } else {
          i = paramInt2;
        }
      }
    } while ((i < 0) || (!parkedWorkersStack$FU.compareAndSet(this, l, 2097152L + l & 0xFFE00000 | i)));
  }
  
  /* Error */
  public final void runSafely(@NotNull Task paramTask)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 499	kotlinx/coroutines/scheduling/Task:run	()V
    //   4: invokestatic 457	kotlinx/coroutines/TimeSourceKt:getTimeSource	()Lkotlinx/coroutines/TimeSource;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull +41 -> 50
    //   12: aload_1
    //   13: invokeinterface 502 1 0
    //   18: return
    //   19: astore_1
    //   20: goto +31 -> 51
    //   23: astore_1
    //   24: invokestatic 337	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   27: astore_2
    //   28: aload_2
    //   29: invokevirtual 506	java/lang/Thread:getUncaughtExceptionHandler	()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   32: aload_2
    //   33: aload_1
    //   34: invokeinterface 512 3 0
    //   39: invokestatic 457	kotlinx/coroutines/TimeSourceKt:getTimeSource	()Lkotlinx/coroutines/TimeSource;
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull +6 -> 50
    //   47: goto -35 -> 12
    //   50: return
    //   51: invokestatic 457	kotlinx/coroutines/TimeSourceKt:getTimeSource	()Lkotlinx/coroutines/TimeSource;
    //   54: astore_2
    //   55: aload_2
    //   56: ifnull +9 -> 65
    //   59: aload_2
    //   60: invokeinterface 502 1 0
    //   65: goto +5 -> 70
    //   68: aload_1
    //   69: athrow
    //   70: goto -2 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	CoroutineScheduler
    //   0	73	1	paramTask	Task
    //   27	33	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	19	finally
    //   24	39	19	finally
    //   0	4	23	java/lang/Throwable
  }
  
  public final void shutdown(long paramLong)
  {
    ??? = _isTerminated$FU;
    int k = 0;
    if (!((AtomicIntegerFieldUpdater)???).compareAndSet(this, 0, 1)) {
      return;
    }
    CoroutineScheduler.Worker localWorker = currentWorker();
    synchronized (this.workers)
    {
      long l = this.controlState;
      int m = (int)(l & 0x1FFFFF);
      int i;
      if (1 <= m)
      {
        i = 1;
        for (;;)
        {
          ??? = this.workers.get(i);
          if (??? == null) {
            Intrinsics.throwNpe();
          }
          ??? = (CoroutineScheduler.Worker)???;
          if (??? != localWorker)
          {
            while (((CoroutineScheduler.Worker)???).isAlive())
            {
              LockSupport.unpark((Thread)???);
              ((CoroutineScheduler.Worker)???).join(paramLong);
            }
            CoroutineScheduler.WorkerState localWorkerState = ((CoroutineScheduler.Worker)???).state;
            if (DebugKt.getASSERTIONS_ENABLED())
            {
              int j;
              if (localWorkerState == CoroutineScheduler.WorkerState.TERMINATED) {
                j = 1;
              } else {
                j = 0;
              }
              if (j == 0) {
                throw ((Throwable)new AssertionError());
              }
            }
            ((CoroutineScheduler.Worker)???).localQueue.offloadAllWorkTo(this.globalBlockingQueue);
          }
          if (i == m) {
            break;
          }
          i += 1;
        }
      }
      this.globalBlockingQueue.close();
      this.globalCpuQueue.close();
      for (;;)
      {
        if (localWorker != null)
        {
          ??? = localWorker.findTask(true);
          if (??? != null) {}
        }
        else
        {
          ??? = (Task)this.globalCpuQueue.removeFirstOrNull();
        }
        if (??? == null) {
          ??? = (Task)this.globalBlockingQueue.removeFirstOrNull();
        }
        if (??? == null) {
          break;
        }
        runSafely((Task)???);
      }
      if (localWorker != null) {
        localWorker.tryReleaseCpu$kotlinx_coroutines_core(CoroutineScheduler.WorkerState.TERMINATED);
      }
      if (DebugKt.getASSERTIONS_ENABLED())
      {
        i = k;
        if ((int)((this.controlState & 0x0) >> 42) == this.corePoolSize) {
          i = 1;
        }
        if (i == 0) {
          throw ((Throwable)new AssertionError());
        }
      }
      this.parkedWorkersStack = 0L;
      this.controlState = 0L;
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public final void signalCpuWork$kotlinx_coroutines_core()
  {
    if (tryUnpark()) {
      return;
    }
    if (tryCreateWorker$default(this, 0L, 1, null)) {
      return;
    }
    tryUnpark();
  }
  
  @NotNull
  public String toString()
  {
    ArrayList localArrayList = new ArrayList();
    int i7 = this.workers.length();
    int n = 1;
    int i1 = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    int i6;
    for (int i = 0; n < i7; i = i6)
    {
      localObject = (CoroutineScheduler.Worker)this.workers.get(n);
      int i2 = i1;
      int i4 = m;
      int i5 = k;
      int i3 = j;
      i6 = i;
      if (localObject != null)
      {
        int i8 = ((CoroutineScheduler.Worker)localObject).localQueue.getSize$kotlinx_coroutines_core();
        localObject = ((CoroutineScheduler.Worker)localObject).state;
        i2 = CoroutineScheduler.WhenMappings.$EnumSwitchMapping$0[localObject.ordinal()];
        if (i2 != 1)
        {
          StringBuilder localStringBuilder;
          if (i2 != 2)
          {
            if (i2 != 3)
            {
              if (i2 != 4)
              {
                if (i2 != 5)
                {
                  i2 = i1;
                  i4 = m;
                  i5 = k;
                  i3 = j;
                  i6 = i;
                }
                else
                {
                  i6 = i + 1;
                  i2 = i1;
                  i4 = m;
                  i5 = k;
                  i3 = j;
                }
              }
              else
              {
                j += 1;
                i2 = i1;
                i4 = m;
                i5 = k;
                i3 = j;
                i6 = i;
                if (i8 > 0)
                {
                  localObject = (Collection)localArrayList;
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append(String.valueOf(i8));
                  localStringBuilder.append("d");
                  ((Collection)localObject).add(localStringBuilder.toString());
                  i2 = i1;
                  i4 = m;
                  i5 = k;
                  i3 = j;
                  i6 = i;
                }
              }
            }
            else
            {
              i2 = i1 + 1;
              localObject = (Collection)localArrayList;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(String.valueOf(i8));
              localStringBuilder.append("c");
              ((Collection)localObject).add(localStringBuilder.toString());
              i4 = m;
              i5 = k;
              i3 = j;
              i6 = i;
            }
          }
          else
          {
            i4 = m + 1;
            localObject = (Collection)localArrayList;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(String.valueOf(i8));
            localStringBuilder.append("b");
            ((Collection)localObject).add(localStringBuilder.toString());
            i2 = i1;
            i5 = k;
            i3 = j;
            i6 = i;
          }
        }
        else
        {
          i5 = k + 1;
          i6 = i;
          i3 = j;
          i4 = m;
          i2 = i1;
        }
      }
      n += 1;
      i1 = i2;
      m = i4;
      k = i5;
      j = i3;
    }
    long l = this.controlState;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.schedulerName);
    ((StringBuilder)localObject).append('@');
    ((StringBuilder)localObject).append(DebugStringsKt.getHexAddress(this));
    ((StringBuilder)localObject).append('[');
    ((StringBuilder)localObject).append("Pool Size {");
    ((StringBuilder)localObject).append("core = ");
    ((StringBuilder)localObject).append(this.corePoolSize);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append("max = ");
    ((StringBuilder)localObject).append(this.maxPoolSize);
    ((StringBuilder)localObject).append("}, ");
    ((StringBuilder)localObject).append("Worker States {");
    ((StringBuilder)localObject).append("CPU = ");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append("blocking = ");
    ((StringBuilder)localObject).append(m);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append("parked = ");
    ((StringBuilder)localObject).append(k);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append("dormant = ");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append("terminated = ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("}, ");
    ((StringBuilder)localObject).append("running workers queues = ");
    ((StringBuilder)localObject).append(localArrayList);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append("global CPU queue size = ");
    ((StringBuilder)localObject).append(this.globalCpuQueue.getSize());
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append("global blocking queue size = ");
    ((StringBuilder)localObject).append(this.globalBlockingQueue.getSize());
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append("Control State {");
    ((StringBuilder)localObject).append("created workers= ");
    ((StringBuilder)localObject).append((int)(0x1FFFFF & l));
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append("blocking tasks = ");
    ((StringBuilder)localObject).append((int)((0xFFE00000 & l) >> 21));
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append("CPUs acquired = ");
    ((StringBuilder)localObject).append(this.corePoolSize - (int)((l & 0x0) >> 42));
    ((StringBuilder)localObject).append("}]");
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.scheduling.CoroutineScheduler
 * JD-Core Version:    0.7.0.1
 */