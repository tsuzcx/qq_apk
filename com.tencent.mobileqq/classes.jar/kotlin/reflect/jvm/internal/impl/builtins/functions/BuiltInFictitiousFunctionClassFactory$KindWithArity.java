package kotlin.reflect.jvm.internal.impl.builtins.functions;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class BuiltInFictitiousFunctionClassFactory$KindWithArity
{
  private final int arity;
  @NotNull
  private final FunctionClassDescriptor.Kind kind;
  
  public BuiltInFictitiousFunctionClassFactory$KindWithArity(@NotNull FunctionClassDescriptor.Kind paramKind, int paramInt)
  {
    this.kind = paramKind;
    this.arity = paramInt;
  }
  
  @NotNull
  public final FunctionClassDescriptor.Kind component1()
  {
    return this.kind;
  }
  
  public final int component2()
  {
    return this.arity;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof KindWithArity))
      {
        paramObject = (KindWithArity)paramObject;
        if ((Intrinsics.areEqual(this.kind, paramObject.kind)) && (this.arity == paramObject.arity)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final FunctionClassDescriptor.Kind getKind()
  {
    return this.kind;
  }
  
  public int hashCode()
  {
    FunctionClassDescriptor.Kind localKind = this.kind;
    int i;
    if (localKind != null) {
      i = localKind.hashCode();
    } else {
      i = 0;
    }
    return i * 31 + this.arity;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KindWithArity(kind=");
    localStringBuilder.append(this.kind);
    localStringBuilder.append(", arity=");
    localStringBuilder.append(this.arity);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory.KindWithArity
 * JD-Core Version:    0.7.0.1
 */