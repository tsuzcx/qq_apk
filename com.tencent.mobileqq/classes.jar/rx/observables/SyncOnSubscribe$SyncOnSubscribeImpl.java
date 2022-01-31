package rx.observables;

import rx.Observer;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func2;

final class SyncOnSubscribe$SyncOnSubscribeImpl<S, T>
  extends SyncOnSubscribe<S, T>
{
  private final Func0<? extends S> generator;
  private final Func2<? super S, ? super Observer<? super T>, ? extends S> next;
  private final Action1<? super S> onUnsubscribe;
  
  public SyncOnSubscribe$SyncOnSubscribeImpl(Func0<? extends S> paramFunc0, Func2<? super S, ? super Observer<? super T>, ? extends S> paramFunc2)
  {
    this(paramFunc0, paramFunc2, null);
  }
  
  SyncOnSubscribe$SyncOnSubscribeImpl(Func0<? extends S> paramFunc0, Func2<? super S, ? super Observer<? super T>, ? extends S> paramFunc2, Action1<? super S> paramAction1)
  {
    this.generator = paramFunc0;
    this.next = paramFunc2;
    this.onUnsubscribe = paramAction1;
  }
  
  public SyncOnSubscribe$SyncOnSubscribeImpl(Func2<S, Observer<? super T>, S> paramFunc2)
  {
    this(null, paramFunc2, null);
  }
  
  public SyncOnSubscribe$SyncOnSubscribeImpl(Func2<S, Observer<? super T>, S> paramFunc2, Action1<? super S> paramAction1)
  {
    this(null, paramFunc2, paramAction1);
  }
  
  protected S generateState()
  {
    if (this.generator == null) {
      return null;
    }
    return this.generator.call();
  }
  
  protected S next(S paramS, Observer<? super T> paramObserver)
  {
    return this.next.call(paramS, paramObserver);
  }
  
  protected void onUnsubscribe(S paramS)
  {
    if (this.onUnsubscribe != null) {
      this.onUnsubscribe.call(paramS);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.observables.SyncOnSubscribe.SyncOnSubscribeImpl
 * JD-Core Version:    0.7.0.1
 */