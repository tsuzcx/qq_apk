package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.FuncN;
import rx.internal.util.RxRingBuffer;
import rx.subscriptions.CompositeSubscription;

final class OperatorZip$Zip<R>
  extends AtomicLong
{
  static final int THRESHOLD;
  private static final long serialVersionUID = 5995274816189928317L;
  final Observer<? super R> child;
  private final CompositeSubscription childSubscription = new CompositeSubscription();
  int emitted = 0;
  private AtomicLong requested;
  private volatile Object[] subscribers;
  private final FuncN<? extends R> zipFunction;
  
  static
  {
    double d = RxRingBuffer.SIZE;
    Double.isNaN(d);
    THRESHOLD = (int)(d * 0.7D);
  }
  
  public OperatorZip$Zip(Subscriber<? super R> paramSubscriber, FuncN<? extends R> paramFuncN)
  {
    this.child = paramSubscriber;
    this.zipFunction = paramFuncN;
    paramSubscriber.add(this.childSubscription);
  }
  
  public void start(Observable[] paramArrayOfObservable, AtomicLong paramAtomicLong)
  {
    Object[] arrayOfObject = new Object[paramArrayOfObservable.length];
    int j = 0;
    int i = 0;
    while (i < paramArrayOfObservable.length)
    {
      OperatorZip.Zip.InnerSubscriber localInnerSubscriber = new OperatorZip.Zip.InnerSubscriber(this);
      arrayOfObject[i] = localInnerSubscriber;
      this.childSubscription.add(localInnerSubscriber);
      i += 1;
    }
    this.requested = paramAtomicLong;
    this.subscribers = arrayOfObject;
    i = j;
    while (i < paramArrayOfObservable.length)
    {
      paramArrayOfObservable[i].unsafeSubscribe((OperatorZip.Zip.InnerSubscriber)arrayOfObject[i]);
      i += 1;
    }
  }
  
  void tick()
  {
    Object[] arrayOfObject = this.subscribers;
    if (arrayOfObject == null) {
      return;
    }
    if (getAndIncrement() == 0L)
    {
      int k = arrayOfObject.length;
      Observer localObserver = this.child;
      AtomicLong localAtomicLong = this.requested;
      do
      {
        for (;;)
        {
          Object localObject1 = new Object[k];
          int i = 0;
          int j = 1;
          while (i < k)
          {
            RxRingBuffer localRxRingBuffer = ((OperatorZip.Zip.InnerSubscriber)arrayOfObject[i]).items;
            Object localObject2 = localRxRingBuffer.peek();
            if (localObject2 == null)
            {
              j = 0;
            }
            else
            {
              if (localRxRingBuffer.isCompleted(localObject2))
              {
                localObserver.onCompleted();
                this.childSubscription.unsubscribe();
                return;
              }
              localObject1[i] = localRxRingBuffer.getValue(localObject2);
            }
            i += 1;
          }
          if ((localAtomicLong.get() > 0L) && (j != 0)) {
            try
            {
              localObserver.onNext(this.zipFunction.call((Object[])localObject1));
              localAtomicLong.decrementAndGet();
              this.emitted += 1;
              j = arrayOfObject.length;
              i = 0;
              while (i < j)
              {
                localObject1 = ((OperatorZip.Zip.InnerSubscriber)arrayOfObject[i]).items;
                ((RxRingBuffer)localObject1).poll();
                if (((RxRingBuffer)localObject1).isCompleted(((RxRingBuffer)localObject1).peek()))
                {
                  localObserver.onCompleted();
                  this.childSubscription.unsubscribe();
                  return;
                }
                i += 1;
              }
              if (this.emitted > THRESHOLD)
              {
                j = arrayOfObject.length;
                i = 0;
                while (i < j)
                {
                  ((OperatorZip.Zip.InnerSubscriber)arrayOfObject[i]).requestMore(this.emitted);
                  i += 1;
                }
                this.emitted = 0;
              }
            }
            catch (Throwable localThrowable)
            {
              Exceptions.throwOrReport(localThrowable, localObserver, localObject1);
              return;
            }
          }
        }
      } while (decrementAndGet() > 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorZip.Zip
 * JD-Core Version:    0.7.0.1
 */