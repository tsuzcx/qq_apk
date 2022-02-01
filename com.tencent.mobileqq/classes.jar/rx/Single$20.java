package rx;

import rx.observers.SerializedSubscriber;

class Single$20
  implements Observable.Operator<T, T>
{
  Single$20(Single paramSingle, Completable paramCompletable) {}
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    SerializedSubscriber localSerializedSubscriber = new SerializedSubscriber(paramSubscriber, false);
    Single.20.1 local1 = new Single.20.1(this, localSerializedSubscriber, false, localSerializedSubscriber);
    Single.20.2 local2 = new Single.20.2(this, local1, localSerializedSubscriber);
    localSerializedSubscriber.add(local1);
    paramSubscriber.add(localSerializedSubscriber);
    this.val$other.subscribe(local2);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.Single.20
 * JD-Core Version:    0.7.0.1
 */