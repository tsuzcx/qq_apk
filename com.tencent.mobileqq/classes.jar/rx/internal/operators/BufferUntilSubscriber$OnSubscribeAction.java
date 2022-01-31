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
    int i = 1;
    if (this.state.casObserverRef(null, ???)) {
      ???.add(Subscriptions.create(new BufferUntilSubscriber.OnSubscribeAction.1(this)));
    }
    for (;;)
    {
      synchronized (this.state.guard)
      {
        if (this.state.emitting) {
          break label164;
        }
        this.state.emitting = true;
        if (i == 0) {
          break;
        }
        ??? = NotificationLite.instance();
        Object localObject1 = this.state.buffer.poll();
        if (localObject1 != null) {
          ???.accept((Observer)this.state.get(), localObject1);
        }
      }
      synchronized (this.state.guard)
      {
        if (this.state.buffer.isEmpty())
        {
          this.state.emitting = false;
          return;
        }
      }
      ???.onError(new IllegalStateException("Only one subscriber allowed!"));
      return;
      label164:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.BufferUntilSubscriber.OnSubscribeAction
 * JD-Core Version:    0.7.0.1
 */