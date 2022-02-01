package rx.internal.operators;

import java.util.Map;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

final class OnSubscribeGroupJoin$ResultManager$RightDurationObserver
  extends Subscriber<D2>
{
  final int id;
  boolean once = true;
  
  public OnSubscribeGroupJoin$ResultManager$RightDurationObserver(OnSubscribeGroupJoin.ResultManager paramResultManager, int paramInt)
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
        this.this$1.rightMap.remove(Integer.valueOf(this.id));
        this.this$1.group.remove(this);
        return;
      }
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.this$1.errorMain(paramThrowable);
  }
  
  public void onNext(D2 paramD2)
  {
    onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeGroupJoin.ResultManager.RightDurationObserver
 * JD-Core Version:    0.7.0.1
 */