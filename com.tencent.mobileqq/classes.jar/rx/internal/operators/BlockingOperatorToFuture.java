package rx.internal.operators;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;

public final class BlockingOperatorToFuture
{
  private BlockingOperatorToFuture()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> Future<T> toFuture(Observable<? extends T> paramObservable)
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    AtomicReference localAtomicReference1 = new AtomicReference();
    AtomicReference localAtomicReference2 = new AtomicReference();
    return new BlockingOperatorToFuture.2(localCountDownLatch, paramObservable.single().subscribe(new BlockingOperatorToFuture.1(localCountDownLatch, localAtomicReference2, localAtomicReference1)), localAtomicReference2, localAtomicReference1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.BlockingOperatorToFuture
 * JD-Core Version:    0.7.0.1
 */