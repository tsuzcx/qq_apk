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
import rx.subscriptions.CompositeSubscription;

final class OnSubscribeGroupJoin$ResultManager$RightObserver
  extends Subscriber<T2>
{
  OnSubscribeGroupJoin$ResultManager$RightObserver(OnSubscribeGroupJoin.ResultManager paramResultManager) {}
  
  public void onCompleted()
  {
    for (;;)
    {
      synchronized (this.this$1.guard)
      {
        this.this$1.rightDone = true;
        if (this.this$1.leftDone)
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
  
  public void onNext(T2 paramT2)
  {
    try
    {
      synchronized (this.this$1.guard)
      {
        Object localObject2 = this.this$1;
        int i = ((OnSubscribeGroupJoin.ResultManager)localObject2).rightIds;
        ((OnSubscribeGroupJoin.ResultManager)localObject2).rightIds = (i + 1);
        this.this$1.rightMap.put(Integer.valueOf(i), paramT2);
        ??? = (Observable)this.this$1.this$0.rightDuration.call(paramT2);
        localObject2 = new OnSubscribeGroupJoin.ResultManager.RightDurationObserver(this.this$1, i);
        this.this$1.group.add((Subscription)localObject2);
        ((Observable)???).unsafeSubscribe((Subscriber)localObject2);
        synchronized (this.this$1.guard)
        {
          localObject2 = new ArrayList(this.this$1.leftMap.values());
          ??? = ((List)localObject2).iterator();
          if (((Iterator)???).hasNext()) {
            ((Observer)((Iterator)???).next()).onNext(paramT2);
          }
        }
      }
      return;
    }
    catch (Throwable paramT2)
    {
      Exceptions.throwOrReport(paramT2, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeGroupJoin.ResultManager.RightObserver
 * JD-Core Version:    0.7.0.1
 */