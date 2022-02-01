package rx.functions;

public abstract interface Func3<T1, T2, T3, R>
  extends Function
{
  public abstract R call(T1 paramT1, T2 paramT2, T3 paramT3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.functions.Func3
 * JD-Core Version:    0.7.0.1
 */