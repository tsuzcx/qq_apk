package rx.subjects;

import rx.functions.Func1;
import rx.schedulers.Timestamped;

final class ReplaySubject$RemoveTimestamped
  implements Func1<Object, Object>
{
  public Object call(Object paramObject)
  {
    return ((Timestamped)paramObject).getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.subjects.ReplaySubject.RemoveTimestamped
 * JD-Core Version:    0.7.0.1
 */