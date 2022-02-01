package rx.internal.operators;

import rx.Producer;
import rx.Subscriber;

class OperatorTake$1
  extends Subscriber<T>
{
  boolean completed;
  int count;
  
  OperatorTake$1(OperatorTake paramOperatorTake, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    if (!this.completed)
    {
      this.completed = true;
      this.val$child.onCompleted();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (!this.completed)
    {
      this.completed = true;
      try
      {
        this.val$child.onError(paramThrowable);
        return;
      }
      finally
      {
        unsubscribe();
      }
    }
  }
  
  public void onNext(T paramT)
  {
    if (!isUnsubscribed())
    {
      int i = this.count;
      this.count = (i + 1);
      if (i < this.this$0.limit)
      {
        if (this.count == this.this$0.limit) {
          i = 1;
        } else {
          i = 0;
        }
        this.val$child.onNext(paramT);
        if ((i != 0) && (!this.completed))
        {
          this.completed = true;
          try
          {
            this.val$child.onCompleted();
            return;
          }
          finally
          {
            unsubscribe();
          }
        }
      }
    }
  }
  
  public void setProducer(Producer paramProducer)
  {
    this.val$child.setProducer(new OperatorTake.1.1(this, paramProducer));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorTake.1
 * JD-Core Version:    0.7.0.1
 */