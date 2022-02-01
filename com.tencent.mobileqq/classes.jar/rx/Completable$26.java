package rx;

import rx.functions.Action0;
import rx.plugins.RxJavaErrorHandler;
import rx.subscriptions.MultipleAssignmentSubscription;

class Completable$26
  implements Completable.CompletableSubscriber
{
  Completable$26(Completable paramCompletable, Action0 paramAction0, MultipleAssignmentSubscription paramMultipleAssignmentSubscription) {}
  
  /* Error */
  public void onCompleted()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	rx/Completable$26:val$onComplete	Lrx/functions/Action0;
    //   4: invokeinterface 32 1 0
    //   9: aload_0
    //   10: getfield 20	rx/Completable$26:val$mad	Lrx/subscriptions/MultipleAssignmentSubscription;
    //   13: invokevirtual 37	rx/subscriptions/MultipleAssignmentSubscription:unsubscribe	()V
    //   16: return
    //   17: astore_1
    //   18: goto +18 -> 36
    //   21: astore_1
    //   22: getstatic 43	rx/Completable:ERROR_HANDLER	Lrx/plugins/RxJavaErrorHandler;
    //   25: aload_1
    //   26: invokevirtual 49	rx/plugins/RxJavaErrorHandler:handleError	(Ljava/lang/Throwable;)V
    //   29: aload_1
    //   30: invokestatic 52	rx/Completable:access$000	(Ljava/lang/Throwable;)V
    //   33: goto -24 -> 9
    //   36: aload_0
    //   37: getfield 20	rx/Completable$26:val$mad	Lrx/subscriptions/MultipleAssignmentSubscription;
    //   40: invokevirtual 37	rx/subscriptions/MultipleAssignmentSubscription:unsubscribe	()V
    //   43: goto +5 -> 48
    //   46: aload_1
    //   47: athrow
    //   48: goto -2 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	26
    //   17	1	1	localObject	Object
    //   21	26	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	9	17	finally
    //   22	33	17	finally
    //   0	9	21	java/lang/Throwable
  }
  
  public void onError(Throwable paramThrowable)
  {
    Completable.ERROR_HANDLER.handleError(paramThrowable);
    this.val$mad.unsubscribe();
    Completable.access$000(paramThrowable);
  }
  
  public void onSubscribe(Subscription paramSubscription)
  {
    this.val$mad.set(paramSubscription);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Completable.26
 * JD-Core Version:    0.7.0.1
 */