package rx.functions;

final class Functions$14
  implements FuncN<Void>
{
  Functions$14(Action3 paramAction3) {}
  
  public Void call(Object... paramVarArgs)
  {
    if (paramVarArgs.length == 3)
    {
      this.val$f.call(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
      return null;
    }
    throw new RuntimeException("Action3 expecting 3 arguments.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.functions.Functions.14
 * JD-Core Version:    0.7.0.1
 */