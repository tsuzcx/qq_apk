package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public abstract class DelegatingSimpleType
  extends SimpleType
{
  @NotNull
  public Annotations getAnnotations()
  {
    return getDelegate().getAnnotations();
  }
  
  @NotNull
  public List<TypeProjection> getArguments()
  {
    return getDelegate().getArguments();
  }
  
  @NotNull
  public TypeConstructor getConstructor()
  {
    return getDelegate().getConstructor();
  }
  
  @NotNull
  protected abstract SimpleType getDelegate();
  
  @NotNull
  public MemberScope getMemberScope()
  {
    return getDelegate().getMemberScope();
  }
  
  public boolean isMarkedNullable()
  {
    return getDelegate().isMarkedNullable();
  }
  
  @NotNull
  public SimpleType refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    paramKotlinTypeRefiner = paramKotlinTypeRefiner.refineType((KotlinType)getDelegate());
    if (paramKotlinTypeRefiner != null) {
      return (SimpleType)replaceDelegate((SimpleType)paramKotlinTypeRefiner);
    }
    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
  }
  
  @NotNull
  public abstract DelegatingSimpleType replaceDelegate(@NotNull SimpleType paramSimpleType);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
 * JD-Core Version:    0.7.0.1
 */