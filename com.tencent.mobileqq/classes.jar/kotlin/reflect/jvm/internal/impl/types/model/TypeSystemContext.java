package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface TypeSystemContext
  extends TypeSystemOptimizationContext
{
  public abstract int argumentsCount(@NotNull KotlinTypeMarker paramKotlinTypeMarker);
  
  @NotNull
  public abstract TypeArgumentListMarker asArgumentList(@NotNull SimpleTypeMarker paramSimpleTypeMarker);
  
  @Nullable
  public abstract CapturedTypeMarker asCapturedType(@NotNull SimpleTypeMarker paramSimpleTypeMarker);
  
  @Nullable
  public abstract DefinitelyNotNullTypeMarker asDefinitelyNotNullType(@NotNull SimpleTypeMarker paramSimpleTypeMarker);
  
  @Nullable
  public abstract DynamicTypeMarker asDynamicType(@NotNull FlexibleTypeMarker paramFlexibleTypeMarker);
  
  @Nullable
  public abstract FlexibleTypeMarker asFlexibleType(@NotNull KotlinTypeMarker paramKotlinTypeMarker);
  
  @Nullable
  public abstract SimpleTypeMarker asSimpleType(@NotNull KotlinTypeMarker paramKotlinTypeMarker);
  
  @NotNull
  public abstract TypeArgumentMarker asTypeArgument(@NotNull KotlinTypeMarker paramKotlinTypeMarker);
  
  @Nullable
  public abstract SimpleTypeMarker captureFromArguments(@NotNull SimpleTypeMarker paramSimpleTypeMarker, @NotNull CaptureStatus paramCaptureStatus);
  
  @NotNull
  public abstract TypeArgumentMarker get(@NotNull TypeArgumentListMarker paramTypeArgumentListMarker, int paramInt);
  
  @NotNull
  public abstract TypeArgumentMarker getArgument(@NotNull KotlinTypeMarker paramKotlinTypeMarker, int paramInt);
  
  @NotNull
  public abstract TypeParameterMarker getParameter(@NotNull TypeConstructorMarker paramTypeConstructorMarker, int paramInt);
  
  @NotNull
  public abstract KotlinTypeMarker getType(@NotNull TypeArgumentMarker paramTypeArgumentMarker);
  
  @NotNull
  public abstract TypeVariance getVariance(@NotNull TypeArgumentMarker paramTypeArgumentMarker);
  
  @NotNull
  public abstract TypeVariance getVariance(@NotNull TypeParameterMarker paramTypeParameterMarker);
  
  @NotNull
  public abstract KotlinTypeMarker intersectTypes(@NotNull List<? extends KotlinTypeMarker> paramList);
  
  public abstract boolean isAnyConstructor(@NotNull TypeConstructorMarker paramTypeConstructorMarker);
  
  public abstract boolean isClassTypeConstructor(@NotNull TypeConstructorMarker paramTypeConstructorMarker);
  
  public abstract boolean isCommonFinalClassConstructor(@NotNull TypeConstructorMarker paramTypeConstructorMarker);
  
  public abstract boolean isDenotable(@NotNull TypeConstructorMarker paramTypeConstructorMarker);
  
  public abstract boolean isEqualTypeConstructors(@NotNull TypeConstructorMarker paramTypeConstructorMarker1, @NotNull TypeConstructorMarker paramTypeConstructorMarker2);
  
  public abstract boolean isError(@NotNull KotlinTypeMarker paramKotlinTypeMarker);
  
  public abstract boolean isIntegerLiteralTypeConstructor(@NotNull TypeConstructorMarker paramTypeConstructorMarker);
  
  public abstract boolean isIntersection(@NotNull TypeConstructorMarker paramTypeConstructorMarker);
  
  public abstract boolean isMarkedNullable(@NotNull SimpleTypeMarker paramSimpleTypeMarker);
  
  public abstract boolean isNothingConstructor(@NotNull TypeConstructorMarker paramTypeConstructorMarker);
  
  public abstract boolean isNullableType(@NotNull KotlinTypeMarker paramKotlinTypeMarker);
  
  public abstract boolean isPrimitiveType(@NotNull SimpleTypeMarker paramSimpleTypeMarker);
  
  public abstract boolean isSingleClassifierType(@NotNull SimpleTypeMarker paramSimpleTypeMarker);
  
  public abstract boolean isStarProjection(@NotNull TypeArgumentMarker paramTypeArgumentMarker);
  
  public abstract boolean isStubType(@NotNull SimpleTypeMarker paramSimpleTypeMarker);
  
  @NotNull
  public abstract SimpleTypeMarker lowerBound(@NotNull FlexibleTypeMarker paramFlexibleTypeMarker);
  
  @NotNull
  public abstract SimpleTypeMarker lowerBoundIfFlexible(@NotNull KotlinTypeMarker paramKotlinTypeMarker);
  
  @Nullable
  public abstract KotlinTypeMarker lowerType(@NotNull CapturedTypeMarker paramCapturedTypeMarker);
  
  public abstract int parametersCount(@NotNull TypeConstructorMarker paramTypeConstructorMarker);
  
  @NotNull
  public abstract Collection<KotlinTypeMarker> possibleIntegerTypes(@NotNull SimpleTypeMarker paramSimpleTypeMarker);
  
  public abstract int size(@NotNull TypeArgumentListMarker paramTypeArgumentListMarker);
  
  @NotNull
  public abstract Collection<KotlinTypeMarker> supertypes(@NotNull TypeConstructorMarker paramTypeConstructorMarker);
  
  @NotNull
  public abstract TypeConstructorMarker typeConstructor(@NotNull KotlinTypeMarker paramKotlinTypeMarker);
  
  @NotNull
  public abstract TypeConstructorMarker typeConstructor(@NotNull SimpleTypeMarker paramSimpleTypeMarker);
  
  @NotNull
  public abstract SimpleTypeMarker upperBound(@NotNull FlexibleTypeMarker paramFlexibleTypeMarker);
  
  @NotNull
  public abstract SimpleTypeMarker upperBoundIfFlexible(@NotNull KotlinTypeMarker paramKotlinTypeMarker);
  
  @NotNull
  public abstract SimpleTypeMarker withNullability(@NotNull SimpleTypeMarker paramSimpleTypeMarker, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
 * JD-Core Version:    0.7.0.1
 */