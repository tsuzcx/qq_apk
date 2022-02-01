package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;

final class OnSubscribeAmb$AmbSubscriber<T>
  extends Subscriber<T>
{
  private boolean chosen;
  private final OnSubscribeAmb.Selection<T> selection;
  private final Subscriber<? super T> subscriber;
  
  OnSubscribeAmb$AmbSubscriber(long paramLong, Subscriber<? super T> paramSubscriber, OnSubscribeAmb.Selection<T> paramSelection)
  {
    this.subscriber = paramSubscriber;
    this.selection = paramSelection;
    request(paramLong);
  }
  
  private boolean isSelected()
  {
    if (this.chosen) {
      return true;
    }
    if (this.selection.choice.get() == this)
    {
      this.chosen = true;
      return true;
    }
    if (this.selection.choice.compareAndSet(null, this))
    {
      this.selection.unsubscribeOthers(this);
      this.chosen = true;
      return true;
    }
    this.selection.unsubscribeLosers();
    return false;
  }
  
  private void requestMore(long paramLong)
  {
    request(paramLong);
  }
  
  public void onCompleted()
  {
    if (!isSelected()) {
      return;
    }
    this.subscriber.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (!isSelected()) {
      return;
    }
    this.subscriber.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    if (!isSelected()) {
      return;
    }
    this.subscriber.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeAmb.AmbSubscriber
 * JD-Core Version:    0.7.0.1
 */