package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;

final class CapturedTypeConstructorKt$createCapturedIfNeeded$1
  extends Lambda
  implements Function0<KotlinType>
{
  CapturedTypeConstructorKt$createCapturedIfNeeded$1(TypeProjection paramTypeProjection)
  {
    super(0);
  }
  
  @NotNull
  public final KotlinType invoke()
  {
    KotlinType localKotlinType = this.$this_createCapturedIfNeeded.getType();
    Intrinsics.checkExpressionValueIsNotNull(localKotlinType, "this@createCapturedIfNeeded.type");
    return localKotlinType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt.createCapturedIfNeeded.1
 * JD-Core Version:    0.7.0.1
 */