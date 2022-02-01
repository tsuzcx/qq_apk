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
    for (;;)
    {
      synchronized (this.this$1.guard)
      {
        if ((this.this$1.leftMap.remove(Integer.valueOf(paramInt)) != null) && (this.this$1.leftMap.isEmpty()) && (this.this$1.leftDone))
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
        localResultSink.leftDone = true;
        i = j;
        if (!this.this$1.rightDone)
        {
          if (!this.this$1.leftMap.isEmpty()) {
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
  
  public void onNext(TLeft paramTLeft)
  {
    synchronized (this.this$1.guard)
    {
      Object localObject2 = this.this$1;
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
            localObject2 = this.this$1.this$0.resultSelector.call(paramTLeft, localObject2);
            this.this$1.subscriber.onNext(localObject2);
          }
        }
        return;
      }
      catch (Throwable paramTLeft)
      {
        Exceptions.throwOrReport(paramTLeft, this);
      }
    }
    for (;;)
    {
      throw paramTLeft;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeJoin.ResultSink.LeftSubscriber
 * JD-Core Version:    0.7.0.1
 */