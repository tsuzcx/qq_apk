package rx.internal.operators;

import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;

class SingleOnSubscribeUsing$1
  extends SingleSubscriber<T>
{
  SingleOnSubscribeUsing$1(SingleOnSubscribeUsing paramSingleOnSubscribeUsing, Object paramObject, SingleSubscriber paramSingleSubscriber) {}
  
  public void onError(Throwable paramThrowable)
  {
    this.this$0.handleSubscriptionTimeError(this.val$child, this.val$resource, paramThrowable);
  }
  
  public void onSuccess(T paramT)
  {
    if (this.this$0.disposeEagerly) {
      try
      {
        this.this$0.disposeAction.call(this.val$resource);
      }
      catch (Throwable paramT)
      {
        Exceptions.throwIfFatal(paramT);
        this.val$child.onError(paramT);
        return;
      }
    }
    this.val$child.onSuccess(paramT);
    if (!this.this$0.disposeEagerly) {
      try
      {
        this.this$0.disposeAction.call(this.val$resource);
        return;
      }
      catch (Throwable paramT)
      {
        Exceptions.throwIfFatal(paramT);
        RxJavaPlugins.getInstance().getErrorHandler().handleError(paramT);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.SingleOnSubscribeUsing.1
 * JD-Core Version:    0.7.0.1
 */