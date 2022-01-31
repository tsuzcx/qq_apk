package rx.singles;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import rx.Single;
import rx.annotations.Experimental;
import rx.internal.operators.BlockingOperatorToFuture;
import rx.internal.util.BlockingUtils;

@Experimental
public class BlockingSingle<T>
{
  private final Single<? extends T> single;
  
  private BlockingSingle(Single<? extends T> paramSingle)
  {
    this.single = paramSingle;
  }
  
  @Experimental
  public static <T> BlockingSingle<T> from(Single<? extends T> paramSingle)
  {
    return new BlockingSingle(paramSingle);
  }
  
  @Experimental
  public Future<T> toFuture()
  {
    return BlockingOperatorToFuture.toFuture(this.single.toObservable());
  }
  
  @Experimental
  public T value()
  {
    AtomicReference localAtomicReference = new AtomicReference();
    Object localObject = new AtomicReference();
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    BlockingUtils.awaitForComplete(localCountDownLatch, this.single.subscribe(new BlockingSingle.1(this, localAtomicReference, localCountDownLatch, (AtomicReference)localObject)));
    localObject = (Throwable)((AtomicReference)localObject).get();
    if (localObject != null)
    {
      if ((localObject instanceof RuntimeException)) {
        throw ((RuntimeException)localObject);
      }
      throw new RuntimeException((Throwable)localObject);
    }
    return localAtomicReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.singles.BlockingSingle
 * JD-Core Version:    0.7.0.1
 */