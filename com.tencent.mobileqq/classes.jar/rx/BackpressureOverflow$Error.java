package rx;

import rx.exceptions.MissingBackpressureException;

class BackpressureOverflow$Error
  implements BackpressureOverflow.Strategy
{
  static final Error INSTANCE = new Error();
  
  public boolean mayAttemptDrop()
  {
    throw new MissingBackpressureException("Overflowed buffer");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.BackpressureOverflow.Error
 * JD-Core Version:    0.7.0.1
 */