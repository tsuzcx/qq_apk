package rx.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.SubscriptionList;
import rx.subscriptions.CompositeSubscription;

public final class ScheduledAction
  extends AtomicReference<Thread>
  implements Runnable, Subscription
{
  private static final long serialVersionUID = -3962399486978279857L;
  final Action0 action;
  final SubscriptionList cancel;
  
  public ScheduledAction(Action0 paramAction0)
  {
    this.action = paramAction0;
    this.cancel = new SubscriptionList();
  }
  
  public ScheduledAction(Action0 paramAction0, SubscriptionList paramSubscriptionList)
  {
    this.action = paramAction0;
    this.cancel = new SubscriptionList(new ScheduledAction.Remover2(this, paramSubscriptionList));
  }
  
  public ScheduledAction(Action0 paramAction0, CompositeSubscription paramCompositeSubscription)
  {
    this.action = paramAction0;
    this.cancel = new SubscriptionList(new ScheduledAction.Remover(this, paramCompositeSubscription));
  }
  
  public void add(Future<?> paramFuture)
  {
    this.cancel.add(new ScheduledAction.FutureCompleter(this, paramFuture));
  }
  
  public void add(Subscription paramSubscription)
  {
    this.cancel.add(paramSubscription);
  }
  
  public void addParent(SubscriptionList paramSubscriptionList)
  {
    this.cancel.add(new ScheduledAction.Remover2(this, paramSubscriptionList));
  }
  
  public void addParent(CompositeSubscription paramCompositeSubscription)
  {
    this.cancel.add(new ScheduledAction.Remover(this, paramCompositeSubscription));
  }
  
  public boolean isUnsubscribed()
  {
    return this.cancel.isUnsubscribed();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 72	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   4: invokevirtual 76	rx/internal/schedulers/ScheduledAction:lazySet	(Ljava/lang/Object;)V
    //   7: aload_0
    //   8: getfield 24	rx/internal/schedulers/ScheduledAction:action	Lrx/functions/Action0;
    //   11: invokeinterface 81 1 0
    //   16: aload_0
    //   17: invokevirtual 84	rx/internal/schedulers/ScheduledAction:unsubscribe	()V
    //   20: return
    //   21: astore_1
    //   22: goto +64 -> 86
    //   25: astore_1
    //   26: aload_1
    //   27: instanceof 86
    //   30: ifeq +17 -> 47
    //   33: new 88	java/lang/IllegalStateException
    //   36: dup
    //   37: ldc 90
    //   39: aload_1
    //   40: invokespecial 93	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   43: astore_1
    //   44: goto +14 -> 58
    //   47: new 88	java/lang/IllegalStateException
    //   50: dup
    //   51: ldc 95
    //   53: aload_1
    //   54: invokespecial 93	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   57: astore_1
    //   58: invokestatic 101	rx/plugins/RxJavaPlugins:getInstance	()Lrx/plugins/RxJavaPlugins;
    //   61: invokevirtual 105	rx/plugins/RxJavaPlugins:getErrorHandler	()Lrx/plugins/RxJavaErrorHandler;
    //   64: aload_1
    //   65: invokevirtual 111	rx/plugins/RxJavaErrorHandler:handleError	(Ljava/lang/Throwable;)V
    //   68: invokestatic 72	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   71: astore_2
    //   72: aload_2
    //   73: invokevirtual 115	java/lang/Thread:getUncaughtExceptionHandler	()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   76: aload_2
    //   77: aload_1
    //   78: invokeinterface 121 3 0
    //   83: goto -67 -> 16
    //   86: aload_0
    //   87: invokevirtual 84	rx/internal/schedulers/ScheduledAction:unsubscribe	()V
    //   90: goto +5 -> 95
    //   93: aload_1
    //   94: athrow
    //   95: goto -2 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	ScheduledAction
    //   21	1	1	localObject	java.lang.Object
    //   25	15	1	localThrowable	java.lang.Throwable
    //   43	51	1	localIllegalStateException	java.lang.IllegalStateException
    //   71	6	2	localThread	Thread
    // Exception table:
    //   from	to	target	type
    //   0	16	21	finally
    //   26	44	21	finally
    //   47	58	21	finally
    //   58	83	21	finally
    //   0	16	25	java/lang/Throwable
  }
  
  public void unsubscribe()
  {
    if (!this.cancel.isUnsubscribed()) {
      this.cancel.unsubscribe();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.schedulers.ScheduledAction
 * JD-Core Version:    0.7.0.1
 */