package rx.functions;

final class Functions$4
  implements FuncN<R>
{
  Functions$4(Func3 paramFunc3) {}
  
  public R call(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 3) {
      throw new RuntimeException("Func3 expecting 3 arguments.");
    }
    return this.val$f.call(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.functions.Functions.4
 * JD-Core Version:    0.7.0.1
 */