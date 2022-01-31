package rx.internal.schedulers;

final class EventLoopsScheduler$FixedSchedulerPool
{
  final int cores;
  final EventLoopsScheduler.PoolWorker[] eventLoops;
  long n;
  
  EventLoopsScheduler$FixedSchedulerPool(int paramInt)
  {
    this.cores = paramInt;
    this.eventLoops = new EventLoopsScheduler.PoolWorker[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      this.eventLoops[i] = new EventLoopsScheduler.PoolWorker(EventLoopsScheduler.THREAD_FACTORY);
      i += 1;
    }
  }
  
  public EventLoopsScheduler.PoolWorker getEventLoop()
  {
    int i = this.cores;
    if (i == 0) {
      return EventLoopsScheduler.SHUTDOWN_WORKER;
    }
    EventLoopsScheduler.PoolWorker[] arrayOfPoolWorker = this.eventLoops;
    long l = this.n;
    this.n = (1L + l);
    return arrayOfPoolWorker[((int)(l % i))];
  }
  
  public void shutdown()
  {
    EventLoopsScheduler.PoolWorker[] arrayOfPoolWorker = this.eventLoops;
    int j = arrayOfPoolWorker.length;
    int i = 0;
    while (i < j)
    {
      arrayOfPoolWorker[i].unsubscribe();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.schedulers.EventLoopsScheduler.FixedSchedulerPool
 * JD-Core Version:    0.7.0.1
 */