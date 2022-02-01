package rx;

import rx.functions.Func3;
import rx.functions.FuncN;

final class Single$7
  implements FuncN<R>
{
  Single$7(Func3 paramFunc3) {}
  
  public R call(Object... paramVarArgs)
  {
    return this.val$zipFunction.call(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.Single.7
 * JD-Core Version:    0.7.0.1
 */