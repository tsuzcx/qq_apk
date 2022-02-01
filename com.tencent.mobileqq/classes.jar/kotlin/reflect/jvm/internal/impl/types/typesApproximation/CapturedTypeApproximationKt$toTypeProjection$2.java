package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

final class CapturedTypeApproximationKt$toTypeProjection$2
  extends Lambda
  implements Function1<Variance, Variance>
{
  CapturedTypeApproximationKt$toTypeProjection$2(TypeArgument paramTypeArgument)
  {
    super(1);
  }
  
  @NotNull
  public final Variance invoke(@NotNull Variance paramVariance)
  {
    Intrinsics.checkParameterIsNotNull(paramVariance, "variance");
    Variance localVariance = paramVariance;
    if (paramVariance == this.$this_toTypeProjection.getTypeParameter().getVariance()) {
      localVariance = Variance.INVARIANT;
    }
    return localVariance;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt.toTypeProjection.2
 * JD-Core Version:    0.7.0.1
 */