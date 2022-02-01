package rx.functions;

final class Functions$7
  implements FuncN<R>
{
  Functions$7(Func6 paramFunc6) {}
  
  public R call(Object... paramVarArgs)
  {
    if (paramVarArgs.length == 6) {
      return this.val$f.call(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3], paramVarArgs[4], paramVarArgs[5]);
    }
    throw new RuntimeException("Func6 expecting 6 arguments.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.functions.Functions.7
 * JD-Core Version:    0.7.0.1
 */