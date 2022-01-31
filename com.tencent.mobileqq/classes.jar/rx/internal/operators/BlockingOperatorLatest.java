package rx.internal.operators;

import rx.Observable;

public final class BlockingOperatorLatest
{
  private BlockingOperatorLatest()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> Iterable<T> latest(Observable<? extends T> paramObservable)
  {
    return new BlockingOperatorLatest.1(paramObservable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.BlockingOperatorLatest
 * JD-Core Version:    0.7.0.1
 */