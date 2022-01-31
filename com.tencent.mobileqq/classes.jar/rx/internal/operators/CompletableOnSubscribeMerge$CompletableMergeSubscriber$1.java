package rx.internal.operators;

import java.util.Queue;
import rx.Completable.CompletableSubscriber;
import rx.Subscription;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import rx.subscriptions.CompositeSubscription;

class CompletableOnSubscribeMerge$CompletableMergeSubscriber$1
  implements Completable.CompletableSubscriber
{
  Subscription d;
  boolean innerDone;
  
  CompletableOnSubscribeMerge$CompletableMergeSubscriber$1(CompletableOnSubscribeMerge.CompletableMergeSubscriber paramCompletableMergeSubscriber) {}
  
  public void onCompleted()
  {
    if (this.innerDone) {}
    do
    {
      return;
      this.innerDone = true;
      this.this$0.set.remove(this.d);
      this.this$0.terminate();
    } while (this.this$0.done);
    CompletableOnSubscribeMerge.CompletableMergeSubscriber.access$100(this.this$0, 1L);
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.innerDone) {
      RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
    }
    do
    {
      return;
      this.innerDone = true;
      this.this$0.set.remove(this.d);
      this.this$0.getOrCreateErrors().offer(paramThrowable);
      this.this$0.terminate();
    } while ((!this.this$0.delayErrors) || (this.this$0.done));
    CompletableOnSubscribeMerge.CompletableMergeSubscriber.access$000(this.this$0, 1L);
  }
  
  public void onSubscribe(Subscription paramSubscription)
  {
    this.d = paramSubscription;
    this.this$0.set.add(paramSubscription);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.CompletableOnSubscribeMerge.CompletableMergeSubscriber.1
 * JD-Core Version:    0.7.0.1
 */