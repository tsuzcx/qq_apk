package rx;

import rx.functions.Func8;
import rx.functions.FuncN;

final class Single$12
  implements FuncN<R>
{
  Single$12(Func8 paramFunc8) {}
  
  public R call(Object... paramVarArgs)
  {
    return this.val$zipFunction.call(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3], paramVarArgs[4], paramVarArgs[5], paramVarArgs[6], paramVarArgs[7]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.Single.12
 * JD-Core Version:    0.7.0.1
 */