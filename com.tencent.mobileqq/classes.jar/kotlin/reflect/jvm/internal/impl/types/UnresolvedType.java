package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public final class UnresolvedType
  extends ErrorType
{
  @NotNull
  private final String presentableName;
  
  public UnresolvedType(@NotNull String paramString, @NotNull TypeConstructor paramTypeConstructor, @NotNull MemberScope paramMemberScope, @NotNull List<? extends TypeProjection> paramList, boolean paramBoolean)
  {
    super(paramTypeConstructor, paramMemberScope, paramList, paramBoolean, null, 16, null);
    this.presentableName = paramString;
  }
  
  @NotNull
  public String getPresentableName()
  {
    return this.presentableName;
  }
  
  @NotNull
  public SimpleType makeNullableAsSpecified(boolean paramBoolean)
  {
    return (SimpleType)new UnresolvedType(getPresentableName(), getConstructor(), getMemberScope(), getArguments(), paramBoolean);
  }
  
  @NotNull
  public UnresolvedType refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.UnresolvedType
 * JD-Core Version:    0.7.0.1
 */