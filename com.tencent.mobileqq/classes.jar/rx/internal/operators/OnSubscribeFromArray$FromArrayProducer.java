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
    while (i < j)
    {
      Object localObject = arrayOfObject[i];
      if (localSubscriber.isUnsubscribed()) {
        return;
      }
      localSubscriber.onNext(localObject);
      i += 1;
    }
    if (localSubscriber.isUnsubscribed()) {
      return;
    }
    localSubscriber.onCompleted();
  }
  
  public void request(long paramLong)
  {
    if (paramLong >= 0L)
    {
      if (paramLong == 9223372036854775807L)
      {
        if (BackpressureUtils.getAndAddRequest(this, paramLong) == 0L) {
          fastPath();
        }
      }
      else if ((paramLong != 0L) && (BackpressureUtils.getAndAddRequest(this, paramLong) == 0L)) {
        slowPath(paramLong);
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("n >= 0 required but it was ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  void slowPath(long paramLong)
  {
    Subscriber localSubscriber = this.child;
    Object[] arrayOfObject = this.array;
    int j = arrayOfObject.length;
    int i = this.index;
    long l1;
    do
    {
      l1 = 0L;
      long l2;
      do
      {
        while ((paramLong != 0L) && (i != j))
        {
          if (localSubscriber.isUnsubscribed()) {
            return;
          }
          localSubscriber.onNext(arrayOfObject[i]);
          i += 1;
          if (i == j)
          {
            if (!localSubscriber.isUnsubscribed()) {
              localSubscriber.onCompleted();
            }
            return;
          }
          paramLong -= 1L;
          l1 -= 1L;
        }
        l2 = get() + l1;
        paramLong = l2;
      } while (l2 != 0L);
      this.index = i;
      l1 = addAndGet(l1);
      paramLong = l1;
    } while (l1 != 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeFromArray.FromArrayProducer
 * JD-Core Version:    0.7.0.1
 */