package rx.internal.operators;

import rx.Producer;
import rx.Subscriber;

class OperatorElementAt$1
  extends Subscriber<T>
{
  private int currentIndex = 0;
  
  OperatorElementAt$1(OperatorElementAt paramOperatorElementAt, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    if (this.currentIndex <= this.this$0.index)
    {
      if (this.this$0.hasDefault)
      {
        this.val$child.onNext(this.this$0.defaultValue);
        this.val$child.onCompleted();
        return;
      }
      Subscriber localSubscriber = this.val$child;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.this$0.index);
      localStringBuilder.append(" is out of bounds");
      localSubscriber.onError(new IndexOutOfBoundsException(localStringBuilder.toString()));
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    int i = this.currentIndex;
    this.currentIndex = (i + 1);
    if (i == this.this$0.index)
    {
      this.val$child.onNext(paramT);
      this.val$child.onCompleted();
      unsubscribe();
    }
  }
  
  public void setProducer(Producer paramProducer)
  {
    this.val$child.setProducer(new OperatorElementAt.InnerProducer(paramProducer));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorElementAt.1
 * JD-Core Version:    0.7.0.1
 */