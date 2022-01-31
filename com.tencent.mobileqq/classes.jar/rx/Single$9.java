package rx;

import rx.functions.Func5;
import rx.functions.FuncN;

final class Single$9
  implements FuncN<R>
{
  Single$9(Func5 paramFunc5) {}
  
  public R call(Object... paramVarArgs)
  {
    return this.val$zipFunction.call(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3], paramVarArgs[4]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.Single.9
 * JD-Core Version:    0.7.0.1
 */