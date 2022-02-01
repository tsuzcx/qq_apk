package rx.internal.operators;

import java.util.Arrays;
import rx.Single;
import rx.Single.OnSubscribe;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;

public final class SingleOnSubscribeUsing<T, Resource>
  implements Single.OnSubscribe<T>
{
  final Action1<? super Resource> disposeAction;
  final boolean disposeEagerly;
  final Func0<Resource> resourceFactory;
  final Func1<? super Resource, ? extends Single<? extends T>> singleFactory;
  
  public SingleOnSubscribeUsing(Func0<Resource> paramFunc0, Func1<? super Resource, ? extends Single<? extends T>> paramFunc1, Action1<? super Resource> paramAction1, boolean paramBoolean)
  {
    this.resourceFactory = paramFunc0;
    this.singleFactory = paramFunc1;
    this.disposeAction = paramAction1;
    this.disposeEagerly = paramBoolean;
  }
  
  public void call(SingleSubscriber<? super T> paramSingleSubscriber)
  {
    try
    {
      Object localObject = this.resourceFactory.call();
      try
      {
        Single localSingle = (Single)this.singleFactory.call(localObject);
        if (localSingle == null)
        {
          handleSubscriptionTimeError(paramSingleSubscriber, localObject, new NullPointerException("The single"));
          return;
        }
        localObject = new SingleOnSubscribeUsing.1(this, localObject, paramSingleSubscriber);
        paramSingleSubscriber.add((Subscription)localObject);
        localSingle.subscribe((SingleSubscriber)localObject);
        return;
      }
      catch (Throwable localThrowable2)
      {
        handleSubscriptionTimeError(paramSingleSubscriber, localObject, localThrowable2);
        return;
      }
      return;
    }
    catch (Throwable localThrowable1)
    {
      Exceptions.throwIfFatal(localThrowable1);
      paramSingleSubscriber.onError(localThrowable1);
    }
  }
  
  void handleSubscriptionTimeError(SingleSubscriber<? super T> paramSingleSubscriber, Resource paramResource, Throwable paramThrowable)
  {
    Exceptions.throwIfFatal(paramThrowable);
    Throwable localThrowable1 = paramThrowable;
    CompositeException localCompositeException;
    if (this.disposeEagerly) {
      try
      {
        this.disposeAction.call(paramResource);
        localThrowable1 = paramThrowable;
      }
      catch (Throwable localThrowable2)
      {
        Exceptions.throwIfFatal(localThrowable2);
        localCompositeException = new CompositeException(Arrays.asList(new Throwable[] { paramThrowable, localThrowable2 }));
      }
    }
    paramSingleSubscriber.onError(localCompositeException);
    if (!this.disposeEagerly) {
      try
      {
        this.disposeAction.call(paramResource);
        return;
      }
      catch (Throwable paramSingleSubscriber)
      {
        Exceptions.throwIfFatal(paramSingleSubscriber);
        RxJavaPlugins.getInstance().getErrorHandler().handleError(paramSingleSubscriber);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.SingleOnSubscribeUsing
 * JD-Core Version:    0.7.0.1
 */