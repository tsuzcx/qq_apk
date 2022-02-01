package rx;

import rx.functions.Action1;

class Single$24
  implements Observer<T>
{
  Single$24(Single paramSingle, Action1 paramAction1) {}
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable) {}
  
  public void onNext(T paramT)
  {
    this.val$onSuccess.call(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.Single.24
 * JD-Core Version:    0.7.0.1
 */