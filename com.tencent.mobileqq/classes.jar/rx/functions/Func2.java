package rx.functions;

public abstract interface Func2<T1, T2, R>
  extends Function
{
  public abstract R call(T1 paramT1, T2 paramT2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.functions.Func2
 * JD-Core Version:    0.7.0.1
 */