package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.HashSet;
import java.util.HashSet<Lkotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;>;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class InlineClassMappingKt
{
  @Nullable
  public static final KotlinTypeMarker computeExpandedTypeForInlineClass(@NotNull TypeSystemCommonBackendContext paramTypeSystemCommonBackendContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeSystemCommonBackendContext, "$this$computeExpandedTypeForInlineClass");
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "inlineClassType");
    return computeExpandedTypeInner(paramTypeSystemCommonBackendContext, paramKotlinTypeMarker, new HashSet());
  }
  
  private static final KotlinTypeMarker computeExpandedTypeInner(@NotNull TypeSystemCommonBackendContext paramTypeSystemCommonBackendContext, KotlinTypeMarker paramKotlinTypeMarker, HashSet<TypeConstructorMarker> paramHashSet)
  {
    Object localObject = paramTypeSystemCommonBackendContext.typeConstructor(paramKotlinTypeMarker);
    if (!paramHashSet.add(localObject)) {
      return null;
    }
    TypeParameterMarker localTypeParameterMarker = paramTypeSystemCommonBackendContext.getTypeParameterClassifier((TypeConstructorMarker)localObject);
    if (localTypeParameterMarker != null)
    {
      localObject = computeExpandedTypeInner(paramTypeSystemCommonBackendContext, paramTypeSystemCommonBackendContext.getRepresentativeUpperBound(localTypeParameterMarker), paramHashSet);
      if (localObject != null)
      {
        paramHashSet = (HashSet<TypeConstructorMarker>)localObject;
        if (!paramTypeSystemCommonBackendContext.isNullableType((KotlinTypeMarker)localObject)) {
          if (!paramTypeSystemCommonBackendContext.isMarkedNullable(paramKotlinTypeMarker)) {
            paramHashSet = (HashSet<TypeConstructorMarker>)localObject;
          } else {
            return paramTypeSystemCommonBackendContext.makeNullable((KotlinTypeMarker)localObject);
          }
        }
      }
      else
      {
        return null;
      }
    }
    else
    {
      if (!paramTypeSystemCommonBackendContext.isInlineClass((TypeConstructorMarker)localObject)) {
        return paramKotlinTypeMarker;
      }
      localObject = paramTypeSystemCommonBackendContext.getSubstitutedUnderlyingType(paramKotlinTypeMarker);
      if (localObject == null) {
        break label174;
      }
      paramHashSet = computeExpandedTypeInner(paramTypeSystemCommonBackendContext, (KotlinTypeMarker)localObject, paramHashSet);
      if (paramHashSet == null) {
        break label174;
      }
      if (paramTypeSystemCommonBackendContext.isNullableType(paramKotlinTypeMarker)) {
        break label132;
      }
    }
    return paramHashSet;
    label132:
    if (paramTypeSystemCommonBackendContext.isNullableType(paramHashSet)) {
      return paramKotlinTypeMarker;
    }
    if (((paramHashSet instanceof SimpleTypeMarker)) && (paramTypeSystemCommonBackendContext.isPrimitiveType((SimpleTypeMarker)paramHashSet))) {
      return paramKotlinTypeMarker;
    }
    return paramTypeSystemCommonBackendContext.makeNullable(paramHashSet);
    label174:
    return null;
    return paramKotlinTypeMarker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.InlineClassMappingKt
 * JD-Core Version:    0.7.0.1
 */