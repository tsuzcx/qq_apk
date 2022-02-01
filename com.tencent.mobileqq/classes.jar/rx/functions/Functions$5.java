package rx.functions;

final class Functions$5
  implements FuncN<R>
{
  Functions$5(Func4 paramFunc4) {}
  
  public R call(Object... paramVarArgs)
  {
    if (paramVarArgs.length == 4) {
      return this.val$f.call(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3]);
    }
    throw new RuntimeException("Func4 expecting 4 arguments.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.functions.Functions.5
 * JD-Core Version:    0.7.0.1
 */