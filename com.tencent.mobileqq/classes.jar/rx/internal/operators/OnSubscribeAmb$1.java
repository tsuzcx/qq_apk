package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.functions.Action0;

class OnSubscribeAmb$1
  implements Action0
{
  OnSubscribeAmb$1(OnSubscribeAmb paramOnSubscribeAmb, AtomicReference paramAtomicReference, OnSubscribeAmb.Selection paramSelection) {}
  
  public void call()
  {
    OnSubscribeAmb.AmbSubscriber localAmbSubscriber = (OnSubscribeAmb.AmbSubscriber)this.val$choice.get();
    if (localAmbSubscriber != null) {
      localAmbSubscriber.unsubscribe();
    }
    OnSubscribeAmb.unsubscribeAmbSubscribers(this.val$selection.ambSubscribers);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeAmb.1
 * JD-Core Version:    0.7.0.1
 */