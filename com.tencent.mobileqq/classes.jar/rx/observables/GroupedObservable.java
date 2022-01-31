package rx.observables;

import rx.Observable;
import rx.Observable.OnSubscribe;

public class GroupedObservable<K, T>
  extends Observable<T>
{
  private final K key;
  
  protected GroupedObservable(K paramK, Observable.OnSubscribe<T> paramOnSubscribe)
  {
    super(paramOnSubscribe);
    this.key = paramK;
  }
  
  public static <K, T> GroupedObservable<K, T> create(K paramK, Observable.OnSubscribe<T> paramOnSubscribe)
  {
    return new GroupedObservable(paramK, paramOnSubscribe);
  }
  
  public static <K, T> GroupedObservable<K, T> from(K paramK, Observable<T> paramObservable)
  {
    return new GroupedObservable(paramK, new GroupedObservable.1(paramObservable));
  }
  
  public K getKey()
  {
    return this.key;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.observables.GroupedObservable
 * JD-Core Version:    0.7.0.1
 */