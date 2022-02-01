package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/EventLoopImplBase;", "<init>", "()V", "", "closeQueue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dequeue", "()Ljava/lang/Runnable;", "Lkotlin/coroutines/CoroutineContext;", "context", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "", "processNextEvent", "()J", "rescheduleAllDelayed", "resetAll", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "", "scheduleImpl", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "shouldUnpark", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "shutdown", "value", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "getNextTime", "nextTime", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;"}, k=1, mv={1, 1, 16})
public abstract class EventLoopImplBase
  extends EventLoopImplPlatform
  implements Delay
{
  private static final AtomicReferenceFieldUpdater _delayed$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_delayed");
  private static final AtomicReferenceFieldUpdater _queue$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_queue");
  private volatile Object _delayed = null;
  private volatile int _isCompleted = 0;
  private volatile Object _queue = null;
  
  private final void closeQueue()
  {
    if ((DebugKt.getASSERTIONS_ENABLED()) && (!isCompleted())) {
      throw ((Throwable)new AssertionError());
    }
    LockFreeTaskQueueCore localLockFreeTaskQueueCore;
    do
    {
      do
      {
        localObject = this._queue;
        if (localObject != null) {
          break;
        }
      } while (!_queue$FU.compareAndSet(this, null, EventLoop_commonKt.access$getCLOSED_EMPTY$p()));
      return;
      if ((localObject instanceof LockFreeTaskQueueCore))
      {
        ((LockFreeTaskQueueCore)localObject).close();
        return;
      }
      if (localObject == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
        return;
      }
      localLockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
      if (localObject == null) {
        break;
      }
      localLockFreeTaskQueueCore.addLast((Runnable)localObject);
    } while (!_queue$FU.compareAndSet(this, localObject, localLockFreeTaskQueueCore));
    return;
    Object localObject = new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private final Runnable dequeue()
  {
    label70:
    do
    {
      for (;;)
      {
        localObject1 = this._queue;
        if (localObject1 == null) {
          return null;
        }
        if (!(localObject1 instanceof LockFreeTaskQueueCore)) {
          break label70;
        }
        if (localObject1 == null) {
          break;
        }
        LockFreeTaskQueueCore localLockFreeTaskQueueCore = (LockFreeTaskQueueCore)localObject1;
        Object localObject2 = localLockFreeTaskQueueCore.removeFirstOrNull();
        if (localObject2 != LockFreeTaskQueueCore.REMOVE_FROZEN) {
          return (Runnable)localObject2;
        }
        _queue$FU.compareAndSet(this, localObject1, localLockFreeTaskQueueCore.next());
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
      if (localObject1 == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
        return null;
      }
    } while (!_queue$FU.compareAndSet(this, localObject1, null));
    if (localObject1 != null) {
      return (Runnable)localObject1;
    }
    Object localObject1 = new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  private final boolean enqueueImpl(Runnable paramRunnable)
  {
    Object localObject;
    LockFreeTaskQueueCore localLockFreeTaskQueueCore;
    label94:
    label104:
    do
    {
      for (;;)
      {
        localObject = this._queue;
        if (isCompleted()) {
          return false;
        }
        if (localObject == null)
        {
          if (_queue$FU.compareAndSet(this, null, paramRunnable)) {
            return true;
          }
        }
        else
        {
          if (!(localObject instanceof LockFreeTaskQueueCore)) {
            break label104;
          }
          if (localObject == null) {
            break label94;
          }
          localLockFreeTaskQueueCore = (LockFreeTaskQueueCore)localObject;
          int i = localLockFreeTaskQueueCore.addLast(paramRunnable);
          if (i == 0) {
            break;
          }
          if (i != 1)
          {
            if (i == 2) {
              return false;
            }
          }
          else {
            _queue$FU.compareAndSet(this, localObject, localLockFreeTaskQueueCore.next());
          }
        }
      }
      return true;
      throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
      if (localObject == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
        return false;
      }
      localLockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
      if (localObject == null) {
        break;
      }
      localLockFreeTaskQueueCore.addLast((Runnable)localObject);
      localLockFreeTaskQueueCore.addLast(paramRunnable);
    } while (!_queue$FU.compareAndSet(this, localObject, localLockFreeTaskQueueCore));
    return true;
    paramRunnable = new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
    for (;;)
    {
      throw paramRunnable;
    }
  }
  
  private final boolean isCompleted()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private final void rescheduleAllDelayed()
  {
    Object localObject = TimeSourceKt.getTimeSource();
    long l;
    if (localObject != null) {
      l = ((TimeSource)localObject).nanoTime();
    } else {
      l = System.nanoTime();
    }
    for (;;)
    {
      localObject = (EventLoopImplBase.DelayedTaskQueue)this._delayed;
      if (localObject == null) {
        break;
      }
      localObject = (EventLoopImplBase.DelayedTask)((EventLoopImplBase.DelayedTaskQueue)localObject).removeFirstOrNull();
      if (localObject == null) {
        break;
      }
      reschedule(l, (EventLoopImplBase.DelayedTask)localObject);
    }
  }
  
  private final int scheduleImpl(long paramLong, EventLoopImplBase.DelayedTask paramDelayedTask)
  {
    if (isCompleted()) {
      return 1;
    }
    Object localObject = (EventLoopImplBase.DelayedTaskQueue)this._delayed;
    if (localObject == null)
    {
      localObject = (EventLoopImplBase)this;
      _delayed$FU.compareAndSet(localObject, null, new EventLoopImplBase.DelayedTaskQueue(paramLong));
      localObject = ((EventLoopImplBase)localObject)._delayed;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = (EventLoopImplBase.DelayedTaskQueue)localObject;
    }
    return paramDelayedTask.scheduleTask(paramLong, (EventLoopImplBase.DelayedTaskQueue)localObject, this);
  }
  
  private final void setCompleted(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private final boolean shouldUnpark(EventLoopImplBase.DelayedTask paramDelayedTask)
  {
    Object localObject = (EventLoopImplBase.DelayedTaskQueue)this._delayed;
    if (localObject != null) {
      localObject = (EventLoopImplBase.DelayedTask)((EventLoopImplBase.DelayedTaskQueue)localObject).peek();
    } else {
      localObject = null;
    }
    return localObject == paramDelayedTask;
  }
  
  @Nullable
  public Object delay(long paramLong, @NotNull Continuation<? super Unit> paramContinuation)
  {
    return Delay.DefaultImpls.delay(this, paramLong, paramContinuation);
  }
  
  public final void dispatch(@NotNull CoroutineContext paramCoroutineContext, @NotNull Runnable paramRunnable)
  {
    enqueue(paramRunnable);
  }
  
  public final void enqueue(@NotNull Runnable paramRunnable)
  {
    if (enqueueImpl(paramRunnable))
    {
      unpark();
      return;
    }
    DefaultExecutor.INSTANCE.enqueue(paramRunnable);
  }
  
  protected long getNextTime()
  {
    if (super.getNextTime() == 0L) {
      return 0L;
    }
    Object localObject = this._queue;
    if (localObject != null)
    {
      if (!(localObject instanceof LockFreeTaskQueueCore)) {
        break label118;
      }
      if (!((LockFreeTaskQueueCore)localObject).isEmpty()) {
        return 0L;
      }
    }
    localObject = (EventLoopImplBase.DelayedTaskQueue)this._delayed;
    if (localObject != null)
    {
      localObject = (EventLoopImplBase.DelayedTask)((EventLoopImplBase.DelayedTaskQueue)localObject).peek();
      if (localObject != null)
      {
        long l2 = ((EventLoopImplBase.DelayedTask)localObject).nanoTime;
        localObject = TimeSourceKt.getTimeSource();
        long l1;
        if (localObject != null) {
          l1 = ((TimeSource)localObject).nanoTime();
        } else {
          l1 = System.nanoTime();
        }
        return RangesKt.coerceAtLeast(l2 - l1, 0L);
      }
    }
    return 9223372036854775807L;
    label118:
    if (localObject == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
      return 9223372036854775807L;
    }
    return 0L;
  }
  
  @NotNull
  public DisposableHandle invokeOnTimeout(long paramLong, @NotNull Runnable paramRunnable)
  {
    return Delay.DefaultImpls.invokeOnTimeout(this, paramLong, paramRunnable);
  }
  
  protected boolean isEmpty()
  {
    if (!isUnconfinedQueueEmpty()) {
      return false;
    }
    Object localObject = (EventLoopImplBase.DelayedTaskQueue)this._delayed;
    if ((localObject != null) && (!((EventLoopImplBase.DelayedTaskQueue)localObject).isEmpty())) {
      return false;
    }
    localObject = this._queue;
    if (localObject == null) {}
    do
    {
      return true;
      if ((localObject instanceof LockFreeTaskQueueCore)) {
        return ((LockFreeTaskQueueCore)localObject).isEmpty();
      }
    } while (localObject == EventLoop_commonKt.access$getCLOSED_EMPTY$p());
    return false;
  }
  
  public long processNextEvent()
  {
    if (processUnconfinedEvent()) {
      return getNextTime();
    }
    EventLoopImplBase.DelayedTaskQueue localDelayedTaskQueue = (EventLoopImplBase.DelayedTaskQueue)this._delayed;
    Object localObject1;
    long l;
    if ((localDelayedTaskQueue != null) && (!localDelayedTaskQueue.isEmpty()))
    {
      localObject1 = TimeSourceKt.getTimeSource();
      if (localObject1 != null) {
        l = ((TimeSource)localObject1).nanoTime();
      } else {
        l = System.nanoTime();
      }
    }
    for (;;)
    {
      synchronized ((ThreadSafeHeap)localDelayedTaskQueue)
      {
        ThreadSafeHeapNode localThreadSafeHeapNode = ???.firstImpl();
        EventLoopImplBase.DelayedTask localDelayedTask = null;
        localObject1 = null;
        if (localThreadSafeHeapNode != null)
        {
          localDelayedTask = (EventLoopImplBase.DelayedTask)localThreadSafeHeapNode;
          if (!localDelayedTask.timeToExecute(l)) {
            break label183;
          }
          bool = enqueueImpl((Runnable)localDelayedTask);
          if (bool) {
            localObject1 = ???.removeAtImpl(0);
          }
        }
        else
        {
          localObject1 = localDelayedTask;
        }
        if ((EventLoopImplBase.DelayedTask)localObject1 == null) {}
      }
      Runnable localRunnable = dequeue();
      if (localRunnable != null) {
        localRunnable.run();
      }
      return getNextTime();
      label183:
      boolean bool = false;
    }
  }
  
  protected final void resetAll()
  {
    this._queue = null;
    this._delayed = null;
  }
  
  public final void schedule(long paramLong, @NotNull EventLoopImplBase.DelayedTask paramDelayedTask)
  {
    int i = scheduleImpl(paramLong, paramDelayedTask);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          return;
        }
        throw ((Throwable)new IllegalStateException("unexpected result".toString()));
      }
      reschedule(paramLong, paramDelayedTask);
      return;
    }
    if (shouldUnpark(paramDelayedTask)) {
      unpark();
    }
  }
  
  @NotNull
  protected final DisposableHandle scheduleInvokeOnTimeout(long paramLong, @NotNull Runnable paramRunnable)
  {
    long l = EventLoop_commonKt.delayToNanos(paramLong);
    if (l < 4611686018427387903L)
    {
      TimeSource localTimeSource = TimeSourceKt.getTimeSource();
      if (localTimeSource != null) {
        paramLong = localTimeSource.nanoTime();
      } else {
        paramLong = System.nanoTime();
      }
      paramRunnable = new EventLoopImplBase.DelayedRunnableTask(l + paramLong, paramRunnable);
      schedule(paramLong, (EventLoopImplBase.DelayedTask)paramRunnable);
      return (DisposableHandle)paramRunnable;
    }
    return (DisposableHandle)NonDisposableHandle.INSTANCE;
  }
  
  public void scheduleResumeAfterDelay(long paramLong, @NotNull CancellableContinuation<? super Unit> paramCancellableContinuation)
  {
    long l = EventLoop_commonKt.delayToNanos(paramLong);
    if (l < 4611686018427387903L)
    {
      Object localObject = TimeSourceKt.getTimeSource();
      if (localObject != null) {
        paramLong = ((TimeSource)localObject).nanoTime();
      } else {
        paramLong = System.nanoTime();
      }
      localObject = new EventLoopImplBase.DelayedResumeTask(this, l + paramLong, paramCancellableContinuation);
      CancellableContinuationKt.disposeOnCancellation(paramCancellableContinuation, (DisposableHandle)localObject);
      schedule(paramLong, (EventLoopImplBase.DelayedTask)localObject);
    }
  }
  
  protected void shutdown()
  {
    ThreadLocalEventLoop.INSTANCE.resetEventLoop$kotlinx_coroutines_core();
    setCompleted(true);
    closeQueue();
    while (processNextEvent() <= 0L) {}
    rescheduleAllDelayed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.EventLoopImplBase
 * JD-Core Version:    0.7.0.1
 */