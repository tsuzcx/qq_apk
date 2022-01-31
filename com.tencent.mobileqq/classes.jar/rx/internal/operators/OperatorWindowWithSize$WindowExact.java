package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.subjects.Subject;
import rx.subscriptions.Subscriptions;

final class OperatorWindowWithSize$WindowExact<T>
  extends Subscriber<T>
  implements Action0
{
  final Subscriber<? super Observable<T>> actual;
  final Subscription cancel;
  int index;
  final int size;
  Subject<T, T> window;
  final AtomicInteger wip;
  
  public OperatorWindowWithSize$WindowExact(Subscriber<? super Observable<T>> paramSubscriber, int paramInt)
  {
    this.actual = paramSubscriber;
    this.size = paramInt;
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
    return new OperatorWindowWithSize.WindowExact.1(this);
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
    ((Subject)localObject).onNext(paramT);
    if (i == this.size)
    {
      this.index = 0;
      this.window = null;
      ((Subject)localObject).onCompleted();
      return;
    }
    this.index = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithSize.WindowExact
 * JD-Core Version:    0.7.0.1
 */