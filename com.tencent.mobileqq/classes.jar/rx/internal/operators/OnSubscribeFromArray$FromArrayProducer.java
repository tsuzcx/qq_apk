package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;

final class OnSubscribeFromArray$FromArrayProducer<T>
  extends AtomicLong
  implements Producer
{
  private static final long serialVersionUID = 3534218984725836979L;
  final T[] array;
  final Subscriber<? super T> child;
  int index;
  
  public OnSubscribeFromArray$FromArrayProducer(Subscriber<? super T> paramSubscriber, T[] paramArrayOfT)
  {
    this.child = paramSubscriber;
    this.array = paramArrayOfT;
  }
  
  void fastPath()
  {
    Subscriber localSubscriber = this.child;
    Object[] arrayOfObject = this.array;
    int j = arrayOfObject.length;
    int i = 0;
    if (i < j)
    {
      localObject = arrayOfObject[i];
      if (!localSubscriber.isUnsubscribed()) {}
    }
    while (localSubscriber.isUnsubscribed())
    {
      Object localObject;
      return;
      localSubscriber.onNext(localObject);
      i += 1;
      break;
    }
    localSubscriber.onCompleted();
  }
  
  public void request(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("n >= 0 required but it was " + paramLong);
    }
    if (paramLong == 9223372036854775807L) {
      if (BackpressureUtils.getAndAddRequest(this, paramLong) == 0L) {
        fastPath();
      }
    }
    while ((paramLong == 0L) || (BackpressureUtils.getAndAddRequest(this, paramLong) != 0L)) {
      return;
    }
    slowPath(paramLong);
  }
  
  void slowPath(long paramLong)
  {
    Subscriber localSubscriber = this.child;
    Object[] arrayOfObject = this.array;
    int j = arrayOfObject.length;
    int i = this.index;
    long l1 = 0L;
    for (;;)
    {
      if ((paramLong != 0L) && (i != j)) {
        if (!localSubscriber.isUnsubscribed()) {}
      }
      do
      {
        do
        {
          return;
          localSubscriber.onNext(arrayOfObject[i]);
          i += 1;
          if (i != j) {
            break;
          }
        } while (localSubscriber.isUnsubscribed());
        localSubscriber.onCompleted();
        return;
        paramLong -= 1L;
        l1 -= 1L;
        break;
        long l2 = get() + l1;
        paramLong = l2;
        if (l2 != 0L) {
          break;
        }
        this.index = i;
        paramLong = addAndGet(l1);
      } while (paramLong == 0L);
      l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeFromArray.FromArrayProducer
 * JD-Core Version:    0.7.0.1
 */