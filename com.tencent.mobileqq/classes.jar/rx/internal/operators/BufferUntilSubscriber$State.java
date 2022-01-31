package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observer;

final class BufferUntilSubscriber$State<T>
  extends AtomicReference<Observer<? super T>>
{
  final ConcurrentLinkedQueue<Object> buffer = new ConcurrentLinkedQueue();
  boolean emitting = false;
  final Object guard = new Object();
  final NotificationLite<T> nl = NotificationLite.instance();
  
  boolean casObserverRef(Observer<? super T> paramObserver1, Observer<? super T> paramObserver2)
  {
    return compareAndSet(paramObserver1, paramObserver2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.BufferUntilSubscriber.State
 * JD-Core Version:    0.7.0.1
 */