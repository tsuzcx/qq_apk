package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/jvm/internal/SuspendLambda;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/jvm/internal/FunctionBase;", "", "Lkotlin/coroutines/jvm/internal/SuspendFunction;", "arity", "", "(I)V", "completion", "Lkotlin/coroutines/Continuation;", "(ILkotlin/coroutines/Continuation;)V", "getArity", "()I", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
public abstract class SuspendLambda
  extends ContinuationImpl
  implements SuspendFunction, FunctionBase<Object>
{
  private final int arity;
  
  public SuspendLambda(int paramInt)
  {
    this(paramInt, null);
  }
  
  public SuspendLambda(int paramInt, @Nullable Continuation<Object> paramContinuation)
  {
    super(paramContinuation);
    this.arity = paramInt;
  }
  
  public int getArity()
  {
    return this.arity;
  }
  
  @NotNull
  public String toString()
  {
    if (getCompletion() == null)
    {
      String str = Reflection.renderLambdaToString((FunctionBase)this);
      Intrinsics.checkExpressionValueIsNotNull(str, "Reflection.renderLambdaToString(this)");
      return str;
    }
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.coroutines.jvm.internal.SuspendLambda
 * JD-Core Version:    0.7.0.1
 */