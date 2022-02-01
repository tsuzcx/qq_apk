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
import rx.subscriptions.SerialSubscription;

final class OnSubscribeJoin$ResultSink$RightSubscriber
  extends Subscriber<TRight>
{
  OnSubscribeJoin$ResultSink$RightSubscriber(OnSubscribeJoin.ResultSink paramResultSink) {}
  
  void expire(int paramInt, Subscription paramSubscription)
  {
    for (;;)
    {
      synchronized (this.this$1.guard)
      {
        if ((this.this$1.rightMap.remove(Integer.valueOf(paramInt)) != null) && (this.this$1.rightMap.isEmpty()) && (this.this$1.rightDone))
        {
          paramInt = 1;
          if (paramInt != 0)
          {
            this.this$1.subscriber.onCompleted();
            this.this$1.subscriber.unsubscribe();
            return;
          }
          this.this$1.group.remove(paramSubscription);
          return;
        }
      }
      paramInt = 0;
    }
  }
  
  public void onCompleted()
  {
    for (;;)
    {
      synchronized (this.this$1.guard)
      {
        OnSubscribeJoin.ResultSink localResultSink = this.this$1;
        int j = 1;
        localResultSink.rightDone = true;
        i = j;
        if (!this.this$1.leftDone)
        {
          if (!this.this$1.rightMap.isEmpty()) {
            break label102;
          }
          i = j;
        }
        if (i != 0)
        {
          this.this$1.subscriber.onCompleted();
          this.this$1.subscriber.unsubscribe();
          return;
        }
        this.this$1.group.remove(this);
        return;
      }
      label102:
      int i = 0;
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.this$1.subscriber.onError(paramThrowable);
    this.this$1.subscriber.unsubscribe();
  }
  
  public void onNext(TRight paramTRight)
  {
    synchronized (this.this$1.guard)
    {
      Object localObject2 = this.this$1;
      int i = ((OnSubscribeJoin.ResultSink)localObject2).rightId;
      ((OnSubscribeJoin.ResultSink)localObject2).rightId = (i + 1);
      this.this$1.rightMap.put(Integer.valueOf(i), paramTRight);
      int j = this.this$1.leftId;
      ??? = new SerialSubscription();
      this.this$1.group.add((Subscription)???);
      try
      {
        ??? = (Observable)this.this$1.this$0.rightDurationSelector.call(paramTRight);
        localObject2 = new OnSubscribeJoin.ResultSink.RightSubscriber.RightDurationSubscriber(this, i);
        this.this$1.group.add((Subscription)localObject2);
        ((Observable)???).unsafeSubscribe((Subscriber)localObject2);
        localObject2 = new ArrayList();
        synchronized (this.this$1.guard)
        {
          Iterator localIterator = this.this$1.leftMap.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            if (((Integer)localEntry.getKey()).intValue() < j) {
              ((List)localObject2).add(localEntry.getValue());
            }
          }
          ??? = ((List)localObject2).iterator();
          if (((Iterator)???).hasNext())
          {
            localObject2 = ((Iterator)???).next();
            localObject2 = this.this$1.this$0.resultSelector.call(localObject2, paramTRight);
            this.this$1.subscriber.onNext(localObject2);
          }
        }
        return;
      }
      catch (Throwable paramTRight)
      {
        Exceptions.throwOrReport(paramTRight, this);
      }
    }
    for (;;)
    {
      throw paramTRight;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeJoin.ResultSink.RightSubscriber
 * JD-Core Version:    0.7.0.1
 */