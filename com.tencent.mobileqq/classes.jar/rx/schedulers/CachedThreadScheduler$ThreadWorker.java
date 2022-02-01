package rx.schedulers;

import java.util.concurrent.ThreadFactory;
import rx.internal.schedulers.NewThreadWorker;

final class CachedThreadScheduler$ThreadWorker
  extends NewThreadWorker
{
  private long expirationTime = 0L;
  
  CachedThreadScheduler$ThreadWorker(ThreadFactory paramThreadFactory)
  {
    super(paramThreadFactory);
  }
  
  public long getExpirationTime()
  {
    return this.expirationTime;
  }
  
  public void setExpirationTime(long paramLong)
  {
    this.expirationTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.schedulers.CachedThreadScheduler.ThreadWorker
 * JD-Core Version:    0.7.0.1
 */