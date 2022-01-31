package rx.functions;

final class Functions$12
  implements FuncN<Void>
{
  Functions$12(Action1 paramAction1) {}
  
  public Void call(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 1) {
      throw new RuntimeException("Action1 expecting 1 argument.");
    }
    this.val$f.call(paramVarArgs[0]);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.functions.Functions.12
 * JD-Core Version:    0.7.0.1
 */