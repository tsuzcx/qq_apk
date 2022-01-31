package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.functions.Action0;
import rx.subjects.Subject;

public final class UnicastSubject<T>
  extends Subject<T, T>
{
  final UnicastSubject.State<T> state;
  
  private UnicastSubject(UnicastSubject.State<T> paramState)
  {
    super(paramState);
    this.state = paramState;
  }
  
  public static <T> UnicastSubject<T> create()
  {
    return create(16);
  }
  
  public static <T> UnicastSubject<T> create(int paramInt)
  {
    return new UnicastSubject(new UnicastSubject.State(paramInt, null));
  }
  
  public static <T> UnicastSubject<T> create(int paramInt, Action0 paramAction0)
  {
    return new UnicastSubject(new UnicastSubject.State(paramInt, paramAction0));
  }
  
  public boolean hasObservers()
  {
    return this.state.subscriber.get() != null;
  }
  
  public void onCompleted()
  {
    this.state.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.state.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.state.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.UnicastSubject
 * JD-Core Version:    0.7.0.1
 */