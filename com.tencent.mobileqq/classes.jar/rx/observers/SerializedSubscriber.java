package rx.observers;

import rx.Observer;
import rx.Subscriber;

public class SerializedSubscriber<T>
  extends Subscriber<T>
{
  private final Observer<T> s;
  
  public SerializedSubscriber(Subscriber<? super T> paramSubscriber)
  {
    this(paramSubscriber, true);
  }
  
  public SerializedSubscriber(Subscriber<? super T> paramSubscriber, boolean paramBoolean)
  {
    super(paramSubscriber, paramBoolean);
    this.s = new SerializedObserver(paramSubscriber);
  }
  
  public void onCompleted()
  {
    this.s.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.s.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.s.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.observers.SerializedSubscriber
 * JD-Core Version:    0.7.0.1
 */