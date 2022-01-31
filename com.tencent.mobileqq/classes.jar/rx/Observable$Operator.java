package rx;

import rx.functions.Func1;

public abstract interface Observable$Operator<R, T>
  extends Func1<Subscriber<? super R>, Subscriber<? super T>>
{}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.Observable.Operator
 * JD-Core Version:    0.7.0.1
 */