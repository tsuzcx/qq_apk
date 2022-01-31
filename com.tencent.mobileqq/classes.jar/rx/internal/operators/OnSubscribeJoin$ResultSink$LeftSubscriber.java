package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.subscriptions.CompositeSubscription;

final class OnSubscribeJoin$ResultSink$LeftSubscriber
  extends Subscriber<TLeft>
{
  OnSubscribeJoin$ResultSink$LeftSubscriber(OnSubscribeJoin.ResultSink paramResultSink) {}
  
  protected void expire(int paramInt, Subscription paramSubscription)
  {
    int j = 0;
    Object localObject = this.this$1.guard;
    int i = j;
    try
    {
      if (this.this$1.leftMap.remove(Integer.valueOf(paramInt)) != null)
      {
        i = j;
        if (this.this$1.leftMap.isEmpty())
        {
          i = j;
          if (this.this$1.leftDone) {
            i = 1;
          }
        }
      }
      if (i != 0)
      {
        this.this$1.subscriber.onCompleted();
        this.this$1.subscriber.unsubscribe();
        return;
      }
    }
    finally {}
    this.this$1.group.remove(paramSubscription);
  }
  
  public void onCompleted()
  {
    for (int i = 0;; i = 1)
    {
      synchronized (this.this$1.guard)
      {
        this.this$1.leftDone = true;
        if ((this.this$1.rightDone) || (this.this$1.leftMap.isEmpty())) {
          continue;
        }
        if (i != 0)
        {
          this.this$1.subscriber.onCompleted();
          this.this$1.subscriber.unsubscribe();
          return;
        }
      }
      this.this$1.group.remove(this);
      return;
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.this$1.subscriber.onError(paramThrowable);
    this.this$1.subscriber.unsubscribe();
  }
  
  public void onNext(TLeft paramTLeft)
  {
    Object localObject2;
    synchronized (this.this$1.guard)
    {
      localObject2 = this.this$1;
      int i = ((OnSubscribeJoin.ResultSink)localObject2).leftId;
      ((OnSubscribeJoin.ResultSink)localObject2).leftId = (i + 1);
      this.this$1.leftMap.put(Integer.valueOf(i), paramTLeft);
      int j = this.this$1.rightId;
      try
      {
        ??? = (Observable)this.this$1.this$0.leftDurationSelector.call(paramTLeft);
        localObject2 = new OnSubscribeJoin.ResultSink.LeftSubscriber.LeftDurationSubscriber(this, i);
        this.this$1.group.add((Subscription)localObject2);
        ((Observable)???).unsafeSubscribe((Subscriber)localObject2);
        localObject2 = new ArrayList();
        synchronized (this.this$1.guard)
        {
          Iterator localIterator = this.this$1.rightMap.entrySet().iterator();
          Map.Entry localEntry;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localEntry = (Map.Entry)localIterator.next();
          } while (((Integer)localEntry.getKey()).intValue() >= j);
          ((List)localObject2).add(localEntry.getValue());
        }
        return;
      }
      catch (Throwable paramTLeft)
      {
        Exceptions.throwOrReport(paramTLeft, this);
      }
    }
    ??? = ((List)localObject2).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = ((Iterator)???).next();
      localObject2 = this.this$1.this$0.resultSelector.call(paramTLeft, localObject2);
      this.this$1.subscriber.onNext(localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeJoin.ResultSink.LeftSubscriber
 * JD-Core Version:    0.7.0.1
 */