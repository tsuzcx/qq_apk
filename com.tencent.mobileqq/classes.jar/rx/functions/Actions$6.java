package rx.functions;

final class Actions$6
  implements Func5<T1, T2, T3, T4, T5, R>
{
  Actions$6(Action5 paramAction5, Object paramObject) {}
  
  public R call(T1 paramT1, T2 paramT2, T3 paramT3, T4 paramT4, T5 paramT5)
  {
    this.val$action.call(paramT1, paramT2, paramT3, paramT4, paramT5);
    return this.val$result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.functions.Actions.6
 * JD-Core Version:    0.7.0.1
 */