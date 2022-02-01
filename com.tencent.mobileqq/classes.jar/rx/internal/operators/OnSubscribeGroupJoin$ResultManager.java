package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.RefCountSubscription;

final class OnSubscribeGroupJoin$ResultManager
  implements Subscription
{
  final RefCountSubscription cancel;
  final CompositeSubscription group;
  final Object guard = new Object();
  boolean leftDone;
  int leftIds;
  final Map<Integer, Observer<T2>> leftMap = new HashMap();
  boolean rightDone;
  int rightIds;
  final Map<Integer, T2> rightMap = new HashMap();
  final Subscriber<? super R> subscriber;
  
  public OnSubscribeGroupJoin$ResultManager(Subscriber<? super R> paramSubscriber)
  {
    Object localObject;
    this.subscriber = localObject;
    this.group = new CompositeSubscription();
    this.cancel = new RefCountSubscription(this.group);
  }
  
  void complete(List<Observer<T2>> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((Observer)paramList.next()).onCompleted();
      }
      this.subscriber.onCompleted();
      this.cancel.unsubscribe();
    }
  }
  
  void errorAll(Throwable paramThrowable)
  {
    synchronized (this.guard)
    {
      ArrayList localArrayList = new ArrayList(this.leftMap.values());
      this.leftMap.clear();
      this.rightMap.clear();
      ??? = localArrayList.iterator();
      if (((Iterator)???).hasNext()) {
        ((Observer)((Iterator)???).next()).onError(paramThrowable);
      }
    }
    this.subscriber.onError(paramThrowable);
    this.cancel.unsubscribe();
  }
  
  void errorMain(Throwable paramThrowable)
  {
    synchronized (this.guard)
    {
      this.leftMap.clear();
      this.rightMap.clear();
      this.subscriber.onError(paramThrowable);
      this.cancel.unsubscribe();
      return;
    }
  }
  
  public void init()
  {
    OnSubscribeGroupJoin.ResultManager.LeftObserver localLeftObserver = new OnSubscribeGroupJoin.ResultManager.LeftObserver(this);
    OnSubscribeGroupJoin.ResultManager.RightObserver localRightObserver = new OnSubscribeGroupJoin.ResultManager.RightObserver(this);
    this.group.add(localLeftObserver);
    this.group.add(localRightObserver);
    this.this$0.left.unsafeSubscribe(localLeftObserver);
    this.this$0.right.unsafeSubscribe(localRightObserver);
  }
  
  public boolean isUnsubscribed()
  {
    return this.cancel.isUnsubscribed();
  }
  
  public void unsubscribe()
  {
    this.cancel.unsubscribe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeGroupJoin.ResultManager
 * JD-Core Version:    0.7.0.1
 */