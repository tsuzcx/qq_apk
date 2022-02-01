package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.Subscriber;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;

class OperatorMaterialize$ParentSubscriber<T>
  extends Subscriber<T>
{
  private boolean busy = false;
  private final Subscriber<? super Notification<T>> child;
  private boolean missed = false;
  private final AtomicLong requested = new AtomicLong();
  private volatile Notification<T> terminalNotification;
  
  OperatorMaterialize$ParentSubscriber(Subscriber<? super Notification<T>> paramSubscriber)
  {
    this.child = paramSubscriber;
  }
  
  private void decrementRequested()
  {
    AtomicLong localAtomicLong = this.requested;
    long l;
    do
    {
      l = localAtomicLong.get();
      if (l == 9223372036854775807L) {
        return;
      }
    } while (!localAtomicLong.compareAndSet(l, l - 1L));
  }
  
  private void drain()
  {
    for (;;)
    {
      try
      {
        if (this.busy)
        {
          this.missed = true;
          return;
        }
        AtomicLong localAtomicLong = this.requested;
        if (this.child.isUnsubscribed()) {
          break;
        }
        Notification localNotification = this.terminalNotification;
        if ((localNotification != null) && (localAtomicLong.get() > 0L))
        {
          this.terminalNotification = null;
          this.child.onNext(localNotification);
          if (this.child.isUnsubscribed()) {
            break;
          }
          this.child.onCompleted();
          return;
        }
      }
      finally {}
      try
      {
        if (!this.missed)
        {
          this.busy = false;
          return;
        }
      }
      finally {}
    }
  }
  
  public void onCompleted()
  {
    this.terminalNotification = Notification.createOnCompleted();
    drain();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.terminalNotification = Notification.createOnError(paramThrowable);
    RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
    drain();
  }
  
  public void onNext(T paramT)
  {
    this.child.onNext(Notification.createOnNext(paramT));
    decrementRequested();
  }
  
  public void onStart()
  {
    request(0L);
  }
  
  void requestMore(long paramLong)
  {
    BackpressureUtils.getAndAddRequest(this.requested, paramLong);
    request(paramLong);
    drain();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorMaterialize.ParentSubscriber
 * JD-Core Version:    0.7.0.1
 */