package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

final class CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1
  extends Lambda
  implements Function1<UnwrappedType, Boolean>
{
  public static final 1 INSTANCE = new 1();
  
  CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1()
  {
    super(1);
  }
  
  public final boolean invoke(UnwrappedType paramUnwrappedType)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramUnwrappedType, "it");
    return CapturedTypeConstructorKt.isCaptured((KotlinType)paramUnwrappedType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt.approximateCapturedTypesIfNecessary.1
 * JD-Core Version:    0.7.0.1
 */