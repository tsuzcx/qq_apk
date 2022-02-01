package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SimpleClassicTypeSystemContext
  implements ClassicTypeSystemContext
{
  public static final SimpleClassicTypeSystemContext INSTANCE = new SimpleClassicTypeSystemContext();
  
  public int argumentsCount(@NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$argumentsCount");
    return ClassicTypeSystemContext.DefaultImpls.argumentsCount(this, paramKotlinTypeMarker);
  }
  
  @NotNull
  public TypeArgumentListMarker asArgumentList(@NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$asArgumentList");
    return ClassicTypeSystemContext.DefaultImpls.asArgumentList(this, paramSimpleTypeMarker);
  }
  
  @Nullable
  public CapturedTypeMarker asCapturedType(@NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$asCapturedType");
    return ClassicTypeSystemContext.DefaultImpls.asCapturedType(this, paramSimpleTypeMarker);
  }
  
  @Nullable
  public DefinitelyNotNullTypeMarker asDefinitelyNotNullType(@NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$asDefinitelyNotNullType");
    return ClassicTypeSystemContext.DefaultImpls.asDefinitelyNotNullType(this, paramSimpleTypeMarker);
  }
  
  @Nullable
  public DynamicTypeMarker asDynamicType(@NotNull FlexibleTypeMarker paramFlexibleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramFlexibleTypeMarker, "$this$asDynamicType");
    return ClassicTypeSystemContext.DefaultImpls.asDynamicType(this, paramFlexibleTypeMarker);
  }
  
  @Nullable
  public FlexibleTypeMarker asFlexibleType(@NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$asFlexibleType");
    return ClassicTypeSystemContext.DefaultImpls.asFlexibleType(this, paramKotlinTypeMarker);
  }
  
  @Nullable
  public SimpleTypeMarker asSimpleType(@NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$asSimpleType");
    return ClassicTypeSystemContext.DefaultImpls.asSimpleType(this, paramKotlinTypeMarker);
  }
  
  @NotNull
  public TypeArgumentMarker asTypeArgument(@NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$asTypeArgument");
    return ClassicTypeSystemContext.DefaultImpls.asTypeArgument(this, paramKotlinTypeMarker);
  }
  
  @Nullable
  public SimpleTypeMarker captureFromArguments(@NotNull SimpleTypeMarker paramSimpleTypeMarker, @NotNull CaptureStatus paramCaptureStatus)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "type");
    Intrinsics.checkParameterIsNotNull(paramCaptureStatus, "status");
    return ClassicTypeSystemContext.DefaultImpls.captureFromArguments(this, paramSimpleTypeMarker, paramCaptureStatus);
  }
  
  @NotNull
  public TypeArgumentMarker get(@NotNull TypeArgumentListMarker paramTypeArgumentListMarker, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeArgumentListMarker, "$this$get");
    return ClassicTypeSystemContext.DefaultImpls.get(this, paramTypeArgumentListMarker, paramInt);
  }
  
  @NotNull
  public TypeArgumentMarker getArgument(@NotNull KotlinTypeMarker paramKotlinTypeMarker, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$getArgument");
    return ClassicTypeSystemContext.DefaultImpls.getArgument(this, paramKotlinTypeMarker, paramInt);
  }
  
  @NotNull
  public FqNameUnsafe getClassFqNameUnsafe(@NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$getClassFqNameUnsafe");
    return ClassicTypeSystemContext.DefaultImpls.getClassFqNameUnsafe(this, paramTypeConstructorMarker);
  }
  
  @NotNull
  public TypeParameterMarker getParameter(@NotNull TypeConstructorMarker paramTypeConstructorMarker, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$getParameter");
    return ClassicTypeSystemContext.DefaultImpls.getParameter(this, paramTypeConstructorMarker, paramInt);
  }
  
  @Nullable
  public PrimitiveType getPrimitiveArrayType(@NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$getPrimitiveArrayType");
    return ClassicTypeSystemContext.DefaultImpls.getPrimitiveArrayType(this, paramTypeConstructorMarker);
  }
  
  @Nullable
  public PrimitiveType getPrimitiveType(@NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$getPrimitiveType");
    return ClassicTypeSystemContext.DefaultImpls.getPrimitiveType(this, paramTypeConstructorMarker);
  }
  
  @NotNull
  public KotlinTypeMarker getRepresentativeUpperBound(@NotNull TypeParameterMarker paramTypeParameterMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeParameterMarker, "$this$getRepresentativeUpperBound");
    return ClassicTypeSystemContext.DefaultImpls.getRepresentativeUpperBound(this, paramTypeParameterMarker);
  }
  
  @Nullable
  public KotlinTypeMarker getSubstitutedUnderlyingType(@NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$getSubstitutedUnderlyingType");
    return ClassicTypeSystemContext.DefaultImpls.getSubstitutedUnderlyingType(this, paramKotlinTypeMarker);
  }
  
  @NotNull
  public KotlinTypeMarker getType(@NotNull TypeArgumentMarker paramTypeArgumentMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeArgumentMarker, "$this$getType");
    return ClassicTypeSystemContext.DefaultImpls.getType(this, paramTypeArgumentMarker);
  }
  
  @Nullable
  public TypeParameterMarker getTypeParameterClassifier(@NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$getTypeParameterClassifier");
    return ClassicTypeSystemContext.DefaultImpls.getTypeParameterClassifier(this, paramTypeConstructorMarker);
  }
  
  @NotNull
  public TypeVariance getVariance(@NotNull TypeArgumentMarker paramTypeArgumentMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeArgumentMarker, "$this$getVariance");
    return ClassicTypeSystemContext.DefaultImpls.getVariance(this, paramTypeArgumentMarker);
  }
  
  @NotNull
  public TypeVariance getVariance(@NotNull TypeParameterMarker paramTypeParameterMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeParameterMarker, "$this$getVariance");
    return ClassicTypeSystemContext.DefaultImpls.getVariance(this, paramTypeParameterMarker);
  }
  
  public boolean hasAnnotation(@NotNull KotlinTypeMarker paramKotlinTypeMarker, @NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$hasAnnotation");
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    return ClassicTypeSystemContext.DefaultImpls.hasAnnotation(this, paramKotlinTypeMarker, paramFqName);
  }
  
  public boolean identicalArguments(@NotNull SimpleTypeMarker paramSimpleTypeMarker1, @NotNull SimpleTypeMarker paramSimpleTypeMarker2)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker1, "a");
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker2, "b");
    return ClassicTypeSystemContext.DefaultImpls.identicalArguments(this, paramSimpleTypeMarker1, paramSimpleTypeMarker2);
  }
  
  @NotNull
  public KotlinTypeMarker intersectTypes(@NotNull List<? extends KotlinTypeMarker> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "types");
    return ClassicTypeSystemContext.DefaultImpls.intersectTypes(this, paramList);
  }
  
  public boolean isAnyConstructor(@NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$isAnyConstructor");
    return ClassicTypeSystemContext.DefaultImpls.isAnyConstructor(this, paramTypeConstructorMarker);
  }
  
  public boolean isClassTypeConstructor(@NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$isClassTypeConstructor");
    return ClassicTypeSystemContext.DefaultImpls.isClassTypeConstructor(this, paramTypeConstructorMarker);
  }
  
  public boolean isCommonFinalClassConstructor(@NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$isCommonFinalClassConstructor");
    return ClassicTypeSystemContext.DefaultImpls.isCommonFinalClassConstructor(this, paramTypeConstructorMarker);
  }
  
  public boolean isDenotable(@NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$isDenotable");
    return ClassicTypeSystemContext.DefaultImpls.isDenotable(this, paramTypeConstructorMarker);
  }
  
  public boolean isEqualTypeConstructors(@NotNull TypeConstructorMarker paramTypeConstructorMarker1, @NotNull TypeConstructorMarker paramTypeConstructorMarker2)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker1, "c1");
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker2, "c2");
    return ClassicTypeSystemContext.DefaultImpls.isEqualTypeConstructors(this, paramTypeConstructorMarker1, paramTypeConstructorMarker2);
  }
  
  public boolean isError(@NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$isError");
    return ClassicTypeSystemContext.DefaultImpls.isError(this, paramKotlinTypeMarker);
  }
  
  public boolean isInlineClass(@NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$isInlineClass");
    return ClassicTypeSystemContext.DefaultImpls.isInlineClass(this, paramTypeConstructorMarker);
  }
  
  public boolean isIntegerLiteralTypeConstructor(@NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$isIntegerLiteralTypeConstructor");
    return ClassicTypeSystemContext.DefaultImpls.isIntegerLiteralTypeConstructor(this, paramTypeConstructorMarker);
  }
  
  public boolean isIntersection(@NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$isIntersection");
    return ClassicTypeSystemContext.DefaultImpls.isIntersection(this, paramTypeConstructorMarker);
  }
  
  public boolean isMarkedNullable(@NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$isMarkedNullable");
    return ClassicTypeSystemContext.DefaultImpls.isMarkedNullable(this, paramKotlinTypeMarker);
  }
  
  public boolean isMarkedNullable(@NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$isMarkedNullable");
    return ClassicTypeSystemContext.DefaultImpls.isMarkedNullable(this, paramSimpleTypeMarker);
  }
  
  public boolean isNothingConstructor(@NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$isNothingConstructor");
    return ClassicTypeSystemContext.DefaultImpls.isNothingConstructor(this, paramTypeConstructorMarker);
  }
  
  public boolean isNullableType(@NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$isNullableType");
    return ClassicTypeSystemContext.DefaultImpls.isNullableType(this, paramKotlinTypeMarker);
  }
  
  public boolean isPrimitiveType(@NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$isPrimitiveType");
    return ClassicTypeSystemContext.DefaultImpls.isPrimitiveType(this, paramSimpleTypeMarker);
  }
  
  public boolean isSingleClassifierType(@NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$isSingleClassifierType");
    return ClassicTypeSystemContext.DefaultImpls.isSingleClassifierType(this, paramSimpleTypeMarker);
  }
  
  public boolean isStarProjection(@NotNull TypeArgumentMarker paramTypeArgumentMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeArgumentMarker, "$this$isStarProjection");
    return ClassicTypeSystemContext.DefaultImpls.isStarProjection(this, paramTypeArgumentMarker);
  }
  
  public boolean isStubType(@NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$isStubType");
    return ClassicTypeSystemContext.DefaultImpls.isStubType(this, paramSimpleTypeMarker);
  }
  
  public boolean isUnderKotlinPackage(@NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$isUnderKotlinPackage");
    return ClassicTypeSystemContext.DefaultImpls.isUnderKotlinPackage(this, paramTypeConstructorMarker);
  }
  
  @NotNull
  public SimpleTypeMarker lowerBound(@NotNull FlexibleTypeMarker paramFlexibleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramFlexibleTypeMarker, "$this$lowerBound");
    return ClassicTypeSystemContext.DefaultImpls.lowerBound(this, paramFlexibleTypeMarker);
  }
  
  @NotNull
  public SimpleTypeMarker lowerBoundIfFlexible(@NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$lowerBoundIfFlexible");
    return ClassicTypeSystemContext.DefaultImpls.lowerBoundIfFlexible(this, paramKotlinTypeMarker);
  }
  
  @Nullable
  public KotlinTypeMarker lowerType(@NotNull CapturedTypeMarker paramCapturedTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramCapturedTypeMarker, "$this$lowerType");
    return ClassicTypeSystemContext.DefaultImpls.lowerType(this, paramCapturedTypeMarker);
  }
  
  @NotNull
  public KotlinTypeMarker makeNullable(@NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$makeNullable");
    return ClassicTypeSystemContext.DefaultImpls.makeNullable(this, paramKotlinTypeMarker);
  }
  
  @NotNull
  public AbstractTypeCheckerContext newBaseTypeCheckerContext(boolean paramBoolean1, boolean paramBoolean2)
  {
    return ClassicTypeSystemContext.DefaultImpls.newBaseTypeCheckerContext(this, paramBoolean1, paramBoolean2);
  }
  
  public int parametersCount(@NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$parametersCount");
    return ClassicTypeSystemContext.DefaultImpls.parametersCount(this, paramTypeConstructorMarker);
  }
  
  @NotNull
  public Collection<KotlinTypeMarker> possibleIntegerTypes(@NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$possibleIntegerTypes");
    return ClassicTypeSystemContext.DefaultImpls.possibleIntegerTypes(this, paramSimpleTypeMarker);
  }
  
  public int size(@NotNull TypeArgumentListMarker paramTypeArgumentListMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeArgumentListMarker, "$this$size");
    return ClassicTypeSystemContext.DefaultImpls.size(this, paramTypeArgumentListMarker);
  }
  
  @NotNull
  public Collection<KotlinTypeMarker> supertypes(@NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$supertypes");
    return ClassicTypeSystemContext.DefaultImpls.supertypes(this, paramTypeConstructorMarker);
  }
  
  @NotNull
  public TypeConstructorMarker typeConstructor(@NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$typeConstructor");
    return ClassicTypeSystemContext.DefaultImpls.typeConstructor(this, paramKotlinTypeMarker);
  }
  
  @NotNull
  public TypeConstructorMarker typeConstructor(@NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$typeConstructor");
    return ClassicTypeSystemContext.DefaultImpls.typeConstructor(this, paramSimpleTypeMarker);
  }
  
  @NotNull
  public SimpleTypeMarker upperBound(@NotNull FlexibleTypeMarker paramFlexibleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramFlexibleTypeMarker, "$this$upperBound");
    return ClassicTypeSystemContext.DefaultImpls.upperBound(this, paramFlexibleTypeMarker);
  }
  
  @NotNull
  public SimpleTypeMarker upperBoundIfFlexible(@NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$upperBoundIfFlexible");
    return ClassicTypeSystemContext.DefaultImpls.upperBoundIfFlexible(this, paramKotlinTypeMarker);
  }
  
  @NotNull
  public SimpleTypeMarker withNullability(@NotNull SimpleTypeMarker paramSimpleTypeMarker, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$withNullability");
    return ClassicTypeSystemContext.DefaultImpls.withNullability(this, paramSimpleTypeMarker, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext
 * JD-Core Version:    0.7.0.1
 */