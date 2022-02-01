package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeSystemInferenceExtensionContext$DefaultImpls
{
  @Nullable
  public static List<SimpleTypeMarker> fastCorrespondingSupertypes(TypeSystemInferenceExtensionContext paramTypeSystemInferenceExtensionContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker, @NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$fastCorrespondingSupertypes");
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "constructor");
    return TypeSystemContext.DefaultImpls.fastCorrespondingSupertypes((TypeSystemContext)paramTypeSystemInferenceExtensionContext, paramSimpleTypeMarker, paramTypeConstructorMarker);
  }
  
  @NotNull
  public static TypeArgumentMarker get(TypeSystemInferenceExtensionContext paramTypeSystemInferenceExtensionContext, @NotNull TypeArgumentListMarker paramTypeArgumentListMarker, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeArgumentListMarker, "$this$get");
    return TypeSystemContext.DefaultImpls.get((TypeSystemContext)paramTypeSystemInferenceExtensionContext, paramTypeArgumentListMarker, paramInt);
  }
  
  @Nullable
  public static TypeArgumentMarker getArgumentOrNull(TypeSystemInferenceExtensionContext paramTypeSystemInferenceExtensionContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$getArgumentOrNull");
    return TypeSystemContext.DefaultImpls.getArgumentOrNull((TypeSystemContext)paramTypeSystemInferenceExtensionContext, paramSimpleTypeMarker, paramInt);
  }
  
  public static boolean hasFlexibleNullability(TypeSystemInferenceExtensionContext paramTypeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$hasFlexibleNullability");
    return TypeSystemContext.DefaultImpls.hasFlexibleNullability((TypeSystemContext)paramTypeSystemInferenceExtensionContext, paramKotlinTypeMarker);
  }
  
  public static boolean isClassType(TypeSystemInferenceExtensionContext paramTypeSystemInferenceExtensionContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$isClassType");
    return TypeSystemContext.DefaultImpls.isClassType((TypeSystemContext)paramTypeSystemInferenceExtensionContext, paramSimpleTypeMarker);
  }
  
  public static boolean isDefinitelyNotNullType(TypeSystemInferenceExtensionContext paramTypeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$isDefinitelyNotNullType");
    return TypeSystemContext.DefaultImpls.isDefinitelyNotNullType((TypeSystemContext)paramTypeSystemInferenceExtensionContext, paramKotlinTypeMarker);
  }
  
  public static boolean isDynamic(TypeSystemInferenceExtensionContext paramTypeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$isDynamic");
    return TypeSystemContext.DefaultImpls.isDynamic((TypeSystemContext)paramTypeSystemInferenceExtensionContext, paramKotlinTypeMarker);
  }
  
  public static boolean isIntegerLiteralType(TypeSystemInferenceExtensionContext paramTypeSystemInferenceExtensionContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$isIntegerLiteralType");
    return TypeSystemContext.DefaultImpls.isIntegerLiteralType((TypeSystemContext)paramTypeSystemInferenceExtensionContext, paramSimpleTypeMarker);
  }
  
  public static boolean isNothing(TypeSystemInferenceExtensionContext paramTypeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$isNothing");
    return TypeSystemContext.DefaultImpls.isNothing((TypeSystemContext)paramTypeSystemInferenceExtensionContext, paramKotlinTypeMarker);
  }
  
  @NotNull
  public static SimpleTypeMarker lowerBoundIfFlexible(TypeSystemInferenceExtensionContext paramTypeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$lowerBoundIfFlexible");
    return TypeSystemContext.DefaultImpls.lowerBoundIfFlexible((TypeSystemContext)paramTypeSystemInferenceExtensionContext, paramKotlinTypeMarker);
  }
  
  public static int size(TypeSystemInferenceExtensionContext paramTypeSystemInferenceExtensionContext, @NotNull TypeArgumentListMarker paramTypeArgumentListMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeArgumentListMarker, "$this$size");
    return TypeSystemContext.DefaultImpls.size((TypeSystemContext)paramTypeSystemInferenceExtensionContext, paramTypeArgumentListMarker);
  }
  
  @NotNull
  public static TypeConstructorMarker typeConstructor(TypeSystemInferenceExtensionContext paramTypeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$typeConstructor");
    return TypeSystemContext.DefaultImpls.typeConstructor((TypeSystemContext)paramTypeSystemInferenceExtensionContext, paramKotlinTypeMarker);
  }
  
  @NotNull
  public static SimpleTypeMarker upperBoundIfFlexible(TypeSystemInferenceExtensionContext paramTypeSystemInferenceExtensionContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$upperBoundIfFlexible");
    return TypeSystemContext.DefaultImpls.upperBoundIfFlexible((TypeSystemContext)paramTypeSystemInferenceExtensionContext, paramKotlinTypeMarker);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */