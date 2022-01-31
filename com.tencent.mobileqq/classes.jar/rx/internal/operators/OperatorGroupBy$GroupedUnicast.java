package rx.internal.operators;

import rx.observables.GroupedObservable;

final class OperatorGroupBy$GroupedUnicast<K, T>
  extends GroupedObservable<K, T>
{
  final OperatorGroupBy.State<T, K> state;
  
  protected OperatorGroupBy$GroupedUnicast(K paramK, OperatorGroupBy.State<T, K> paramState)
  {
    super(paramK, paramState);
    this.state = paramState;
  }
  
  public static <T, K> GroupedUnicast<K, T> createWith(K paramK, int paramInt, OperatorGroupBy.GroupBySubscriber<?, K, T> paramGroupBySubscriber, boolean paramBoolean)
  {
    return new GroupedUnicast(paramK, new OperatorGroupBy.State(paramInt, paramGroupBySubscriber, paramK, paramBoolean));
  }
  
  public void onComplete()
  {
    this.state.onComplete();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.state.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.state.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorGroupBy.GroupedUnicast
 * JD-Core Version:    0.7.0.1
 */