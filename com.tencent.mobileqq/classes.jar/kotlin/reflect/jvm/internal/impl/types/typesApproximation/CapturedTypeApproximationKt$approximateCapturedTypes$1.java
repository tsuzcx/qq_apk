package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import org.jetbrains.annotations.NotNull;

final class CapturedTypeApproximationKt$approximateCapturedTypes$1
  extends Lambda
  implements Function1<KotlinType, KotlinType>
{
  CapturedTypeApproximationKt$approximateCapturedTypes$1(KotlinType paramKotlinType)
  {
    super(1);
  }
  
  @NotNull
  public final KotlinType invoke(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$makeNullableIfNeeded");
    paramKotlinType = TypeUtils.makeNullableIfNeeded(paramKotlinType, this.$type.isMarkedNullable());
    Intrinsics.checkExpressionValueIsNotNull(paramKotlinType, "TypeUtils.makeNullableIf…s, type.isMarkedNullable)");
    return paramKotlinType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt.approximateCapturedTypes.1
 * JD-Core Version:    0.7.0.1
 */