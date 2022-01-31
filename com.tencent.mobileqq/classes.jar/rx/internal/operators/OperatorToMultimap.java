package rx.internal.operators;

import java.util.Collection;
import java.util.Map;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.observers.Subscribers;

public final class OperatorToMultimap<T, K, V>
  implements Observable.Operator<Map<K, Collection<V>>, T>
{
  final Func1<? super K, ? extends Collection<V>> collectionFactory;
  final Func1<? super T, ? extends K> keySelector;
  private final Func0<? extends Map<K, Collection<V>>> mapFactory;
  final Func1<? super T, ? extends V> valueSelector;
  
  public OperatorToMultimap(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11)
  {
    this(paramFunc1, paramFunc11, new OperatorToMultimap.DefaultToMultimapFactory(), new OperatorToMultimap.DefaultMultimapCollectionFactory());
  }
  
  public OperatorToMultimap(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11, Func0<? extends Map<K, Collection<V>>> paramFunc0)
  {
    this(paramFunc1, paramFunc11, paramFunc0, new OperatorToMultimap.DefaultMultimapCollectionFactory());
  }
  
  public OperatorToMultimap(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11, Func0<? extends Map<K, Collection<V>>> paramFunc0, Func1<? super K, ? extends Collection<V>> paramFunc12)
  {
    this.keySelector = paramFunc1;
    this.valueSelector = paramFunc11;
    this.mapFactory = paramFunc0;
    this.collectionFactory = paramFunc12;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Map<K, Collection<V>>> paramSubscriber)
  {
    try
    {
      Map localMap = (Map)this.mapFactory.call();
      return new OperatorToMultimap.1(this, paramSubscriber, localMap, paramSubscriber);
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwIfFatal(localThrowable);
      paramSubscriber.onError(localThrowable);
      paramSubscriber = Subscribers.empty();
      paramSubscriber.unsubscribe();
    }
    return paramSubscriber;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorToMultimap
 * JD-Core Version:    0.7.0.1
 */