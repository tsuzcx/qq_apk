package rx;

import rx.functions.Func6;
import rx.functions.FuncN;

final class Single$10
  implements FuncN<R>
{
  Single$10(Func6 paramFunc6) {}
  
  public R call(Object... paramVarArgs)
  {
    return this.val$zipFunction.call(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3], paramVarArgs[4], paramVarArgs[5]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.Single.10
 * JD-Core Version:    0.7.0.1
 */