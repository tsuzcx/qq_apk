package rx.internal.operators;

import rx.Observable;

public final class BlockingOperatorNext
{
  private BlockingOperatorNext()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> Iterable<T> next(Observable<? extends T> paramObservable)
  {
    return new BlockingOperatorNext.1(paramObservable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.BlockingOperatorNext
 * JD-Core Version:    0.7.0.1
 */