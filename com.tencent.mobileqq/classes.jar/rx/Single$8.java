package rx;

import rx.functions.Func4;
import rx.functions.FuncN;

final class Single$8
  implements FuncN<R>
{
  Single$8(Func4 paramFunc4) {}
  
  public R call(Object... paramVarArgs)
  {
    return this.val$zipFunction.call(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.Single.8
 * JD-Core Version:    0.7.0.1
 */