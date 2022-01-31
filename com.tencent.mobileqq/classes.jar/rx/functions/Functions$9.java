package rx.functions;

final class Functions$9
  implements FuncN<R>
{
  Functions$9(Func8 paramFunc8) {}
  
  public R call(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 8) {
      throw new RuntimeException("Func8 expecting 8 arguments.");
    }
    return this.val$f.call(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3], paramVarArgs[4], paramVarArgs[5], paramVarArgs[6], paramVarArgs[7]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.functions.Functions.9
 * JD-Core Version:    0.7.0.1
 */