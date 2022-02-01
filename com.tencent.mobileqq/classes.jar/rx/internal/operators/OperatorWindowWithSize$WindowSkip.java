package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.subjects.Subject;
import rx.subscriptions.Subscriptions;

final class OperatorWindowWithSize$WindowSkip<T>
  extends Subscriber<T>
  implements Action0
{
  final Subscriber<? super Observable<T>> actual;
  final Subscription cancel;
  int index;
  final int size;
  final int skip;
  Subject<T, T> window;
  final AtomicInteger wip;
  
  public OperatorWindowWithSize$WindowSkip(Subscriber<? super Observable<T>> paramSubscriber, int paramInt1, int paramInt2)
  {
    this.actual = paramSubscriber;
    this.size = paramInt1;
    this.skip = paramInt2;
    this.wip = new AtomicInteger(1);
    this.cancel = Subscriptions.create(this);
    add(this.cancel);
    request(0L);
  }
  
  public void call()
  {
    if (this.wip.decrementAndGet() == 0) {
      unsubscribe();
    }
  }
  
  Producer createProducer()
  {
    return new OperatorWindowWithSize.WindowSkip.WindowSkipProducer(this);
  }
  
  public void onCompleted()
  {
    Subject localSubject = this.window;
    if (localSubject != null)
    {
      this.window = null;
      localSubject.onCompleted();
    }
    this.actual.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    Subject localSubject = this.window;
    if (localSubject != null)
    {
      this.window = null;
      localSubject.onError(paramThrowable);
    }
    this.actual.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    int i = this.index;
    Object localObject = this.window;
    if (i == 0)
    {
      this.wip.getAndIncrement();
      localObject = UnicastSubject.create(this.size, this);
      this.window = ((Subject)localObject);
      this.actual.onNext(localObject);
    }
    i += 1;
    if (localObject != null) {
      ((Subject)localObject).onNext(paramT);
    }
    if (i == this.size)
    {
      this.index = i;
      this.window = null;
      ((Subject)localObject).onCompleted();
      return;
    }
    if (i == this.skip)
    {
      this.index = 0;
      return;
    }
    this.index = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithSize.WindowSkip
 * JD-Core Version:    0.7.0.1
 */