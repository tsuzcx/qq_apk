package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Subscriber;
import rx.subscriptions.Subscriptions;

final class BufferUntilSubscriber$OnSubscribeAction<T>
  implements Observable.OnSubscribe<T>
{
  final BufferUntilSubscriber.State<T> state;
  
  public BufferUntilSubscriber$OnSubscribeAction(BufferUntilSubscriber.State<T> paramState)
  {
    this.state = paramState;
  }
  
  public void call(Subscriber<? super T> arg1)
  {
    if (this.state.casObserverRef(null, ???)) {
      ???.add(Subscriptions.create(new BufferUntilSubscriber.OnSubscribeAction.1(this)));
    }
    for (;;)
    {
      synchronized (this.state.guard)
      {
        boolean bool = this.state.emitting;
        i = 1;
        if (bool) {
          break label179;
        }
        this.state.emitting = true;
        if (i == 0) {
          break label178;
        }
        ??? = NotificationLite.instance();
        ??? = this.state.buffer.poll();
        if (??? != null)
        {
          ???.accept((Observer)this.state.get(), ???);
          continue;
        }
        synchronized (this.state.guard)
        {
          if (this.state.buffer.isEmpty())
          {
            this.state.emitting = false;
            return;
          }
        }
      }
      ???.onError(new IllegalStateException("Only one subscriber allowed!"));
      label178:
      return;
      label179:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.BufferUntilSubscriber.OnSubscribeAction
 * JD-Core Version:    0.7.0.1
 */