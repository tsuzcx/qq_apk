package rx.functions;

final class Functions$13
  implements FuncN<Void>
{
  Functions$13(Action2 paramAction2) {}
  
  public Void call(Object... paramVarArgs)
  {
    if (paramVarArgs.length == 2)
    {
      this.val$f.call(paramVarArgs[0], paramVarArgs[1]);
      return null;
    }
    throw new RuntimeException("Action3 expecting 2 arguments.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.functions.Functions.13
 * JD-Core Version:    0.7.0.1
 */