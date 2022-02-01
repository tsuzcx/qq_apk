package rx.internal.util;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.internal.schedulers.SchedulerLifecycle;
import rx.internal.util.unsafe.MpmcArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.schedulers.Schedulers;

public abstract class ObjectPool<T>
  implements SchedulerLifecycle
{
  final int maxSize;
  final int minSize;
  Queue<T> pool;
  private final AtomicReference<Scheduler.Worker> schedulerWorker;
  private final long validationInterval;
  
  public ObjectPool()
  {
    this(0, 0, 67L);
  }
  
  private ObjectPool(int paramInt1, int paramInt2, long paramLong)
  {
    this.minSize = paramInt1;
    this.maxSize = paramInt2;
    this.validationInterval = paramLong;
    this.schedulerWorker = new AtomicReference();
    initialize(paramInt1);
    start();
  }
  
  private void initialize(int paramInt)
  {
    if (UnsafeAccess.isUnsafeAvailable()) {}
    for (this.pool = new MpmcArrayQueue(Math.max(this.maxSize, 1024));; this.pool = new ConcurrentLinkedQueue())
    {
      int i = 0;
      while (i < paramInt)
      {
        this.pool.add(createObject());
        i += 1;
      }
    }
  }
  
  public T borrowObject()
  {
    Object localObject2 = this.pool.poll();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = createObject();
    }
    return localObject1;
  }
  
  protected abstract T createObject();
  
  public void returnObject(T paramT)
  {
    if (paramT == null) {
      return;
    }
    this.pool.offer(paramT);
  }
  
  public void shutdown()
  {
    Scheduler.Worker localWorker = (Scheduler.Worker)this.schedulerWorker.getAndSet(null);
    if (localWorker != null) {
      localWorker.unsubscribe();
    }
  }
  
  public void start()
  {
    Scheduler.Worker localWorker = Schedulers.computation().createWorker();
    if (this.schedulerWorker.compareAndSet(null, localWorker))
    {
      localWorker.schedulePeriodically(new ObjectPool.1(this), this.validationInterval, this.validationInterval, TimeUnit.SECONDS);
      return;
    }
    localWorker.unsubscribe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.util.ObjectPool
 * JD-Core Version:    0.7.0.1
 */