package rx;

import rx.observers.SerializedSubscriber;

class Single$21
  implements Observable.Operator<T, T>
{
  Single$21(Single paramSingle, Observable paramObservable) {}
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    SerializedSubscriber localSerializedSubscriber = new SerializedSubscriber(paramSubscriber, false);
    Single.21.1 local1 = new Single.21.1(this, localSerializedSubscriber, false, localSerializedSubscriber);
    Single.21.2 local2 = new Single.21.2(this, local1);
    localSerializedSubscriber.add(local1);
    localSerializedSubscriber.add(local2);
    paramSubscriber.add(localSerializedSubscriber);
    this.val$other.unsafeSubscribe(local2);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.Single.21
 * JD-Core Version:    0.7.0.1
 */