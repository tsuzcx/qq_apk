package rx;

import rx.functions.Action0;
import rx.functions.Action1;
import rx.subscriptions.MultipleAssignmentSubscription;

class Completable$27
  implements Completable.CompletableSubscriber
{
  Completable$27(Completable paramCompletable, Action0 paramAction0, MultipleAssignmentSubscription paramMultipleAssignmentSubscription, Action1 paramAction1) {}
  
  public void onCompleted()
  {
    try
    {
      this.val$onComplete.call();
      this.val$mad.unsubscribe();
      return;
    }
    catch (Throwable localThrowable)
    {
      onError(localThrowable);
    }
  }
  
  /* Error */
  public void onError(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	rx/Completable$27:val$onError	Lrx/functions/Action1;
    //   4: aload_1
    //   5: invokeinterface 50 2 0
    //   10: aload_0
    //   11: getfield 22	rx/Completable$27:val$mad	Lrx/subscriptions/MultipleAssignmentSubscription;
    //   14: invokevirtual 41	rx/subscriptions/MultipleAssignmentSubscription:unsubscribe	()V
    //   17: return
    //   18: astore_1
    //   19: goto +41 -> 60
    //   22: astore_2
    //   23: new 52	rx/exceptions/CompositeException
    //   26: dup
    //   27: iconst_2
    //   28: anewarray 31	java/lang/Throwable
    //   31: dup
    //   32: iconst_0
    //   33: aload_1
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: aload_2
    //   38: aastore
    //   39: invokestatic 58	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   42: invokespecial 61	rx/exceptions/CompositeException:<init>	(Ljava/util/Collection;)V
    //   45: astore_1
    //   46: getstatic 67	rx/Completable:ERROR_HANDLER	Lrx/plugins/RxJavaErrorHandler;
    //   49: aload_1
    //   50: invokevirtual 72	rx/plugins/RxJavaErrorHandler:handleError	(Ljava/lang/Throwable;)V
    //   53: aload_1
    //   54: invokestatic 75	rx/Completable:access$000	(Ljava/lang/Throwable;)V
    //   57: goto -47 -> 10
    //   60: aload_0
    //   61: getfield 22	rx/Completable$27:val$mad	Lrx/subscriptions/MultipleAssignmentSubscription;
    //   64: invokevirtual 41	rx/subscriptions/MultipleAssignmentSubscription:unsubscribe	()V
    //   67: goto +5 -> 72
    //   70: aload_1
    //   71: athrow
    //   72: goto -2 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	27
    //   0	75	1	paramThrowable	Throwable
    //   22	16	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	10	18	finally
    //   23	57	18	finally
    //   0	10	22	java/lang/Throwable
  }
  
  public void onSubscribe(Subscription paramSubscription)
  {
    this.val$mad.set(paramSubscription);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Completable.27
 * JD-Core Version:    0.7.0.1
 */