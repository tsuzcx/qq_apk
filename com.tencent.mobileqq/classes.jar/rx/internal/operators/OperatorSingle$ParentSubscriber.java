package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.Subscriber;

final class OperatorSingle$ParentSubscriber<T>
  extends Subscriber<T>
{
  private final Subscriber<? super T> child;
  private final T defaultValue;
  private final boolean hasDefaultValue;
  private boolean hasTooManyElements = false;
  private boolean isNonEmpty = false;
  private T value;
  
  OperatorSingle$ParentSubscriber(Subscriber<? super T> paramSubscriber, boolean paramBoolean, T paramT)
  {
    this.child = paramSubscriber;
    this.hasDefaultValue = paramBoolean;
    this.defaultValue = paramT;
  }
  
  public void onCompleted()
  {
    if (this.hasTooManyElements) {
      return;
    }
    if (this.isNonEmpty)
    {
      this.child.onNext(this.value);
      this.child.onCompleted();
      return;
    }
    if (this.hasDefaultValue)
    {
      this.child.onNext(this.defaultValue);
      this.child.onCompleted();
      return;
    }
    this.child.onError(new NoSuchElementException("Sequence contains no elements"));
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    if (this.isNonEmpty)
    {
      this.hasTooManyElements = true;
      this.child.onError(new IllegalArgumentException("Sequence contains too many elements"));
      unsubscribe();
      return;
    }
    this.value = paramT;
    this.isNonEmpty = true;
  }
  
  void requestMore(long paramLong)
  {
    request(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorSingle.ParentSubscriber
 * JD-Core Version:    0.7.0.1
 */