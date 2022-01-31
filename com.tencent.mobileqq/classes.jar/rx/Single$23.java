package rx;

import rx.functions.Action1;

class Single$23
  implements Observer<T>
{
  Single$23(Single paramSingle, Action1 paramAction1) {}
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable)
  {
    this.val$onError.call(paramThrowable);
  }
  
  public void onNext(T paramT) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.Single.23
 * JD-Core Version:    0.7.0.1
 */