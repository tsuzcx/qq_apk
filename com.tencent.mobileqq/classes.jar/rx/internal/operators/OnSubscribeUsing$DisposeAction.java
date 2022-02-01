package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;

final class OnSubscribeUsing$DisposeAction<Resource>
  extends AtomicBoolean
  implements Subscription, Action0
{
  private static final long serialVersionUID = 4262875056400218316L;
  private Action1<? super Resource> dispose;
  private Resource resource;
  
  OnSubscribeUsing$DisposeAction(Action1<? super Resource> paramAction1, Resource paramResource)
  {
    this.dispose = paramAction1;
    this.resource = paramResource;
    lazySet(false);
  }
  
  public void call()
  {
    if (compareAndSet(false, true)) {
      try
      {
        this.dispose.call(this.resource);
        return;
      }
      finally
      {
        this.resource = null;
        this.dispose = null;
      }
    }
  }
  
  public boolean isUnsubscribed()
  {
    return get();
  }
  
  public void unsubscribe()
  {
    call();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeUsing.DisposeAction
 * JD-Core Version:    0.7.0.1
 */