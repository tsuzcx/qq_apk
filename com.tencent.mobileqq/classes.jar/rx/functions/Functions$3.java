package rx.functions;

final class Functions$3
  implements FuncN<R>
{
  Functions$3(Func2 paramFunc2) {}
  
  public R call(Object... paramVarArgs)
  {
    if (paramVarArgs.length == 2) {
      return this.val$f.call(paramVarArgs[0], paramVarArgs[1]);
    }
    throw new RuntimeException("Func2 expecting 2 arguments.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.functions.Functions.3
 * JD-Core Version:    0.7.0.1
 */