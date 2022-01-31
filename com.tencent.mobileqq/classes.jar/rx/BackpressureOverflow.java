package rx;

import rx.annotations.Experimental;

@Experimental
public final class BackpressureOverflow
{
  public static final BackpressureOverflow.Strategy ON_OVERFLOW_DEFAULT = BackpressureOverflow.Error.INSTANCE;
  public static final BackpressureOverflow.Strategy ON_OVERFLOW_DROP_LATEST = BackpressureOverflow.DropLatest.INSTANCE;
  public static final BackpressureOverflow.Strategy ON_OVERFLOW_DROP_OLDEST;
  public static final BackpressureOverflow.Strategy ON_OVERFLOW_ERROR = BackpressureOverflow.Error.INSTANCE;
  
  static
  {
    ON_OVERFLOW_DROP_OLDEST = BackpressureOverflow.DropOldest.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.BackpressureOverflow
 * JD-Core Version:    0.7.0.1
 */