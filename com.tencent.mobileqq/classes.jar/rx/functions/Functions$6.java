package rx.functions;

final class Functions$6
  implements FuncN<R>
{
  Functions$6(Func5 paramFunc5) {}
  
  public R call(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 5) {
      throw new RuntimeException("Func5 expecting 5 arguments.");
    }
    return this.val$f.call(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3], paramVarArgs[4]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.functions.Functions.6
 * JD-Core Version:    0.7.0.1
 */