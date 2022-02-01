package kotlin.reflect.jvm.internal.impl.types;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public final class SimpleTypeWithEnhancement
  extends DelegatingSimpleType
  implements TypeWithEnhancement
{
  @NotNull
  private final SimpleType delegate;
  @NotNull
  private final KotlinType enhancement;
  
  public SimpleTypeWithEnhancement(@NotNull SimpleType paramSimpleType, @NotNull KotlinType paramKotlinType)
  {
    this.delegate = paramSimpleType;
    this.enhancement = paramKotlinType;
  }
  
  @NotNull
  protected SimpleType getDelegate()
  {
    return this.delegate;
  }
  
  @NotNull
  public KotlinType getEnhancement()
  {
    return this.enhancement;
  }
  
  @NotNull
  public UnwrappedType getOrigin()
  {
    return (UnwrappedType)getDelegate();
  }
  
  @NotNull
  public SimpleType makeNullableAsSpecified(boolean paramBoolean)
  {
    UnwrappedType localUnwrappedType = TypeWithEnhancementKt.wrapEnhancement(getOrigin().makeNullableAsSpecified(paramBoolean), (KotlinType)getEnhancement().unwrap().makeNullableAsSpecified(paramBoolean));
    if (localUnwrappedType != null) {
      return (SimpleType)localUnwrappedType;
    }
    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
  }
  
  @NotNull
  public SimpleTypeWithEnhancement refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    KotlinType localKotlinType = paramKotlinTypeRefiner.refineType((KotlinType)getDelegate());
    if (localKotlinType != null) {
      return new SimpleTypeWithEnhancement((SimpleType)localKotlinType, paramKotlinTypeRefiner.refineType(getEnhancement()));
    }
    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
  }
  
  @NotNull
  public SimpleType replaceAnnotations(@NotNull Annotations paramAnnotations)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "newAnnotations");
    paramAnnotations = TypeWithEnhancementKt.wrapEnhancement(getOrigin().replaceAnnotations(paramAnnotations), getEnhancement());
    if (paramAnnotations != null) {
      return (SimpleType)paramAnnotations;
    }
    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
  }
  
  @NotNull
  public SimpleTypeWithEnhancement replaceDelegate(@NotNull SimpleType paramSimpleType)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleType, "delegate");
    return new SimpleTypeWithEnhancement(paramSimpleType, getEnhancement());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithEnhancement
 * JD-Core Version:    0.7.0.1
 */