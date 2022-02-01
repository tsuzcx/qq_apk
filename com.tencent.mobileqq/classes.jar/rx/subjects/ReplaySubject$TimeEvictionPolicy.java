package rx.subjects;

import rx.Scheduler;
import rx.schedulers.Timestamped;

final class ReplaySubject$TimeEvictionPolicy
  implements ReplaySubject.EvictionPolicy
{
  final long maxAgeMillis;
  final Scheduler scheduler;
  
  public ReplaySubject$TimeEvictionPolicy(long paramLong, Scheduler paramScheduler)
  {
    this.maxAgeMillis = paramLong;
    this.scheduler = paramScheduler;
  }
  
  public void evict(ReplaySubject.NodeList<Object> paramNodeList)
  {
    long l = this.scheduler.now();
    while ((!paramNodeList.isEmpty()) && (test(paramNodeList.head.next.value, l))) {
      paramNodeList.removeFirst();
    }
  }
  
  public void evictFinal(ReplaySubject.NodeList<Object> paramNodeList)
  {
    long l = this.scheduler.now();
    while ((paramNodeList.size > 1) && (test(paramNodeList.head.next.value, l))) {
      paramNodeList.removeFirst();
    }
  }
  
  public boolean test(Object paramObject, long paramLong)
  {
    return ((Timestamped)paramObject).getTimestampMillis() <= paramLong - this.maxAgeMillis;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.subjects.ReplaySubject.TimeEvictionPolicy
 * JD-Core Version:    0.7.0.1
 */