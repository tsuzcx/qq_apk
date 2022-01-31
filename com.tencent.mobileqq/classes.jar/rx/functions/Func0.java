package rx.functions;

import java.util.concurrent.Callable;

public abstract interface Func0<R>
  extends Callable<R>, Function
{
  public abstract R call();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.functions.Func0
 * JD-Core Version:    0.7.0.1
 */