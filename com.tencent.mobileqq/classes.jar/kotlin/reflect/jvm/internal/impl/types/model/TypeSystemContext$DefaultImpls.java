package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeSystemContext$DefaultImpls
{
  @Nullable
  public static List<SimpleTypeMarker> fastCorrespondingSupertypes(TypeSystemContext paramTypeSystemContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker, @NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$fastCorrespondingSupertypes");
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "constructor");
    return null;
  }
  
  @NotNull
  public static TypeArgumentMarker get(TypeSystemContext paramTypeSystemContext, @NotNull TypeArgumentListMarker paramTypeArgumentListMarker, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeArgumentListMarker, "$this$get");
    if ((paramTypeArgumentListMarker instanceof SimpleTypeMarker)) {
      return paramTypeSystemContext.getArgument((KotlinTypeMarker)paramTypeArgumentListMarker, paramInt);
    }
    if ((paramTypeArgumentListMarker instanceof ArgumentList))
    {
      paramTypeSystemContext = ((ArgumentList)paramTypeArgumentListMarker).get(paramInt);
      Intrinsics.checkExpressionValueIsNotNull(paramTypeSystemContext, "get(index)");
      return (TypeArgumentMarker)paramTypeSystemContext;
    }
    paramTypeSystemContext = new StringBuilder();
    paramTypeSystemContext.append("unknown type argument list type: ");
    paramTypeSystemContext.append(paramTypeArgumentListMarker);
    paramTypeSystemContext.append(", ");
    paramTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeArgumentListMarker.getClass()));
    throw ((Throwable)new IllegalStateException(paramTypeSystemContext.toString().toString()));
  }
  
  @Nullable
  public static TypeArgumentMarker getArgumentOrNull(TypeSystemContext paramTypeSystemContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$getArgumentOrNull");
    paramSimpleTypeMarker = (KotlinTypeMarker)paramSimpleTypeMarker;
    int i = paramTypeSystemContext.argumentsCount(paramSimpleTypeMarker);
    if ((paramInt >= 0) && (i > paramInt)) {
      return paramTypeSystemContext.getArgument(paramSimpleTypeMarker, paramInt);
    }
    return null;
  }
  
  public static boolean hasFlexibleNullability(TypeSystemContext paramTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$hasFlexibleNullability");
    return paramTypeSystemContext.isMarkedNullable(paramTypeSystemContext.lowerBoundIfFlexible(paramKotlinTypeMarker)) != paramTypeSystemContext.isMarkedNullable(paramTypeSystemContext.upperBoundIfFlexible(paramKotlinTypeMarker));
  }
  
  public static boolean identicalArguments(TypeSystemContext paramTypeSystemContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker1, @NotNull SimpleTypeMarker paramSimpleTypeMarker2)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker1, "a");
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker2, "b");
    return TypeSystemOptimizationContext.DefaultImpls.identicalArguments((TypeSystemOptimizationContext)paramTypeSystemContext, paramSimpleTypeMarker1, paramSimpleTypeMarker2);
  }
  
  public static boolean isClassType(TypeSystemContext paramTypeSystemContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$isClassType");
    return paramTypeSystemContext.isClassTypeConstructor(paramTypeSystemContext.typeConstructor(paramSimpleTypeMarker));
  }
  
  public static boolean isDefinitelyNotNullType(TypeSystemContext paramTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$isDefinitelyNotNullType");
    paramKotlinTypeMarker = paramTypeSystemContext.asSimpleType(paramKotlinTypeMarker);
    if (paramKotlinTypeMarker != null) {
      paramTypeSystemContext = paramTypeSystemContext.asDefinitelyNotNullType(paramKotlinTypeMarker);
    } else {
      paramTypeSystemContext = null;
    }
    return paramTypeSystemContext != null;
  }
  
  public static boolean isDynamic(TypeSystemContext paramTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$isDynamic");
    paramKotlinTypeMarker = paramTypeSystemContext.asFlexibleType(paramKotlinTypeMarker);
    if (paramKotlinTypeMarker != null) {
      paramTypeSystemContext = paramTypeSystemContext.asDynamicType(paramKotlinTypeMarker);
    } else {
      paramTypeSystemContext = null;
    }
    return paramTypeSystemContext != null;
  }
  
  public static boolean isIntegerLiteralType(TypeSystemContext paramTypeSystemContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$isIntegerLiteralType");
    return paramTypeSystemContext.isIntegerLiteralTypeConstructor(paramTypeSystemContext.typeConstructor(paramSimpleTypeMarker));
  }
  
  public static boolean isNothing(TypeSystemContext paramTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$isNothing");
    return (paramTypeSystemContext.isNothingConstructor(paramTypeSystemContext.typeConstructor(paramKotlinTypeMarker))) && (!paramTypeSystemContext.isNullableType(paramKotlinTypeMarker));
  }
  
  @NotNull
  public static SimpleTypeMarker lowerBoundIfFlexible(TypeSystemContext paramTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$lowerBoundIfFlexible");
    Object localObject = paramTypeSystemContext.asFlexibleType(paramKotlinTypeMarker);
    if (localObject != null)
    {
      localObject = paramTypeSystemContext.lowerBound((FlexibleTypeMarker)localObject);
      if (localObject != null) {
        return localObject;
      }
    }
    paramTypeSystemContext = paramTypeSystemContext.asSimpleType(paramKotlinTypeMarker);
    if (paramTypeSystemContext == null) {
      Intrinsics.throwNpe();
    }
    return paramTypeSystemContext;
  }
  
  public static int size(TypeSystemContext paramTypeSystemContext, @NotNull TypeArgumentListMarker paramTypeArgumentListMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeArgumentListMarker, "$this$size");
    if ((paramTypeArgumentListMarker instanceof SimpleTypeMarker)) {
      return paramTypeSystemContext.argumentsCount((KotlinTypeMarker)paramTypeArgumentListMarker);
    }
    if ((paramTypeArgumentListMarker instanceof ArgumentList)) {
      return ((ArgumentList)paramTypeArgumentListMarker).size();
    }
    paramTypeSystemContext = new StringBuilder();
    paramTypeSystemContext.append("unknown type argument list type: ");
    paramTypeSystemContext.append(paramTypeArgumentListMarker);
    paramTypeSystemContext.append(", ");
    paramTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeArgumentListMarker.getClass()));
    throw ((Throwable)new IllegalStateException(paramTypeSystemContext.toString().toString()));
  }
  
  @NotNull
  public static TypeConstructorMarker typeConstructor(TypeSystemContext paramTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$typeConstructor");
    SimpleTypeMarker localSimpleTypeMarker = paramTypeSystemContext.asSimpleType(paramKotlinTypeMarker);
    if (localSimpleTypeMarker != null) {
      paramKotlinTypeMarker = localSimpleTypeMarker;
    } else {
      paramKotlinTypeMarker = paramTypeSystemContext.lowerBoundIfFlexible(paramKotlinTypeMarker);
    }
    return paramTypeSystemContext.typeConstructor(paramKotlinTypeMarker);
  }
  
  @NotNull
  public static SimpleTypeMarker upperBoundIfFlexible(TypeSystemContext paramTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$upperBoundIfFlexible");
    Object localObject = paramTypeSystemContext.asFlexibleType(paramKotlinTypeMarker);
    if (localObject != null)
    {
      localObject = paramTypeSystemContext.upperBound((FlexibleTypeMarker)localObject);
      if (localObject != null) {
        return localObject;
      }
    }
    paramTypeSystemContext = paramTypeSystemContext.asSimpleType(paramKotlinTypeMarker);
    if (paramTypeSystemContext == null) {
      Intrinsics.throwNpe();
    }
    return paramTypeSystemContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */