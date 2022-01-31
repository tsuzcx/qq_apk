package rx.subjects;

import rx.Scheduler;
import rx.functions.Func1;
import rx.schedulers.Timestamped;

final class ReplaySubject$AddTimestamped
  implements Func1<Object, Object>
{
  final Scheduler scheduler;
  
  public ReplaySubject$AddTimestamped(Scheduler paramScheduler)
  {
    this.scheduler = paramScheduler;
  }
  
  public Object call(Object paramObject)
  {
    return new Timestamped(this.scheduler.now(), paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.subjects.ReplaySubject.AddTimestamped
 * JD-Core Version:    0.7.0.1
 */