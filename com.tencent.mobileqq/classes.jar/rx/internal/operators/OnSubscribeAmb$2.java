package rx.internal.operators;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import rx.Producer;

class OnSubscribeAmb$2
  implements Producer
{
  OnSubscribeAmb$2(OnSubscribeAmb paramOnSubscribeAmb, AtomicReference paramAtomicReference, OnSubscribeAmb.Selection paramSelection) {}
  
  public void request(long paramLong)
  {
    Object localObject = (OnSubscribeAmb.AmbSubscriber)this.val$choice.get();
    if (localObject != null) {
      OnSubscribeAmb.AmbSubscriber.access$100((OnSubscribeAmb.AmbSubscriber)localObject, paramLong);
    }
    for (;;)
    {
      return;
      localObject = this.val$selection.ambSubscribers.iterator();
      while (((Iterator)localObject).hasNext())
      {
        OnSubscribeAmb.AmbSubscriber localAmbSubscriber = (OnSubscribeAmb.AmbSubscriber)((Iterator)localObject).next();
        if (!localAmbSubscriber.isUnsubscribed())
        {
          if (this.val$choice.get() == localAmbSubscriber)
          {
            OnSubscribeAmb.AmbSubscriber.access$100(localAmbSubscriber, paramLong);
            return;
          }
          OnSubscribeAmb.AmbSubscriber.access$100(localAmbSubscriber, paramLong);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeAmb.2
 * JD-Core Version:    0.7.0.1
 */