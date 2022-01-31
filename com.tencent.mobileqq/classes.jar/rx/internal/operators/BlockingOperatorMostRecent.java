package rx.internal.operators;

import rx.Observable;

public final class BlockingOperatorMostRecent
{
  private BlockingOperatorMostRecent()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> Iterable<T> mostRecent(Observable<? extends T> paramObservable, T paramT)
  {
    return new BlockingOperatorMostRecent.1(paramT, paramObservable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.BlockingOperatorMostRecent
 * JD-Core Version:    0.7.0.1
 */