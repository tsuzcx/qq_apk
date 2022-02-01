package rx;

import rx.functions.Func2;

final class Observable$CountLongHolder$1
  implements Func2<Long, Object, Long>
{
  public final Long call(Long paramLong, Object paramObject)
  {
    return Long.valueOf(paramLong.longValue() + 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.Observable.CountLongHolder.1
 * JD-Core Version:    0.7.0.1
 */