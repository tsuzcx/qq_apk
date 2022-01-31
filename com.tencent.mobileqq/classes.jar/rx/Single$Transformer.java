package rx;

import rx.functions.Func1;

public abstract interface Single$Transformer<T, R>
  extends Func1<Single<T>, Single<R>>
{}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.Single.Transformer
 * JD-Core Version:    0.7.0.1
 */