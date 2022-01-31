package rx.internal.operators;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;

class OnSubscribeAmb$Selection<T>
{
  final Collection<OnSubscribeAmb.AmbSubscriber<T>> ambSubscribers = new ConcurrentLinkedQueue();
  final AtomicReference<OnSubscribeAmb.AmbSubscriber<T>> choice = new AtomicReference();
  
  public void unsubscribeLosers()
  {
    OnSubscribeAmb.AmbSubscriber localAmbSubscriber = (OnSubscribeAmb.AmbSubscriber)this.choice.get();
    if (localAmbSubscriber != null) {
      unsubscribeOthers(localAmbSubscriber);
    }
  }
  
  public void unsubscribeOthers(OnSubscribeAmb.AmbSubscriber<T> paramAmbSubscriber)
  {
    Iterator localIterator = this.ambSubscribers.iterator();
    while (localIterator.hasNext())
    {
      OnSubscribeAmb.AmbSubscriber localAmbSubscriber = (OnSubscribeAmb.AmbSubscriber)localIterator.next();
      if (localAmbSubscriber != paramAmbSubscriber) {
        localAmbSubscriber.unsubscribe();
      }
    }
    this.ambSubscribers.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeAmb.Selection
 * JD-Core Version:    0.7.0.1
 */