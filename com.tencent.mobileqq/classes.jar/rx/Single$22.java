package rx;

import rx.observers.SerializedSubscriber;

class Single$22
  implements Observable.Operator<T, T>
{
  Single$22(Single paramSingle1, Single paramSingle2) {}
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    SerializedSubscriber localSerializedSubscriber = new SerializedSubscriber(paramSubscriber, false);
    Single.22.1 local1 = new Single.22.1(this, localSerializedSubscriber, false, localSerializedSubscriber);
    Single.22.2 local2 = new Single.22.2(this, local1);
    localSerializedSubscriber.add(local1);
    localSerializedSubscriber.add(local2);
    paramSubscriber.add(localSerializedSubscriber);
    this.val$other.subscribe(local2);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Single.22
 * JD-Core Version:    0.7.0.1
 */