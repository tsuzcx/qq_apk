package rx.functions;

final class Functions$11
  implements FuncN<Void>
{
  Functions$11(Action0 paramAction0) {}
  
  public Void call(Object... paramVarArgs)
  {
    if (paramVarArgs.length == 0)
    {
      this.val$f.call();
      return null;
    }
    throw new RuntimeException("Action0 expecting 0 arguments.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.functions.Functions.11
 * JD-Core Version:    0.7.0.1
 */