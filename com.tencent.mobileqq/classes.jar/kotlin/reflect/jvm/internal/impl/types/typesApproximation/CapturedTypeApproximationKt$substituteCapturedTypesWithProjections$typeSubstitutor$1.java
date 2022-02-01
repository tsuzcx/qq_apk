package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CapturedTypeApproximationKt$substituteCapturedTypesWithProjections$typeSubstitutor$1
  extends TypeConstructorSubstitution
{
  @Nullable
  public TypeProjection get(@NotNull TypeConstructor paramTypeConstructor)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructor, "key");
    TypeConstructor localTypeConstructor = paramTypeConstructor;
    if (!(paramTypeConstructor instanceof CapturedTypeConstructor)) {
      localTypeConstructor = null;
    }
    paramTypeConstructor = (CapturedTypeConstructor)localTypeConstructor;
    if (paramTypeConstructor != null)
    {
      if (paramTypeConstructor.getProjection().isStarProjection()) {
        return (TypeProjection)new TypeProjectionImpl(Variance.OUT_VARIANCE, paramTypeConstructor.getProjection().getType());
      }
      return paramTypeConstructor.getProjection();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt.substituteCapturedTypesWithProjections.typeSubstitutor.1
 * JD-Core Version:    0.7.0.1
 */