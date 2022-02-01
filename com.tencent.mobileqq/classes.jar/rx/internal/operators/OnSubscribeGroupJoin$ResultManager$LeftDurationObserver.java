package rx.internal.operators;

import java.util.Map;
import rx.Observer;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

final class OnSubscribeGroupJoin$ResultManager$LeftDurationObserver
  extends Subscriber<D1>
{
  final int id;
  boolean once = true;
  
  public OnSubscribeGroupJoin$ResultManager$LeftDurationObserver(OnSubscribeGroupJoin.ResultManager paramResultManager, int paramInt)
  {
    this.id = paramInt;
  }
  
  public void onCompleted()
  {
    if (this.once)
    {
      this.once = false;
      synchronized (this.this$1.guard)
      {
        Observer localObserver = (Observer)this.this$1.leftMap.remove(Integer.valueOf(this.id));
        if (localObserver != null) {
          localObserver.onCompleted();
        }
        this.this$1.group.remove(this);
        return;
      }
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.this$1.errorMain(paramThrowable);
  }
  
  public void onNext(D1 paramD1)
  {
    onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeGroupJoin.ResultManager.LeftDurationObserver
 * JD-Core Version:    0.7.0.1
 */