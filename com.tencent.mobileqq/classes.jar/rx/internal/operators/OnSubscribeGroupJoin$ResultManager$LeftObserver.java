package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observers.SerializedObserver;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;

final class OnSubscribeGroupJoin$ResultManager$LeftObserver
  extends Subscriber<T1>
{
  OnSubscribeGroupJoin$ResultManager$LeftObserver(OnSubscribeGroupJoin.ResultManager paramResultManager) {}
  
  public void onCompleted()
  {
    for (;;)
    {
      synchronized (this.this$1.guard)
      {
        this.this$1.leftDone = true;
        if (this.this$1.rightDone)
        {
          ArrayList localArrayList = new ArrayList(this.this$1.leftMap.values());
          this.this$1.leftMap.clear();
          this.this$1.rightMap.clear();
          this.this$1.complete(localArrayList);
          return;
        }
      }
      Object localObject2 = null;
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.this$1.errorAll(paramThrowable);
  }
  
  public void onNext(T1 arg1)
  {
    try
    {
      Object localObject3 = PublishSubject.create();
      SerializedObserver localSerializedObserver = new SerializedObserver((Observer)localObject3);
      synchronized (this.this$1.guard)
      {
        Object localObject4 = this.this$1;
        int i = ((OnSubscribeGroupJoin.ResultManager)localObject4).leftIds;
        ((OnSubscribeGroupJoin.ResultManager)localObject4).leftIds = (i + 1);
        this.this$1.leftMap.put(Integer.valueOf(i), localSerializedObserver);
        ??? = Observable.create(new OnSubscribeGroupJoin.WindowObservableFunc((Observable)localObject3, this.this$1.cancel));
        localObject3 = (Observable)this.this$1.this$0.leftDuration.call(???);
        localObject4 = new OnSubscribeGroupJoin.ResultManager.LeftDurationObserver(this.this$1, i);
        this.this$1.group.add((Subscription)localObject4);
        ((Observable)localObject3).unsafeSubscribe((Subscriber)localObject4);
        ??? = this.this$1.this$0.resultSelector.call(???, ???);
        synchronized (this.this$1.guard)
        {
          localObject3 = new ArrayList(this.this$1.rightMap.values());
          this.this$1.subscriber.onNext(???);
          ??? = ((List)localObject3).iterator();
          if (???.hasNext()) {
            localSerializedObserver.onNext(???.next());
          }
        }
      }
      return;
    }
    catch (Throwable ???)
    {
      Exceptions.throwOrReport(???, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeGroupJoin.ResultManager.LeftObserver
 * JD-Core Version:    0.7.0.1
 */