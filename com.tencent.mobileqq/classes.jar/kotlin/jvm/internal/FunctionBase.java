package kotlin.jvm.internal;

import kotlin.Function;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/FunctionBase;", "R", "Lkotlin/Function;", "arity", "", "getArity", "()I", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface FunctionBase<R>
  extends Function<R>
{
  public abstract int getArity();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.jvm.internal.FunctionBase
 * JD-Core Version:    0.7.0.1
 */