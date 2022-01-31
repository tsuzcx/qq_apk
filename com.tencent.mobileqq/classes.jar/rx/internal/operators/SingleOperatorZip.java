package rx.internal.operators;

import rx.Single;
import rx.functions.FuncN;

public class SingleOperatorZip
{
  public static <T, R> Single<R> zip(Single<? extends T>[] paramArrayOfSingle, FuncN<? extends R> paramFuncN)
  {
    return Single.create(new SingleOperatorZip.1(paramArrayOfSingle, paramFuncN));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.SingleOperatorZip
 * JD-Core Version:    0.7.0.1
 */