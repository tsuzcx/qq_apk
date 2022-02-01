package kotlin.jvm.functions;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.FunctionBase;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/functions/FunctionN;", "R", "Lkotlin/Function;", "Lkotlin/jvm/internal/FunctionBase;", "arity", "", "getArity", "()I", "invoke", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
public abstract interface FunctionN<R>
  extends Function<R>, FunctionBase<R>
{
  public abstract int getArity();
  
  public abstract R invoke(@NotNull Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.jvm.functions.FunctionN
 * JD-Core Version:    0.7.0.1
 */