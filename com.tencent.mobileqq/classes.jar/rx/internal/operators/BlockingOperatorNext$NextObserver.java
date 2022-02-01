package rx.internal.operators;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Notification;
import rx.Subscriber;

class BlockingOperatorNext$NextObserver<T>
  extends Subscriber<Notification<? extends T>>
{
  private final BlockingQueue<Notification<? extends T>> buf = new ArrayBlockingQueue(1);
  final AtomicInteger waiting = new AtomicInteger();
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable) {}
  
  public void onNext(Notification<? extends T> paramNotification)
  {
    Notification<? extends T> localNotification = paramNotification;
    if (this.waiting.getAndSet(0) != 1)
    {
      if (paramNotification.isOnNext()) {}
    }
    else {
      for (localNotification = paramNotification; !this.buf.offer(localNotification); localNotification = paramNotification)
      {
        label23:
        paramNotification = (Notification)this.buf.poll();
        if ((paramNotification == null) || (paramNotification.isOnNext())) {
          break label23;
        }
      }
    }
  }
  
  void setWaiting(int paramInt)
  {
    this.waiting.set(paramInt);
  }
  
  public Notification<? extends T> takeNext()
  {
    setWaiting(1);
    return (Notification)this.buf.take();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.BlockingOperatorNext.NextObserver
 * JD-Core Version:    0.7.0.1
 */