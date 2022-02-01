package rx;

import rx.functions.Func9;
import rx.functions.FuncN;

final class Single$13
  implements FuncN<R>
{
  Single$13(Func9 paramFunc9) {}
  
  public R call(Object... paramVarArgs)
  {
    return this.val$zipFunction.call(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3], paramVarArgs[4], paramVarArgs[5], paramVarArgs[6], paramVarArgs[7], paramVarArgs[8]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Single.13
 * JD-Core Version:    0.7.0.1
 */