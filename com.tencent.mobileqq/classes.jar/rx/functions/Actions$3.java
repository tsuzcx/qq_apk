package rx.functions;

final class Actions$3
  implements Func2<T1, T2, R>
{
  Actions$3(Action2 paramAction2, Object paramObject) {}
  
  public R call(T1 paramT1, T2 paramT2)
  {
    this.val$action.call(paramT1, paramT2);
    return this.val$result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.functions.Actions.3
 * JD-Core Version:    0.7.0.1
 */