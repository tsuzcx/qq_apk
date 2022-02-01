package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

final class SimpleTypeImpl
  extends SimpleType
{
  @NotNull
  private final List<TypeProjection> arguments;
  @NotNull
  private final TypeConstructor constructor;
  private final boolean isMarkedNullable;
  @NotNull
  private final MemberScope memberScope;
  private final Function1<KotlinTypeRefiner, SimpleType> refinedTypeFactory;
  
  public SimpleTypeImpl(@NotNull TypeConstructor paramTypeConstructor, @NotNull List<? extends TypeProjection> paramList, boolean paramBoolean, @NotNull MemberScope paramMemberScope, @NotNull Function1<? super KotlinTypeRefiner, ? extends SimpleType> paramFunction1)
  {
    this.constructor = paramTypeConstructor;
    this.arguments = paramList;
    this.isMarkedNullable = paramBoolean;
    this.memberScope = paramMemberScope;
    this.refinedTypeFactory = paramFunction1;
    if (!(getMemberScope() instanceof ErrorUtils.ErrorScope)) {
      return;
    }
    paramTypeConstructor = new StringBuilder();
    paramTypeConstructor.append("SimpleTypeImpl should not be created for error type: ");
    paramTypeConstructor.append(getMemberScope());
    paramTypeConstructor.append('\n');
    paramTypeConstructor.append(getConstructor());
    throw ((Throwable)new IllegalStateException(paramTypeConstructor.toString()));
  }
  
  @NotNull
  public Annotations getAnnotations()
  {
    return Annotations.Companion.getEMPTY();
  }
  
  @NotNull
  public List<TypeProjection> getArguments()
  {
    return this.arguments;
  }
  
  @NotNull
  public TypeConstructor getConstructor()
  {
    return this.constructor;
  }
  
  @NotNull
  public MemberScope getMemberScope()
  {
    return this.memberScope;
  }
  
  public boolean isMarkedNullable()
  {
    return this.isMarkedNullable;
  }
  
  @NotNull
  public SimpleType makeNullableAsSpecified(boolean paramBoolean)
  {
    if (paramBoolean == isMarkedNullable()) {
      return (SimpleType)this;
    }
    if (paramBoolean) {
      return (SimpleType)new NullableSimpleType((SimpleType)this);
    }
    return (SimpleType)new NotNullSimpleType((SimpleType)this);
  }
  
  @NotNull
  public SimpleType refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    paramKotlinTypeRefiner = (SimpleType)this.refinedTypeFactory.invoke(paramKotlinTypeRefiner);
    if (paramKotlinTypeRefiner != null) {
      return paramKotlinTypeRefiner;
    }
    return (SimpleType)this;
  }
  
  @NotNull
  public SimpleType replaceAnnotations(@NotNull Annotations paramAnnotations)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "newAnnotations");
    if (paramAnnotations.isEmpty()) {
      return (SimpleType)this;
    }
    return (SimpleType)new AnnotatedSimpleType((SimpleType)this, paramAnnotations);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.SimpleTypeImpl
 * JD-Core Version:    0.7.0.1
 */