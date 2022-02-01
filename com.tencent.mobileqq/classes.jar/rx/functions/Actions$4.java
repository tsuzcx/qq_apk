package rx.functions;

final class Actions$4
  implements Func3<T1, T2, T3, R>
{
  Actions$4(Action3 paramAction3, Object paramObject) {}
  
  public R call(T1 paramT1, T2 paramT2, T3 paramT3)
  {
    this.val$action.call(paramT1, paramT2, paramT3);
    return this.val$result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.functions.Actions.4
 * JD-Core Version:    0.7.0.1
 */