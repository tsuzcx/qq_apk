package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/Lambda;", "R", "Lkotlin/jvm/internal/FunctionBase;", "Ljava/io/Serializable;", "arity", "", "(I)V", "getArity", "()I", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract class Lambda<R>
  implements Serializable, FunctionBase<R>
{
  private final int arity;
  
  public Lambda(int paramInt)
  {
    this.arity = paramInt;
  }
  
  public int getArity()
  {
    return this.arity;
  }
  
  @NotNull
  public String toString()
  {
    String str = Reflection.renderLambdaToString(this);
    Intrinsics.checkExpressionValueIsNotNull(str, "Reflection.renderLambdaToString(this)");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.jvm.internal.Lambda
 * JD-Core Version:    0.7.0.1
 */